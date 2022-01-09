
package View;

import Controller.Cliente_controller;
import Controller.Usuario_controller;
import Controller.Ventas_controller;
import static Controller.Ventas_controller.listaDetalle;
import Model.Cliente;
import Model.Ventas;
import static View.pnlClientes.clientes;
import static View.pnlReportes.modelo;
import java.awt.BorderLayout;
import static java.lang.String.valueOf;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter.SortKey;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.util.SortOrder;

/**
 *
 * @author Kevin
 */
public class pnlReportesDia extends javax.swing.JPanel {

    URL jasperUrl;
    public pnlReportesDia() {
        initComponents();
        tableVentasModel();
        listarVentas();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTOPV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelBusquedaV = new javax.swing.JPanel();
        scrollPaneVentasDia = new javax.swing.JScrollPane();
        tableVentasDia = tableVentasDia = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnDetalle = new javax.swing.JButton();
        contenedorFactura = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(884, 550));

        PanelTOPV.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Ventas del día");

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

        tableVentasDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableVentasDia.setRowHeight(20);
        tableVentasDia.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tableVentasDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVentasDiaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableVentasDiaMousePressed(evt);
            }
        });
        scrollPaneVentasDia.setViewportView(tableVentasDia);

        btnDetalle.setBackground(new java.awt.Color(255, 255, 255));
        btnDetalle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/factura_detalle.png"))); // NOI18N
        btnDetalle.setText("Detalle de factura");
        btnDetalle.setBorder(null);
        btnDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetalle.setFocusPainted(false);
        btnDetalle.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });

        contenedorFactura.setBackground(new java.awt.Color(255, 255, 255));
        contenedorFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        contenedorFactura.setPreferredSize(new java.awt.Dimension(200, 236));
        contenedorFactura.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout PanelBusquedaVLayout = new javax.swing.GroupLayout(PanelBusquedaV);
        PanelBusquedaV.setLayout(PanelBusquedaVLayout);
        PanelBusquedaVLayout.setHorizontalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneVentasDia, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contenedorFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBusquedaVLayout.setVerticalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneVentasDia, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addComponent(btnDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contenedorFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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

    private void tableVentasDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasDiaMouseClicked
        //fila = tableVentasDia.getSelectedRow();
    }//GEN-LAST:event_tableVentasDiaMouseClicked

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
            
        int numeroFactura = 0;
        
          if(tableVentasDia.getSelectedRow() < 0 )//< -1)
            {
//                txtNombre_Cliente.requestFocus(); 
//                editarCliente = false;
            }    
            else
            {
                numeroFactura = (int) tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 0);
                //Ventas_controller.generaReporteVenta("15", "Kevin Aguilar", "daniel", "83848140", "guacimo xD");
                Ventas_controller.obtenerDetalleVenta(numeroFactura);
                
                
                String vendedor = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 2));
                String cliente = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 1));
                String tCliente = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 4));
                String dCliente = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 5));
                generarReporteDetalleVenta(valueOf(numeroFactura), vendedor, cliente, tCliente , dCliente);
                /*Usuario_controller.buscarUsuario(listaVentas.get(i).getCodigoUsuario()).getNombre();*/
            }
    }//GEN-LAST:event_btnDetalleActionPerformed

    
    private void detalleFactura()
    {
        int numeroFactura = 0;
        
          if(tableVentasDia.getSelectedRow() < 0 )//< -1)
            {
//                txtNombre_Cliente.requestFocus(); 
//                editarCliente = false;
            }    
            else
            {
                numeroFactura = (int) tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 0);
                //Ventas_controller.generaReporteVenta("15", "Kevin Aguilar", "daniel", "83848140", "guacimo xD");
                Ventas_controller.obtenerDetalleVenta(numeroFactura);
                
                
                String vendedor = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 2));
                String cliente = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 1));
                String tCliente = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 4));
                String dCliente = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 5));
                generarReporteDetalleVenta(valueOf(numeroFactura), vendedor, cliente, tCliente , dCliente);
                /*Usuario_controller.buscarUsuario(listaVentas.get(i).getCodigoUsuario()).getNombre();*/
            }        
    }
    
    
    private void tableVentasDiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasDiaMousePressed
       // System.out.println("se presionó botón del mouse");
    }//GEN-LAST:event_tableVentasDiaMousePressed

    
    
    public void generarReporteDetalleVenta(String factura, String vendedor, String cliente, String telefono, String direccion)
    {
        
        try 
        {
            //asperReport reporte = null;
            //String path = "\\Reportes\\TiqueteVenta.jasper";

            Map parametros = new HashMap();
            parametros.put("numero_factura", factura);
            parametros.put("nombre_cliente", cliente);
            parametros.put("telefono_cliente", telefono);
            parametros.put("direccion_cliente", direccion);
            parametros.put("nombre_vendedor", vendedor);

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
    
    public void tableVentasModel() 
    {   
        modelo = new DefaultTableModel();
        modelo.addColumn("Número factura");
        modelo.addColumn("Cliente");
        modelo.addColumn("Vendedor");
        modelo.addColumn("Total de la venta");
        modelo.addColumn("t");
        modelo.addColumn("d");
        modelo.addColumn("trnsp");
        
        tableVentasDia.setModel(modelo);
        
//        TableColumn colCod = tableVentas.getColumn("Número de factura");       //colCod.setPreferredWidth(1);  
//        TableColumn colCant = tableVentas.getColumn("ID cliente");     //  colName.setPreferredWidth(0);
//        TableColumn colPro = tableVentas.getColumn("ID vendedor");       // colTel.setPreferredWidth(50);
          tableVentasDia.getColumn("t").setMaxWidth(0);    tableVentasDia.getColumn("t").setMinWidth(0); tableVentasDia.getColumn("t").setPreferredWidth(0);
          tableVentasDia.getColumn("d").setMaxWidth(0);    tableVentasDia.getColumn("d").setMinWidth(0); tableVentasDia.getColumn("d").setPreferredWidth(0);
          tableVentasDia.getColumn("trnsp").setMaxWidth(0);    tableVentasDia.getColumn("trnsp").setMinWidth(0); tableVentasDia.getColumn("trnsp").setPreferredWidth(0);

         /**************************************/ 
          ListSelectionModel lsm;
          this.tableVentasDia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            lsm = this.tableVentasDia.getSelectionModel();
            lsm.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                    detalleFactura();
               }
            });

          
          
          /************************************/        
          
