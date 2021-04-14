/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Usuario_controller;
import Model.Usuario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Kevin
 */
public class pnlUsuarios extends javax.swing.JPanel {

    public static DefaultTableModel modelo = new DefaultTableModel();
    List<Usuario> usuarios;
    //List<Cliente> coincidencias;
    int fila;
    boolean editarUsuario = false;
    int codigoUsuario;
    
    
    public pnlUsuarios() {
        initComponents();
        
        tableUsuariosModel();
        obtenerUsuarios();
        mostrarUsuariosInTable();     
        
        soloNumeros(txtTelefono_Usuario);
        soloLetras(txtNombre_Usuario);
        txtNombre_Usuario.requestFocus();
    }

    
    public void tableUsuariosModel() 
    {   
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Usuario");
        modelo.addColumn("Tipo usuario");
        modelo.addColumn("c");
        
        tableUsuarios.setModel(modelo);
        
        TableColumn colCod = tableUsuarios.getColumn("Código");       colCod.setPreferredWidth(1);  
        TableColumn colName = tableUsuarios.getColumn("Nombre");       colName.setPreferredWidth(100);
        TableColumn colTel = tableUsuarios.getColumn("Teléfono");        colTel.setPreferredWidth(50);
        TableColumn colUser = tableUsuarios.getColumn("Usuario");       colUser.setPreferredWidth(100);
        TableColumn colTipoUser = tableUsuarios.getColumn("Tipo usuario");       colTipoUser.setPreferredWidth(100);
                
        tableUsuarios.getColumn("c").setMaxWidth(0);    tableUsuarios.getColumn("c").setMinWidth(0); tableUsuarios.getColumn("c").setPreferredWidth(0);
                 
        jScrollPane_TableUsuarios.setViewportView(tableUsuarios);  
    }
    
    public void obtenerUsuarios() 
    {
        try
        {
            usuarios = Usuario_controller.listarUsuario();

        } catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        } 
    }
    
    
    public void mostrarUsuariosInTable()
    {
        tableUsuarios.setVisible(false);
        tableUsuarios.setModel(modelo);
        modelo.fireTableDataChanged();
        
        Object[] row = new Object[modelo.getColumnCount()];
        
        DefaultTableModel modelo = (DefaultTableModel) tableUsuarios.getModel();
        
        while(modelo.getRowCount()>0)
            modelo.removeRow(0);
            

        for(int i=0; i<usuarios.size(); i++)
        {
            row[0] = usuarios.get(i).getCodigo();
            row[1] = usuarios.get(i).getNombre();
            row[2] = usuarios.get(i).getTelefono();
            row[3] = usuarios.get(i).getUsuario();
            row[4] = usuarios.get(i).getTipoUsuario();
            row[5] = usuarios.get(i).getContrasenia();

            modelo.addRow(row);
        }  
        tableUsuarios.setVisible(true);
               
    }
    
    public void guardarUsuario() throws SQLException, ClassNotFoundException
    {
       // lblCod.setVisible(false); lblDescrip.setVisible(false); lblPrecio.setVisible(false);
        
        if(validaTXT("usuario"))
        {           
            //int codigo = parseInt(txtCodigo_Usuario.getText());
            String nombre = txtNombre_Usuario.getText();
            String telefono = txtTelefono_Usuario.getText();
            String user = txtUsuario.getText();
           // char[] contrasenia = txtPassword_Usuario.getPassword();
            String contra = txtPassword_Usuario.getText();
            //char[] confirmContrasenia = txtPassword_Usuario2.getPassword();
            String contraConfirm = txtPassword_Usuario2.getText();
            String tipo = (String) jCombo_tipoUsuario.getSelectedItem();

            //Usuario usuario = new Usuario(codigo, nombre, telefono, user, contrasenia, tipo);
            Usuario usuario = new Usuario(nombre, telefono, user, contra, tipo);

            
            if(contra.equals(contraConfirm))//isPasswordCorrect(txtPassword_Usuario.getPassword(), txtPassword_Usuario2.getPassword()))
            {
                if(Usuario_controller.guardarUsuario(usuario))
                {                
                    Usuario_controller.Notificaciones("userSaved");;
                }
            }else
            {
                Usuario_controller.Notificaciones("passwordIncorret");
            }
                                           

            cleanTXT();
            txtNombre_Usuario.requestFocus();

            obtenerUsuarios(); mostrarUsuariosInTable();   
            fila = -1;
        }        
    }

    
