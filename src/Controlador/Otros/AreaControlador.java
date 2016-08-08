package Controlador.Otros;

import Classes.Beans.AreaBean;
import Modelo.Otros.AreaDAO;
import Utils.CleanupDone;
import Utils.TextChecker;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Descripción: Controlador para Área
 *
 */
@CleanupDone
public class AreaControlador {

    private static final AreaDAO ADM = new AreaDAO();
    private static final TextChecker TEXT_CHECKER = new TextChecker();

    /**
     * Uso: Ingresar Area.
     *
     * Descripción: Crea un nuevo area bean y le ingresa los datos en los text
     * field, envia el bean al dao correspondiente, si es exitoso envia un
     * JOptionPane con texto correcto, si no es exitoso envia un texto erroneo.
     *
     * Variables:
     *
     * @param jField // Contiene el objeto Texto
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJIngresarArea(Object[] jField) {
        AreaBean Bean = new AreaBean();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Área", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!TEXT_CHECKER.checkText(jField[0].toString())) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        Bean.setSeccion(jField[0].toString());
        if (ADM.IngresarArea(Bean)) {
            JOptionPane.showMessageDialog(null, "El Área ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó el Área", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Uso: Modificar Area.
     *
     * Descripción: Crea un nuevo area bean, Si la tabla está seleccionada
     * consigue el id de la area seleccionada y lo ingresa en el bean con todos
     * los valores en los text field. Envia los datos al dao correspondiente, si
     * es exitoso envia un JOptionPane con texto correcto, si no es exitoso
     * envia un texto erroneo.
     *
     * Variables:
     *
     * @param jTableRArea // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Text
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJModificarArea(JTable jTableRArea, Object[] jField) {
        AreaBean Bean = new AreaBean();
        int Select = jTableRArea.getSelectedRow();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos del Área", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!TEXT_CHECKER.checkText(jField[0].toString())) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            Bean.setIdArea(Integer.parseInt(jTableRArea.getValueAt(Select, 0).toString()));
            Bean.setSeccion(jField[0].toString());
            Bean.setEstatus(jField[1].toString());
            if (ADM.ModificarArea(Bean)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                return true;
            }
        }
        return false;
    }

    /**
     * Uso: Eliminar Area.
     *
     * Descripción: Si la tabla está seleccionada consigue el id de la area
     * seleccionada. Envia el id al dao correspondiente, si es exitoso envia un
     * JOptionPane con texto correcto, si no es exitoso envia un texto erroneo.
     *
     * Variables:
     *
     * @param jTableRArea // Contiene el objeto Tabla de la Vista
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJEliminarArea(JTable jTableRArea) {
        DefaultTableModel ae = (DefaultTableModel) jTableRArea.getModel();
        int Select = jTableRArea.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            if (ADM.EliminarArea(Integer.parseInt(jTableRArea.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                return true;
            }
        }
        return false;
    }

}
