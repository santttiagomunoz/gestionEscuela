package application.dao;

import application.db.DbConecction;
import application.models.Usuario;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class UsuarioDao {

    static final DbConecction connect = new DbConecction();

    /* metodo con herencia indirecta usando claves foraneas
    public Usuario login(String email, String password)throws SQLException {
        String query = "select * from usuarios where email = ? and password = ?";
        try(Connection conn = connect.dbConnection();
        PreparedStatement statement = conn.prepareStatement(query)){

            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRol(rs.getString("rol"));
                return usuario;
            }
            return null;
        }
    }**/

    public Usuario buscarEnTabla(Connection conn, String tabla, String email, String password, String rol) throws Exception {
        String query = "SELECT * FROM " + tabla + " WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRol(rol);
                return usuario;
            }
        }
        return null;
    }
}
