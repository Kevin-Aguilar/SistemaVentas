
package View;

import Controller.Cliente_controller;
import Controller.Email_controller;
import Model.Cliente;
import Model.Producto;
import com.lowagie.text.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Kevin
 */
public class pnlClientes extends javax.swing.JPanel {

    public static DefaultTableModel modelo = new DefaultTableModel();
    public static List<Cliente> clientes;
    List<Cliente> coincidencias;
    int fila;
    boolean editarCliente = false;
    int codigoCliente;
      private TableRowSorter trsFiltro;
    
    public pnlClientes() {
        initComponents();
        tableClientesModel();
        obtenerClientes();
        mostrarClientesInTable();
        
        
        soloLetras(txtNombre_Cliente);
        soloNumeros(txtTelefono_Cliente);
        txtNombre_Cliente.requestFocus();
        
        Label_NombreCliente3.setVisible(editarCliente);
        txtCorreo_cliente.setVisible(false);
    }


    public void tableClientesModel() 
    {   
        modelo = new DefaultTableModel();
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("TELÉFONO");
        modelo.addColumn("DIRECCIÓN");
        //modelo.addColumn("CORREO");
        
        tableClientes.setModel(modelo);

        tableClientes.getColumn("CÓDIGO").setMaxWidth(60);    /*tableClientes.getColumn("CÓDIGO").setMinWidth(60);*/ tableClientes.getColumn("CÓDIGO").setPreferredWidth(60);
        tableClientes.getColumn("NOMBRE").setMaxWidth(200);    /*tableClientes.getColumn("NOMBRE").setMinWidth(160);*/ tableClientes.getColumn("NOMBRE").setPreferredWidth(200);        
        tableClientes.getColumn("DIRECCIÓN").setMaxWidth(255);    /*tableClientes.getColumn("DIRECCIÓN").setMinWidth(197);*/ tableClientes.getColumn("DIRECCIÓN").setPreferredWidth(255);
        tableClientes.getColumn("TELÉFONO").setMaxWidth(100);    /*tableClientes.getColumn("TELÉFONO").setMinWidth(100);*/ tableClientes.getColumn("TELÉFONO").setPreferredWidth(100);
        //tableClientes.getColumn("CORREO").setMaxWidth(150);    /*tableClientes.getColumn("CORREO").setMinWidth(150);*/ tableClientes.getColumn("CORREO").setPreferredWidth(150);
        
        
        JTableHeader th  = tableClientes.getTableHeader();
        th.setFont(tableClientes.getFont().deriveFont(Font.BOLD)); 
        
        ScrollPaneTableClientes.setViewportView(tableClientes);  
    }
    
