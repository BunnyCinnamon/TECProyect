package Controlador;

import Classes.Beans.LibroBean;
import Classes.Beans.SocioBean;
import Modelo.AdministradorDAO;
import Vista.VAdministrador;
import java.util.ArrayList;
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
        Bean.setNumeroPrestamos(Integer.parseInt(va.JSpinnerCantidad.getValue().toString()));
        Bean.setEditorial(va.JListEditorial.getSelectedIndex());
        Bean.setArea(va.JAreaLibro.getSelectedIndex());
        Bean.setLocalizacion(va.JLocalizacionLibro.getSelectedIndex());
        if (adm.IngresarLibro(Bean)) {
            ae.addRow(new Object[]{Bean.getIdLibro(), Bean.getIsbn(), Bean.getTitulo(), Bean.getPaginas(), Bean.getEstatus(), va.JListAutor.getSelectedValue(), va.JListEditorial.getSelectedValue(), va.JAreaLibro.getSelectedItem().toString(), va.JLocalizacionLibro.getSelectedItem().toString(), Bean.getNumeroPrestamos()});
            JOptionPane.showMessageDialog(null, "El Libro ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el Libro correctamente", "Error!", JOptionPane.ERROR_MESSAGE);
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
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {

            Bean.setIdLibro(Integer.parseInt(va.JTableRLibro.getValueAt(Select, 0).toString()));
            Bean.setIsbn(va.JISBNText.getText());
            Bean.setTitulo(va.JTituloText.getText());
            Bean.setPaginas(Integer.parseInt(va.JSpinnerNPag.getValue().toString()));
            Bean.setEstatus(va.JEstadoLibro.getSelectedItem().toString());
            Bean.setAutor(va.JListAutor.getSelectedIndex());
            Bean.setEditorial(va.JListEditorial.getSelectedIndex());
            Bean.setArea(va.JAreaLibro.getSelectedIndex());
            Bean.setLocalizacion(va.JLocalizacionLibro.getSelectedIndex());

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
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? (Inactivo)")) {
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
        SocioBean Bean = new SocioBean();
        Bean.setNormbre(va.JNombreTextSocio.getText());
        Bean.setApellidoP(va.JApellidoPTextSocio.getText());
        Bean.setApellidoM(va.JApellidoMTextSocio.getText());
        Bean.setEstado(va.JEstadoTextSocio.getText());
        Bean.setMunicipio(va.JMunicipioTextSocio.getText());
        Bean.setCalle(va.JCalleTextSocio.getText());
        Bean.setNumero(Integer.parseInt(va.JNCalleTextSocio.getText()));
        Bean.setTelefono(Integer.parseInt(va.JTelefonoTextSocio.getText()));
        Bean.setUsuario(va.JTextUsuario.getText());
        Bean.setContraseña(va.JTextContraseñaSocio.getText());
        if (adm.IngresarSocio(Bean)) {
            ae.addRow(new Object[]{Bean.getIdUsuario(), Bean.getNormbre(), Bean.getApellidoP(), Bean.getApellidoM(), Bean.getEstado() + " " + Bean.getMunicipio() + " " + Bean.getCalle() + "#" + Bean.getNumero(), Bean.getTelefono(), "Activo", "**********"});
            JOptionPane.showMessageDialog(null, "El Libro ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el Libro correctamente", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modificar Socios
     *
     *
     * @param va
     */
    public void actionPerformedJModificarSocio(VAdministrador va) {
        int Select = va.JTableRLibro.getSelectedRow();
        SocioBean Bean = new SocioBean();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {

            Bean.setIdUsuario(Integer.parseInt(va.JTableRSocio.getValueAt(Select, 0).toString()));
            Bean.setNormbre(va.JNombreTextSocio.getText());
            Bean.setApellidoP(va.JApellidoPTextSocio.getText());
            Bean.setApellidoM(va.JApellidoMTextSocio.getText());
            Bean.setEstado(va.JEstadoTextSocio.getText());
            Bean.setMunicipio(va.JMunicipioTextSocio.getText());
            Bean.setCalle(va.JCalleTextSocio.getText());
            Bean.setNumero(Integer.parseInt(va.JNCalleTextSocio.getText()));
            Bean.setTelefono(Integer.parseInt(va.JTelefonoTextSocio.getText()));
            Bean.setUsuario(va.JTextUsuario.getText());
            Bean.setEstatus(va.JEstatusSocio.getSelectedItem().toString());
            Bean.setContraseña(va.JTextContraseñaSocio.getText());

            if (adm.ModificarSocio(Bean)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            }
        }
    }

    /**
     * Eliminar Socios
     *
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJEliminarSocio(DefaultTableModel ae, VAdministrador va) {
        int Select = va.JTableRLibro.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? (Inactivo)")) {
            int id = Integer.parseInt(va.JTableRSocio.getValueAt(Select, 0).toString());
            if (adm.EliminarSocio(id)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            }
        }
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

//    ////////////////////////////////////////////////////////////////////////////
//    /**
//     * Ingresar Editorial
//     *
//     *
//     * @param ae
//     * @param va
//     */
//    public void actionPerformedJIngresarEditorial(DefaultTableModel ae, VAdministrador va) {
//
//    }
//
//    /**
//     * Modificar Editorial
//     *
//     *
//     * @param va
//     */
//    public void actionPerformedJModificarEditorial(VAdministrador va) {
//
//    }
//
//    /**
//     * Eliminar Editorial
//     *
//     *
//     * @param ae
//     * @param va
//     */
//    public void actionPerformedJEliminarEditorial(DefaultTableModel ae, VAdministrador va) {
//
//    }
//
//    ////////////////////////////////////////////////////////////////////////////
//    /**
//     * Ingresar Localización
//     *
//     *
//     * @param ae
//     * @param va
//     */
//    public void actionPerformedJIngresarLocalizacion(DefaultTableModel ae, VAdministrador va) {
//
//    }
//
//    /**
//     * Modificar Localización
//     *
//     *
//     * @param va
//     */
//    public void actionPerformedJModificarLocalizacion(VAdministrador va) {
//
//    }
//
//    /**
//     * Eliminar Localización
//     *
//     *
//     * @param ae
//     * @param va
//     */
//    public void actionPerformedJEliminarLocalizacion(DefaultTableModel ae, VAdministrador va) {
//
//    }
//
//    ////////////////////////////////////////////////////////////////////////////
//    /**
//     * Ingresar Área
//     *
//     *
//     * @param ae
//     * @param va
//     */
//    public void actionPerformedJIngresarArea(DefaultTableModel ae, VAdministrador va) {
//
//    }
//
//    /**
//     * Modificar Área
//     *
//     *
//     * @param va
//     */
//    public void actionPerformedJModificarArea(VAdministrador va) {
//
//    }
//
//    /**
//     * Eliminar Área
//     *
//     *
//     * @param ae
//     * @param va
//     */
//    public void actionPerformedJEliminarArea(DefaultTableModel ae, VAdministrador va) {
//
//    }
}
