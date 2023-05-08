
package View;

import Controller.Usuario_controller;
import Controller.Ventas_controller;
import static Controller.Ventas_controller.listaDetalle;
import Model.Usuario;
import Model.Ventas;
import static View.pnlClientes.clientes;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static View.pnlReportes.modelo;
import java.awt.BorderLayout;
import static java.lang.String.valueOf;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter.SortKey;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
/**
 *
 * @author Kevin
 */
public class pnlReporteVendedor extends javax.swing.JPanel {

    URL jasperUrl;
    List<Usuario> usuarios;
    int idUsuario;
    public pnlReporteVendedor() {
        initComponents();
        llenarComboBox();
        tableVentasModel();      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTOPV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelBusquedaV = new javax.swing.JPanel();
        scrollPaneVentasPorUsuario = new javax.swing.JScrollPane();
        tableVentasPorUsuario = tableVentasPorUsuario = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnBuscarVentas = new javax.swing.JButton();
        contenedorFactura = new javax.swing.JPanel();
        btnDetalleVenta = new javax.swing.JButton();
        comboUsuarios = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        PanelTOPV.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Ventas por usuario");

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
        PanelBusquedaV.setPreferredSize(new java.awt.Dimension(804, 529));

        tableVentasPorUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableVentasPorUsuario.setRowHeight(20);
        tableVentasPorUsuario.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tableVentasPorUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVentasPorUsuarioMouseClicked(evt);
            }
        });
        scrollPaneVentasPorUsuario.setViewportView(tableVentasPorUsuario);

        btnBuscarVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarVentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscar.png"))); // NOI18N
        btnBuscarVentas.setBorder(null);
        btnBuscarVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarVentas.setFocusPainted(false);
        btnBuscarVentas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBuscarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentasActionPerformed(evt);
            }
        });

        contenedorFactura.setBackground(new java.awt.Color(255, 255, 255));
        contenedorFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        contenedorFactura.setPreferredSize(new java.awt.Dimension(200, 236));
        contenedorFactura.setLayout(new java.awt.BorderLayout());

        btnDetalleVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnDetalleVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDetalleVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/factura_detalle.png"))); // NOI18N
        btnDetalleVenta.setText("Detalle de venta");
        btnDetalleVenta.setBorder(null);
        btnDetalleVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetalleVenta.setFocusPainted(false);
        btnDetalleVenta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDetalleVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleVentaActionPerformed(evt);
            }
        });

        comboUsuarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el usuario" }));
        comboUsuarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboUsuariosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout PanelBusquedaVLayout = new javax.swing.GroupLayout(PanelBusquedaV);
        PanelBusquedaV.setLayout(PanelBusquedaVLayout);
        PanelBusquedaVLayout.setHorizontalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addComponent(comboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(scrollPaneVentasPorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDetalleVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(contenedorFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        PanelBusquedaVLayout.setVerticalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusquedaVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscarVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnDetalleVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboUsuarios))
                .addGap(25, 25, 25)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneVentasPorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(contenedorFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                .addContainerGap(212, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTOPV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelBusquedaV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTOPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelBusquedaV, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void llenarComboBox()
    {
        try {
            usuarios = Usuario_controller.listarUsuario();         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnlReporteVendedor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pnlReporteVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for (int i = 0; i < usuarios.size(); i++) 
        {
            String tipoUser = usuarios.get(i).getTipoUsuario();
            
            comboUsuarios.addItem("<html><font color=black> "+usuarios.get(i).getNombre()+"<html><font color=blue> "+"     -     "+tipoUser+"</font></html>");
        }        
    }
    
    private int obtenerIndexUsuario(int index)
    {
        index -=1;
        for (int i = 0; i < usuarios.size(); i++) 
        {
            if(index == i)
                return usuarios.get(i).getCodigo();
                //System.out.println("se seleccionó el usuario con nombre:"+ usuarios.get(i).getNombre() +"y codigo de usuario: "+usuarios.get(i).getCodigo());                                           
        }
        return index;
    }
  
    
    
     public void tableVentasModel() 
    {   
        modelo = new DefaultTableModel();
        modelo.addColumn("Número factura");
        modelo.addColumn("Cliente");
        modelo.addColumn("Vendedor");
        modelo.addColumn("Total venta");
        modelo.addColumn("Fecha");
        modelo.addColumn("t");
        modelo.addColumn("d");
        
        tableVentasPorUsuario.setModel(modelo);
        
//        TableColumn colCod = tableVentas.getColumn("Número de factura");       //colCod.setPreferredWidth(1);  
          tableVentasPorUsuario.getColumn("Cliente").setPreferredWidth(50);     
          tableVentasPorUsuario.getColumn("Vendedor").setPreferredWidth(50);  
          tableVentasPorUsuario.getColumn("t").setMaxWidth(0);   tableVentasPorUsuario.getColumn("t").setMinWidth(0); tableVentasPorUsuario.getColumn("t").setPreferredWidth(0);
          tableVentasPorUsuario.getColumn("d").setMaxWidth(0);   tableVentasPorUsuario.getColumn("d").setMinWidth(0); tableVentasPorUsuario.getColumn("d").setPreferredWidth(0);

        /*********************************************/
           ListSelectionModel lsm;
          this.tableVentasPorUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            lsm = this.tableVentasPorUsuario.getSelectionModel();
            lsm.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                    detalleFactura();
               }
            });
        /***********************************************/          
          
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
//        tableVentasPorUsuario.setRowSorter(sorter);
//
//        List<SortKey> sortKeys = new ArrayList<>();
//        sortKeys.add(new SortKey(0, javax.swing.SortOrder.DESCENDING));
//        sorter.setSortKeys(sortKeys);

        scrollPaneVentasPorUsuario.setViewportView(tableVentasPorUsuario);  
    }
    

    public void listarVentas()
    {
        limpiarTable();
        List<Ventas> listaVentas = Ventas_controller.listarVentaPorUsuario(obtenerIndexUsuario(idUsuario));;
        
        modelo = (DefaultTableModel) tableVentasPorUsuario.getModel();
        Object[] ob = new Object[7];
        
        Collections.sort(listaVentas); 
        
        for (int i = 0; i < listaVentas.size(); i++) 
        {
            ob[0] = listaVentas.get(i).getCodigoVenta();
//            pnlClientes.obtenerClientes();
//            
//            for (int j = 0; j < clientes.size(); j++) 
//            {
//                if (clientes.get(j).getCodigo() == listaVentas.get(i).getCodigoCliente()) 
//                {
//                    ob[1] = clientes.get(j).getNombre();
//                    ob[5] = clientes.get(j).getTelefono();
//                    ob[6] = clientes.get(j).getDireccion();
//                }
//            }
                       
            ob[1] = listaVentas.get(i).getNombreCliente();
            ob[2] = listaVentas.get(i).getNombreUsuario();
            ob[3] = listaVentas.get(i).getTotal();
            ob[4] = listaVentas.get(i).getFecha();
            ob[5] = listaVentas.get(i).getTelCliente();
            ob[6] = listaVentas.get(i).getDirCliente();
            modelo.addRow(ob);
        }
        tableVentasPorUsuario.setModel(modelo);
    }
    
    
    public void limpiarTable()
    {
        DefaultTableModel tb = (DefaultTableModel) tableVentasPorUsuario.getModel();
        int a = tableVentasPorUsuario.getRowCount()-1;
        
        for (int i = a; i >= 0; i--)                  
        { tb.removeRow(tb.getRowCount()-1); }      
    }
    
    
    private void tableVentasPorUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasPorUsuarioMouseClicked
        //fila = tableVentasDia.getSelectedRow();
    }//GEN-LAST:event_tableVentasPorUsuarioMouseClicked

    private void btnBuscarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentasActionPerformed
        
        listarVentas();
                    
    }//GEN-LAST:event_btnBuscarVentasActionPerformed

    private void btnDetalleVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleVentaActionPerformed
        int numeroFactura = 0;
        
          if(tableVentasPorUsuario.getSelectedRow() < 0 )//< -1)
            {
//                txtNombre_Cliente.requestFocus(); 
//                editarCliente = false;
            }    
            else
            {
                numeroFactura = (int) tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 0);
                //Ventas_controller.generaReporteVenta("15", "Kevin Aguilar", "daniel", "83848140", "guacimo xD");
                Ventas_controller.obtenerDetalleVenta(numeroFactura);
                
                
                String vendedor = valueOf(tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 2));
                String cliente = valueOf(tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 1));
                String tCliente = valueOf(tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 5));
                String fecha = valueOf(tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 4));
                String dCliente = valueOf(tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 6));
                generarReporteDetalleVenta(valueOf(numeroFactura), vendedor, cliente, tCliente , dCliente, fecha);
                /*Usuario_controller.buscarUsuario(listaVentas.get(i).getCodigoUsuario()).getNombre();*/
            }
    }//GEN-LAST:event_btnDetalleVentaActionPerformed

    private void detalleFactura()
    {
        int numeroFactura = 0;
        
          if(tableVentasPorUsuario.getSelectedRow() < 0 )//< -1)
            {
//                txtNombre_Cliente.requestFocus(); 
//                editarCliente = false;
            }    
            else
            {
                numeroFactura = (int) tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 0);
                //Ventas_controller.generaReporteVenta("15", "Kevin Aguilar", "daniel", "83848140", "guacimo xD");
                Ventas_controller.obtenerDetalleVenta(numeroFactura);
                
                
                String vendedor = valueOf(tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 2));
                String cliente = valueOf(tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 1));
                String tCliente = valueOf(tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 5));
                String fecha = valueOf(tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 4));
                String dCliente = valueOf(tableVentasPorUsuario.getValueAt(tableVentasPorUsuario.getSelectedRow(), 6));
                generarReporteDetalleVenta(valueOf(numeroFactura), vendedor, cliente, tCliente , dCliente, fecha);
                /*Usuario_controller.buscarUsuario(listaVentas.get(i).getCodigoUsuario()).getNombre();*/
            }        
    }
    
    
    public void generarReporteDetalleVenta(String factura, String vendedor, String cliente, String telefono, String direccion, String fecha)
    {
        
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
    
    
    private void comboUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboUsuariosItemStateChanged
          
        idUsuario = comboUsuarios.getSelectedIndex();
        
        if(evt.getStateChange()== 1)      
            listarVentas();             
    }//GEN-LAST:event_comboUsuariosItemStateChanged

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBusquedaV;
    private javax.swing.JPanel PanelTOPV;
    private javax.swing.JButton btnBuscarVentas;
    private javax.swing.JButton btnDetalleVenta;
    private javax.swing.JComboBox<String> comboUsuarios;
    private javax.swing.JPanel contenedorFactura;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane scrollPaneVentasPorUsuario;
    private javax.swing.JTable tableVentasPorUsuario;
    // End of variables declaration//GEN-END:variables
}
