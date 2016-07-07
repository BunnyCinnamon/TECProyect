package Controlador;

import Modelo.IniciarSesionDAO;
import Vista.VAdministrador;
import Vista.VBuscarLibro;
import Vista.VOpcionesAdmin;
import Vista.VPrestamos;

public class OpcionesControladorAdmin {

    public VAdministrador vad = new VAdministrador();
    public VBuscarLibro vbl = new VBuscarLibro();
    public VPrestamos vp = new VPrestamos();
    public IniciarSesionDAO isd = new IniciarSesionDAO();

    public void actionPerformedJPrestamosOpen() {
        vp.setVisible(true);
        vp.setLocationRelativeTo(null);
    }
    
    public void actionPerformedJBibliotecaOpen() {
            vad.setVisible(true);
            vad.setLocationRelativeTo(null);
    }
}
