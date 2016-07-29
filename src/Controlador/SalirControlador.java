package Controlador;

import Vista.VIniciarSesion;

public class SalirControlador {

    VIniciarSesion vis = new VIniciarSesion();

    /**
     * Abre una nueva ventana de Iniciar Sesión
     *
     */
    public void actionPerformed() {
        vis.setLocationRelativeTo(null);
        vis.setVisible(true);
    }
}
