
package View;

import Controller.Producto_controller;
import Controller.Ventas_controller;
import Model.Detalle_Ventas;
import static View.pnlReportes.modelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import static java.lang.String.valueOf;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane; 
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Kevin
 */
public class pnlReporteEstadistico extends javax.swing.JPanel {


    DefaultPieDataset datosGrafico = new DefaultPieDataset();
    String patron = "###, ###. ##";
    DecimalFormat objDF = new DecimalFormat (patron);
    List<Detalle_Ventas> listaVentas;
    
    public pnlReporteEstadistico() {
        initComponents();
        tableVentasModel();
        //dateInicial.requestFocus();
    }


    public void tableVentasModel() 
    {   
        modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");
        modelo.addColumn("Producto");
        modelo.addColumn("Total");

        /*lblTotalPagar.setText(String.format("%.2f", totalPagar));*/
        tableVentasEstadisticas.setModel(modelo);
        
        tableVentasEstadisticas.getColumn("Cantidad").setMaxWidth(65);   tableVentasEstadisticas.getColumn("Cantidad").setMinWidth(65); tableVentasEstadisticas.getColumn("Cantidad").setPreferredWidth(65);
        tableVentasEstadisticas.getColumn("Total").setMaxWidth(65);   tableVentasEstadisticas.getColumn("Total").setMinWidth(65); tableVentasEstadisticas.getColumn("Total").setPreferredWidth(65);
        
        
        
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
//        tableVentasEstadisticas.setRowSorter(sorter);

//        List<SortKey> sortKeys = new ArrayList<>();
//        
//        tableVentasEstadisticas.getColumnClass(0);
//        sortKeys.add(new SortKey(0,javax.swing.SortOrder.DESCENDING));
//        sorter.setSortKeys(sortKeys);
        
        scrollPaneVentasEstadisticas.setViewportView(tableVentasEstadisticas);  
    }
    
       
    public void limpiarTable()
    {
        DefaultTableModel tb = (DefaultTableModel) tableVentasEstadisticas.getModel();
        int a = tableVentasEstadisticas.getRowCount()-1;
        
        for (int i = a; i >= 0; i--)                  
        { tb.removeRow(tb.getRowCount()-1); }      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTOPV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelBusquedaV = new javax.swing.JPanel();
        btnBuscarVentas = new javax.swing.JButton();
        btnImprimir = new lib.RSButtonMetro();
        contenedorGrafico = new javax.swing.JPanel();
        dateInicial = new rojeru_san.componentes.RSDateChooser();
        dateFinal = new rojeru_san.componentes.RSDateChooser();
        scrollPaneVentasEstadisticas = new javax.swing.JScrollPane();
        tableVentasEstadisticas = tableVentasEstadisticas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };

        setBackground(new java.awt.Color(255, 255, 255));

        PanelTOPV.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Datos estadísticos");

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

        btnImprimir.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imprimir.png"))); // NOI18N
        btnImprimir.setToolTipText("Imprimir reporte");
        btnImprimir.setColorHover(new java.awt.Color(52, 152, 219));
        btnImprimir.setColorNormal(new java.awt.Color(102, 153, 255));
        btnImprimir.setColorPressed(new java.awt.Color(255, 255, 255));
        btnImprimir.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnImprimir.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnImprimir.setFocusPainted(false);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        contenedorGrafico.setBackground(new java.awt.Color(255, 255, 255));
        contenedorGrafico.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        contenedorGrafico.setPreferredSize(new java.awt.Dimension(200, 236));
        contenedorGrafico.setLayout(new java.awt.BorderLayout());

