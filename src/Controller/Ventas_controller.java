
package Controller;

import Model.Detalle_Ventas;
import Model.Tiquete_venta;
import Model.Ventas;
import View.pnlReportesDia;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.System.in;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kevin
 */
public class Ventas_controller 
{
    private static Connection miConexion = null;
    private static PreparedStatement miStatement = null;
    private static ResultSet miResult = null;
    private static String url = "jdbc:mysql://localhost:3306/sistemaventas?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = "12345";
    
    public static List<Tiquete_venta> listaDetalle = new ArrayList<>();
    public static Tiquete_venta detalleReporte;

    public Ventas_controller() {}
    

    public boolean RegistrarVenta(Ventas v, String cliente, String usuario, String direccionC, String telC)
    {
        boolean estado = false;
        try
        {
            miConexion = DriverManager.getConnection(url, user, password);

                /*String sqlGuardar = "INSERT INTO ventas(total, id_usuario, id_cliente, transporte, fecha) values(?,?,?,?, curdate())";

                miStatement = miConexion.prepareStatement(sqlGuardar);
                //miStatement.setInt(1, cliente.getCodigo());
                miStatement.setDouble(1, v.getTotal()); 
                miStatement.setInt(2, v.getCodigoUsuario());
                miStatement.setInt(3, v.getCodigoCliente());
                miStatement.setDouble(4, v.getTransporte());
                miStatement.execute();*/
                
                
                String sqlGuardar = "INSERT INTO ventastest(fecha, total, id_usuario, id_cliente, nombre_usuario, nombre_cliente, direccion_cliente, telefono_cliente, transporte) \n" +
                                        "values(curdate(),?,?,?,?,?,?,?,?)";

                miStatement = miConexion.prepareStatement(sqlGuardar);
                //miStatement.setInt(1, cliente.getCodigo());
                miStatement.setDouble(1, v.getTotal()); 
                miStatement.setInt(2, v.getCodigoUsuario());
                miStatement.setInt(3, v.getCodigoCliente());
                miStatement.setString(4, usuario);
                miStatement.setString(5, cliente);
                miStatement.setString(6, direccionC);
                miStatement.setString(7, telC);
                miStatement.setDouble(8, v.getTransporte());
                miStatement.execute();
                

                estado = true;
                miConexion.close();

                return estado;                   
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return estado;
    }   
    
    public boolean RegistrarDetalle_venta(Detalle_Ventas detalleVenta, String producto, double precioProducto)
    {
        boolean estado = false;
        try
        {
            miConexion = DriverManager.getConnection(url, user, password);

//                String sqlGuardar = "INSERT INTO detalle_ventas(cantidad, id_venta, id_producto) values(?,"
//                        + "(SELECT MAX(id_venta) FROM ventas),?)";
//
//                miStatement = miConexion.prepareStatement(sqlGuardar);
//                //miStatement.setInt(1, cliente.getCodigo());
//                miStatement.setDouble(1, detalleVenta.getCantidad()); 
//               // miStatement.setInt(2, detalleVenta.getCodigo_Venta());
//                miStatement.setInt(2, detalleVenta.getCodigoProducto());   
//                miStatement.execute();


                String sqlGuardar = "INSERT INTO detalle_ventas_test(id_producto, descripcion, cantidad,precio, id_venta) "
                        + "values(?,?,?,?,(SELECT MAX(id_venta) FROM ventastest))";

                miStatement = miConexion.prepareStatement(sqlGuardar);
                miStatement.setInt(1, detalleVenta.getCodigoProducto()); ;
                miStatement.setString(2, producto);  
                miStatement.setInt(3, detalleVenta.getCantidad());
                miStatement.setDouble(4, precioProducto);
                miStatement.execute();

                estado = true;
                miConexion.close();

                return estado;                   
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return estado;
    }
    
   
    
    
    public static int getNumeroFactura()
    {
        int numeroFactura = 0;
        try
        {
            miConexion = DriverManager.getConnection(url, user, password);

                String sqlGuardar = "SELECT MAX(id_venta) FROM ventastest";

                miStatement = miConexion.prepareStatement(sqlGuardar);  
                miResult = miStatement.executeQuery(); 

            while(miResult.next())
            {
                numeroFactura = miResult.getInt(1);
            } 
            miResult.close();
            miConexion.close();
                
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }        
        return numeroFactura+1;
    }
 
    
    public static double getTotalVentaDia()
    {
        double totalDia = 0;
        try
        {
            miConexion = DriverManager.getConnection(url, user, password);

                String sqlGuardar = "SELECT SUM(total) FROM ventastest where fecha = curdate()";

                miStatement = miConexion.prepareStatement(sqlGuardar);  
                miResult = miStatement.executeQuery(); 

            while(miResult.next())
            {
                totalDia = miResult.getDouble(1);
            } 
            miResult.close();
            miConexion.close();
                
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }        
        return totalDia;        
    }
    
    
    public static boolean anularVenta(int factura)
    {
        boolean estado = false;
        
            try
            {            
                miConexion = DriverManager.getConnection(url, user, password);            

                String sqlConsulta = "DELETE ventastest, detalle_ventas_test from\n" +
                                    "ventastest join detalle_ventas_test on ventastest.id_venta = detalle_ventas_test.id_venta where ventastest.id_venta = ?;";

                miStatement = miConexion.prepareStatement(sqlConsulta);
                miStatement.setInt(1, factura);
                miStatement.execute();

                estado = true;
                miConexion.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            } 
            
        return estado; 
    }
    
    public static List<Ventas> listarVentas() 
    {       
        List<Ventas> listaVentas = new ArrayList<>();
        try 
        {
            miConexion = DriverManager.getConnection(url, user, password);
            Ventas venta;
            
            String sqlConsulta = "SELECT * FROM ventas";
            
            miStatement = miConexion.prepareStatement(sqlConsulta);
            miResult = miStatement.executeQuery();
            
            while(miResult.next())
            {
                venta = new Ventas();
                venta.setCodigoVenta(miResult.getInt("id_venta"));
                venta.setTotal(miResult.getDouble("total"));
                venta.setCodigoUsuario(miResult.getInt("id_usuario"));
                venta.setCodigoCliente(miResult.getInt("id_cliente"));

                listaVentas.add(venta);
            } 
            
            miResult.close();
            miConexion.close();
            
            return listaVentas;      
        } catch (SQLException ex) 
        {
            Logger.getLogger(Ventas_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentas; 
    }
    
    public static Ventas listarVentaPorFactura(int numeroFactura)
    {
        Ventas venta = new Ventas();;
        
        try 
        {
            miConexion = DriverManager.getConnection(url, user, password);
            
//            String sqlConsulta = "SELECT * FROM ventas where id_venta = ?";
//            
//            miStatement = miConexion.prepareStatement(sqlConsulta);
//             
//            miStatement.setInt(1, numeroFactura); 
//            miResult = miStatement.executeQuery();
//            
//            
//            while(miResult.next())
//            {
//                venta.setCodigoVenta(numeroFactura);
//                venta.setTotal(miResult.getDouble("total"));
//                venta.setCodigoUsuario(miResult.getInt("id_usuario"));
//                venta.setCodigoCliente(miResult.getInt("id_cliente"));
//                venta.setFecha(miResult.getDate("fecha"));
//            } 


            String sqlConsulta = "SELECT * FROM ventastest where id_venta = ?";
            
            miStatement = miConexion.prepareStatement(sqlConsulta);
             
            miStatement.setInt(1, numeroFactura); 
            miResult = miStatement.executeQuery();
            
            
            while(miResult.next())
            {
                venta.setCodigoVenta(numeroFactura);
                venta.setTotal(miResult.getDouble("total"));
                venta.setCodigoUsuario(miResult.getInt("id_usuario"));
                venta.setCodigoCliente(miResult.getInt("id_cliente"));
                venta.setNombreUsuario(miResult.getString("nombre_usuario"));
                venta.setNombreCliente(miResult.getString("nombre_cliente"));
                 venta.setTelCliente(miResult.getString("telefono_cliente"));
                venta.setDirCliente(miResult.getString("direccion_cliente"));
                venta.setFecha(miResult.getDate("fecha"));
            } 

            miResult.close();
            miConexion.close();
            
            obtenerDetalleVenta(numeroFactura);
                  
        } catch (SQLException ex) 
        {
            Logger.getLogger(Ventas_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
      return venta;  
    }
    
    public static List<Ventas> listarVentaPorUsuario(int idUsuario)
    {
        
        List<Ventas> listaVentas = new ArrayList<>();
        
       
        try 
        {
            miConexion = DriverManager.getConnection(url, user, password);
            
//            String sqlConsulta = "SELECT * FROM ventas where id_usuario = ?";
//            
//            miStatement = miConexion.prepareStatement(sqlConsulta);
//             
//            miStatement.setInt(1, idUsuario); 
//            miResult = miStatement.executeQuery();
//            
//            
//            while(miResult.next())
//            {
//                Ventas venta = new Ventas();
//                venta.setCodigoVenta(miResult.getInt("id_venta"));
//                venta.setTotal(miResult.getDouble("total"));
//                venta.setCodigoUsuario(miResult.getInt("id_usuario"));
//                venta.setCodigoCliente(miResult.getInt("id_cliente"));
//                venta.setFecha(miResult.getDate("fecha"));
//                
//                listaVentas.add(venta);
//            } 


            String sqlConsulta = "SELECT * FROM ventastest where id_usuario = ?";
            
            miStatement = miConexion.prepareStatement(sqlConsulta);
             
            miStatement.setInt(1, idUsuario); 
            miResult = miStatement.executeQuery();
            
            
            while(miResult.next())
            {
                Ventas venta = new Ventas();
                venta.setCodigoVenta(miResult.getInt("id_venta"));
                venta.setTotal(miResult.getDouble("total"));
                venta.setCodigoUsuario(miResult.getInt("id_usuario"));
                venta.setCodigoCliente(miResult.getInt("id_cliente"));
                venta.setNombreUsuario(miResult.getString("nombre_usuario"));
                venta.setNombreCliente(miResult.getString("nombre_cliente"));
                venta.setTelCliente(miResult.getString("telefono_cliente"));
                venta.setDirCliente(miResult.getString("direccion_cliente"));
                venta.setFecha(miResult.getDate("fecha"));
                
                listaVentas.add(venta);
            }

            miResult.close();
            miConexion.close();
            
            //obtenerDetalleVenta(numeroFactura);
                  return listaVentas;
        } catch (SQLException ex) 
        {
            Logger.getLogger(Ventas_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listaVentas; 
    }   
    
    
    
    public static List<Ventas> listarVentasDia()
    {
        List<Ventas> listaVentas = new ArrayList<>();
        
        try 
        {
            miConexion = DriverManager.getConnection(url, user, password);
            Ventas venta;
            
//            String sqlConsulta = "SELECT * FROM ventas WHERE fecha = curdate()";
//            
//            miStatement = miConexion.prepareStatement(sqlConsulta);
//            //miStatement.setString(1, fecha);
//            miResult = miStatement.executeQuery();
//            
//            
//            while(miResult.next())
//            {
//                venta = new Ventas();
//                venta.setCodigoVenta(miResult.getInt("id_venta"));
//                venta.setTotal(miResult.getDouble("total"));
//                venta.setCodigoUsuario(miResult.getInt("id_usuario"));
//                venta.setCodigoCliente(miResult.getInt("id_cliente"));
//                venta.setTransporte(miResult.getDouble("transporte"));
//
//                listaVentas.add(venta);
//            } 


            String sqlConsulta = "SELECT * FROM ventastest WHERE fecha = curdate()";
            
            miStatement = miConexion.prepareStatement(sqlConsulta);
            //miStatement.setString(1, fecha);
            miResult = miStatement.executeQuery();
            
            
            while(miResult.next())
            {
                venta = new Ventas();
                venta.setCodigoVenta(miResult.getInt("id_venta"));
                venta.setTotal(miResult.getDouble("total"));
                venta.setCodigoUsuario(miResult.getInt("id_usuario"));
                venta.setCodigoCliente(miResult.getInt("id_cliente"));
                venta.setNombreUsuario(miResult.getString("nombre_usuario"));
                venta.setNombreCliente(miResult.getString("nombre_cliente"));
                venta.setTelCliente(miResult.getString("telefono_cliente"));
                venta.setDirCliente(miResult.getString("direccion_cliente"));
                venta.setTransporte(miResult.getDouble("transporte"));

                listaVentas.add(venta);
            } 

            
            miResult.close();
            miConexion.close();
            
            return listaVentas;      
        } catch (SQLException ex) 
        {
            Logger.getLogger(Ventas_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentas;         
    }
    
    
    public static List<Ventas> listarVentasPeriodos(Date fechaInicio, Date fechaFinal)
    {
        List<Ventas> listaVentas = new ArrayList<>();
        
        try 
        {
            miConexion = DriverManager.getConnection(url, user, password);
            Ventas venta;
            
//            String sqlConsulta = "SELECT * FROM ventas WHERE fecha BETWEEN  ? AND ?";
//            
//            miStatement = miConexion.prepareStatement(sqlConsulta);
//            miStatement.setDate(1, fechaInicio);
//            miStatement.setDate(2, fechaFinal);
//            miResult = miStatement.executeQuery();
//            
//            
//            while(miResult.next())
//            {
//                venta = new Ventas();
//                venta.setCodigoVenta(miResult.getInt("id_venta"));
//                venta.setTotal(miResult.getDouble("total"));
//                venta.setFecha(miResult.getDate("fecha"));
//                venta.setCodigoUsuario(miResult.getInt("id_usuario"));
//                venta.setCodigoCliente(miResult.getInt("id_cliente"));
//
//                listaVentas.add(venta);
//            } 
            

            String sqlConsulta = "SELECT * FROM ventastest WHERE fecha BETWEEN  ? AND ?";
            
            miStatement = miConexion.prepareStatement(sqlConsulta);
            miStatement.setDate(1, fechaInicio);
            miStatement.setDate(2, fechaFinal);
            miResult = miStatement.executeQuery();
            
            
            while(miResult.next())
            {
                venta = new Ventas();
                venta.setCodigoVenta(miResult.getInt("id_venta"));
                venta.setTotal(miResult.getDouble("total"));
                venta.setFecha(miResult.getDate("fecha"));
                venta.setCodigoUsuario(miResult.getInt("id_usuario"));
                venta.setCodigoCliente(miResult.getInt("id_cliente"));
                venta.setNombreUsuario(miResult.getString("nombre_usuario"));
                venta.setNombreCliente(miResult.getString("nombre_cliente"));
                venta.setTelCliente(miResult.getString("telefono_cliente"));
                venta.setDirCliente(miResult.getString("direccion_cliente"));

                listaVentas.add(venta);
            } 

            miResult.close();
            miConexion.close();
                        
            
            return listaVentas;      
        } catch (SQLException ex) 
        {
            Logger.getLogger(Ventas_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentas;         
    }
    
    
    
    public static List<Detalle_Ventas> listarVentasPorPeriodoEstadistico(Date fechaInicio, Date fechaFinal)
    {
        List<Detalle_Ventas> listaVentas = new ArrayList<>();
        
        try 
        {
            miConexion = DriverManager.getConnection(url, user, password);
            Detalle_Ventas venta;
            
//            String sqlConsulta = "SELECT sum(detalle_ventas.cantidad) AS cantidad, detalle_ventas.id_producto, detalle_ventas.id_detalle_venta, ventas.fecha, ventas.id_venta FROM ventas\n" +
//                "INNER JOIN detalle_ventas ON ventas.id_venta = detalle_ventas.id_venta  WHERE fecha BETWEEN ? AND ?" +
//                " GROUP BY id_producto HAVING COUNT(*)>=1;";
//            
//            miStatement = miConexion.prepareStatement(sqlConsulta);
//            miStatement.setDate(1, fechaInicio);
//            miStatement.setDate(2, fechaFinal);
//            miResult = miStatement.executeQuery();
//            
//            
//            while(miResult.next())
//            {
//                venta = new Detalle_Ventas();
//                venta.setCodigo_Venta(miResult.getInt("id_venta"));
//                venta.setCodigoProducto(miResult.getInt("id_producto"));
//                venta.setCantidad(miResult.getInt("cantidad"));
//                venta.setFecha(miResult.getDate("fecha"));;
//
//                listaVentas.add(venta);
//            } 
            

            String sqlConsulta = "SELECT sum(detalle_ventas_test.cantidad) AS cantidad, detalle_ventas_test.id_producto, detalle_ventas_test.descripcion, detalle_ventas_test.precio, detalle_ventas_test.id_detalle_venta, ventastest.fecha, ventastest.id_venta FROM ventastest\n" +
                "INNER JOIN detalle_ventas_test ON ventastest.id_venta = detalle_ventas_test.id_venta  WHERE fecha BETWEEN ? AND ?" +
                " GROUP BY id_producto HAVING COUNT(*)>=1;";
            
            miStatement = miConexion.prepareStatement(sqlConsulta);
            miStatement.setDate(1, fechaInicio);
            miStatement.setDate(2, fechaFinal);
            miResult = miStatement.executeQuery();
            
            
            while(miResult.next())
            {
                venta = new Detalle_Ventas();
                venta.setCodigo_Venta(miResult.getInt("id_venta"));
                venta.setCodigoProducto(miResult.getInt("id_producto"));
                venta.setProducto(miResult.getString("descripcion"));
                venta.setPrecio(miResult.getDouble("precio"));
                venta.setCantidad(miResult.getInt("cantidad"));
                venta.setFecha(miResult.getDate("fecha"));;

                listaVentas.add(venta);
            }

            miResult.close();
            miConexion.close();
                        
            
            return listaVentas;      
        } catch (SQLException ex) 
        {
            Logger.getLogger(Ventas_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentas;         
    }
    
    
    public static void obtenerDetalleVenta(int numeroFactura)
    {
        //List<Detalle_Ventas> listaVentas = new ArrayList<>();
        listaDetalle.clear();
        try 
        {
            miConexion = DriverManager.getConnection(url, user, password);
            Detalle_Ventas detalle;
            
//            String sqlConsulta = "SELECT ventas.id_venta, ventas.fecha, ventas.id_usuario, ventas.total, ventas.id_cliente, ventas.transporte,\n" +
//                    "detalle_ventas.id_detalle_venta, detalle_ventas.cantidad, detalle_ventas.id_venta, detalle_ventas.id_producto,\n"
//                    + "productos.descripcion, productos.precio\n"
//                    + "FROM ventas\n"
//                    + "INNER JOIN detalle_ventas \n"
//                    + "ON ventas.id_venta = detalle_ventas.id_venta\n"
//                    + "INNER JOIN productos  \n"
//                    + "ON detalle_ventas.id_producto = productos.id_producto\n"
//                    + "WHERE ventas.id_venta = ?;";
//            
//                miStatement = miConexion.prepareStatement(sqlConsulta);
//                miStatement.setInt(1, numeroFactura);
//                miResult = miStatement.executeQuery();
//            
//    
//            while(miResult.next())
//            {
//                detalle = new Detalle_Ventas();
//                detalle.setCodigo_Venta(miResult.getInt("id_venta"));
//                detalle.setCodigoProducto(miResult.getInt("id_producto"));
//                detalle.setCantidad(miResult.getInt("cantidad"));
//
//                detalleReporte = new Tiquete_venta(miResult.getInt("id_venta"), miResult.getString("descripcion"),
//                        miResult.getDouble("precio"), miResult.getInt("cantidad"),miResult.getInt("cantidad")* miResult.getDouble("precio"),
//                         0, miResult.getDouble("transporte"), miResult.getDouble("total"));
//                
//                listaDetalle.add(detalleReporte);
//            } 

            String sqlConsulta = "SELECT ventastest.id_venta, ventastest.fecha, ventastest.total, ventastest.id_usuario, ventastest.id_cliente, ventastest.nombre_usuario, ventastest.nombre_cliente, "
                    + "ventastest.telefono_cliente, ventastest.direccion_cliente, ventastest.transporte,"
                    + "detalle_ventas_test.id_producto,  detalle_ventas_test.descripcion, detalle_ventas_test.cantidad, detalle_ventas_test.precio, "
                    + "detalle_ventas_test.id_venta FROM ventastest "
                    + "INNER JOIN detalle_ventas_test ON ventastest.id_venta = detalle_ventas_test.id_venta "
                    + "WHERE ventastest.id_venta = ?";
            
                miStatement = miConexion.prepareStatement(sqlConsulta);
                miStatement.setInt(1, numeroFactura);
                miResult = miStatement.executeQuery();
            
    
            while(miResult.next())
            {
                detalle = new Detalle_Ventas();
                detalle.setCodigo_Venta(miResult.getInt("id_venta"));
                detalle.setCodigoProducto(miResult.getInt("id_producto"));
                detalle.setCantidad(miResult.getInt("cantidad"));

                detalleReporte = new Tiquete_venta(
                        miResult.getInt("id_venta"), 
                        miResult.getString("descripcion"), 
                        miResult.getString("nombre_usuario"), 
                        miResult.getString("nombre_cliente"),
                        miResult.getString("telefono_cliente"),
                        miResult.getString("direccion_cliente"),
                        miResult.getDouble("precio"), 
                        miResult.getInt("cantidad"),
                        miResult.getInt("cantidad")* miResult.getDouble("precio"),
                        miResult.getDouble("total") - miResult.getDouble("transporte"),
                        miResult.getDouble("transporte"),
                        miResult.getDouble("total"));
                
                listaDetalle.add(detalleReporte);
            } 

   
            miResult.close();
            miConexion.close();
               
            
        } catch (SQLException ex) 
        {
            Logger.getLogger(Ventas_controller.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void generaReporteVenta(String factura, String vendedor, String cliente, String telefono, String direccion) throws FileNotFoundException
    {
        //obtenerDetalleVenta(103);
        try {
            //JasperReport reporte = null;
            //String path = "src\\Reportes\\TiqueteVenta.jasper"; //src\\Reportes\\ReporteEstadistico.jasper
            
            Map parametros = new HashMap();
            parametros.put("numero_factura", factura);
            parametros.put("nombre_cliente", cliente);
            parametros.put("telefono_cliente", telefono);
            parametros.put("direccion_cliente", direccion);
            parametros.put("nombre_vendedor", vendedor);
            parametros.put("ruta_logo", this.getClass().getResourceAsStream("/Images/logo_dragon.jpg"));
            
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/TiqueteVenta.jasper"));
            
            JasperPrint jPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaDetalle));//JREmptyDataSource(
                   
            JasperPrintManager.printReport(jPrint, false);
            
            JasperViewer vistaReporte = new JasperViewer(jPrint, false);
            vistaReporte.setVisible(true);
            listaDetalle.clear();
            
            
            /********************************************************/

            JasperExportManager.exportReportToPdfFile( jPrint, "Facturas/".concat(factura.concat(".pdf")));//"src/Facturas/"+factura+".pdf");
            //guardarFacturaPDF(parametros, listaDetalle, factura);
            
            
            
                    } catch (JRException ex) {
            Logger.getLogger(Ventas_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
//    public static void generarReporteDetalleVenta(String factura, String vendedor, String cliente, String telefono, String direccion)
//    {
//        
//        try 
//        {
//            JasperReport reporte = null;
//            String path = "\\Reportes\\TestReporte"; //("/Images/ramen.png"
//
//            Map parametros = new HashMap();
//            parametros.put("numero_factura", factura);
//            parametros.put("nombre_cliente", cliente);
//            parametros.put("telefono_cliente", telefono);
//            parametros.put("direccion_cliente", direccion);
//            parametros.put("nombre_vendedor", vendedor);
//
//           JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/TestVenta.jasper"));
//            JasperPrint jPrint = JasperFillManager.fillReport(path, parametros, new JRBeanCollectionDataSource(listaDetalle));//JREmptyDataSource(
//
//            JasperViewer vistaReporte = new JasperViewer(jPrint, false);
//            vistaReporte.setVisible(true);
//            listaDetalle.clear();
//            
//          
//
//            vistaReporte.setVisible(true);           
//
//        } catch (JRException ex) {
//            Logger.getLogger(Ventas_controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
