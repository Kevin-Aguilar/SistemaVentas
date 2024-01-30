/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Cliente_controller;
import Controller.Usuario_controller;
import Controller.Ventas_controller;
import static Controller.Ventas_controller.listaDetalle;
import Model.Cliente;
import Model.Ventas;
import static View.pnlClientes.clientes;
import static View.pnlReportesDia.contenedorFactura;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.net.URL;
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
public class pnlBuscarFactura extends javax.swing.JPanel {

    
    public pnlBuscarFactura() {
        initComponents();
        limpiaFocus();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTOPV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelBusquedaV = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        contenedorFactura = new javax.swing.JPanel();
        txtFactura = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(884, 550));

        PanelTOPV.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Buscar factura");

        javax.swing.GroupLayout PanelTOPVLayout = new javax.swing.GroupLayout(PanelTOPV);
        PanelTOPV.setLayout(PanelTOPVLayout);
        PanelTOPVLayout.setHorizontalGroup(
            PanelTOPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTOPVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTOPVLayout.setVerticalGroup(
            PanelTOPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTOPVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        PanelBusquedaV.setBackground(new java.awt.Color(255, 255, 255));
        PanelBusquedaV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        contenedorFactura.setBackground(new java.awt.Color(255, 255, 255));
        contenedorFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        contenedorFactura.setPreferredSize(new java.awt.Dimension(200, 236));
        contenedorFactura.setLayout(new java.awt.BorderLayout());

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

        javax.swing.GroupLayout PanelBusquedaVLayout = new javax.swing.GroupLayout(PanelBusquedaV);
        PanelBusquedaV.setLayout(PanelBusquedaVLayout);
        PanelBusquedaVLayout.setHorizontalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelBusquedaVLayout.createSequentialGroup()
                        .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(contenedorFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(411, Short.MAX_VALUE))
        );
        PanelBusquedaVLayout.setVerticalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contenedorFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelTOPV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBusquedaV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTOPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelBusquedaV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void procesoBusqueda()
    {
        int numeroFactura = parseInt(txtFactura.getText());
        
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
    
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        procesoBusqueda();
    }//GEN-LAST:event_btnBuscarActionPerformed


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
            parametros.put("ruta_logo", this.getClass().getResourceAsStream("/Images/logo_dragon.jpg"));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/TiqueteReporte.jasper"));
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
   
    public static void notificaciones(String accion)
    {
        switch(accion)
        {
            case "facturaNoExist":
                    new rojerusan.RSNotifyAnimated("", "EL NÚMERO DE FACTURA INDICADO NO EXISTE", 4, RSNotifyAnimated.PositionNotify.BottomRight, 
                            RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                 break;
                
            case "codExist":
                    new rojerusan.RSNotifyAnimated("", "El código del producto ya existe", 4, RSNotifyAnimated.PositionNotify.BottomRight, 
                         RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                break;  
                    
        }        
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBusquedaV;
    private javax.swing.JPanel PanelTOPV;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel contenedorFactura;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtFactura;
    // End of variables declaration//GEN-END:variables
}
