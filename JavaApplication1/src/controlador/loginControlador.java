package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import vista.*;

public class loginControlador {
    private loginVista vista;
    private UsuarioDAO dao;

    public loginControlador(loginVista vista, UsuarioDAO dao) {
        this.vista = vista;
        this.dao = dao;
        conectarEventos();
    }

    public void conectarEventos() {
        this.vista.listenBtnIngresar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Mensaje 2
                procesarLogin();
            }
        });
    }

    public void procesarLogin() {
        // FASE 1: Captura de Datos
        String user = vista.getUsuario();  // Mensajes 3 y 4
        String pass = vista.getPassword(); // Mensajes 5 y 6

        // FASE 2: Consulta y Validación
        Usuario usuarioLogueado = dao.autenticar(user, pass); // Mensaje 7

        // FASE 3 y 4: Respuesta, Polimorfismo y Cambio de pantallas
        if (usuarioLogueado != null) {
            vista.mostrarMensajeExito(usuarioLogueado.getUsername()); // Mensaje 16 y 17
            vista.setVisible(false); // Mensaje 18
            
            // Llamada polimórfica dinámica basada en el objeto devuelto por el DAO
            usuarioLogueado.mostrarMenu(this); // Mensaje 19
        } else {
            vista.mostrarMensajeError("Credenciales Inválidas");
        }
    }

    // Ejecutado desde Administrador.java si el rol coincide
    public void mostrarPanelAdmin(administrador admin) {
        MenuAdminVista menuAdmin = new MenuAdminVista(); // Mensaje 20 y 21
        menuAdmin.setVisible(true); // Mensaje 23
        System.out.println("Mostrar Panel Admin ejecutado con éxito."); // Mensaje 24
    }

    // Ejecutado desde Cliente.java si el rol coincide
    public void mostrarPanelCliente(cliente cliente) {
        MenuClienteVista menuCliente = new MenuClienteVista();
        menuCliente.setVisible(true);
    }

    // FASE 5: Cierre de Sesión (Mensaje 27)
    public void regresarALogin() {
        loginVista nuevaVista = new loginVista(); // Mensaje 28
        this.vista = nuevaVista;
        conectarEventos(); // Mensaje 29: conectarEventos
        this.vista.setVisible(true); // Mensaje 30
    }
}
