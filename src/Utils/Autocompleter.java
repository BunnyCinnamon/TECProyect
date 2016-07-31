package Utils;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import javax.swing.JTextField;

@CleanupDone
public class Autocompleter {

    TextAutoCompleter autocompleter;

    public Autocompleter(JTextField r, ArrayList<String> array) {
        this.autocompleter = new TextAutoCompleter(r);
        setTexts(array);
    }

    private void setTexts(ArrayList array) {
        autocompleter.addItems(array);
    }

}
