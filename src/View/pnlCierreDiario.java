
package View;

import Controller.Ingreso_egreso_controller;
import Controller.Usuario_controller;
import Controller.Ventas_controller;
import Model.Ingreso_egreso;
import Model.Ventas;
import static View.pnlClientes.clientes;
import static View.pnlReportes.modelo;
import static View.pnlReportesDia.scrollPaneVentasDia;
import static View.pnlReportesDia.tableVentasDia;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Double.parseDouble;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Kevin
 */
public class pnlCierreDiario extends javax.swing.JPanel {

    Ingreso_egreso conceptos;
    private double ingresoConceptos;
    private double ingresoVentas;
    private double egresoConceptos;
    private double totalIngresos;
    private double totalEgresos;
    Ingreso_egreso_controller ieController;
    
    String patron = "###, ###. ##";
    DecimalFormat objDF = new DecimalFormat (patron);
    

    public pnlCierreDiario() {
        initComponents();
        ieController = new Ingreso_egreso_controller();
        conceptos = new Ingreso_egreso();
        
        tableCierreModel();
        tableVentasModel();
        listar();
        listarVentas();
        soloNumReales(txtCantidad);
        calculaIngresoEgreso();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTOPV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelBusquedaV = new javax.swing.JPanel();
        scrollPaneVentasPeriodo = new javax.swing.JScrollPane();
        tableCierre = tableCierre = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnGenerarCierre = new javax.swing.JButton();
        txtConcepto = new javax.swing.JTextField();
        btnNuevoConcepto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcomboTipo = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        scrollPaneVentasDia = new javax.swing.JScrollPane();
        tableVentasDia = tableVentasDia = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        lblTittleBussiness10 = new javax.swing.JLabel();
        lblTotalVentas = new javax.swing.JLabel();
        lblTittleBussiness11 = new javax.swing.JLabel();
        lblIngresoConceptos = new javax.swing.JLabel();
        lblSalidasConceptos = new javax.swing.JLabel();
        lblTittleBussiness12 = new javax.swing.JLabel();
        lblTittleBussiness13 = new javax.swing.JLabel();
        lblTotalIngresos = new javax.swing.JLabel();
        lblTittleBussiness14 = new javax.swing.JLabel();
        lblTotalSalidas = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1078, 550));

        PanelTOPV.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Cierre diario ");

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

        tableCierre.setRowHeight(20);
        tableCierre.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tableCierre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCierreMouseClicked(evt);
            }
        });
        scrollPaneVentasPeriodo.setViewportView(tableCierre);

        btnGenerarCierre.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarCierre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGenerarCierre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cierre.png"))); // NOI18N
        btnGenerarCierre.setText("Generar cierre");
        btnGenerarCierre.setBorder(null);
        btnGenerarCierre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarCierre.setFocusPainted(false);
        btnGenerarCierre.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGenerarCierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarCierreActionPerformed(evt);
            }
        });

        txtConcepto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtConcepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConceptoKeyPressed(evt);
            }
        });

        btnNuevoConcepto.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoConcepto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoConcepto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/concepto.png"))); // NOI18N
        btnNuevoConcepto.setText("Agregar");
        btnNuevoConcepto.setBorder(null);
        btnNuevoConcepto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoConcepto.setFocusPainted(false);
        btnNuevoConcepto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNuevoConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoConceptoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nuevo concepto");

        jcomboTipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcomboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Salida" }));
        jcomboTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcomboTipoItemStateChanged(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad");

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
        });
        scrollPaneVentasDia.setViewportView(tableVentasDia);

        lblTittleBussiness10.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        lblTittleBussiness10.setForeground(new java.awt.Color(44, 62, 80));
        lblTittleBussiness10.setText("Ingresos por ventas:");

        lblTotalVentas.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        lblTotalVentas.setForeground(new java.awt.Color(51, 153, 255));
        lblTotalVentas.setText("0.00");

        lblTittleBussiness11.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        lblTittleBussiness11.setForeground(new java.awt.Color(44, 62, 80));
        lblTittleBussiness11.setText("Ingresos por conceptos:");

        lblIngresoConceptos.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        lblIngresoConceptos.setForeground(new java.awt.Color(51, 153, 255));
        lblIngresoConceptos.setText("0.00");

        lblSalidasConceptos.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        lblSalidasConceptos.setForeground(new java.awt.Color(255, 51, 102));
        lblSalidasConceptos.setText("0.00");

        lblTittleBussiness12.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        lblTittleBussiness12.setForeground(new java.awt.Color(44, 62, 80));
        lblTittleBussiness12.setText("Salidas por conceptos");

        lblTittleBussiness13.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        lblTittleBussiness13.setForeground(new java.awt.Color(44, 62, 80));
        lblTittleBussiness13.setText("Total ingresos:");

        lblTotalIngresos.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        lblTotalIngresos.setForeground(new java.awt.Color(51, 153, 255));
        lblTotalIngresos.setText("0.00");

        lblTittleBussiness14.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        lblTittleBussiness14.setForeground(new java.awt.Color(44, 62, 80));
        lblTittleBussiness14.setText("Total salidas:");

        lblTotalSalidas.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        lblTotalSalidas.setForeground(new java.awt.Color(255, 51, 102));
        lblTotalSalidas.setText("0.00");

        javax.swing.GroupLayout PanelBusquedaVLayout = new javax.swing.GroupLayout(PanelBusquedaV);
        PanelBusquedaV.setLayout(PanelBusquedaVLayout);
        PanelBusquedaVLayout.setHorizontalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTittleBussiness11, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTittleBussiness10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTotalVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(lblIngresoConceptos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                                .addComponent(lblTittleBussiness12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSalidasConceptos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTittleBussiness14, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotalSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTittleBussiness13, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2))
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPaneVentasPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                                .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcomboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPaneVentasDia, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerarCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        PanelBusquedaVLayout.setVerticalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusquedaVLayout.createSequentialGroup()
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcomboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNuevoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGenerarCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneVentasDia, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(scrollPaneVentasPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalVentas, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTittleBussiness13)
                        .addComponent(lblTotalIngresos))
                    .addComponent(lblTittleBussiness10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTittleBussiness14)
                        .addComponent(lblTotalSalidas))
                    .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTittleBussiness11)
                        .addComponent(lblIngresoConceptos)
                        .addComponent(lblTittleBussiness12)
                        .addComponent(lblSalidasConceptos)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelTOPV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBusquedaV, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTOPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelBusquedaV, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    public void tableCierreModel() 
    {   
        modelo = new DefaultTableModel();
        modelo.addColumn("codigoC");
        modelo.addColumn("Fecha");
        //modelo.addColumn("Número factura");
        modelo.addColumn("Concepto");
        modelo.addColumn("Entrada");
        modelo.addColumn("Salida");
       // modelo.addColumn("Tipo");
        modelo.addColumn("Usuario");
        modelo.addColumn("codigoUser");
        
        tableCierre.setModel(modelo);
        
//       // TableColumn colCod = tableVentasPeriodos.getColumn("Número de factura");       //colCod.setPreferredWidth(1);  
//        tableVentasPeriodos.getColumn("Cliente").setPreferredWidth(50);     
//        tableVentasPeriodos.getColumn("Vendedor").setPreferredWidth(50);       
          tableCierre.getColumn("codigoC").setMaxWidth(0);    tableCierre.getColumn("codigoC").setMinWidth(0); tableCierre.getColumn("codigoC").setPreferredWidth(0);
        tableCierre.getColumn("codigoUser").setMaxWidth(0);    tableCierre.getColumn("codigoUser").setMinWidth(0); tableCierre.getColumn("codigoUser").setPreferredWidth(0);

        
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tableCierre.setRowSorter(sorter);
          
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, javax.swing.SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        
        scrollPaneVentasPeriodo.setViewportView(tableCierre);  

    }
    
    
     public void tableVentasModel() 
    {   
        modelo = new DefaultTableModel();
        modelo.addColumn("Número factura");
       // modelo.addColumn("Cliente");
        //modelo.addColumn("Vendedor");
        modelo.addColumn("Total de la venta");
        //modelo.addColumn("t");
        //modelo.addColumn("d");
        //modelo.addColumn("trnsp");
        
        tableVentasDia.setModel(modelo);
        
//        TableColumn colCod = tableVentas.getColumn("Número de factura");       //colCod.setPreferredWidth(1);  
//        TableColumn colCant = tableVentas.getColumn("ID cliente");     //  colName.setPreferredWidth(0);
//        TableColumn colPro = tableVentas.getColumn("ID vendedor");       // colTel.setPreferredWidth(50);
//          tableVentasDia.getColumn("t").setMaxWidth(0);    tableVentasDia.getColumn("t").setMinWidth(0); tableVentasDia.getColumn("t").setPreferredWidth(0);
 //         tableVentasDia.getColumn("d").setMaxWidth(0);    tableVentasDia.getColumn("d").setMinWidth(0); tableVentasDia.getColumn("d").setPreferredWidth(0);
 //         tableVentasDia.getColumn("trnsp").setMaxWidth(0);    tableVentasDia.getColumn("trnsp").setMinWidth(0); tableVentasDia.getColumn("trnsp").setPreferredWidth(0);

          /************************************/
          
          TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
          tableVentasDia.setRowSorter(sorter);
          
          List<RowSorter.SortKey> sortKeys = new ArrayList<>();
          sortKeys.add(new RowSorter.SortKey(0, javax.swing.SortOrder.DESCENDING));
          sorter.setSortKeys(sortKeys);
          /************************************/
        scrollPaneVentasDia.setViewportView(tableVentasDia);  
   
    }
    
    
    
    public void listar()
    {
       // limpiarTable();
        List<Ingreso_egreso> listaConceptos = Ingreso_egreso_controller.listarConceptos();
        
        modelo = (DefaultTableModel) tableCierre.getModel();
        Object[] ob = new Object[7];
        
        for (int i = 0; i < listaConceptos.size(); i++) 
        {
            ob[0] = listaConceptos.get(i).getCodigoCierre();
            ob[1] = listaConceptos.get(i).getFecha();
            ob[2] = listaConceptos.get(i).getConcepto();
            ob[3] = listaConceptos.get(i).getIngreso();
            ob[4] = listaConceptos.get(i).getEgreso();
            ob[5] = Usuario_controller.buscarUsuario(listaConceptos.get(i).getCodigoUsuario()).getNombre();
            ob[6] = listaConceptos.get(i).getCodigoUsuario();
            
            modelo.addRow(ob);
        }
        
            
    } 
    
    
     public void listarVentas()
    {
        List<Ventas> listaVentas = Ventas_controller.listarVentasDia();
        
        modelo = (DefaultTableModel) tableVentasDia.getModel();
        Object[] ob = new Object[2];
        
        for (int i = 0; i < listaVentas.size(); i++) 
        {
            ob[0] = listaVentas.get(i).getCodigoVenta();
            //pnlClientes.obtenerClientes();
//            
//            for (int j = 0; j < clientes.size(); j++) 
//            {
//                if (clientes.get(j).getCodigo() == listaVentas.get(i).getCodigoCliente()) 
//                {
//                    ob[1] = clientes.get(j).getNombre();
//                    ob[4] = clientes.get(j).getTelefono();
//                    ob[5] = clientes.get(j).getDireccion();
//                }
//            }
            
            ob[1] = listaVentas.get(i).getTotal();
            modelo.addRow(ob);
        }
        tableVentasDia.setModel(modelo);
    }
    
    
  
        
        
    
    private void tableCierreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCierreMouseClicked
        //fila = tableVentasDia.getSelectedRow();
    }//GEN-LAST:event_tableCierreMouseClicked

    private void btnGenerarCierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarCierreActionPerformed
        conceptos = null;
        
        double ingresoConceptoReport = Double.parseDouble(lblIngresoConceptos.getText().toString());
        double ingresoVentas = Double.parseDouble(lblTotalVentas.getText().toString());
        double totalSalidas = Double.parseDouble(lblTotalSalidas.getText().toString());
        String usuario = null;
        
        
        
        for (int i = 0; i < tableCierre.getRowCount(); i++) 
        {
            String concept = tableCierre.getValueAt(i, 2).toString();
            double entrada = (double) tableCierre.getValueAt(i, 3);        
            double salida = (double) tableCierre.getValueAt(i, 4);
            usuario = tableCierre.getValueAt(i, 5).toString();
            int codiUser = (int) tableCierre.getValueAt(i, 6);

            //detalleV.setCodigo_Venta(6);
            
//            detalle_toReporte.setCodigo(cod); 
//            detalle_toReporte.setDescripcion(produ);
//            detalle_toReporte.setPrecio(preci);
//            detalle_toReporte.setCantidad(cantiP);
//            detalle_toReporte.setTotal(totl);
//String concepto, double ingreso, double egreso, int codigoUsuario
           //String vendedor, double ingresoConceptos, double ingresoVentas, double totalIngresos, double totalSalidas
           conceptos = new Ingreso_egreso(concept, entrada, salida, codiUser);
    
           Ingreso_egreso_controller.listaConceptos.add(conceptos);
           
 
        }
        
           if(tableCierre.getRowCount() < 1 )
           {
               Ingreso_egreso_controller.listaConceptos.add(conceptos);
               ieController.generaReporteCierre(frameLogin.usuarioLogueado.getNombre(), ingresoConceptoReport, ingresoVentas, ingresoVentas + ingresoConceptoReport, totalSalidas);  
           }else
                ieController.generaReporteCierre(usuario, ingresoConceptoReport, ingresoVentas, ingresoVentas + ingresoConceptoReport, totalSalidas);  
                
                /*        modelo.addColumn("codigoC");
        modelo.addColumn("Fecha");
        //modelo.addColumn("Número factura");
        modelo.addColumn("Concepto");
        modelo.addColumn("Entrada");
        modelo.addColumn("Salida");
       // modelo.addColumn("Tipo");
        modelo.addColumn("Usuario");*/

        


