package Controlador;

import Utils.CleanupDone;
import Vista.VIniciarSesion;

@CleanupDone
public class SalirControlador {

    /**
     * Abre una nueva ventana de Iniciar Sesión
     *
     */
    public void actionPerformed() {
        VIniciarSesion IniciarSesion = new VIniciarSesion();
        IniciarSesion.setLocationRelativeTo(null);
        IniciarSesion.setVisible(true);
    }
}
