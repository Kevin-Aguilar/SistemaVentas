
package View;

import Controller.Configuraciones;
import javax.swing.JPanel;

/**
 *
 * @author kevin
 */
public class pnlConfiguraciones extends javax.swing.JPanel
{

    public pnlConfiguraciones()
    {
        initComponents();
        btnTest.setVisible(false);
        //Configuraciones.escrituraArchivoPropiedades();
        //Configuraciones.leer();
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

        PanelConfiguraciones = new javax.swing.JPanel();
        PanelTOPC = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        PanelMenuC = new javax.swing.JPanel();
        btnTest = new javax.swing.JButton();
        btn_respaldo_datos = new javax.swing.JButton();
        btnAgregar_usuarios = new javax.swing.JButton();
        btnConfig_email = new javax.swing.JButton();
        pnlBody = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1078, 550));

        PanelConfiguraciones.setBackground(new java.awt.Color(255, 255, 255));
        PanelConfiguraciones.setPreferredSize(new java.awt.Dimension(1078, 540));

        PanelTOPC.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPC.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 204));
        jLabel22.setText("Configuraciones");

        javax.swing.GroupLayout PanelTOPCLayout = new javax.swing.GroupLayout(PanelTOPC);
        PanelTOPC.setLayout(PanelTOPCLayout);
        PanelTOPCLayout.setHorizontalGroup(
            PanelTOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTOPCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(852, Short.MAX_VALUE))
        );
        PanelTOPCLayout.setVerticalGroup(
            PanelTOPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTOPCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addContainerGap())
        );

        PanelMenuC.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenuC.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelMenuC.setMaximumSize(new java.awt.Dimension(386, 338));

        btnTest.setBackground(new java.awt.Color(255, 255, 255));
        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/importarDB.png"))); // NOI18N
        btnTest.setText("Importar BD");
        btnTest.setBorder(null);
        btnTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTest.setFocusPainted(false);
        btnTest.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTest.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btn_respaldo_datos.setBackground(new java.awt.Color(255, 255, 255));
        btn_respaldo_datos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/configDB.png"))); // NOI18N
        btn_respaldo_datos.setText("Respaldo de datos");
        btn_respaldo_datos.setBorder(null);
        btn_respaldo_datos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_respaldo_datos.setFocusPainted(false);
        btn_respaldo_datos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_respaldo_datos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_respaldo_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_respaldo_datosActionPerformed(evt);
            }
        });

        btnAgregar_usuarios.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/agregar_usuario.png"))); // NOI18N
        btnAgregar_usuarios.setText("Usuarios del sistema");
        btnAgregar_usuarios.setBorder(null);
        btnAgregar_usuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar_usuarios.setFocusPainted(false);
        btnAgregar_usuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAgregar_usuarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregar_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar_usuariosActionPerformed(evt);
            }
        });

        btnConfig_email.setBackground(new java.awt.Color(255, 255, 255));
        btnConfig_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/email_config.png"))); // NOI18N
        btnConfig_email.setText("Correo del negocio");
        btnConfig_email.setBorder(null);
        btnConfig_email.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfig_email.setFocusPainted(false);
        btnConfig_email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConfig_email.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConfig_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfig_emailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuCLayout = new javax.swing.GroupLayout(PanelMenuC);
        PanelMenuC.setLayout(PanelMenuCLayout);
        PanelMenuCLayout.setHorizontalGroup(
            PanelMenuCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuCLayout.createSequentialGroup()
                .addGroup(PanelMenuCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_respaldo_datos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(btnAgregar_usuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfig_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelMenuCLayout.setVerticalGroup(
            PanelMenuCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuCLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnAgregar_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_respaldo_datos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfig_email, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlBody.setMinimumSize(new java.awt.Dimension(400, 360));
        pnlBody.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout PanelConfiguracionesLayout = new javax.swing.GroupLayout(PanelConfiguraciones);
        PanelConfiguraciones.setLayout(PanelConfiguracionesLayout);
        PanelConfiguracionesLayout.setHorizontalGroup(
            PanelConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelConfiguracionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTOPC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelConfiguracionesLayout.createSequentialGroup()
                        .addComponent(PanelMenuC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelConfiguracionesLayout.setVerticalGroup(
            PanelConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelConfiguracionesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(PanelTOPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelConfiguracionesLayout.createSequentialGroup()
                        .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(PanelConfiguracionesLayout.createSequentialGroup()
                        .addComponent(PanelMenuC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelConfiguraciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelConfiguraciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregar_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_usuariosActionPerformed

        
        CambiaPanel(pnlBody, new pnlUsuarios());        
    }//GEN-LAST:event_btnAgregar_usuariosActionPerformed

    private void btn_respaldo_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_respaldo_datosActionPerformed
        CambiaPanel(pnlBody, new pnlRespaldoDatos());  
    }//GEN-LAST:event_btn_respaldo_datosActionPerformed

    private void btnConfig_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfig_emailActionPerformed
         CambiaPanel(pnlBody, new pnlConfigEmail()); 
    }//GEN-LAST:event_btnConfig_emailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelConfiguraciones;
    private javax.swing.JPanel PanelMenuC;
    private javax.swing.JPanel PanelTOPC;
    private javax.swing.JButton btnAgregar_usuarios;
    private javax.swing.JButton btnConfig_email;
    private javax.swing.JButton btnTest;
    private javax.swing.JButton btn_respaldo_datos;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel pnlBody;
    // End of variables declaration//GEN-END:variables
}
