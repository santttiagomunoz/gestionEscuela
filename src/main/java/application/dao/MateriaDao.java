package application.dao;

import application.db.DbConecction;
import application.models.Materia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MateriaDao {

    static final DbConecction connect = new DbConecction();

    public static void guardarMateria(Materia materia){
        String query = "INSERT INTO materiaes (id, name) VALUES (?, ?)";
        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, materia.getId());
            stmt.setString(2, materia.getName());

            stmt.executeUpdate();
            System.out.println("Materia guardado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Materia buscarMateria(Long id){
        String query = "SELECT * FROM materiaes WHERE id = ?";
        Materia materia = null;

        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    materia = new Materia(
                            rs.getLong("id"),
                            rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materia;
    }

    public static void actualizarMateria(Materia materia) {
        String query = "UPDATE materias SET name = ?, lastName = ? WHERE id = ?";
        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, materia.getName());
            stmt.setLong(2, materia.getId());

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
