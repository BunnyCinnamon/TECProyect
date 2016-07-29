package Controlador;

import Classes.Beans.AutorBean;
import Classes.Beans.LibroBean;
import Classes.Beans.SocioBean;
import Modelo.AdministradorDAO;
import Utils.CleanupDone;
import Vista.VAdministrador;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

@CleanupDone
public class AdministradorControlador {

    private final AdministradorDAO adm = new AdministradorDAO();

    /**
     * Transforma el String a un id al inicio del texto. El matcher busca el
     * primer número en el texto y envia el resultado a un parse que convierte
     * el número a integer
     *
     * @param a // Contiene el texto
     */
    private int getId(String a) {
        Matcher m = Pattern.compile("[^0-9]*([0-9]+).*").matcher(a);
        int id = 0;
        if (m.matches()) {
            id = Integer.parseInt(m.group(1));
        }
        return id;
    }

    /**
     * Transforma el String a un texto leíble para la base de datos. Si el texto
     * es null devuelve un texto vacio; Si el texto contiene texto, busca el
     * primer espacio y resta los caracteres del texto hasta el primer espacio
     * más 1
     *
     * @param e // Contiene el texto
     */
    private String getString(String e) {
        if (e == null) {
            return "";
        }
        return e.substring(e.indexOf(' ') + 1);
    }

