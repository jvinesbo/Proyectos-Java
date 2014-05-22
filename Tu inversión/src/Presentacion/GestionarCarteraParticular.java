package Presentacion;

import ModeloDatos.Compras;
import ModeloDatos.Historicos;
import ModeloDatos.Sesiones;
import ModeloDatos.Ventas;
import Negocio.Coordinador;
import Negocio.UtilesGraficos;

public class GestionarCarteraParticular extends javax.swing.JFrame {

    private UtilesGraficos utilesGraficos;
    private Sesiones sesiones;
    private Historicos historicos;
    private Ventas ventas;
    private Compras compras;
    private Coordinador coordinador;
    private int idUsuario;
    private int filaSeleccionada;

    public GestionarCarteraParticular(final int idUsuario) {
        initComponents();

        this.idUsuario = idUsuario;

        utilesGraficos = new UtilesGraficos();
        sesiones = new Sesiones();
        historicos = new Historicos();
        ventas = new Ventas(idUsuario, 0);
        compras = new Compras(idUsuario, 0);
        coordinador = new Coordinador();

        utilesGraficos.mostrarLabelSesion(this, idUsuario);
        utilesGraficos.centrarPanel(this, panel);
        utilesGraficos.panelTransparente(panel);
        utilesGraficos.pantallaCompleta(this);
        utilesGraficos.ponerIcono(this);

        sesiones.cerrar(rootPane, this, idUsuario);

        utilesGraficos.cambiarLetraCabeceraTabla(tableCompras);
        utilesGraficos.renderTabla(tableCompras, false);
        utilesGraficos.cargarTabla(tableCompras, "SELECT fecha, nombreEmpresa, cantidad, precioCompra, total\n"
                + "FROM compras\n"
                + "WHERE idUsuario = '" + idUsuario + "' AND idPartida = '" + 0 + "';");

        utilesGraficos.cambiarLetraCabeceraTabla(tableVentas);
        utilesGraficos.cargarTabla(tableVentas, "SELECT fecha, nombreEmpresa, cantidad, precioVenta, total, gan_per\n"
                + "FROM ventas\n"
                + "WHERE idUsuario = '" + idUsuario + "' AND idPartida = '" + 0 + "';");
        utilesGraficos.renderTablaGanancias(tableVentas, false);

        utilesGraficos.cambiarLetraCabeceraTabla(tableTotales);
        utilesGraficos.renderTabla(tableTotales, false);

        utilesGraficos.cargarTablaPonderado(tablePonderado, idUsuario, 0, tableTotales);
        utilesGraficos.cambiarLetraCabeceraTabla(tablePonderado);
        utilesGraficos.renderTablaGanancias(tablePonderado, true);

        txt_total_ventas.setText(ventas.sumatorio() + "");
        txt_total_compras.setText(compras.sumatorio() + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelVentas = new javax.swing.JPanel();
        txt_total_ventas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        panelCompras = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCompras = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_total_compras = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePonderado = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTotales = new javax.swing.JTable();
        btnCompraVenta = new javax.swing.JButton();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/folder_48.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        jLabel15.setText("Gestionar Mi Cartera");

        panelVentas.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        txt_total_ventas.setEditable(false);
        txt_total_ventas.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Total ventas:");

        tableVentas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Empresa", "Cantidad", "Precio", "Total", "Gan / Per  (€)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableVentas);

        javax.swing.GroupLayout panelVentasLayout = new javax.swing.GroupLayout(panelVentas);
        panelVentas.setLayout(panelVentasLayout);
        panelVentasLayout.setHorizontalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addContainerGap(470, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txt_total_ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelVentasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelVentasLayout.setVerticalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total_ventas)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelVentasLayout.createSequentialGroup()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 27, Short.MAX_VALUE)))
        );

        panelCompras.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tableCompras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tableCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Empresa", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableCompras);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Total compras:");

        txt_total_compras.setEditable(false);
        txt_total_compras.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N

        javax.swing.GroupLayout panelComprasLayout = new javax.swing.GroupLayout(panelCompras);
        panelCompras.setLayout(panelComprasLayout);
        panelComprasLayout.setHorizontalGroup(
            panelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addGroup(panelComprasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(38, 38, 38)
                        .addComponent(txt_total_compras, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelComprasLayout.setVerticalGroup(
            panelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComprasLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_total_compras))
                .addGap(1, 1, 1))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Ponderado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tablePonderado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tablePonderado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio", "Invertido", "Precio actual", "Precio actual total", "Ganancias / Perdidas (€)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablePonderado);

        tableTotales.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tableTotales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Total invertido", "Importe total", "Ganancias / Perdidas (€)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableTotales);

        btnCompraVenta.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCompraVenta.setText("Comprar / Vender");
        btnCompraVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1295, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCompraVenta)
                        .addGap(136, 136, 136))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompraVenta))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(358, 358, 358)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(panelCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnCompraVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraVentaActionPerformed
        coordinador.cambiarVista(this, "CompraVenta", idUsuario, "");
    }//GEN-LAST:event_btnCompraVentaActionPerformed

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
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelCompras;
    private javax.swing.JPanel panelVentas;
    private javax.swing.JTable tableCompras;
    private javax.swing.JTable tablePonderado;
    private javax.swing.JTable tableTotales;
    private javax.swing.JTable tableVentas;
    private javax.swing.JTextField txt_total_compras;
    private javax.swing.JTextField txt_total_ventas;
    // End of variables declaration//GEN-END:variables
}
