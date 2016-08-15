package Controlador;

import Classes.Beans.AutorBean;
import Classes.Beans.LibroBean;
import Classes.Beans.SocioBean;
import Modelo.AdministradorDAO;
import Utils.CleanupDone;
import Utils.TableHelper;
import Utils.TextChecker;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Descripción: Controlador para Administradores
 *
 */
@CleanupDone
public class AdministradorControlador {

    private static final AdministradorDAO ADM = new AdministradorDAO();
    private static final TextChecker TEXT_CHECKER = new TextChecker();
    public final TableHelper TABLE_HELPER = new TableHelper();

    /**
     * Uso: Transforma el String a un id al inicio del texto.
     *
     * Descripción: El matcher busca el primer número en el texto y envia el
     * resultado a un parse que convierte el número a integer.
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
     * Uso: Transforma el String a un texto leíble para la base de datos.
     *
     * Descripción: Si el texto es null devuelve un texto vacio; Si el texto
     * contiene texto, busca el primer espacio y resta los caracteres del texto
     * hasta el primer espacio más 1.
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
     * Uso: Ingresar Libro.
     *
     * Descripción: Crea un nuevo libro bean y le asigna los datos en los text
     * fiels y listas, si todas las listas tienen datos, ingresa la información
     * en la tabla y envia los datos al dao correspondiente, si es correcto
     * ingresa los datos en la tabla y muestra un JOptionPane con texto exitoso,
     * si no es correcto envia un JOptionPane con texto erroneo.
     *
     * @param jModel // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     * @param jArray // Contiene los objetos de selección
     * @return // Regresa true o false si ocurre un error
     */
    public boolean actionPerformedJIngresarLibro(DefaultTableModel jModel, Object[] jField, ArrayList jArray) {
        LibroBean Bean = new LibroBean();
        boolean err = false;
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return err;
        } else if (!TEXT_CHECKER.checkLenght(jField[0].toString(), 10, 13)) {
            JOptionPane.showMessageDialog(null, "ISBN debe tener 10 ó 13 números", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return err;
        }
        if (!TEXT_CHECKER.checkISBN(jField[0].toString()) || !TEXT_CHECKER.checkText(jField[1].toString())) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z,ñ´] [0-9,-]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return err;
        }
        Bean.setIsbn(jField[0].toString());
        Bean.setTitulo(jField[1].toString());
        Bean.setPaginas(Integer.parseInt(jField[2].toString()));
        Bean.setEstatus(jField[3].toString());
        Bean.setNumero(Integer.parseInt(jField[4].toString()));
        try {
            Bean.setAutor(getId(jArray.get(0).toString()));
            Bean.setEditorial(getId(jArray.get(1).toString()));
            Bean.setArea(getId(jArray.get(2).toString()));
            Bean.setLocalizacion(getId(jArray.get(3).toString()));
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return err;
        }
        if (Bean.getArea() == 0 || Bean.getEditorial() == 0 || Bean.getAutor() == 0 || Bean.getLocalizacion() == 0) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (ADM.IngresarLibro(Bean)) {
            jModel.addRow(new Object[]{Bean.getIdLibro(), Bean.getIsbn(), Bean.getTitulo(), Bean.getPaginas(), Bean.getEstatus(), getString(jArray.get(0).toString()), getString(jArray.get(1).toString()), getString(jArray.get(2).toString()), getString(jArray.get(3).toString()), Bean.getNumero()});
            JOptionPane.showMessageDialog(null, "El Libro ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el Libro correctamente", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return err;
    }

    /**
     * Uso: Modificar Libro.
     *
     * Descripción: Crea un nuevo libro bean y le asigna los datos en los text
     * fiels y listas, si todas las listas tienen datos, envia los datos al dao
     * correspondiente, si algo es exitoso o erroneo muestra un texto en
     * JOptionPane.
     *
     * @param jTableRLibro // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     * @param jArray // Contiene los objetos de selección
     * @return // Regresa true o false si ocurre un error
     */
    public boolean actionPerformedJModificarLibro(JTable jTableRLibro, Object[] jField, ArrayList jArray) {
        LibroBean Bean = new LibroBean();
        boolean err = false;
        int select = jTableRLibro.getSelectedRow();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return err;
        } else if (!TEXT_CHECKER.checkLenght(jField[0].toString(), 10, 13)) {
            JOptionPane.showMessageDialog(null, "ISBN debe tener 10 ó 13 números", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return err;
        }
        if (!TEXT_CHECKER.checkISBN(jField[0].toString()) || !TEXT_CHECKER.checkText(jField[1].toString())) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z,ñ´] [0-9,-]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return err;
        }
        try {
            Bean.setAutor(getId(jArray.get(0).toString()));
            Bean.setEditorial(getId(jArray.get(1).toString()));
            Bean.setArea(getId(jArray.get(2).toString()));
            Bean.setLocalizacion(getId(jArray.get(3).toString()));
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return err;
        }
        if (select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            Bean.setIdLibro(Integer.parseInt(jTableRLibro.getValueAt(select, 0).toString()));
            Bean.setIsbn(jField[0].toString());
            Bean.setTitulo(jField[1].toString());
            Bean.setPaginas(Integer.parseInt(jField[2].toString()));
            Bean.setEstatus(jField[3].toString());
            Bean.setNumero(Integer.parseInt(jField[4].toString()));
            if (Bean.getArea() == 0 || Bean.getEditorial() == 0 || Bean.getAutor() == 0 || Bean.getLocalizacion() == 0) {
                JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (ADM.ModificarLibro(Bean)) {
                Object[] jFieldText = new Object[]{Bean.getIsbn(), Bean.getTitulo(), Bean.getPaginas(), Bean.getEstatus(), getString(jArray.get(0).toString()), getString(jArray.get(1).toString()), getString(jArray.get(2).toString()), getString(jArray.get(3).toString()), Bean.getNumero()};
                TABLE_HELPER.updateTableContentWith(jTableRLibro, jFieldText, select, 0);
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                return true;
            }
        }
        return err;
    }

    /**
     * Uso: Eliminar Libro.
     *
     * Descripción: Consigue el id del libro seleccionado en la tabla, si hay un
     * error envia JOptionPane con texto erroneo y si no un texto exitoso, envia
     * el id al dao correspondiente.
     *
     * @param jTableRLibro // Contiene el objeto Tabla
     */
    public void actionPerformedJEliminarLibro(JTable jTableRLibro) {
        DefaultTableModel ae = (DefaultTableModel) jTableRLibro.getModel();
        int Select = jTableRLibro.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? (Inactivo)")) {
            if (ADM.EliminarLibro(Integer.parseInt(jTableRLibro.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
    }

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
            Editorial = getString(jField[2].toString());
        } catch (NullPointerException n) {
        }
        try {
            Autor = getString(jField[3].toString());
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

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Uso: Ingresar Socios.
     *
     * Descripción: Crea un nuevo socio bean y le ingresa los datos en los text
     * fiels y listas, de la vista. Envia los datos al dao correspondiente con
     * texto exitoso, si no es correcto envia un JOptionPane con texto erroneo y
     * si es correcto ingresa los datos en la tabla y muestra un JOptionPane con
     * texto exitoso, si no es correcto envia un JOptionPane con texto erroneo.
     *
     * @param jModel // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Texto
     * @param A // Contiene el Apellido Materno del Socio, si es que tiene
     * @param B // Contiene el Número de Calle del Socio, si es que tiene
     * @param secretPass // Contraseña segura del Socio
     * @return // Regresa true o false si ocurre un error
     */
    public boolean actionPerformedJIngresarSocio(DefaultTableModel jModel, Object[] jField, String A, String B, char[] secretPass) {
        SocioBean Bean = new SocioBean();
        boolean err = false;
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Socio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return err;
        }
        if (TEXT_CHECKER.checkNoNumberText(jField[0].toString() + jField[1].toString())
                && TEXT_CHECKER.checkDirection(jField[2].toString() + jField[3].toString() + jField[4].toString())
                && TEXT_CHECKER.checkPhoneNumber(jField[5].toString())
                && TEXT_CHECKER.checkEmail(jField[6].toString())) {
            Bean.setNombre(jField[0].toString());
            Bean.setApellidoP(jField[1].toString());
            Bean.setApellidoM(A);
            Bean.setEstado(jField[2].toString());
            Bean.setMunicipio(jField[3].toString());
            Bean.setCalle(jField[4].toString());
            Bean.setNumero(B);
            Bean.setTelefono(jField[5].toString());
            Bean.setUsuario(jField[6].toString());
            if (ADM.IngresarSocio(Bean, secretPass)) {
                jModel.addRow(new Object[]{Bean.getIdUsuario(), Bean.getNombre(), Bean.getApellidoP(), Bean.getApellidoM(), Bean.getEstado() + " " + Bean.getMunicipio() + " " + Bean.getCalle() + " " + Bean.getNumero(), Bean.getTelefono(), "Activo", Bean.getPrestamos(), Bean.getUsuario(), "**********"});
                JOptionPane.showMessageDialog(null, "El Socio ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se agregó el Socio correctamente ¿Usuario duplicado?", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
        return err;
    }

    /**
     * Uso: Introducir Contraseña.
     *
     * Descripción: Crea una ventana donde se introduce la contraseña, si es
     * mayor a 5 caracteres continua, si no lo es envia un cuadro de texto
     * erroneo, pide de nuevo la contraseña y si es igual a la primera
     * contraseña inserta el texto en el text field y lo marca en verde.
     *
     * @param JTextContraseñaSocio // Contiene el objeto Text Field
     */
    public void JTextContraseñaSocioMouseClicked(JTextField JTextContraseñaSocio) {
        JPasswordField pwd = new JPasswordField(10);
        JPasswordField rpwd = new JPasswordField(10);
        if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, pwd, "Introducir contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE)) {
            char[] pass1 = pwd.getPassword();
            if (pass1.length < 5) {
                JOptionPane.showMessageDialog(null, "Contraseña no válida, Ingrese una contraseña igual o mayor a 5 caracteres");
            } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, rpwd, "Vuelva a introducir contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE)) {
                char[] pass2 = rpwd.getPassword();
                if (Arrays.equals(pass1, pass2)) {
                    JTextContraseñaSocio.setText(new String(pass2));
                    JTextContraseñaSocio.setForeground(Color.green);
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseñas no coinciden");
                }
            }
        }
    }

    /**
     * Uso: Modificar Socios.
     *
     * Descripción: Crea un nuevo socio bean, si la tabla esta seleccionada
     * consigue el id del socio y envia el Bean al dao correspondiente, si es
     * exitoso muestra un mensaje correcto.
     *
     * @param jTableRSocio // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Text
     * @param A // Contiene el Apellido Materno del Socio, si es que tiene
     * @param B // Contiene el Número de Calle del Socio, si es que tiene
     * @param secretPass // Contraseña segura del Socio
     * @return // Regresa true o false si ocurre un error
     */
    public boolean actionPerformedJModificarSocio(JTable jTableRSocio, Object[] jField, String A, String B, char[] secretPass) {
        int select = jTableRSocio.getSelectedRow();
        boolean err = false;
        SocioBean Bean = new SocioBean();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Socio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return err;
        }
        if (TEXT_CHECKER.checkNoNumberText(jField[0].toString() + jField[1].toString())
                && TEXT_CHECKER.checkDirection(jField[3].toString() + jField[4].toString() + jField[5].toString())
                && TEXT_CHECKER.checkPhoneNumber(jField[6].toString())
                && TEXT_CHECKER.checkEmail(jField[7].toString())) {
            if (select < 0) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
            } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
                Bean.setIdUsuario(Integer.parseInt(jTableRSocio.getValueAt(select, 0).toString()));
                Bean.setNombre(jField[0].toString());
                Bean.setApellidoP(jField[1].toString());
                Bean.setApellidoM(A);
                Bean.setEstatus(jField[2].toString());
                Bean.setEstado(jField[3].toString());
                Bean.setPrestamos(Integer.parseInt(jTableRSocio.getValueAt(select, 7).toString()));
                Bean.setMunicipio(jField[4].toString());
                Bean.setCalle(jField[5].toString());
                Bean.setNumero(B);
                Bean.setTelefono(jField[6].toString());
                Bean.setUsuario(jField[7].toString());
                if (ADM.ModificarSocio(Bean, secretPass)) {
                    String dir = Bean.getEstado() + " " + Bean.getMunicipio() + " " + Bean.getCalle() + " " + Bean.getNumero();
                    Object[] jFieldText = new Object[]{Bean.getNombre(), Bean.getApellidoP(), Bean.getApellidoM(), dir, Bean.getTelefono(), Bean.getEstatus(), Bean.getPrestamos(), Bean.getUsuario(), "**********"};
                    TABLE_HELPER.updateTableContentWith(jTableRSocio, jFieldText, select, 0);
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
        return err;
    }

    /**
     * Uso: Eliminar Socios.
     *
     * Descripción: Si la tabla está seleccionada consigue el id del socio y lo
     * envia a el dao correspondiente, si no muestra un JOptionPane con el
     * mensaje que le corresponde.
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
            if (ADM.EliminarSocio(id)) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
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
        boolean N = jSelect[0];
        boolean Ap = jSelect[1];
        boolean Am = jSelect[2];
        boolean U = jSelect[3];
        if (N && (!Am && !Ap && !U)) {
            action = 1;
        } else if (Ap && (!Am && !N && !U)) {
            action = 2;
        } else if (Am && (!N && !Ap && !U)) {
            action = 3;
        } else if (U && (!N && !Ap && !Am)) {
            action = 4;
        } else if (U && N && (!Ap && !Am)) {
            action = 5;
        } else if (Am && N && (!Ap && !U)) {
            action = 6;
        } else if (Ap && N && (!U && !Am)) {
            action = 7;
        } else if (Ap && Am && (!U && !N)) {
            action = 8;
        } else if (Ap && U && (!N && !Am)) {
            action = 9;
        } else if (U && Am && (!N && !Ap)) {
            action = 10;
        } else if (N && Ap && Am && (!U)) {
            action = 11;
        } else if (N && Ap && U && (!Am)) {
            action = 12;
        } else if (Ap && Am && U && (!N)) {
            action = 13;
        } else if (N && Am && U && (!Ap)) {
            action = 14;
        } else if (U && Am && N && Ap) {
            action = 15;
        }
        ADM.BuscarSocio(jModel, Bean, action);
    }

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Uso: Ingresar Autor.
     *
     * Descripción: Crea un nuevo autor bean y le ingresa los datos en los text
     * field, envia el bean al dao correspondiente, si es exitoso envia un
     * JOptionPane con texto correcto, si no es exitoso envia un texto erroneo.
     *
     * @param jModel // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     * @param m // Contiene el Apellido Materno del Autor, si es que tiene
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJIngresarAutor(DefaultTableModel jModel, Object[] jField, String m) {
        AutorBean Bean = new AutorBean();
        boolean err = false;
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Autor", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return err;
        }
        if (TEXT_CHECKER.checkNoNumberText(jField[0].toString() + jField[1].toString())) {
            Bean.setNombre(jField[0].toString());
            Bean.setApellidoP(jField[1].toString());
            Bean.setApellidoM(m);
            if (ADM.IngresarAutor(Bean)) {
                jModel.addRow(new Object[]{Bean.getIdAutor(), Bean.getNombre(), Bean.getApellidoP(), Bean.getApellidoM(), "Activo"});
                JOptionPane.showMessageDialog(null, "El Autor ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se agregó el Autor", "Error!", JOptionPane.ERROR_MESSAGE);
                return err;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
        return err;
    }

    /**
     * Uso: Modificar Autor.
     *
     * Descripción: Crea un nuevo autor bean, Si la tabla está seleccionada
     * consigue el id del autor seleccionado y lo ingresa en el bean con todos
     * los valores en los text field. Envia los datos al dao correspondiente, si
     * es exitoso envia un JOptionPane con texto correcto, si no es exitoso
     * envia un texto erroneo.
     *
     * @param jTableRAutor // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Text
     * @param m // Contiene el Apellido Materno del Autor, si es que tiene
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJModificarAutor(JTable jTableRAutor, Object[] jField, String m) {
        AutorBean Bean = new AutorBean();
        boolean err = false;
        int select = jTableRAutor.getSelectedRow();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Autor", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return err;
        }
        if (TEXT_CHECKER.checkNoNumberText(jField[0].toString() + jField[1].toString())) {
            if (select < 0) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
            } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
                Bean.setIdAutor(Integer.parseInt(jTableRAutor.getValueAt(select, 0).toString()));
                Bean.setNombre(jField[0].toString());
                Bean.setApellidoP(jField[1].toString());
                Bean.setApellidoM(m);
                Bean.setStatus(jField[2].toString());
                if (ADM.ModificarAutor(Bean)) {
                    Object[] jFieldText = new Object[]{Bean.getNombre(), Bean.getApellidoP(), Bean.getApellidoM(), Bean.getStatus()};
                    TABLE_HELPER.updateTableContentWith(jTableRAutor, jFieldText, select, 0);
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    return true;
                }
            }
            return err;
        } else {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
        return err;
    }

    /**
     * Uso: Eliminar Autor.
     *
     * Descripción: Si la tabla está seleccionada consigue el id del autor
     * seleccionado. Envia el id al dao correspondiente, si es exitoso envia un
     * JOptionPane con texto correcto, si no es exitoso envia un texto erroneo.
     *
     * @param jTableRAutor // Contiene el objeto de Tabla de la Vista
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJEliminarAutor(JTable jTableRAutor) {
        DefaultTableModel ae = (DefaultTableModel) jTableRAutor.getModel();
        int Select = jTableRAutor.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            int id = Integer.parseInt(jTableRAutor.getValueAt(Select, 0).toString());
            if (ADM.EliminarAutor(id)) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                return true;
            }
        }
        return false;
    }

    /**
     * Uso: Buscar Autor.
     *
     * Descripción: Crea un nuevo autor bean, ingresa los valores de los text
     * fiels en el bean y consigue la acción dependiendo de los combo box
     * seleccionados. Envia el bean y la acción al dao correspondiente.
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
        boolean N = jSelect[0];
        boolean Ap = jSelect[1];
        boolean Am = jSelect[2];
        if (N && (!Am && !Ap)) {
            action = 1;
        } else if (Ap && (!Am && !N)) {
            action = 2;
        } else if (Am && (!N && !Ap)) {
            action = 3;
        } else if (Ap && N && (!Am)) {
            action = 4;
        } else if (Am && N && (!Ap)) {
            action = 5;
        } else if (Am && Ap && (!N)) {
            action = 6;
        }
        ADM.BuscarAutor(jModel, Bean, action);
    }
}
