package Utils;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

@CleanupDone
public class RunnableCode implements Runnable {

    @Override
    public void run() {
        timerJPane(2).start();
        JOptionPane.showOptionDialog(null, "Reiniciando...", "Restart", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
    }

    /**
     * Muestra JOptionPane por segundos
     *
     * @param n // Tiempo de vida del mensaje
     */
    private Timer timerJPane(int n) {
        ActionListener cerrar = (ActionEvent e) -> {
            Window[] wind = Window.getWindows();
            for (Window window : wind) {
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    if (dialog.getContentPane().getComponentCount() == 1
                            && dialog.getContentPane().getComponent(0) instanceof JOptionPane) {
                        dialog.dispose();
                    }
                }
            }
        };
        Timer t = new Timer(n * 1000, cerrar);
        t.setRepeats(false);
        return t;
    }

}
