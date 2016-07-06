package Controlador;

import java.awt.event.ActionEvent;
import Classes.Beans.AdministradorBean;
import Vista.VBuscarLibro;
import Vista.VBuscarSocios;
import Vista.VIniciarSesion;
import Vista.VOpciones;
import Vista.VPrestamos;

public class SalirControlador /**
 * implements ActionListener*
 */
{

    VIniciarSesion vis = new VIniciarSesion();
    VOpciones vops = new VOpciones();

//    @Override
    public void actionPerformed(ActionEvent ae) {
        AdministradorBean adb = new AdministradorBean();
        adb.setidAdministrador(666);
        adb.setUsuario("");
        adb.setContraseña("");
        vis.setVisible(true);
        vis.setLocationRelativeTo(null);
    }

    public void actionPerformedReturn(ActionEvent ae) {
        vops.setVisible(true);
        vops.setLocationRelativeTo(null);
    }

    public void actionPerformedVBuscarLibro(ActionEvent ae) {
        VBuscarLibro vbl = new VBuscarLibro();
        vbl.setVisible(true);
        vbl.setLocationRelativeTo(null);
    }

    public void actionPerformedVBuscarSocio(ActionEvent ae) {
        VBuscarSocios vbs = new VBuscarSocios();
        vbs.setVisible(true);
        vbs.setLocationRelativeTo(null);
    }

    public void actionPerformedVPrestamo(ActionEvent ae) {
        VPrestamos vp = new VPrestamos();
        vp.setVisible(true);
        vp.setLocationRelativeTo(null);
    }

}
