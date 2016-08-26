package Utils;

import Vista.VDynamicTable;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Uso: Maneja el flujo de información de Tablas entre Vistas y Controladores o
 * entre estas.
 *
 * Descripción: Controlador para Tablas
 *
 */
@CleanupDone
public class TableHelper {

    /**
     * Uso: Encontrar elementos de Tabla.
     *
     * Descripción: Consigue el tamaño del objeto y las columnas de la tabla.
     * Luego inserta el texto de la tabla en los objetos dados.
     *
     * @param jTable // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     * @param last // Columnas a ignorar al final de la Tabla
     */
    public void JTableMouseDoubleClicked(JTable jTable, Object[] jField, int last) {
        DefaultTableModel ae = (DefaultTableModel) jTable.getModel();
        int select = jTable.getSelectedRow();
        int start = ae.getColumnCount() - last;
        for (int i = 1; i < start; i++) {
            String n = jTable.getValueAt(select, i).toString();
            Object obj = jField[i - 1];
            if (obj instanceof JTextField) {
                JTextField text = (JTextField) obj;
                if (n.isEmpty()) {
                    text.setText("N/A");
                    text.setForeground(new Color(0, 153, 0));
                    continue;
                }
                text.setForeground(Color.black);
                text.setBackground(Color.white);
                text.setText(n);
            } else if (obj instanceof JSpinner) {
                JSpinner text = (JSpinner) obj;
                text.setValue(Integer.parseInt(n));
            } else if (obj instanceof JList) {
                JList text = (JList) obj;
                text.setBackground(Color.white);
                text.setSelectedValue(getExistingString(text, n), true);
            } else if (obj instanceof JComboBox) {
                JComboBox text = (JComboBox) obj;
                text.setBackground(Color.white);
                text.setSelectedItem(getExistingString(text, n));
            }
        }
    }

    /**
     * Uso: Encontrar elementos de Tabla.
     *
     * Descripción: Consigue el tamaño del objeto y las columnas de la tabla.
     * Luego inserta el texto de la tabla en los objetos dados.
     *
     * @param jTable // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     * @param jField0 // Contiene los objetos de Texto Complejos
     * @param last // Columnas a ignorar al final de la Tabla
     */
    public void JTableMouseDoubleClicked(JTable jTable, Object[] jField, Object[] jField0, int last) {
        DefaultTableModel ae = (DefaultTableModel) jTable.getModel();
        int select = jTable.getSelectedRow();
        int start = ae.getColumnCount() - last;
        for (int i = 1; i < start; i++) {
            Object obj = jField[i - 1];
            String n = jTable.getValueAt(select, i).toString();
            if (obj instanceof JTextField) {
                JTextField text = (JTextField) obj;
                if (n.isEmpty()) {
                    text.setText("N/A");
                    text.setForeground(new Color(0, 153, 0));
                    continue;
                }
                text.setText(n);
            } else if (obj instanceof JComboBox) {
                JComboBox text = (JComboBox) obj;
                text.setSelectedItem(getExistingString(text, jTable.getValueAt(select, i).toString()));
            } else if (obj == null) {
                if (((n.length() - n.replaceAll(" ", "").length() == 3))) {
                    int l = 0;
                    String[] array = getStringInText(n);
                    for (Object obj0 : jField0) {
                        ((JTextField) obj0).setText(array[l]);
                        l++;
                    }
                }
            }
        }
    }

    /**
     * Uso: Encontrar texto en la Tabla.
     *
     * Descripción: Consigue las columnas de la tabla. Luego inserta el texto de
     * la tabla en un array.
     *
     * @param jTable // Contiene el objeto Tabla de la Vista
     * @param canGet // Contiene las columnas que son true para conseguir su
     * información
     * @param last // Columnas a ignorar al final de la Tabla
     * @return // Array con texto de la Tabla
     */
    public ArrayList getTextFromSelectedTable(JTable jTable, boolean[] canGet, int last) {
        DefaultTableModel ae = (DefaultTableModel) jTable.getModel();
        int select = jTable.getSelectedRow();
        ArrayList jArray = new ArrayList();
        int start = ae.getColumnCount() - last;
        for (int i = 0; i < start; i++) {
            if (canGet[i]) {
                jArray.add(jTable.getValueAt(select, i).toString());
            }
        }
        return jArray;
    }

