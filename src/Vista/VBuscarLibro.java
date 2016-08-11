package Vista;

import Classes.Beans.SocioBean;
import Controlador.BuscarLibroControlador;
import Controlador.CargarInfoControlador;
import Utils.Autocompleter;
import Utils.CleanupDone;
import Utils.TextChecker;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Descripción: Vista de BuscarLibro
 *
 */
@CleanupDone
public class VBuscarLibro extends javax.swing.JFrame {

    private static final TextChecker TEXT_CHECKER = new TextChecker();
    private static final BuscarLibroControlador BUSCAR_LIBRO_CONTROLER = new BuscarLibroControlador();

    /**
     * Descripción: Inicializa la Vista.
     *
     * @param Bean // Contiene el Bean de Socio
     */
    public VBuscarLibro(SocioBean Bean) {
        /**
         * VBuscar Libro*
         */
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
        SetBean(Bean);
        Iniciar();
        ////////////////////////////////////////////////////////////////////////
        JBuscarLibro.setToolTipText("Buscar Libro con datos parecidos");
        JAsignar.setToolTipText("Pedir Libro Seleccionado");
        JDetalles.setToolTipText("Ver las Estadísticas de Biblioteca");
        JNPagText.setToolTipText("Usuario loggeado al sistema");
        JNPagText.setText(Bean.getUsuario());
    }

    /**
     * Uso: Iniciar Página.
     *
     * Descripción: Crea un objeto Controlador, remueve cualquier texto
     * remanente en combo box y list, Carga la información a los mismos. Un
     * try-catch que llama al método de autocompletar.
     *
     */
    private void Iniciar() {
        CargarInfoControlador Cargar = new CargarInfoControlador();
        JListAutor.setListData(new String[0]);
        JListEditorial.setListData(new String[0]);
        try {
            loadAuto(Cargar.CargarTexts());
        } catch (java.lang.ExceptionInInitializerError ex) {
            System.err.println("Error in JTatoo file: " + ex.getLocalizedMessage());
        }
        /**
         * VRegistro de Libro*
         */
        JList[] jFieldList = new JList[]{JListAutor, JListEditorial};
        Cargar.CargarInfoListas(jFieldList);
    }

    /**
     * Cargar libreria Autocompleter. Si la libreria no se encuentra presente,
     * el programa inicia con normalidad pero sin las funciones de
     * autocompletado
     *
     * @param array // Contiene el array de textos encontrados
     */
    private void loadAuto(ArrayList array) throws java.lang.ExceptionInInitializerError {
        Autocompleter Autocompleter;
        Autocompleter = new Autocompleter(JTituloText, array);
    }

