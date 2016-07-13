package Vista;

import Classes.Beans.SocioBean;
import Controlador.OpcionesControladorSocio;
import Controlador.SalirControlador;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Arekkuusu
 */
public class VOpcionesSocio extends javax.swing.JFrame {

    /**
     * Creates new form Opciones
     *
     * @param Bean
     */
    public VOpcionesSocio(SocioBean Bean) {
        initComponents();
        this.setResizable(false);
        SetBean(Bean);
    }
    
    private static SocioBean Bean;

    private void SetBean(SocioBean Bean){
        this.Bean=Bean;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jIconLeeyAprende = new javax.swing.JLabel();
        JModificarLibros = new javax.swing.JPanel();
        JLibrosOpen = new javax.swing.JLabel();
        JVerContabilidad = new javax.swing.JPanel();
        JPrestamosOpen = new javax.swing.JLabel();
        jLibros = new javax.swing.JLabel();
        jPrestamos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMenuCerrarSesion = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Socio");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        JLibrosOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1467285836_OFFice-33.png"))); // NOI18N
        JLibrosOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLibrosOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLibrosOpenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JModificarLibrosLayout = new javax.swing.GroupLayout(JModificarLibros);
        JModificarLibros.setLayout(JModificarLibrosLayout);
        JModificarLibrosLayout.setHorizontalGroup(
            JModificarLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLibrosOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JModificarLibrosLayout.setVerticalGroup(
            JModificarLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLibrosOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JPrestamosOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1467284813_OFFice-90.png"))); // NOI18N
        JPrestamosOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JPrestamosOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPrestamosOpenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JVerContabilidadLayout = new javax.swing.GroupLayout(JVerContabilidad);
        JVerContabilidad.setLayout(JVerContabilidadLayout);
        JVerContabilidadLayout.setHorizontalGroup(
            JVerContabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPrestamosOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JVerContabilidadLayout.setVerticalGroup(
            JVerContabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPrestamosOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLibros.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLibros.setText("Libros");

        jPrestamos.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPrestamos.setText("Préstamos");

        jMenu1.setText("Opciones");

        JMenuCerrarSesion.setText("Cerrar Sesión");
        JMenuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(JMenuCerrarSesion);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jIconLeeyAprende)
                .addContainerGap(315, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLibros))
                    .addComponent(JModificarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JVerContabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(202, 202, 202))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jIconLeeyAprende)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JModificarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLibros))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JVerContabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPrestamos)))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JLibrosOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLibrosOpenMouseClicked
        OpcionesControladorSocio OpcionesControlador = new OpcionesControladorSocio();
        OpcionesControlador.actionPerformedJLibrosOpen(Bean);
    }//GEN-LAST:event_JLibrosOpenMouseClicked

    private void JPrestamosOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPrestamosOpenMouseClicked
        OpcionesControladorSocio OpcionesControlador = new OpcionesControladorSocio();
        OpcionesControlador.actionPerformedJPrestamosOpen(Bean);
    }//GEN-LAST:event_JPrestamosOpenMouseClicked

    private void JMenuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuCerrarSesionActionPerformed
        SalirControlador SalirControlador = new SalirControlador();
        SalirControlador.actionPerformed(evt);
        this.setVisible(false);
    }//GEN-LAST:event_JMenuCerrarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VOpcionesSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VOpcionesSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VOpcionesSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VOpcionesSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JLibrosOpen;
    private javax.swing.JMenuItem JMenuCerrarSesion;
    private javax.swing.JPanel JModificarLibros;
    public javax.swing.JLabel JPrestamosOpen;
    private javax.swing.JPanel JVerContabilidad;
    private javax.swing.JLabel jIconLeeyAprende;
    private javax.swing.JLabel jLibros;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JLabel jPrestamos;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
