package Utils;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 * Descripción: Verificar contenido de Textos.
 *
 */
@CleanupDone
public class TextChecker {

    /**
     * Uso: Verificar Nombre Válido de Socio.
     *
     * Descripción: Reemplaza los espacios por underscores "_" y compara el
     * texto con un texto.
     *
     * Variables:
     *
     * @param a // Contiene el objeto String
     * @return // Regresa true o false si el texto coincide
     */
    public boolean ValidadorTexto(String a) {
        String replaceAll = a.replaceAll(" ", "_");
        Pattern pat = Pattern.compile("^[a-zA-Z_]*");
        Matcher mat = pat.matcher(replaceAll);
        return mat.matches();
    }

    /**
     * Verificar Número Válido de Socio.
     *
     * Descripción: Compara el texto con un número.
     *
     * Variables:
     *
     * @param a // Contiene el objeto String
     * @return // Regresa true o false si el texto coincide
     */
    public boolean ValidadorNumero(String a) {
        Pattern pat = Pattern.compile("[0-9]+");
        Matcher mat = pat.matcher(a);
        return mat.matches();
    }

    /**
     * Uso: Verificar Número Válido de Socio.
     *
     * Descripción: Compara el texto con un isbn.
     *
     * Variables:
     *
     * @param a // Contiene el objeto String
     * @return // Regresa true o false si el texto coincide
     */
    public boolean ValidadorISBN(String a) {
        Pattern pat = Pattern.compile("[0-9-]+");
        Matcher mat = pat.matcher(a);
        return mat.matches();
    }

    /**
     * Uso: Checar si los Textos son correctos. Si no validan, el texto se torna
     * rojo.
     *
     * Descripción: Valida el texto en el text field, y le asigna un color de
     * fondo dependiendo del resultado.
     *
     * Variables:
     *
     * @param JText // Contiene el objeto Text Field
     */
    public void checkColors(JTextField JText) {
        if (!ValidadorTexto(JText.getText())) {
            JText.setForeground(new Color(204, 0, 0));
        } else {
            JText.setForeground(Color.black);
        }
    }

    /**
     * Uso: Checar si los Textos son correctos.
     *
     * Descripción: Busca que cada objeto tenga un valor no nulo o vacio, si lo
     * tienen cambia su fondo a rojo.
     *
     * Variables:
     *
     * @param obj // Contiene los objetos Text Field
     */
    public void checkFieldsColors(Object[] obj) {
        for (Object obj1 : obj) {
            String text;
            Color col = new Color(255, 204, 255);
            if (obj1 instanceof JTextField) {
                JTextField field = (JTextField) obj1;
                text = field.getText();
                if (text.isEmpty()) {
                    field.setBackground(col);
                } else {
                    field.setBackground(Color.white);
                }
            } else if (obj1 instanceof JList) {
                JList field = (JList) obj1;
                if (field.getSelectedIndex() <= 0) {
                    field.setBackground(col);
                } else {
                    field.setBackground(Color.white);
                }
            } else if (obj1 instanceof JComboBox) {
                JComboBox field = (JComboBox) obj1;
                if (field.getSelectedIndex() <= 0) {
                    field.setBackground(col);
                } else {
                    field.setBackground(Color.white);
                }
            }
        }
    }

    /**
     * Uso: Checar si el texto tiene una longitud.
     *
     * Descripción: Contar los números dentro del texto, retorna true o false si
     * el texto tiene los números deseados.
     *
     * Variables:
     *
     * @param l // Contiene el objeto String
     * @param m // Primer condición
     * @param n // Segunda condición
     * @return // Regresa true si tiene la longitud esperada
     */
    public boolean checkLenght(String l, int m, int n) {
        int count = 0;
        for (int i = 0, len = l.length(); i < len; i++) {
            if (Character.isDigit(l.charAt(i))) {
                count++;
            }
        }
        return count == m || count == n;
    }

    /**
     * Uso: Checar si el Texto es email.
     *
     * Descripción: Compara el texto con un email.
     *
     * Variables:
     *
     * @param text // Contiene el objeto String
     * @return // Regresa true si tiene un email
     */
    public boolean checkEmail(String text) {
        Pattern pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(text);
        return mat.matches();
    }

    /**
     * Uso: Checar si los Textos son vacios.
     *
     * Descripción: Busca que el texto no mida 0 o sea 0.
     *
     * Variables:
     *
     * @param obj // Contiene los objetos Text Field
     * @return // Retorna true si el objeto esta vacio
     */
    public boolean checkIfEmpty(Object[] obj) {
        for (Object obj1 : obj) {
            String text = (String) obj1;
            if (text.isEmpty() || obj1.equals("0")) {
                return true;
            }
        }
        return false;
    }
}
