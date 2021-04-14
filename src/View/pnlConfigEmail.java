
package View;

import Controller.Email_controller;
import Model.Email;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kevin
 */
public class pnlConfigEmail extends javax.swing.JPanel {

    public static Email datosEmail;
    String dir = null;
    String pass = null;
    
    
    public pnlConfigEmail() {
        initComponents();
        datosEmail = new Email();
        correoAlmacenado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTOPV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelDatosV = new javax.swing.JPanel();
        txtDirCorreo = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtPasswordEmail = new javax.swing.JPasswordField();
        txtPasswordEmail_confirm = new javax.swing.JPasswordField();
        lblContrasenia = new javax.swing.JLabel();
        lblContrasenia_confirm = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtCorreoAlmacenado = new javax.swing.JTextField();
        lblDireccion1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(904, 422));

        PanelTOPV.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Correo del negocio");

        javax.swing.GroupLayout PanelTOPVLayout = new javax.swing.GroupLayout(PanelTOPV);
        PanelTOPV.setLayout(PanelTOPVLayout);
        PanelTOPVLayout.setHorizontalGroup(
            PanelTOPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTOPVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(666, Short.MAX_VALUE))
        );
        PanelTOPVLayout.setVerticalGroup(
            PanelTOPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTOPVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        PanelDatosV.setBackground(new java.awt.Color(255, 255, 255));
        PanelDatosV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelDatosV.setMaximumSize(new java.awt.Dimension(386, 338));

        lblDireccion.setText("Dirreción de correo");
        lblDireccion.setToolTipText("");

        txtPasswordEmail.setPreferredSize(new java.awt.Dimension(100, 20));

        txtPasswordEmail_confirm.setPreferredSize(new java.awt.Dimension(100, 20));

        lblContrasenia.setText("Contraseña");
        lblContrasenia.setToolTipText("");

        lblContrasenia_confirm.setText("Confirme contraseña");
        lblContrasenia_confirm.setToolTipText("");

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar_color.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar correo");
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar_color.png"))); // NOI18N
        btnEditar.setToolTipText("Editar correo");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setFocusPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar_color.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar correo");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar_color.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtCorreoAlmacenado.setEditable(false);
        txtCorreoAlmacenado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCorreoAlmacenado.setFocusable(false);

        lblDireccion1.setText("Direccion almacenada");
        lblDireccion1.setToolTipText("");

        javax.swing.GroupLayout PanelDatosVLayout = new javax.swing.GroupLayout(PanelDatosV);
        PanelDatosV.setLayout(PanelDatosVLayout);
        PanelDatosVLayout.setHorizontalGroup(
            PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosVLayout.createSequentialGroup()
                        .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosVLayout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelDatosVLayout.createSequentialGroup()
                                .addComponent(lblDireccion)
                                .addGap(19, 19, 19)
                                .addComponent(txtDirCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDireccion1)
                                    .addComponent(txtCorreoAlmacenado, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(144, 144, 144))
                    .addGroup(PanelDatosVLayout.createSequentialGroup()
                        .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContrasenia)
                            .addComponent(lblContrasenia_confirm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPasswordEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPasswordEmail_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelDatosVLayout.setVerticalGroup(
            PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosVLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDirCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasenia)
                    .addComponent(txtPasswordEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasenia_confirm)
                    .addComponent(txtPasswordEmail_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(PanelDatosVLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblDireccion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreoAlmacenado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTOPV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelDatosV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTOPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelDatosV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void limpiar()
    {
        txtDirCorreo.setText("");
        txtPasswordEmail.setText("");
        txtPasswordEmail_confirm.setText("");
    }
    
    
    private void correoAlmacenado()
    {
        dir = null;
        pass = null;
        Email_controller.leerEmailFromFile();
        dir = datosEmail.getDireccion();
        pass = datosEmail.getContrasenia();
                
        txtCorreoAlmacenado.setText(datosEmail.getDireccion());
    }
    
    
    public void guardarEmail() 
    {       
        if(!txtDirCorreo.getText().isEmpty() && (!txtPasswordEmail.getText().isEmpty() && !txtPasswordEmail_confirm.getText().isEmpty()))
        {
            String correo = txtDirCorreo.getText();
            String contrasenia = txtPasswordEmail.getText();
            String contraseniaConfirm = txtPasswordEmail_confirm.getText();  
                        
            if(validarMail(correo) == true)
            {
                if(contrasenia.equals(contraseniaConfirm))
                {
                    datosEmail.setDireccion(correo);
                    datosEmail.setContrasenia(contrasenia);

                    try{
                        Email_controller.almacenarEmailInFile();
                        correoAlmacenado();
                        
                        limpiar();
                        txtDirCorreo.requestFocus();
                        
                    } catch (IOException ex) {
                        Logger.getLogger(pnlConfigEmail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else
                {
                    Email_controller.Notificaciones("passwordIncorrect");
                    txtPasswordEmail.setText("");   txtPasswordEmail_confirm.setText("");
                    txtPasswordEmail.requestFocus();
                }
            }
            else
                Email_controller.Notificaciones("mailIncorrect");                               
        }                   
    }
    
    
    public void editarEmail()
    {        
        txtDirCorreo.setText(txtCorreoAlmacenado.getText());
        txtPasswordEmail.setText(pass);
        txtPasswordEmail_confirm.setText(pass);                            
    }
    
     public static boolean validarMail(String email) 
    {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
    
    
    
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        guardarEmail();
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarEmail();
        txtDirCorreo.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        Email_controller.eliminarFile();
        correoAlmacenado();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
        txtDirCorreo.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatosV;
    private javax.swing.JPanel PanelTOPV;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblContrasenia_confirm;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccion1;
    private javax.swing.JTextField txtCorreoAlmacenado;
    private javax.swing.JTextField txtDirCorreo;
    private javax.swing.JPasswordField txtPasswordEmail;
    private javax.swing.JPasswordField txtPasswordEmail_confirm;
    // End of variables declaration//GEN-END:variables
}