    /**
     * Ingresar Libro. Crea un nuevo libro bean y le asigna los datos en los
     * text fiels y listas, si todas las listas tienen datos, ingresa la
     * información en la tabla y envia los datos al dao correspondiente, si es
     * correcto ingresa los datos en la tabla y muestra un JOptionPane con texto
     * exitoso, si no es correcto envia un JOptionPane con texto erroneo
     *
     * @param ae // Contiene el objeto Tabla de la Vista
     * @param va // Contiene le objeto Vista
     */
    public void actionPerformedJIngresarLibro(DefaultTableModel ae, VAdministrador va) {
        LibroBean Bean = new LibroBean();
        Bean.setIsbn(va.JISBNText.getText());
        Bean.setTitulo(va.JTituloText.getText());
        Bean.setPaginas(Integer.parseInt(va.JSpinnerNPag.getValue().toString()));
        Bean.setEstatus(va.JEstadoLibro.getSelectedItem().toString());
        Bean.setAutor(getId(va.JListAutor.getSelectedValue()));
        Bean.setNumeroPrestamos(Integer.parseInt(va.JSpinnerCantidad.getValue().toString()));
        Bean.setEditorial(getId(va.JListEditorial.getSelectedValue()));
        Bean.setArea(getId(va.JAreaLibro.getSelectedItem().toString()));
        Bean.setLocalizacion(getId(va.JLocalizacionLibro.getSelectedItem().toString()));
        if (Bean.getArea() == 0 || Bean.getEditorial() == 0 || Bean.getAutor() == 0 || Bean.getLocalizacion() == 0) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del libro", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        } else if (adm.IngresarLibro(Bean)) {
            ae.addRow(new Object[]{Bean.getIdLibro(), Bean.getIsbn(), Bean.getTitulo(), Bean.getPaginas(), Bean.getEstatus(), getString(va.JListAutor.getSelectedValue()), getString(va.JListEditorial.getSelectedValue()), getString(va.JAreaLibro.getSelectedItem().toString()), getString(va.JLocalizacionLibro.getSelectedItem().toString()), Bean.getNumeroPrestamos()});
            JOptionPane.showMessageDialog(null, "El Libro ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el Libro correctamente", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modificar Libro. Crea un nuevo libro bean y le asigna los datos en los
     * text fiels y listas, si todas las listas tienen datos, envia los datos al
     * dao correspondiente, si algo es exitoso o erroneo muestra un texto en
     * JOptionPane
     *
     * @param va // Contiene le objeto Vista
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
            Bean.setAutor(getId(va.JListAutor.getSelectedValue()));
            Bean.setEditorial(getId(va.JListEditorial.getSelectedValue()));
            Bean.setArea(getId(va.JAreaLibro.getSelectedItem().toString()));
            Bean.setLocalizacion(getId(va.JLocalizacionLibro.getSelectedItem().toString()));
            if (Bean.getArea() == 0 || Bean.getEditorial() == 0 || Bean.getAutor() == 0 || Bean.getLocalizacion() == 0) {
                JOptionPane.showMessageDialog(null, "Ingresa todos los datos del libro", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            } else if (adm.ModificarLibro(Bean)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            }
        }
    }

    /**
     * Eliminar Libro. Consigue el id del libro seleccionado en la tabla, si hay
     * un error envia JOptionPane con texto erroneo y si no un texto exitoso,
     * envia el id al dao correspondiente
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJEliminarLibro(DefaultTableModel ae, VAdministrador va) {
        int Select = va.JTableRLibro.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? (Inactivo)")) {
            if (adm.EliminarLibro(Integer.parseInt(va.JTableRLibro.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

    /**
     * Buscar Libro. Consigue el id del titulo, isbn, editorial y autor si hay
     * un error envia JOptionPane con texto erroneo y si no un texto exitoso,
     * envia los datos al dao correspondiente
     *
     * @param ae
     * @param va
     */
    public void actionPerformedJBuscarLibro(DefaultTableModel ae, VAdministrador va) {
        int action = 0;
        LibroBean Bean = new LibroBean();
        Bean.setTitulo(va.JTituloText.getText());
        Bean.setIsbn(va.JISBNText.getText());
        String Editorial = getString(va.JListEditorial.getSelectedValue());
        String Autor = getString(va.JListAutor.getSelectedValue());
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
     * Ingresar Socios. Crea un nuevo socio bean y le ingresa los datos en los
     * text fiels y listas, de la vista. Envia los datos al dao correspondiente
     * con texto exitoso, si no es correcto envia un JOptionPane con texto
     * erroneo y si es correcto ingresa los datos en la tabla y muestra un
     * JOptionPane con texto exitoso, si no es correcto envia un JOptionPane con
     * texto erroneo
     *
     * @param ae // Contiene el objeto de Tabla de la Vista
     * @param va // Contiene el objeto de Vista
     */
    public void actionPerformedJIngresarSocio(DefaultTableModel ae, VAdministrador va) {
        SocioBean Bean = new SocioBean();
        Bean.setNombre(va.JNombreTextSocio.getText());
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
            ae.addRow(new Object[]{Bean.getIdUsuario(), Bean.getNombre(), Bean.getApellidoP(), Bean.getApellidoM(), Bean.getEstado() + " " + Bean.getMunicipio() + " " + Bean.getCalle() + "#" + Bean.getNumero(), Bean.getTelefono(), "Activo", Bean.getPrestamos(), Bean.getUsuario(), "**********"});
            JOptionPane.showMessageDialog(null, "El Libro ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el Libro correctamente", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modificar Socios. Crea un nuevo socio bean, si la tabla esta seleccionada
     * consigue el id del socio y envia el Bean al dao correspondiente, si es
     * exitoso muestra un mensaje correcto
     *
     * @param va // Contiene el objeto de Vista
     */
    public void actionPerformedJModificarSocio(VAdministrador va) {
        int Select = va.JTableRSocio.getSelectedRow();
        SocioBean Bean = new SocioBean();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {

            Bean.setIdUsuario(Integer.parseInt(va.JTableRSocio.getValueAt(Select, 0).toString()));
            Bean.setNombre(va.JNombreTextSocio.getText());
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
     * Eliminar Socios. Si la tabla está seleccionada consigue el id del socio y
     * lo envia a el dao correspondiente, si no muestra un JOptionPane con el
     * mensaje que le corresponde
     *
     * @param ae // Contiene el objeto Tabla de la Vista
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJEliminarSocio(DefaultTableModel ae, VAdministrador va) {
        int Select = va.JTableRSocio.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? (Inactivo)")) {
            int id = Integer.parseInt(va.JTableRSocio.getValueAt(Select, 0).toString());
            if (adm.EliminarSocio(id)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

    /**
     * Buscar Socios. Crea un nuevo socio bean, ingresa los valores de los text
     * fiels en el bean y consigue la acción dependiendo de los combo box
     * seleccionados. Envia el bean y la acción al dao correspondiente
     *
     * @param ae // Contiene el objeto Tabla de la vista
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJBuscarSocio(DefaultTableModel ae, VAdministrador va) {
        int action = 0;
        SocioBean Bean = new SocioBean();
        Bean.setNombre(va.JNombreTextSocio.getText());
        Bean.setApellidoP(va.JApellidoPTextSocio.getText());
        Bean.setApellidoM(va.JApellidoMTextSocio.getText());
        Bean.setUsuario(va.JTextUsuario.getText());
        if (va.JCheckNombre.isSelected() && (!va.JCheckApellidoP.isSelected() && !va.JCheckApellidoM.isSelected() && !va.JCheckUsuario.isSelected())) {
            action = 1;
        } else if (va.JCheckApellidoM.isSelected() && (!va.JCheckApellidoP.isSelected() && !va.JCheckNombre.isSelected() && !va.JCheckUsuario.isSelected())) {
            action = 2;
        } else if (va.JCheckApellidoP.isSelected() && (!va.JCheckNombre.isSelected() && !va.JCheckApellidoM.isSelected() && !va.JCheckUsuario.isSelected())) {
            action = 3;
        } else if (va.JCheckUsuario.isSelected() && (!va.JCheckNombre.isSelected() && !va.JCheckApellidoM.isSelected() && !va.JCheckApellidoP.isSelected())) {
            action = 4;
        } else if (va.JCheckUsuario.isSelected() && va.JCheckNombre.isSelected() && (!va.JCheckApellidoM.isSelected() && !va.JCheckApellidoP.isSelected())) {
            action = 5;
        } else if (va.JCheckApellidoP.isSelected() && va.JCheckNombre.isSelected() && (!va.JCheckApellidoM.isSelected() && !va.JCheckUsuario.isSelected())) {
            action = 6;
        } else if (va.JCheckApellidoM.isSelected() && va.JCheckNombre.isSelected() && (!va.JCheckUsuario.isSelected() && !va.JCheckApellidoP.isSelected())) {
            action = 7;
        } else if (va.JCheckApellidoM.isSelected() && va.JCheckApellidoP.isSelected() && (!va.JCheckUsuario.isSelected() && !va.JCheckNombre.isSelected())) {
            action = 8;
        } else if (va.JCheckApellidoM.isSelected() && va.JCheckUsuario.isSelected() && (!va.JCheckNombre.isSelected() && !va.JCheckApellidoP.isSelected())) {
            action = 9;
        } else if (va.JCheckUsuario.isSelected() && va.JCheckApellidoP.isSelected() && (!va.JCheckNombre.isSelected() && !va.JCheckApellidoM.isSelected())) {
            action = 10;
        } else if (va.JCheckNombre.isSelected() && va.JCheckApellidoM.isSelected() && va.JCheckApellidoP.isSelected() && (!va.JCheckUsuario.isSelected())) {
            action = 11;
        } else if (va.JCheckNombre.isSelected() && va.JCheckApellidoM.isSelected() && va.JCheckUsuario.isSelected() && (!va.JCheckApellidoP.isSelected())) {
            action = 12;
        } else if (va.JCheckApellidoM.isSelected() && va.JCheckApellidoP.isSelected() && va.JCheckUsuario.isSelected() && (!va.JCheckNombre.isSelected())) {
            action = 13;
        } else if (va.JCheckNombre.isSelected() && va.JCheckApellidoP.isSelected() && va.JCheckUsuario.isSelected() && (!va.JCheckApellidoM.isSelected())) {
            action = 14;
        } else if (va.JCheckUsuario.isSelected() && va.JCheckApellidoP.isSelected() && va.JCheckNombre.isSelected() && va.JCheckApellidoM.isSelected()) {
            action = 15;
        }
        adm.BuscarSocio(ae, Bean, action);
    }

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Ingresar Autor. Crea un nuevo autor bean y le ingresa los datos en los
     * text field, envia el bean al dao correspondiente, si es exitoso envia un
     * JOptionPane con texto correcto, si no es exitoso envia un texto erroneo
     *
     * @param ae // Contiene el objeto Tabla de la Vista
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJIngresarAutor(DefaultTableModel ae, VAdministrador va) {
        AutorBean Bean = new AutorBean();
        Bean.setNombre(va.JNombreTextAutor.getText());
        Bean.setApellidoP(va.JApellidoPAutor.getText());
        Bean.setApellidoM(va.JApellidoMAutor.getText());
        if (adm.IngresarAutor(ae, Bean)) {
            ae.addRow(new Object[]{Bean.getIdAutor(), Bean.getNombre(), Bean.getApellidoP(), Bean.getApellidoM(), "Activo"});
            JOptionPane.showMessageDialog(null, "El autor ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el autor", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modificar Autor. Crea un nuevo autor bean, Si la tabla está seleccionada
     * consigue el id del autor seleccionado y lo ingresa en el bean con todos
     * los valores en los text field. Envia los datos al dao correspondiente, si
     * es exitoso envia un JOptionPane con texto correcto, si no es exitoso
     * envia un texto erroneo
     *
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJModificarAutor(VAdministrador va) {
        AutorBean Bean = new AutorBean();
        int Select = va.JTableRAutor.getSelectedRow();
        Bean.setIdAutor(Integer.parseInt(va.JTableRAutor.getValueAt(Select, 0).toString()));
        Bean.setNombre(va.JNombreTextAutor.getText());
        Bean.setApellidoP(va.JApellidoPAutor.getText());
        Bean.setApellidoM(va.JApellidoMAutor.getText());
        Bean.setStatus(va.JComboEstatusAutor.getSelectedItem().toString());
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            if (adm.ModificarAutor(Bean)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            }
        }
    }

    /**
     * Eliminar Autor. Si la tabla está seleccionada consigue el id del autor
     * seleccionado. Envia el id al dao correspondiente, si es exitoso envia un
     * JOptionPane con texto correcto, si no es exitoso envia un texto erroneo
     *
     * @param ae // Contiene el objeto Tabla de Vista
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJEliminarAutor(DefaultTableModel ae, VAdministrador va) {
        int Select = va.JTableRAutor.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            if (adm.EliminarAutor(Integer.parseInt(va.JTableRAutor.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Integer.parseInt(va.JTableRAutor.getValueAt(Select, 0).toString()));
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

    /**
     * Buscar Autor. Crea un nuevo autor bean, ingresa los valores de los text
     * fiels en el bean y consigue la acción dependiendo de los combo box
     * seleccionados. Envia el bean y la acción al dao correspondiente
     *
     * @param ae // Contiene el objeto Tabla de la vista
     * @param va // Contiene el objeto Vista
     */
    public void actionPerformedJBuscarAutor(DefaultTableModel ae, VAdministrador va) {
        int action = 0;
        AutorBean Bean = new AutorBean();
        Bean.setNombre(va.JNombreTextSocio.getText());
        Bean.setApellidoP(va.JApellidoPTextSocio.getText());
        Bean.setApellidoM(va.JApellidoMTextSocio.getText());
        if (va.JCheckNombreAutor.isSelected() && (!va.JCheckApellidoP.isSelected() && !va.JCheckApellidoM.isSelected())) {
            action = 1;
        } else if (va.JCheckApellidoM.isSelected() && (!va.JCheckApellidoP.isSelected() && !va.JCheckNombre.isSelected())) {
            action = 2;
        } else if (va.JCheckApellidoP.isSelected() && (!va.JCheckNombre.isSelected() && !va.JCheckApellidoM.isSelected())) {
            action = 3;
        } else if (va.JCheckApellidoM.isSelected() && va.JCheckNombre.isSelected() && (!va.JCheckApellidoM.isSelected())) {
            action = 4;
        } else if (va.JCheckApellidoP.isSelected() && va.JCheckNombre.isSelected() && (!va.JCheckApellidoP.isSelected())) {
            action = 5;
        } else if (va.JCheckApellidoP.isSelected() && va.JCheckApellidoM.isSelected() && (!va.JCheckNombre.isSelected())) {
            action = 6;
        }
        adm.BuscarAutor(ae, Bean, action);
    }
}
