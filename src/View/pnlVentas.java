
package View;

import Controller.Cliente_controller;
import Controller.Email_controller;
import Controller.Producto_controller;
import Controller.Ventas_controller;
import Model.Cliente;
import Model.Detalle_Ventas;
import Model.Tiquete_venta;
import Model.Producto;
import Model.Ventas;
import static View.DashboardPrincipal.maximized;
import static View.pnlClientes.clientes;
import static View.pnlProductos.productos;
import com.lowagie.text.Font;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


/**
 *
 * @author Kevin
 */
public class pnlVentas extends javax.swing.JFrame {
    public static DefaultTableModel modelo = new DefaultTableModel();
    static boolean maximized = true;
    private boolean guardarCliente = false;
    private boolean enviarFactura = false;
    private String correoCliente = "";
    int xMouse;
    int yMouse;
    Ventas venta; 
    Detalle_Ventas detalleV;
    Tiquete_venta detalle_toReporte;
    Ventas_controller ventaControl;
    public static List<Producto> productosVenta;
    public List<Detalle_Ventas> detalleVenta;
    Producto productoSeleccionado;
    int cantidadProducto = 0;
    double precioTotal = 0;
    double totalPagar;
    double transporte;
    String codCliente;
    boolean existeCliente = false;
    boolean isUberClient = false;
    DecimalFormat df = new DecimalFormat("#,###.00");
    

    public pnlVentas() {
        initComponents();
        fecha();
        tableProductosModel();
        this.setLocationRelativeTo(null);
        lblVendedor.setText(frameLogin.usuarioLogueado.getNombre());
        lblNumFactura.setText(valueOf(Ventas_controller.getNumeroFactura()));
        
        venta = new Ventas();
        detalleV = new Detalle_Ventas();
       // detalle_toReporte = new Detalle_venta_to_reporte();
        ventaControl = new Ventas_controller();
        pnlProductos viewProductos = new pnlProductos();
        pnlClientes viewClientes = new pnlClientes();       
        viewProductos.obtenerProductos();
        viewClientes.obtenerClientes();
        
        productosVenta = new ArrayList<>();
        detalleVenta = new ArrayList<>();
        llenarComboBox();
        AutoCompleteDecorator.decorate(jcomboProductos);
        soloNumReales(txtTransporte);
        soloNumReales(txtProducto);
        verificaCheckEmail();
        abrirMaximizado();
        
        checkEnviarFactura.setVisible(false);
        //btnAnularVenta.setVisible(false);
    }

    
    
    private void abrirMaximizado()
    {
        pnlVentas.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        pnlVentas.this.setMaximizedBounds(env.getMaximumWindowBounds());
        maximized = false;
    }
    
    
    private void llenarComboBox()
    {
        
        for (int i = 0; i < productos.size(); i++) 
        {
            String descripcionProducto = productos.get(i).getDescripcion();
            String precio = valueOf(productos.get(i).getPrecio());
            
            //jcomboProductos.addItem("<html><font color=black> "+descripcionProducto+"<html><font color=blue> "+"     -     "+precio+"</font></html>");
            jcomboProductos.addItem(descripcionProducto);
        }        
    }
    
    
    public void tableProductosModelSearch() 
    {   
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Descripción");
        modelo.addColumn("Precio");
        
        tableOculta.setModel(modelo);
                  
        scrollTable.setViewportView(tableOculta);  
    }
    
    public void llenarTableOculta()
    {
        tableOculta.setVisible(false);
        tableOculta.setModel(modelo);
        modelo.fireTableDataChanged();
        
        Object[] row = new Object[modelo.getColumnCount()];
        
        DefaultTableModel modelo = (DefaultTableModel) tableOculta.getModel();
        
        while(modelo.getRowCount()>0)
            modelo.removeRow(0);
            

        for(int i=0; i<productos.size(); i++)
        {
            row[0] = productos.get(i).getCodigo();
            row[1] = productos.get(i).getDescripcion();
            row[2] = productos.get(i).getPrecio();

            modelo.addRow(row);
        }  
        //tableOculta.setVisible(true);
    }
    
    

