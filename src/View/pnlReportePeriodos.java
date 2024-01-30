
package View;

import Controller.Usuario_controller;
import Controller.Ventas_controller;
import static Controller.Ventas_controller.listaDetalle;
import Model.Ventas;
import static View.pnlClientes.clientes;
import static View.pnlReportes.modelo;
import static View.pnlReportesDia.contenedorFactura;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import static java.lang.String.valueOf;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
;
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
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Kevin
 */
public class pnlReportePeriodos extends javax.swing.JPanel {

    URL jasperUrl;
    
    public pnlReportePeriodos() {
        initComponents();
        tableVentasModel();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTOPV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelBusquedaV = new javax.swing.JPanel();
        scrollPaneVentasPeriodo = new javax.swing.JScrollPane();
        tableVentasPeriodos = tableVentasPeriodos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnBuscarVentas = new javax.swing.JButton();
        contenedorFactura = new javax.swing.JPanel();
        dateInicial = new rojeru_san.componentes.RSDateChooser();
        dateFinal = new rojeru_san.componentes.RSDateChooser();
        btnDetalleVenta = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(804, 650));

        PanelTOPV.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Ventas entre periodos");

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

        tableVentasPeriodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableVentasPeriodos.setRowHeight(20);
        tableVentasPeriodos.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tableVentasPeriodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVentasPeriodosMouseClicked(evt);
            }
        });
        scrollPaneVentasPeriodo.setViewportView(tableVentasPeriodos);

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

        dateInicial.setColorBackground(new java.awt.Color(0, 153, 204));
        dateInicial.setColorButtonHover(new java.awt.Color(0, 153, 204));
        dateInicial.setColorForeground(new java.awt.Color(0, 153, 204));
        dateInicial.setFormatoFecha("dd/MM/yyyy");
        dateInicial.setPlaceholder("Fecha inicial");
        dateInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateInicialKeyTyped(evt);
            }
        });

        dateFinal.setColorBackground(new java.awt.Color(0, 153, 204));
        dateFinal.setColorButtonHover(new java.awt.Color(0, 153, 204));
        dateFinal.setColorForeground(new java.awt.Color(0, 153, 204));
        dateFinal.setFormatoFecha("dd/MM/yyyy");
        dateFinal.setPlaceholder("Fecha final");
        dateFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateFinalKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout PanelBusquedaVLayout = new javax.swing.GroupLayout(PanelBusquedaV);
        PanelBusquedaV.setLayout(PanelBusquedaVLayout);
        PanelBusquedaVLayout.setHorizontalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addComponent(dateInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(scrollPaneVentasPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(dateInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDetalleVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneVentasPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

    private void tableVentasPeriodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasPeriodosMouseClicked
        //fila = tableVentasDia.getSelectedRow();
    }//GEN-LAST:event_tableVentasPeriodosMouseClicked

    private void btnBuscarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentasActionPerformed
       
        if(dateInicial.getDatoFecha() != null && dateFinal.getDatoFecha() != null)
        {
            String formatoFecha = "dd MM yyyy";
            String formatoFechaSQL = "yyy MM dd";

            
            java.sql.Date fechaInicio = convert(dateInicial.getDatoFecha());
            java.sql.Date fechaFinal = convert(dateFinal.getDatoFecha());
            SimpleDateFormat formateador  = new SimpleDateFormat(formatoFecha);
            SimpleDateFormat formateadorSQL = new SimpleDateFormat(formatoFechaSQL);
            DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
            
               if(!comparaFechas(fechaInicio, fechaFinal))                              
                   listarVentas(fechaInicio, fechaFinal);
               else
                   notificaciones("fechaFinalMenor");
               
                   
                
            
            
            //Ventas_controller.listarVentasPeriodos(fechaInicio, fechaFinal);
            // System.out.println("Fecha inicial: "+  fechaInicio +"\nFecha final: "+ fechaFinal);
        }
        
        
        
        
//        if(tableVentasDia.getSelectedRow() < 0 )//< -1)
//        {
//            //                txtNombre_Cliente.requestFocus();
//            //                editarCliente = false;
//        }
//        else
//        {
//            numeroFactura = (int) tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 0);
//            //Ventas_controller.generaReporteVenta("15", "Kevin Aguilar", "daniel", "83848140", "guacimo xD");
//            Ventas_controller.obtenerDetalleVenta(numeroFactura);
//
//            String vendedor = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 2));
//            String cliente = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 1));
//            String tCliente = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 4));
//            String dCliente = valueOf(tableVentasDia.getValueAt(tableVentasDia.getSelectedRow(), 5));
//            generarReporteDetalleVenta(valueOf(numeroFactura), vendedor, cliente, tCliente , dCliente);
//            /*Usuario_controller.buscarUsuario(listaVentas.get(i).getCodigoUsuario()).getNombre();*/
//        }
    }//GEN-LAST:event_btnBuscarVentasActionPerformed

    
    private boolean comparaFechas(java.sql.Date fechaInicio, java.sql.Date fechaFinal)
    {
        return fechaInicio.after(fechaFinal);       
    }
    
    
   private static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
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
        
        tableVentasPeriodos.setModel(modelo);
        
       // TableColumn colCod = tableVentasPeriodos.getColumn("Número de factura");       //colCod.setPreferredWidth(1);  
        tableVentasPeriodos.getColumn("Cliente").setPreferredWidth(50);     
        tableVentasPeriodos.getColumn("Vendedor").setPreferredWidth(50);       
        tableVentasPeriodos.getColumn("t").setMaxWidth(0);    tableVentasPeriodos.getColumn("t").setMinWidth(0); tableVentasPeriodos.getColumn("t").setPreferredWidth(0);
        tableVentasPeriodos.getColumn("d").setMaxWidth(0);    tableVentasPeriodos.getColumn("d").setMinWidth(0); tableVentasPeriodos.getColumn("d").setPreferredWidth(0);

        /*********************************************/
           ListSelectionModel lsm;
          this.tableVentasPeriodos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            lsm = this.tableVentasPeriodos.getSelectionModel();
            lsm.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                    detalleFactura();
               }
            });
        /***********************************************/
        
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
//        tableVentasPeriodos.setRowSorter(sorter);
//          
//        List<SortKey> sortKeys = new ArrayList<>();
//        sortKeys.add(new SortKey(0, javax.swing.SortOrder.DESCENDING));
//        sorter.setSortKeys(sortKeys);
        
        scrollPaneVentasPeriodo.setViewportView(tableVentasPeriodos);  

    }
    
    
    public void listarVentas(java.sql.Date fechaInicio, java.sql.Date fechaFinal)
    {
        limpiarTable();
        List<Ventas> listaVentas = Ventas_controller.listarVentasPeriodos(fechaInicio, fechaFinal);
        
        modelo = (DefaultTableModel) tableVentasPeriodos.getModel();
        Object[] ob = new Object[7];
        
        Collections.sort(listaVentas); 
        
        for (int i = 0; i < listaVentas.size(); i++) 
        {
            ob[0] = listaVentas.get(i).getCodigoVenta();
  //          pnlClientes.obtenerClientes();
            
//            for (int j = 0; j < clientes.size(); j++) 
//            {
//                if (clientes.get(j).getCodigo() != listaVentas.get(i).getCodigoCliente()) 
//                {
//                    //System.out.println("Codigo cliente de: "+listaVentas.get(i).getNombreCliente() +"  "+listaVentas.get(i).getCodigoCliente());
//                    ob[1] = listaVentas.get(i).getNombreCliente(); 
////                    ob[5] = ;
////                    ob[6] = ;
//                }else
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
        tableVentasPeriodos.setModel(modelo);
    }
    
    
    public void limpiarTable()
    {
        DefaultTableModel tb = (DefaultTableModel) tableVentasPeriodos.getModel();
        int a = tableVentasPeriodos.getRowCount()-1;
        
        for (int i = a; i >= 0; i--)                  
        { tb.removeRow(tb.getRowCount()-1); }      
    }
    
    private void dateInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateInicialKeyTyped
        consume(evt);
    }//GEN-LAST:event_dateInicialKeyTyped

    private void dateFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateFinalKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_dateFinalKeyTyped

    private void btnDetalleVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleVentaActionPerformed
        int numeroFactura = 0;
        
          if(tableVentasPeriodos.getSelectedRow() < 0 )//< -1)
            {
//                txtNombre_Cliente.requestFocus(); 
//                editarCliente = false;
            }    
            else
            {
                numeroFactura = (int) tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 0);
                //Ventas_controller.generaReporteVenta("15", "Kevin Aguilar", "daniel", "83848140", "guacimo xD");
                Ventas_controller.obtenerDetalleVenta(numeroFactura);
                
                
                String vendedor = valueOf(tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 2));
                String cliente = valueOf(tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 1));
                String tCliente = valueOf(tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 5));
                String fecha = valueOf(tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 4));
                String dCliente = valueOf(tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 6));
              
