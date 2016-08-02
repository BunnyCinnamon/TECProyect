package Controlador;

import Utils.CleanupDone;
import Utils.RunnableCode;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

@CleanupDone
public class SalirControlador {

    /**
     * Crea un nuevo Runnable y captura errores del método que controla
     *
     */
    public void actionPerformed() {
        Runnable run = new RunnableCode();
        try {
            reiniciarApli(run);
        } catch (IOException ex) {
            Logger.getLogger(SalirControlador.class.getName()).log(Level.SEVERE, "Error al Reiniciar:", ex);
        }
    }

    public static final String SUN_JAVA_COMMAND = "sun.java.command";

    /**
     * Reinicia la aplicación en ejecución con todas sus características
     *
     * @param run // Código para correr en reinicio
     * @throws IOException
     */
    public static void reiniciarApli(Runnable run) throws IOException {
        try {
            String java = System.getProperty("java.home") + "/bin/java";
            List<String> vmArgumentos = ManagementFactory.getRuntimeMXBean().getInputArguments();
            StringBuffer vmArgsOneLine = new StringBuffer();
            vmArgumentos.stream().filter((arg) -> (!arg.contains("-agentlib"))).map((arg) -> {
                vmArgsOneLine.append(arg);
                return arg;
            }).forEach((_item) -> {
                vmArgsOneLine.append(" ");
            });
            final StringBuffer cmd = new StringBuffer("\"" + java + "\" " + vmArgsOneLine);
            String[] comando = System.getProperty(SUN_JAVA_COMMAND).split(" ");
            if (comando[0].endsWith(".jar")) {
                cmd.append("-jar ").append(new File(comando[0]).getPath());
            } else {
                cmd.append("-cp \"").append(System.getProperty("java.class.path")).append("\" ").append(comando[0]);
            }
            for (int i = 1; i < comando.length; i++) {
                cmd.append(" ");
                cmd.append(comando[i]);
            }
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    try {
                        Runtime.getRuntime().exec(cmd.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            if (run != null) {
                run.run();
            }

            System.exit(0);
        } catch (Exception e) {
            throw new IOException("Error while trying to restart the application", e);
        }
    }
}