    public void tableProductosModel() 
    {   
        modelo = new DefaultTableModel();
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("PRECIO");
        modelo.addColumn("TOTAL");
        
        tableProductos.setModel(modelo);
        
//        TableColumn colCod = tableProductos.getColumn("Código");       //colCod.setPreferredWidth(1);  
//        TableColumn colCant = tableProductos.getColumn("Cantidad");     //  colName.setPreferredWidth(0);
//        TableColumn colPro = tableProductos.getColumn("Producto");       // colTel.setPreferredWidth(50);
//        TableColumn colPreci = tableProductos.getColumn("Precio");       //colDir.setPreferredWidth(100);
//        TableColumn colTotal = tableProductos.getColumn("Total");

        JTableHeader th  = tableProductos.getTableHeader();
        th.setFont(tableProductos.getFont().deriveFont(Font.BOLD));       
        //th.setFont(tableProductos.getFont().deriveFont(20));
        tableProductos.setFont(tableProductos.getFont().deriveFont(Font.BOLD));

        ScrollPaneTableProductos.setViewportView(tableProductos);  
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTable = new javax.swing.JScrollPane();
        tableOculta = new javax.swing.JTable();
        pnlTop = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnMaximize = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();
        pnlNumFactura = new javax.swing.JPanel();
        lblTittleBussiness1 = new javax.swing.JLabel();
        lblNumFactura = new javax.swing.JLabel();
        pnlDatosVendedor = new javax.swing.JPanel();
        lblTittleBussiness = new javax.swing.JLabel();
        lblTittleBussiness3 = new javax.swing.JLabel();
        lblVendedor = new javax.swing.JLabel();
        txtNombre_cliente = new javax.swing.JTextField();
        lblTittleBussiness5 = new javax.swing.JLabel();
        txtDireccion_cliente = new javax.swing.JTextField();
        lblTittleBussiness6 = new javax.swing.JLabel();
        txtTelefono_cliente = new javax.swing.JTextField();
        checkGuardarCliente = new javax.swing.JCheckBox();
        checkEnviarFactura = new javax.swing.JCheckBox();
        lblCorreoCliente = new javax.swing.JLabel();
        txtCorreoCliente = new javax.swing.JTextField();
        pnlFecha = new javax.swing.JPanel();
        lblTittleBussiness4 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        pnlDescripProductos = new javax.swing.JPanel();
        txtProducto = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jcomboProductos = new javax.swing.JComboBox<>();
        pnlBody = new javax.swing.JPanel();
        ScrollPaneTableProductos = new javax.swing.JScrollPane();
        tableProductos = tableProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return true; //Disallow the editing of any cell
            }
        };
        pnlBottom = new javax.swing.JPanel();
        lblTittleBussiness9 = new javax.swing.JLabel();
        lblTotalPagar = new javax.swing.JLabel();
        lblTittleBussiness10 = new javax.swing.JLabel();
        txtTransporte = new javax.swing.JTextField();
        pnlBottom1 = new javax.swing.JPanel();
        lblAtajo2 = new javax.swing.JLabel();
        lblAtajo3 = new javax.swing.JLabel();
        lblAtajo6 = new javax.swing.JLabel();
        btnGenerarVenta = new lib.RSButtonMetro();
        btnCancelar = new lib.RSButtonMetro();

        scrollTable.setViewportView(tableOculta);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/Images/ramen.png")).getImage());
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1120, 800));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop.setForeground(new java.awt.Color(255, 255, 255));
        pnlTop.setPreferredSize(new java.awt.Dimension(1120, 805));
        pnlTop.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTopMouseDragged(evt);
            }
        });
        pnlTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTopMousePressed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusable(false);
        btnExit.setOpaque(true);
        btnExit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit (2).png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnMaximize.setBackground(new java.awt.Color(255, 255, 255));
        btnMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maximize.png"))); // NOI18N
        btnMaximize.setContentAreaFilled(false);
        btnMaximize.setFocusable(false);
        btnMaximize.setOpaque(true);
        btnMaximize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maximize (2).png"))); // NOI18N
        btnMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMaximizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMaximizeMouseExited(evt);
            }
        });
        btnMaximize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaximizeActionPerformed(evt);
            }
        });

        btnMinimize.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minimize.png"))); // NOI18N
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setFocusable(false);
        btnMinimize.setOpaque(true);
        btnMinimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minimize (2).png"))); // NOI18N
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseExited(evt);
            }
        });
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pnlMenuKeyPressed(evt);
            }
        });

        pnlNumFactura.setBackground(new java.awt.Color(255, 255, 255));
        pnlNumFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblTittleBussiness1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTittleBussiness1.setForeground(new java.awt.Color(44, 62, 80));
        lblTittleBussiness1.setText("No. Factura");

        lblNumFactura.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblNumFactura.setForeground(new java.awt.Color(44, 62, 80));
        lblNumFactura.setText("######");
        lblNumFactura.setToolTipText("");
        lblNumFactura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlNumFacturaLayout = new javax.swing.GroupLayout(pnlNumFactura);
        pnlNumFactura.setLayout(pnlNumFacturaLayout);
        pnlNumFacturaLayout.setHorizontalGroup(
            pnlNumFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNumFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittleBussiness1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNumFacturaLayout.setVerticalGroup(
            pnlNumFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNumFacturaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlNumFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTittleBussiness1)
                    .addComponent(lblNumFactura))
                .addGap(32, 32, 32))
        );

        pnlDatosVendedor.setBackground(new java.awt.Color(255, 255, 255));
        pnlDatosVendedor.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblTittleBussiness.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTittleBussiness.setForeground(new java.awt.Color(44, 62, 80));
        lblTittleBussiness.setText("Cliente");

        lblTittleBussiness3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTittleBussiness3.setForeground(new java.awt.Color(44, 62, 80));
        lblTittleBussiness3.setText("Vendedor:");

        lblVendedor.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblVendedor.setForeground(new java.awt.Color(44, 62, 80));
        lblVendedor.setText("###############");

        txtNombre_cliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtNombre_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombre_clienteKeyPressed(evt);
            }
        });

        lblTittleBussiness5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTittleBussiness5.setForeground(new java.awt.Color(44, 62, 80));
        lblTittleBussiness5.setText("Dirección");

        txtDireccion_cliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtDireccion_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccion_clienteKeyPressed(evt);
            }
        });

        lblTittleBussiness6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTittleBussiness6.setForeground(new java.awt.Color(44, 62, 80));
        lblTittleBussiness6.setText("Teléfono");

        txtTelefono_cliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtTelefono_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefono_clienteKeyPressed(evt);
            }
        });

        checkGuardarCliente.setBackground(new java.awt.Color(255, 255, 255));
        checkGuardarCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkGuardarCliente.setText("Guardar cliente");
        checkGuardarCliente.setFocusPainted(false);
        checkGuardarCliente.setFocusable(false);
        checkGuardarCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkGuardarClienteItemStateChanged(evt);
            }
        });

        checkEnviarFactura.setBackground(new java.awt.Color(255, 255, 255));
        checkEnviarFactura.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkEnviarFactura.setText("Enviar copia factura");
        checkEnviarFactura.setFocusPainted(false);
        checkEnviarFactura.setFocusable(false);
        checkEnviarFactura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkEnviarFacturaItemStateChanged(evt);
            }
        });

        lblCorreoCliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblCorreoCliente.setForeground(new java.awt.Color(44, 62, 80));
        lblCorreoCliente.setText("Email");

        txtCorreoCliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtCorreoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoClienteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosVendedorLayout = new javax.swing.GroupLayout(pnlDatosVendedor);
        pnlDatosVendedor.setLayout(pnlDatosVendedorLayout);
        pnlDatosVendedorLayout.setHorizontalGroup(
            pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlDatosVendedorLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosVendedorLayout.createSequentialGroup()
                        .addComponent(lblTittleBussiness3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(188, Short.MAX_VALUE))
                    .addGroup(pnlDatosVendedorLayout.createSequentialGroup()
                        .addGroup(pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblTittleBussiness5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(lblTittleBussiness6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblTittleBussiness, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosVendedorLayout.createSequentialGroup()
                                .addComponent(txtNombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorreoCliente))
                            .addGroup(pnlDatosVendedorLayout.createSequentialGroup()
                                .addGroup(pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkEnviarFactura)
                                    .addComponent(checkGuardarCliente))))
                        .addGap(26, 26, 26))))
        );
        pnlDatosVendedorLayout.setVerticalGroup(
            pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosVendedorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVendedor)
                    .addComponent(lblTittleBussiness3))
                .addGroup(pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosVendedorLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTittleBussiness6)
                            .addComponent(txtTelefono_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTittleBussiness5)
                            .addComponent(txtDireccion_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosVendedorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkGuardarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkEnviarFactura)
                        .addGap(8, 8, 8)))
                .addGroup(pnlDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTittleBussiness)
                    .addComponent(txtNombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreoCliente))
                .addGap(18, 18, 18))
        );

        pnlFecha.setBackground(new java.awt.Color(255, 255, 255));
        pnlFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblTittleBussiness4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTittleBussiness4.setForeground(new java.awt.Color(44, 62, 80));
        lblTittleBussiness4.setText("Fecha");

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(44, 62, 80));
        lblFecha.setText("00/00/0000");
        lblFecha.setToolTipText("");
        lblFecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlFechaLayout = new javax.swing.GroupLayout(pnlFecha);
        pnlFecha.setLayout(pnlFechaLayout);
        pnlFechaLayout.setHorizontalGroup(
            pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittleBussiness4)
                .addGap(18, 18, 18)
                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFechaLayout.setVerticalGroup(
            pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFechaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTittleBussiness4)
                    .addComponent(lblFecha))
                .addGap(32, 32, 32))
        );

        pnlDescripProductos.setBackground(new java.awt.Color(52, 152, 219));
        pnlDescripProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtProducto.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        txtProducto.setPreferredSize(new java.awt.Dimension(6, 35));
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
        });

        btnAgregarProducto.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregarProducto.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(44, 62, 80));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/agregarProducto.png"))); // NOI18N
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.setToolTipText("Agregar Producto");
        btnAgregarProducto.setContentAreaFilled(false);
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.setFocusable(false);
        btnAgregarProducto.setPreferredSize(new java.awt.Dimension(100, 27));
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        txtDescripcion.setPreferredSize(new java.awt.Dimension(6, 35));

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        txtPrecio.setPreferredSize(new java.awt.Dimension(6, 35));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DESCRIPCIÓN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PRECIO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CÓDIGO");

        txtCantidad.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        txtCantidad.setPreferredSize(new java.awt.Dimension(6, 35));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CANTIDAD");

        btnEliminar.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(44, 62, 80));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnEliminar.setMnemonic('3');
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Eliminar producto");
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusable(false);
        btnEliminar.setPreferredSize(new java.awt.Dimension(100, 27));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jcomboProductos.setEditable(true);
        jcomboProductos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcomboProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRODUCTOS" }));
        jcomboProductos.setToolTipText("");
        jcomboProductos.setPreferredSize(new java.awt.Dimension(6, 35));
        jcomboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboProductosActionPerformed(evt);
            }
        });
        jcomboProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcomboProductosKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlDescripProductosLayout = new javax.swing.GroupLayout(pnlDescripProductos);
        pnlDescripProductos.setLayout(pnlDescripProductosLayout);
        pnlDescripProductosLayout.setHorizontalGroup(
            pnlDescripProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDescripProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDescripProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDescripProductosLayout.createSequentialGroup()
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcomboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDescripProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDescripProductosLayout.createSequentialGroup()
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDescripProductosLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel4)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDescripProductosLayout.setVerticalGroup(
            pnlDescripProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDescripProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDescripProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDescripProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addGroup(pnlDescripProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGap(2, 2, 2)
                .addGroup(pnlDescripProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDescripProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDescripProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcomboProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlBody.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlBody.setMinimumSize(new java.awt.Dimension(654, 630));

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
        ScrollPaneTableProductos.setViewportView(tableProductos);

        javax.swing.GroupLayout pnlBodyLayout = new javax.swing.GroupLayout(pnlBody);
        pnlBody.setLayout(pnlBodyLayout);
        pnlBodyLayout.setHorizontalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTableProductos)
                .addContainerGap())
        );
        pnlBodyLayout.setVerticalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTableProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBottom.setBackground(new java.awt.Color(52, 152, 219));
        pnlBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlBottom.setToolTipText("");

        lblTittleBussiness9.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        lblTittleBussiness9.setForeground(new java.awt.Color(255, 255, 255));
        lblTittleBussiness9.setText("Transporte:");

        lblTotalPagar.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTotalPagar.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPagar.setText("0.00");

        lblTittleBussiness10.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        lblTittleBussiness10.setForeground(new java.awt.Color(255, 255, 255));
        lblTittleBussiness10.setText("Total a pagar:");

        txtTransporte.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtTransporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTransporteKeyPressed(evt);
            }
        });

        pnlBottom1.setBackground(new java.awt.Color(255, 255, 255));
        pnlBottom1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlBottom1.setToolTipText("");

        lblAtajo2.setBackground(new java.awt.Color(51, 153, 255));
        lblAtajo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAtajo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtajo2.setText("<html>Eliminar Producto <br> &nbsp&nbsp&nbsp&nbsp&nbsp\n  ALT + 3</br>  </html>");
        lblAtajo2.setToolTipText("mnemonic");
        lblAtajo2.setFocusable(false);
        lblAtajo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblAtajo3.setBackground(new java.awt.Color(153, 153, 153));
        lblAtajo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAtajo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtajo3.setText("<html>Generar Venta\n<br>&nbsp&nbsp&nbsp ALT + 1</br>\n</html>");
        lblAtajo3.setToolTipText("mnemonic");
        lblAtajo3.setFocusable(false);
        lblAtajo3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblAtajo6.setBackground(new java.awt.Color(51, 153, 255));
        lblAtajo6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAtajo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAtajo6.setText("<html>Cancelar Venta <br> &nbsp&nbsp&nbsp&nbsp&nbsp\n  ALT + 2</br>  </html>");
        lblAtajo6.setToolTipText("mnemonic");
        lblAtajo6.setFocusable(false);
        lblAtajo6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlBottom1Layout = new javax.swing.GroupLayout(pnlBottom1);
        pnlBottom1.setLayout(pnlBottom1Layout);
        pnlBottom1Layout.setHorizontalGroup(
            pnlBottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottom1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblAtajo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblAtajo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblAtajo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBottom1Layout.setVerticalGroup(
            pnlBottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblAtajo2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblAtajo3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblAtajo6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnGenerarVenta.setBackground(new java.awt.Color(51, 153, 0));
        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/venta.png"))); // NOI18N
        btnGenerarVenta.setMnemonic('1');
        btnGenerarVenta.setText("Generar venta");
        btnGenerarVenta.setColorBorde(null);
        btnGenerarVenta.setColorHover(new java.awt.Color(51, 153, 0));
        btnGenerarVenta.setColorNormal(new java.awt.Color(51, 153, 0));
        btnGenerarVenta.setColorPressed(new java.awt.Color(0, 204, 153));
        btnGenerarVenta.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnGenerarVenta.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnGenerarVenta.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnGenerarVenta.setFocusPainted(false);
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelarVenta.png"))); // NOI18N
        btnCancelar.setMnemonic('2');
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorBorde(null);
        btnCancelar.setColorHover(new java.awt.Color(255, 51, 51));
        btnCancelar.setColorNormal(new java.awt.Color(255, 51, 51));
        btnCancelar.setColorPressed(new java.awt.Color(255, 102, 102));
        btnCancelar.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnCancelar.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnCancelar.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBottomLayout = new javax.swing.GroupLayout(pnlBottom);
        pnlBottom.setLayout(pnlBottomLayout);
        pnlBottomLayout.setHorizontalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomLayout.createSequentialGroup()
                        .addComponent(lblTittleBussiness10, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomLayout.createSequentialGroup()
                        .addComponent(lblTittleBussiness9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTransporte)))
                .addGap(21, 21, 21))
            .addComponent(pnlBottom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBottomLayout.setVerticalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBottomLayout.createSequentialGroup()
                        .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTittleBussiness9)
                            .addComponent(txtTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTittleBussiness10)
                            .addComponent(lblTotalPagar)))
                    .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBottom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addComponent(pnlDatosVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlNumFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlBottom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDescripProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addComponent(pnlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlDatosVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(pnlDescripProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlBody, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnExit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopLayout.createSequentialGroup()
                        .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMaximize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(new Color(232,17,35));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        
       if(maximized == false){
            maximized = true;
            new DashboardPrincipal().setVisible(maximized);
            this.dispose();
            
        }else{                        
            new DashboardPrincipal().setVisible(maximized);
            this.dispose();
        }
               
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnMaximizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizeMouseEntered
        btnMaximize.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_btnMaximizeMouseEntered

    private void btnMaximizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizeMouseExited
        btnMaximize.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnMaximizeMouseExited

    private void btnMaximizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaximizeActionPerformed
        if(maximized){
            //handle fullscreen - taskbar
            pnlVentas.this.setExtendedState(JFrame.MAXIMIZED_BOTH);         
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            pnlVentas.this.setMaximizedBounds(env.getMaximumWindowBounds());
            maximized = false;
        }else{
            setExtendedState(JFrame.NORMAL);
            maximized = true;
        }
    }//GEN-LAST:event_btnMaximizeActionPerformed

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        btnMinimize.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseExited
        btnMinimize.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnMinimizeMouseExited

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void pnlTopMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseDragged
        if(maximized){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
        }
    }//GEN-LAST:event_pnlTopMouseDragged

    private void pnlTopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlTopMousePressed

    private void tableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductosMouseClicked
        //fila = tableClientes.getSelectedRow();
    }//GEN-LAST:event_tableProductosMouseClicked

    
    String toSeek = null;
    String cadena = null;
    int codCadena = 0;
    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed

        int code = evt.getKeyCode();
                  
        if(code == KeyEvent.VK_ENTER) 
        {
          
            if(!"".equals(txtProducto.getText()))
            {
                codCadena = parseInt(txtProducto.getText());
               
                if(isUberClient == true )
                {
                   for (int i = 0; i < productos.size(); i++) 
                   {
                       if (productos.get(i).getCodigo() == codCadena) 
                       {
                           String cod = String.valueOf(productos.get(i).getCodigo());

                           txtDescripcion.setText(productos.get(i).getDescripcion());
                           txtPrecio.setText(String.valueOf(productos.get(i).getPrecioUberEats()));
                           //txtCantidad.requestFocus();
                           productoSeleccionado = new Producto(productos.get(i).getCodigo(), productos.get(i).getDescripcion(), productos.get(i).getPrecioUberEats());
                           txtCantidad.requestFocus();

                           System.out.println("precio normal: "+productos.get(i).getPrecio() +"  precio uber: "+productos.get(i).getPrecioUberEats());
                            jcomboProductos.setSelectedIndex(i+1);

                       }
                   } 
                   
                }else
                {
                   for (int i = 0; i < productos.size(); i++) 
                   {
                       if (productos.get(i).getCodigo() == codCadena) 
                       {
                           String cod = String.valueOf(productos.get(i).getCodigo());

                           txtDescripcion.setText(productos.get(i).getDescripcion());
                           txtPrecio.setText(String.valueOf(productos.get(i).getPrecio()));
                           //txtCantidad.requestFocus();
                           productoSeleccionado = new Producto(productos.get(i).getCodigo(), productos.get(i).getDescripcion(), productos.get(i).getPrecio());
                           txtCantidad.requestFocus();

                            jcomboProductos.setSelectedIndex(i+1);

                       }
                   }                     
                }
                
                
//                for (int i = 0; i < productos.size(); i++) 
//                {
//                    if (productos.get(i).getCodigo() == codCadena) 
//                    {
//                        String cod = String.valueOf(productos.get(i).getCodigo());
//
//                        txtDescripcion.setText(productos.get(i).getDescripcion());
//                        txtPrecio.setText(String.valueOf(productos.get(i).getPrecio()));
//                        //txtCantidad.requestFocus();
//                        productoSeleccionado = new Producto(productos.get(i).getCodigo(), productos.get(i).getDescripcion(), productos.get(i).getPrecio());
//                        txtCantidad.requestFocus();
//                        
//                         jcomboProductos.setSelectedIndex(i+1);
//
//                    }
//                } 
                
            } 
        }else if(code == KeyEvent.VK_RIGHT)       
            jcomboProductos.transferFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_UP)
            txtNombre_cliente.requestFocus();
  
    }//GEN-LAST:event_txtProductoKeyPressed

    
    
    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
           
        ArrayList lista = new ArrayList();
        
        if (!"".equals(txtCantidad.getText()) && (!"".equals(txtDescripcion.getText()) && !"".equals(txtPrecio.getText())))
        {
            int codVenta = codCadena;
            String descripVenta = txtDescripcion.getText();
            double precio = parseDouble(txtPrecio.getText());
            int cantidadVenta = parseInt(txtCantidad.getText());
            double total = cantidadVenta * precio;

            tableProductos.setVisible(false);
            tableProductos.setModel(modelo);
            DefaultTableModel modelo = (DefaultTableModel) tableProductos.getModel();

            for (int i = 0; i < tableProductos.getRowCount(); i++) {
                if (tableProductos.getValueAt(i, 2).equals(descripVenta)) {
                    //JOptionPane.showMessageDialog(null, "El producto ya esta registrado");
                    //modelo.setValueAt(cantidadVenta, i, 1);
                    //return;
                }
            }

            // ArrayList lista = new ArrayList();
            lista.add(codVenta);
            lista.add(cantidadVenta);
            lista.add(descripVenta);
            lista.add(precio);
            lista.add(total);

//                tableProductos.setVisible(false);
//                tableProductos.setModel(modelo);
            //modelo.fireTableDataChanged();
            Object[] row = new Object[modelo.getColumnCount()];

            //DefaultTableModel modelo = (DefaultTableModel) tableProductos.getModel();
            Object[] O = new Object[modelo.getColumnCount()];
            O[0] = lista.get(0);
            O[1] = lista.get(1);
            O[2] = lista.get(2);
            O[3] = lista.get(3);
            O[4] = lista.get(4);

            modelo.addRow(O);
            totalPagar();
            limpiarVenta();
            txtProducto.requestFocus();
            tableProductos.setModel(modelo);
            tableProductos.setVisible(true);
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        
        int code = evt.getKeyCode();
       ArrayList lista = new ArrayList();
       
        if(code == KeyEvent.VK_ENTER) 
        {
            if (!"".equals(txtCantidad.getText()))
            {
                int codVenta = codCadena;
                String descripVenta = txtDescripcion.getText();
                double precio = parseDouble(txtPrecio.getText());
                int cantidadVenta = parseInt(txtCantidad.getText());
                double total = cantidadVenta * precio;
                
                
                tableProductos.setVisible(false);
                tableProductos.setModel(modelo);
                DefaultTableModel modelo = (DefaultTableModel) tableProductos.getModel();
                    
                    for (int i = 0; i < tableProductos.getRowCount(); i++) {
                        if (tableProductos.getValueAt(i, 2).equals(descripVenta)) 
                        {
                            //JOptionPane.showMessageDialog(null, "El producto ya esta registrado");
                            //modelo.setValueAt(cantidadVenta, i, 1);
                            //return;
                        }
                    }
                
               // ArrayList lista = new ArrayList();
                lista.add(codVenta);
                lista.add(cantidadVenta);
                lista.add(descripVenta);
                lista.add(precio);
                lista.add(total);
                
                
//                tableProductos.setVisible(false);
//                tableProductos.setModel(modelo);
                //modelo.fireTableDataChanged();

                Object[] row = new Object[modelo.getColumnCount()];

                //DefaultTableModel modelo = (DefaultTableModel) tableProductos.getModel();
                Object[] O = new Object[modelo.getColumnCount()];
                O[0] = lista.get(0);
                O[1] = lista.get(1);
                O[2] = lista.get(2);
                O[3] = lista.get(3);
                O[4] = lista.get(4);
               
                modelo.addRow(O);
                totalPagar();
                limpiarVenta();
                txtProducto.requestFocus();
                tableProductos.setModel(modelo);
                tableProductos.setVisible(true);
        }
            
        }
        
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    
    String cliente_toReport; 
    String direccion_toReport; 
    String telefono_toReport; 
    double subtotal_toReport;
    double transporte_toReport;
    double totalPagar_toReport;

    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        if(tableProductos.getSelectedRow() >= 0)
        {
            modelo = (DefaultTableModel) tableProductos.getModel();
            modelo.removeRow(tableProductos.getSelectedRow());
            totalPagar();
            txtProducto.requestFocus();           
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtTelefono_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono_clienteKeyPressed
      
        existeCliente = false;
        correoCliente = "";
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            if (!"".equals(txtTelefono_cliente.getText()))
            {              
               telefono_toReport = txtTelefono_cliente.getText();
               String tel = txtTelefono_cliente.getText();
                
               for (int i = 0; i < clientes.size(); i++) 
               {

                    if (clientes.get(i).getTelefono().equals(tel)) 
                    {
                        if(clientes.get(i).getTelefono().equals("300"))
                        {
                            isUberClient = true;
                            System.out.println("cliente uber");
                        }
                            
                            
                        codCliente = String.valueOf(clientes.get(i).getCodigo());

                        txtNombre_cliente.setText(clientes.get(i).getNombre());
                        txtDireccion_cliente.setText(clientes.get(i).getDireccion());
                       
                        /********************************************/                       
                       
                        correoCliente = clientes.get(i).getEmail();
                        
                        if("".equals(correoCliente))
                        {
                            System.out.println("no hay correo");
                            txtCorreoCliente.setText("");
                            txtCorreoCliente.setBackground(Color.WHITE);
                            txtCorreoCliente.setEditable(true);
                            //txtProducto.requestFocus();
                            
                        }else if(!"".equals(correoCliente))
                        {
                            correoCliente = clientes.get(i).getEmail();
                            txtCorreoCliente.setText(correoCliente);
                            txtCorreoCliente.setBackground(Color.CYAN); 
                            txtCorreoCliente.setEditable(false);
                            txtProducto.transferFocus();
                        }
                        
                       
                        /************************************************/
                        
                        txtProducto.requestFocus();
                        
                        existeCliente = true;
                        
                        cliente_toReport = clientes.get(i).getNombre();
                        direccion_toReport = clientes.get(i).getDireccion();
                        break;
                    }else
                    {
//                        txtDireccion_cliente.setText("");
//                        txtNombre_cliente.setText("");
                        txtDireccion_cliente.requestFocus();
                    }
                }   
            }
            //txtProducto.requestFocus();
        }if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            txtDireccion_cliente.requestFocus();
    }//GEN-LAST:event_txtTelefono_clienteKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_F1) 
        {
            txtNombre_cliente.setText("presioné la tecla F1");
        }
    }//GEN-LAST:event_formKeyPressed

    private void pnlMenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlMenuKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_F1) 
        {
            txtNombre_cliente.setText("presioné la tecla F1");
        }
    }//GEN-LAST:event_pnlMenuKeyPressed

    private void txtTransporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTransporteKeyPressed
        int code = evt.getKeyCode();
       
        if(code == KeyEvent.VK_ENTER) 
        {
            if(!"".equals(txtTransporte.getText()))   
            {
                
               transporte = Double.parseDouble(txtTransporte.getText()); 
               agregarTransporte(transporte);
               txtProducto.requestFocus();
               txtTransporte.setText("");  
            }
        }
    }//GEN-LAST:event_txtTransporteKeyPressed

    private TableRowSorter trsFiltro;
    private void jcomboProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcomboProductosKeyPressed
        int code = evt.getKeyCode();
           
        if(code == KeyEvent.VK_LEFT) 
        {
            txtProducto.transferFocus();
            System.out.println("flkecha izquierda");
        }
             
    }//GEN-LAST:event_jcomboProductosKeyPressed
   
    private void jcomboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboProductosActionPerformed
       String code = evt.getActionCommand();
       
        if(code.equalsIgnoreCase("comboBoxEdited")) 
        {
            
            if(isUberClient == true ) 
            {
                String pro = jcomboProductos.getSelectedItem().toString();

                for (int i = 0; i < productos.size(); i++) 
                {
                    if (productos.get(i).getDescripcion().matches(pro)) {
                        codCadena = productos.get(i).getCodigo();

                        txtDescripcion.setText(productos.get(i).getDescripcion());
                        txtPrecio.setText(String.valueOf(productos.get(i).getPrecioUberEats()));
                        //txtCantidad.requestFocus();
                        productoSeleccionado = new Producto(productos.get(i).getCodigo(), productos.get(i).getDescripcion(), productos.get(i).getPrecioUberEats());
                        txtCantidad.requestFocus();

                    }
                }                
            }else
            {
                String pro = jcomboProductos.getSelectedItem().toString();

                for (int i = 0; i < productos.size(); i++) 
                {
                    if (productos.get(i).getDescripcion().matches(pro)) {
                        codCadena = productos.get(i).getCodigo();

                        txtDescripcion.setText(productos.get(i).getDescripcion());
                        txtPrecio.setText(String.valueOf(productos.get(i).getPrecio()));
                        //txtCantidad.requestFocus();
                        productoSeleccionado = new Producto(productos.get(i).getCodigo(), productos.get(i).getDescripcion(), productos.get(i).getPrecio());
                        txtCantidad.requestFocus();

                    }
                }               
            }          
        }
    }//GEN-LAST:event_jcomboProductosActionPerformed

    private void checkGuardarClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkGuardarClienteItemStateChanged
        if(evt.getStateChange() == 1)
            guardarCliente = true;
        else
            guardarCliente = false;
    }//GEN-LAST:event_checkGuardarClienteItemStateChanged

    private void checkEnviarFacturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkEnviarFacturaItemStateChanged
               
        if(evt.getStateChange() == 1)
        {
            enviarFactura = true;
            verificaCheckEmail();
        }
        else
        {
            enviarFactura = false;
            verificaCheckEmail();
        }

    }//GEN-LAST:event_checkEnviarFacturaItemStateChanged

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
       
        if(tableProductos.getRowCount() > 0)
        {
            registrarVenta();
            registrarDetalleVenta();
            
            if(guardarCliente) //si está marcada la casilla para guardar el cliente (que no se encuentra en el sistema)
                guardarCliente();
                       
            try {
                //Ventas_controller.generaReporteVenta(valueOf(Ventas_controller.getNumeroFactura()-1), lblVendedor.getText(), cliente_toReport, telefono_toReport, direccion_toReport);
                ventaControl.generaReporteVenta(valueOf(Ventas_controller.getNumeroFactura()-1), lblVendedor.getText(), cliente_toReport, telefono_toReport, direccion_toReport);
                
            } catch (FileNotFoundException ex) 
            {  System.out.println(ex.getMessage());}
            
            if(enviarFactura)
                enviarCopiaFactura();
            
            transporte = 0.0;           
            checkGuardarCliente.setSelected(false);
            checkEnviarFactura.setSelected(false);
            isUberClient = false;
            limpiarTabla(); 
        }
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelarVenta();
        txtTelefono_cliente.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCorreoClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoClienteKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txtProducto.requestFocus();
    }//GEN-LAST:event_txtCorreoClienteKeyPressed

    private void txtDireccion_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccion_clienteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            txtNombre_cliente.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_UP)
            txtTelefono_cliente.requestFocus();
    }//GEN-LAST:event_txtDireccion_clienteKeyPressed

    private void txtNombre_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_clienteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            txtProducto.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_UP)
            txtDireccion_cliente.requestFocus();
    }//GEN-LAST:event_txtNombre_clienteKeyPressed

    
    private void verificaCheckEmail()
    {
        if(enviarFactura)
        {
            lblCorreoCliente.setVisible(true);
            txtCorreoCliente.setVisible(true);  
            txtCorreoCliente.requestFocus();
        }else
        {
            lblCorreoCliente.setVisible(false);
            txtCorreoCliente.setVisible(false);            
        }
    }
    
    
    private void guardarCliente()
    {
         if(txtTelefono_cliente.getText().isEmpty())
        {    }
        else if(txtDireccion_cliente.getText().isEmpty())
        {    }
        else if(txtNombre_cliente.getText().isEmpty())               
        {    }
        else
        {
            if(!existeCliente)
            {
                
                                              
                Cliente cliente = new Cliente(txtNombre_cliente.getText(), txtTelefono_cliente.getText(), txtDireccion_cliente.getText(), txtCorreoCliente.getText());

               if(Cliente_controller.guardarCliente(cliente))
                {                
                   Cliente_controller.Notificaciones("clientSaved");
                   txtProducto.requestFocus();
                }
               
            }
        }
    }
    
    
    private void enviarCopiaFactura()
    {
        if(enviarFactura)
        {
            if(existeCliente)
            {
                if("".equals(correoCliente))
                {
                    correoCliente = txtCorreoCliente.getText();                                        
                    System.out.println(" se envió la factura al correo: "+correoCliente+"  este correo no se encuentra almacenado junto al cliente"); 
                    
                    if(Email_controller.ValidarMail(correoCliente) == false)
                        Email_controller.Notificaciones("mailErrorSent");                                              
                    else
                        Email_controller.enviarMailConAdjunto(correoCliente, valueOf(Ventas_controller.getNumeroFactura()-1)); 
                    
                }else
                {
                    System.out.println(" se envió la factura al correo: "+correoCliente +"  este correo se encontraba almacenado junto al cliente");
                    Email_controller.enviarMailConAdjunto(correoCliente, valueOf(Ventas_controller.getNumeroFactura()-1));
                }

            }else
            {
                correoCliente = txtCorreoCliente.getText();
                System.out.println("se envió la factura al correo: "+correoCliente +"     el cliente no estaba guardado");
            }
        }
        
        /*                if(!Email_controller.ValidarMail(correo))
                    Email_controller.Notificaciones("mailIncorrect");*/
    }
    
