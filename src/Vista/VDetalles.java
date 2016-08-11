package Vista;

import Utils.CleanupDone;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Descripción: Vista de Detalles
 *
 */
@CleanupDone
public class VDetalles extends javax.swing.JFrame {

    /**
     * Descripción: Inicializa la Vista
     */
    public VDetalles() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent ev) {
//                dispose();
//            }
//        });
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon.png")).getImage());
    }

    /**
     * Descripción: Inserta texto en el Titulo y Array a Detalles.
     *
     * @param Titulo // Título de la vista
     * @param A // Array list con la información encontrada
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
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMenuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detalles");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/IconBookshelf.png"))); // NOI18N

        JTitulo.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        JTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JTitulo.setText("SU BASE DE DATOS ESTA VACIA");

        JTitulo0.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        JTitulo0.setForeground(new java.awt.Color(0, 153, 153));
        JTitulo0.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JTitulo0.setText("TITLE");

        JDesc0.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JDesc0.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JDesc0.setText("DESCRIPTION");

        JTitulo1.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        JTitulo1.setForeground(new java.awt.Color(0, 153, 153));
        JTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JTitulo1.setText("TITLE");

        JDesc1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JDesc1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JDesc1.setText("DESCRIPTION");

        JTitulo2.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        JTitulo2.setForeground(new java.awt.Color(0, 153, 153));
        JTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JTitulo2.setText("TITLE");

        JDesc2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JDesc2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JDesc2.setText("DESCRIPTION");

        JTitulo3.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
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

        JTitulo4.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        JTitulo4.setForeground(new java.awt.Color(0, 153, 153));
        JTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JTitulo4.setText("TITLE");

        JDesc4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JDesc4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JDesc4.setText("DESCRIPTION");

        jMenu1.setText("Ventana");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JMenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        JMenuSalir.setText("Salir");
        JMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(JMenuSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(88, 88, 88)
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
                    .addComponent(JDesc4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator5))
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
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(JTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDesc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(JTitulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDesc2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(JTitulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDesc3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
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
        dispose();
    }//GEN-LAST:event_JTerminadoActionPerformed

    private void JMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuSalirActionPerformed
        dispose();
    }//GEN-LAST:event_JMenuSalirActionPerformed

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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
