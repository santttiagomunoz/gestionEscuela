package application.dao;

import application.db.DbConecction;
import application.models.Calificacion;
import application.models.CalificacionEstudiante;
import application.models.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CalificacionDao {

    static final DbConecction dbConecction = new DbConecction();

    public static boolean guardarEvaluacion(Calificacion calificacion){
        String query = "insert into calificacion (id_profesor, id_materia, descripcion) values (?, ?, ?) ";
        try(Connection conn = dbConecction.dbConnection();
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            statement.setLong(1, calificacion.getId_profesor());
            statement.setLong(2, calificacion.getId_materia());
            statement.setString(3, calificacion.getDescripcion());
            int fila = statement.executeUpdate();
            if(fila > 0){
                ResultSet clave = statement.getGeneratedKeys();
                if(clave.next()){
                    calificacion.setId_calificacion(clave.getLong(1));
                }
                else {
                    throw new SQLException("falla en el Resultset");
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean asignarCalificacionEstudiante(CalificacionEstudiante calificacionEstudiante){
        String query = "insert into calificacion_estudiante (id_calificacion, id_estudiante, nota) values (?, ?, ?)";
        try(Connection conn = dbConecction.dbConnection();
        PreparedStatement statement = conn.prepareStatement(query)){
        statement.setLong(1, calificacionEstudiante.getId_calificacion());
        statement.setLong(2, calificacionEstudiante.getId_estudiante());
        statement.setDouble(3, calificacionEstudiante.getNota());
        return statement.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static List<CalificacionEstudiante> obtenerCalificacionEstudiante(Long id_estudiante){
        String query = "select ce.id_calificacion, c.descripcion, ce.nota, e.name " +
                "from calificacion_estudiante ce join calificacion c on ce.id_calificacion = c.id_calificacion " +
                "join estudiantes e on ce.id_estudiante = e.id " +
                "where ce.id_estudiante = ?";
        List<CalificacionEstudiante> calificaciones = new ArrayList<>();
        try(Connection conn = dbConecction.dbConnection();
        PreparedStatement statement = conn.prepareStatement(query)){
            statement.setLong(1, id_estudiante);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                CalificacionEstudiante calificacionEstudiante = new CalificacionEstudiante();
                calificacionEstudiante.setId_calificacion(rs.getLong("id_calificacion"));
                //System.out.println("descripcion: " + rs.getString("descripcion"));
                calificacionEstudiante.setNota(rs.getDouble("nota"));

                Calificacion calificacion = new Calificacion();
                calificacion.setDescripcion(rs.getString("descripcion"));
                calificacionEstudiante.setCalificacion(calificacion);

                Estudiante estudiante = new Estudiante();
                estudiante.setName(rs.getString("name"));
                calificacionEstudiante.setEstudiante(estudiante);

                calificaciones.add(calificacionEstudiante);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return calificaciones;
    }
}
