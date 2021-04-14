
package Controller;

import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kevin
 */
public class DB
{
    public static Connection conectar() throws ClassNotFoundException, SQLException
    {
        Connection miConexion = null;
        PreparedStatement miStatement = null;
        ResultSet miResultSet = null;
        String mensaje = "";

        
        Class.forName("com.mysql.jdbc.Driver"); //jdbc:hsqldb:file:DB2/DB_Sistema2
        miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaventas?autoReconnect=true&useSSL=false", "root", "'12345'");

              
        

        return miConexion;
        
//        if(miConexion != null)
//        {
//               
//            String sqlConsulta = "SELECT * FROM usuario WHERE cedula = ?";  //crea consulta usuario mediante la cédula
//            miStatement = miConexion.prepareStatement(sqlConsulta);         //asigna al preparedStatement la consulta
//            miStatement.setString(1, user.getCedula());             //asigna al parámetro la cédula
//            miResultSet = miStatement.executeQuery();               //se ejecuta consulta 
//                
//            if(miResultSet.next())
//            {
//                String ced = miResultSet.getString("cedula");
//                String pass = miResultSet.getString("contrasenia");
//                String tipo = miResultSet.getString("tipo");
//
//                if(user.getContrasenia().equals(pass))
//                {                       
//                    return tipo;
//                }else
//                {
//                    return mensaje = "passwordFalse";
//                }
//
//            }else     //significa que no se encuentra registrado y procede a ingresarlo a BBDD
//            {
//                String sqlRegistro = "INSERT INTO usuario(cedula,contrasenia,tipo) values(?,?,?)";
//
//                    miStatement = miConexion.prepareStatement(sqlRegistro);
//                    miStatement.setString(1, user.getCedula());
//                    miStatement.setString(2, user.getContrasenia());   
//                    miStatement.setString(3, user.getTipoUsuario());
//                    miStatement.execute();
//
//                    return user.getTipoUsuario();
//            }                
//        }
//        return mensaje = "error";
    }  
    
    public static void guardarCliente(Cliente cliente) throws ClassNotFoundException, SQLException
    {
        Connection miConexion = conectar();
        PreparedStatement miStatement = null;
        Statement miState = null;
        //ResultSet miResultSet = null;
        String mensaje = "";
        
        
        String sqlRegistro = "INSERT INTO cliente(codigo, nombre, telefono, direccion) values(?,?,?,?)";

        miStatement = miConexion.prepareStatement(sqlRegistro);
        miStatement.setInt(1, cliente.getCodigo());
        miStatement.setString(2, cliente.getNombre());   
        miStatement.setString(3, cliente.getTelefono());
        miStatement.setString(4, cliente.getDireccion());
        miStatement.execute();

        System.out.println("Guardado exitosamente");
        miConexion.close();
        System.out.println("Conexion cerrada");
    }
}
