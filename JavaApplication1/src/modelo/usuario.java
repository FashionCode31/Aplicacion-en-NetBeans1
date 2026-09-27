/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author test
 */
import controlador.loginControlador;
        
public abstract class Usuario {
    private String id;
    private String username;
    private String password;
    private String rol;
    
    public Usuario(String id,String username,String password,String rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
    public abstract void MostrarMenu(loginControlador Controlador);

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }
    
}  