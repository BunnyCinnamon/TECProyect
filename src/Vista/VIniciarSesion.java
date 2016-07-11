package Vista;

import Controlador.IniciarSesionControlador;
import java.util.ResourceBundle;

/**
 *
 * @author Arekkuusu
 */
public class VIniciarSesion extends javax.swing.JFrame {

    private static String usuario;
    private static ResourceBundle propertiesLogins;

    public VIniciarSesion() {
        initComponents();
        this.setResizable(false);
        ReadFile();
    }

    private void ReadFile() {
        if (propertiesLogins == null) {
            propertiesLogins = ResourceBundle.getBundle("logins");
            try {
                if (propertiesLogins.getString("login").equals("true")) {
                    JRecordarUsuario.setSelected(true);
                    usuario = propertiesLogins.getString("usuario");
                    JUsuarioInicio.setText(usuario);
                } else if (!propertiesLogins.getString("login").equals("true") && !propertiesLogins.getString("login").equals("false")) {
                    JAnounce.setText("Error in configuration file: Cannot reach TRUE or FALSE value");
                }
            } catch (java.util.MissingResourceException e) {
                System.err.println("Error in configuration file: " + e.getMessage());
                JAnounce.setText("Error in configuration file: " + e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        JCodeWorkIcon = new javax.swing.JPanel();
        jIconCodeWork = new javax.swing.JLabel();
        JLeeyAprendeIcon = new javax.swing.JPanel();
        jIconLeeyAprende = new javax.swing.JLabel();
        jUsuario = new javax.swing.JLabel();
        jContraseña = new javax.swing.JLabel();
        JRecordarUsuario = new javax.swing.JCheckBox();
        JIngresar = new javax.swing.JButton();
        JUsuarioInicio = new javax.swing.JTextField();
        JContraseñaInicio = new javax.swing.JPasswordField();
        JSesionIcon = new javax.swing.JPanel();
        jIconSession = new javax.swing.JLabel();
        JAnounce = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jIconCodeWork.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Logo.jpg"))); // NOI18N

        javax.swing.GroupLayout JCodeWorkIconLayout = new javax.swing.GroupLayout(JCodeWorkIcon);
        JCodeWorkIcon.setLayout(JCodeWorkIconLayout);
        JCodeWorkIconLayout.setHorizontalGroup(
            JCodeWorkIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JCodeWorkIconLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jIconCodeWork)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        JCodeWorkIconLayout.setVerticalGroup(
            JCodeWorkIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JCodeWorkIconLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jIconCodeWork, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        javax.swing.GroupLayout JLeeyAprendeIconLayout = new javax.swing.GroupLayout(JLeeyAprendeIcon);
        JLeeyAprendeIcon.setLayout(JLeeyAprendeIconLayout);
        JLeeyAprendeIconLayout.setHorizontalGroup(
            JLeeyAprendeIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JLeeyAprendeIconLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jIconLeeyAprende)
                .addGap(18, 18, 18))
        );
        JLeeyAprendeIconLayout.setVerticalGroup(
            JLeeyAprendeIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jIconLeeyAprende, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jUsuario.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jUsuario.setText("Usuario");

        jContraseña.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jContraseña.setText("Contraseña");

        JRecordarUsuario.setText("Ingresar como Administrador");

        JIngresar.setText("Ingresar");
        JIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarActionPerformed(evt);
            }
        });

        jIconSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/key-icon.png"))); // NOI18N

        javax.swing.GroupLayout JSesionIconLayout = new javax.swing.GroupLayout(JSesionIcon);
        JSesionIcon.setLayout(JSesionIconLayout);
        JSesionIconLayout.setHorizontalGroup(
            JSesionIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jIconSession, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );
        JSesionIconLayout.setVerticalGroup(
            JSesionIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jIconSession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JCodeWorkIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLeeyAprendeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jUsuario)
                                    .addComponent(jContraseña))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JUsuarioInicio)
                                    .addComponent(JContraseñaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addComponent(JSesionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JRecordarUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JIngresar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JAnounce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JCodeWorkIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLeeyAprendeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jUsuario)
                            .addComponent(JUsuarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jContraseña)
                            .addComponent(JContraseñaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JSesionIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JIngresar)
                    .addComponent(JRecordarUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(JAnounce))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarActionPerformed
        IniciarSesionControlador IniciarSesionControlador = new IniciarSesionControlador();
        IniciarSesionControlador.actionPerformed(this);
    }//GEN-LAST:event_JIngresarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VIniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JAnounce;
    private javax.swing.JPanel JCodeWorkIcon;
    public javax.swing.JPasswordField JContraseñaInicio;
    public javax.swing.JButton JIngresar;
    private javax.swing.JPanel JLeeyAprendeIcon;
    public javax.swing.JCheckBox JRecordarUsuario;
    private javax.swing.JPanel JSesionIcon;
    public javax.swing.JTextField JUsuarioInicio;
    private javax.swing.JLabel jContraseña;
    private javax.swing.JLabel jIconCodeWork;
    private javax.swing.JLabel jIconLeeyAprende;
    private javax.swing.JLabel jIconSession;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jUsuario;
    // End of variables declaration//GEN-END:variables
}
