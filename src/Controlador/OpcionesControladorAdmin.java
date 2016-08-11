package Controlador;

import Classes.Beans.AdministradorBean;
import Utils.CleanupDone;
import Vista.VAdministrador;
import Vista.VBuscarLibroAdmin;
import Vista.VPrestamos;

/**
 * Descripción: Controlador para Administrador
 *
 */
@CleanupDone
public class OpcionesControladorAdmin {

    /**
     * Descripción: Abre una nueva ventana de Ver Prestamos.
     *
     */
    public void actionPerformedJPrestamosOpen() {
        VPrestamos vp = new VPrestamos();
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

    /**
     * Descripción: Abre una nueva ventana de Buscar Libros.
     *
     * @param Bean // Contiene el Bean Socio
     */
    public void actionPerformedJLibrosOpen(AdministradorBean Bean) {
        VBuscarLibroAdmin vbl = new VBuscarLibroAdmin(Bean);
        vbl.setLocationRelativeTo(null);
        vbl.setVisible(true);
    }

    /**
     * Descripción: Abre una nueva ventana de Administrador.
     *
     */
    public void actionPerformedJBibliotecaOpen() {
        VAdministrador vad = new VAdministrador();
        vad.setLocationRelativeTo(null);
        vad.setVisible(true);
    }
}
