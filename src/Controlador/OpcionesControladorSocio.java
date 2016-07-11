package Controlador;

import Classes.Beans.SocioBean;
import Modelo.IniciarSesionDAO;
import Vista.VAdministrador;
import Vista.VBuscarLibro;
import Vista.VPrestamos;

public class OpcionesControladorSocio {

    public VAdministrador vad = new VAdministrador();
    public IniciarSesionDAO isd = new IniciarSesionDAO();

    public void actionPerformedJLibrosOpen(SocioBean Bean) {
        VBuscarLibro vbl = new VBuscarLibro(Bean);
        vbl.setLocationRelativeTo(null);
        vbl.setVisible(true);
    }

    public void actionPerformedJPrestamosOpen(SocioBean Bean) {
        VPrestamos vp = new VPrestamos(Bean);
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

}
