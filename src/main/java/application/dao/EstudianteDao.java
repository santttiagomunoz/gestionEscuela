package application.dao;

import application.db.DbConecction;
import application.models.Estudiante;
import application.models.Materia;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao {

    static final DbConecction connect = new DbConecction();

    public static void guardarEstudiante(Estudiante estudiante){
        String query = "INSERT INTO estudiantes (id, name, lastName, email, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, estudiante.getId());
            stmt.setString(2, estudiante.getName());
            stmt.setString(3, estudiante.getLastName());
            stmt.setString(4, estudiante.getEmail());
            stmt.setString(5, estudiante.getPassword());

            stmt.executeUpdate();
            System.out.println("Estudiante guardado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Estudiante buscarEstudiante(Long id){
        String query = "SELECT * FROM estudiantes WHERE id = ?";
        Estudiante estudiante = null;

        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    estudiante = new Estudiante(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("lastName"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("rol")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiante;
    }

    public static List<Estudiante> buscarEstudiantes(){
        String query = "SELECT id, name, lastName, email FROM estudiantes";
        List<Estudiante>estudiantes = new ArrayList<>();

        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getLong("id"));
                estudiante.setName(rs.getString("name"));
                estudiante.setLastName(rs.getString("lastName"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }

    public static void actualizarEstudiante(Estudiante estudiante) {
        String query = "UPDATE estudiantes SET name = ?, lastName = ? WHERE id = ?";
        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, estudiante.getName());
            stmt.setString(2, estudiante.getLastName());
            stmt.setLong(3, estudiante.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Estudiante actualizado correctamente.");
            } else {
                System.out.println("No se encontró el estudiante con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarEstudiante(Long id) {
        String query = "DELETE FROM estudiantes WHERE id = ?";
        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Estudiante eliminado correctamente.");
            } else {
                System.out.println("No se encontró el estudiante con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
