package Controlador;

import Classes.Beans.SocioBean;
import Utils.CleanupDone;
import Vista.VBuscarLibro;
import Vista.VPrestamos;

@CleanupDone
public class OpcionesControladorSocio {

    /**
     * Abre una nueva ventana de Buscar Libros
     *
     * @param Bean // Contiene el Bean Socio
     */
    public void actionPerformedJLibrosOpen(SocioBean Bean) {
        VBuscarLibro vbl = new VBuscarLibro(Bean);
        vbl.setLocationRelativeTo(null);
        vbl.setVisible(true);
    }

    /**
     * Abre una nueva ventana de Ver Prestamos
     *
     * @param Bean // Contiene el Bean Socio
     */
    public void actionPerformedJPrestamosOpen(SocioBean Bean) {
        VPrestamos vp = new VPrestamos(Bean);
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

}