//                for (int i = 0; i < listaDetalle.size(); i++) 
//                {
//                    if(listaDetalle.get(i).getCodigo())
//                }

                
                generarReporteDetalleVenta(valueOf(numeroFactura), vendedor , cliente, tCliente , dCliente, fecha);
                /*Usuario_controller.buscarUsuario(listaVentas.get(i).getCodigoUsuario()).getNombre();*/
            }       
    }//GEN-LAST:event_btnDetalleVentaActionPerformed


    private void detalleFactura()
    {
        int numeroFactura = 0;
        
          if(tableVentasPeriodos.getSelectedRow() < 0 )//< -1)
            {
//                txtNombre_Cliente.requestFocus(); 
//                editarCliente = false;
            }    
            else
            {
                numeroFactura = (int) tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 0);
                //Ventas_controller.generaReporteVenta("15", "Kevin Aguilar", "daniel", "83848140", "guacimo xD");
                Ventas_controller.obtenerDetalleVenta(numeroFactura);
                
                
                String vendedor = valueOf(tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 2));
                String cliente = valueOf(tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 1));
                String tCliente = valueOf(tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 5));
                String fecha = valueOf(tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 4));
                String dCliente = valueOf(tableVentasPeriodos.getValueAt(tableVentasPeriodos.getSelectedRow(), 6));
              
//                for (int i = 0; i < listaDetalle.size(); i++) 
//                {
//                    if(listaDetalle.get(i).getCodigo())
//                }

                
                generarReporteDetalleVenta(valueOf(numeroFactura), vendedor , cliente, tCliente , dCliente, fecha);
                /*Usuario_controller.buscarUsuario(listaVentas.get(i).getCodigoUsuario()).getNombre();*/
            }         
    }
    
    private void consume(java.awt.event.KeyEvent evt)
    {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
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
            case "fechaFinalMenor":
                    new rojerusan.RSNotifyAnimated("", "LA FECHA FINAL NO DEBE SER MENOR A LA INICIAL", 4, RSNotifyAnimated.PositionNotify.BottomRight, 
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
    private javax.swing.JButton btnBuscarVentas;
    private javax.swing.JButton btnDetalleVenta;
    private javax.swing.JPanel contenedorFactura;
    private rojeru_san.componentes.RSDateChooser dateFinal;
    private rojeru_san.componentes.RSDateChooser dateInicial;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane scrollPaneVentasPeriodo;
    private javax.swing.JTable tableVentasPeriodos;
    // End of variables declaration//GEN-END:variables
}
