package Vista;

import Classes.Beans.SocioBean;
import Controlador.AsignarSocioControlador;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arekkuusu
 */
public class VAsignarSocio extends javax.swing.JFrame {

    private final SocioBean SocioBean;
    private final ArrayList ArrayList;

    public VAsignarSocio(SocioBean Bean, ArrayList Array) {
        initComponents();
        this.setResizable(false);
        LoadData(Bean, Array);
        this.SocioBean = Bean;
        this.ArrayList = Array;
        ////////////////////////////////////////////////////////////////////////
        JTableBLibro.setToolTipText("Libro Seleccionado Previamente");
        JTableBSocio.setToolTipText("Socio loggeado en el sistema");
        JAceptarAsignar.setForeground(Color.red);
        JAbortar.setForeground(Color.red);
    }

    private void LoadData(SocioBean Bean, ArrayList Array) {
        DefaultTableModel model = (DefaultTableModel) JTableBLibro.getModel();
        DefaultTableModel model0 = (DefaultTableModel) JTableBSocio.getModel();
        AsignarSocioControlador AsignarSocioControlador = new AsignarSocioControlador();
        AsignarSocioControlador.LoadData(new Object[]{model, model0, Bean, Array});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jIconLeeyAprende = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JAbortar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableBLibro = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableBSocio = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JAceptarAsignar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuOpciones = new javax.swing.JMenu();
        JMenuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Préstamos");

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        JAbortar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JAbortar.setText("Abortar");
        JAbortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAbortarActionPerformed(evt);
            }
        });

        JTableBLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "ISBN", "N° Pag", "Autor", "Editorial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableBLibro.setEnabled(false);
        JTableBLibro.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTableBLibro);

        JTableBSocio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Dirección", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableBSocio.setEnabled(false);
        JTableBSocio.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(JTableBSocio);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel1.setText("Asignando Libro:");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("A Socio:");

        JAceptarAsignar.setText("Aceptar");
        JAceptarAsignar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JAceptarAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAceptarAsignarActionPerformed(evt);
            }
        });

        JMenuOpciones.setText("Opciones");

        JMenuSalir.setText("Salir");
        JMenuOpciones.add(JMenuSalir);

        jMenuBar1.add(JMenuOpciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jIconLeeyAprende)
                        .addGap(116, 116, 116)
                        .addComponent(JAbortar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(JAceptarAsignar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIconLeeyAprende)
                    .addComponent(JAbortar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JAceptarAsignar)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JAceptarAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAceptarAsignarActionPerformed
        this.setVisible(false);
        AsignarSocioControlador AsignarSocioControlador = new AsignarSocioControlador();
        AsignarSocioControlador.actionPerformedJAceptarPrestamo(new Object[]{SocioBean, ArrayList});
    }//GEN-LAST:event_JAceptarAsignarActionPerformed

    private void JAbortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAbortarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_JAbortarActionPerformed

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
            java.util.logging.Logger.getLogger(VAsignarSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VAsignarSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VAsignarSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VAsignarSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JButton JAbortar;
    private javax.swing.JButton JAceptarAsignar;
    private javax.swing.JMenu JMenuOpciones;
    private javax.swing.JMenuItem JMenuSalir;
    public javax.swing.JTable JTableBLibro;
    public javax.swing.JTable JTableBSocio;
    private javax.swing.JLabel jIconLeeyAprende;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
