package Controlador;

import Classes.Beans.AdministradorBean;
import Classes.Beans.SocioBean;
import Modelo.IniciarSesionDAO;
import Vista.VOpcionesAdmin;
import Vista.VIniciarSesion;
import Vista.VOpcionesSocio;

public class IniciarSesionControlador {

    public VOpcionesAdmin vo = new VOpcionesAdmin();
    public VOpcionesSocio vs = new VOpcionesSocio();
    public IniciarSesionDAO isd = new IniciarSesionDAO();

    public void actionPerformed(VIniciarSesion vis) {
        AdministradorBean adm = new AdministradorBean();
        SocioBean s = new SocioBean();
        if (vis.JRecordarUsuario.isSelected()) {
            adm.setUsuario(vis.JUsuarioInicio.getText());
            adm.setContraseña(vis.JContraseñaInicio.getText());
            if (isd.CheckPasswordAdmin(adm)) {
                vis.setVisible(false);
                vo.setVisible(true);
                vo.setLocationRelativeTo(null);
            } else {
                vis.JAnounce.setText("Usuario o Contraseña incorrecto");
            }
        } else {
            s.setUsuario(vis.JUsuarioInicio.getText());
            s.setContraseña(vis.JContraseñaInicio.getText());
            if (isd.CheckPasswordSocio(s)) {
            vis.setVisible(false);
            vs.setVisible(true);
            vs.setLocationRelativeTo(null);
        } else {
            vis.JAnounce.setText("Usuario o Contraseña incorrecto");
            }
        }
    }
}
