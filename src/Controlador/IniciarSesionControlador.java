package Controlador;

import Classes.Beans.AdministradorBean;
import Classes.Beans.SocioBean;
import Modelo.IniciarSesionDAO;
import Utils.CleanupDone;
import Vista.VOpcionesAdmin;
import Vista.VIniciarSesion;
import Vista.VOpcionesSocio;

/**
 * Descripción: Controlador para Iniciar Sesión
 *
 */
@CleanupDone
public class IniciarSesionControlador {

    private static final IniciarSesionDAO ISD = new IniciarSesionDAO();

    /**
     * Uso: Abre una nueva ventana de Opciones.
     *
     * Descripción: Si el checkbox está activado ingresa como administrador, si
     * no lo está ingresa como socio.
     *
     * Variables:
     *
     * @param vis // Contiene el objeto Vista
     */
    public void actionPerformed(VIniciarSesion vis) {
        if (vis.JUsuario.isSelected()) {
            AdministradorBean adm = new AdministradorBean();
            adm.setUsuario(vis.JUsuarioInicio.getText());
            char[] secretPass = vis.JContraseñaInicio.getText().toCharArray();
            if (ISD.CheckPasswordAdmin(adm, secretPass)) {
                VOpcionesAdmin vo = new VOpcionesAdmin(adm);
                vis.dispose();
                vo.setLocationRelativeTo(null);
                vo.setVisible(true);
            } else {
                vis.JAnounce.setText("Usuario o Contraseña incorrecto");
            }
        } else {
            SocioBean s = new SocioBean();
            s.setUsuario(vis.JUsuarioInicio.getText());
            char[] secretPass = vis.JContraseñaInicio.getText().toCharArray();
            Object[] temp = ISD.CheckPasswordSocio(s, secretPass);
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
