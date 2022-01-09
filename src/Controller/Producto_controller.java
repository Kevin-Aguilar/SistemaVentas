
package Controller;

import static Controller.DB.conectar;
import Model.Producto;
//import View.ArchivosControl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author kevin
 */
public class Producto_controller
{
   
    private static Connection miConexion = null;
    private static PreparedStatement miStatement = null;
    private static ResultSet miResult = null;
    private static String url = "jdbc:mysql://localhost:3306/sistemaventas?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = "12345";
    
    /*Constructor */
    public Producto_controller() throws ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
    }

    
    public static boolean guardarProducto(Producto producto) throws SQLException, ClassNotFoundException
    {       
        boolean estado = false;
               
        miConexion = DriverManager.getConnection(url, user, password);
        
            try
            {                
                String sqlConsulta = "SELECT * FROM productos WHERE id_producto = ?";
                miStatement = miConexion.prepareStatement(sqlConsulta);
                miStatement.setInt(1, producto.getCodigo());
                miResult = miStatement.executeQuery();

                if(miResult.next())
                    Notificaciones("codExist");

                else
                {

                    String sqlGuardar = "INSERT INTO productos(id_producto, descripcion, precio, precioUberEats) values(?,?,?,?)";

                    miStatement = miConexion.prepareStatement(sqlGuardar);
                    miStatement.setInt(1, producto.getCodigo());
                    miStatement.setString(2, producto.getDescripcion());
                    miStatement.setDouble(3, producto.getPrecio());
                    miStatement.setDouble(4, producto.getPrecioUberEats());
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
    
    
    public static boolean editarProducto(Producto producto) 
    {
        boolean estado = false;
        
            try
            {            
                miConexion = DriverManager.getConnection(url, user, password);             

                String sqlConsulta = "UPDATE productos SET descripcion = ?, precio = ?, precioUberEats = ? WHERE id_producto = ?";

                miStatement = miConexion.prepareStatement(sqlConsulta);
                miStatement.setString(1, producto.getDescripcion());
                miStatement.setDouble(2, producto.getPrecio());
                miStatement.setDouble(3, producto.getPrecioUberEats());
                miStatement.setInt(4, producto.getCodigo());
                miStatement.execute();

                estado = true;
                miConexion.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }            
        return estado;
    }
    
    
    public static List<Producto> buscarProducto()
    {
        try
        {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaventas?autoReconnect=true&useSSL=false", "root", "12345");
            PreparedStatement miStatement = null;
            ResultSet miResultSet = null;
            Producto product;
            List<Producto> listaProductos = new ArrayList<>();


                String sqlConsulta = "SELECT * FROM productos";  

                miStatement = miConexion.prepareStatement(sqlConsulta);  
                miResultSet = miStatement.executeQuery();              

                while(miResultSet.next())
                {
                    product = new Producto();
                    product.setCodigo(miResultSet.getInt("id_producto"));
                    product.setDescripcion(miResultSet.getString("descripcion"));
                    product.setPrecio(miResultSet.getDouble("precio"));
                    product.setPrecioUberEats(miResultSet.getDouble("precioUberEats"));

                    listaProductos.add(product);   //agrega el producto al arraylist
                } 

                miResultSet.close();
                miConexion.close();

                return listaProductos;    

        } catch (ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        } 
         return null;
    }
    
    
    
    
    public static Producto buscarProductoPorID(int id_producto)
    {            
        Producto producto = new Producto(); 
        try {
            miConexion = DriverManager.getConnection(url, user, password);
 
            
            
            String sqlConsulta = "SELECT * FROM productos where id_producto = ?";
            
            miStatement = miConexion.prepareStatement(sqlConsulta);
            miStatement.setInt(1, id_producto);
            miResult = miStatement.executeQuery();
            
            while(miResult.next())
            {
                producto.setCodigo(id_producto);
                producto.setDescripcion(miResult.getString("descripcion"));
                producto.setPrecio(miResult.getDouble("precio"));   
                producto.setPrecioUberEats(miResult.getDouble("precioUberEats"));
            } 
            
            miResult.close();
            miConexion.close();
            return producto;   
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }
    
    
    public static boolean eliminarProducto(Producto producto)
    {
        boolean estado = false;
        
            try
            {            
                miConexion = DriverManager.getConnection(url, user, password);            

                String sqlConsulta = "DELETE FROM productos WHERE id_producto = ?";

                miStatement = miConexion.prepareStatement(sqlConsulta);
                miStatement.setInt(1, producto.getCodigo());
                miStatement.execute();

                estado = true;
                miConexion.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            } 
            
        return estado;        
    }
    
    
    public static List<Producto> listarProducto() throws ClassNotFoundException, SQLException
    {
        miConexion = DriverManager.getConnection(url, user, password);
        Producto product;
        List<Producto> listaProductos = new ArrayList<>();
        
        
            String sqlConsulta = "SELECT * FROM productos";  
            
            miStatement = miConexion.prepareStatement(sqlConsulta);  
            miResult = miStatement.executeQuery();              
                
            while(miResult.next())
            {
                product = new Producto();
                product.setCodigo(miResult.getInt("id_producto"));
                product.setDescripcion(miResult.getString("descripcion"));
                product.setPrecio(miResult.getDouble("precio"));
                product.setPrecioUberEats(miResult.getDouble("precioUberEats"));
                

                listaProductos.add(product);   //agrega el producto al arraylist
            } 
            
            miResult.close();
            miConexion.close();
            
            return listaProductos;      
    }
    
    public static void Notificaciones(String accion)
    {
        switch(accion)
        {
            case "prodSaved":
                    new rojerusan.RSNotifyAnimated("", "Producto guardado", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                            RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                 break;
                
            case "codExist":
                    new rojerusan.RSNotifyAnimated("", "El código del producto ya existe", 3, RSNotifyAnimated.PositionNotify.BottomRight, 
                         RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                break;
            case "prodEdit":
                new rojerusan.RSNotifyAnimated("", "Producto editado", 3, RSNotifyAnimated.PositionNotify.BottomRight,
                        RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                break;
            case "prodDelete":
                new rojerusan.RSNotifyAnimated("", "Producto eliminado", 3, RSNotifyAnimated.PositionNotify.BottomRight,
                        RSNotifyAnimated.AnimationNotify.RightLeft, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                break;
                
        }        
    }
}
