package Controlador;

import Classes.Beans.LibroBean;
import Classes.Beans.SocioBean;
import Classes.Beans.AdministradorBean;
import Modelo.BuscarLibroDAO;
import Utils.CleanupDone;
import Utils.TableHelper;
import Vista.VAsignarSocio;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Descripción: Controlador para Libros.
 *
 */
@CleanupDone
public class BuscarLibroControladorAdmin {

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

    /**
     * Uso: Buscar Socios.
     *
     * Descripción: Crea un nuevo socio bean, ingresa los valores de los text
     * fiels en el bean y consigue la acción dependiendo de los combo box
     * seleccionados. Envia el bean y la acción al dao correspondiente.
     *
     * @param jModel // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     * @param jSelect // Contiene los objetos de selección
     */
    public void actionPerformedJBuscarSocio(DefaultTableModel jModel, Object[] jField, boolean[] jSelect) {
        int action = 0;
        SocioBean Bean = new SocioBean();
        Bean.setNombre(jField[0].toString());
        Bean.setApellidoP(jField[1].toString());
        Bean.setApellidoM(jField[2].toString());
        Bean.setUsuario(jField[3].toString());
        if (jSelect[0] && (!jSelect[1] && !jSelect[2] && !jSelect[3])) {
            action = 1;
        } else if (jSelect[2] && (!jSelect[1] && !jSelect[0] && !jSelect[3])) {
            action = 2;
        } else if (jSelect[1] && (!jSelect[0] && !jSelect[2] && !jSelect[3])) {
            action = 3;
        } else if (jSelect[3] && (!jSelect[0] && !jSelect[2] && !jSelect[1])) {
            action = 4;
        } else if (jSelect[3] && jSelect[0] && (!jSelect[2] && !jSelect[1])) {
            action = 5;
        } else if (jSelect[1] && jSelect[0] && (!jSelect[2] && !jSelect[3])) {
            action = 6;
        } else if (jSelect[2] && jSelect[0] && (!jSelect[3] && !jSelect[1])) {
            action = 7;
        } else if (jSelect[2] && jSelect[1] && (!jSelect[3] && !jSelect[0])) {
            action = 8;
        } else if (jSelect[2] && jSelect[3] && (!jSelect[0] && !jSelect[1])) {
            action = 9;
        } else if (jSelect[3] && jSelect[1] && (!jSelect[0] && !jSelect[2])) {
            action = 10;
        } else if (jSelect[0] && jSelect[2] && jSelect[1] && (!jSelect[3])) {
            action = 11;
        } else if (jSelect[0] && jSelect[2] && jSelect[3] && (!jSelect[1])) {
            action = 12;
        } else if (jSelect[2] && jSelect[1] && jSelect[3] && (!jSelect[0])) {
            action = 13;
        } else if (jSelect[0] && jSelect[1] && jSelect[3] && (!jSelect[2])) {
            action = 14;
        } else if (jSelect[3] && jSelect[1] && jSelect[0] && jSelect[2]) {
            action = 15;
        }
        ADM.BuscarSocio(jModel, Bean, action);
    }

    /**
     * Uso: Pedir Prestamo de Libro.
     *
     * Descripción: Si no hay un libro seleccionado un Texto se muestra en
     * JOptionPane, si hay un libro seleccionado los datos en la tabla se
     * introducen en un array y son enviados junto con el bean del socio a el
     * dao correspondiente.
     *
     * @param Bean // Contiene los datos del Administrador
     * @param jTableBLibro // Contiene el objeto Tabla de Vista
     * @param jTableBSocio // Contiene el objeto Tabla de Vista
     */
    public void actionPerformedJPrestamo(AdministradorBean Bean, JTable jTableBLibro, JTable jTableBSocio) {
        int select = jTableBLibro.getSelectedRow();
        int select0 = jTableBSocio.getSelectedRow();
        SocioBean SocioBean = new SocioBean();
        if (select0 < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla de Socios");
            return;
        } else {
            boolean[] canGet = new boolean[]{true, true, true, true, true, false, false, false, true};
            ArrayList jArray = TABLE_HELPER.getTextFromSelectedTable(jTableBSocio, canGet, 1);
            SocioBean.setIdUsuario(Integer.parseInt(jArray.get(0).toString()));
            SocioBean.setNombre(jArray.get(1).toString());
            SocioBean.setApellidoP(jArray.get(2).toString());
            SocioBean.setApellidoM(jArray.get(3).toString());
            SocioBean.setEstado(jArray.get(4).toString());
            SocioBean.setUsuario(jArray.get(5).toString());
        }
        if (select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla de Libros");
        } else {
            ArrayList Array = new ArrayList();
            Array.add(jTableBLibro.getValueAt(select, 0).toString());
            Array.add(jTableBLibro.getValueAt(select, 2).toString());
            Array.add(jTableBLibro.getValueAt(select, 1).toString());
            Array.add(jTableBLibro.getValueAt(select, 3).toString());
            Array.add(jTableBLibro.getValueAt(select, 5).toString());
            Array.add(jTableBLibro.getValueAt(select, 6).toString());
            VAsignarSocio vas = new VAsignarSocio(SocioBean, Array);
            vas.setLocationRelativeTo(null);
            vas.setVisible(true);
        }
    }

}
