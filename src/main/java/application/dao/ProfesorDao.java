package application.dao;

import application.db.DbConecction;
import application.models.Estudiante;
import application.models.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDao {

    static final DbConecction connect = new DbConecction();

    public static void guardarProfesor(Profesor profesor){
        String query = "INSERT INTO profesores (id, name, lastName, email, password, rol, speciality) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, profesor.getId());
            stmt.setString(2, profesor.getName());
            stmt.setString(3, profesor.getLastName());
            stmt.setString(4, profesor.getEmail());
            stmt.setString(5, profesor.getPassword());
            stmt.setString(6, profesor.getRol());
            stmt.setString(7, profesor.getSpeciality());

            stmt.executeUpdate();
            System.out.println("Profesor guardado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Profesor buscarProfesor(Long id){
        String query = "SELECT * FROM profesores WHERE id = ?";
        Profesor profesor = null;

        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    profesor = new Profesor(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("lastName"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("rol"),
                            rs.getString("speciality")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesor;
    }

    public static List<Profesor> buscarProfesores(){
        String query = "SELECT id, name, lastName, email, speciality FROM profesores";
        List<Profesor>profesores = new ArrayList<>();

        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Profesor profesor = new Profesor();
                profesor.setId(rs.getLong("id"));
                profesor.setName(rs.getString("name"));
                profesor.setLastName(rs.getString("lastName"));
                profesor.setEmail(rs.getString("email"));
                profesor.setSpeciality(rs.getString("speciality"));
                profesores.add(profesor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesores;
    }

    public static void actualizarProfesor(Profesor profesor) {
        String query = "UPDATE profesores SET name = ?, lastName = ?, email = ?, speciality = ? WHERE id = ?";
        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, profesor.getName());
            stmt.setString(2, profesor.getLastName());
            stmt.setString(3, profesor.getEmail());
            stmt.setString(4, profesor.getSpeciality());
            stmt.setLong(5, profesor.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Profesor actualizado correctamente.");
            } else {
                System.out.println("No se encontró el profesor con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarProfesor(Long id) {
        String query = "DELETE FROM profesores WHERE id = ?";
        try (Connection conn = connect.dbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Profesor eliminado correctamente.");
            } else {
                System.out.println("No se encontró el profesor con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
