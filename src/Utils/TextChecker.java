package Utils;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

@CleanupDone
/**
 * Verificar contenido de Textos
 *
 */
public class TextChecker {

    /**
     * Verificar Nombre Válido de Socio
     *
     * @param a // Contiene el objeto String
     * @return
     */
    public boolean ValidadorTexto(String a) {
        Pattern pat = Pattern.compile("^[a-zA-Z]*");
        Matcher mat = pat.matcher(a);
        return mat.matches();
    }

    /**
     * Verificar Número Válido de Socio
     *
     * @param a // Contiene el objeto String
     * @return
     */
    public boolean ValidadorNumero(String a) {
        Pattern pat = Pattern.compile("[0-9]+");
        Matcher mat = pat.matcher(a);
        return mat.matches();
    }

    /**
     * Checar si los Textos son correctos
     *
     * @param JText // Contiene el objeto Text Field
     */
    public void checkColors(JTextField JText) {
        if (!ValidadorTexto(JText.getText())) {
            JText.setForeground(Color.red);
        } else {
            JText.setForeground(Color.black);
        }
    }

    /**
     * Checar si los Textos son correctos
     *
     * @param text // Contiene el objeto String
     * @return
     */
    public boolean checkEmail(String text) {
        Pattern pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(text);
        return mat.matches();
    }
    
    /**
     * Checar si los Textos son vacios
     *
     * @param obj // Contiene los objetos Text Field
     * @return
     */
    public boolean checkIfEmpty(Object[] obj) {
        for (Object obj1 : obj) {
            if (obj1.equals("") || obj1.equals("0")) {
                return true;
            }
        }
        return false;
    }
}
