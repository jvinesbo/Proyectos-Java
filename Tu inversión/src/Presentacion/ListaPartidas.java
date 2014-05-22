package Presentacion;

import ModeloDatos.Historicos;
import ModeloDatos.Partida;
import ModeloDatos.Sesiones;
import ModeloDatos.Ventas;
import Negocio.Coordinador;
import Negocio.Utiles;
import Negocio.UtilesGraficos;
import javax.swing.JOptionPane;

public class ListaPartidas extends javax.swing.JFrame {

    private UtilesGraficos utilesGraficos;
    private Ventas ventas;
    private Sesiones sesiones;
    private Historicos historicos;
    private Partida partida;
    private Coordinador coordinador;
    private Utiles utiles;
    private int idUsuario;
    private String nombrePartida;
    private int idPartida;
    private int filaSeleccionada;

    public ListaPartidas(final int idUsuario) {
        initComponents();

        this.idUsuario = idUsuario;

        utilesGraficos = new UtilesGraficos();
        sesiones = new Sesiones();
        historicos = new Historicos();
        partida = new Partida();
        coordinador = new Coordinador();
        utiles = new Utiles();
        ventas = new Ventas();

        utilesGraficos.mostrarLabelSesion(this, idUsuario);
        utilesGraficos.centrarPanel(this, panel);
        utilesGraficos.panelTransparente(panel);
        utilesGraficos.panelTransparente(panelLista);
        utilesGraficos.panelTransparente(panelJugadores);
        utilesGraficos.pantallaCompleta(this);
        utilesGraficos.ponerIcono(this);

        sesiones.cerrar(rootPane, this, idUsuario);

        utilesGraficos.cargarComboBox(cbListaPartidas, "SELECT nombre FROM partida,userspartida\n"
                + "WHERE partida.id = userspartida.idPartida AND userspartida.idUsuario = '" + idUsuario + "';");

        utilesGraficos.renderTabla(tableCompras, false);
        utilesGraficos.renderTabla(tablePonderado, false);
        utilesGraficos.renderTabla(tableVentas, false);

        btnCompraVenta.setEnabled(false);

        cbJugadores.removeAllItems();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelLista = new javax.swing.JPanel();
        cbListaPartidas = new javax.swing.JComboBox();
        panelJugadores = new javax.swing.JPanel();
        cbJugadores = new javax.swing.JComboBox();
        lblJugadores = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCompraVenta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSaldoDisponible = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        panelCompras = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCompras = new javax.swing.JTable();
        panelVentas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePonderado = new javax.swing.JTable();
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
        setIconImage(getIconImage());

        panel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista_48.png"))); // NOI18N

        panelLista.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        cbListaPartidas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbListaPartidas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbListaPartidas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbListaPartidas.setPreferredSize(new java.awt.Dimension(61, 25));
        cbListaPartidas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbListaPartidasItemStateChanged(evt);
            }
        });
        cbListaPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbListaPartidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelListaLayout = new javax.swing.GroupLayout(panelLista);
        panelLista.setLayout(panelListaLayout);
        panelListaLayout.setHorizontalGroup(
            panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbListaPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelListaLayout.setVerticalGroup(
            panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cbListaPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelJugadores.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        cbJugadores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbJugadores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbJugadores.setPreferredSize(new java.awt.Dimension(61, 25));
        cbJugadores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbJugadoresItemStateChanged(evt);
            }
        });
        cbJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJugadoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelJugadoresLayout = new javax.swing.GroupLayout(panelJugadores);
        panelJugadores.setLayout(panelJugadoresLayout);
        panelJugadoresLayout.setHorizontalGroup(
            panelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelJugadoresLayout.setVerticalGroup(
            panelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugadoresLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cbJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lblJugadores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblJugadores.setText("Lista jugadores");

        jLabel15.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        jLabel15.setText("Partidas");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Lista partidas");

        btnCompraVenta.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCompraVenta.setText("Comprar / Vender");
        btnCompraVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraVentaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Saldo disponible:");

        txtSaldoDisponible.setEditable(false);
        txtSaldoDisponible.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Fecha final:");

        panelCompras.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tableCompras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tableCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Empresa", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableCompras);

        javax.swing.GroupLayout panelComprasLayout = new javax.swing.GroupLayout(panelCompras);
        panelCompras.setLayout(panelComprasLayout);
        panelComprasLayout.setHorizontalGroup(
            panelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelComprasLayout.setVerticalGroup(
            panelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );

        panelVentas.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tableVentas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Empresa", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableVentas);

        javax.swing.GroupLayout panelVentasLayout = new javax.swing.GroupLayout(panelVentas);
        panelVentas.setLayout(panelVentasLayout);
        panelVentasLayout.setHorizontalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelVentasLayout.setVerticalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Ponderado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tablePonderado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tablePonderado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablePonderado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(416, 416, 416))
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtSaldoDisponible))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJugadores)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(panelCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(panelVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(btnCompraVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(386, 386, 386))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15))
                .addGap(35, 35, 35)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(lblJugadores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFecha)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCompraVenta)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSaldoDisponible)
                        .addComponent(jLabel2)))
                .addContainerGap(18, Short.MAX_VALUE))
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
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbListaPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbListaPartidasActionPerformed
        if (nombrePartida != null) {
            if (nombrePartida.length() > 0) {
                if (partida.comprobarPartidasTerminadas(nombrePartida, idUsuario)) {
                    cargarInterface(idUsuario);

                    if (partida.habilitarCompraVenta() == 1) {
                        btnCompraVenta.setEnabled(false);
                    } else {
                        btnCompraVenta.setEnabled(true);
                    }
                } else {
                    cargarInterface(idUsuario);
                    btnCompraVenta.setEnabled(false);
                }
            } else {
                btnCompraVenta.setEnabled(false);
            }
        }
        this.repaint();
    }//GEN-LAST:event_cbListaPartidasActionPerformed

    private void cbListaPartidasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbListaPartidasItemStateChanged
        if (evt.getStateChange() == 1) {
            nombrePartida = cbListaPartidas.getSelectedItem().toString();
            idPartida = partida.obtenerId(nombrePartida);
        }
        this.repaint();
    }//GEN-LAST:event_cbListaPartidasItemStateChanged

    private void btnCompraVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraVentaActionPerformed
        String nombrePartidas = cbListaPartidas.getSelectedItem().toString();

        if (nombrePartidas.length() <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una partida para poder comprar o vender");
        } else {
            this.dispose();
            this.setVisible(false);
            coordinador.cambiarVista(this, "CompraVenta", idUsuario, nombrePartidas);
        }
    }//GEN-LAST:event_btnCompraVentaActionPerformed

    private void cbJugadoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbJugadoresItemStateChanged
        if (evt.getStateChange() == 1) {
            String nombreJugador = cbJugadores.getSelectedItem().toString();

            if (nombreJugador.length() > 0) {
                int idActual = utilesGraficos.obtenerId("SELECT id FROM usuarios WHERE nombreLogin = '" + nombreJugador + "'");

                if (nombrePartida != null) {
                    if (nombrePartida.length() > 0) {
                        if (partida.comprobarPartidasTerminadas(nombrePartida, idUsuario)) {
                            cargarInterface(idActual);
                        } else {
                            btnCompraVenta.setEnabled(false);
                        }
                    } else {
                        btnCompraVenta.setEnabled(false);
                    }
                }
            }
        }

        this.repaint();
    }//GEN-LAST:event_cbJugadoresItemStateChanged

    private void cargarInterface(int id) {
        utiles.vaciarTabla(tableVentas);
        utiles.vaciarTabla(tableCompras);
        utiles.vaciarTabla(tablePonderado);

        partida.setNombre(nombrePartida);

        utilesGraficos.cargarTabla(tableCompras, "SELECT fecha, nombreEmpresa, cantidad, precioCompra\n"
                + "FROM compras\n"
                + "WHERE idUsuario = '" + id + "' AND idPartida = '" + idPartida + "';");
        utilesGraficos.cargarTabla(tableVentas, "SELECT fecha, nombreEmpresa, cantidad, precioVenta\n"
                + "FROM ventas\n"
                + "WHERE idUsuario = '" + id + "' AND idPartida = '" + idPartida + "';");
        utilesGraficos.cargarTabla(tablePonderado, "SELECT nombreEmpresa, numAcciones, precio\n"
                + "FROM ponderado\n"
                + "WHERE idUsuario = '" + id + "' AND idPartida = '" + idPartida + "';");

        utilesGraficos.cargarComboBox(cbJugadores, "SELECT nombreLogin\n"
                + "FROM usuarios,userspartida\n"
                + "WHERE userspartida.idUsuario = usuarios.id AND userspartida.idPartida = (SELECT id\n"
                + "FROM partida\n"
                + "WHERE partida.nombre = '" + nombrePartida + "');");

        txtSaldoDisponible.setText(partida.saldoDisponible(id));
        txtFecha.setText(partida.fechaFinal());
    }

    private void cbJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJugadoresActionPerformed
        this.repaint();
    }//GEN-LAST:event_cbJugadoresActionPerformed

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
    private javax.swing.JButton btnCompraVenta;
    private javax.swing.JComboBox cbJugadores;
    private javax.swing.JComboBox cbListaPartidas;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblJugadores;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelCompras;
    private javax.swing.JPanel panelJugadores;
    private javax.swing.JPanel panelLista;
    private javax.swing.JPanel panelVentas;
    private javax.swing.JTable tableCompras;
    private javax.swing.JTable tablePonderado;
    private javax.swing.JTable tableVentas;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtSaldoDisponible;
    // End of variables declaration//GEN-END:variables
}
