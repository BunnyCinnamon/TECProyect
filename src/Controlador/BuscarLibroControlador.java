package Controlador;

import Classes.Beans.LibroBean;
import Classes.Beans.SocioBean;
import Modelo.BuscarLibroDAO;
import Utils.CleanupDone;
import Vista.VAsignarSocio;
import Vista.VBuscarLibro;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

@CleanupDone
public class BuscarLibroControlador {

    BuscarLibroDAO adm = new BuscarLibroDAO();

    /**
     * Buscar Libro. Crea un nuevo libro bean e introduce los datos a buscar,
     * dependiendo de los check box seleccionados da una acción a la variable
     * action, finalmente envia los datos al dao correspondiente
     *
     * @param ae // Contiene el objeto Tabla de la Vista
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJBuscarLibro(DefaultTableModel ae, VBuscarLibro va) {
        int action = 0;
        LibroBean Bean = new LibroBean();
        Bean.setTitulo(va.JTituloText.getText());
        Bean.setIsbn(va.JISBNText.getText());
        String Editorial = (va.JListEditorial.getSelectedValue());
        String Autor = (va.JListAutor.getSelectedValue());
        if (va.JCheckTitulo.isSelected() && (!va.JCheckAutor.isSelected() && !va.JCheckISBN.isSelected() && !va.JCheckEditorial.isSelected())) {
            action = 1;
        } else if (va.JCheckISBN.isSelected() && (!va.JCheckAutor.isSelected() && !va.JCheckTitulo.isSelected() && !va.JCheckEditorial.isSelected())) {
            action = 2;
        } else if (va.JCheckAutor.isSelected() && (!va.JCheckTitulo.isSelected() && !va.JCheckISBN.isSelected() && !va.JCheckEditorial.isSelected())) {
            action = 3;
        } else if (va.JCheckEditorial.isSelected() && (!va.JCheckTitulo.isSelected() && !va.JCheckISBN.isSelected() && !va.JCheckAutor.isSelected())) {
            action = 4;
        } else if (va.JCheckEditorial.isSelected() && va.JCheckTitulo.isSelected() && (!va.JCheckISBN.isSelected() && !va.JCheckAutor.isSelected())) {
            action = 5;
        } else if (va.JCheckAutor.isSelected() && va.JCheckTitulo.isSelected() && (!va.JCheckISBN.isSelected() && !va.JCheckEditorial.isSelected())) {
            action = 6;
        } else if (va.JCheckISBN.isSelected() && va.JCheckTitulo.isSelected() && (!va.JCheckEditorial.isSelected() && !va.JCheckAutor.isSelected())) {
            action = 7;
        } else if (va.JCheckISBN.isSelected() && va.JCheckAutor.isSelected() && (!va.JCheckEditorial.isSelected() && !va.JCheckTitulo.isSelected())) {
            action = 8;
        } else if (va.JCheckISBN.isSelected() && va.JCheckEditorial.isSelected() && (!va.JCheckTitulo.isSelected() && !va.JCheckAutor.isSelected())) {
            action = 9;
        } else if (va.JCheckEditorial.isSelected() && va.JCheckAutor.isSelected() && (!va.JCheckTitulo.isSelected() && !va.JCheckISBN.isSelected())) {
            action = 10;
        } else if (va.JCheckTitulo.isSelected() && va.JCheckISBN.isSelected() && va.JCheckAutor.isSelected() && (!va.JCheckEditorial.isSelected())) {
            action = 11;
        } else if (va.JCheckTitulo.isSelected() && va.JCheckISBN.isSelected() && va.JCheckEditorial.isSelected() && (!va.JCheckAutor.isSelected())) {
            action = 12;
        } else if (va.JCheckISBN.isSelected() && va.JCheckAutor.isSelected() && va.JCheckEditorial.isSelected() && (!va.JCheckTitulo.isSelected())) {
            action = 13;
        } else if (va.JCheckTitulo.isSelected() && va.JCheckAutor.isSelected() && va.JCheckEditorial.isSelected() && (!va.JCheckISBN.isSelected())) {
            action = 14;
        } else if (va.JCheckEditorial.isSelected() && va.JCheckAutor.isSelected() && va.JCheckTitulo.isSelected() && va.JCheckISBN.isSelected()) {
            action = 15;
        }
        adm.BuscarLibro(ae, Bean, Editorial, Autor, action);
    }

    /**
     * Pedir Prestamo de Libro. Si no hay un libro seleccionado un Texto se
     * muestra en JOptionPane, si hay un libro seleccionado los datos en la
     * tabla se introducen en un array y son enviados junto con el bean del
     * socio a el dao correspondiente
     *
     * @param SocioBean // Contiene los datos del Socio
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJPrestamo(SocioBean SocioBean, VBuscarLibro va) {
        int Select = va.JTableBLibro.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else {
            ArrayList Array = new ArrayList();
            Array.add(va.JTableBLibro.getValueAt(Select, 0).toString());
            Array.add(va.JTableBLibro.getValueAt(Select, 2).toString());
            Array.add(va.JTableBLibro.getValueAt(Select, 1).toString());
            Array.add(va.JTableBLibro.getValueAt(Select, 3).toString());
            Array.add(va.JTableBLibro.getValueAt(Select, 5).toString());
            Array.add(va.JTableBLibro.getValueAt(Select, 6).toString());
            VAsignarSocio vas = new VAsignarSocio(SocioBean, Array);
            vas.setLocationRelativeTo(null);
            vas.setVisible(true);
        }
    }

}
