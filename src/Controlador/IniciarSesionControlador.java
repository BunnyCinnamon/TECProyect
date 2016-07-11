package Controlador;

import Classes.Beans.AdministradorBean;
import Classes.Beans.SocioBean;
import Modelo.IniciarSesionDAO;
import Vista.VOpcionesAdmin;
import Vista.VIniciarSesion;
import Vista.VOpcionesSocio;

public class IniciarSesionControlador {

    public VOpcionesAdmin vo = new VOpcionesAdmin();
    public IniciarSesionDAO isd = new IniciarSesionDAO();

    public void actionPerformed(VIniciarSesion vis) {
        AdministradorBean adm = new AdministradorBean();
        SocioBean s = new SocioBean();
        if (vis.JRecordarUsuario.isSelected()) {
            adm.setUsuario(vis.JUsuarioInicio.getText());
            adm.setContraseña(vis.JContraseñaInicio.getText());
            if (isd.CheckPasswordAdmin(adm)) {
                vis.setVisible(false);
                vo.setLocationRelativeTo(null);
                vo.setVisible(true);
            } else {
                vis.JAnounce.setText("Usuario o Contraseña incorrecto");
            }
        } else {
            s.setUsuario(vis.JUsuarioInicio.getText());
            s.setContraseña(vis.JContraseñaInicio.getText());
            Object[] temp = isd.CheckPasswordSocio(s);
            SocioBean ABean = (SocioBean) temp[0];
            boolean TRUE = (boolean) temp[1];
            if (TRUE) {
                VOpcionesSocio vs = new VOpcionesSocio(ABean);
                vis.setVisible(false);
                vs.setLocationRelativeTo(null);
                vs.setVisible(true);
            } else {
                vis.JAnounce.setText("Usuario o Contraseña incorrecto");
            }
        }
    }
}
