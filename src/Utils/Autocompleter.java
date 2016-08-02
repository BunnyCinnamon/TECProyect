package Utils;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import javax.swing.JTextField;

@CleanupDone
/**
 * Autocompletar Textos con la información
 *
 */
public class Autocompleter {

    TextAutoCompleter autocompleter;

    /**
     * Muestra JOptionPane por segundos
     *
     * @param r // Text field para autocompletado
     * @param array // Contiene el objeto de Arrays
     */
    public Autocompleter(JTextField r, ArrayList<String> array) {
        this.autocompleter = new TextAutoCompleter(r);
        setTexts(array);
    }

    /**
     * Añade los textos al autocompletado
     *
     * @param array // Contiene el objeto de Arrays
     */
    private void setTexts(ArrayList array) {
        autocompleter.addItems(array);
    }

}
