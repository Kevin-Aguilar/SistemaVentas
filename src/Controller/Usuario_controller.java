
package Controller;

import Model.Cliente;
import Model.Usuario;
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
 * @author Kevin
 */
public class Usuario_controller {
    
    private static Connection miConexion = null;
    private static PreparedStatement miStatement = null;
    private static ResultSet miResult = null;
    private static String url = "jdbc:mysql://localhost:3306/sistemaventas?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = "12345";
    
    
    public static boolean guardarUsuario(Usuario usuario)
    {
        boolean estado = false;
        
        try
        {
            miConexion = DriverManager.getConnection(url, user, password);

//            String sqlConsulta = "SELECT * FROM cliente WHERE codigo = ?";
//            miStatement = miConexion.prepareStatement(sqlConsulta);
//            miStatement.setString(1, cliente.getTelefono());
//            miResultSet = miStatement.executeQuery();

//            if(miResultSet.next()) SI EL NÚMERO DE TELÉFONO YA EXISTE
//                ArchivosControl.Notificaciones("codExist");

//            else
//            {
                String sqlGuardar = "INSERT INTO usuarios(nombre, telefono, usuario, contrasenia, tipoUsuario) values(?,?,?,?,?)";

                miStatement = miConexion.prepareStatement(sqlGuardar);
                //miStatement.setInt(1, cliente.getCodigo());
                miStatement.setString(1, usuario.getNombre()); 
                miStatement.setString(2,usuario.getTelefono());
                miStatement.setString(3, usuario.getUsuario());   
                miStatement.setString(4, usuario.getContrasenia()); 
                miStatement.setString(5, usuario.getTipoUsuario()); 
                miStatement.execute();

                estado = true;
                miConexion.close();

                return estado;                  
            //}  
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
                   
        return estado;
    }
    
    
        public static boolean editarUsuario(Usuario usuario) 
    {
        boolean estado = false;
        
            try
            {            
                miConexion = DriverManager.getConnection(url, user, password);             

                String sqlConsulta = "UPDATE usuarios SET nombre = ?, telefono = ?, usuario= ?, contrasenia = ?, tipoUsuario = ? WHERE id_usuario = ?";

                miStatement = miConexion.prepareStatement(sqlConsulta);
                miStatement.setString(1, usuario.getNombre()); 
                miStatement.setString(2,usuario.getTelefono());
                miStatement.setString(3, usuario.getUsuario());   
                miStatement.setString(4, usuario.getContrasenia()); 
                miStatement.setString(5, usuario.getTipoUsuario());
                miStatement.setInt(6, usuario.getCodigo());
                miStatement.execute();

                estado = true;
                miConexion.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }            
        return estado;
    }
    
    public static boolean eliminarUsuario(Usuario usuario)
    {
        boolean estado = false;
        
            try
            {            
                miConexion = DriverManager.getConnection(url, user, password);            

                String sqlConsulta = "DELETE FROM usuarios WHERE id_usuario = ?";

                miStatement = miConexion.prepareStatement(sqlConsulta);
                miStatement.setInt(1, usuario.getCodigo());
                miStatement.execute();

                estado = true;
                miConexion.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            } 
            
        return estado;        
    }
    
    public static Usuario buscarUsuario(int numUsuario)
    {            
        Usuario usuario = new Usuario(); 
        try {
            miConexion = DriverManager.getConnection(url, user, password);
 
            
            
            String sqlConsulta = "SELECT * FROM usuarios where id_usuario = ?";
            
            miStatement = miConexion.prepareStatement(sqlConsulta);
            miStatement.setInt(1, numUsuario);
            miResult = miStatement.executeQuery();
            
            while(miResult.next())
            {
                usuario.setNombre(miResult.getString("nombre"));
                usuario.setTelefono(miResult.getString("telefono"));                
            } 
            
            miResult.close();
            miConexion.close();
            return usuario;   
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    public static List<Usuario> listarUsuario() throws ClassNotFoundException, SQLException
    {
        miConexion = DriverManager.getConnection(url, user, password);
        Usuario user;
        List<Usuario> listaUsuarios = new ArrayList<>();
        
        
            String sqlConsulta = "SELECT * FROM usuarios";  
            
            miStatement = miConexion.prepareStatement(sqlConsulta);  
            miResult = miStatement.executeQuery();              
                
            while(miResult.next())
            {
                user = new Usuario();
                user.setCodigo(miResult.getInt("id_usuario"));
                user.setNombre(miResult.getString("nombre"));
                user.setTelefono(miResult.getString("telefono"));
                user.setUsuario(miResult.getString("usuario"));
                user.setContrasenia(miResult.getString("contrasenia"));
                user.setTipoUsuario(miResult.getString("tipoUsuario"));
                

                listaUsuarios.add(user);   //agrega el producto al arraylist
            } 
            
            miResult.close();
            miConexion.close();
            
            return listaUsuarios;      
    }    
    
    
    public static void Notificaciones(String accion)
    {
        switch(accion)
        {
            case "userSaved":
                    new rojerusan.RSNotifyAnimated("", "Usuario registrado", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                            RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                 break;
                
            case "codExist":
                    new rojerusan.RSNotifyAnimated("", "El código del producto ya existe", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                         RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                break;
            case "userEdit":
                new rojerusan.RSNotifyAnimated("", "Usuario actualizado", 3, RSNotifyAnimated.PositionNotify.BottomRight,
                        RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                break;
            case "userDelete":
                new rojerusan.RSNotifyAnimated("", "Usuario eliminado", 3, RSNotifyAnimated.PositionNotify.BottomRight,
                        RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                break;
            case "tryToDeleteLoged":
                new rojerusan.RSNotifyAnimated("", "No puede eliminar el usuario que cuenta con sesion activa", 4, RSNotifyAnimated.PositionNotify.BottomRight,
                        RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                break;
            case "passwordIncorret":
                new rojerusan.RSNotifyAnimated("", "Las contraseñas ingresadas no son correspondientes", 4, RSNotifyAnimated.PositionNotify.BottomRight,
                        RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                break;    
        } 
     
    }
    
        
 }
