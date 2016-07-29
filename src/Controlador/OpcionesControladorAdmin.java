package Controlador;

import Modelo.IniciarSesionDAO;
import Vista.VAdministrador;
import Vista.VPrestamos;

public class OpcionesControladorAdmin {

    public VAdministrador vad = new VAdministrador();
    public VPrestamos vp = new VPrestamos();
    public IniciarSesionDAO isd = new IniciarSesionDAO();

    /**
     * Abre una nueva ventana de Ver Prestamos
     *
     */
    public void actionPerformedJPrestamosOpen() {
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

    /**
     * Abre una nueva ventana de Administrador
     *
     */
    public void actionPerformedJBibliotecaOpen() {
        vad.setLocationRelativeTo(null);
        vad.setVisible(true);
    }
}
