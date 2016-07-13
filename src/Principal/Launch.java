package Principal;

import Vista.VIniciarSesion;

public class Launch {

    public static void main(String[] args) {
        VIniciarSesion IniciarSesion = new VIniciarSesion();
        IniciarSesion.setLocationRelativeTo(null);
        IniciarSesion.setVisible(true);
    }
}
