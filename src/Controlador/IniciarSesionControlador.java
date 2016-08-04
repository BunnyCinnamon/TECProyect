package Controlador;

import Classes.Beans.AdministradorBean;
import Classes.Beans.SocioBean;
import Modelo.IniciarSesionDAO;
import Utils.CleanupDone;
import Vista.VOpcionesAdmin;
import Vista.VIniciarSesion;
import Vista.VOpcionesSocio;

@CleanupDone
public class IniciarSesionControlador {

    public IniciarSesionDAO isd = new IniciarSesionDAO();

    /**
     * Abre una nueva ventana de Opciones. Si el checkbox está activado ingresa
     * como administrador, si no lo está ingresa como socio.
     *
     * @param vis // Contiene el objeto Vista
     */
    public void actionPerformed(VIniciarSesion vis) {
        if (vis.JUsuario.isSelected()) {
            AdministradorBean adm = new AdministradorBean();
            adm.setUsuario(vis.JUsuarioInicio.getText());
            adm.setContraseña(vis.JContraseñaInicio.getText());
            if (isd.CheckPasswordAdmin(adm)) {
                VOpcionesAdmin vo = new VOpcionesAdmin();
                vis.dispose();
                vo.setLocationRelativeTo(null);
                vo.setVisible(true);
            } else {
                vis.JAnounce.setText("Usuario o Contraseña incorrecto");
            }
        } else {
            SocioBean s = new SocioBean();
            s.setUsuario(vis.JUsuarioInicio.getText());
            s.setContraseña(vis.JContraseñaInicio.getText());
            Object[] temp = isd.CheckPasswordSocio(s);
            SocioBean ABean = (SocioBean) temp[0];
            boolean TRUE = (boolean) temp[1];
            if (TRUE) {
                VOpcionesSocio vs = new VOpcionesSocio(ABean);
                vis.dispose();
                vs.setLocationRelativeTo(null);
                vs.setVisible(true);
            } else {
                vis.JAnounce.setText("Usuario o Contraseña incorrecto");
            }
        }
    }
}
