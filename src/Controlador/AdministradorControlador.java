package Controlador;

import Classes.Beans.LibroBean;
import Modelo.AdministradorDAO;
import Vista.VAdministrador;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class AdministradorControlador {

    public AdministradorDAO adm = new AdministradorDAO();

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
        System.out.println(Bean.getIsbn()+Bean.getTitulo()+Bean.getPaginas()+Bean.getEstatus()+Bean.getNumeroPrestamos()+Bean.getEditorial()+Bean.getArea()+Bean.getLocalizacion());
        ae.addRow(new Object[]{Bean.getIdLibro(), Bean.getIsbn(), Bean.getTitulo(), Bean.getPaginas(), Bean.getEstatus(), va.JListAutor.getSelectedValue(), va.JListEditorial.getSelectedValue(), va.JAreaLibro.getSelectedItem().toString(), va.JLocalizacionLibro.getSelectedItem().toString(), va.JSpinnerCantidad.getValue().toString()});
        if (adm.IngresarLibro(ae, Bean)) {
ae.addRow(new Object[]{Bean.getIdLibro(), Bean.getIsbn(), Bean.getTitulo(), Bean.getPaginas(), Bean.getEstatus(), va.JListAutor.getSelectedValue(), va.JListEditorial.getSelectedValue(), va.JAreaLibro.getSelectedItem().toString(), va.JLocalizacionLibro.getSelectedItem().toString(), va.JSpinnerCantidad.getValue().toString()});
            JOptionPane.showMessageDialog(null, "El Libro ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el Libro", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformedJModificarLibro(VAdministrador va) {
        int Select = va.JTableRLibro.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            if (adm.ModificarLibro(va.JTableRLibro.getValueAt(Select, 0).toString(), va.JTableRLibro.getValueAt(Select, 1).toString(), va.JTableRLibro.getValueAt(Select, 2).toString(), va.JTableRLibro.getValueAt(Select, 3).toString(), va.JTableRLibro.getValueAt(Select, 4).toString(), va.JTableRLibro.getValueAt(Select, 5).toString())) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            }
        }
    }

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

    public void actionPerformedJBuscarLibro(DefaultTableModel ae, VAdministrador va) {
        int action = 0;
        LibroBean Bean = new LibroBean();
        Bean.setTitulo(va.JTituloText.getText());
        Bean.setIsbn(va.JISBNText.getText());
        String Editorial = (va.JListEditorial.getSelectedValue());
        String Autor = (va.JListAutor.getSelectedValue());
        if (va.JCheckTitulo.isSelected() && (!va.JCheckAutor.isSelected() && !va.JCheckISBN.isSelected() && !va.JCheckEditorial.isSelected())) {
            action = 1;
        } else if(va.JCheckISBN.isSelected() && (!va.JCheckAutor.isSelected() && !va.JCheckTitulo.isSelected() && !va.JCheckEditorial.isSelected())){
            action = 2;
        } else if(va.JCheckAutor.isSelected() && (!va.JCheckTitulo.isSelected() && !va.JCheckISBN.isSelected() && !va.JCheckEditorial.isSelected())){
            action = 3;
        } else if(va.JCheckEditorial.isSelected() && (!va.JCheckTitulo.isSelected() && !va.JCheckISBN.isSelected() && !va.JCheckAutor.isSelected())){
            action = 4;
        } else if(va.JCheckEditorial.isSelected() && va.JCheckTitulo.isSelected() && (!va.JCheckISBN.isSelected() && !va.JCheckAutor.isSelected())){
            action = 5;
        }
        adm.BuscarLibro(ae, Bean, Editorial, Autor, action);
    }

}
