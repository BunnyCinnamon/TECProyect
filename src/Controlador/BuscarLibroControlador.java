package Controlador;

import Classes.Beans.LibroBean;
import Classes.Beans.SocioBean;
import Modelo.BuscarLibroDAO;
import Utils.CleanupDone;
import Vista.VAsignarSocio;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@CleanupDone
public class BuscarLibroControlador {

    BuscarLibroDAO adm = new BuscarLibroDAO();

    /**
     * Buscar Libro. Consigue el id del titulo, isbn, editorial y autor si hay
     * un error envia JOptionPane con texto erroneo y si no un texto exitoso,
     * envia los datos al dao correspondiente
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
            Autor = jField[3].toString();
        } catch (NullPointerException n) {
        }
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
        adm.BuscarLibro(jModel, Bean, Editorial, Autor, action);
    }

    /**
     * Pedir Prestamo de Libro. Si no hay un libro seleccionado un Texto se
     * muestra en JOptionPane, si hay un libro seleccionado los datos en la
     * tabla se introducen en un array y son enviados junto con el bean del
     * socio a el dao correspondiente
     *
     * @param SocioBean // Contiene los datos del Socio
     * @param jTableBLibro // Contiene el objeto Tabla de Vista
     */
    public void actionPerformedJPrestamo(SocioBean SocioBean, JTable jTableBLibro) {
        int Select = jTableBLibro.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else {
            ArrayList Array = new ArrayList();
            Array.add(jTableBLibro.getValueAt(Select, 0).toString());
            Array.add(jTableBLibro.getValueAt(Select, 2).toString());
            Array.add(jTableBLibro.getValueAt(Select, 1).toString());
            Array.add(jTableBLibro.getValueAt(Select, 3).toString());
            Array.add(jTableBLibro.getValueAt(Select, 5).toString());
            Array.add(jTableBLibro.getValueAt(Select, 6).toString());
            VAsignarSocio vas = new VAsignarSocio(SocioBean, Array);
            vas.setLocationRelativeTo(null);
            vas.setVisible(true);
        }
    }

}