//    private boolean isPasswordCorrect(char[] j1,char[] j2) 
//    {
//        boolean valor = true;
//        int puntero = 0;
//        if (j1.length != j2.length)
//        {
//            valor = false;
//        }
//        else
//        {
//            while((valor)&&(puntero < j1.length))
//            {               
//                if (j1[puntero] != j2[puntero])
//                {
//                    valor = false;
//                }
//                puntero++;
//            }
//        }
//        return valor;
//      }
    
    

    public void editarUsuario(int codigo)
    {
        //lblCod.setVisible(false); lblDescrip.setVisible(false); lblPrecio.setVisible(false);
        
        if(validaTXT("usuario"))
        {           

            String nombre = txtNombre_Usuario.getText();
            String telefono = txtTelefono_Usuario.getText();
            String user = txtUsuario.getText();
            String contrasenia = txtPassword_Usuario.getText();
            String tipo = (String) jCombo_tipoUsuario.getSelectedItem();
            String contraConfirm = txtPassword_Usuario2.getText();
            
            Usuario usuario =  new Usuario(codigo, nombre, telefono, user, contrasenia, tipo);
            
            
            if(contrasenia.equals(contraConfirm))//isPasswordCorrect(txtPassword_Usuario.getPassword(), txtPassword_Usuario2.getPassword()))
            {
                if(Usuario_controller.editarUsuario(usuario))
                {
                    Usuario_controller.Notificaciones("userEdit");
                }
            }else
            {
                Usuario_controller.Notificaciones("passwordIncorret");
                txtPassword_Usuario.setText("");
                txtPassword_Usuario2.setText("");
                txtPassword_Usuario.requestFocus();
            }
            
            cleanTXT();
            txtNombre_Usuario.requestFocus();
            obtenerUsuarios();  mostrarUsuariosInTable();           
        }                 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelUsuarios = new javax.swing.JPanel();
        PanelTOPV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelDatosV = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre_Usuario = new javax.swing.JTextField();
        Label_NombreCliente4 = new javax.swing.JLabel();
        txtTelefono_Usuario = new javax.swing.JTextField();
        Label_NombreCliente5 = new javax.swing.JLabel();
        btnGuardar_Usuarios = new javax.swing.JButton();
        btnEliminar_Usuario = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar_Usuario = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        Label_NombreCliente6 = new javax.swing.JLabel();
        Label_NombreCliente7 = new javax.swing.JLabel();
        txtPassword_Usuario = new javax.swing.JPasswordField();
        txtPassword_Usuario2 = new javax.swing.JPasswordField();
        Label_NombreCliente8 = new javax.swing.JLabel();
        jCombo_tipoUsuario = new javax.swing.JComboBox<>();
        PanelBusquedaV = new javax.swing.JPanel();
        jScrollPane_TableUsuarios = new javax.swing.JScrollPane();
        tableUsuarios = tableUsuarios = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel9 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(884, 485));

        PanelUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        PanelUsuarios.setPreferredSize(new java.awt.Dimension(884, 485));

        PanelTOPV.setBackground(new java.awt.Color(255, 255, 255));
        PanelTOPV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Usuarios");

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

        PanelDatosV.setBackground(new java.awt.Color(255, 255, 255));
        PanelDatosV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelDatosV.setMaximumSize(new java.awt.Dimension(386, 338));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText("Ingrese la información del nuevo usuario");
        jLabel8.setToolTipText("");

        Label_NombreCliente4.setText("Nombre");
        Label_NombreCliente4.setToolTipText("");

        Label_NombreCliente5.setText("Teléfono");
        Label_NombreCliente5.setToolTipText("");

        btnGuardar_Usuarios.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar_Usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar_color.png"))); // NOI18N
        btnGuardar_Usuarios.setToolTipText("Guardar usuario");
        btnGuardar_Usuarios.setBorder(null);
        btnGuardar_Usuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar_Usuarios.setFocusPainted(false);
        btnGuardar_Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar_UsuariosActionPerformed(evt);
            }
        });

        btnEliminar_Usuario.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar_color.png"))); // NOI18N
        btnEliminar_Usuario.setToolTipText("Eliminar usuario");
        btnEliminar_Usuario.setBorder(null);
        btnEliminar_Usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar_Usuario.setFocusPainted(false);
        btnEliminar_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_UsuarioActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar_color.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEditar_Usuario.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar_color.png"))); // NOI18N
        btnEditar_Usuario.setToolTipText("Editar usuario");
        btnEditar_Usuario.setBorder(null);
        btnEditar_Usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar_Usuario.setFocusPainted(false);
        btnEditar_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar_UsuarioActionPerformed(evt);
            }
        });

        Label_NombreCliente6.setText("Usuario");
        Label_NombreCliente6.setToolTipText("");

        Label_NombreCliente7.setText("Contraseña");
        Label_NombreCliente7.setToolTipText("");

        txtPassword_Usuario.setPreferredSize(new java.awt.Dimension(100, 20));

        txtPassword_Usuario2.setPreferredSize(new java.awt.Dimension(100, 20));

        Label_NombreCliente8.setText("Confirme contraseña");
        Label_NombreCliente8.setToolTipText("");

        jCombo_tipoUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCombo_tipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Administrador" }));

        javax.swing.GroupLayout PanelDatosVLayout = new javax.swing.GroupLayout(PanelDatosV);
        PanelDatosV.setLayout(PanelDatosVLayout);
        PanelDatosVLayout.setHorizontalGroup(
            PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosVLayout.createSequentialGroup()
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosVLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8))
                    .addGroup(PanelDatosVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar_Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btnEliminar_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDatosVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_NombreCliente4)
                            .addComponent(Label_NombreCliente5)
                            .addGroup(PanelDatosVLayout.createSequentialGroup()
                                .addComponent(Label_NombreCliente6)
                                .addGap(52, 52, 52)
                                .addComponent(Label_NombreCliente7))
                            .addComponent(txtTelefono_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txtNombre_Usuario)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelDatosVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jCombo_tipoUsuario, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPassword_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelDatosVLayout.createSequentialGroup()
                                    .addComponent(Label_NombreCliente8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPassword_Usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        PanelDatosVLayout.setVerticalGroup(
            PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosVLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label_NombreCliente4)
                .addGap(6, 6, 6)
                .addComponent(txtNombre_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Label_NombreCliente5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelDatosVLayout.createSequentialGroup()
                        .addComponent(Label_NombreCliente6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelDatosVLayout.createSequentialGroup()
                        .addComponent(Label_NombreCliente7)
                        .addGap(26, 26, 26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword_Usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_NombreCliente8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCombo_tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(PanelDatosVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar_Usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar_Usuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar_Usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        PanelBusquedaV.setBackground(new java.awt.Color(255, 255, 255));
        PanelBusquedaV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableUsuarios.setRowHeight(20);
        tableUsuarios.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane_TableUsuarios.setViewportView(tableUsuarios);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 204));
        jLabel9.setText("Lista de usuarios");

        javax.swing.GroupLayout PanelBusquedaVLayout = new javax.swing.GroupLayout(PanelBusquedaV);
        PanelBusquedaV.setLayout(PanelBusquedaVLayout);
        PanelBusquedaVLayout.setHorizontalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_TableUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelBusquedaVLayout.setVerticalGroup(
            PanelBusquedaVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaVLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_TableUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelUsuariosLayout = new javax.swing.GroupLayout(PanelUsuarios);
        PanelUsuarios.setLayout(PanelUsuariosLayout);
        PanelUsuariosLayout.setHorizontalGroup(
            PanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuariosLayout.createSequentialGroup()
                .addComponent(PanelDatosV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelBusquedaV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelTOPV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelUsuariosLayout.setVerticalGroup(
            PanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuariosLayout.createSequentialGroup()
                .addComponent(PanelTOPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelDatosV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBusquedaV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardar_UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_UsuariosActionPerformed
     
        if(!editarUsuario)
            try {
                guardarUsuario();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(pnlProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        else
        {
            editarUsuario(codigoUsuario);
            editarUsuario = false;
        }         
    }//GEN-LAST:event_btnGuardar_UsuariosActionPerformed

    private void btnEditar_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_UsuarioActionPerformed
        if( txtNombre_Usuario.hasFocus() || txtTelefono_Usuario.hasFocus() || txtUsuario.hasFocus() || txtPassword_Usuario.hasFocus())
            txtNombre_Usuario.requestFocus();

        else
        {
            if(tableUsuarios.getSelectedRow() >=  0)//< -1)
            {
                codigoUsuario = (int) tableUsuarios.getValueAt(fila, 0);

                editarUsuario = true;
                txtNombre_Usuario.setText(String.valueOf(tableUsuarios.getValueAt(fila, 1))); txtNombre_Usuario.requestFocus();
                txtTelefono_Usuario.setText(String.valueOf(tableUsuarios.getValueAt(fila, 2)));
                txtUsuario.setText(String.valueOf(tableUsuarios.getValueAt(fila, 3)));
                jCombo_tipoUsuario.setSelectedItem(String.valueOf(tableUsuarios.getValueAt(fila, 4)));
                txtPassword_Usuario.setText(String.valueOf(tableUsuarios.getValueAt(fila, 5)));
                txtPassword_Usuario2.setText((String)tableUsuarios.getValueAt(fila, 5));
                //codigoCliente = -1;
            }    
            else
            {
                txtNombre_Usuario.requestFocus();
                editarUsuario = false;
            }
        }
    }//GEN-LAST:event_btnEditar_UsuarioActionPerformed

    private void tableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUsuariosMouseClicked
        fila = tableUsuarios.getSelectedRow();
    }//GEN-LAST:event_tableUsuariosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cleanTXT();
        txtNombre_Usuario.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminar_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_UsuarioActionPerformed
        if( txtNombre_Usuario.hasFocus() || txtTelefono_Usuario.hasFocus() || txtUsuario.hasFocus() || txtPassword_Usuario.hasFocus())
            txtNombre_Usuario.requestFocus();
        else
        {
            if (tableUsuarios.getSelectedRow() < 0) {
                txtNombre_Usuario.requestFocus();
            } else {
                codigoUsuario = (int) tableUsuarios.getValueAt(fila, 0);
                
                if(!verificaUsuarioLogueado(codigoUsuario))
                    eliminarUsuario(codigoUsuario);               
            }
        }       
    }//GEN-LAST:event_btnEliminar_UsuarioActionPerformed

    
    public boolean verificaUsuarioLogueado(int codigo)
    {
        if(frameLogin.usuarioLogueado.getCodigo() == codigo)
        {
            Usuario_controller.Notificaciones("tryToDeleteLoged");
            return true;
        }
        return false;
    }
    
    public void eliminarUsuario(int codigo)
    {
        Usuario usuario = new Usuario();
        usuario.setCodigo(codigo);
        
         if(Usuario_controller.eliminarUsuario(usuario))
         {
            Usuario_controller.Notificaciones("userDelete");
         }
         
        cleanTXT();
        txtNombre_Usuario.requestFocus();
         
         obtenerUsuarios(); mostrarUsuariosInTable();
    }
    
        private boolean validaTXT(String panel)
    {
        boolean estado = false;
        
        if(panel.equalsIgnoreCase("usuario"))
        {
            if(txtNombre_Usuario.getText().isEmpty())
            {
                //lblCod.setVisible(true);  txtCodigo_Producto.requestFocus();  return estado;                
            }
            else if(txtTelefono_Usuario.getText().isEmpty())
            {
                //lblDescrip.setVisible(true); txtDescripcion_Producto.requestFocus();  return estado;
            }
            else if(txtUsuario.getText().isEmpty())
            {
                //lblPrecio.setVisible(true); txtPrecio_Producto.requestFocus(); return estado;
            }
            else if(txtPassword_Usuario.getText().isEmpty())
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
        txtNombre_Usuario.setText("");
        txtTelefono_Usuario.setText("");
        txtUsuario.setText("");        
        txtPassword_Usuario.setText("");
        txtPassword_Usuario2.setText("");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_NombreCliente4;
    private javax.swing.JLabel Label_NombreCliente5;
    private javax.swing.JLabel Label_NombreCliente6;
    private javax.swing.JLabel Label_NombreCliente7;
    private javax.swing.JLabel Label_NombreCliente8;
    private javax.swing.JPanel PanelBusquedaV;
    private javax.swing.JPanel PanelDatosV;
    private javax.swing.JPanel PanelTOPV;
    private javax.swing.JPanel PanelUsuarios;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar_Usuario;
    private javax.swing.JButton btnEliminar_Usuario;
    private javax.swing.JButton btnGuardar_Usuarios;
    private javax.swing.JComboBox<String> jCombo_tipoUsuario;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane_TableUsuarios;
    private javax.swing.JTable tableUsuarios;
    private javax.swing.JTextField txtNombre_Usuario;
    private javax.swing.JPasswordField txtPassword_Usuario;
    private javax.swing.JPasswordField txtPassword_Usuario2;
    private javax.swing.JTextField txtTelefono_Usuario;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
