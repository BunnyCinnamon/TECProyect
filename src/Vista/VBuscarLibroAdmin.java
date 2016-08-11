package Vista;

import Classes.Beans.AdministradorBean;
import Controlador.AdministradorControlador;
import Controlador.BuscarLibroControladorAdmin;
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
 * Descripción: Vista de Buscar Libros, búsqueda y préstamo de libros
 *
 */
@CleanupDone
public class VBuscarLibroAdmin extends javax.swing.JFrame {

    private static final TextChecker TEXT_CHECKER = new TextChecker();
    private static final AdministradorControlador ADMINISTRADOR_CONTROLER = new AdministradorControlador();
    private static final BuscarLibroControladorAdmin BUSCAR_LIBRO_CONTROLER = new BuscarLibroControladorAdmin();

    /**
     * Descripción: Inicializa la Vista.
     *
     * @param Bean // Contiene el Bean de Administrador
     */
    public VBuscarLibroAdmin(AdministradorBean Bean) {
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
        SetToolTipText();
        JNPagText.setText(Bean.getUsuario());
    }

    private void SetToolTipText() {
        JBuscarLibro.setToolTipText("Buscar Libro");
        JDetalles.setToolTipText("Pedir Información del Libro Seleccionado");
        JEstadisticas.setToolTipText("Ver las Estadísticas de Biblioteca");
        JNPagText.setToolTipText("Su Username");
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
            System.err.println("Error in JAutocompleter file: " + ex.getLocalizedMessage());
        }
        /**
         * VRegistro de Libro*
         */
        JList[] jFieldList = new JList[]{JListAutor, JListEditorial};
        Cargar.CargarInfoListas(jFieldList);
    }

    /**
     * Uso: Cargar libreria Autocompleter.
     *
     * Descripción: Si la libreria no se encuentra presente, el programa inicia
     * con normalidad pero sin las funciones de autocompletado.
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
     * Bean de Administrador*
     */
    private AdministradorBean BeanA;

    private void SetBean(Object Bean) {
        if (Bean instanceof AdministradorBean) {
            this.BeanA = (AdministradorBean) Bean;
        } else {
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jIconLeeyAprende = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jRegistrarLibro = new javax.swing.JLabel();
        JRegresar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jTitulo = new javax.swing.JLabel();
        jISBN = new javax.swing.JLabel();
        JTituloText = new javax.swing.JTextField();
        JISBNText = new javax.swing.JTextField();
        jNPag = new javax.swing.JLabel();
        JNPagText = new javax.swing.JTextField();
        JTabbedBusquedaLibros = new javax.swing.JTabbedPane();
        JInternalBuscar = new javax.swing.JInternalFrame();
        JBuscarLibro = new javax.swing.JButton();
        JCheckTitulo = new javax.swing.JCheckBox();
        JCheckISBN = new javax.swing.JCheckBox();
        JCheckAutor = new javax.swing.JCheckBox();
        JCheckEditorial = new javax.swing.JCheckBox();
        JEstadisticas = new javax.swing.JButton();
        JInternalEditar1 = new javax.swing.JInternalFrame();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JDetalles = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JListAutor = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JListEditorial = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableBLibro = new javax.swing.JTable();
        JInternalSocio = new javax.swing.JInternalFrame();
        jTitulo1 = new javax.swing.JLabel();
        jISBN1 = new javax.swing.JLabel();
        jNPag1 = new javax.swing.JLabel();
        JApellidoMTextSocio = new javax.swing.JTextField();
        JApellidoPTextSocio = new javax.swing.JTextField();
        JNombreTextSocio = new javax.swing.JTextField();
        JTabbedBusquedaSocios = new javax.swing.JTabbedPane();
        JInternalBuscar1 = new javax.swing.JInternalFrame();
        JCheckNombre = new javax.swing.JCheckBox();
        JCheckApellidoP = new javax.swing.JCheckBox();
        JCheckApellidoM = new javax.swing.JCheckBox();
        JBuscarSocio = new javax.swing.JButton();
        JCheckUsuario = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTableRSocio = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        JTextUsuario = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jISBN7 = new javax.swing.JLabel();
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

        jRegistrarLibro.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jRegistrarLibro.setText("Búsqueda de Libros");

        JRegresar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JRegresar.setText("Regresar");
        JRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRegresarActionPerformed(evt);
            }
        });

        jInternalFrame1.setVisible(true);

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

        JEstadisticas.setText("Estadisticas");
        JEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEstadisticasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JInternalBuscarLayout = new javax.swing.GroupLayout(JInternalBuscar.getContentPane());
        JInternalBuscar.getContentPane().setLayout(JInternalBuscarLayout);
        JInternalBuscarLayout.setHorizontalGroup(
            JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalBuscarLayout.createSequentialGroup()
                        .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCheckAutor)
                            .addComponent(JCheckEditorial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JEstadisticas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JBuscarLibro, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(JInternalBuscarLayout.createSequentialGroup()
                        .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCheckTitulo)
                            .addComponent(JCheckISBN))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JInternalBuscarLayout.setVerticalGroup(
            JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCheckTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JBuscarLibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JEstadisticas))
                    .addGroup(JInternalBuscarLayout.createSequentialGroup()
                        .addComponent(JCheckISBN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCheckAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCheckEditorial)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTabbedBusquedaLibros.addTab("Buscar", JInternalBuscar);

        JInternalEditar1.setVisible(true);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/IconLibros.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel5.setText("Selección:");

        JDetalles.setText("Asignar Libro");
        JDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JInternalEditar1Layout = new javax.swing.GroupLayout(JInternalEditar1.getContentPane());
        JInternalEditar1.getContentPane().setLayout(JInternalEditar1Layout);
        JInternalEditar1Layout.setHorizontalGroup(
            JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalEditar1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        JInternalEditar1Layout.setVerticalGroup(
            JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar1Layout.createSequentialGroup()
                .addGroup(JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(JInternalEditar1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDetalles)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JTabbedBusquedaLibros.addTab("Acciones", JInternalEditar1);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel1.setText("Autor");

        JListAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(JListAutor);

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("Editorial");

        JListEditorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(JListEditorial);

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

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jISBN)
                                    .addComponent(jTitulo))
                                .addGap(26, 26, 26)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTituloText, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jNPag)
                                        .addGap(18, 18, 18)
                                        .addComponent(JNPagText, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JTabbedBusquedaLibros)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo)
                            .addComponent(JTituloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jISBN)
                            .addComponent(JISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNPag)
                            .addComponent(JNPagText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(JTabbedBusquedaLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Libros", jInternalFrame1);

        JInternalSocio.setVisible(true);

        jTitulo1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo1.setText("Nombre:");

        jISBN1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN1.setText("Primero:");

        jNPag1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag1.setText("Segundo:");

        JApellidoMTextSocio.setForeground(new java.awt.Color(0, 153, 0));
        JApellidoMTextSocio.setText("Campo no Obligatorio");
        JApellidoMTextSocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JApellidoMTextSocioMouseClicked(evt);
            }
        });
        JApellidoMTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JApellidoMTextSocioKeyTyped(evt);
            }
        });

        JApellidoPTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JApellidoPTextSocioKeyTyped(evt);
            }
        });

        JNombreTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JNombreTextSocioKeyTyped(evt);
            }
        });

        JInternalBuscar1.setVisible(true);

        JCheckNombre.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckNombre.setText("Nombre");

        JCheckApellidoP.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoP.setText("Segundo Apellido");

        JCheckApellidoM.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoM.setText("Primer Apellido");

        JBuscarSocio.setText("Buscar");
        JBuscarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBuscarSocioActionPerformed(evt);
            }
        });

        JCheckUsuario.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckUsuario.setText("Usuario");

        javax.swing.GroupLayout JInternalBuscar1Layout = new javax.swing.GroupLayout(JInternalBuscar1.getContentPane());
        JInternalBuscar1.getContentPane().setLayout(JInternalBuscar1Layout);
        JInternalBuscar1Layout.setHorizontalGroup(
            JInternalBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalBuscar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalBuscar1Layout.createSequentialGroup()
                        .addComponent(JCheckUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBuscarSocio))
                    .addGroup(JInternalBuscar1Layout.createSequentialGroup()
                        .addGroup(JInternalBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCheckNombre)
                            .addComponent(JCheckApellidoP)
                            .addComponent(JCheckApellidoM))
                        .addGap(0, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JInternalBuscar1Layout.setVerticalGroup(
            JInternalBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCheckNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCheckApellidoM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCheckApellidoP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JInternalBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCheckUsuario)
                    .addComponent(JBuscarSocio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTabbedBusquedaSocios.addTab("Buscar", JInternalBuscar1);

        JTableRSocio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido Paterno", "Apellido Materno", "Dirección", "Teléfono", "Estatus", "Préstamos", "Usuario", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRSocio.getTableHeader().setReorderingAllowed(false);
        JTableRSocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableRSocioMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(JTableRSocio);

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel3.setText("Usuario:");

        JTextUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTextUsuarioKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel16.setText("Socio");

        jISBN7.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN7.setText("Apellido(s):");

        javax.swing.GroupLayout JInternalSocioLayout = new javax.swing.GroupLayout(JInternalSocio.getContentPane());
        JInternalSocio.getContentPane().setLayout(JInternalSocioLayout);
        JInternalSocioLayout.setHorizontalGroup(
            JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addComponent(jNPag1)
                                .addGap(18, 18, 18)
                                .addComponent(JApellidoMTextSocio, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addComponent(jISBN1)
                                .addGap(18, 18, 18)
                                .addComponent(JApellidoPTextSocio))
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addComponent(jTitulo1)
                                .addGap(26, 26, 26)
                                .addComponent(JNombreTextSocio))
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jISBN7)
                                    .addComponent(jLabel16))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(JTextUsuario)))
                        .addGap(10, 10, 10)
                        .addComponent(JTabbedBusquedaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JInternalSocioLayout.setVerticalGroup(
            JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(8, 8, 8)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JNombreTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTitulo1))
                        .addGap(9, 9, 9)
                        .addComponent(jISBN7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JApellidoPTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jISBN1))
                        .addGap(18, 18, 18)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNPag1)
                            .addComponent(JApellidoMTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(JTabbedBusquedaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Socios", JInternalSocio);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jRegistrarLibro)
                        .addGap(136, 136, 136)
                        .addComponent(jIconLeeyAprende)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JRegresar)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRegresarActionPerformed
        dispose();
    }//GEN-LAST:event_JRegresarActionPerformed

    private void JDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDetallesActionPerformed
        BUSCAR_LIBRO_CONTROLER.actionPerformedJPrestamo(BeanA, JTableBLibro, JTableRSocio);
    }//GEN-LAST:event_JDetallesActionPerformed

    private void JEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEstadisticasActionPerformed
        CargarInfoControlador Cargar = new CargarInfoControlador();
        Cargar.CargarInfoEstadisticas();
    }//GEN-LAST:event_JEstadisticasActionPerformed

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
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClicked((DefaultTableModel) JTableBLibro.getModel());
            } else if (JRadioTableSelection.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClickedRow(JTableBLibro);
            }
        }
    }//GEN-LAST:event_JTableBLibroMouseClicked

    private void JApellidoMTextSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JApellidoMTextSocioMouseClicked
        JApellidoMTextSocio.selectAll();
        JApellidoMTextSocio.setForeground(Color.black);
    }//GEN-LAST:event_JApellidoMTextSocioMouseClicked

    private void JApellidoMTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JApellidoMTextSocioKeyTyped
        TEXT_CHECKER.checkColorsNoNumber(JApellidoMTextSocio);
    }//GEN-LAST:event_JApellidoMTextSocioKeyTyped

    private void JApellidoPTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JApellidoPTextSocioKeyTyped
        TEXT_CHECKER.checkColorsNoNumber(JApellidoPTextSocio);
    }//GEN-LAST:event_JApellidoPTextSocioKeyTyped

    private void JNombreTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JNombreTextSocioKeyTyped
        TEXT_CHECKER.checkColorsNoNumber(JNombreTextSocio);
    }//GEN-LAST:event_JNombreTextSocioKeyTyped

    private void JBuscarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBuscarSocioActionPerformed
        DefaultTableModel model = (DefaultTableModel) JTableRSocio.getModel();
        Object[] jField = new Object[]{JNombreTextSocio.getText(), JApellidoPTextSocio.getText(), JApellidoMTextSocio.getText(), JTextUsuario.getText()};
        boolean[] jSelect = {JCheckNombre.isSelected(), JCheckApellidoM.isSelected(), JCheckApellidoP.isSelected(), JCheckUsuario.isSelected()};
        if (jField[2].toString().equals("Campo no Obligatorio")) {
            jField[2] = "";
        } else if ((!TEXT_CHECKER.checkNoNumberText(jField[2].toString()) && jSelect[2])) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if ((!TEXT_CHECKER.checkNoNumberText(jField[0].toString()) && jSelect[0]) || (!TEXT_CHECKER.checkNoNumberText(jField[1].toString()) && jSelect[1]) || (!TEXT_CHECKER.checkEmail(jField[3].toString()) && jSelect[3])) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        ADMINISTRADOR_CONTROLER.actionPerformedJBuscarSocio(model, jField, jSelect);
    }//GEN-LAST:event_JBuscarSocioActionPerformed

    private void JTableRSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRSocioMouseClicked
        if (evt.getClickCount() == 2) {
            Object[] jField = new Object[]{JNombreTextSocio, JApellidoPTextSocio, JApellidoMTextSocio, null, null, null, null, JTextUsuario};
            ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseDoubleClicked(JTableRSocio, jField, 1);
        } else if ((evt.getModifiers() & ActionEvent.ALT_MASK) == ActionEvent.ALT_MASK) {
            if (JRadioTableComplete.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClicked((DefaultTableModel) JTableRSocio.getModel());
            } else if (JRadioTableSelection.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClickedRow(JTableRSocio);
            }
        }
    }//GEN-LAST:event_JTableRSocioMouseClicked

    private void JTextUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextUsuarioKeyTyped
        if (!TEXT_CHECKER.checkEmail(JTextUsuario.getText())) {
            JTextUsuario.setForeground(new Color(204, 0, 0));
        } else {
            JTextUsuario.setForeground(Color.black);
        }
    }//GEN-LAST:event_JTextUsuarioKeyTyped

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
        Object[] jText = {JNombreTextSocio, JApellidoPTextSocio, JTextUsuario,
            JTituloText, JISBNText, JListAutor, JListEditorial};
        clearTexts(jText);
    }//GEN-LAST:event_JClearTextsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField JApellidoMTextSocio;
    public javax.swing.JTextField JApellidoPTextSocio;
    private javax.swing.JButton JBuscarLibro;
    private javax.swing.JButton JBuscarSocio;
    public javax.swing.JCheckBox JCheckApellidoM;
    public javax.swing.JCheckBox JCheckApellidoP;
    public javax.swing.JCheckBox JCheckAutor;
    public javax.swing.JCheckBox JCheckEditorial;
    public javax.swing.JCheckBox JCheckISBN;
    public javax.swing.JCheckBox JCheckNombre;
    public javax.swing.JCheckBox JCheckTitulo;
    public javax.swing.JCheckBox JCheckUsuario;
    private javax.swing.JMenuItem JClearTexts;
    private javax.swing.JButton JDetalles;
    private javax.swing.JButton JEstadisticas;
    public javax.swing.JTextField JISBNText;
    private javax.swing.JInternalFrame JInternalBuscar;
    private javax.swing.JInternalFrame JInternalBuscar1;
    private javax.swing.JInternalFrame JInternalEditar1;
    private javax.swing.JInternalFrame JInternalSocio;
    public javax.swing.JList<String> JListAutor;
    public javax.swing.JList<String> JListEditorial;
    public javax.swing.JTextField JNPagText;
    public javax.swing.JTextField JNombreTextSocio;
    private javax.swing.JRadioButtonMenuItem JRadioTableComplete;
    private javax.swing.JRadioButtonMenuItem JRadioTableSelection;
    private javax.swing.JButton JRegresar;
    private javax.swing.JTabbedPane JTabbedBusquedaLibros;
    private javax.swing.JTabbedPane JTabbedBusquedaSocios;
    public javax.swing.JTable JTableBLibro;
    public javax.swing.JTable JTableRSocio;
    public javax.swing.JTextField JTextUsuario;
    public javax.swing.JTextField JTituloText;
    private javax.swing.JLabel jISBN;
    private javax.swing.JLabel jISBN1;
    private javax.swing.JLabel jISBN7;
    private javax.swing.JLabel jIconLeeyAprende;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JLabel jNPag;
    private javax.swing.JLabel jNPag1;
    private javax.swing.JLabel jRegistrarLibro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jTitulo;
    private javax.swing.JLabel jTitulo1;
    // End of variables declaration//GEN-END:variables
}