//
//        if(dateInicial.getDatoFecha() != null && dateFinal.getDatoFecha() != null)
//        {
//            String formatoFecha = "dd MM yyyy";
//            String formatoFechaSQL = "yyy MM dd";
//
//            java.sql.Date fechaInicio = convert(dateInicial.getDatoFecha());
//            java.sql.Date fechaFinal = convert(dateFinal.getDatoFecha());
//            SimpleDateFormat formateador  = new SimpleDateFormat(formatoFecha);
//            SimpleDateFormat formateadorSQL = new SimpleDateFormat(formatoFechaSQL);
//            DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
//
//            if(!comparaFechas(fechaInicio, fechaFinal))
//            listarVentas(fechaInicio, fechaFinal);
//            else
//            notificaciones("fechaFinalMenor");
//
//            //Ventas_controller.listarVentasPeriodos(fechaInicio, fechaFinal);
//            // System.out.println("Fecha inicial: "+  fechaInicio +"\nFecha final: "+ fechaFinal);
//        }

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
    }//GEN-LAST:event_btnGenerarCierreActionPerformed

    private void txtConceptoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConceptoKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
//            if (!"".equals(txtConcepto.getText()))
//            {
//                
//                String concepto = txtConcepto.getText();
//
//                for (int i = 0; i < clientes.size(); i++) {
//
//                    if (clientes.get(i).getTelefono().equals(tel)) {
//                        codCliente = String.valueOf(clientes.get(i).getCodigo());
//
//                        txtNombre_cliente.setText(clientes.get(i).getNombre());
//                        txtDireccion_cliente.setText(clientes.get(i).getDireccion());
//
//                        cliente_toReport = clientes.get(i).getNombre();
//                        direccion_toReport = clientes.get(i).getDireccion();
//                    }
//                }
//            }
//            txtConcepto.requestFocus();
        }
    }//GEN-LAST:event_txtConceptoKeyPressed

    private void btnNuevoConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoConceptoActionPerformed
       limpiarTabla();
        conceptos = new Ingreso_egreso();
        
        if(!"".equals(txtConcepto.getText()) && !"".equals(txtCantidad.getText()))
        {
            if(jcomboTipo.getSelectedItem().equals("Entrada"))
            {
            
                conceptos.setConcepto(txtConcepto.getText());
                conceptos.setIngreso(Double.parseDouble(txtCantidad.getText()));
                conceptos.setCodigoUsuario(frameLogin.usuarioLogueado.getCodigo());
                Ingreso_egreso_controller.guardarConcepto(conceptos);
                
                txtConcepto.setText("");
                txtCantidad.setText("");
            }else
            {
                conceptos.setConcepto(txtConcepto.getText());
                conceptos.setEgreso(Double.parseDouble(txtCantidad.getText()));
                conceptos.setCodigoUsuario(frameLogin.usuarioLogueado.getCodigo()); 
                Ingreso_egreso_controller.guardarConcepto(conceptos);
                
                txtConcepto.setText("");
                txtCantidad.setText("");
            }
            

        }
        listar();
        calculaIngresoEgreso();
    }//GEN-LAST:event_btnNuevoConceptoActionPerformed

    
    private void calculaIngresoEgreso() 
    {
        ingresoConceptos = 0.00;            egresoConceptos = 0.00;              totalEgresos = 0.00;
        ingresoVentas = 0.00;               totalIngresos = 0.00;

        
        int numFila = tableCierre.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double ingreso = Double.parseDouble(String.valueOf(tableCierre.getModel().getValueAt(i, 3)));
            double egreso =  Double.parseDouble(String.valueOf(tableCierre.getModel().getValueAt(i, 4)));
            ingresoConceptos += ingreso;
            egresoConceptos += egreso;
        }