/*    String cliente_toReport; 
    String direccion_toReport; 
    String telefono_toReport; 
    double subtotal_toReport;
    double transporte_toReport;
    double totalPagar_toReport;*/
    
    public void registrarVenta()
    {
        telefono_toReport = txtTelefono_cliente.getText();
        cliente_toReport = txtNombre_cliente.getText();
        direccion_toReport = txtDireccion_cliente.getText();
        
        int codigoVendedor = frameLogin.usuarioLogueado.getCodigo();
        double total = totalPagar;
        
        subtotal_toReport = totalPagar - transporte;
        totalPagar_toReport = totalPagar;
        transporte_toReport = transporte;
        
        //venta.setCodigoCliente(parseInt(codCliente));
        venta.setCodigoUsuario(codigoVendedor);
        venta.setTotal(total);
        venta.setTransporte(transporte);
        
        ventaControl.RegistrarVenta(venta ,txtNombre_cliente.getText().toString(), frameLogin.usuarioLogueado.getNombre(), txtDireccion_cliente.getText(), txtTelefono_cliente.getText());
    }
    
    public void registrarDetalleVenta()
    {
        Ventas_controller.listaDetalle.clear();
        for (int i = 0; i < tableProductos.getRowCount(); i++) 
        {
            int cod = parseInt(tableProductos.getValueAt(i, 0).toString());
            int cantiP = parseInt(tableProductos.getValueAt(i, 1).toString());
            
            String produ = tableProductos.getValueAt(i, 2).toString();
            double preci = parseDouble(tableProductos.getValueAt(i, 3).toString());
            double totl = cantiP * preci;
                      
            detalleV.setCantidad(cantiP);
            detalleV.setCodigoProducto(cod);
            //detalleV.setCodigo_Venta(6);
            
//            detalle_toReporte.setCodigo(cod); 
//            detalle_toReporte.setDescripcion(produ);
//            detalle_toReporte.setPrecio(preci);
//            detalle_toReporte.setCantidad(cantiP);
//            detalle_toReporte.setTotal(totl);
           
           detalle_toReporte = new Tiquete_venta(cod, produ, preci, cantiP, totl, subtotal_toReport, transporte_toReport, totalPagar_toReport);
           
           Ventas_controller.listaDetalle.add(detalle_toReporte); 
           ventaControl.RegistrarDetalle_venta(detalleV, produ, preci);
           
        }
    }
    
    
    Producto product = new Producto();
    
    public void cancelarVenta()
    {
        limpiarVenta();
        limpiarTabla();
        lblTotalPagar.setText("0.00");
        enviarFactura = false;
        verificaCheckEmail();
        checkEnviarFactura.setSelected(false);
        isUberClient = false;
    }

    public void fecha()
    {
        Calendar calendario = new GregorianCalendar();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = 1 +  calendario.get(Calendar.MONTH);
        int anio = calendario.get(Calendar.YEAR);
        
        lblFecha.setText(dia +"/"+ mes +"/"+ anio);
        
        
    }
    
   
    private void totalPagar() 
    {
        totalPagar = 0.00;
        int numFila = tableProductos.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(tableProductos.getModel().getValueAt(i, 4)));
            totalPagar += cal;
        }
        lblTotalPagar.setText(String.format("%.2f", totalPagar));
    }
    
    private void agregarTransporte(double transporte)
    {
        totalPagar += transporte;     
        lblTotalPagar.setText(String.format("%.2f", totalPagar));
    }
   
    
    private void limpiarVenta() 
    {
        txtProducto.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }
    
    private void limpiarTabla()
    {
        modelo = (DefaultTableModel) tableProductos.getModel();
        
        int fila = tableProductos.getRowCount();
        
        for (int i = 0; i < fila; i++) 
        {
            modelo.removeRow(0);
        }
        
        limpiarVenta(); 
        txtTransporte.setText("");
        lblTotalPagar.setText("");
        txtNombre_cliente.setText("");
        txtTelefono_cliente.setText("");
        txtDireccion_cliente.setText("");
        txtCorreoCliente.setText("");
        txtTelefono_cliente.requestFocus();
        lblTotalPagar.setText("0.00");
        lblNumFactura.setText(valueOf(Ventas_controller.getNumeroFactura()));
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
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       // try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(pnlVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(pnlVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(pnlVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(pnlVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //}
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pnlVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane ScrollPaneTableProductos;
    private javax.swing.JButton btnAgregarProducto;
    private lib.RSButtonMetro btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExit;
    private lib.RSButtonMetro btnGenerarVenta;
    private javax.swing.JButton btnMaximize;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JCheckBox checkEnviarFactura;
    private javax.swing.JCheckBox checkGuardarCliente;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> jcomboProductos;
    private javax.swing.JLabel lblAtajo2;
    private javax.swing.JLabel lblAtajo3;
    private javax.swing.JLabel lblAtajo6;
    private javax.swing.JLabel lblCorreoCliente;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNumFactura;
    private javax.swing.JLabel lblTittleBussiness;
    private javax.swing.JLabel lblTittleBussiness1;
    private javax.swing.JLabel lblTittleBussiness10;
    private javax.swing.JLabel lblTittleBussiness3;
    private javax.swing.JLabel lblTittleBussiness4;
    private javax.swing.JLabel lblTittleBussiness5;
    private javax.swing.JLabel lblTittleBussiness6;
    private javax.swing.JLabel lblTittleBussiness9;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlBottom1;
    private javax.swing.JPanel pnlDatosVendedor;
    private javax.swing.JPanel pnlDescripProductos;
    private javax.swing.JPanel pnlFecha;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlNumFactura;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tableOculta;
    public javax.swing.JTable tableProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDireccion_cliente;
    private javax.swing.JTextField txtNombre_cliente;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtTelefono_cliente;
    private javax.swing.JTextField txtTransporte;
    // End of variables declaration//GEN-END:variables
}
