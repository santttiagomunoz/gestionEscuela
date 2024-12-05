package application.services;

import application.dao.UsuarioDao;
import application.db.DbConecction;
import application.models.Usuario;

import java.sql.Connection;

public class LoginService {

    private final UsuarioDao usuarioDao = new UsuarioDao();
    private final DbConecction dbConecction = new DbConecction();
    /*public Usuario autenticar(String email, String password){
        try{
            return usuarioDao.login(email, password);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }**/

    public Usuario autenticar(String email, String password){
        try (Connection conn = dbConecction.dbConnection()) {
            // Buscar en tabla estudiantes
            Usuario usuario = usuarioDao.buscarEnTabla(conn, "estudiantes", email, password, "estudiante");
            if (usuario != null) return usuario;

            // Buscar en tabla profesores
            usuario = usuarioDao.buscarEnTabla(conn, "profesores", email, password, "profesor");
            if (usuario != null) return usuario;

            // Buscar en tabla administradores
            return usuarioDao.buscarEnTabla(conn, "administradores", email, password, "administrador");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