    public static void obtenerClientes() 
    {
        try
        {
            clientes= Cliente_controller.listarCliente();

        } catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        } 
    }
    
    
    public void mostrarClientesInTable()
    {
        tableClientes.setVisible(false);
        tableClientes.setModel(modelo);
        modelo.fireTableDataChanged();
        
        Object[] row = new Object[modelo.getColumnCount()];
        
        DefaultTableModel modelo = (DefaultTableModel) tableClientes.getModel();
        
        while(modelo.getRowCount()>0)
            modelo.removeRow(0);
            

        for(int i=0; i<clientes.size(); i++)
        {
            row[0] = clientes.get(i).getCodigo();
            row[1] = clientes.get(i).getNombre();
            row[2] = clientes.get(i).getTelefono();
            row[3] = clientes.get(i).getDireccion();
           // row[3] = clientes.get(i).getEmail();

            modelo.addRow(row);
        }  
        tableClientes.setVisible(true);
        
        if(tableClientes.getRowCount() <= 0)
        {
            btnEditar_Cliente.setEnabled(false);   btnEliminar_Cliente.setEnabled(false);
        }  
//        else
//        {  
//            btnEditar_Producto.setEnabled(true);  btnEliminar_Producto.setEnabled(true); 
//        }        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelClientes = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        txtNombre_Cliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Label_NombreCliente = new javax.swing.JLabel();
        txtDireccion_Cliente = new javax.swing.JTextField();
        Label_NombreCliente1 = new javax.swing.JLabel();
        txtTelefono_Cliente = new javax.swing.JTextField();
        Label_NombreCliente2 = new javax.swing.JLabel();
        btnGuardar_Cliente = new javax.swing.JButton();
        btnCancelar_Cliente = new javax.swing.JButton();
        txtCorreo_cliente = new javax.swing.JTextField();
        Label_NombreCliente3 = new javax.swing.JLabel();
        PanelBuscar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PanelListado = new javax.swing.JPanel();
        PanelTableClientes = new javax.swing.JPanel();
        ScrollPaneTableClientes = new javax.swing.JScrollPane();
        tableClientes = tableClientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel6 = new javax.swing.JLabel();
        txtBuscar_Cliente = new javax.swing.JTextField();
        btnEditar_Cliente = new javax.swing.JButton();
        btnEliminar_Cliente = new javax.swing.JButton();
        btnEnviarMail = new lib.RSButtonMetro();

        setPreferredSize(new java.awt.Dimension(945, 569));

        PanelClientes.setBackground(new java.awt.Color(255, 255, 255));
        PanelClientes.setPreferredSize(new java.awt.Dimension(945, 569));

        PanelDatos.setBackground(new java.awt.Color(255, 255, 255));
        PanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelDatos.setMaximumSize(new java.awt.Dimension(386, 338));

        txtNombre_Cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombre_ClienteKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setText("Ingrese la información del nuevo cliente");
        jLabel3.setToolTipText("");

        Label_NombreCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_NombreCliente.setText("Nombre completo");
        Label_NombreCliente.setToolTipText("");

        txtDireccion_Cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccion_ClienteKeyPressed(evt);
            }
        });

        Label_NombreCliente1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_NombreCliente1.setText("Dirección o zona");
        Label_NombreCliente1.setToolTipText("");

        txtTelefono_Cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefono_ClienteKeyPressed(evt);
            }
        });

        Label_NombreCliente2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_NombreCliente2.setText("Teléfono");
        Label_NombreCliente2.setToolTipText("");

        btnGuardar_Cliente.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar_color.png"))); // NOI18N
        btnGuardar_Cliente.setText("Guardar");
        btnGuardar_Cliente.setBorder(null);
        btnGuardar_Cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar_Cliente.setFocusPainted(false);
        btnGuardar_Cliente.setFocusable(false);
        btnGuardar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar_ClienteActionPerformed(evt);
            }
        });

        btnCancelar_Cliente.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar_color.png"))); // NOI18N
        btnCancelar_Cliente.setText("Cancelar");
        btnCancelar_Cliente.setBorder(null);
        btnCancelar_Cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar_Cliente.setFocusPainted(false);
        btnCancelar_Cliente.setFocusable(false);
        btnCancelar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar_ClienteActionPerformed(evt);
            }
        });

        txtCorreo_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreo_clienteKeyPressed(evt);
            }
        });

        Label_NombreCliente3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_NombreCliente3.setText("Correo electrónico");
        Label_NombreCliente3.setToolTipText("");

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_NombreCliente)
                            .addComponent(txtNombre_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_NombreCliente1)
                            .addComponent(txtDireccion_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_NombreCliente2)
                            .addComponent(txtTelefono_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCorreo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Label_NombreCliente3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addComponent(Label_NombreCliente)
                .addGap(6, 6, 6)
                .addComponent(txtNombre_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Label_NombreCliente1)
                .addGap(6, 6, 6)
                .addComponent(txtDireccion_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Label_NombreCliente2)
                .addGap(6, 6, 6)
                .addComponent(txtTelefono_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Label_NombreCliente3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        PanelBuscar.setBackground(new java.awt.Color(255, 255, 255));
        PanelBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setText("Clientes");

        javax.swing.GroupLayout PanelBuscarLayout = new javax.swing.GroupLayout(PanelBuscar);
        PanelBuscar.setLayout(PanelBuscarLayout);
        PanelBuscarLayout.setHorizontalGroup(
            PanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBuscarLayout.setVerticalGroup(
            PanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        PanelListado.setBackground(new java.awt.Color(255, 255, 255));
        PanelListado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelListado.setPreferredSize(new java.awt.Dimension(500, 77));

        PanelTableClientes.setBackground(new java.awt.Color(255, 255, 255));

        tableClientes.setBackground(new java.awt.Color(204, 255, 255));
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tableClientes.setToolTipText("");
        tableClientes.setRowHeight(25);
        tableClientes.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientesMouseClicked(evt);
            }
        });
        ScrollPaneTableClientes.setViewportView(tableClientes);

        javax.swing.GroupLayout PanelTableClientesLayout = new javax.swing.GroupLayout(PanelTableClientes);
        PanelTableClientes.setLayout(PanelTableClientesLayout);
        PanelTableClientesLayout.setHorizontalGroup(
            PanelTableClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTableClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelTableClientesLayout.setVerticalGroup(
            PanelTableClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTableClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setText("Buscar");

        txtBuscar_Cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscar_ClienteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar_ClienteKeyTyped(evt);
            }
        });

        btnEditar_Cliente.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar_color.png"))); // NOI18N
        btnEditar_Cliente.setText("Editar");
        btnEditar_Cliente.setBorder(null);
        btnEditar_Cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar_Cliente.setFocusPainted(false);
        btnEditar_Cliente.setFocusable(false);
        btnEditar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar_ClienteActionPerformed(evt);
            }
        });

        btnEliminar_Cliente.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar_color.png"))); // NOI18N
        btnEliminar_Cliente.setText("Eliminar");
        btnEliminar_Cliente.setBorder(null);
        btnEliminar_Cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar_Cliente.setFocusPainted(false);
        btnEliminar_Cliente.setFocusable(false);
        btnEliminar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_ClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelListadoLayout = new javax.swing.GroupLayout(PanelListado);
        PanelListado.setLayout(PanelListadoLayout);
        PanelListadoLayout.setHorizontalGroup(
            PanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelListadoLayout.createSequentialGroup()
                        .addComponent(PanelTableClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelListadoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198)
                        .addComponent(btnEditar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        PanelListadoLayout.setVerticalGroup(
            PanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelListadoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PanelTableClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEnviarMail.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEnviarMail.setText("Enviar correo notificación");
        btnEnviarMail.setColorBorde(new javax.swing.border.MatteBorder(null));
        btnEnviarMail.setColorHover(new java.awt.Color(52, 152, 219));
        btnEnviarMail.setColorNormal(new java.awt.Color(0, 153, 204));
        btnEnviarMail.setColorPressed(new java.awt.Color(255, 255, 255));
        btnEnviarMail.setColorTextNormal(new java.awt.Color(0, 0, 0));
        btnEnviarMail.setColorTextPressed(new java.awt.Color(0, 0, 0));
        btnEnviarMail.setFocusPainted(false);
        btnEnviarMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelClientesLayout = new javax.swing.GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnviarMail, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelListado, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelClientesLayout.setVerticalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(PanelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelListado, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnviarMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void guardarCliente() throws SQLException, ClassNotFoundException
    {
        
        if(validaTXT("cliente"))
        {           
            int codigo = codigoCliente;
            String nombre = txtNombre_Cliente.getText();
            String direccion = txtDireccion_Cliente.getText();
            String telefono = txtTelefono_Cliente.getText();
            String correo = txtCorreo_cliente.getText();

            if(!"".equals(correo))    
            {
                if(Email_controller.ValidarMail(correo) == false)
                    Email_controller.Notificaciones("mailIncorrect");
                else
                {
                    Cliente cliente = new Cliente(nombre,telefono, direccion, correo);

                    if(Cliente_controller.guardarCliente(cliente))
                    {                
                        Cliente_controller.Notificaciones("clientSaved");
                    }

                    cleanTXT();
                    txtNombre_Cliente.requestFocus();

                    obtenerClientes(); mostrarClientesInTable();
                }
            }
            else
            {              
                Cliente cliente = new Cliente(nombre,telefono, direccion, correo);

                if(Cliente_controller.guardarCliente(cliente))
                {                
                    Cliente_controller.Notificaciones("clientSaved");
                }

                cleanTXT();
                txtNombre_Cliente.requestFocus();

                obtenerClientes(); mostrarClientesInTable();                 
            }                         
        }        
    }
    

    
    
    
    private void btnGuardar_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_ClienteActionPerformed
        if(!editarCliente)
            try {
                guardarCliente();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(pnlProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        else
        {
            editarCliente(codigoCliente);
            editarCliente = false;
        }   
    }//GEN-LAST:event_btnGuardar_ClienteActionPerformed

    private void tableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientesMouseClicked
        fila = tableClientes.getSelectedRow();
    }//GEN-LAST:event_tableClientesMouseClicked

    private void btnEditar_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_ClienteActionPerformed
       
        
        if( txtNombre_Cliente.hasFocus() || txtTelefono_Cliente.hasFocus() || txtDireccion_Cliente.hasFocus() || txtBuscar_Cliente.hasFocus())
            txtNombre_Cliente.requestFocus();

        else
        {
            if(tableClientes.getSelectedRow() < 0 )//< -1)
            {
                txtNombre_Cliente.requestFocus(); 
                editarCliente = false;
            }    
            else
            {
                codigoCliente = (int) tableClientes.getValueAt(fila, 0);

                editarCliente = true;
                txtNombre_Cliente.setText(String.valueOf(tableClientes.getValueAt(fila, 1))); txtNombre_Cliente.requestFocus();
                txtTelefono_Cliente.setText(String.valueOf(tableClientes.getValueAt(fila, 2)));
                txtDireccion_Cliente.setText(String.valueOf(tableClientes.getValueAt(fila, 3)));
                txtCorreo_cliente.setText(String.valueOf(tableClientes.getValueAt(fila, 4)));
            }
        }
    }//GEN-LAST:event_btnEditar_ClienteActionPerformed

    private void btnEliminar_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_ClienteActionPerformed
        if( txtNombre_Cliente.hasFocus() || txtTelefono_Cliente.hasFocus() || txtDireccion_Cliente.hasFocus() || txtBuscar_Cliente.hasFocus())
            txtNombre_Cliente.requestFocus();

        else
        {
            if (tableClientes.getSelectedRow() < 0) {
                txtNombre_Cliente.requestFocus();
            } else {
                codigoCliente = (int) tableClientes.getValueAt(fila, 0);
                
                eliminarCliente(codigoCliente);
            }
        }
    }//GEN-LAST:event_btnEliminar_ClienteActionPerformed

    private void btnCancelar_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar_ClienteActionPerformed
        cleanTXT();
        txtNombre_Cliente.requestFocus();
    }//GEN-LAST:event_btnCancelar_ClienteActionPerformed

    private void txtBuscar_ClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_ClienteKeyTyped
           txtBuscar_Cliente.addKeyListener(new KeyAdapter() {              
             public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscar_Cliente.getText());
                txtBuscar_Cliente.setText(cadena);
                //repaint();
                
                trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + cadena, 1));
            }
        });
        trsFiltro = new TableRowSorter(tableClientes.getModel());
        tableClientes.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txtBuscar_ClienteKeyTyped

    private void btnEnviarMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarMailActionPerformed
        
            if(tableClientes.getSelectedRow() < 0 )//< -1)
            {
                txtNombre_Cliente.requestFocus(); 
            }    
            else
            {
                if("".equals(String.valueOf(tableClientes.getValueAt(fila, 4))))
                    Email_controller.Notificaciones("mailEmpty");
                else
                    Email_controller.enviarMail(String.valueOf(tableClientes.getValueAt(fila, 4)));
            }          
    }//GEN-LAST:event_btnEnviarMailActionPerformed

    private void txtNombre_ClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_ClienteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txtDireccion_Cliente.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            txtDireccion_Cliente.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_UP)
            txtBuscar_Cliente.requestFocus();
    }//GEN-LAST:event_txtNombre_ClienteKeyPressed

    private void txtDireccion_ClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccion_ClienteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txtTelefono_Cliente.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            txtTelefono_Cliente.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_UP)
            txtNombre_Cliente.requestFocus();
    }//GEN-LAST:event_txtDireccion_ClienteKeyPressed

    private void txtTelefono_ClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono_ClienteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            txtCorreo_cliente.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            txtCorreo_cliente.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_UP)
            txtDireccion_Cliente.requestFocus();
    }//GEN-LAST:event_txtTelefono_ClienteKeyPressed

    private void txtCorreo_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreo_clienteKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_UP)
            txtTelefono_Cliente.requestFocus();
    }//GEN-LAST:event_txtCorreo_clienteKeyPressed

    private void txtBuscar_ClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_ClienteKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_LEFT)
            txtNombre_Cliente.requestFocus();
        else if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            txtNombre_Cliente.requestFocus();
    }//GEN-LAST:event_txtBuscar_ClienteKeyPressed


    public void editarCliente(int codigo)
    {
        
        if(validaTXT("cliente"))
        {           

            String nombre = txtNombre_Cliente.getText();
            String direccion = txtDireccion_Cliente.getText();
            String telefono = txtTelefono_Cliente.getText();
            String correo = txtCorreo_cliente.getText();
                      
            if(!"".equals(correo))    
            {
                if(!Email_controller.ValidarMail(correo))
                    Email_controller.Notificaciones("mailIncorrect");  
                else
                {
                    Cliente cliente = new Cliente(codigo, nombre, telefono, direccion, correo);

                    if(Cliente_controller.editarCliente(cliente))
                    {
                        Cliente_controller.Notificaciones("clientEdit");
                    }

                    cleanTXT();
                    obtenerClientes();  mostrarClientesInTable();  
                }
            }
            else
            {
                Cliente cliente = new Cliente(codigo, nombre, telefono, direccion, correo);

                if(Cliente_controller.editarCliente(cliente))
                {
                    Cliente_controller.Notificaciones("clientEdit");
                }

                cleanTXT();
                obtenerClientes();  mostrarClientesInTable();                 
            }          
        } 
    }
    
    public void eliminarCliente(int codigo)
    {
        Cliente cliente = new Cliente();
        cliente.setCodigo(codigo);
        
         if(Cliente_controller.eliminarCliente(cliente))
         {
             Cliente_controller.Notificaciones("clientDelete");
         }
         
        cleanTXT();
        txtNombre_Cliente.requestFocus();
         
         obtenerClientes(); mostrarClientesInTable();
    }
    
    private boolean validaTXT(String panel)
    {
        boolean estado = false;
        
        if(panel.equalsIgnoreCase("cliente"))
        {

            if(txtTelefono_Cliente.getText().isEmpty())
            {
                //lblPrecio.setVisible(true); txtPrecio_Producto.requestFocus(); return estado;
            }
            else
                estado = true;            
        }
        
        return estado;
    }
    
    public void cleanTXT()
    {
        txtNombre_Cliente.setText("");
        txtDireccion_Cliente.setText("");
        txtTelefono_Cliente.setText("");        
        txtBuscar_Cliente.setText("");
        txtCorreo_cliente.setText("");
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
    
//    private void establecerFocus()
//    {
//        txtNombre_Cliente.requestFocus();
//        
//        //lblCod.setVisible(false); lblDescrip.setVisible(false); lblPrecio.setVisible(false);
//        
//        SoloNumeros(txtCodigo_Producto);
//        SoloNumReales(txtPrecio_Producto);   
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_NombreCliente;
    private javax.swing.JLabel Label_NombreCliente1;
    private javax.swing.JLabel Label_NombreCliente2;
    private javax.swing.JLabel Label_NombreCliente3;
    private javax.swing.JPanel PanelBuscar;
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelListado;
    private javax.swing.JPanel PanelTableClientes;
    public javax.swing.JScrollPane ScrollPaneTableClientes;
    private javax.swing.JButton btnCancelar_Cliente;
    private javax.swing.JButton btnEditar_Cliente;
    private javax.swing.JButton btnEliminar_Cliente;
    private lib.RSButtonMetro btnEnviarMail;
    private javax.swing.JButton btnGuardar_Cliente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JTable tableClientes;
    private javax.swing.JTextField txtBuscar_Cliente;
    private javax.swing.JTextField txtCorreo_cliente;
    private javax.swing.JTextField txtDireccion_Cliente;
    private javax.swing.JTextField txtNombre_Cliente;
    private javax.swing.JTextField txtTelefono_Cliente;
    // End of variables declaration//GEN-END:variables
}
