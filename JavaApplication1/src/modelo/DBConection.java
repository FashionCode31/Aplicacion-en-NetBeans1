package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConection {
    
    private static final String URL = "jdbc:mysql://Localhost:3306/sistema_login";
    private static final String USER ="root";
    private static final String PASSWORD ="Root2026";
    private static Connection conexion = null;
    
    public static Connection getConexion(){
        
    if (conexion==null){
        
    }
        try {
            conexion=DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar" + e.getMessage());
        }
        return conexion;
}
}
