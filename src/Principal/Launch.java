package Principal;

import Vista.VIniciarSesion;

public class Launch {

    public static void main(String[] args) {
        VIniciarSesion IniciarSesion = new VIniciarSesion();
        IniciarSesion.setVisible(true);
        IniciarSesion.setLocationRelativeTo(null);
    }
}
