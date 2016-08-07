package Controlador;

import Classes.Beans.SocioBean;
import Utils.CleanupDone;
import Vista.VBuscarLibro;
import Vista.VBuscarLibroAdmin;
import Vista.VPrestamos;

/**
 * Descripción: Controlador para Socio
 *
 */
@CleanupDone
public class OpcionesControladorSocio {

    /**
     * Descripción: Abre una nueva ventana de Buscar Libros.
     *
     * Variables:
     *
     * @param Bean // Contiene el Bean Socio
     */
    public void actionPerformedJLibrosOpen(SocioBean Bean) {
        VBuscarLibro vbl = new VBuscarLibro(Bean);
        vbl.setLocationRelativeTo(null);
        vbl.setVisible(true);
    }

    /**
     * Descripción: Abre una nueva ventana de Ver Prestamos.
     *
     * Variables:
     *
     * @param Bean // Contiene el Bean Socio
     */
    public void actionPerformedJPrestamosOpen(SocioBean Bean) {
        VPrestamos vp = new VPrestamos(Bean);
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

}