//          TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
//          tableVentasDia.setRowSorter(sorter);
//          
//          List<SortKey> sortKeys = new ArrayList<>();
//          sortKeys.add(new SortKey(0, javax.swing.SortOrder.DESCENDING));
//          sorter.setSortKeys(sortKeys);
          /************************************/
        scrollPaneVentasDia.setViewportView(tableVentasDia);  
   
    }
    

    public void listarVentas()
    {
        List<Ventas> listaVentas = Ventas_controller.listarVentasDia();
        Cliente client = new Cliente();
        
        
        modelo = (DefaultTableModel) tableVentasDia.getModel();
        Object[] ob = new Object[7];
        
        Collections.sort(listaVentas); 
        
        for (int i = 0; i < listaVentas.size(); i++) 
        {
            
            
            ob[0] = (int)listaVentas.get(i).getCodigoVenta();
//            pnlClientes.obtenerClientes();
//            
//            for (int j = 0; j < clientes.size(); j++) 
//            {
//                if (clientes.get(j).getCodigo() == listaVentas.get(i).getCodigoCliente()) 
//                {
//                    ob[1] = clientes.get(j).getNombre();
//                    ob[4] = clientes.get(j).getTelefono();
//                    ob[5] = clientes.get(j).getDireccion();
//                }else
//                {
//                    ob[1] = listaVentas.get(i).getNombreCliente();   
//                }
//            }
//            if(Cliente_controller.buscarCliente(listaVentas.get(i).getCodigoCliente()).getCodigo() == 0)
//            {
//                ob[1] = listaVentas.get(i).getNombreCliente();
//            }else
//            {
//                client = Cliente_controller.buscarCliente(listaVentas.get(i).getCodigoCliente());
//                ob[1] = client.getNombre();                
//                ob[4] = client.getTelefono();
//                ob[5] = client.getDireccion();
//            }

            ob[1] = listaVentas.get(i).getNombreCliente();
            ob[2] = listaVentas.get(i).getNombreUsuario();
            ob[3] = listaVentas.get(i).getTotal();
            ob[4] = listaVentas.get(i).getTelCliente();
            ob[5] = listaVentas.get(i).getDirCliente();
            ob[6] = listaVentas.get(i).getTransporte();
            modelo.addRow(ob);
        }
        tableVentasDia.setModel(modelo);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel PanelBusquedaV;
    public static javax.swing.JPanel PanelTOPV;
    public static javax.swing.JButton btnDetalle;
    public static javax.swing.JPanel contenedorFactura;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JScrollPane scrollPaneVentasDia;
    public static javax.swing.JTable tableVentasDia;
    // End of variables declaration//GEN-END:variables
}