//        lblIngresoConceptos.setText(objDF.format(ingresoConceptos));
//        lblSalidasConceptos.setText(objDF.format(egresoConceptos));
        
        lblIngresoConceptos.setText(String.format("%.2f", ingresoConceptos));
        lblSalidasConceptos.setText(String.format("%.2f",egresoConceptos));
        //lblTotalPagar.setText(String.format("%.2f", totalPagar)
        
        int fila = tableVentasDia.getRowCount();
        for (int i = 0; i < fila; i++) {
            double ventas = Double.parseDouble(String.valueOf(tableVentasDia.getModel().getValueAt(i, 1)));
            ingresoVentas += ventas;
        }
//        lblTotalVentas.setText(objDF.format(ingresoVentas));
//        
//        lblTotalIngresos.setText(objDF.format(ingresoVentas + ingresoConceptos));
//        lblTotalSalidas.setText(objDF.format(egresoConceptos));
        
        
        lblTotalVentas.setText(String.format("%.2f", ingresoVentas));
        
        lblTotalIngresos.setText(String.format("%.2f", ingresoVentas + ingresoConceptos));
        lblTotalSalidas.setText(String.format("%.2f", egresoConceptos));
    }
    
    
    
    private void limpiarTabla()
    {
        modelo = (DefaultTableModel) tableCierre.getModel();
        
        int fila = tableCierre.getRowCount();
        
        for (int i = 0; i < fila; i++) 
        {
            modelo.removeRow(0);
        }
        
    }     
    
    
    
    
    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void jcomboTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcomboTipoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboTipoItemStateChanged

    private void tableVentasDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasDiaMouseClicked
        //fila = tableVentasDia.getSelectedRow();
    }//GEN-LAST:event_tableVentasDiaMouseClicked

    
    
    public void soloNumReales(JTextField c)
    {
        c.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent c){
                if(!Character.isDigit(c.getKeyChar()) && c.getKeyChar() != '.') //Solo permite digitar numeros
                {                                                              //y puntos para decimales
                    c.consume();
                }
            }
        });  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBusquedaV;
    private javax.swing.JPanel PanelTOPV;
    private javax.swing.JButton btnGenerarCierre;
    private javax.swing.JButton btnNuevoConcepto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> jcomboTipo;
    private javax.swing.JLabel lblIngresoConceptos;
    private javax.swing.JLabel lblSalidasConceptos;
    private javax.swing.JLabel lblTittleBussiness10;
    private javax.swing.JLabel lblTittleBussiness11;
    private javax.swing.JLabel lblTittleBussiness12;
    private javax.swing.JLabel lblTittleBussiness13;
    private javax.swing.JLabel lblTittleBussiness14;
    private javax.swing.JLabel lblTotalIngresos;
    private javax.swing.JLabel lblTotalSalidas;
    private javax.swing.JLabel lblTotalVentas;
    private javax.swing.JScrollPane scrollPaneVentasDia;
    private javax.swing.JScrollPane scrollPaneVentasPeriodo;
    private javax.swing.JTable tableCierre;
    private javax.swing.JTable tableVentasDia;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtConcepto;
    // End of variables declaration//GEN-END:variables
}
