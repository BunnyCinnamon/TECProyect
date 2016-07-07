package Controlador;

import Modelo.IniciarSesionDAO;
import Vista.VAdministrador;
import Vista.VBuscarLibro;
import Vista.VPrestamos;

public class OpcionesControladorSocio {

    public VAdministrador vad = new VAdministrador();
    public VBuscarLibro vbl = new VBuscarLibro();
    public VPrestamos vp = new VPrestamos();
    public IniciarSesionDAO isd = new IniciarSesionDAO();

    public void actionPerformedJLibrosOpen() {
        vbl.setVisible(true);
        vbl.setLocationRelativeTo(null);
    }

    public void actionPerformedJPrestamosOpen() {
        vp.setVisible(true);
        vp.setLocationRelativeTo(null);
    }

}
