package Controlador;

import java.awt.event.ActionEvent;
import Vista.VIniciarSesion;

public class SalirControlador {

    VIniciarSesion vis = new VIniciarSesion();

    public void actionPerformed(ActionEvent ae) {
        vis.setLocationRelativeTo(null);
        vis.setVisible(true);
    }
}