    /**
     * Uso: Limpiar todas las opciones a Default.
     *
     * Descripción: Busca por cada objeto y cambia su contenido a un default
     * establecido.
     *
     * @param jText // Contiene los objetos de opciones
     */
    private void clearTexts(Object[] jText) {
        for (Object c : jText) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            } else if (c instanceof JList) {
                ((JList) c).setSelectedIndex(0);
            } else if (c instanceof JComboBox) {
                ((JComboBox) c).setSelectedIndex(0);
            } else if (c instanceof JSpinner) {
                ((JSpinner) c).setValue(0);
            }
        }
    }

    /**
     * Bean de Socio*
     */
    private SocioBean Bean;

    private void SetBean(SocioBean Bean) {
        this.Bean = Bean;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jIconLeeyAprende = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableBLibro = new javax.swing.JTable();
        jRegistrarLibro = new javax.swing.JLabel();
        jTitulo = new javax.swing.JLabel();
        jISBN = new javax.swing.JLabel();
        JTituloText = new javax.swing.JTextField();
        JISBNText = new javax.swing.JTextField();
        jNPag = new javax.swing.JLabel();
        JNPagText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JListAutor = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JListEditorial = new javax.swing.JList<>();
        JTabbedBusquedaLibros = new javax.swing.JTabbedPane();
        JInternalBuscar = new javax.swing.JInternalFrame();
        JBuscarLibro = new javax.swing.JButton();
        JCheckTitulo = new javax.swing.JCheckBox();
        JCheckISBN = new javax.swing.JCheckBox();
        JCheckAutor = new javax.swing.JCheckBox();
        JCheckEditorial = new javax.swing.JCheckBox();
        JDetalles = new javax.swing.JButton();
        JInternalEditar1 = new javax.swing.JInternalFrame();
        jLabel5 = new javax.swing.JLabel();
        JAsignar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        JRegresar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        JRadioTableSelection = new javax.swing.JRadioButtonMenuItem();
        JRadioTableComplete = new javax.swing.JRadioButtonMenuItem();
        JClearTexts = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Búsqueda de Libros");

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        JTableBLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "ISBN", "Titulo", "N° Pag", "Estado", "Autor", "Editorial", "Localización", "Área", "Existencias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableBLibro.getTableHeader().setReorderingAllowed(false);
        JTableBLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableBLibroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableBLibro);

        jRegistrarLibro.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jRegistrarLibro.setText("Búsqueda de Libros");

        jTitulo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo.setText("Título:");

        jISBN.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN.setText("ISBN:");

        JTituloText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTituloTextKeyTyped(evt);
            }
        });

        JISBNText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JISBNTextKeyTyped(evt);
            }
        });

        jNPag.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag.setText("Usuario:");

        JNPagText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JNPagText.setEnabled(false);

        JListAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(JListAutor);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel1.setText("Autor");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("Editorial");

        JListEditorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(JListEditorial);

        JInternalBuscar.setVisible(true);

        JBuscarLibro.setText("Buscar");
        JBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBuscarLibroActionPerformed(evt);
            }
        });

        JCheckTitulo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckTitulo.setText("Título");

        JCheckISBN.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckISBN.setText("ISBN");

        JCheckAutor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckAutor.setText("Autor");

        JCheckEditorial.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckEditorial.setText("Editorial");

        JDetalles.setText("Estadisticas");
        JDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JInternalBuscarLayout = new javax.swing.GroupLayout(JInternalBuscar.getContentPane());
        JInternalBuscar.getContentPane().setLayout(JInternalBuscarLayout);
        JInternalBuscarLayout.setHorizontalGroup(
            JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCheckTitulo)
                    .addComponent(JCheckISBN)
                    .addComponent(JCheckAutor)
                    .addComponent(JCheckEditorial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBuscarLibro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JDetalles, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        JInternalBuscarLayout.setVerticalGroup(
            JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCheckTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCheckISBN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCheckAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCheckEditorial)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBuscarLibro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDetalles)
                .addContainerGap())
        );

        JTabbedBusquedaLibros.addTab("Buscar", JInternalBuscar);

        JInternalEditar1.setVisible(true);

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel5.setText("Selección:");

        JAsignar.setText("Detalles");
        JAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAsignarActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/IconLibros.png"))); // NOI18N

        javax.swing.GroupLayout JInternalEditar1Layout = new javax.swing.GroupLayout(JInternalEditar1.getContentPane());
        JInternalEditar1.getContentPane().setLayout(JInternalEditar1Layout);
        JInternalEditar1Layout.setHorizontalGroup(
            JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(JAsignar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        JInternalEditar1Layout.setVerticalGroup(
            JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar1Layout.createSequentialGroup()
                .addGroup(JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalEditar1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JAsignar))
                    .addComponent(jLabel6))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        JTabbedBusquedaLibros.addTab("Acciones", JInternalEditar1);

        JRegresar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JRegresar.setText("Regresar");
        JRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRegresarActionPerformed(evt);
            }
        });

        jMenu1.setText("Ventana");

        jMenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSalir);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Opciones");

        jMenu6.setText("Opciones de Tabla");

        JRadioTableSelection.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        JRadioTableSelection.setSelected(true);
        JRadioTableSelection.setText("Detalles de Tabla por Selección");
        jMenu6.add(JRadioTableSelection);

        JRadioTableComplete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        JRadioTableComplete.setText("Detalles de Tabla Completa");
        jMenu6.add(JRadioTableComplete);

        jMenu4.add(jMenu6);

        JClearTexts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        JClearTexts.setText("Limpiar todos los textos");
        JClearTexts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JClearTextsActionPerformed(evt);
            }
        });
        jMenu4.add(JClearTexts);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jRegistrarLibro)
                        .addGap(136, 136, 136)
                        .addComponent(jIconLeeyAprende)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jNPag)
                                    .addComponent(jISBN)
                                    .addComponent(jTitulo))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTituloText)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JISBNText, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                            .addComponent(JNPagText))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 198, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(9, 9, 9)
                        .addComponent(JTabbedBusquedaLibros)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jIconLeeyAprende)
                        .addComponent(JRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jRegistrarLibro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo)
                            .addComponent(JTituloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jISBN)
                            .addComponent(JISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNPag)
                            .addComponent(JNPagText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JTabbedBusquedaLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRegresarActionPerformed
        dispose();
    }//GEN-LAST:event_JRegresarActionPerformed

    private void JAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAsignarActionPerformed
        BUSCAR_LIBRO_CONTROLER.TABLE_HELPER.JTableMouseControlClickedRow(JTableBLibro);
    }//GEN-LAST:event_JAsignarActionPerformed

    private void JDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDetallesActionPerformed
        CargarInfoControlador Cargar = new CargarInfoControlador();
        Cargar.CargarInfoEstadisticas();
    }//GEN-LAST:event_JDetallesActionPerformed

    private void JBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBuscarLibroActionPerformed
        DefaultTableModel model = (DefaultTableModel) JTableBLibro.getModel();
        Object[] jField = new Object[]{JTituloText.getText(), JISBNText.getText(), JListEditorial.getSelectedValue(), JListAutor.getSelectedValue()};
        boolean[] jSelect = {JCheckTitulo.isSelected(), JCheckAutor.isSelected(), JCheckISBN.isSelected(), JCheckEditorial.isSelected()};
        if ((!TEXT_CHECKER.checkISBN(jField[1].toString()) && jSelect[2]) || (!TEXT_CHECKER.checkText(jField[0].toString()) && jSelect[0])) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z,ñ´] [0-9,-]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        BUSCAR_LIBRO_CONTROLER.actionPerformedJBuscarLibro(model, jField, jSelect);
    }//GEN-LAST:event_JBuscarLibroActionPerformed

    private void JTableBLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableBLibroMouseClicked
        if (evt.getClickCount() == 2) {
            Object[] jField = new Object[]{JISBNText, JTituloText, null, null, JListAutor, JListEditorial};
            BUSCAR_LIBRO_CONTROLER.TABLE_HELPER.JTableMouseDoubleClicked(JTableBLibro, jField, 3);
        } else if ((evt.getModifiers() & ActionEvent.ALT_MASK) == ActionEvent.ALT_MASK) {
            if (JRadioTableComplete.isSelected()) {
                BUSCAR_LIBRO_CONTROLER.TABLE_HELPER.JTableMouseControlClicked((DefaultTableModel) JTableBLibro.getModel());
            } else if (JRadioTableSelection.isSelected()) {
                BUSCAR_LIBRO_CONTROLER.TABLE_HELPER.JTableMouseControlClickedRow(JTableBLibro);
            }
        }
    }//GEN-LAST:event_JTableBLibroMouseClicked

    private void JTituloTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTituloTextKeyTyped
        TEXT_CHECKER.checkColors(JTituloText);
    }//GEN-LAST:event_JTituloTextKeyTyped

    private void JISBNTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JISBNTextKeyTyped
        if (evt.getKeyChar() == ' ') {
            evt.setKeyChar('-');
        }
        if (!TEXT_CHECKER.checkISBN(JISBNText.getText())) {
            JISBNText.setForeground(new Color(204, 0, 0));
        } else {
            JISBNText.setForeground(Color.black);
        }
    }//GEN-LAST:event_JISBNTextKeyTyped

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void JClearTextsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JClearTextsActionPerformed
        Object[] jText = {JTituloText, JISBNText, JListAutor, JListEditorial};
        clearTexts(jText);
    }//GEN-LAST:event_JClearTextsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JAsignar;
    private javax.swing.JButton JBuscarLibro;
    public javax.swing.JCheckBox JCheckAutor;
    public javax.swing.JCheckBox JCheckEditorial;
    public javax.swing.JCheckBox JCheckISBN;
    public javax.swing.JCheckBox JCheckTitulo;
    private javax.swing.JMenuItem JClearTexts;
    private javax.swing.JButton JDetalles;
    public javax.swing.JTextField JISBNText;
    private javax.swing.JInternalFrame JInternalBuscar;
    private javax.swing.JInternalFrame JInternalEditar1;
    public javax.swing.JList<String> JListAutor;
    public javax.swing.JList<String> JListEditorial;
    public javax.swing.JTextField JNPagText;
    private javax.swing.JRadioButtonMenuItem JRadioTableComplete;
    private javax.swing.JRadioButtonMenuItem JRadioTableSelection;
    private javax.swing.JButton JRegresar;
    private javax.swing.JTabbedPane JTabbedBusquedaLibros;
    public javax.swing.JTable JTableBLibro;
    public javax.swing.JTextField JTituloText;
    private javax.swing.JLabel jISBN;
    private javax.swing.JLabel jIconLeeyAprende;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JLabel jNPag;
    private javax.swing.JLabel jRegistrarLibro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jTitulo;
    // End of variables declaration//GEN-END:variables
}
