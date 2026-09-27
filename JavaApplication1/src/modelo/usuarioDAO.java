package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private DBConection DBconection = new DBconection();

    public Usuario autenticar(String username, String password) {
        Connection con = DBconection.getConexion(); // Mensaje 8 y 9: getConexion
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?"; // Mensaje 10: SELECT
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) { // Mensaje 11: ResultSet
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String user = rs.getString("username");
                    String pass = rs.getString("password");
                    String rol = rs.getString("rol");
                    
                    // Fábrica Polimórfica (Fase 3: Respuesta y Polimorfismo)
                    if (rol.equalsIgnoreCase("Administrador")) {
                        return new administrador(id, user, pass, rol); // Mensaje 12 y 13
                    } else if (rol.equalsIgnoreCase("Cliente")) {
                        return new cliente(id, user, pass, rol);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la autenticación: " + e.getMessage());
        }
        return null;
    }
}
