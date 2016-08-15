package Vista;

import Controlador.AdministradorControlador;
import Controlador.CargarInfoControlador;
import Controlador.Otros.AreaControlador;
import Controlador.Otros.EditorialControlador;
import Controlador.Otros.LocalizacionControlador;
import Utils.Autocompleter;
import Utils.CleanupDone;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Utils.TextChecker;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * Descripción: Vista de Administrador, edición de Libros, Socios, Autores,
 * Localizaciones, Areas, y Editoriales.
 *
 */
@CleanupDone
public class VAdministrador extends javax.swing.JFrame {

    private static final TextChecker TEXT_CHECKER = new TextChecker();
    private static final AdministradorControlador ADMINISTRADOR_CONTROLER = new AdministradorControlador();
    private static final EditorialControlador EDITORIAL_CONTROLER = new EditorialControlador();
    private static final LocalizacionControlador LOCALIZACION_CONTROLER = new LocalizacionControlador();
    private static final AreaControlador AREA_CONTROLER = new AreaControlador();

    /**
     * Descripción: Inicializa la Vista.
     *
     */
    public VAdministrador() {
        initComponents();
        Iniciar();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {DO_NOTHING_ON_CLOSE
//            @Override
//            public void windowClosing(WindowEvent ev) {
//                dispose();
//            }
//        });
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon.png")).getImage());
        ////////////////////////////////////////////////////////////////////////
        JIngresarLibro.setToolTipText("Enviar datos a la Tabla");
        JModificarLibroTabla.setToolTipText("Modificar Selección");
        JEliminarLibroTabla.setToolTipText("Dar de Baja la Selección");
        JBuscarLibro.setToolTipText("Buscar Libro");
        JEstadisticas.setToolTipText("Ver las Estadísticas de Biblioteca");
        ////////////////////////////////////////////////////////////////////////
        JIngresarSocio.setToolTipText("Enviar datos a la Tabla");
        JModificarSocioTabla.setToolTipText("Modificar Selección");
        JEliminarSocioTabla.setToolTipText("Dar de Baja la Selección");
        JBuscarSocio.setToolTipText("Buscar Socio");
        ////////////////////////////////////////////////////////////////////////
        JIngresarAutor.setToolTipText("Enviar datos a la Tabla");
        JModificarAutorTabla.setToolTipText("Modificar Selección");
        JEliminarAutorTabla.setToolTipText("Dar de Baja la Selección");
        JBuscarAutor.setToolTipText("Buscar Autor");
        ////////////////////////////////////////////////////////////////////////
        JIngresarNuevoEditorial.setToolTipText("Enviar datos a la Tabla");
        JModificarEditorial.setToolTipText("Modificar Selección");
        JEliminarEditorial.setToolTipText("Dar de Baja la Selección");
        ////////////////////////////////////////////////////////////////////////
        JIngresarNuevoLocalizacion.setToolTipText("Enviar datos a la Tabla");
        JModificarLocalizacion.setToolTipText("Modificar Selección");
        JEliminarLocalizacion.setToolTipText("Dar de Baja la Selección");
        ////////////////////////////////////////////////////////////////////////
        JIngresarNuevaArea.setToolTipText("Enviar datos a la Tabla");
        JModificarArea.setToolTipText("Modificar Selección");
        JEliminarArea.setToolTipText("Dar de Baja la Selección");
        ////////////////////////////////////////////////////////////////////////
        toolTipGiver(JTituloText, ", Ingresa el Título del Libro");
        toolTipGiver(JISBNText, " (De 10 ó 13 números ej:\"0-123456-47-9 ó 978-3-16-148410-0\")");
        JSpinnerNPag.setToolTipText("Campo Obligatorio, Número de páginas del Libro");
        JListAutor.setToolTipText("Campo Obligatorio, Seleccione un Autor");
        JSpinnerCantidad.setToolTipText("Campo Obligatorio, Cantidad de Libros en Existencia");
        JLocalizacionLibro.setToolTipText("Campo Obligatorio, Seleccione una Localización");
        JAreaLibro.setToolTipText("Campo Obligatorio, Seleccione un Área");
        JListEditorial.setToolTipText("Campo Obligatorio, Seleccione una Editorial");
        ////////////////////////////////////////////////////////////////////////
        toolTipGiver(JNombreTextSocio, ", Ingrese sólo Letras");
        toolTipGiver(JApellidoPTextSocio, ", Ingrese sólo Letras");
        toolTipGiver(JTelefonoTextSocio, " (ej:\"777-1234567\")");
        toolTipGiver(JTextUsuario, " (Correo Electrónico ej:\"correo@gmail.com\")");
        toolTipGiver(JEstadoTextSocio, ", Estado de Procedencia (Ej: Nuevo_León)");
        toolTipGiver(JMunicipioTextSocio, ", Municipio de Procedencia (Ej: Monterrey)");
        toolTipGiver(JCalleTextSocio, ", Nombre de Calle en la que reside");
        toolTipGiver(JTextContraseñaSocio, ", Contraseña debe ser mayor a 4 caracteres de longitud");
        JApellidoMTextSocio.setToolTipText("Campo no Obligatorio, Ingrese sólo Letras");
        JNCalleTextSocio.setToolTipText("Campo no Obligatorio, Ingrese sólo Números");
        toolTipGiver(JNombreTextAutor, ", Ingrese sólo Letras");
        toolTipGiver(JApellidoPAutor, ", Ingrese sólo Letras");
        JApellidoMAutor.setToolTipText("Campo no Obligatorio, Ingrese sólo Letras");
        toolTipGiver(JNombreTextEditorial, ", (ej: Editorial Libros : 1985 -etc)");
        toolTipGiver(JLocalizacionText, ", (ej: A1 ó T67 -etc");
        toolTipGiver(JAreaText, ", (ej: Magia & Fantasía -etc)");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu3 = new javax.swing.JMenu();
        ButtonTables = new javax.swing.ButtonGroup();
        jIconLeeyAprende = new javax.swing.JLabel();
        jRegistrarLibro = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JTabbedRegistroLibro = new javax.swing.JTabbedPane();
        JInternalLibro = new javax.swing.JInternalFrame();
        jTitulo = new javax.swing.JLabel();
        JTituloText = new javax.swing.JTextField();
        jISBN = new javax.swing.JLabel();
        JISBNText = new javax.swing.JTextField();
        jNPag = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JListAutor = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableRLibro = new javax.swing.JTable();
        JTabbedAdminLibros = new javax.swing.JTabbedPane();
        JInternalEditar1 = new javax.swing.JInternalFrame();
        JIngresarLibro = new javax.swing.JButton();
        JModificarLibroTabla = new javax.swing.JButton();
        JEliminarLibroTabla = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JInternalBuscar = new javax.swing.JInternalFrame();
        JBuscarLibro = new javax.swing.JButton();
        JCheckTitulo = new javax.swing.JCheckBox();
        JCheckISBN = new javax.swing.JCheckBox();
        JCheckAutor = new javax.swing.JCheckBox();
        JCheckEditorial = new javax.swing.JCheckBox();
        JEstadisticas = new javax.swing.JButton();
        jISBN5 = new javax.swing.JLabel();
        JEstadoLibro = new javax.swing.JComboBox<>();
        JSpinnerNPag = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        JListEditorial = new javax.swing.JList<>();
        JLocalizacionLibro = new javax.swing.JComboBox<>();
        JSpinnerCantidad = new javax.swing.JSpinner();
        jNPag3 = new javax.swing.JLabel();
        jISBN3 = new javax.swing.JLabel();
        JAreaLibro = new javax.swing.JComboBox<>();
        jISBN4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JInternalSocio = new javax.swing.JInternalFrame();
        jTitulo1 = new javax.swing.JLabel();
        jISBN1 = new javax.swing.JLabel();
        jNPag1 = new javax.swing.JLabel();
        jTitulo2 = new javax.swing.JLabel();
        jTitulo3 = new javax.swing.JLabel();
        jTitulo4 = new javax.swing.JLabel();
        JCalleTextSocio = new javax.swing.JTextField();
        jTitulo5 = new javax.swing.JLabel();
        JTelefonoTextSocio = new javax.swing.JTextField();
        jTitulo6 = new javax.swing.JLabel();
        JNCalleTextSocio = new javax.swing.JTextField();
        JMunicipioTextSocio = new javax.swing.JTextField();
        JEstadoTextSocio = new javax.swing.JTextField();
        JApellidoMTextSocio = new javax.swing.JTextField();
        JApellidoPTextSocio = new javax.swing.JTextField();
        JNombreTextSocio = new javax.swing.JTextField();
        JTabbedBusquedaSocios = new javax.swing.JTabbedPane();
        JInternalEditar5 = new javax.swing.JInternalFrame();
        JEliminarSocioTabla = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        JIngresarSocio = new javax.swing.JButton();
        JModificarSocioTabla = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        JInternalBuscar1 = new javax.swing.JInternalFrame();
        JCheckNombre = new javax.swing.JCheckBox();
        JCheckApellidoM = new javax.swing.JCheckBox();
        JCheckApellidoP = new javax.swing.JCheckBox();
        JBuscarSocio = new javax.swing.JButton();
        JCheckUsuario = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTableRSocio = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        JTextUsuario = new javax.swing.JTextField();
        JEstatusSocio = new javax.swing.JComboBox<>();
        jTitulo8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTextContraseñaSocio = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jISBN7 = new javax.swing.JLabel();
        JInternalAutor = new javax.swing.JInternalFrame();
        jTitulo7 = new javax.swing.JLabel();
        JNombreTextAutor = new javax.swing.JTextField();
        jISBN2 = new javax.swing.JLabel();
        JApellidoPAutor = new javax.swing.JTextField();
        jNPag2 = new javax.swing.JLabel();
        JApellidoMAutor = new javax.swing.JTextField();
        JTabbedBusquedaSocios2 = new javax.swing.JTabbedPane();
        JInternalEditar6 = new javax.swing.JInternalFrame();
        JEliminarAutorTabla = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        JIngresarAutor = new javax.swing.JButton();
        JModificarAutorTabla = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        JInternalBuscar2 = new javax.swing.JInternalFrame();
        JCheckNombreAutor = new javax.swing.JCheckBox();
        JCheckApellidoPAutor = new javax.swing.JCheckBox();
        JCheckApellidoMAutor = new javax.swing.JCheckBox();
        JBuscarAutor = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTableRAutor = new javax.swing.JTable();
        jTitulo10 = new javax.swing.JLabel();
        JComboEstatusAutor = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jISBN6 = new javax.swing.JLabel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        JComboEstatusEditorial = new javax.swing.JComboBox<>();
        JNombreTextEditorial = new javax.swing.JTextField();
        JIngresarNuevoEditorial = new javax.swing.JButton();
        JModificarEditorial = new javax.swing.JButton();
        jTitulo14 = new javax.swing.JLabel();
        JEliminarEditorial = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        JTableREditorial = new javax.swing.JTable();
        jTitulo13 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jTitulo15 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        JTableRLocalizacion = new javax.swing.JTable();
        JModificarLocalizacion = new javax.swing.JButton();
        jTitulo18 = new javax.swing.JLabel();
        JComboEstatusLocalizacion = new javax.swing.JComboBox<>();
        JIngresarNuevoLocalizacion = new javax.swing.JButton();
        JEliminarLocalizacion = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        JLocalizacionText = new javax.swing.JTextField();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jTitulo17 = new javax.swing.JLabel();
        JAreaText = new javax.swing.JTextField();
        JIngresarNuevaArea = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        JTableRArea = new javax.swing.JTable();
        JModificarArea = new javax.swing.JButton();
        JEliminarArea = new javax.swing.JButton();
        JComboEstatusArea = new javax.swing.JComboBox<>();
        jTitulo16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JRegresar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        JRadioTableSelection = new javax.swing.JRadioButtonMenuItem();
        JRadioTableComplete = new javax.swing.JRadioButtonMenuItem();
        JClearTexts = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrar Biblioteca");

        jIconLeeyAprende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/LibraryIcon.png"))); // NOI18N

        jRegistrarLibro.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jRegistrarLibro.setText("Administrador");

        JInternalLibro.setVisible(true);

        jTitulo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo.setText("Título:");

        JTituloText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTituloTextKeyTyped(evt);
            }
        });

        jISBN.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN.setText("ISBN:");

        JISBNText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JISBNTextKeyTyped(evt);
            }
        });

        jNPag.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag.setText("N° Pág:");

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel1.setText("Autor");

        JListAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(JListAutor);

        JTableRLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "ISBN", "Titulo", "N° Pag", "Estatus", "Autor", "Editorial", "Localización", "Área", "Existencias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRLibro.getTableHeader().setReorderingAllowed(false);
        JTableRLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableRLibroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableRLibro);

        JInternalEditar1.setVisible(true);

        JIngresarLibro.setText("Registrar");
        JIngresarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarLibroActionPerformed(evt);
            }
        });

        JModificarLibroTabla.setText("Modificar");
        JModificarLibroTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarLibroTablaActionPerformed(evt);
            }
        });

        JEliminarLibroTabla.setForeground(new java.awt.Color(204, 0, 0));
        JEliminarLibroTabla.setText("Eliminar");
        JEliminarLibroTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarLibroTablaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Consolas", 2, 12)); // NOI18N
        jLabel5.setText("Selección:");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/IconBookshelf.png"))); // NOI18N

        javax.swing.GroupLayout JInternalEditar1Layout = new javax.swing.GroupLayout(JInternalEditar1.getContentPane());
        JInternalEditar1.getContentPane().setLayout(JInternalEditar1Layout);
        JInternalEditar1Layout.setHorizontalGroup(
            JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JEliminarLibroTabla)
                    .addComponent(JModificarLibroTabla)
                    .addComponent(jLabel5)
                    .addComponent(JIngresarLibro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel11))
        );
        JInternalEditar1Layout.setVerticalGroup(
            JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar1Layout.createSequentialGroup()
                .addGroup(JInternalEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalEditar1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JIngresarLibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(JModificarLibroTabla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JEliminarLibroTabla))
                    .addComponent(jLabel11))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JTabbedAdminLibros.addTab("Editar", JInternalEditar1);

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

        JEstadisticas.setText("Estadísticas");
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
                            .addComponent(JCheckTitulo)
                            .addComponent(JCheckISBN)
                            .addComponent(JCheckAutor))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscarLayout.createSequentialGroup()
                        .addComponent(JCheckEditorial)
                        .addGap(25, 25, 25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JEstadisticas)
                    .addComponent(JBuscarLibro))
                .addContainerGap())
        );
        JInternalBuscarLayout.setVerticalGroup(
            JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCheckTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCheckISBN)
                .addGap(4, 4, 4)
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCheckAutor)
                    .addComponent(JBuscarLibro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JInternalBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JEstadisticas)
                    .addComponent(JCheckEditorial))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        JTabbedAdminLibros.addTab("Buscar", JInternalBuscar);

        jISBN5.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        jISBN5.setText("Estado:");

        JEstadoLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        JSpinnerNPag.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel17.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel17.setText("Libro");

        JListEditorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(JListEditorial);

        JSpinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jNPag3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag3.setText("Cantidad:");

        jISBN3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN3.setText("Localización:");

        jISBN4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN4.setText("Área:");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("Editorial");

        jLayeredPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(JLocalizacionLibro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(JSpinnerCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jNPag3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jISBN3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(JAreaLibro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jISBN4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jNPag3)
                                .addGap(18, 18, 18)
                                .addComponent(JSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(113, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jISBN3)
                        .addGap(18, 18, 18)
                        .addComponent(JLocalizacionLibro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jISBN4)
                        .addGap(18, 18, 18)
                        .addComponent(JAreaLibro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jISBN3)
                    .addComponent(JLocalizacionLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JAreaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jISBN4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNPag3)
                    .addComponent(JSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JInternalLibroLayout = new javax.swing.GroupLayout(JInternalLibro.getContentPane());
        JInternalLibro.getContentPane().setLayout(JInternalLibroLayout);
        JInternalLibroLayout.setHorizontalGroup(
            JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(JInternalLibroLayout.createSequentialGroup()
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17)
                            .addComponent(jLabel1)
                            .addGroup(JInternalLibroLayout.createSequentialGroup()
                                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTitulo)
                                    .addComponent(jISBN))
                                .addGap(18, 18, 18)
                                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JISBNText)
                                    .addComponent(JTituloText)))
                            .addGroup(JInternalLibroLayout.createSequentialGroup()
                                .addComponent(jNPag)
                                .addGap(18, 18, 18)
                                .addComponent(JSpinnerNPag, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jISBN5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JEstadoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addComponent(jLayeredPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTabbedAdminLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JInternalLibroLayout.setVerticalGroup(
            JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalLibroLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(5, 5, 5)
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo)
                            .addComponent(JTituloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jISBN)
                            .addComponent(JISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JInternalLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNPag)
                            .addComponent(JSpinnerNPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jISBN5)
                            .addComponent(JEstadoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JInternalLibroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JTabbedAdminLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JTabbedRegistroLibro.addTab("Registros de Libro", JInternalLibro);

        JInternalSocio.setVisible(true);

        jTitulo1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo1.setText("Nombre:");

        jISBN1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN1.setText("Primero:");

        jNPag1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag1.setText("Segundo:");

        jTitulo2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo2.setText("Estado:");

        jTitulo3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo3.setText("Mucicipio:");

        jTitulo4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo4.setText("Calle:");

        JCalleTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JCalleTextSocioKeyTyped(evt);
            }
        });

        jTitulo5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo5.setText("Teléfono:");

        JTelefonoTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTelefonoTextSocioKeyTyped(evt);
            }
        });

        jTitulo6.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo6.setText("N°Calle:");

        JNCalleTextSocio.setForeground(new java.awt.Color(0, 153, 0));
        JNCalleTextSocio.setText("N/A");
        JNCalleTextSocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JNCalleTextSocioMouseClicked(evt);
            }
        });
        JNCalleTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JNCalleTextSocioKeyTyped(evt);
            }
        });

        JMunicipioTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JMunicipioTextSocioKeyTyped(evt);
            }
        });

        JEstadoTextSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JEstadoTextSocioKeyTyped(evt);
            }
        });

        JApellidoMTextSocio.setForeground(new java.awt.Color(0, 153, 0));
        JApellidoMTextSocio.setText("N/A");
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

        JInternalEditar5.setVisible(true);

        JEliminarSocioTabla.setForeground(new java.awt.Color(204, 0, 0));
        JEliminarSocioTabla.setText("Eliminar");
        JEliminarSocioTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JEliminarSocioTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarSocioTablaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Consolas", 2, 12)); // NOI18N
        jLabel8.setText("Selección:");

        JIngresarSocio.setText("Registrar");
        JIngresarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarSocioActionPerformed(evt);
            }
        });

        JModificarSocioTabla.setText("Modificar");
        JModificarSocioTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarSocioTablaActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/IconBookshelf.png"))); // NOI18N

        javax.swing.GroupLayout JInternalEditar5Layout = new javax.swing.GroupLayout(JInternalEditar5.getContentPane());
        JInternalEditar5.getContentPane().setLayout(JInternalEditar5Layout);
        JInternalEditar5Layout.setHorizontalGroup(
            JInternalEditar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalEditar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JEliminarSocioTabla)
                    .addComponent(jLabel8)
                    .addComponent(JIngresarSocio)
                    .addComponent(JModificarSocioTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        JInternalEditar5Layout.setVerticalGroup(
            JInternalEditar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JIngresarSocio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JModificarSocioTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JEliminarSocioTabla)
                .addGap(20, 20, 20))
            .addGroup(JInternalEditar5Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JTabbedBusquedaSocios.addTab("Editar", JInternalEditar5);

        JInternalBuscar1.setVisible(true);

        JCheckNombre.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckNombre.setText("Nombre");

        JCheckApellidoM.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoM.setText("Segundo Apellido");

        JCheckApellidoP.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoP.setText("Primer Apellido");

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
                            .addComponent(JCheckApellidoM)
                            .addComponent(JCheckApellidoP))
                        .addGap(0, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JInternalBuscar1Layout.setVerticalGroup(
            JInternalBuscar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCheckNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCheckApellidoP)
                .addGap(3, 3, 3)
                .addComponent(JCheckApellidoM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCheckUsuario)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscar1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBuscarSocio)
                .addContainerGap())
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

        jLabel3.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        jLabel3.setText("Usuario:");

        JTextUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTextUsuarioKeyTyped(evt);
            }
        });

        JEstatusSocio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jTitulo8.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        jTitulo8.setText("Estatus:");

        jLabel4.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        jLabel4.setText("Contraseña:");

        JTextContraseñaSocio.setEditable(false);
        JTextContraseñaSocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTextContraseñaSocioMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel16.setText("Socio");

        jISBN7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
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
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTitulo5)
                                            .addComponent(jLabel3))
                                        .addGap(10, 10, 10)
                                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JTelefonoTextSocio, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                            .addComponent(JTextUsuario)))
                                    .addComponent(jISBN7)
                                    .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalSocioLayout.createSequentialGroup()
                                            .addComponent(jNPag1)
                                            .addGap(18, 18, 18)
                                            .addComponent(JApellidoMTextSocio))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalSocioLayout.createSequentialGroup()
                                            .addComponent(jISBN1)
                                            .addGap(18, 18, 18)
                                            .addComponent(JApellidoPTextSocio))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JInternalSocioLayout.createSequentialGroup()
                                            .addComponent(jTitulo1)
                                            .addGap(26, 26, 26)
                                            .addComponent(JNombreTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(22, 31, Short.MAX_VALUE)
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTitulo6)
                                    .addComponent(jTitulo8)
                                    .addComponent(jLabel4)
                                    .addComponent(jTitulo4)
                                    .addComponent(jTitulo2)
                                    .addComponent(jTitulo3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JEstadoTextSocio)
                                    .addComponent(JNCalleTextSocio)
                                    .addComponent(JTextContraseñaSocio)
                                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                                        .addComponent(JEstatusSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 82, Short.MAX_VALUE))
                                    .addComponent(JCalleTextSocio)
                                    .addComponent(JMunicipioTextSocio, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTabbedBusquedaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JInternalSocioLayout.setVerticalGroup(
            JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalSocioLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(8, 8, 8)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JNombreTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTitulo1)
                            .addComponent(jTitulo2)
                            .addComponent(JEstadoTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JMunicipioTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTitulo3))
                            .addComponent(jISBN7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTitulo4)
                                    .addComponent(JCalleTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTitulo6)
                                    .addComponent(JNCalleTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(JInternalSocioLayout.createSequentialGroup()
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JApellidoPTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jISBN1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jNPag1)
                                    .addComponent(JApellidoMTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo5)
                            .addComponent(JTelefonoTextSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTitulo8)
                            .addComponent(JEstatusSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(JTextContraseñaSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JInternalSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))))
                    .addComponent(JTabbedBusquedaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabbedRegistroLibro.addTab("Registros de Socio", JInternalSocio);

        JInternalAutor.setVisible(true);

        jTitulo7.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo7.setText("Nombre:");

        JNombreTextAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JNombreTextAutorKeyTyped(evt);
            }
        });

        jISBN2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jISBN2.setText("Primero:");

        JApellidoPAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JApellidoPAutorKeyTyped(evt);
            }
        });

        jNPag2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jNPag2.setText("Segundo:");

        JApellidoMAutor.setForeground(new java.awt.Color(0, 153, 0));
        JApellidoMAutor.setText("N/A");
        JApellidoMAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JApellidoMAutorMouseClicked(evt);
            }
        });
        JApellidoMAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JApellidoMAutorKeyTyped(evt);
            }
        });

        JInternalEditar6.setVisible(true);

        JEliminarAutorTabla.setForeground(new java.awt.Color(204, 0, 0));
        JEliminarAutorTabla.setText("Eliminar");
        JEliminarAutorTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JEliminarAutorTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarAutorTablaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Consolas", 2, 12)); // NOI18N
        jLabel10.setText("Selección:");

        JIngresarAutor.setText("Registrar");
        JIngresarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarAutorActionPerformed(evt);
            }
        });

        JModificarAutorTabla.setText("Modificar");
        JModificarAutorTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarAutorTablaActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/IconBookshelf.png"))); // NOI18N

        javax.swing.GroupLayout JInternalEditar6Layout = new javax.swing.GroupLayout(JInternalEditar6.getContentPane());
        JInternalEditar6.getContentPane().setLayout(JInternalEditar6Layout);
        JInternalEditar6Layout.setHorizontalGroup(
            JInternalEditar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalEditar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JEliminarAutorTabla)
                    .addComponent(jLabel10)
                    .addComponent(JIngresarAutor)
                    .addComponent(JModificarAutorTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        JInternalEditar6Layout.setVerticalGroup(
            JInternalEditar6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalEditar6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JIngresarAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JModificarAutorTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JEliminarAutorTabla)
                .addGap(20, 20, 20))
            .addGroup(JInternalEditar6Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JTabbedBusquedaSocios2.addTab("Editar", JInternalEditar6);

        JInternalBuscar2.setVisible(true);

        JCheckNombreAutor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckNombreAutor.setText("Nombre");

        JCheckApellidoPAutor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoPAutor.setText("Primer Apellido");

        JCheckApellidoMAutor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        JCheckApellidoMAutor.setText("Segundo Apellido");

        JBuscarAutor.setText("Buscar");
        JBuscarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBuscarAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JInternalBuscar2Layout = new javax.swing.GroupLayout(JInternalBuscar2.getContentPane());
        JInternalBuscar2.getContentPane().setLayout(JInternalBuscar2Layout);
        JInternalBuscar2Layout.setHorizontalGroup(
            JInternalBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalBuscar2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscar2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JBuscarAutor))
                    .addGroup(JInternalBuscar2Layout.createSequentialGroup()
                        .addGroup(JInternalBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JCheckNombreAutor)
                            .addComponent(JCheckApellidoPAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCheckApellidoMAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JInternalBuscar2Layout.setVerticalGroup(
            JInternalBuscar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JInternalBuscar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCheckNombreAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCheckApellidoPAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JCheckApellidoMAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(JBuscarAutor)
                .addContainerGap())
        );

        JTabbedBusquedaSocios2.addTab("Buscar", JInternalBuscar2);

        JTableRAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido Paterno", "Apellido Materno", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRAutor.getTableHeader().setReorderingAllowed(false);
        JTableRAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableRAutorMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(JTableRAutor);

        jTitulo10.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        jTitulo10.setText("Estatus:");

        JComboEstatusAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jLabel15.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel15.setText("Autor");

        jISBN6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jISBN6.setText("Apellido(s):");

        javax.swing.GroupLayout JInternalAutorLayout = new javax.swing.GroupLayout(JInternalAutor.getContentPane());
        JInternalAutor.getContentPane().setLayout(JInternalAutorLayout);
        JInternalAutorLayout.setHorizontalGroup(
            JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(JInternalAutorLayout.createSequentialGroup()
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JInternalAutorLayout.createSequentialGroup()
                                .addComponent(jNPag2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JApellidoMAutor))
                            .addGroup(JInternalAutorLayout.createSequentialGroup()
                                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jISBN2)
                                    .addComponent(jTitulo7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JNombreTextAutor)
                                    .addComponent(JApellidoPAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)))
                            .addGroup(JInternalAutorLayout.createSequentialGroup()
                                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JInternalAutorLayout.createSequentialGroup()
                                        .addComponent(jTitulo10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JComboEstatusAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel15)
                                    .addComponent(jISBN6))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTabbedBusquedaSocios2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JInternalAutorLayout.setVerticalGroup(
            JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JInternalAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JInternalAutorLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo7)
                            .addComponent(JNombreTextAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jISBN6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jISBN2)
                            .addComponent(JApellidoPAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNPag2)
                            .addComponent(JApellidoMAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JInternalAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTitulo10)
                            .addComponent(JComboEstatusAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JTabbedBusquedaSocios2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabbedRegistroLibro.addTab("Registros de Autor", JInternalAutor);

        jInternalFrame4.setVisible(true);

        JComboEstatusEditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        JNombreTextEditorial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JNombreTextEditorialKeyTyped(evt);
            }
        });

        JIngresarNuevoEditorial.setText("Registrar");
        JIngresarNuevoEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarNuevoEditorialActionPerformed(evt);
            }
        });

        JModificarEditorial.setText("Modificar");
        JModificarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarEditorialActionPerformed(evt);
            }
        });

        jTitulo14.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        jTitulo14.setText("Estatus:");

        JEliminarEditorial.setForeground(new java.awt.Color(204, 0, 0));
        JEliminarEditorial.setText("Eliminar");
        JEliminarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarEditorialActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel12.setText("Editoriales");

        JTableREditorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableREditorial.getTableHeader().setReorderingAllowed(false);
        JTableREditorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableREditorialMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(JTableREditorial);

        jTitulo13.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo13.setText("Nombre:");

        jLayeredPane2.setLayer(JComboEstatusEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(JNombreTextEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(JIngresarNuevoEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(JModificarEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTitulo14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(JEliminarEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTitulo13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTitulo13)
                            .addComponent(jTitulo14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(JComboEstatusEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JIngresarNuevoEditorial))
                            .addComponent(JNombreTextEditorial)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(JModificarEditorial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JEliminarEditorial))
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JNombreTextEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitulo13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTitulo14)
                    .addComponent(JComboEstatusEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JIngresarNuevoEditorial))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JModificarEditorial)
                    .addComponent(JEliminarEditorial))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTitulo15.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo15.setText("Pasillo:");

        JTableRLocalizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Pasillo", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRLocalizacion.getTableHeader().setReorderingAllowed(false);
        JTableRLocalizacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableRLocalizacionMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(JTableRLocalizacion);

        JModificarLocalizacion.setText("Modificar");
        JModificarLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarLocalizacionActionPerformed(evt);
            }
        });

        jTitulo18.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        jTitulo18.setText("Estatus:");

        JComboEstatusLocalizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        JIngresarNuevoLocalizacion.setText("Registrar");
        JIngresarNuevoLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarNuevoLocalizacionActionPerformed(evt);
            }
        });

        JEliminarLocalizacion.setForeground(new java.awt.Color(204, 0, 0));
        JEliminarLocalizacion.setText("Eliminar");
        JEliminarLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarLocalizacionActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel13.setText("Localización");

        JLocalizacionText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JLocalizacionTextKeyTyped(evt);
            }
        });

        jLayeredPane3.setLayer(jTitulo15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jScrollPane10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(JModificarLocalizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jTitulo18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(JComboEstatusLocalizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(JIngresarNuevoLocalizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(JEliminarLocalizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(JLocalizacionText, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(JModificarLocalizacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JEliminarLocalizacion))
                    .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane3Layout.createSequentialGroup()
                            .addComponent(jTitulo18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(JComboEstatusLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)
                            .addComponent(JIngresarNuevoLocalizacion))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane3Layout.createSequentialGroup()
                            .addComponent(jTitulo15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(JLocalizacionText, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLocalizacionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitulo15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTitulo18)
                    .addComponent(JComboEstatusLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JIngresarNuevoLocalizacion))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JModificarLocalizacion)
                    .addComponent(JEliminarLocalizacion))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTitulo17.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        jTitulo17.setText("Estatus:");

        JAreaText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JAreaTextKeyTyped(evt);
            }
        });

        JIngresarNuevaArea.setText("Registrar");
        JIngresarNuevaArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIngresarNuevaAreaActionPerformed(evt);
            }
        });

        JTableRArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Sección", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRArea.getTableHeader().setReorderingAllowed(false);
        JTableRArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableRAreaMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(JTableRArea);

        JModificarArea.setText("Modificar");
        JModificarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModificarAreaActionPerformed(evt);
            }
        });

        JEliminarArea.setForeground(new java.awt.Color(204, 0, 0));
        JEliminarArea.setText("Eliminar");
        JEliminarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarAreaActionPerformed(evt);
            }
        });

        JComboEstatusArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jTitulo16.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTitulo16.setText("Sección:");

        jLabel14.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel14.setText("Área");

        jLayeredPane4.setLayer(jTitulo17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(JAreaText, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(JIngresarNuevaArea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(JModificarArea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(JEliminarArea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(JComboEstatusArea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jTitulo16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(JModificarArea)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JEliminarArea))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTitulo16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTitulo17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16)
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                        .addComponent(JComboEstatusArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JIngresarNuevaArea))
                                    .addComponent(JAreaText))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JAreaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitulo16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTitulo17)
                    .addComponent(JComboEstatusArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JIngresarNuevaArea))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JModificarArea)
                    .addComponent(JEliminarArea))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2)
                .addGap(29, 29, 29)
                .addComponent(jLayeredPane3)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(870, 870, 870))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane4)
                    .addComponent(jLayeredPane3)
                    .addComponent(jLayeredPane2))
                .addContainerGap())
        );

        JTabbedRegistroLibro.addTab("Registros de Editorial/Localización/Área", jInternalFrame4);

        JRegresar.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        JRegresar.setText("Regresar");
        JRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRegresarActionPerformed(evt);
            }
        });

        jMenu5.setText("Ventana");

        jMenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuSalir);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Opciones");

        jMenu6.setText("Opciones de Tabla");

        JRadioTableSelection.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        ButtonTables.add(JRadioTableSelection);
        JRadioTableSelection.setSelected(true);
        JRadioTableSelection.setText("Detalles de Tabla por Selección");
        jMenu6.add(JRadioTableSelection);

        JRadioTableComplete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        ButtonTables.add(JRadioTableComplete);
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
                        .addComponent(JTabbedRegistroLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jRegistrarLibro)
                        .addGap(188, 188, 188)
                        .addComponent(jIconLeeyAprende)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JRegresar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jRegistrarLibro))
                    .addComponent(jIconLeeyAprende)
                    .addComponent(JRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTabbedRegistroLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Descripción: Asigna un texto default a quien llame el método.
     *
     */
    private void toolTipGiver(JTextField jField, String text) {
        jField.setToolTipText("Campo Obligatorio" + text);
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

        /**
         * VRegistro de Libro*
         */
        JLocalizacionLibro.removeAllItems();
        JAreaLibro.removeAllItems();
        JComboBox[] jFieldCombo = {JLocalizacionLibro, JAreaLibro};
        JList[] jFieldList = {JListAutor, JListEditorial};
        Cargar.CargarInfoListas(jFieldCombo, jFieldList);
        try {
            loadAuto(Cargar.CargarTexts());
        } catch (java.lang.ExceptionInInitializerError ex) {
            System.err.println("Error in Autocomplete file: " + ex.getLocalizedMessage());
        }
        /**
         * VRegistro de Editorial/Localizacion/Area*
         */
        DefaultTableModel Editorial = (DefaultTableModel) JTableREditorial.getModel();
        Cargar.CargarEditorial(Editorial);
        DefaultTableModel Localizacion = (DefaultTableModel) JTableRLocalizacion.getModel();
        Cargar.CargarLocalizacion(Localizacion);
        DefaultTableModel Area = (DefaultTableModel) JTableRArea.getModel();
        Cargar.CargarArea(Area);
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
     * Registros de Libro*
     */

    private void JIngresarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarLibroActionPerformed
        DefaultTableModel model = (DefaultTableModel) JTableRLibro.getModel();
        Object[] jField = {JISBNText.getText(), JTituloText.getText(), JSpinnerNPag.getValue().toString(), JEstadoLibro.getSelectedItem().toString(), JSpinnerCantidad.getValue().toString()};
        Object[] jText = {JTituloText, JISBNText, JListAutor, JListEditorial, JAreaLibro, JLocalizacionLibro, JSpinnerNPag, JSpinnerCantidad};
        TEXT_CHECKER.checkFieldsColors(jText);
        ArrayList jArray = new ArrayList();
        jArray.add(JListAutor.getSelectedValue());
        jArray.add(JListEditorial.getSelectedValue());
        jArray.add(JAreaLibro.getSelectedItem().toString());
        jArray.add(JLocalizacionLibro.getSelectedItem().toString());
        if (ADMINISTRADOR_CONTROLER.actionPerformedJIngresarLibro(model, jField, jArray)) {
            clearTexts(jText);
        }
    }//GEN-LAST:event_JIngresarLibroActionPerformed

    private void JModificarLibroTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarLibroTablaActionPerformed
        Object[] jField = {JISBNText.getText(), JTituloText.getText(), JSpinnerNPag.getValue().toString(), JEstadoLibro.getSelectedItem().toString(), JSpinnerCantidad.getValue().toString()};
        Object[] jText = {JTituloText, JISBNText, JListAutor, JListEditorial, JAreaLibro, JLocalizacionLibro, JSpinnerNPag, JSpinnerCantidad};
        TEXT_CHECKER.checkFieldsColors(jText);
        ArrayList jArray = new ArrayList();
        jArray.add(JListAutor.getSelectedValue());
        jArray.add(JListEditorial.getSelectedValue());
        jArray.add(JAreaLibro.getSelectedItem().toString());
        jArray.add(JLocalizacionLibro.getSelectedItem().toString());
        if (ADMINISTRADOR_CONTROLER.actionPerformedJModificarLibro(JTableRLibro, jField, jArray)) {
            clearTexts(jText);
        }
    }//GEN-LAST:event_JModificarLibroTablaActionPerformed

    private void JEliminarLibroTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarLibroTablaActionPerformed
        ADMINISTRADOR_CONTROLER.actionPerformedJEliminarLibro(JTableRLibro);
    }//GEN-LAST:event_JEliminarLibroTablaActionPerformed

    /**
     * Busqueda de Libro*
     */

    private void JBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBuscarLibroActionPerformed
        DefaultTableModel model = (DefaultTableModel) JTableRLibro.getModel();
        Object[] jField = {JTituloText.getText(), JISBNText.getText(), JListEditorial.getSelectedValue(), JListAutor.getSelectedValue()};
        boolean[] jSelect = {JCheckTitulo.isSelected(), JCheckAutor.isSelected(), JCheckISBN.isSelected(), JCheckEditorial.isSelected()};
        if ((!TEXT_CHECKER.checkISBN(jField[1].toString()) && jSelect[2]) || (!TEXT_CHECKER.checkText(jField[0].toString()) && jSelect[0])) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z,ñ´] [0-9,-]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        ADMINISTRADOR_CONTROLER.actionPerformedJBuscarLibro(model, jField, jSelect);
    }//GEN-LAST:event_JBuscarLibroActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Registro de Socios*
     */

    private void JIngresarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarSocioActionPerformed
        Object[] jField = {JNombreTextSocio.getText(),
            JApellidoPTextSocio.getText(), JEstadoTextSocio.getText(),
            JMunicipioTextSocio.getText(), JCalleTextSocio.getText(),
            JTelefonoTextSocio.getText(), JTextUsuario.getText()};
        String A = JApellidoMTextSocio.getText();
        String B = JNCalleTextSocio.getText();
        if (A.equals("N/A")) {
            A = "";
        } else if (!TEXT_CHECKER.checkNoNumberText(A)) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (B.equals("N/A")) {
        } else if (!TEXT_CHECKER.checkNumber(B)) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Object[] jText = {JNombreTextSocio, JApellidoPTextSocio, JTelefonoTextSocio, JTextUsuario, JEstadoTextSocio, JMunicipioTextSocio, JCalleTextSocio};
        TEXT_CHECKER.checkFieldsColors(jText);
        DefaultTableModel model = (DefaultTableModel) JTableRSocio.getModel();
        if (ADMINISTRADOR_CONTROLER.actionPerformedJIngresarSocio(model, jField, A, B, JTextContraseñaSocio.getText().toCharArray())) {
            clearTexts(jText);
            JApellidoMTextSocio.setText("N/A");
            JApellidoMTextSocio.setForeground(new Color(0, 153, 0));
            JNCalleTextSocio.setText("N/A");
            JNCalleTextSocio.setForeground(new Color(0, 153, 0));
        }
    }//GEN-LAST:event_JIngresarSocioActionPerformed

    private void JModificarSocioTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarSocioTablaActionPerformed
        Object[] jField = {JNombreTextSocio.getText(),
            JApellidoPTextSocio.getText(), JEstatusSocio.getSelectedItem().toString(), JEstadoTextSocio.getText(),
            JMunicipioTextSocio.getText(), JCalleTextSocio.getText(),
            JTelefonoTextSocio.getText(), JTextUsuario.getText()};
        String A = JApellidoMTextSocio.getText();
        String B = JNCalleTextSocio.getText();
        if (A.equals("N/A")) {
            A = "";
        } else if (!TEXT_CHECKER.checkNoNumberText(A)) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (B.equals("N/A")) {
        } else if (!TEXT_CHECKER.checkNumber(B)) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Object[] jText = {JNombreTextSocio, JApellidoPTextSocio, JTelefonoTextSocio, JTextUsuario, JEstadoTextSocio, JMunicipioTextSocio, JCalleTextSocio};
        TEXT_CHECKER.checkFieldsColors(jText);
        if (ADMINISTRADOR_CONTROLER.actionPerformedJModificarSocio(JTableRSocio, jField, A, B, JTextContraseñaSocio.getText().toCharArray())) {
            clearTexts(jText);
            JApellidoMTextSocio.setText("N/A");
            JApellidoMTextSocio.setForeground(new Color(0, 153, 0));
            JNCalleTextSocio.setText("N/A");
            JNCalleTextSocio.setForeground(new Color(0, 153, 0));
        }
    }//GEN-LAST:event_JModificarSocioTablaActionPerformed

    private void JEliminarSocioTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarSocioTablaActionPerformed
        ADMINISTRADOR_CONTROLER.actionPerformedJEliminarSocio(JTableRSocio);
    }//GEN-LAST:event_JEliminarSocioTablaActionPerformed

    /**
     * Busqueda de Socios*
     */
    private void JBuscarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBuscarSocioActionPerformed
        DefaultTableModel model = (DefaultTableModel) JTableRSocio.getModel();
        Object[] jField = {JNombreTextSocio.getText(), JApellidoPTextSocio.getText(), JApellidoMTextSocio.getText(), JTextUsuario.getText()};
        boolean[] jSelect = {JCheckNombre.isSelected(), JCheckApellidoP.isSelected(), JCheckApellidoM.isSelected(), JCheckUsuario.isSelected()};
        if (jField[2].toString().equals("N/A")) {
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

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Registro de Autor*
     */

    private void JIngresarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarAutorActionPerformed
        Object[] jField = {JNombreTextAutor.getText(), JApellidoPAutor.getText()};
        Object[] jText = {JNombreTextAutor, JApellidoPAutor};
        String B = JApellidoMAutor.getText();
        TEXT_CHECKER.checkFieldsColors(jText);
        if (B.equals("N/A")) {
            B = "";
        } else if (!TEXT_CHECKER.checkNoNumberText(B)) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) JTableRAutor.getModel();
        if (ADMINISTRADOR_CONTROLER.actionPerformedJIngresarAutor(model, jField, B)) {
            clearTexts(jText);
            JApellidoMAutor.setText("N/A");
            JApellidoMAutor.setForeground(new Color(0, 153, 0));
            this.Iniciar();
        }
    }//GEN-LAST:event_JIngresarAutorActionPerformed

    private void JModificarAutorTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarAutorTablaActionPerformed
        Object[] jField = {JNombreTextAutor.getText(), JApellidoPAutor.getText(), JComboEstatusAutor.getSelectedItem().toString()};
        Object[] jText = {JNombreTextAutor, JApellidoPAutor};
        String B = JApellidoMAutor.getText();
        TEXT_CHECKER.checkFieldsColors(jText);
        if (B.equals("N/A")) {
            B = "";
        } else if (!TEXT_CHECKER.checkNoNumberText(B)) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (ADMINISTRADOR_CONTROLER.actionPerformedJModificarAutor(JTableRAutor, jField, B)) {
            clearTexts(jText);
            JApellidoMAutor.setText("N/A");
            JApellidoMAutor.setForeground(new Color(0, 153, 0));
            this.Iniciar();
        }
    }//GEN-LAST:event_JModificarAutorTablaActionPerformed

    private void JEliminarAutorTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarAutorTablaActionPerformed
        if (ADMINISTRADOR_CONTROLER.actionPerformedJEliminarAutor(JTableRAutor)) {
            this.Iniciar();
        }
    }//GEN-LAST:event_JEliminarAutorTablaActionPerformed

    /**
     * Busqueda de Autor*
     */

    private void JBuscarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBuscarAutorActionPerformed
        DefaultTableModel model = (DefaultTableModel) JTableRAutor.getModel();
        Object[] jField = {JNombreTextAutor.getText(), JApellidoPAutor.getText(), JApellidoMAutor.getText()};
        boolean[] jSelect = {JCheckNombreAutor.isSelected(), JCheckApellidoPAutor.isSelected(), JCheckApellidoMAutor.isSelected()};
        if (jField[2].toString().equals("N/A")) {
            jField[2] = "";
        } else if (!TEXT_CHECKER.checkNoNumberText(jField[2].toString()) && jSelect[2]) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z] [0-9]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if ((!TEXT_CHECKER.checkNoNumberText(jField[0].toString()) && jSelect[0]) || (!TEXT_CHECKER.checkNoNumberText(jField[1].toString()) && jSelect[1])) {
            JOptionPane.showMessageDialog(null, "Caracteres no válidos, solo intriducir [a-z|A-Z]", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        ADMINISTRADOR_CONTROLER.actionPerformedJBuscarAutor(model, jField, jSelect);
    }//GEN-LAST:event_JBuscarAutorActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Registros de Editorial*
     */

    private void JIngresarNuevoEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarNuevoEditorialActionPerformed
        Object[] jField = {JNombreTextEditorial.getText()};
        Object[] jText = {JNombreTextEditorial};
        TEXT_CHECKER.checkFieldsColors(jText);
        if (EDITORIAL_CONTROLER.actionPerformedJIngresarEditorial(jField)) {
            clearTexts(jText);
            this.Iniciar();
        }
    }//GEN-LAST:event_JIngresarNuevoEditorialActionPerformed

    private void JModificarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarEditorialActionPerformed
        Object[] jField = {JNombreTextEditorial.getText(), JComboEstatusEditorial.getSelectedItem().toString()};
        Object[] jText = {JNombreTextEditorial};
        TEXT_CHECKER.checkFieldsColors(jText);
        if (EDITORIAL_CONTROLER.actionPerformedJModificarEditorial(JTableREditorial, jField)) {
            clearTexts(jText);
            this.Iniciar();
        }
    }//GEN-LAST:event_JModificarEditorialActionPerformed

    private void JEliminarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarEditorialActionPerformed
        if (EDITORIAL_CONTROLER.actionPerformedJEliminarEditorial(JTableREditorial)) {
            this.Iniciar();
        }
    }//GEN-LAST:event_JEliminarEditorialActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Registros de Localización*
     */

    private void JIngresarNuevoLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarNuevoLocalizacionActionPerformed
        Object[] jField = {JLocalizacionText.getText()};
        Object[] jText = {JLocalizacionText};
        TEXT_CHECKER.checkFieldsColors(jText);
        if (LOCALIZACION_CONTROLER.actionPerformedJIngresarLocalizacion(jField)) {
            clearTexts(jText);
            this.Iniciar();
        }
    }//GEN-LAST:event_JIngresarNuevoLocalizacionActionPerformed

    private void JModificarLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarLocalizacionActionPerformed
        Object[] jField = {JLocalizacionText.getText(), JComboEstatusLocalizacion.getSelectedItem().toString()};
        Object[] jText = {JLocalizacionText};
        TEXT_CHECKER.checkFieldsColors(jText);
        if (LOCALIZACION_CONTROLER.actionPerformedJModificarLocalizacion(JTableRLocalizacion, jField)) {
            clearTexts(jText);
            this.Iniciar();
        }
    }//GEN-LAST:event_JModificarLocalizacionActionPerformed

    private void JEliminarLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarLocalizacionActionPerformed
        if (LOCALIZACION_CONTROLER.actionPerformedJEliminarLocalizacion(JTableRLocalizacion)) {
            this.Iniciar();
        }
    }//GEN-LAST:event_JEliminarLocalizacionActionPerformed

    private void JRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JRegresarActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Registros de Area*
     */

    private void JIngresarNuevaAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIngresarNuevaAreaActionPerformed
        Object[] jField = {JAreaText.getText()};
        Object[] jText = {JAreaText};
        TEXT_CHECKER.checkFieldsColors(jText);
        if (AREA_CONTROLER.actionPerformedJIngresarArea(jField)) {
            clearTexts(jText);
            Iniciar();
        }
    }//GEN-LAST:event_JIngresarNuevaAreaActionPerformed

    private void JModificarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModificarAreaActionPerformed
        Object[] jField = {JAreaText.getText(), JComboEstatusArea.getSelectedItem().toString()};
        Object[] jText = {JAreaText};
        TEXT_CHECKER.checkFieldsColors(jText);
        if (AREA_CONTROLER.actionPerformedJModificarArea(JTableRArea, jField)) {
            clearTexts(jText);
            Iniciar();
        }
    }//GEN-LAST:event_JModificarAreaActionPerformed

    private void JEliminarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarAreaActionPerformed
        if (AREA_CONTROLER.actionPerformedJEliminarArea(JTableRArea)) {
            Iniciar();
        }
    }//GEN-LAST:event_JEliminarAreaActionPerformed

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Estadisticas*
     */

    private void JEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEstadisticasActionPerformed
        CargarInfoControlador Cargar = new CargarInfoControlador();
        Cargar.CargarInfoEstadisticas();
    }//GEN-LAST:event_JEstadisticasActionPerformed

    private void JTituloTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTituloTextKeyTyped
        TEXT_CHECKER.checkColors(JTituloText);
    }//GEN-LAST:event_JTituloTextKeyTyped

    private void JNombreTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JNombreTextSocioKeyTyped
        TEXT_CHECKER.checkColorsNoNumber(JNombreTextSocio);
    }//GEN-LAST:event_JNombreTextSocioKeyTyped

    private void JApellidoPTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JApellidoPTextSocioKeyTyped
        TEXT_CHECKER.checkColorsNoNumber(JApellidoPTextSocio);
    }//GEN-LAST:event_JApellidoPTextSocioKeyTyped

    private void JApellidoMTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JApellidoMTextSocioKeyTyped
        if (JApellidoMTextSocio.getText().isEmpty()) {
            JApellidoMTextSocio.setText("N/A");
            JApellidoMTextSocio.setForeground(new Color(0, 153, 0));
        } else {
            TEXT_CHECKER.checkColorsNoNumber(JApellidoMTextSocio);
        }
    }//GEN-LAST:event_JApellidoMTextSocioKeyTyped

    private void JEstadoTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JEstadoTextSocioKeyTyped
        if (evt.getKeyChar() == ' ') {
            evt.setKeyChar('_');
        }
        TEXT_CHECKER.checkColorsDirection(JEstadoTextSocio);
    }//GEN-LAST:event_JEstadoTextSocioKeyTyped

    private void JMunicipioTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JMunicipioTextSocioKeyTyped
        if (evt.getKeyChar() == ' ') {
            evt.setKeyChar('_');
        }
        TEXT_CHECKER.checkColorsDirection(JMunicipioTextSocio);
    }//GEN-LAST:event_JMunicipioTextSocioKeyTyped

    private void JCalleTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCalleTextSocioKeyTyped
        if (evt.getKeyChar() == ' ') {
            evt.setKeyChar('_');
        }
        TEXT_CHECKER.checkColorsDirection(JCalleTextSocio);
    }//GEN-LAST:event_JCalleTextSocioKeyTyped

    private void JTelefonoTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTelefonoTextSocioKeyTyped
        if (evt.getKeyChar() == ' ') {
            evt.setKeyChar('-');
        }
        if (!TEXT_CHECKER.checkPhoneNumber(JTelefonoTextSocio.getText())) {
            JTelefonoTextSocio.setForeground(new Color(204, 0, 0));
        } else {
            JTelefonoTextSocio.setForeground(Color.black);
        }
    }//GEN-LAST:event_JTelefonoTextSocioKeyTyped

    private void JNCalleTextSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JNCalleTextSocioKeyTyped
        if (evt.getKeyChar() == ' ') {
            evt.setKeyChar('0');
        }
        TEXT_CHECKER.checkColorsNumber(JNCalleTextSocio);
        if (JNCalleTextSocio.getText().isEmpty()) {
            JNCalleTextSocio.setText("N/A");
            JNCalleTextSocio.setForeground(new Color(0, 153, 0));
        }
    }//GEN-LAST:event_JNCalleTextSocioKeyTyped

    private void JTextUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextUsuarioKeyTyped
        if (evt.getKeyChar() == ' ') {
            evt.setKeyChar('-');
        }
        if (!TEXT_CHECKER.checkEmail(JTextUsuario.getText())) {
            JTextUsuario.setForeground(new Color(204, 0, 0));
        } else {
            JTextUsuario.setForeground(Color.black);
        }
    }//GEN-LAST:event_JTextUsuarioKeyTyped

    private void JNombreTextAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JNombreTextAutorKeyTyped
        TEXT_CHECKER.checkColorsNoNumber(JNombreTextAutor);
    }//GEN-LAST:event_JNombreTextAutorKeyTyped

    private void JApellidoPAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JApellidoPAutorKeyTyped
        TEXT_CHECKER.checkColorsNoNumber(JApellidoPAutor);
    }//GEN-LAST:event_JApellidoPAutorKeyTyped

    private void JApellidoMAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JApellidoMAutorKeyTyped
        TEXT_CHECKER.checkColorsNoNumber(JApellidoMAutor);
        if (JApellidoMAutor.getText().isEmpty()) {
            JApellidoMAutor.setText("N/A");
            JApellidoMAutor.setForeground(new Color(0, 153, 0));
        }
    }//GEN-LAST:event_JApellidoMAutorKeyTyped

    private void JTextContraseñaSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTextContraseñaSocioMouseClicked
        ADMINISTRADOR_CONTROLER.JTextContraseñaSocioMouseClicked(JTextContraseñaSocio);
    }//GEN-LAST:event_JTextContraseñaSocioMouseClicked

    private void JTableRLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRLibroMouseClicked
        if (evt.getClickCount() == 2) {
            Object[] jField = {JISBNText, JTituloText, JSpinnerNPag, JEstadoLibro, JListAutor, JListEditorial, JAreaLibro, JLocalizacionLibro, JSpinnerCantidad};
            ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseDoubleClicked(JTableRLibro, jField, 0);
        } else if ((evt.getModifiers() & ActionEvent.ALT_MASK) == ActionEvent.ALT_MASK) {
            if (JRadioTableComplete.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClicked((DefaultTableModel) JTableRLibro.getModel());
            } else if (JRadioTableSelection.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClickedRow(JTableRLibro);
            }
        }
    }//GEN-LAST:event_JTableRLibroMouseClicked

    private void JTableRSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRSocioMouseClicked
        if (evt.getClickCount() == 2) {
            Object[] jField = {JNombreTextSocio, JApellidoPTextSocio, JApellidoMTextSocio, null, JTelefonoTextSocio, JEstatusSocio, null, JTextUsuario};
            Object[] jField0 = {JEstadoTextSocio, JMunicipioTextSocio, JCalleTextSocio, JNCalleTextSocio};
            ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseDoubleClicked(JTableRSocio, jField, jField0, 1);
        } else if ((evt.getModifiers() & ActionEvent.ALT_MASK) == ActionEvent.ALT_MASK) {
            if (JRadioTableComplete.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClicked((DefaultTableModel) JTableRSocio.getModel());
            } else if (JRadioTableSelection.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClickedRow(JTableRSocio);
            }
        }
    }//GEN-LAST:event_JTableRSocioMouseClicked

    private void JTableRAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRAutorMouseClicked
        if (evt.getClickCount() == 2) {
            Object[] jField = {JNombreTextAutor, JApellidoPAutor, JApellidoMAutor, JComboEstatusAutor};
            ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseDoubleClicked(JTableRAutor, jField, 0);
        } else if ((evt.getModifiers() & ActionEvent.ALT_MASK) == ActionEvent.ALT_MASK) {
            if (JRadioTableComplete.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClicked((DefaultTableModel) JTableRAutor.getModel());
            } else if (JRadioTableSelection.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClickedRow(JTableRAutor);
            }
        }
    }//GEN-LAST:event_JTableRAutorMouseClicked

    private void JTableREditorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableREditorialMouseClicked
        if (evt.getClickCount() == 2) {
            Object[] jField = {JNombreTextEditorial, JComboEstatusEditorial};
            ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseDoubleClicked(JTableREditorial, jField, 0);
        } else if ((evt.getModifiers() & ActionEvent.ALT_MASK) == ActionEvent.ALT_MASK) {
            if (JRadioTableComplete.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClicked((DefaultTableModel) JTableREditorial.getModel());
            } else if (JRadioTableSelection.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClickedRow(JTableREditorial);
            }
        }
    }//GEN-LAST:event_JTableREditorialMouseClicked

    private void JTableRLocalizacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRLocalizacionMouseClicked
        if (evt.getClickCount() == 2) {
            Object[] jField = {JLocalizacionText, JComboEstatusLocalizacion};
            ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseDoubleClicked(JTableRLocalizacion, jField, 0);
        } else if ((evt.getModifiers() & ActionEvent.ALT_MASK) == ActionEvent.ALT_MASK) {
            if (JRadioTableComplete.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClicked((DefaultTableModel) JTableRLocalizacion.getModel());
            } else if (JRadioTableSelection.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClickedRow(JTableRLocalizacion);
            }
        }
    }//GEN-LAST:event_JTableRLocalizacionMouseClicked

    private void JTableRAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRAreaMouseClicked
        if (evt.getClickCount() == 2) {
            Object[] jField = {JAreaText, JComboEstatusArea};
            ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseDoubleClicked(JTableRArea, jField, 0);
        } else if ((evt.getModifiers() & ActionEvent.ALT_MASK) == ActionEvent.ALT_MASK) {
            if (JRadioTableComplete.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClicked((DefaultTableModel) JTableRArea.getModel());
            } else if (JRadioTableSelection.isSelected()) {
                ADMINISTRADOR_CONTROLER.TABLE_HELPER.JTableMouseControlClickedRow(JTableRArea);
            }
        }
    }//GEN-LAST:event_JTableRAreaMouseClicked

    private void JApellidoMTextSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JApellidoMTextSocioMouseClicked
        JApellidoMTextSocio.selectAll();
        JApellidoMTextSocio.setForeground(Color.black);
    }//GEN-LAST:event_JApellidoMTextSocioMouseClicked

    private void JApellidoMAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JApellidoMAutorMouseClicked
        JApellidoMAutor.selectAll();
        JApellidoMAutor.setForeground(Color.black);
    }//GEN-LAST:event_JApellidoMAutorMouseClicked

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

    private void JNombreTextEditorialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JNombreTextEditorialKeyTyped
        TEXT_CHECKER.checkColors(JNombreTextEditorial);
    }//GEN-LAST:event_JNombreTextEditorialKeyTyped

    private void JLocalizacionTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JLocalizacionTextKeyTyped
        TEXT_CHECKER.checkColors(JLocalizacionText);
    }//GEN-LAST:event_JLocalizacionTextKeyTyped

    private void JAreaTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JAreaTextKeyTyped
        TEXT_CHECKER.checkColors(JAreaText);
    }//GEN-LAST:event_JAreaTextKeyTyped

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void JClearTextsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JClearTextsActionPerformed
        Object[] jText = {JAreaText, JLocalizacionText, JNombreTextEditorial,
            JNombreTextAutor, JApellidoPAutor, JNombreTextSocio, JApellidoPTextSocio,
            JTelefonoTextSocio, JTextUsuario, JEstadoTextSocio, JMunicipioTextSocio,
            JCalleTextSocio, JNCalleTextSocio, JTituloText, JISBNText, JListAutor,
            JListEditorial, JAreaLibro, JLocalizacionLibro, JSpinnerNPag, JSpinnerCantidad};
        clearTexts(jText);
        JApellidoMTextSocio.setText("N/A");
        JApellidoMTextSocio.setForeground(new Color(0, 153, 0));
        JNCalleTextSocio.setText("N/A");
        JNCalleTextSocio.setForeground(new Color(0, 153, 0));
        JApellidoMAutor.setText("N/A");
        JApellidoMAutor.setForeground(new Color(0, 153, 0));
    }//GEN-LAST:event_JClearTextsActionPerformed

    private void JNCalleTextSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JNCalleTextSocioMouseClicked
        JNCalleTextSocio.selectAll();
        JNCalleTextSocio.setForeground(Color.black);
    }//GEN-LAST:event_JNCalleTextSocioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ButtonTables;
    public javax.swing.JTextField JApellidoMAutor;
    public javax.swing.JTextField JApellidoMTextSocio;
    public javax.swing.JTextField JApellidoPAutor;
    public javax.swing.JTextField JApellidoPTextSocio;
    public javax.swing.JComboBox<String> JAreaLibro;
    public javax.swing.JTextField JAreaText;
    private javax.swing.JButton JBuscarAutor;
    private javax.swing.JButton JBuscarLibro;
    private javax.swing.JButton JBuscarSocio;
    public javax.swing.JTextField JCalleTextSocio;
    public javax.swing.JCheckBox JCheckApellidoM;
    public javax.swing.JCheckBox JCheckApellidoMAutor;
    public javax.swing.JCheckBox JCheckApellidoP;
    public javax.swing.JCheckBox JCheckApellidoPAutor;
    public static javax.swing.JCheckBox JCheckAutor;
    public static javax.swing.JCheckBox JCheckEditorial;
    public javax.swing.JCheckBox JCheckISBN;
    public javax.swing.JCheckBox JCheckNombre;
    public javax.swing.JCheckBox JCheckNombreAutor;
    public javax.swing.JCheckBox JCheckTitulo;
    public javax.swing.JCheckBox JCheckUsuario;
    private javax.swing.JMenuItem JClearTexts;
    public javax.swing.JComboBox<String> JComboEstatusArea;
    public javax.swing.JComboBox<String> JComboEstatusAutor;
    public javax.swing.JComboBox<String> JComboEstatusEditorial;
    public javax.swing.JComboBox<String> JComboEstatusLocalizacion;
    public javax.swing.JButton JEliminarArea;
    private javax.swing.JButton JEliminarAutorTabla;
    public javax.swing.JButton JEliminarEditorial;
    private javax.swing.JButton JEliminarLibroTabla;
    public javax.swing.JButton JEliminarLocalizacion;
    private javax.swing.JButton JEliminarSocioTabla;
    private javax.swing.JButton JEstadisticas;
    public javax.swing.JComboBox<String> JEstadoLibro;
    public javax.swing.JTextField JEstadoTextSocio;
    public javax.swing.JComboBox<String> JEstatusSocio;
    public javax.swing.JTextField JISBNText;
    private javax.swing.JButton JIngresarAutor;
    private javax.swing.JButton JIngresarLibro;
    public javax.swing.JButton JIngresarNuevaArea;
    public javax.swing.JButton JIngresarNuevoEditorial;
    public javax.swing.JButton JIngresarNuevoLocalizacion;
    private javax.swing.JButton JIngresarSocio;
    private javax.swing.JInternalFrame JInternalAutor;
    private javax.swing.JInternalFrame JInternalBuscar;
    private javax.swing.JInternalFrame JInternalBuscar1;
    private javax.swing.JInternalFrame JInternalBuscar2;
    private javax.swing.JInternalFrame JInternalEditar1;
    private javax.swing.JInternalFrame JInternalEditar5;
    private javax.swing.JInternalFrame JInternalEditar6;
    private javax.swing.JInternalFrame JInternalLibro;
    private javax.swing.JInternalFrame JInternalSocio;
    public javax.swing.JList<String> JListAutor;
    public javax.swing.JList<String> JListEditorial;
    public javax.swing.JComboBox<String> JLocalizacionLibro;
    public javax.swing.JTextField JLocalizacionText;
    public javax.swing.JButton JModificarArea;
    private javax.swing.JButton JModificarAutorTabla;
    public javax.swing.JButton JModificarEditorial;
    private javax.swing.JButton JModificarLibroTabla;
    public javax.swing.JButton JModificarLocalizacion;
    private javax.swing.JButton JModificarSocioTabla;
    public javax.swing.JTextField JMunicipioTextSocio;
    public javax.swing.JTextField JNCalleTextSocio;
    public javax.swing.JTextField JNombreTextAutor;
    public javax.swing.JTextField JNombreTextEditorial;
    public javax.swing.JTextField JNombreTextSocio;
    private javax.swing.JRadioButtonMenuItem JRadioTableComplete;
    private javax.swing.JRadioButtonMenuItem JRadioTableSelection;
    private javax.swing.JButton JRegresar;
    public javax.swing.JSpinner JSpinnerCantidad;
    public javax.swing.JSpinner JSpinnerNPag;
    private javax.swing.JTabbedPane JTabbedAdminLibros;
    private javax.swing.JTabbedPane JTabbedBusquedaSocios;
    private javax.swing.JTabbedPane JTabbedBusquedaSocios2;
    private javax.swing.JTabbedPane JTabbedRegistroLibro;
    public javax.swing.JTable JTableRArea;
    public javax.swing.JTable JTableRAutor;
    public javax.swing.JTable JTableREditorial;
    public javax.swing.JTable JTableRLibro;
    public javax.swing.JTable JTableRLocalizacion;
    public javax.swing.JTable JTableRSocio;
    public javax.swing.JTextField JTelefonoTextSocio;
    public javax.swing.JPasswordField JTextContraseñaSocio;
    public javax.swing.JTextField JTextUsuario;
    public javax.swing.JTextField JTituloText;
    private javax.swing.JLabel jISBN;
    private javax.swing.JLabel jISBN1;
    private javax.swing.JLabel jISBN2;
    private javax.swing.JLabel jISBN3;
    private javax.swing.JLabel jISBN4;
    private javax.swing.JLabel jISBN5;
    private javax.swing.JLabel jISBN6;
    private javax.swing.JLabel jISBN7;
    private javax.swing.JLabel jIconLeeyAprende;
    public javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JLabel jNPag;
    private javax.swing.JLabel jNPag1;
    private javax.swing.JLabel jNPag2;
    private javax.swing.JLabel jNPag3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel jRegistrarLibro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jTitulo;
    private javax.swing.JLabel jTitulo1;
    private javax.swing.JLabel jTitulo10;
    private javax.swing.JLabel jTitulo13;
    private javax.swing.JLabel jTitulo14;
    private javax.swing.JLabel jTitulo15;
    private javax.swing.JLabel jTitulo16;
    private javax.swing.JLabel jTitulo17;
    private javax.swing.JLabel jTitulo18;
    private javax.swing.JLabel jTitulo2;
    private javax.swing.JLabel jTitulo3;
    private javax.swing.JLabel jTitulo4;
    private javax.swing.JLabel jTitulo5;
    private javax.swing.JLabel jTitulo6;
    private javax.swing.JLabel jTitulo7;
    private javax.swing.JLabel jTitulo8;
    // End of variables declaration//GEN-END:variables
}