        dateInicial.setColorBackground(new java.awt.Color(0, 153, 204));
        dateInicial.setColorButtonHover(new java.awt.Color(0, 153, 204));
        dateInicial.setColorForeground(new java.awt.Color(0, 153, 204));
        dateInicial.setFormatoFecha("dd/MM/yyyy");
        dateInicial.setPlaceholder("Fecha inicio");
        dateInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateInicialKeyTyped(evt);
            }
        });
        dateInicial.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                dateInicialVetoableChange(evt);
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

        scrollPaneVentasEstadisticas.setBackground(new java.awt.Color(255, 255, 255));

        tableVentasEstadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableVentasEstadisticas.setGridColor(new java.awt.Color(255, 255, 255));
        tableVentasEstadisticas.setRowHeight(20);
        tableVentasEstadisticas.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tableVentasEstadisticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVentasEstadisticasMouseClicked(evt);
            }
        });
        scrollPaneVentasEstadisticas.setViewportView(tableVentasEstadisticas);

        javax.swing.GroupLayout PanelBusquedaVLayout = new javax.swing.GroupLayout(PanelBusquedaV);
        PanelBusquedaV.setLayout(PanelBusquedaVLayout);
        PanelBusquedaVLayout.setHorizontalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addComponent(contenedorGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPaneVentasEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addComponent(dateInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        PanelBusquedaVLayout.setVerticalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusquedaVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(dateFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneVentasEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(contenedorGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                .addContainerGap(175, Short.MAX_VALUE))
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
            {
                listarVentas(fechaInicio, fechaFinal); 
                generarGrafico();
            }
           else            
            notificaciones("fechaFinalMenor");

        }
       
    }//GEN-LAST:event_btnBuscarVentasActionPerformed
  
    public void generarGrafico()
    {
        
//        datos.setValue("arroz cantones", n1);
//        datos.setValue("chop suey en salsa", n2);
//        datos.setValue("tacos chinos", n3);
        
        
        JFreeChart grafico = ChartFactory.createPieChart(
            "Productos más vendidos",
            datosGrafico,                    //datos    
            true,                       //nombre categorias
            true,                       //herramientas
            false                        //generacion url
        );
               
        ChartPanel panel = new ChartPanel(grafico);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(400,300));

        
        contenedorGrafico.removeAll();
        contenedorGrafico.setLayout(new BorderLayout());
        contenedorGrafico.add(panel, BorderLayout.NORTH);
        
        repaint();
        revalidate();
        //datosGrafico.clear();
    }
    
     public void listarVentas(java.sql.Date fechaInicio, java.sql.Date fechaFinal)
    {
        datosGrafico.clear(); limpiarTable(); 
        listaVentas = Ventas_controller.listarVentasPorPeriodoEstadistico(fechaInicio, fechaFinal);
        String nombre = null;
        String total = null;  
        
        modelo = (DefaultTableModel) tableVentasEstadisticas.getModel();
        Object[] ob = new Object[3];
        
       Collections.sort(listaVentas); //ordenar la lista 
        
        for (int i = 0; i < listaVentas.size(); i++) 
        {
                        
            //nombre = Producto_controller.buscarProductoPorID(listaVentas.get(i).getCodigoProducto()).getDescripcion();
            nombre = listaVentas.get(i).getProducto();
            
            ob[0] = listaVentas.get(i).getCantidad();           
            ob[1] = nombre;  
            //total =  valueOf(listaVentas.get(i).getCantidad() * Producto_controller.buscarProductoPorID(listaVentas.get(i).getCodigoProducto()).getPrecio());
           // ob[2] =  valueOf(listaVentas.get(i).getCantidad() * Producto_controller.buscarProductoPorID(listaVentas.get(i).getCodigoProducto()).getPrecio());            
            
            //ob[2] = objDF.format(listaVentas.get(i).getCantidad() * Producto_controller.buscarProductoPorID(listaVentas.get(i).getCodigoProducto()).getPrecio());
            ob[2] = objDF.format(listaVentas.get(i).getCantidad() * listaVentas.get(i).getPrecio());
            listaVentas.get(i).setIngreso(listaVentas.get(i).getCantidad() * listaVentas.get(i).getPrecio());
            
            datosGrafico.setValue(nombre, listaVentas.get(i).getCantidad());   
            modelo.addRow(ob);
        }
        tableVentasEstadisticas.setModel(modelo);
        generarGrafico();
        //listaVentas.clear();
    }
    
    
    /*        limpiarTable();
        List<Ventas> listaVentas = Ventas_controller.listarVentaPorUsuario(obtenerIndexUsuario(idUsuario));;
        
        modelo = (DefaultTableModel) tableVentasPorUsuario.getModel();
        Object[] ob = new Object[7];
        
        for (int i = 0; i < listaVentas.size(); i++) 
        {
            ob[0] = listaVentas.get(i).getCodigoVenta();
            pnlClientes.obtenerClientes();
            
            for (int j = 0; j < clientes.size(); j++) 
            {
                if (clientes.get(j).getCodigo() == listaVentas.get(i).getCodigoCliente()) 
                {
                    ob[1] = clientes.get(j).getNombre();
                    ob[5] = clientes.get(j).getTelefono();
                    ob[6] = clientes.get(j).getDireccion();
                }
            }
            
            ob[2] = Usuario_controller.buscarUsuario(listaVentas.get(i).getCodigoUsuario()).getNombre();
            ob[3] = listaVentas.get(i).getTotal();
            ob[4] = listaVentas.get(i).getFecha();
            modelo.addRow(ob);
        }
        tableVentasPorUsuario.setModel(modelo);*/
     
     
    private boolean comparaFechas(java.sql.Date fechaInicio, java.sql.Date fechaFinal)
    {
        return fechaInicio.after(fechaFinal);       
    }
    
    
   private static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    
    private void dateInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateInicialKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_dateInicialKeyTyped

    private void dateFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateFinalKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_dateFinalKeyTyped

    private void tableVentasEstadisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasEstadisticasMouseClicked
        //fila = tableVentasDia.getSelectedRow();
    }//GEN-LAST:event_tableVentasEstadisticasMouseClicked

    private void dateInicialVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dateInicialVetoableChange
            System.out.println("seleccion");
    }//GEN-LAST:event_dateInicialVetoableChange

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
       
        if(dateInicial.getDatoFecha() != null && dateFinal.getDatoFecha() != null)
        {
            String formatoFecha = "dd MM yyyy";
            SimpleDateFormat formateador  = new SimpleDateFormat(formatoFecha);
                       
            generarReporteEstadistico(formateador.format(dateInicial.getDatoFecha()), formateador.format(dateFinal.getDatoFecha()), frameLogin.usuarioLogueado.getNombre());
        }
            
    }//GEN-LAST:event_btnImprimirActionPerformed
       
    public void generarReporteEstadistico(String Fecha_inicio, String Fecha_fin, String nombre_usuario)
    {
        
        try 
        {
            //JasperReport reporte = null;
            //String path = "src\\Reportes\\ReporteEstadistico.jasper";

            Map parametros = new HashMap();
            parametros.put("Fecha_inicio", Fecha_inicio);
            parametros.put("Fecha_fin", Fecha_fin);
            parametros.put("nombre_usuario", nombre_usuario);

            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteEstadistico.jasper"));
            JasperPrint jPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaVentas));//JREmptyDataSource(

            JasperPrintManager.printReport(jPrint, false);
            //JasperViewer vistaReporte = new JasperViewer(jPrint, false);
            //vistaReporte.setVisible(true);
            //listaVentas.clear();

            //vistaReporte.setVisible(true);           

        } catch (JRException ex) {
            notificaciones("reporteVacio");
            System.out.println(ex.getMessage());
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
                 
            case "reporteVacio":
                    new rojerusan.RSNotifyAnimated("", "El reporte no contiene páginas", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                            RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                 break;     
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBusquedaV;
    private javax.swing.JPanel PanelTOPV;
    private javax.swing.JButton btnBuscarVentas;
    private lib.RSButtonMetro btnImprimir;
    private javax.swing.JPanel contenedorGrafico;
    private rojeru_san.componentes.RSDateChooser dateFinal;
    private rojeru_san.componentes.RSDateChooser dateInicial;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane scrollPaneVentasEstadisticas;
    private javax.swing.JTable tableVentasEstadisticas;
    // End of variables declaration//GEN-END:variables
}
