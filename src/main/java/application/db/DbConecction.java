package application.db;

import java.sql.*;

public class DbConecction {
    Connection connect = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public Connection dbConnection(){
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela", "root", "root");
            //System.out.println("conexion exitosa");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Algo salio mal");
        }
        return connect;
    }
}
