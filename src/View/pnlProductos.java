
package View;

//import Controller.DBProductoInteraccion;
import Controller.Producto_controller;
import Model.Producto;
import com.lowagie.text.Font;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author kevin
 */
public class pnlProductos extends javax.swing.JPanel
{
    //public static ArchivosControl controlArchivos = new ArchivosControl(); 
    public static DefaultTableModel modelo = new DefaultTableModel();
    public static List<Producto> productos;
    List<Producto> coincidencias;
    int fila;
    boolean editarProducto = false;
    private TableRowSorter trsFiltro;
    DecimalFormat df = new DecimalFormat("#,###.00");
    DecimalFormat dfNormal = new DecimalFormat("#.##");
    
    public pnlProductos()
    {
        initComponents();
        tableProductosModel();
        //Layout();
        obtenerProductos();
        mostrarProductosInTable();
        establecerFocus();
        //txtCodigo_Producto.transferFocus();
    }
   
//    private void Layout()
//    {
//        setLayout(new BorderLayout());
//        add(PanelTitulo, BorderLayout.NORTH);
//        add(PanelDATOS, BorderLayout.WEST);
//        add(PanelBusqueda, BorderLayout.CENTER);       
//    }
    
    private void establecerFocus()
    {
        txtCodigo_Producto.requestFocus();
        
       // lblCod.setVisible(false); lblDescrip.setVisible(false); lblPrecio.setVisible(false);

        soloNumReales(txtPrecio_Producto);
        soloNumReales(txtPrecio_Uber);
        soloNumeros(txtCodigo_Producto);
    }
    
    
     public void soloLetras(JTextField a) 
    {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(Character.isDigit(c))    //si se digita un numero, es consumido y emite un sonido
                {                           //solo se permite digitar letras
                    e.consume();
                }   
            }     
        });    
    }
    
    public void soloNumeros(JTextField e)  
    {
         e.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(Character.isLetter(c))       //si una letra, es consumida solo se permite 
                {                               //digitar numeros
                    e.consume();
                }
             }   
        });
    }
        
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

     
    public void tableProductosModel() 
    {   
        modelo = new DefaultTableModel();
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("DESCRIPCIÓN");
        modelo.addColumn("PRECIO");
        modelo.addColumn("PRECIO UberEats");
        
        tableProductos.setModel(modelo);
        
        TableColumn colCod = tableProductos.getColumn("CÓDIGO");       colCod.setPreferredWidth(1);  
        TableColumn colDes = tableProductos.getColumn("DESCRIPCIÓN");  colDes.setPreferredWidth(250);
        TableColumn colPre = tableProductos.getColumn("PRECIO");       colPre.setPreferredWidth(45);
        TableColumn colPreU = tableProductos.getColumn("PRECIO UberEats");       colPreU.setPreferredWidth(60);
        
        
        JTableHeader th  = tableProductos.getTableHeader();
        th.setFont(tableProductos.getFont().deriveFont(Font.BOLD));       
        //tableProductos.setFont(tableProductos.getFont().deriveFont(Font.BOLD));
        
        
        ScrollPaneTable.setViewportView(tableProductos);  
    }
    
    
    public void obtenerProductos() 
    {
        try
        {
            productos = Producto_controller.listarProducto();

        } catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        } 
    }
    
    public void mostrarProductosInTable()
    {
        tableProductos.setVisible(false);
        tableProductos.setModel(modelo);
        modelo.fireTableDataChanged();
        
        Object[] row = new Object[modelo.getColumnCount()];
        
        DefaultTableModel modelo = (DefaultTableModel) tableProductos.getModel();
        
        while(modelo.getRowCount()>0)
            modelo.removeRow(0);
 
        for(int i=0; i<productos.size(); i++)
        {
            row[0] = productos.get(i).getCodigo();
            row[1] = productos.get(i).getDescripcion();
            row[2] = productos.get(i).getPrecio();
            row[3] = productos.get(i).getPrecioUberEats();
            
            modelo.addRow(row);
        }  
        tableProductos.setVisible(true);
        
        if(tableProductos.getRowCount() <= 0)
        {
            btnEditar_Producto.setEnabled(false);   btnEliminar_Producto.setEnabled(false);
        }  
//        else
//        {  
//            btnEditar_Producto.setEnabled(true);  btnEliminar_Producto.setEnabled(true); 
//        }        
    }
       
    
    //Warnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMenu = new javax.swing.JPanel();
        PanelTitulo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PanelDATOS = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Label_CodigoPDT = new javax.swing.JLabel();
        txtCodigo_Producto = new javax.swing.JTextField();
        Label_DescripcionPDT = new javax.swing.JLabel();
        txtDescripcion_Producto = new javax.swing.JTextField();
        Label_UnidadPDT = new javax.swing.JLabel();
        txtPrecio_Producto = new javax.swing.JTextField();
        btnCancelar_Producto = new javax.swing.JButton();
        btnGuardar_Producto = new javax.swing.JButton();
        Label_UnidadPDT1 = new javax.swing.JLabel();
        txtPrecio_Uber = new javax.swing.JTextField();
        PanelBusqueda = new javax.swing.JPanel();
        Label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar_Producto = new javax.swing.JTextField();
        PanelTable = new javax.swing.JPanel();
        ScrollPaneTable = new javax.swing.JScrollPane();
        tableProductos = tableProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnEditar_Producto = new javax.swing.JButton();
        btnEliminar_Producto = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(945, 486));

        PanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu.setPreferredSize(new java.awt.Dimension(1070, 466));

        PanelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        PanelTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("Productos");

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        PanelDATOS.setBackground(new java.awt.Color(255, 255, 255));
        PanelDATOS.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setText("Ingrese la información del nuevo producto");
        jLabel11.setToolTipText("");

        Label_CodigoPDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_CodigoPDT.setText("Código del producto");
        Label_CodigoPDT.setToolTipText("");

        txtCodigo_Producto.setToolTipText("");
        txtCodigo_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigo_ProductoProductoKeyPressedEventsTXT(evt);
            }
        });

        Label_DescripcionPDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_DescripcionPDT.setText("Descripción");

        txtDescripcion_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcion_ProductoProductoKeyPressedEventsTXT(evt);
            }
        });

        Label_UnidadPDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_UnidadPDT.setText("Precio");
        Label_UnidadPDT.setToolTipText("");

        txtPrecio_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecio_ProductoProductoKeyPressedEventsTXT(evt);
            }
        });

        btnCancelar_Producto.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar_color.png"))); // NOI18N
        btnCancelar_Producto.setText("Cancelar");
        btnCancelar_Producto.setBorder(null);
        btnCancelar_Producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar_Producto.setFocusPainted(false);
        btnCancelar_Producto.setFocusable(false);
        btnCancelar_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar_ProductoActionPerformed(evt);
            }
        });

        btnGuardar_Producto.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar_color.png"))); // NOI18N
        btnGuardar_Producto.setText("Guardar");
        btnGuardar_Producto.setBorder(null);
        btnGuardar_Producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar_Producto.setFocusPainted(false);
        btnGuardar_Producto.setFocusable(false);
        btnGuardar_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar_ProductoActionPerformed(evt);
            }
        });

        Label_UnidadPDT1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_UnidadPDT1.setText("Precio UberEats");
        Label_UnidadPDT1.setToolTipText("");

        txtPrecio_Uber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecio_UberProductoKeyPressedEventsTXT(evt);
            }
        });

        javax.swing.GroupLayout PanelDATOSLayout = new javax.swing.GroupLayout(PanelDATOS);
        PanelDATOS.setLayout(PanelDATOSLayout);
        PanelDATOSLayout.setHorizontalGroup(
            PanelDATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDATOSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDATOSLayout.createSequentialGroup()
                        .addGroup(PanelDATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(Label_CodigoPDT)
                            .addComponent(txtCodigo_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_DescripcionPDT)
                            .addComponent(txtDescripcion_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_UnidadPDT)
                            .addGroup(PanelDATOSLayout.createSequentialGroup()
                                .addComponent(btnGuardar_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(PanelDATOSLayout.createSequentialGroup()
                        .addGroup(PanelDATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio_Uber, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_UnidadPDT1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelDATOSLayout.setVerticalGroup(
            PanelDATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDATOSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(31, 31, 31)
                .addComponent(Label_CodigoPDT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label_DescripcionPDT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_UnidadPDT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label_UnidadPDT1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio_Uber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(PanelDATOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        PanelBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        PanelBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelBusqueda.setPreferredSize(new java.awt.Dimension(630, 358));

        Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label.setForeground(new java.awt.Color(0, 153, 204));
        Label.setText("Productos ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setText("Buscar");

        txtBuscar_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscar_ProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_ProductoKeyTyped(evt);
            }
        });

        PanelTable.setBackground(new java.awt.Color(255, 255, 255));

        ScrollPaneTable.setBackground(new java.awt.Color(255, 255, 255));

        tableProductos.setBackground(new java.awt.Color(204, 255, 255));
        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableProductos.setToolTipText("");
        tableProductos.setRowHeight(25);
        tableProductos.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductosMouseClicked(evt);
            }
        });
        ScrollPaneTable.setViewportView(tableProductos);

        javax.swing.GroupLayout PanelTableLayout = new javax.swing.GroupLayout(PanelTable);
        PanelTable.setLayout(PanelTableLayout);
        PanelTableLayout.setHorizontalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelTableLayout.setVerticalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEditar_Producto.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar_color.png"))); // NOI18N
        btnEditar_Producto.setText("Editar");
        btnEditar_Producto.setBorder(null);
        btnEditar_Producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar_Producto.setFocusPainted(false);
        btnEditar_Producto.setFocusable(false);
        btnEditar_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar_ProductoActionPerformed(evt);
            }
        });

        btnEliminar_Producto.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar_color.png"))); // NOI18N
        btnEliminar_Producto.setText("Eliminar");
        btnEliminar_Producto.setBorder(null);
        btnEliminar_Producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar_Producto.setFocusPainted(false);
        btnEliminar_Producto.setFocusable(false);
        btnEliminar_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_ProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBusquedaLayout = new javax.swing.GroupLayout(PanelBusqueda);
        PanelBusqueda.setLayout(PanelBusquedaLayout);
        PanelBusquedaLayout.setHorizontalGroup(
            PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBusquedaLayout.createSequentialGroup()
                        .addComponent(PanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelBusquedaLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Label)
                        .addGap(45, 45, 45)
                        .addComponent(btnEditar_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        PanelBusquedaLayout.setVerticalGroup(
            PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtBuscar_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Label)
                        .addComponent(btnEditar_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminar_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelDATOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(PanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelDATOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigo_ProductoProductoKeyPressedEventsTXT(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtCodigo_ProductoProductoKeyPressedEventsTXT
    {//GEN-HEADEREND:event_txtCodigo_ProductoProductoKeyPressedEventsTXT
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txtDescripcion_Producto.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            txtDescripcion_Producto.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_UP)
            txtBuscar_Producto.requestFocus();
    }//GEN-LAST:event_txtCodigo_ProductoProductoKeyPressedEventsTXT

    private void txtDescripcion_ProductoProductoKeyPressedEventsTXT(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtDescripcion_ProductoProductoKeyPressedEventsTXT
    {//GEN-HEADEREND:event_txtDescripcion_ProductoProductoKeyPressedEventsTXT
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txtPrecio_Producto.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            txtPrecio_Producto.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_UP)
            txtCodigo_Producto.requestFocus();
    }//GEN-LAST:event_txtDescripcion_ProductoProductoKeyPressedEventsTXT

    private void txtPrecio_ProductoProductoKeyPressedEventsTXT(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtPrecio_ProductoProductoKeyPressedEventsTXT
    {//GEN-HEADEREND:event_txtPrecio_ProductoProductoKeyPressedEventsTXT

        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txtPrecio_Uber.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_UP)
            txtDescripcion_Producto.requestFocus(); 
        else if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            txtPrecio_Uber.requestFocus();
    }//GEN-LAST:event_txtPrecio_ProductoProductoKeyPressedEventsTXT

    private void btnCancelar_ProductoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelar_ProductoActionPerformed
    {//GEN-HEADEREND:event_btnCancelar_ProductoActionPerformed
        cleanTXT();
        establecerFocus();
    }//GEN-LAST:event_btnCancelar_ProductoActionPerformed

    private void btnGuardar_ProductoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGuardar_ProductoActionPerformed
    {//GEN-HEADEREND:event_btnGuardar_ProductoActionPerformed
        if(!editarProducto)
            try {
                guardarProducto();
        } catch (SQLException ex) {
            Logger.getLogger(pnlProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnlProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        else
        {
            editarProducto();
            editarProducto = false;
        }        
    }//GEN-LAST:event_btnGuardar_ProductoActionPerformed
   
    public void guardarProducto() throws SQLException, ClassNotFoundException
    {
        double precioUberEats = 0.0;
        
        if(validaTXT("producto"))
        {           
            int codigo = parseInt(txtCodigo_Producto.getText());
            double precio = Double.parseDouble(txtPrecio_Producto.getText());
            
            if(!"".equals(txtPrecio_Uber.getText()))
                precioUberEats = Double.parseDouble(txtPrecio_Uber.getText());
            
            Producto producto = new Producto(codigo, txtDescripcion_Producto.getText(), precio, precioUberEats);

            if(Producto_controller.guardarProducto(producto))
            {                
                Producto_controller.Notificaciones("prodSaved");
            }
                

            cleanTXT();
            txtCodigo_Producto.requestFocus();

            obtenerProductos(); mostrarProductosInTable();                           
        }        
    } 
    
    
    public void editarProducto()
    {
        double precioUberEats = 0.0;
        
        if(validaTXT("producto"))
        {           

            int codigo = parseInt(txtCodigo_Producto.getText());
            double precio = Double.parseDouble(txtPrecio_Producto.getText());

            if(!"".equals(txtPrecio_Uber.getText()))
                precioUberEats = Double.parseDouble(txtPrecio_Uber.getText());
            
            Producto producto = new Producto(codigo, txtDescripcion_Producto.getText(), precio, precioUberEats);

            if(Producto_controller.editarProducto(producto))
            {
                Producto_controller.Notificaciones("prodEdit");
            }

            cleanTXT();
            establecerFocus();    txtCodigo_Producto.setEditable(true);

            obtenerProductos();  mostrarProductosInTable();           
        } 
    }
        
    
    private boolean validaTXT(String panel)
    {
        boolean estado = false;
        
        if(panel.equalsIgnoreCase("producto"))
        {
            if(txtCodigo_Producto.getText().isEmpty())
            {
               // lblCod.setVisible(true);  txtCodigo_Producto.requestFocus();  return estado;                
            }
            else if(txtDescripcion_Producto.getText().isEmpty())
            {
               // lblDescrip.setVisible(true); txtDescripcion_Producto.requestFocus();  return estado;
            }
            else if(txtPrecio_Producto.getText().isEmpty())
            {
               // lblPrecio.setVisible(true); txtPrecio_Producto.requestFocus(); return estado;
            }
            else
                estado = true;            
        }
        
        return estado;
    }
    
    
    public void cleanTXT()
    {
        txtCodigo_Producto.setText("");
        txtDescripcion_Producto.setText("");
        txtPrecio_Producto.setText("");        
        txtBuscar_Producto.setText("");
        txtPrecio_Uber.setText("");
    }    
    
    
    
    private void tableProductosMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tableProductosMouseClicked
    {//GEN-HEADEREND:event_tableProductosMouseClicked
        fila = tableProductos.getSelectedRow();
    }//GEN-LAST:event_tableProductosMouseClicked

    public void buscarProducto(String descripcion)
    {
        coincidencias = new ArrayList<>();
        String descrip = null;
               
        for(int i=0; i<productos.size(); i++)
        {
            descrip = productos.get(i).getDescripcion().toLowerCase();
            
            if(descrip.startsWith(descripcion.toLowerCase()))
                coincidencias.add(productos.get(i));
        }  
        
        mostrarCoincidenciasInTable();
    }
    
    
    public void mostrarCoincidenciasInTable()
    {
        tableProductos.setVisible(false);
        tableProductos.setModel(modelo);
        modelo.fireTableDataChanged();
        
        Object[] row = new Object[modelo.getColumnCount()];
        
        DefaultTableModel modelo = (DefaultTableModel) tableProductos.getModel();
        
        while(modelo.getRowCount()>0)
            modelo.removeRow(0);
            

        for(int i=0; i<coincidencias.size(); i++)
        {
            row[0] = coincidencias.get(i).getCodigo();
            row[1] = coincidencias.get(i).getDescripcion();
            row[2] = coincidencias.get(i).getPrecio();

            modelo.addRow(row);
        }  
        tableProductos.setVisible(true);
        
//        if(tableProductos.getRowCount() < 0)
//        {
//            btnEditar_Producto.setEnabled(false);   btnEliminar_Producto.setEnabled(false);
//        }  
//        else
//        {  
//            btnEditar_Producto.setEnabled(true);  btnEliminar_Producto.setEnabled(true); 
//        }         
    }
    
    private void btnEditar_ProductoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEditar_ProductoActionPerformed
    {//GEN-HEADEREND:event_btnEditar_ProductoActionPerformed
        if( txtCodigo_Producto.hasFocus() || txtDescripcion_Producto.hasFocus() || txtPrecio_Producto.hasFocus() || txtBuscar_Producto.hasFocus())
        txtCodigo_Producto.requestFocus();

        else
        {
            if(tableProductos.getSelectedRow() < 0 )//< -1)
            {
               txtCodigo_Producto.requestFocus(); 
               editarProducto = false;
            }    
            else
            {
                int codigo = (int) tableProductos.getValueAt(fila, 0);

                txtCodigo_Producto.setText(String.valueOf(codigo));    txtCodigo_Producto.setEditable(false);
                editarProducto = true;
                txtDescripcion_Producto.setText(String.valueOf(tableProductos.getValueAt(fila, 1))); txtDescripcion_Producto.requestFocus();
                txtPrecio_Producto.setText(String.valueOf(tableProductos.getValueAt(fila, 2)));
                txtPrecio_Uber.setText(String.valueOf(tableProductos.getValueAt(fila, 3)));

            }
        }
    }//GEN-LAST:event_btnEditar_ProductoActionPerformed

    private void btnEliminar_ProductoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEliminar_ProductoActionPerformed
    {//GEN-HEADEREND:event_btnEliminar_ProductoActionPerformed
        if( txtCodigo_Producto.hasFocus() || txtDescripcion_Producto.hasFocus() || txtPrecio_Producto.hasFocus() || txtBuscar_Producto.hasFocus())
        txtCodigo_Producto.requestFocus();

        else
        {
            if(tableProductos.getSelectedRow() < 0)
                txtCodigo_Producto.requestFocus();
            else
            {
                int codigo = (int) tableProductos.getValueAt(fila, 0);
                eliminarProducto(codigo);
            }
        }
    }//GEN-LAST:event_btnEliminar_ProductoActionPerformed

    private void txtBuscar_ProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_ProductoKeyTyped

        txtBuscar_Producto.addKeyListener(new KeyAdapter() {              
             public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscar_Producto.getText());
                txtBuscar_Producto.setText(cadena);
                //repaint();
                String toSearch = "^";
                toSearch = toSearch.concat(txtBuscar_Producto.getText());

                trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + toSearch, 1));
            }
        });
        trsFiltro = new TableRowSorter(tableProductos.getModel());
        tableProductos.setRowSorter(trsFiltro);                
    }//GEN-LAST:event_txtBuscar_ProductoKeyTyped

    private void txtBuscar_ProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_ProductoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_LEFT)
            txtCodigo_Producto.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            txtCodigo_Producto.requestFocus();

    }//GEN-LAST:event_txtBuscar_ProductoKeyPressed

    private void txtPrecio_UberProductoKeyPressedEventsTXT(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio_UberProductoKeyPressedEventsTXT
        if(evt.getKeyCode() == KeyEvent.VK_UP)
            txtPrecio_Producto.requestFocus();
    }//GEN-LAST:event_txtPrecio_UberProductoKeyPressedEventsTXT

    public void eliminarProducto(int codigo)
    {
        Producto producto = new Producto();
        producto.setCodigo(codigo);
        
         if(Producto_controller.eliminarProducto(producto))
         {
             Producto_controller.Notificaciones("prodDelete");
         }
         
        cleanTXT();
        establecerFocus();
         
         obtenerProductos(); mostrarProductosInTable();
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JLabel Label_CodigoPDT;
    private javax.swing.JLabel Label_DescripcionPDT;
    private javax.swing.JLabel Label_UnidadPDT;
    private javax.swing.JLabel Label_UnidadPDT1;
    private javax.swing.JPanel PanelBusqueda;
    private javax.swing.JPanel PanelDATOS;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelTable;
    private javax.swing.JPanel PanelTitulo;
    public javax.swing.JScrollPane ScrollPaneTable;
    private javax.swing.JButton btnCancelar_Producto;
    public javax.swing.JButton btnEditar_Producto;
    public javax.swing.JButton btnEliminar_Producto;
    private javax.swing.JButton btnGuardar_Producto;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JTable tableProductos;
    public javax.swing.JTextField txtBuscar_Producto;
    public javax.swing.JTextField txtCodigo_Producto;
    public javax.swing.JTextField txtDescripcion_Producto;
    public javax.swing.JTextField txtPrecio_Producto;
    public javax.swing.JTextField txtPrecio_Uber;
    // End of variables declaration//GEN-END:variables
}
