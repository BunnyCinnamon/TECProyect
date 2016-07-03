
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Classes.Beans.AdministradorBean;
import Vista.VIniciarSesion;

public class SalirControlador implements ActionListener{

    VIniciarSesion vis = new VIniciarSesion();
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        AdministradorBean adb = new AdministradorBean();
        adb.setUsuario("");
        adb.setContraseña("");
        vis.setVisible(true);
    }
    
}
