package modelo;

import controlador.loginControlador;

public class cliente extends Usuario {

    public cliente(int id, String username, String password, String rol) {
        super(id, username, password, rol);
    }

    public void mostrarMenu(loginControlador controlador) {
        controlador.mostrarPanelCliente(this);
    }
}


