package Vista;

import java.util.ArrayList;

/**
 *
 * @author Arekkuusu
 */
public class VDetalles extends javax.swing.JFrame {

    /**
     * Creates new form Detalles
     */
    public VDetalles() {
        initComponents();
        this.setResizable(false);
    }

    /**
     * Creates new form Detalles
     *
     * @param Titulo
     * @param A
     */
    public void LoadData(String Titulo, ArrayList A) {
        JTitulo.setText(Titulo);
        JTitulo0.setText(A.get(0).toString());
        JDesc0.setText(A.get(1).toString());
        JTitulo1.setText(A.get(2).toString());
        JDesc1.setText(A.get(3).toString());
        JTitulo2.setText(A.get(4).toString());
        JDesc2.setText(A.get(5).toString());
        JTitulo3.setText(A.get(6).toString());
        JDesc3.setText(A.get(7).toString());
        JTitulo4.setText(A.get(8).toString());
        JDesc4.setText(A.get(9).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        JTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JTitulo0 = new javax.swing.JLabel();
        JDesc0 = new javax.swing.JLabel();
        JTitulo1 = new javax.swing.JLabel();
        JDesc1 = new javax.swing.JLabel();
        JTitulo2 = new javax.swing.JLabel();
        JDesc2 = new javax.swing.JLabel();
        JTitulo3 = new javax.swing.JLabel();
        JDesc3 = new javax.swing.JLabel();
        JTerminado = new javax.swing.JButton();
        JTitulo4 = new javax.swing.JLabel();
        JDesc4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMenuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1467286183_bookshelf.png"))); // NOI18N

        JTitulo.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        JTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JTitulo.setText("SU BASE DE DATOS ESTA VACIA");

        JTitulo0.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JTitulo0.setForeground(new java.awt.Color(0, 153, 153));
        JTitulo0.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JTitulo0.setText("TITLE");

        JDesc0.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JDesc0.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JDesc0.setText("DESCRIPTION");

        JTitulo1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JTitulo1.setForeground(new java.awt.Color(0, 153, 153));
        JTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JTitulo1.setText("TITLE");

        JDesc1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JDesc1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JDesc1.setText("DESCRIPTION");

        JTitulo2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JTitulo2.setForeground(new java.awt.Color(0, 153, 153));
        JTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JTitulo2.setText("TITLE");

        JDesc2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JDesc2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JDesc2.setText("DESCRIPTION");

        JTitulo3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JTitulo3.setForeground(new java.awt.Color(0, 153, 153));
        JTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JTitulo3.setText("TITLE");

        JDesc3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JDesc3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JDesc3.setText("DESCRIPTION");

        JTerminado.setText("Terminado");
        JTerminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTerminadoActionPerformed(evt);
            }
        });

        JTitulo4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JTitulo4.setForeground(new java.awt.Color(0, 153, 153));
        JTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JTitulo4.setText("TITLE");

        JDesc4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JDesc4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JDesc4.setText("DESCRIPTION");

        jMenu1.setText("Opciones");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JMenuSalir.setText("Salir");
        jMenu1.add(JMenuSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 130, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(39, 39, 39)
                        .addComponent(JTerminado))
                    .addComponent(JTitulo0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JDesc0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JDesc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JDesc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTitulo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JDesc3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JDesc4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(JTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTitulo0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDesc0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDesc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTitulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDesc2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTitulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDesc3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTitulo4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDesc4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(JTerminado))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTerminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTerminadoActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_JTerminadoActionPerformed

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
            java.util.logging.Logger.getLogger(VDetalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VDetalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VDetalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VDetalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VDetalles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JDesc0;
    public javax.swing.JLabel JDesc1;
    public javax.swing.JLabel JDesc2;
    public javax.swing.JLabel JDesc3;
    public javax.swing.JLabel JDesc4;
    private javax.swing.JMenuItem JMenuSalir;
    private javax.swing.JButton JTerminado;
    public javax.swing.JLabel JTitulo;
    public javax.swing.JLabel JTitulo0;
    public javax.swing.JLabel JTitulo1;
    public javax.swing.JLabel JTitulo2;
    public javax.swing.JLabel JTitulo3;
    public javax.swing.JLabel JTitulo4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
