package Controlador;

import Classes.Beans.LibroBean;
import Modelo.BuscarLibroDAO;
import Utils.CleanupDone;
import Utils.TableHelper;
import javax.swing.table.DefaultTableModel;

/**
 * Descripción: Controlador para Libros.
 *
 */
@CleanupDone
public class BuscarLibroControlador {

    private static final BuscarLibroDAO ADM = new BuscarLibroDAO();
    public final TableHelper TABLE_HELPER = new TableHelper();

    /**
     * Uso: Buscar Libro.
     *
     * Descripción: Consigue el id del titulo, isbn, editorial y autor si hay un
     * error envia JOptionPane con texto erroneo y si no un texto exitoso, envia
     * los datos al dao correspondiente.
     *
     * @param jModel // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     * @param jSelect // Contiene los objetos de selección
     */
    public void actionPerformedJBuscarLibro(DefaultTableModel jModel, Object[] jField, boolean[] jSelect) {
        int action = 0;
        LibroBean Bean = new LibroBean();
        Bean.setTitulo(jField[0].toString());
        Bean.setIsbn(jField[1].toString());
        String Editorial = "";
        String Autor = "";
        try {
            Editorial = jField[2].toString();
        } catch (NullPointerException n) {
        }
        try {
            Autor = jField[3].toString();
        } catch (NullPointerException n) {
        }
        boolean T = jSelect[0];
        boolean A = jSelect[1];
        boolean I = jSelect[2];
        boolean E = jSelect[3];
        if (T && (!A && !I && !E)) {
            action = 1;
        } else if (I && (!A && !T && !E)) {
            action = 2;
        } else if (A && (!T && !I && !E)) {
            action = 3;
        } else if (E && (!T && !I && !A)) {
            action = 4;
        } else if (E && T && (!I && !A)) {
            action = 5;
        } else if (A && T && (!I && !E)) {
            action = 6;
        } else if (I && T && (!E && !A)) {
            action = 7;
        } else if (I && A && (!E && !T)) {
            action = 8;
        } else if (I && E && (!T && !A)) {
            action = 9;
        } else if (E && A && (!T && !I)) {
            action = 10;
        } else if (T && I && A && (!E)) {
            action = 11;
        } else if (T && I && E && (!A)) {
            action = 12;
        } else if (I && A && E && (!T)) {
            action = 13;
        } else if (T && A && E && (!I)) {
            action = 14;
        } else if (E && A && T && I) {
            action = 15;
        }
        ADM.BuscarLibro(jModel, Bean, Editorial, Autor, action);
    }
}
