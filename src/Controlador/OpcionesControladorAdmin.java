package Controlador;

import Modelo.IniciarSesionDAO;
import Utils.CleanupDone;
import Vista.VAdministrador;
import Vista.VPrestamos;

@CleanupDone
public class OpcionesControladorAdmin {

    public IniciarSesionDAO isd = new IniciarSesionDAO();

    /**
     * Abre una nueva ventana de Ver Prestamos
     *
     */
    public void actionPerformedJPrestamosOpen() {
        VPrestamos vp = new VPrestamos();
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

    /**
     * Abre una nueva ventana de Administrador
     *
     */
    public void actionPerformedJBibliotecaOpen() {
        VAdministrador vad = new VAdministrador();
        vad.setLocationRelativeTo(null);
        vad.setVisible(true);
    }
}
