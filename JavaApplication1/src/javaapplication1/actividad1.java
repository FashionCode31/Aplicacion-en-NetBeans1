package actividad1;

import controlador.loginControlador;
import modelo.UsuarioDAO;
import vista.loginVista;

public class actividad1 {
    public static void main(String[] args) {
        // Instancia los componentes siguiendo la arquitectura de tu diagrama estructural
        loginVista vista = new loginVista();
        UsuarioDAO dao = new UsuarioDAO();
        
        // El controlador vincula la vista y el acceso a datos
        loginControlador controlador = new loginControlador(vista, dao);
        
        // Hace visible la ventana inicial
        vista.setVisible(true);
    }
}

