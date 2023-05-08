
package View;

import Controller.Ventas_controller;
import static Controller.Ventas_controller.listaDetalle;
import Model.Cliente;
import Model.Ventas;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Kevin
 */
public class pnlEliminarVenta extends javax.swing.JPanel {

     
    int numeroFactura;
    
    public pnlEliminarVenta() {
        initComponents();
        txtFactura.requestFocus();
        //this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTOPV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        contenedorFactura = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        PanelTOPV.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Factura a eliminar");

        javax.swing.GroupLayout PanelTOPVLayout = new javax.swing.GroupLayout(PanelTOPV);
        PanelTOPV.setLayout(PanelTOPVLayout);
        PanelTOPVLayout.setHorizontalGroup(
            PanelTOPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTOPVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(87, 87, 87))
        );
        PanelTOPVLayout.setVerticalGroup(
            PanelTOPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTOPVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtFactura.setFont(new java.awt.Font("Tahoma", 1, 14));
        txtFactura.setToolTipText("Número de factura");
        txtFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFacturaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFacturaKeyTyped(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        contenedorFactura.setBackground(new java.awt.Color(255, 255, 255));
        contenedorFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        contenedorFactura.setPreferredSize(new java.awt.Dimension(200, 236));
        contenedorFactura.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTOPV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(contenedorFactura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTOPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(contenedorFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyPressed

        int code = evt.getKeyCode();

        if(code == KeyEvent.VK_ENTER)
        {
            if (!"".equals(txtFactura.getText()))
            {
                procesoBusqueda();
            }
        }
    }//GEN-LAST:event_txtFacturaKeyPressed

    private void txtFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFacturaKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
        
        if(Ventas_controller.anularVenta(numeroFactura))
           notificaciones("facturaDelete");
       
       contenedorFactura.removeAll();
       contenedorFactura.repaint();
       limpiaFocus();
    }//GEN-LAST:event_btnEliminarActionPerformed


    private void procesoBusqueda()
    {
        numeroFactura = parseInt(txtFactura.getText());
        
        Ventas venta = new Ventas();       
        venta = Ventas_controller.listarVentaPorFactura(numeroFactura);
        
        if(venta.getFecha() == null)
        {
            notificaciones("facturaNoExist"); limpiaFocus(); 
        }else
        {
            Cliente cliente = new Cliente();
            //cliente = Cliente_controller.buscarCliente(venta.getCodigoCliente());
            
//            pnlClientes.obtenerClientes();
//            
//            for (int j = 0; j < clientes.size(); j++) 
//            {
//                if (clientes.get(j).getCodigo() == venta.getCodigoCliente()) 
//                {
//                    cliente.setNombre(clientes.get(j).getNombre());
//                    cliente.setTelefono(clientes.get(j).getTelefono());
//                    cliente.setDireccion(clientes.get(j).getDireccion());
//                }else
//                {
//                    cliente.setNombre(venta.getNombreCliente());
//                }
//            }
            
             cliente.setNombre(venta.getNombreCliente());
             cliente.setTelefono(venta.getTelCliente());
             cliente.setDireccion(venta.getDirCliente());

             
             generarReporteDetalleVenta(valueOf(numeroFactura), venta.getNombreUsuario(), cliente.getNombre(), cliente.getTelefono(), cliente.getDireccion(),venta.getFecha().toString());
        
            limpiaFocus();            
        }
    }
        
    private void limpiaFocus()
    {
        txtFactura.setText("");
        txtFactura.requestFocus();
    }
        
    public void generarReporteDetalleVenta(String factura, String vendedor, String cliente, String telefono, String direccion, String fecha)
    {
        //URL jasperUrl;
        try 
        {
            //asperReport reporte = null;
            //String path = "src\\Reportes\\TiqueteReporte.jasper";

            Map parametros = new HashMap();
            parametros.put("numero_factura", factura);
            parametros.put("nombre_cliente", cliente);
            parametros.put("telefono_cliente", telefono);
            parametros.put("direccion_cliente", direccion);
            parametros.put("nombre_vendedor", vendedor);
            parametros.put("fecha", fecha);

            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/TiqueteVenta.jasper"));
            //JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("src\\Reportes\\TiqueteReporte.jasper");//loadObject(jasperUrl);            
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaDetalle));           

            JRViewer jRViewer = new JRViewer(jasperPrint);              

            contenedorFactura.removeAll();
            contenedorFactura.setLayout(new BorderLayout());        
            contenedorFactura.add(jRViewer, BorderLayout.CENTER);
            jRViewer.setVisible(true);            
            contenedorFactura.repaint();
            contenedorFactura.revalidate();

        } catch (JRException ex) {
            Logger.getLogger(Ventas_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    public void notificaciones(String accion)
    {
        switch(accion)
        {
            case "facturaNoExist":
                    new rojerusan.RSNotifyAnimated("", "EL NÚMERO DE FACTURA INDICADO NO EXISTE", 4, RSNotifyAnimated.PositionNotify.BottomRight, 
                            RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                 break;
                
            case "facturaDelete":
                    new rojerusan.RSNotifyAnimated("", "LA FACTURA "+numeroFactura+" HA SIDO ANULADA", 4, RSNotifyAnimated.PositionNotify.BottomRight, 
                         RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                break;  
                    
        }        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTOPV;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel contenedorFactura;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtFactura;
    // End of variables declaration//GEN-END:variables
}
