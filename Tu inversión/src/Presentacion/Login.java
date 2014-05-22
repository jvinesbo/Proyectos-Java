package Presentacion;

import ModeloDatos.MysqlConnect;
import ModeloDatos.Sesiones;
import ModeloDatos.Usuarios;
import Negocio.Coordinador;
import Negocio.UtilesGraficos;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

public class Login extends javax.swing.JFrame {
    
    private UtilesGraficos utilesGraficos;
    private Usuarios usuarios;
    private Sesiones sesiones;
    private Coordinador coordinador;
    
    public Login() {
        initComponents();
        
        utilesGraficos = new UtilesGraficos();
        usuarios = new Usuarios();
        sesiones = new Sesiones();
        coordinador = new Coordinador();
        
        utilesGraficos.centrarPanel(this, panel);
        
        utilesGraficos.mostrarLabelSesion(this, -1);
        utilesGraficos.panelTransparente(panel);
        utilesGraficos.pantallaCompleta(this);
        utilesGraficos.cerrar(rootPane, this);
        utilesGraficos.ponerIcono(this);
        
        this.btnEntrar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreUser = new javax.swing.JTextField();
        txtContrasenya = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itRegistrarse = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itLogin = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itAcercade = new javax.swing.JMenuItem();
        itSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        jLabel3.setText("Login");

        jLabel1.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        jLabel1.setText("Nombre usuario: ");

        txtNombreUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNombreUser.setMinimumSize(new java.awt.Dimension(0, 25));
        txtNombreUser.setPreferredSize(new java.awt.Dimension(4, 25));

        txtContrasenya.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtContrasenya.setPreferredSize(new java.awt.Dimension(4, 25));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        jLabel2.setText("Contraseña: ");

        btnEntrar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(null);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/next_48.png"))); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(92, 92, 92)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContrasenya, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(158, 158, 158)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addComponent(btnEntrar)
                .addGap(32, 32, 32))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user_24.png"))); // NOI18N
        jMenu1.setText("Registrarse");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itRegistrarse.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        itRegistrarse.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itRegistrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user_16.png"))); // NOI18N
        itRegistrarse.setText("Registrarse");
        itRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itRegistrarseActionPerformed(evt);
            }
        });
        jMenu1.add(itRegistrarse);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/next_24.png"))); // NOI18N
        jMenu2.setText("Login");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        itLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/next_16.png"))); // NOI18N
        itLogin.setText("Login");
        itLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itLoginActionPerformed(evt);
            }
        });
        jMenu2.add(itLogin);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete_24.png"))); // NOI18N
        jMenu3.setText("Salir");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itAcercade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_TAB, java.awt.event.InputEvent.CTRL_MASK));
        itAcercade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itAcercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/comment_16.png"))); // NOI18N
        itAcercade.setText("Acerca de");
        itAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itAcercadeActionPerformed(evt);
            }
        });
        jMenu3.add(itAcercade);

        itSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        itSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        itSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete_16.png"))); // NOI18N
        itSalir.setText("Salir");
        itSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itSalirActionPerformed(evt);
            }
        });
        jMenu3.add(itSalir);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        sesiones.setUsuario(txtNombreUser.getText());
        sesiones.setContrasenya(txtContrasenya.getText());
        int idUsuario = sesiones.iniciarSesion();
        if (idUsuario > 0) {
            coordinador.cambiarVista(this, "UsuariosLogeados", idUsuario, "");
        }        
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void itRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itRegistrarseActionPerformed
        coordinador.cambiarVista(this, "NewUser", 0, "");
    }//GEN-LAST:event_itRegistrarseActionPerformed

    private void itLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itLoginActionPerformed
        coordinador.cambiarVista(this, "Login", 0, "");
    }//GEN-LAST:event_itLoginActionPerformed

    private void itAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itAcercadeActionPerformed
        AcercaDe acercaDe = new AcercaDe(this, true);
        acercaDe.setVisible(true);
    }//GEN-LAST:event_itAcercadeActionPerformed

    private void itSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itSalirActionPerformed
        int eleccion = JOptionPane.showConfirmDialog(rootPane, "¿Desea salir?");
        if (eleccion == 0) {
            MysqlConnect.getDbCon().cerrarConexiones();
            System.exit(0);
        }
    }//GEN-LAST:event_itSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JMenuItem itAcercade;
    private javax.swing.JMenuItem itLogin;
    private javax.swing.JMenuItem itRegistrarse;
    private javax.swing.JMenuItem itSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField txtContrasenya;
    private javax.swing.JTextField txtNombreUser;
    // End of variables declaration//GEN-END:variables
}
