package View;


import Controller.Login_controller;
import Controller.Usuario_controller;
import Model.Usuario;
import View.DashboardPrincipal;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Kevin
 */
public class frameLogin extends javax.swing.JFrame {


    Usuario_controller usuario;
    List<Usuario> usuarios;
    String user = null;
    String contrasenia = null;
    public static Usuario usuarioLogueado;
    
    public frameLogin() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Images/ramen.png")).getImage()); //src\\Reportes\\TestReporte.jasper
        
        this.setLocationRelativeTo(null);
        obtenerUsuarios();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelTOPV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelDatosV = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        Label_NombreCliente6 = new javax.swing.JLabel();
        Label_NombreCliente7 = new javax.swing.JLabel();
        txtPassword_Usuario = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        PanelTOPV.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("COMIDA CHINA LAS ROSAS");

        javax.swing.GroupLayout PanelTOPVLayout = new javax.swing.GroupLayout(PanelTOPV);
        PanelTOPV.setLayout(PanelTOPVLayout);
        PanelTOPVLayout.setHorizontalGroup(
            PanelTOPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTOPVLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addGap(38, 38, 38))
        );
        PanelTOPVLayout.setVerticalGroup(
            PanelTOPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTOPVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelDatosV.setBackground(new java.awt.Color(255, 255, 255));
        PanelDatosV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelDatosV.setMaximumSize(new java.awt.Dimension(386, 338));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo_rosas_login200px.png"))); // NOI18N
        jLabel8.setToolTipText("");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnIngresar.setBackground(new java.awt.Color(51, 153, 0));
        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setToolTipText("Ingresar");
        btnIngresar.setBorder(null);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.setFocusPainted(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        Label_NombreCliente6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Label_NombreCliente6.setText("Usuario");
        Label_NombreCliente6.setToolTipText("");

        Label_NombreCliente7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Label_NombreCliente7.setText("Contraseña");
        Label_NombreCliente7.setToolTipText("");

        txtPassword_Usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPassword_Usuario.setPreferredSize(new java.awt.Dimension(100, 20));
        txtPassword_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassword_UsuarioKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelDatosVLayout = new javax.swing.GroupLayout(PanelDatosV);
        PanelDatosV.setLayout(PanelDatosVLayout);
        PanelDatosVLayout.setHorizontalGroup(
            PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosVLayout.createSequentialGroup()
                        .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(Label_NombreCliente6)
                            .addComponent(txtUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_NombreCliente7)))
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelDatosVLayout.setVerticalGroup(
            PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosVLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_NombreCliente6)
                    .addComponent(Label_NombreCliente7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTOPV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(PanelDatosV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(PanelTOPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(PanelDatosV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        user = txtUsuario.getText();
        contrasenia = txtPassword_Usuario.getText();
        
        verificarUsuario();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtUsuario.setText("");
        txtUsuario.requestFocus();
        txtPassword_Usuario.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPassword_UsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassword_UsuarioKeyPressed
        
        int code = evt.getKeyCode();
        if(code == KeyEvent.VK_ENTER) 
        {

            user = txtUsuario.getText();
            contrasenia = txtPassword_Usuario.getText();

            verificarUsuario();                              
        }
    }//GEN-LAST:event_txtPassword_UsuarioKeyPressed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        int code = evt.getKeyCode();
        
        if(code == KeyEvent.VK_ENTER && !txtUsuario.getText().isEmpty()) 
            txtPassword_Usuario.requestFocus();
    }//GEN-LAST:event_txtUsuarioKeyPressed


    
    public void obtenerUsuarios() 
    {
        try
        {
            usuarios = Usuario_controller.listarUsuario();

        } catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        } 
    }
    
    public void verificarUsuario()
    {
        String[] args = null;
        for(int i=0; i<usuarios.size(); i++)
        {
            
            if(user.equals(usuarios.get(i).getUsuario()) && contrasenia.equals(usuarios.get(i).getContrasenia()))
            {
                int cod = usuarios.get(i).getCodigo();
                usuarioLogueado = new Usuario(cod, usuarios.get(i).getNombre(), usuarios.get(i).getTelefono(), usuarios.get(i).getUsuario(),
                                    usuarios.get(i).getContrasenia(), usuarios.get(i).getTipoUsuario());
                DashboardPrincipal.main(args);
                this.dispose();
            }
        } 
    }
    
    
//        private boolean isPasswordCorrect(char[] j1,char[] j2) 
//    {
//        boolean valor = true;
//        int puntero = 0;
//        if (j1.length != j2.length)
//        {
//            valor = false;
//        }
//        else
//        {
//            while((valor)&&(puntero < j1.length))
//            {               
//                if (j1[puntero] != j2[puntero])
//                {
//                    valor = false;
//                }
//                puntero++;
//            }
//        }
//        return valor;
//      }
    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new frameLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_NombreCliente6;
    private javax.swing.JLabel Label_NombreCliente7;
    private javax.swing.JPanel PanelDatosV;
    private javax.swing.JPanel PanelTOPV;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword_Usuario;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
