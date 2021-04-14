
package View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Kevin
 */
public class pnlRespaldoDatos extends javax.swing.JPanel {

JFileChooser RealizarCopiaSeguridadMySQL=new JFileChooser();


    public pnlRespaldoDatos() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTOPV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelDatosV = new javax.swing.JPanel();
        btnCopiaSeguridad = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        PanelTOPV.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Datos e información");

        javax.swing.GroupLayout PanelTOPVLayout = new javax.swing.GroupLayout(PanelTOPV);
        PanelTOPV.setLayout(PanelTOPVLayout);
        PanelTOPVLayout.setHorizontalGroup(
            PanelTOPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTOPVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(650, Short.MAX_VALUE))
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

        btnCopiaSeguridad.setBackground(new java.awt.Color(255, 255, 255));
        btnCopiaSeguridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/copia_seguridad.png"))); // NOI18N
        btnCopiaSeguridad.setText("Realizar copia de seguridad");
        btnCopiaSeguridad.setToolTipText("");
        btnCopiaSeguridad.setBorder(null);
        btnCopiaSeguridad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCopiaSeguridad.setFocusPainted(false);
        btnCopiaSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiaSeguridadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDatosVLayout = new javax.swing.GroupLayout(PanelDatosV);
        PanelDatosV.setLayout(PanelDatosVLayout);
        PanelDatosVLayout.setHorizontalGroup(
            PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCopiaSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
        );
        PanelDatosVLayout.setVerticalGroup(
            PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCopiaSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTOPV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelDatosV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTOPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelDatosV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
             
void GenerarCopiaSeguridadMySQL()
{
        int resp;
        Calendar c=Calendar.getInstance();
        String fecha=String.valueOf(c.get(Calendar.DATE));
        fecha=fecha+"-"+String.valueOf(c.get(Calendar.MONTH)+1);
        fecha=fecha+"-"+String.valueOf(c.get(Calendar.YEAR));

        resp=RealizarCopiaSeguridadMySQL.showSaveDialog(this);//JFileChooser de nombre RealizarBackupMySQL
        
        if (resp==JFileChooser.APPROVE_OPTION) 
        {//Si el usuario presiona aceptar; se genera el Backup
            try{
                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File(String.valueOf(RealizarCopiaSeguridadMySQL.getSelectedFile().toString())
                        +"_"+fecha+".sql");
                FileWriter fw = new FileWriter(backupFile);
                Process child = runtime.exec("C:\\Archivos de programa\\MySQL\\MySQL Server 8.0\\bin\\mysqldump --opt --password=12345 --user=root "
                        + "--databases sistemaventas"); 
                InputStreamReader irs = new InputStreamReader(child.getInputStream());
                BufferedReader br = new BufferedReader(irs);

                String line;
                while( (line=br.readLine()) != null ) {
                    fw.write(line + "\n");
                }
                fw.close();
                irs.close();
                br.close();

                
            }catch(Exception e)
            {
                Notificaciones("backupError");
                //JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo:"+e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
            }
            
            Notificaciones("backupSuccess");
            //JOptionPane.showMessageDialog(null, "Archivogenerado","Verificar",JOptionPane.INFORMATION_MESSAGE);
            
        } else if (resp==JFileChooser.CANCEL_OPTION) {
           // JOptionPane.showMessageDialog(null,"Ha sido cancelada la generacion del Backup");
        }
    }
    

    public static void Notificaciones(String accion)
    {
        switch(accion)
        {
            case "backupSuccess":
                    new rojerusan.RSNotifyAnimated("", "Se realizó la copia de seguridad exitosamente", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                            RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                 break;

            case "backupError":
                new rojerusan.RSNotifyAnimated("", "No se pudo realizar la copia de seguridad", 3, RSNotifyAnimated.PositionNotify.BottomRight,
                        RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                break;
                
        }   
    }
    
    private void btnCopiaSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiaSeguridadActionPerformed
        GenerarCopiaSeguridadMySQL();
    }//GEN-LAST:event_btnCopiaSeguridadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatosV;
    private javax.swing.JPanel PanelTOPV;
    private javax.swing.JButton btnCopiaSeguridad;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
