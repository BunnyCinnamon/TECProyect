package Controlador;

import Classes.Beans.AutorBean;
import Classes.Beans.LibroBean;
import Classes.Beans.SocioBean;
import Modelo.AdministradorDAO;
import Utils.CleanupDone;
import Utils.TextChecker;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

@CleanupDone
public class AdministradorControlador {

    private final AdministradorDAO adm = new AdministradorDAO();
    private static final TextChecker TEXT_CHECKER = new TextChecker();

    /**
     * Transforma el String a un id al inicio del texto. El matcher busca el
     * primer número en el texto y envia el resultado a un parse que convierte
     * el número a integer
     *
     * @param a // Contiene el texto
     */
    private int getId(String a) throws NullPointerException {
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
     * @param jModel // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     * @param jArray // Contiene los objetos de selección
     */
    public void actionPerformedJIngresarLibro(DefaultTableModel jModel, Object[] jField, ArrayList jArray) {
        LibroBean Bean = new LibroBean();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Bean.setIsbn(jField[0].toString());
        Bean.setTitulo(jField[1].toString());
        Bean.setPaginas(Integer.parseInt(jField[2].toString()));
        Bean.setEstatus(jField[3].toString());
        Bean.setNumeroPrestamos(Integer.parseInt(jField[4].toString()));
        try {
            Bean.setAutor(getId(jArray.get(0).toString()));
            Bean.setEditorial(getId(jArray.get(1).toString()));
            Bean.setArea(getId(jArray.get(2).toString()));
            Bean.setLocalizacion(getId(jArray.get(3).toString()));
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (Bean.getArea() == 0 || Bean.getEditorial() == 0 || Bean.getAutor() == 0 || Bean.getLocalizacion() == 0) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (adm.IngresarLibro(Bean)) {
            jModel.addRow(new Object[]{Bean.getIdLibro(), Bean.getIsbn(), Bean.getTitulo(), Bean.getPaginas(), Bean.getEstatus(), getString(jArray.get(0).toString()), getString(jArray.get(1).toString()), getString(jArray.get(2).toString()), getString(jArray.get(3).toString()), Bean.getNumeroPrestamos()});
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
     * @param jTableRLibro // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     * @param jArray // Contiene los objetos de selección
     */
    public void actionPerformedJModificarLibro(JTable jTableRLibro, Object[] jField, ArrayList jArray) {
        LibroBean Bean = new LibroBean();
        int Select = jTableRLibro.getSelectedRow();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Bean.setAutor(getId(jArray.get(0).toString()));
            Bean.setEditorial(getId(jArray.get(1).toString()));
            Bean.setArea(getId(jArray.get(2).toString()));
            Bean.setLocalizacion(getId(jArray.get(3).toString()));
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            Bean.setIdLibro(Integer.parseInt(jTableRLibro.getValueAt(Select, 0).toString()));
            Bean.setIsbn(jField[0].toString());
            Bean.setTitulo(jField[1].toString());
            Bean.setPaginas(Integer.parseInt(jField[2].toString()));
            Bean.setEstatus(jField[3].toString());
            Bean.setNumeroPrestamos(Integer.parseInt(jField[4].toString()));
            if (Bean.getArea() == 0 || Bean.getEditorial() == 0 || Bean.getAutor() == 0 || Bean.getLocalizacion() == 0) {
                JOptionPane.showMessageDialog(null, "Ingresa todos los datos del libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
     * @param jTableRLibro // Contiene el objeto Tabla
     */
    public void actionPerformedJEliminarLibro(JTable jTableRLibro) {
        DefaultTableModel ae = (DefaultTableModel) jTableRLibro.getModel();
        int Select = jTableRLibro.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? (Inactivo)")) {
            if (adm.EliminarLibro(Integer.parseInt(jTableRLibro.getValueAt(Select, 0).toString()))) {
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
            Editorial = getString(jField[2].toString());
            Autor = getString(jField[3].toString());
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

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Ingresar Socios. Crea un nuevo socio bean y le ingresa los datos en los
     * text fiels y listas, de la vista. Envia los datos al dao correspondiente
     * con texto exitoso, si no es correcto envia un JOptionPane con texto
     * erroneo y si es correcto ingresa los datos en la tabla y muestra un
     * JOptionPane con texto exitoso, si no es correcto envia un JOptionPane con
     * texto erroneo
     *
     * @param jModel // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Texto
     */
    public void actionPerformedJIngresarSocio(DefaultTableModel jModel, Object[] jField) {
        SocioBean Bean = new SocioBean();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Socio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Bean.setNombre(jField[0].toString());
        Bean.setApellidoP(jField[1].toString());
        Bean.setApellidoM(jField[2].toString());
        Bean.setEstado(jField[3].toString());
        Bean.setMunicipio(jField[4].toString());
        Bean.setCalle(jField[5].toString());
        Bean.setNumero(Integer.parseInt(jField[6].toString()));
        Bean.setTelefono(Integer.parseInt(jField[7].toString()));
        Bean.setUsuario(jField[8].toString());
        Bean.setContraseña(jField[9].toString());
        if (adm.IngresarSocio(Bean)) {
            jModel.addRow(new Object[]{Bean.getIdUsuario(), Bean.getNombre(), Bean.getApellidoP(), Bean.getApellidoM(), Bean.getEstado() + " " + Bean.getMunicipio() + " " + Bean.getCalle() + "#" + Bean.getNumero(), Bean.getTelefono(), "Activo", Bean.getPrestamos(), Bean.getUsuario(), "**********"});
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
     * @param jTableRSocio // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Text
     */
    public void actionPerformedJModificarSocio(JTable jTableRSocio, Object[] jField) {
        int Select = jTableRSocio.getSelectedRow();
        SocioBean Bean = new SocioBean();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Socio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            Bean.setIdUsuario(Integer.parseInt(jTableRSocio.getValueAt(Select, 0).toString()));
            Bean.setNombre(jField[0].toString());
            Bean.setApellidoP(jField[1].toString());
            Bean.setApellidoM(jField[2].toString());
            Bean.setEstado(jField[3].toString());
            Bean.setMunicipio(jField[4].toString());
            Bean.setCalle(jField[5].toString());
            Bean.setNumero(Integer.parseInt(jField[6].toString()));
            Bean.setTelefono(Integer.parseInt(jField[7].toString()));
            Bean.setUsuario(jField[8].toString());
            Bean.setContraseña(jField[9].toString());
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
     * @param jTableRSocio // Contiene el objeto Tabla de la Vista
     */
    public void actionPerformedJEliminarSocio(JTable jTableRSocio) {
        DefaultTableModel ae = (DefaultTableModel) jTableRSocio.getModel();
        int Select = jTableRSocio.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? (Inactivo)")) {
            int id = Integer.parseInt(jTableRSocio.getValueAt(Select, 0).toString());
            if (adm.EliminarSocio(id)) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

    /**
     * Buscar Socios. Crea un nuevo socio bean, ingresa los valores de los text
     * fiels en el bean y consigue la acción dependiendo de los combo box
     * seleccionados. Envia el bean y la acción al dao correspondiente
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
        adm.BuscarSocio(jModel, Bean, action);
    }

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Ingresar Autor. Crea un nuevo autor bean y le ingresa los datos en los
     * text field, envia el bean al dao correspondiente, si es exitoso envia un
     * JOptionPane con texto correcto, si no es exitoso envia un texto erroneo
     *
     * @param jModel // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     */
    public void actionPerformedJIngresarAutor(DefaultTableModel jModel, Object[] jField) {
        AutorBean Bean = new AutorBean();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Autor", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Bean.setNombre(jField[0].toString());
        Bean.setApellidoP(jField[1].toString());
        Bean.setApellidoM(jField[2].toString());
        if (adm.IngresarAutor(jModel, Bean)) {
            jModel.addRow(new Object[]{Bean.getIdAutor(), Bean.getNombre(), Bean.getApellidoP(), Bean.getApellidoM(), "Activo"});
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
     * @param jTableRAutor // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Text
     */
    public void actionPerformedJModificarAutor(JTable jTableRAutor, Object[] jField) {
        AutorBean Bean = new AutorBean();
        int Select = jTableRAutor.getSelectedRow();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Autor", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            Bean.setIdAutor(Integer.parseInt(jTableRAutor.getValueAt(Select, 0).toString()));
            Bean.setNombre(jField[0].toString());
            Bean.setApellidoP(jField[1].toString());
            Bean.setApellidoM(jField[2].toString());
            Bean.setStatus(jField[3].toString());
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
     * @param jTableRAutor // Contiene el objeto de Tabla de la Vista
     */
    public void actionPerformedJEliminarAutor(JTable jTableRAutor) {
        DefaultTableModel ae = (DefaultTableModel) jTableRAutor.getModel();
        int Select = jTableRAutor.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            int id = Integer.parseInt(jTableRAutor.getValueAt(Select, 0).toString());
            if (adm.EliminarAutor(id)) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

    /**
     * Buscar Autor. Crea un nuevo autor bean, ingresa los valores de los text
     * fiels en el bean y consigue la acción dependiendo de los combo box
     * seleccionados. Envia el bean y la acción al dao correspondiente
     *
     * @param jModel // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     * @param jSelect // Contiene los objetos de selección
     */
    public void actionPerformedJBuscarAutor(DefaultTableModel jModel, Object[] jField, boolean[] jSelect) {
        int action = 0;
        AutorBean Bean = new AutorBean();
        Bean.setNombre(jField[0].toString());
        Bean.setApellidoP(jField[1].toString());
        Bean.setApellidoM(jField[2].toString());
        if (jSelect[0] && (!jSelect[1] && !jSelect[2])) {
            action = 1;
        } else if (jSelect[2] && (!jSelect[1] && !jSelect[0])) {
            action = 2;
        } else if (jSelect[1] && (!jSelect[0] && !jSelect[2])) {
            action = 3;
        } else if (jSelect[2] && jSelect[0] && (!jSelect[1])) {
            action = 4;
        } else if (jSelect[1] && jSelect[0] && (!jSelect[2])) {
            action = 5;
        } else if (jSelect[1] && jSelect[2] && (!jSelect[0])) {
            action = 6;
        }
        adm.BuscarAutor(jModel, Bean, action);
    }
}
