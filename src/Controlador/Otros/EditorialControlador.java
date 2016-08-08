package Controlador.Otros;

import Classes.Beans.EditorialBean;
import Modelo.Otros.EditorialDAO;
import Utils.CleanupDone;
import Utils.TextChecker;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Descripción: Controlador para Editorial
 *
 */
@CleanupDone
public class EditorialControlador {

    private static final EditorialDAO ADM = new EditorialDAO();
    private static final TextChecker TEXT_CHECKER = new TextChecker();

    /**
     * Uso: Ingresar Editorial.
     *
     * Descripción: Crea un nuevo editorial bean y le ingresa los datos en los
     * text field, envia el bean al dao correspondiente, si es exitoso envia un
     * JOptionPane con texto correcto, si no es exitoso envia un texto erroneo.
     *
     * Variables:
     *
     * @param jField // Contiene el objeto Texto
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJIngresarEditorial(Object[] jField) {
        EditorialBean Bean = new EditorialBean();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos de la Editorial", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!TEXT_CHECKER.checkText(jField[0].toString())) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        Bean.setNombre(jField[0].toString());
        if (ADM.IngresarEditorial(Bean)) {
            JOptionPane.showMessageDialog(null, "La Editorial ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó la Editorial", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Uso: Modificar Editorial.
     *
     * Descripción: Crea un nuevo editorial bean, Si la tabla está seleccionada
     * consigue el id de la editorial seleccionada y lo ingresa en el bean con
     * todos los valores en los text field. Envia los datos al dao
     * correspondiente, si es exitoso envia un JOptionPane con texto correcto,
     * si no es exitoso envia un texto erroneo.
     *
     * Variables:
     *
     * @param jTableREditorial // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Text
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJModificarEditorial(JTable jTableREditorial, Object[] jField) {
        EditorialBean Bean = new EditorialBean();
        int Select = jTableREditorial.getSelectedRow();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos de la Editorial", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!TEXT_CHECKER.checkText(jField[0].toString())) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            Bean.setIdEditorial(Integer.parseInt(jTableREditorial.getValueAt(Select, 0).toString()));
            Bean.setNombre(jField[0].toString());
            Bean.setEstatus(jField[1].toString());
            if (ADM.ModificarEditorial(Bean)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                return true;
            }
        }
        return false;
    }

    /**
     * Uso: Eliminar Editorial.
     *
     * Descripción: Si la tabla está seleccionada consigue el id de la editorial
     * seleccionada. Envia el id al dao correspondiente, si es exitoso envia un
     * JOptionPane con texto correcto, si no es exitoso envia un texto erroneo.
     *
     * @param jTableREditorial // Contiene el objeto Tabla de la Vista
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJEliminarEditorial(JTable jTableREditorial) {
        DefaultTableModel ae = (DefaultTableModel) jTableREditorial.getModel();
        int Select = jTableREditorial.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            if (ADM.EliminarEditorial(Integer.parseInt(jTableREditorial.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                return true;
            }
        }
        return false;
    }

}
