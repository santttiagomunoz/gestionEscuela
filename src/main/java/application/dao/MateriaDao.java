package application.dao;

import application.db.DbConecction;
import application.models.Materia;
import application.models.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriaDao {

    static final DbConecction connect = new DbConecction();

    public static void guardarMateria(Materia materia){
        String query = "INSERT INTO materias (id, name, id_profesor) VALUES (?, ?, ?)";
        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, materia.getId());
            stmt.setString(2, materia.getName());
            stmt.setLong(3, materia.getId_profesor());

            stmt.executeUpdate();
            System.out.println("Materia guardado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Materia buscarMateria(Long id){
        String query = "SELECT * FROM materias WHERE id = ?";
        Materia materia = null;

        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    materia = new Materia(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getLong("id_profesor")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materia;
    }

    public static List<Materia> buscarMaterias(){
        String query = "SELECT id, name, lastName, email, speciality FROM profesores";
        List<Materia>materias = new ArrayList<>();

        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Materia materia = new Materia();
                materia.setId(rs.getLong("id"));
                materia.setName(rs.getString("name"));
                materia.setId_profesor(rs.getLong("id_profesor"));
                materias.add(materia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;
    }

    public static void actualizarMateria(Materia materia) {
        String query = "UPDATE materias SET name = ?, id_profesor = ? WHERE id = ?";
        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, materia.getName());
            stmt.setLong(2, materia.getId_profesor());
            stmt.setLong(3, materia.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Materia actualizado correctamente.");
            } else {
                System.out.println("No se encontró el materia con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarMateria(Long id) {
        String query = "DELETE FROM materias WHERE id = ?";
        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Materia eliminada correctamente.");
            } else {
                System.out.println("No se encontró la materia con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
