package Presentacion;

import ModeloDatos.Historicos;
import ModeloDatos.Partida;
import ModeloDatos.Sesiones;
import ModeloDatos.Usuarios;
import ModeloDatos.UsuariosPartida;
import Negocio.Coordinador;
import Negocio.Utiles;
import Negocio.UtilesGraficos;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListCellRenderer.UIResource;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class CrearJuego extends javax.swing.JFrame {

    private UtilesGraficos utilesGraficos;
    private Usuarios usuarios;
    private Utiles utiles;
    private Sesiones sesiones;
    private Historicos historicos;
    private Partida partida;
    private UsuariosPartida usuariosPartida;
    private Coordinador coordinador;
    private int idUsuario;

    public CrearJuego(final int idUsuario) {
        initComponents();

        this.idUsuario = idUsuario;

        utilesGraficos = new UtilesGraficos();
        sesiones = new Sesiones();
        historicos = new Historicos();
        usuarios = new Usuarios();
        partida = new Partida();
        utiles = new Utiles();
        usuariosPartida = new UsuariosPartida();
        coordinador = new Coordinador();
        
        utilesGraficos.centrarPanel(this, panel);

        utilesGraficos.panelTransparente(panel);
        utilesGraficos.mostrarLabelSesion(this, idUsuario);
        utilesGraficos.pantallaCompleta(this);
        utilesGraficos.ponerIcono(this);

        DefaultListModel modeloLista = new DefaultListModel<>();
        modeloLista.removeAllElements();
        listUsuarios.setModel(modeloLista);

        sesiones.cerrar(rootPane, this, idUsuario);

        //UTILIZADO PARA CENTRAR EL TEXTO DE LA LISTA DE USUARIOS
        UIResource posicion = new UIResource();
        posicion.setHorizontalAlignment(SwingConstants.CENTER);
        listUsuarios.setCellRenderer(posicion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listUsuarios = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        txtNombrePartida = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidadInicial = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnCrearPartida = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar19 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        itIBEX = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        itGestionarCartera = new javax.swing.JMenuItem();
        it_compraVenta = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itInformeDiario = new javax.swing.JMenuItem();
        itInformeHistorico = new javax.swing.JMenuItem();
        jMenu18 = new javax.swing.JMenu();
        itCrearJuego = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itLista = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        it_actualizar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itLogout = new javax.swing.JMenuItem();
        itAcercade = new javax.swing.JMenuItem();
        itSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        listUsuarios.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        listUsuarios.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(listUsuarios);

        jLabel2.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel2.setText("* Nombre partida:");

        txtNombrePartida.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNombrePartida.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel3.setText("* Cantidad Inicial:");

        txtCantidadInicial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadInicial.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel15.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        jLabel15.setText("Crear Partida");

        btnCrearPartida.setBackground(new java.awt.Color(254, 254, 254));
        btnCrearPartida.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        btnCrearPartida.setText("Crear Partida");
        btnCrearPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPartidaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel4.setText("* Fecha fin del Juego:");

        calendar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        calendar.setPreferredSize(new java.awt.Dimension(95, 25));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Lista de jugadores");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add_48.png"))); // NOI18N

        txtBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtBuscar.setPreferredSize(new java.awt.Dimension(6, 25));

        btnBuscar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel7.setText("* Para borrar un usuario pulse encima de su nombre");

        jLabel8.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel8.setText("* Introduce nombre usuario a buscar:");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(185, 185, 185)
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCantidadInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                .addGap(324, 324, 324))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(37, 37, 37)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombrePartida, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(41, 41, 41)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(37, 37, 37))))))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(btnCrearPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel15)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombrePartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnCrearPartida)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ibex_24.png"))); // NOI18N
        jMenu9.setText("IBEX   ");
        jMenu9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itIBEX.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        itIBEX.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itIBEX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ibex_16.png"))); // NOI18N
        itIBEX.setText("Mostrar datos IBEX 35");
        itIBEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itIBEXActionPerformed(evt);
            }
        });
        jMenu9.add(itIBEX);

        jMenuBar19.add(jMenu9);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compraVenta_24.png"))); // NOI18N
        jMenu5.setText("Mis Inversiones   ");
        jMenu5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itGestionarCartera.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        itGestionarCartera.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itGestionarCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add_to_folder.png"))); // NOI18N
        itGestionarCartera.setText("Gestionar Mi Cartera");
        itGestionarCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itGestionarCarteraActionPerformed(evt);
            }
        });
        jMenu5.add(itGestionarCartera);

        it_compraVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        it_compraVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        it_compraVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compraVenta_16.png"))); // NOI18N
        it_compraVenta.setText("Compra / Venta");
        it_compraVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                it_compraVentaActionPerformed(evt);
            }
        });
        jMenu5.add(it_compraVenta);
        jMenu5.add(jSeparator2);

        itInformeDiario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        itInformeDiario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itInformeDiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/folder.png"))); // NOI18N
        itInformeDiario.setText("Crear Informe Diario");
        itInformeDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itInformeDiarioActionPerformed(evt);
            }
        });
        jMenu5.add(itInformeDiario);

        itInformeHistorico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        itInformeHistorico.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itInformeHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/folder.png"))); // NOI18N
        itInformeHistorico.setText("Crear Informe Histórico");
        itInformeHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itInformeHistoricoActionPerformed(evt);
            }
        });
        jMenu5.add(itInformeHistorico);

        jMenuBar19.add(jMenu5);

        jMenu18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/juego_24.png"))); // NOI18N
        jMenu18.setText("Juego   ");
        jMenu18.setFocusable(false);
        jMenu18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itCrearJuego.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itCrearJuego.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itCrearJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/juego_16.png"))); // NOI18N
        itCrearJuego.setText("Crear Juego");
        itCrearJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itCrearJuegoActionPerformed(evt);
            }
        });
        jMenu18.add(itCrearJuego);
        jMenu18.add(jSeparator1);

        itLista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        itLista.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista_16.png"))); // NOI18N
        itLista.setText("Lista de Partidas");
        itLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itListaActionPerformed(evt);
            }
        });
        jMenu18.add(itLista);

        jMenuBar19.add(jMenu18);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh_24.png"))); // NOI18N
        jMenu1.setText("Actualizar histórico");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        it_actualizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        it_actualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        it_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh_16.png"))); // NOI18N
        it_actualizar.setText("Actualizar");
        it_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                it_actualizarActionPerformed(evt);
            }
        });
        jMenu1.add(it_actualizar);

        jMenuBar19.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete_24.png"))); // NOI18N
        jMenu2.setText("Salir");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        itLogout.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        itLogout.setText("Logout");
        itLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itLogoutActionPerformed(evt);
            }
        });
        jMenu2.add(itLogout);

        itAcercade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_TAB, java.awt.event.InputEvent.CTRL_MASK));
        itAcercade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itAcercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/comment_16.png"))); // NOI18N
        itAcercade.setText("Acerca de");
        itAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itAcercadeActionPerformed(evt);
            }
        });
        jMenu2.add(itAcercade);

        itSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete_16.png"))); // NOI18N
        itSalir.setText("Salir");
        itSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itSalirActionPerformed(evt);
            }
        });
        jMenu2.add(itSalir);

        jMenuBar19.add(jMenu2);

        setJMenuBar(jMenuBar19);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPartidaActionPerformed
        if (txtCantidadInicial.getText().isEmpty() || txtNombrePartida.getText().isEmpty() || calendar.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Los campos marcados con * \n no pueden estar vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Calendar calendario = Calendar.getInstance();
            int dia = calendario.get(Calendar.DATE);
            int mes = calendario.get(Calendar.MONTH) + 1;
            int anyo = calendario.get(Calendar.YEAR);
            String fechaEmpezar = anyo + "-" + mes + "-" + dia;

            Calendar calendarioFin = calendar.getCalendar();

            int diaFin = calendarioFin.get(Calendar.DATE);
            int mesFin = calendarioFin.get(Calendar.MONTH) + 1;
            int anyoFin = calendarioFin.get(Calendar.YEAR);
            String fechaFin = diaFin + "/" + mesFin + "/" + anyoFin;

            Date fecha = new Date();
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            String fechaSistema = formateador.format(fecha);
            
            DefaultListModel modeloLista = (DefaultListModel) listUsuarios.getModel();

            if (utiles.comprobarFechas(fechaSistema, fechaFin)) {
                if (modeloLista.size() < 1) {
                    JOptionPane.showMessageDialog(rootPane, "No puedes crear un juego sin usuarios \n con un mínimo de 2 usuarios", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        if(partida.nombrePartida("SELECT * FROM partida WHERE nombre = '" + txtNombrePartida.getText() + "';")){
                            JOptionPane.showMessageDialog(rootPane, "El nombre de la partida ya existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        } else{
                            fechaFin = anyoFin + "-" + mesFin + "-" + diaFin;
                            partida = new Partida(txtNombrePartida.getText(), idUsuario, Double.parseDouble(txtCantidadInicial.getText()), fechaEmpezar, fechaFin, 0);
                            partida.insertarBD(modeloLista.size());
                            
                            int idPartida = partida.obtenerId(txtNombrePartida.getText());
                            
                            usuariosPartida.setIdUsuario(idUsuario);
                            usuariosPartida.setIdPartida(idPartida);
                            usuariosPartida.setSaldo(Double.parseDouble(txtCantidadInicial.getText()));
                            usuariosPartida.insertarBD();
                            
                            for (int i = 0; i < modeloLista.size(); i++) {
                                int id = partida.seleccionDB("SELECT id FROM usuarios WHERE nombreLogin = '" + modeloLista.get(i).toString() + "'");
                                
                                usuariosPartida.setIdUsuario(id);
                                usuariosPartida.setIdPartida(idPartida);
                                usuariosPartida.setSaldo(Double.parseDouble(txtCantidadInicial.getText()));
                                
                                usuariosPartida.insertarBD();
                            }
                            
                            JOptionPane.showMessageDialog(rootPane, "Partida creada correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                            
                            txtNombrePartida.setText("");
                            txtCantidadInicial.setText("");
                            modeloLista.removeAllElements();
                        }
                    } catch (SQLException ex) {
                        System.err.println("ERROR: " + ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se puede crear una partida con una fecha menor a la actual.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCrearPartidaActionPerformed

    private void listUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listUsuariosMousePressed
        DefaultListModel model = (DefaultListModel) listUsuarios.getModel();

        int eleccion = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quiere borrar la fila?");

        if (eleccion == 0) {
            model.remove(listUsuarios.getSelectedIndex());
            listUsuarios.setModel(model);
        }
    }//GEN-LAST:event_listUsuariosMousePressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        usuarios.setNombreLogin(txtBuscar.getText());
        String resultado = usuarios.buscarUsuario(idUsuario);
        DefaultListModel modeloLista = (DefaultListModel) listUsuarios.getModel();
        if (modeloLista.contains(resultado)) {
            JOptionPane.showMessageDialog(rootPane, "El usuario ya se encuentra en la lista");
        } else {
            modeloLista.addElement(resultado);
            listUsuarios.setModel(modeloLista);
        }
        
        txtBuscar.setText("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void itIBEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itIBEXActionPerformed
        coordinador.cambiarVista(this, "Ibex", idUsuario, "");
    }//GEN-LAST:event_itIBEXActionPerformed

    private void itGestionarCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itGestionarCarteraActionPerformed
        coordinador.cambiarVista(this, "GestionarCarteraParticular", idUsuario, "");
    }//GEN-LAST:event_itGestionarCarteraActionPerformed

    private void it_compraVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_it_compraVentaActionPerformed
        coordinador.cambiarVista(this, "CompraVenta", idUsuario, "");
    }//GEN-LAST:event_it_compraVentaActionPerformed

    private void itInformeDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itInformeDiarioActionPerformed
        ReportDiario reportDiario = new ReportDiario(this, rootPaneCheckingEnabled, idUsuario);
        reportDiario.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_itInformeDiarioActionPerformed

    private void itInformeHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itInformeHistoricoActionPerformed
        ReportHistorico dialogoReport = new ReportHistorico(this, true, idUsuario);
        dialogoReport.setVisible(true);
    }//GEN-LAST:event_itInformeHistoricoActionPerformed

    private void itCrearJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itCrearJuegoActionPerformed
        coordinador.cambiarVista(this, "CrearJuego", idUsuario, "");
    }//GEN-LAST:event_itCrearJuegoActionPerformed

    private void itListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itListaActionPerformed
        coordinador.cambiarVista(this, "ListaPartidas", idUsuario, "");
    }//GEN-LAST:event_itListaActionPerformed

    private void it_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_it_actualizarActionPerformed
        historicos.creacionHistoricos();
    }//GEN-LAST:event_it_actualizarActionPerformed

    private void itLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itLogoutActionPerformed
        sesiones.cerrarSesion(idUsuario, rootPane, false, this);
    }//GEN-LAST:event_itLogoutActionPerformed

    private void itAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itAcercadeActionPerformed
        AcercaDe acercaDe = new AcercaDe(this, true);
        acercaDe.setVisible(true);
    }//GEN-LAST:event_itAcercadeActionPerformed

    private void itSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itSalirActionPerformed
        sesiones.cerrarSesion(idUsuario, rootPane, true, this);
    }//GEN-LAST:event_itSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearPartida;
    private com.toedter.calendar.JDateChooser calendar;
    private javax.swing.JMenuItem itAcercade;
    private javax.swing.JMenuItem itCrearJuego;
    private javax.swing.JMenuItem itGestionarCartera;
    private javax.swing.JMenuItem itIBEX;
    private javax.swing.JMenuItem itInformeDiario;
    private javax.swing.JMenuItem itInformeHistorico;
    private javax.swing.JMenuItem itLista;
    private javax.swing.JMenuItem itLogout;
    private javax.swing.JMenuItem itSalir;
    private javax.swing.JMenuItem it_actualizar;
    private javax.swing.JMenuItem it_compraVenta;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JList listUsuarios;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidadInicial;
    private javax.swing.JTextField txtNombrePartida;
    // End of variables declaration//GEN-END:variables
}
