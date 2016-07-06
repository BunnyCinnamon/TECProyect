package Controlador;

import Classes.Beans.AdministradorBean;
import Modelo.IniciarSesionDAO;
import Vista.VAdministrador;
import Vista.VBuscarLibro;
import Vista.VBuscarSocios;
import Vista.VOpciones;
import Vista.VPrestamos;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class OpcionesControlador {

    public VAdministrador vad = new VAdministrador();
    public VBuscarLibro vbl = new VBuscarLibro();
    public VBuscarSocios vbs = new VBuscarSocios();
    public VPrestamos vp = new VPrestamos();
    public IniciarSesionDAO isd = new IniciarSesionDAO();

    public void actionPerformedJBibliotecaOpen(VOpciones ops) {
        AdministradorBean adm = new AdministradorBean();
        adm.setUsuario("Admin");
        JPasswordField pf = new JPasswordField(); 
        if (JOptionPane.showConfirmDialog(null, pf, "Ingrese contraseña de Administrador", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
            adm.setContraseña(new String(pf.getPassword()));
            if (isd.CheckPassword(adm)) {
            ops.setVisible(false);
            vad.setVisible(true);
            vad.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(null, "Este Usuario no tiene Acceso");
            }
        }
    }

    public void actionPerformedJLibrosOpen(MouseEvent evt) {
        vbl.setVisible(true);
        vbl.setLocationRelativeTo(null);
    }

    public void actionPerformedJSociosOpen(MouseEvent evt) {
        vbs.setVisible(true);
        vbs.setLocationRelativeTo(null);
    }

    public void actionPerformedJPrestamosOpen(MouseEvent evt) {
        vp.setVisible(true);
        vp.setLocationRelativeTo(null);
    }

}
