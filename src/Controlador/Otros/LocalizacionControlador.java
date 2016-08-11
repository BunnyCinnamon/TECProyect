package Controlador.Otros;

import Classes.Beans.LocalizacionBean;
import Modelo.Otros.LocalizacionDAO;
import Utils.CleanupDone;
import Utils.TextChecker;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Descripción: Controlador para Localización
 *
 */
@CleanupDone
public class LocalizacionControlador {

    private static final LocalizacionDAO ADM = new LocalizacionDAO();
    private static final TextChecker TEXT_CHECKER = new TextChecker();

    /**
     * Uso: Ingresar Localizacion.
     *
     * Descripción: Crea un nuevo localizacion bean y le ingresa los datos en
     * los text field, envia el bean al dao correspondiente, si es exitoso envia
     * un JOptionPane con texto correcto, si no es exitoso envia un texto
     * erroneo.
     *
     * @param jField // Contiene el objeto Texto
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJIngresarLocalizacion(Object[] jField) {
        LocalizacionBean Bean = new LocalizacionBean();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos de Localización", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!TEXT_CHECKER.checkText(jField[0].toString())) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        Bean.setPasillo(jField[0].toString());
        if (ADM.IngresarLocalizacion(Bean)) {
            JOptionPane.showMessageDialog(null, "La Localización ha sido agregado de manera exitosa", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se agregó la Localización", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Uso: Modificar Localizacion.
     *
     * Descripción: Crea un nuevo localizacion bean, Si la tabla está
     * seleccionada consigue el id de la localizacion seleccionada y lo ingresa
     * en el bean con todos los valores en los text field. Envia los datos al
     * dao correspondiente, si es exitoso envia un JOptionPane con texto
     * correcto, si no es exitoso envia un texto erroneo.
     *
     * @param jTableRLocalizacion // Contiene el objeto de Tabla de la Vista
     * @param jField // Contiene los objetos Text
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJModificarLocalizacion(JTable jTableRLocalizacion, Object[] jField) {
        LocalizacionBean Bean = new LocalizacionBean();
        int Select = jTableRLocalizacion.getSelectedRow();
        if (TEXT_CHECKER.checkIfEmpty(jField)) {
            JOptionPane.showMessageDialog(null, "Ingresa todos los datos de Localización", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!TEXT_CHECKER.checkText(jField[0].toString())) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Modificar el registro? ")) {
            Bean.setIdLocalización(Integer.parseInt(jTableRLocalizacion.getValueAt(Select, 0).toString()));
            Bean.setPasillo(jField[0].toString());
            Bean.setEstatus(jField[1].toString());
            if (ADM.ModificarLocalizacion(Bean)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                return true;
            }
        }
        return false;
    }

    /**
     * Uso: Eliminar Localizacion.
     *
     * Descripción: Si la tabla está seleccionada consigue el id de la
     * Localizacion seleccionada. Envia el id al dao correspondiente, si es
     * exitoso envia un JOptionPane con texto correcto, si no es exitoso envia
     * un texto erroneo.
     *
     * @param jTableRLocalizacion // Contiene el objeto Tabla de la Vista
     * @return // Retorna false o true si ocurre o no un error
     */
    public boolean actionPerformedJEliminarLocalizacion(JTable jTableRLocalizacion) {
        DefaultTableModel ae = (DefaultTableModel) jTableRLocalizacion.getModel();
        int Select = jTableRLocalizacion.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ")) {
            if (ADM.EliminarLocalizacion(Integer.parseInt(jTableRLocalizacion.getValueAt(Select, 0).toString()))) {
                ae.removeRow(Select);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                return true;
            }
        }
        return false;
    }
}
