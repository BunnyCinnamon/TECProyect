package Controlador;

import Classes.Beans.LibroBean;
import Modelo.AdministradorDAO;
import Vista.VAdministrador;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class AdministradorControlador {

    public AdministradorDAO adm = new AdministradorDAO();

    /**
     * Ingresar Libro
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJIngresarLibro(DefaultTableModel ae, VAdministrador va) {
        LibroBean Bean = new LibroBean();
        Bean.setIsbn(va.JISBNText.getText());
        Bean.setTitulo(va.JTituloText.getText());
        Bean.setPaginas(Integer.parseInt(va.JSpinnerNPag.getValue().toString()));
        Bean.setEstatus(va.JEstadoLibro.getSelectedItem().toString());
        Bean.setAutor(va.JListAutor.getSelectedIndex());
        Bean.setNumeroPrestamos(0);
        Bean.setEditorial(va.JListEditorial.getSelectedIndex());
        Bean.setArea(va.JAreaLibro.getSelectedIndex());
        Bean.setLocalizacion(va.JLocalizacionLibro.getSelectedIndex());
        System.out.println(Bean.getIsbn() + Bean.getTitulo() + Bean.getPaginas() + Bean.getEstatus() + Bean.getNumeroPrestamos() + Bean.getEditorial() + Bean.getArea() + Bean.getLocalizacion());
//        ae.addRow(new Object[]{Bean.getIdLibro(), Bean.getIsbn(), Bean.getTitulo(), Bean.getPaginas(), Bean.getEstatus(), va.JListAutor.getSelectedValue(), va.JListEditorial.getSelectedValue(), va.JAreaLibro.getSelectedItem().toString(), va.JLocalizacionLibro.getSelectedItem().toString(), va.JSpinnerCantidad.getValue().toString()});
        if (adm.IngresarLibro(ae, Bean)) {
            ae.addRow(new Object[]{Bean.getIdLibro(), Bean.getIsbn(), Bean.getTitulo(), Bean.getPaginas(), Bean.getEstatus(), va.JListAutor.getSelectedValue(), va.JListEditorial.getSelectedValue(), va.JAreaLibro.getSelectedItem().toString(), va.JLocalizacionLibro.getSelectedItem().toString(), va.JSpinnerCantidad.getValue().toString()});
            JOptionPane.showMessageDialog(null, "El Libro ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el Libro", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modificar Libro
     *
     *
     * @param va
     */
    public void actionPerformedJModificarLibro(VAdministrador va) {
        LibroBean Bean = new LibroBean();
        int Select = va.JTableRLibro.getSelectedRow();
        Bean.setIdLibro(Select);
        Bean.setIsbn(va.JISBNText.getText());
        Bean.setTitulo(va.JTituloText.getText());
        Bean.setPaginas(Integer.parseInt(va.JSpinnerNPag.getValue().toString()));
        Bean.setEstatus(va.JEstadoLibro.getSelectedItem().toString());
        Bean.setAutor(va.JListAutor.getSelectedIndex());
        Bean.setNumeroPrestamos(0);
        Bean.setEditorial(va.JListEditorial.getSelectedIndex());
        Bean.setArea(va.JAreaLibro.getSelectedIndex());
        Bean.setLocalizacion(va.JLocalizacionLibro.getSelectedIndex());
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            if (adm.ModificarLibro(Bean)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            }
        }
    }

    /**
     * Eliminar Libro
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJEliminarLibro(DefaultTableModel ae, VAdministrador va) {
        int Select = va.JTableRLibro.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            if (adm.EliminarLibro(va.JTableRLibro.getValueAt(Select, 0).toString())) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

    /**
     * Buscar Libro
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJBuscarLibro(DefaultTableModel ae, VAdministrador va) {
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
        System.out.println(action);
        adm.BuscarLibro(ae, Bean, Editorial, Autor, action);
    }

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Ingresar Socios
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJIngresarSocio(DefaultTableModel ae, VAdministrador va) {

    }

    /**
     * Modificar Socios
     *
     *
     * @param va
     */
    public void actionPerformedJModificarSocio(VAdministrador va) {

    }

    /**
     * Eliminar Socios
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJEliminarSocio(DefaultTableModel ae, VAdministrador va) {

    }

    /**
     * Buscar Socios
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJBuscarSocio(DefaultTableModel ae, VAdministrador va) {

    }

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Ingresar Autor
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJIngresarAutor(DefaultTableModel ae, VAdministrador va) {

    }

    /**
     * Modificar Autor
     *
     *
     * @param va
     */
    public void actionPerformedJModificarAutor(VAdministrador va) {

    }

    /**
     * Eliminar Autor
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJEliminarAutor(DefaultTableModel ae, VAdministrador va) {

    }

    /**
     * Buscar Autor
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJBuscarAutor(DefaultTableModel ae, VAdministrador va) {

    }

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Ingresar Editorial
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJIngresarEditorial(DefaultTableModel ae, VAdministrador va) {

    }

    /**
     * Modificar Editorial
     *
     *
     * @param va
     */
    public void actionPerformedJModificarEditorial(VAdministrador va) {

    }

    /**
     * Eliminar Editorial
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJEliminarEditorial(DefaultTableModel ae, VAdministrador va) {

    }

    /**
     * Buscar Editorial
     *
     *
     * @param ae
     */
    public void actionPerformedJBuscarEditorial(DefaultTableModel ae) {

    }

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Ingresar Localización
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJIngresarLocalizacion(DefaultTableModel ae, VAdministrador va) {

    }

    /**
     * Modificar Localización
     *
     *
     * @param va
     */
    public void actionPerformedJModificarLocalizacion(VAdministrador va) {

    }

    /**
     * Eliminar Localización
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJEliminarLocalizacion(DefaultTableModel ae, VAdministrador va) {

    }

    /**
     * Buscar Localización
     *
     *
     * @param ae
     */
    public void actionPerformedJBuscarLocalizacion(DefaultTableModel ae) {

    }

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Ingresar Área
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJIngresarArea(DefaultTableModel ae, VAdministrador va) {

    }

    /**
     * Modificar Área
     *
     *
     * @param va
     */
    public void actionPerformedJModificarArea(VAdministrador va) {

    }

    /**
     * Eliminar Área
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJEliminarArea(DefaultTableModel ae, VAdministrador va) {

    }

    /**
     * Buscar Área
     *
     *
     * @param ae
     */
    public void actionPerformedJBuscarArea(DefaultTableModel ae) {

    }
}