    /**
     * Uso: Encontrar texto separado por espacios.
     *
     * Descripción: Separa el texto en sus palabras.
     *
     * @param text // Contiene el texto
     * @param return // Regresa un Array con texto separado
     */
    private String[] getStringInText(String text) {
        return text.split(" ");
    }

    /**
     * Uso: Encontrar elementos de la Lista que sean equivalentes al texto de la
     * Tabla.
     *
     * Descripción: Busca la fila en un jlist que tenga el texto proporcionado.
     *
     * @param l // Contiene el objeto Combo Box
     * @param n // Contiene el Texto
     */
    private String getExistingString(JList l, String n) {
        for (int i = 0; i <= l.getVisibleRowCount(); i++) {
            l.setSelectedIndex(i);
            String n1 = l.getSelectedValue().toString();
            if (n1.endsWith(n)) {
                return n1;
            }
        }
        return "";
    }

    /**
     * Uso: Encontrar elementos del Combo Box que sean equivalentes al texto de
     * la Tabla.
     *
     * Descripción: Busca la fila en un jcombobox que tenga el texto
     * proporcionado.
     *
     * @param l // Contiene el objeto Combo Box
     * @param n // Contiene el Texto
     */
    private String getExistingString(JComboBox l, String n) {
        for (int i = 0; i < l.getItemCount(); i++) {
            l.setSelectedIndex(i);
            String n1 = l.getSelectedItem().toString();
            if (n1.endsWith(n)) {
                return n1;
            }
        }
        return "";
    }

    /**
     * Uso: Modificar Tabla.
     *
     * Descripción: Modifica la Tabla con los datos en los Objetos.
     *
     * @param jTable // Contiene el objeto Tabla de la Vista
     * @param jField // Contiene los objetos de Texto
     * @param select // Contiene la selección
     * @param last // Columnas a ignorar al final de la Tabla
     */
    public void updateTableContentWith(JTable jTable, Object[] jField, int select, int last) {
        DefaultTableModel ae = (DefaultTableModel) jTable.getModel();
        int start = ae.getColumnCount() - last;
        for (int i = 1; i < start; i++) {
            String string = jField[i - 1].toString();
            jTable.setValueAt(string, select, i);
        }
    }

    /**
     * Uso: Encontrar elementos de Tabla.
     *
     * Descripción: Consigue la tabla. Luego inserta el contenido de la tabla en
     * la tabla dinámica.
     *
     * @param jTable // Contiene el objeto Tabla de la Vista
     */
    public void JTableMouseControlClicked(DefaultTableModel jTable) {
        VDynamicTable vDynamic = new VDynamicTable(jTable);
        vDynamic.setLocationRelativeTo(null);
        vDynamic.setVisible(true);
    }

    /**
     * Uso: Encontrar elementos de Row de una Tabla.
     *
     * Descripción: Consigue la tabla. Luego inserta el contenido de la tabla en
     * la tabla dinámica.
     *
     * @param jTable // Contiene el objeto Tabla de la Vista
     */
    public void JTableMouseControlClickedRow(JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int Select = jTable.getSelectedRow();
        if (Select < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        } else {
            DefaultTableModel jModel = new DefaultTableModel();
            ArrayList jArray = new ArrayList();
            for (int i = 0; i < model.getColumnCount(); i++) {
                jArray.add(model.getValueAt(Select, i));
                jModel.addColumn(model.getColumnName(i));
            }
            jModel.addRow(jArray.toArray());
            VDynamicTable vDynamic = new VDynamicTable(jModel);
            vDynamic.setSize(1080, 170);
            vDynamic.setLocationRelativeTo(null);
            vDynamic.setVisible(true);
        }
    }

}
