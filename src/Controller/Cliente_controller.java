
package Controller;

import Model.Cliente;
//import View.ArchivosControl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author kevin
 */
public class Cliente_controller
{
    
    private static Connection miConexion = null;
    private static PreparedStatement miStatement = null;
    private static ResultSet miResult = null;
    private static String url = "jdbc:mysql://localhost:3306/sistemaventas?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = "12345";
    
    
    public static boolean guardarCliente(Cliente cliente)
    {
        boolean estado = false;
        
        try
        {
            miConexion = DriverManager.getConnection(url, user, password);

            String sqlConsulta = "SELECT * FROM clientes WHERE telefono = ?";
            miStatement = miConexion.prepareStatement(sqlConsulta);
            miStatement.setString(1, cliente.getTelefono());
            miResult = miStatement.executeQuery();

            if(miResult.next())// SI EL NÚMERO DE TELÉFONO YA EXISTE
                Notificaciones("codExist");

            else
            {
                String sqlGuardar = "INSERT INTO clientes(nombre, telefono, direccion, email) values(?,?,?,?)";

                miStatement = miConexion.prepareStatement(sqlGuardar);
                //miStatement.setInt(1, cliente.getCodigo());
                miStatement.setString(1, cliente.getNombre()); 
                miStatement.setString(2, cliente.getTelefono());
                miStatement.setString(3, cliente.getDireccion());
                miStatement.setString(4, cliente.getEmail());
                miStatement.execute();

                estado = true;
                miConexion.close();

                return estado;                  
            }  
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
                   
        return estado;
    }
    
    
    public static boolean editarCliente(Cliente cliente) 
    {
        boolean estado = false;
        
            try
            {            
                miConexion = DriverManager.getConnection(url, user, password);             

                String sqlConsulta = "UPDATE clientes SET nombre = ?, telefono = ?, direccion = ?, email = ? WHERE id_cliente = ?";

                miStatement = miConexion.prepareStatement(sqlConsulta);
                miStatement.setString(1, cliente.getNombre());
                miStatement.setString(2, cliente.getTelefono());
                miStatement.setString(3, cliente.getDireccion());
                miStatement.setString(4, cliente.getEmail());
                miStatement.setInt(5, cliente.getCodigo());
                miStatement.execute();

                estado = true;
                miConexion.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }            
        return estado;
    }
    
    public static boolean eliminarCliente(Cliente cliente)
    {
        boolean estado = false;
        
            try
            {            
                miConexion = DriverManager.getConnection(url, user, password);            

                String sqlConsulta = "DELETE FROM clientes WHERE id_cliente = ?";

                miStatement = miConexion.prepareStatement(sqlConsulta);
                miStatement.setInt(1, cliente.getCodigo());
                miStatement.execute();

                estado = true;
                miConexion.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            } 
            
        return estado;        
    }   
    
    
    public static Cliente buscarCliente(int numCliente)
    {            
        Cliente cliente = new Cliente(); 
        try {
            miConexion = DriverManager.getConnection(url, user, password);
 
            
            
            String sqlConsulta = "SELECT * FROM clientes where id_cliente = ?";
            
            miStatement = miConexion.prepareStatement(sqlConsulta);
            miStatement.setInt(1, numCliente);
            miResult = miStatement.executeQuery();
            
            while(miResult.next())
            {
                cliente.setNombre(miResult.getString("nombre"));
                cliente.setDireccion(miResult.getString("direccion"));
                cliente.setTelefono(miResult.getString("telefono"));                
            } 
            
            miResult.close();
            miConexion.close();
            return cliente;   
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
    
    
    public static List<Cliente> listarCliente() throws ClassNotFoundException, SQLException
    {
        miConexion = DriverManager.getConnection(url, user, password);
        Cliente client;
        List<Cliente> listaClientes = new ArrayList<>();
        
        
            String sqlConsulta = "SELECT * FROM clientes";  
            
            miStatement = miConexion.prepareStatement(sqlConsulta);  
            miResult = miStatement.executeQuery();              
                
            while(miResult.next())
            {
                client = new Cliente();
                client.setCodigo(miResult.getInt("id_cliente"));
                client.setNombre(miResult.getString("nombre"));
                client.setTelefono(miResult.getString("telefono"));
                client.setDireccion(miResult.getString("direccion"));
                client.setEmail(miResult.getString("email"));
                

                listaClientes.add(client);   //agrega el producto al arraylist
            } 
            
            miResult.close();
            miConexion.close();
            
            return listaClientes;      
    }
 
    
    public static void Notificaciones(String accion)
    {
        switch(accion)
        {
            case "clientSaved":
                    new rojerusan.RSNotifyAnimated("", "Cliente guardado", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                            RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                 break;
                
            case "codExist":
                    new rojerusan.RSNotifyAnimated("", "El teléfono ingresado está asignado a otro cliente", 4, RSNotifyAnimated.PositionNotify.BottomRight, 
                         RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                break;
            case "clientEdit":
                new rojerusan.RSNotifyAnimated("", "Cliente actualizado", 3, RSNotifyAnimated.PositionNotify.BottomRight,
                        RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                break;
            case "clientDelete":
                new rojerusan.RSNotifyAnimated("", "Cliente eliminado", 3, RSNotifyAnimated.PositionNotify.BottomRight,
                        RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                break;
                
        } 
        
    }
    
}
