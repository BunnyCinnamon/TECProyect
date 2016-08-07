package Utils;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * Descripción: Autocompletar Textos con la información encontrada
 * 
 */
@CleanupDone
public class Autocompleter {

    TextAutoCompleter autocompleter;

    /**
     * Descripción: Añade los Textos encontrados y crea un nuevo Autocompleter
     * de un TextField.
     *
     * Variables:
     *
     * @param r // Text field para autocompletado
     * @param array // Contiene el objeto de Arrays
     */
    public Autocompleter(JTextField r, ArrayList<String> array) {
        this.autocompleter = new TextAutoCompleter(r);
        setTexts(array);
    }

    /**
     * Descripción: Añade los textos al autocompletado del TextField
     *
     * Variables:
     *
     * @param array // Contiene el objeto de Arrays
     */
    private void setTexts(ArrayList array) {
        autocompleter.addItems(array);
    }

}
