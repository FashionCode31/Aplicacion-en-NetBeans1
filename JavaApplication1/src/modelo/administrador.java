package modelo;

import controlador.loginControlador;

public class administrador extends Usuario {

    public administrador(int id, String username, String password, String rol) {
        super(id, username, password, rol); // Invoca a super() tal como indica el diagrama de secuencia (Mensaje 13)
    }

    @Override
    public void mostrarMenu(loginControlador controlador) {
        // Ejecuta la lógica correspondiente a la Fase 4 del diagrama
        controlador.mostrarPanelAdmin(this);
    }
}

