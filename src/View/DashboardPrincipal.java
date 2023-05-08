
package View;

import Controller.DB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Kevin
 */
public class DashboardPrincipal extends javax.swing.JFrame {

    static boolean maximized = true;
    int xMouse;
    int yMouse;
 
    public DashboardPrincipal() 
    {
        initComponents();
        frameLogin.usuarioLogueado.getNombre();
        lblUsuariolog.setText(frameLogin.usuarioLogueado.getNombre());
        lblTipoUsuariolog.setText(frameLogin.usuarioLogueado.getTipoUsuario());
        verificaRol(frameLogin.usuarioLogueado.getTipoUsuario());
        abrirMaximizado();
       //Layout();
    }

    
    private void abrirMaximizado()
    {
        DashboardPrincipal.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        DashboardPrincipal.this.setMaximizedBounds(env.getMaximumWindowBounds());
        maximized = false;
    }
    
    private void verificaRol(String rol)
    {
        if("vendedor".equalsIgnoreCase(rol))
        {
            btnConfiguraciones.setEnabled(false);
            //btnConfiguraciones.setBackground(new Color(204,204,204));
            btnConfiguraciones.setOpaque(true);
        }

    }
    
    private void Layout()
    {
        setLayout(new BorderLayout());
        add(pnlTop, BorderLayout.NORTH);
        //add(pnlMenu, BorderLayout.PAGE_END);
        add(pnlBody, BorderLayout.CENTER);
       // add(pnlBottom, BorderLayout.SOUTH);
        
    }
    
    
    private JPanel container;
    private JPanel content;
    public void CambiaPanel(JPanel container, JPanel content) {
        this.container = container;
        this.content = content;
        this.container.removeAll();
        this.container.revalidate();
        this.container.repaint();
        
        this.container.add(this.content);
        this.container.revalidate();
        this.container.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnMaximize = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTittleBussiness = new javax.swing.JLabel();
        btnSell = new javax.swing.JButton();
        lblSell = new javax.swing.JLabel();
        btnAgregarClientes = new javax.swing.JButton();
        lblAgregarProductos = new javax.swing.JLabel();
        btnReportes = new javax.swing.JButton();
        lblAgregarClientes = new javax.swing.JLabel();
        btnConfiguraciones = new javax.swing.JButton();
        lblConfiguraciones = new javax.swing.JLabel();
        lblUsuariolog = new javax.swing.JLabel();
        lblTipoUsuariolog = new javax.swing.JLabel();
        btnAgregarProductos = new javax.swing.JButton();
        lblReportes = new javax.swing.JLabel();
        btnSalir = new lib.RSButtonMetro();
        btnCerrarSesion = new lib.RSButtonMetro();
        pnlBody = new javax.swing.JPanel();
        pnlSell = new javax.swing.JPanel();
        pnlCierreDiario = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnCierreDiario = new lib.RSButtonMetro();
        pnlVentas = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnFacturar = new lib.RSButtonMetro();
        pnlAnularVenta = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnAnularVenta = new lib.RSButtonMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COMIDA CHINA EL DRAGÓN ");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new ImageIcon(getClass().getResource("/Images/ramen.png")).getImage());
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(100, 1000));
        setSize(new java.awt.Dimension(1500, 650));

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop.setForeground(new java.awt.Color(255, 255, 255));
        pnlTop.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTopMouseDragged(evt);
            }
        });
        pnlTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTopMousePressed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusable(false);
        btnExit.setOpaque(true);
        btnExit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit (2).png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnMaximize.setBackground(new java.awt.Color(255, 255, 255));
        btnMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maximize.png"))); // NOI18N
        btnMaximize.setContentAreaFilled(false);
        btnMaximize.setFocusable(false);
        btnMaximize.setOpaque(true);
        btnMaximize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maximize (2).png"))); // NOI18N
        btnMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMaximizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMaximizeMouseExited(evt);
            }
        });
        btnMaximize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaximizeActionPerformed(evt);
            }
        });

        btnMinimize.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minimize.png"))); // NOI18N
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setFocusable(false);
        btnMinimize.setOpaque(true);
        btnMinimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minimize (2).png"))); // NOI18N
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseExited(evt);
            }
        });
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExit))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMaximize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ramen.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTittleBussiness.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 28)); // NOI18N
        lblTittleBussiness.setForeground(new java.awt.Color(0, 153, 153));
        lblTittleBussiness.setText("COMIDA CHINA LAS ROSAS");

        btnSell.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSell.setForeground(new java.awt.Color(44, 62, 80));
        btnSell.setText("VENTAS");
        btnSell.setContentAreaFilled(false);
        btnSell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSell.setFocusable(false);
        btnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellActionPerformed(evt);
            }
        });

        lblSell.setBackground(new java.awt.Color(0, 204, 106));
        lblSell.setOpaque(true);

        btnAgregarClientes.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAgregarClientes.setForeground(new java.awt.Color(44, 62, 80));
        btnAgregarClientes.setText("AGREGAR CLIENTES");
        btnAgregarClientes.setContentAreaFilled(false);
        btnAgregarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarClientes.setFocusable(false);
        btnAgregarClientes.setPreferredSize(new java.awt.Dimension(100, 27));
        btnAgregarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClientesActionPerformed(evt);
            }
        });

        lblAgregarProductos.setBackground(new java.awt.Color(255, 255, 255));
        lblAgregarProductos.setOpaque(true);

        btnReportes.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(44, 62, 80));
        btnReportes.setText("REPORTES");
        btnReportes.setContentAreaFilled(false);
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setFocusable(false);
        btnReportes.setPreferredSize(new java.awt.Dimension(100, 27));
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        lblAgregarClientes.setBackground(new java.awt.Color(255, 255, 255));
        lblAgregarClientes.setOpaque(true);
        lblAgregarClientes.setPreferredSize(new java.awt.Dimension(100, 0));

        btnConfiguraciones.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnConfiguraciones.setForeground(new java.awt.Color(44, 62, 80));
        btnConfiguraciones.setText("CONFIGURACIÓN");
        btnConfiguraciones.setContentAreaFilled(false);
        btnConfiguraciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguraciones.setFocusable(false);
        btnConfiguraciones.setPreferredSize(new java.awt.Dimension(100, 27));
        btnConfiguraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionesActionPerformed(evt);
            }
        });

        lblConfiguraciones.setBackground(new java.awt.Color(255, 255, 255));
        lblConfiguraciones.setOpaque(true);
        lblConfiguraciones.setPreferredSize(new java.awt.Dimension(100, 0));

        lblUsuariolog.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuariolog.setForeground(java.awt.SystemColor.textHighlight);
        lblUsuariolog.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuariolog.setText("Nombre logueado");
        lblUsuariolog.setPreferredSize(new java.awt.Dimension(150, 20));

        lblTipoUsuariolog.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTipoUsuariolog.setForeground(new java.awt.Color(52, 152, 219));
        lblTipoUsuariolog.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTipoUsuariolog.setText("rol");
        lblTipoUsuariolog.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblTipoUsuariolog.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTipoUsuariolog.setPreferredSize(new java.awt.Dimension(100, 20));

        btnAgregarProductos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAgregarProductos.setForeground(new java.awt.Color(44, 62, 80));
        btnAgregarProductos.setText("AGREGAR PRODUCTOS");
        btnAgregarProductos.setContentAreaFilled(false);
        btnAgregarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProductos.setFocusable(false);
        btnAgregarProductos.setPreferredSize(new java.awt.Dimension(100, 27));
        btnAgregarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductosActionPerformed(evt);
            }
        });

        lblReportes.setBackground(new java.awt.Color(255, 255, 255));
        lblReportes.setOpaque(true);
        lblReportes.setPreferredSize(new java.awt.Dimension(100, 0));

        btnSalir.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnSalir.setText("Salir");
        btnSalir.setColorBorde(javax.swing.BorderFactory.createTitledBorder(""));
        btnSalir.setColorHover(new java.awt.Color(204, 0, 51));
        btnSalir.setColorNormal(new java.awt.Color(204, 0, 51));
        btnSalir.setColorPressed(new java.awt.Color(204, 0, 51));
        btnSalir.setFocusPainted(false);
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(102, 102, 0));
        btnCerrarSesion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCerrarSesion.setText("Cerrar sesion");
        btnCerrarSesion.setColorBorde(javax.swing.BorderFactory.createTitledBorder(""));
        btnCerrarSesion.setColorHover(new java.awt.Color(102, 102, 0));
        btnCerrarSesion.setColorNormal(new java.awt.Color(102, 102, 0));
        btnCerrarSesion.setColorPressed(new java.awt.Color(102, 102, 0));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSell)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblSell, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnAgregarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnAgregarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblAgregarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAgregarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(28, 28, 28)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnConfiguraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblConfiguraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblUsuariolog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipoUsuariolog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTittleBussiness)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoUsuariolog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuariolog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblTittleBussiness))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMenuLayout.createSequentialGroup()
                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSell)
                                .addComponent(btnAgregarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAgregarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnConfiguraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAgregarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlMenuLayout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblAgregarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSell, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(lblReportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblConfiguraciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlBody.setMinimumSize(new java.awt.Dimension(654, 630));
        pnlBody.setLayout(new java.awt.CardLayout());

        pnlSell.setBackground(new java.awt.Color(255, 255, 255));

        pnlCierreDiario.setBackground(new java.awt.Color(255, 255, 255));
        pnlCierreDiario.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlCierreDiario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlCierreDiario.setPreferredSize(new java.awt.Dimension(233, 226));

        jLabel7.setBackground(new java.awt.Color(52, 152, 219));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cierre Diario");
        jLabel7.setOpaque(true);

        btnCierreDiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cierre_caja.png"))); // NOI18N
        btnCierreDiario.setColorHover(new java.awt.Color(52, 152, 219));
        btnCierreDiario.setColorNormal(new java.awt.Color(255, 255, 255));
        btnCierreDiario.setColorPressed(new java.awt.Color(52, 152, 219));
        btnCierreDiario.setFocusPainted(false);
        btnCierreDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCierreDiarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCierreDiarioLayout = new javax.swing.GroupLayout(pnlCierreDiario);
        pnlCierreDiario.setLayout(pnlCierreDiarioLayout);
        pnlCierreDiarioLayout.setHorizontalGroup(
            pnlCierreDiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCierreDiario, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );
        pnlCierreDiarioLayout.setVerticalGroup(
            pnlCierreDiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCierreDiarioLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCierreDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlVentas.setBackground(new java.awt.Color(255, 255, 255));
        pnlVentas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlVentas.setPreferredSize(new java.awt.Dimension(233, 226));

        jLabel9.setBackground(new java.awt.Color(0, 204, 106));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Facturar");
        jLabel9.setOpaque(true);

        btnFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/facturar.png"))); // NOI18N
        btnFacturar.setColorHover(new java.awt.Color(0, 204, 106));
        btnFacturar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnFacturar.setColorPressed(new java.awt.Color(0, 204, 106));
        btnFacturar.setFocusPainted(false);
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVentasLayout = new javax.swing.GroupLayout(pnlVentas);
        pnlVentas.setLayout(pnlVentasLayout);
        pnlVentasLayout.setHorizontalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnFacturar, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );
        pnlVentasLayout.setVerticalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentasLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlAnularVenta.setBackground(new java.awt.Color(255, 255, 255));
        pnlAnularVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlAnularVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlAnularVenta.setPreferredSize(new java.awt.Dimension(233, 226));

        jLabel10.setBackground(new java.awt.Color(204, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Anular Venta");
        jLabel10.setOpaque(true);

        btnAnularVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/anular venta.png"))); // NOI18N
        btnAnularVenta.setColorHover(new java.awt.Color(204, 0, 0));
        btnAnularVenta.setColorNormal(new java.awt.Color(255, 255, 255));
        btnAnularVenta.setColorPressed(new java.awt.Color(204, 0, 0));
        btnAnularVenta.setFocusPainted(false);
        btnAnularVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAnularVentaLayout = new javax.swing.GroupLayout(pnlAnularVenta);
        pnlAnularVenta.setLayout(pnlAnularVentaLayout);
        pnlAnularVentaLayout.setHorizontalGroup(
            pnlAnularVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAnularVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );
        pnlAnularVentaLayout.setVerticalGroup(
            pnlAnularVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnularVentaLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnularVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlSellLayout = new javax.swing.GroupLayout(pnlSell);
        pnlSell.setLayout(pnlSellLayout);
        pnlSellLayout.setHorizontalGroup(
            pnlSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSellLayout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(pnlVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(pnlAnularVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(pnlCierreDiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        pnlSellLayout.setVerticalGroup(
            pnlSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSellLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(pnlSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(pnlCierreDiario, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(pnlAnularVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap(310, Short.MAX_VALUE))
        );

        pnlBody.add(pnlSell, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1004, 828));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(new Color(232,17,35));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnMaximizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizeMouseEntered
        btnMaximize.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_btnMaximizeMouseEntered

    private void btnMaximizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizeMouseExited
        btnMaximize.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnMaximizeMouseExited

    private void btnMaximizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaximizeActionPerformed
        if(maximized){
            //handle fullscreen - taskbar
            DashboardPrincipal.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            DashboardPrincipal.this.setMaximizedBounds(env.getMaximumWindowBounds());
            maximized = false;
        }else{
            setExtendedState(JFrame.NORMAL);
            maximized = true;
        }
    }//GEN-LAST:event_btnMaximizeActionPerformed

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        btnMinimize.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseExited
        btnMinimize.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnMinimizeMouseExited

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void pnlTopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlTopMousePressed

    private void pnlTopMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseDragged
        if(maximized){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
        }
    }//GEN-LAST:event_pnlTopMouseDragged

    private void btnAgregarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClientesActionPerformed
        lblAgregarClientes.setBackground(new Color(0,204,106));
        
        lblSell.setBackground(new Color(255,255,255));
        lblReportes.setBackground(new Color(255,255,255));
        lblAgregarProductos.setBackground(new Color(255,255,255));
        lblConfiguraciones.setBackground(new Color(255,255,255));
        
        pnlClientes pC;
        
        CambiaPanel(pnlBody, pC = new pnlClientes());
        pC.transferFocus();
    }//GEN-LAST:event_btnAgregarClientesActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        lblReportes.setBackground(new Color(0,204,106));
        
        lblSell.setBackground(new Color(255,255,255));
        lblAgregarClientes.setBackground(new Color(255,255,255));       
        lblAgregarProductos.setBackground(new Color(255,255,255));
        lblConfiguraciones.setBackground(new Color(255,255,255));
        
        CambiaPanel(pnlBody, new pnlReportes());
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnConfiguracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionesActionPerformed
        lblConfiguraciones.setBackground(new Color(0,204,106));
        
        lblSell.setBackground(new Color(255,255,255));
        lblReportes.setBackground(new Color(255,255,255));
        lblAgregarProductos.setBackground(new Color(255,255,255));
        lblAgregarClientes.setBackground(new Color(255,255,255));
                
        CambiaPanel(pnlBody, new pnlConfiguraciones());
    }//GEN-LAST:event_btnConfiguracionesActionPerformed

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSellActionPerformed
        lblSell.setBackground(new Color(0,204,106));
        
        lblConfiguraciones.setBackground(new Color(255,255,255));
        lblReportes.setBackground(new Color(255,255,255));
        lblAgregarProductos.setBackground(new Color(255,255,255));
        lblAgregarClientes.setBackground(new Color(255,255,255));
        
        CambiaPanel(pnlBody, pnlSell);
    }//GEN-LAST:event_btnSellActionPerformed

    private void btnAgregarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductosActionPerformed
        lblAgregarProductos.setBackground(new Color(0,204,106));
        
        lblSell.setBackground(new Color(255,255,255));
        lblAgregarClientes.setBackground(new Color(255,255,255));
        lblConfiguraciones.setBackground(new Color(255,255,255));
        lblReportes.setBackground(new Color(255,255,255));

        pnlProductos pP;  
       CambiaPanel(pnlBody, pP = new pnlProductos());
       pP.transferFocus();
    }//GEN-LAST:event_btnAgregarProductosActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed

        if(maximized == false){
          //DashboardPrincipal.this.setExtendedState(JFrame.NORMAL);
            new pnlVentas().setVisible(true);
            this.dispose();
            //this.setState(Frame.ICONIFIED);
            maximized = true;
            
        }else{
            new pnlVentas().setVisible(maximized);
            this.dispose();
        }
    }//GEN-LAST:event_btnFacturarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCierreDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCierreDiarioActionPerformed
        lblSell.setBackground(new Color(0,204,106));
        
        lblConfiguraciones.setBackground(new Color(255,255,255));
        lblReportes.setBackground(new Color(255,255,255));
        lblAgregarProductos.setBackground(new Color(255,255,255));
        lblAgregarClientes.setBackground(new Color(255,255,255));
        
       CambiaPanel(pnlBody, new pnlCierreDiario());
    }//GEN-LAST:event_btnCierreDiarioActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        String[] args = null;
        frameLogin.main(args);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnAnularVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularVentaActionPerformed
        lblSell.setBackground(new Color(0,204,106));
        
        lblConfiguraciones.setBackground(new Color(255,255,255));
        lblReportes.setBackground(new Color(255,255,255));
        lblAgregarProductos.setBackground(new Color(255,255,255));
        lblAgregarClientes.setBackground(new Color(255,255,255));
        
        pnlEliminarVenta pe;
        CambiaPanel(pnlBody, pe = new pnlEliminarVenta());
        pe.transferFocus();
    }//GEN-LAST:event_btnAnularVentaActionPerformed


    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarClientes;
    private javax.swing.JButton btnAgregarProductos;
    private lib.RSButtonMetro btnAnularVenta;
    private lib.RSButtonMetro btnCerrarSesion;
    private lib.RSButtonMetro btnCierreDiario;
    private javax.swing.JButton btnConfiguraciones;
    private javax.swing.JButton btnExit;
    private lib.RSButtonMetro btnFacturar;
    private javax.swing.JButton btnMaximize;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnReportes;
    private lib.RSButtonMetro btnSalir;
    private javax.swing.JButton btnSell;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAgregarClientes;
    private javax.swing.JLabel lblAgregarProductos;
    private javax.swing.JLabel lblConfiguraciones;
    private javax.swing.JLabel lblReportes;
    private javax.swing.JLabel lblSell;
    private javax.swing.JLabel lblTipoUsuariolog;
    private javax.swing.JLabel lblTittleBussiness;
    private javax.swing.JLabel lblUsuariolog;
    private javax.swing.JPanel pnlAnularVenta;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlCierreDiario;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlSell;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel pnlVentas;
    // End of variables declaration//GEN-END:variables
}
