
package Controlador;

import Classes.Beans.AdministradorBean;
import Modelo.OpcionesDAO;
import Vista.VAdministrador;
import Vista.VBuscarLibro;
import Vista.VBuscarSocios;
import Vista.VOpciones;
import Vista.VPrestamos;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class OpcionesControlador {
    
    public VOpciones ops = new VOpciones();
    public VAdministrador vad = new VAdministrador();
    public VBuscarLibro vbl = new VBuscarLibro();
    public VBuscarSocios vbs = new VBuscarSocios();
    public VPrestamos vp = new VPrestamos();
    public OpcionesDAO adm = new OpcionesDAO();
    
    public void actionPerformedJBibliotecaOpen(MouseEvent evt) {
        AdministradorBean adb = new AdministradorBean();
        if(adm.CheckAdmin(adb)){
        ops.setVisible(false);
        vad.setVisible(true);
        vad.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(null, "Este Usuario no tiene Acceso");
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
