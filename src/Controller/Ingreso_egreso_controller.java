
package Controller;

import Model.Ingreso_egreso;
import java.sql.Connection;
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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kevin
 */
public class Ingreso_egreso_controller
{
    private static Connection miConexion = null;
    private static PreparedStatement miStatement = null;
    private static ResultSet miResult = null;
    private static String url = "jdbc:mysql://localhost:3306/sistemaventas?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = "12345";
    
    
    public static List<Ingreso_egreso> listaConceptos = new ArrayList<>();
    public static Ingreso_egreso conceptos;
    
    
    
    public static boolean guardarConcepto(Ingreso_egreso conceptos)
    {
        boolean estado = false;
        
        try
        {
            miConexion = DriverManager.getConnection(url, user, password);

        
                String sqlGuardar = "INSERT INTO cierre(fecha, ingreso, egreso, concepto, id_usuario) values(curdate(),?,?,?,?)";

                miStatement = miConexion.prepareStatement(sqlGuardar);
                //miStatement.setInt(1, cliente.getCodigo());
                miStatement.setDouble(1, conceptos.getIngreso()); 
                miStatement.setDouble(2, conceptos.getEgreso());
                miStatement.setString(3, conceptos.getConcepto());
                miStatement.setInt(4, conceptos.getCodigoUsuario());
                miStatement.execute();

                estado = true;
                miConexion.close();

                return estado;                  
       } catch (SQLException ex) 
      {   System.out.println(ex.getStackTrace()); }  
         return estado;        
    }   
    
    
    
    public static boolean eliminarConcepto(Ingreso_egreso conceptos)
    {
        boolean estado = false;
        
            try
            {            
                miConexion = DriverManager.getConnection(url, user, password);            

                String sqlConsulta = "DELETE FROM cierre WHERE id_cierre = ?";

                miStatement = miConexion.prepareStatement(sqlConsulta);
                miStatement.setInt(1, conceptos.getCodigoCierre());
                miStatement.execute();

                estado = true;
                miConexion.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            } 
            
        return estado;        
    }   
    
   
    public static List<Ingreso_egreso> listarConceptos()
    {
        List<Ingreso_egreso> listaConceptos = new ArrayList<>();
        
        try 
        {
            miConexion = DriverManager.getConnection(url, user, password);
            Ingreso_egreso conceptos;
            
            String sqlConsulta = "SELECT * FROM cierre WHERE fecha = curdate()";
            
            miStatement = miConexion.prepareStatement(sqlConsulta);
            //miStatement.setString(1, fecha);
            miResult = miStatement.executeQuery();
            
            
            while(miResult.next())
            {
                conceptos = new Ingreso_egreso();
                conceptos.setCodigoCierre(miResult.getInt("id_cierre"));
                conceptos.setFecha(miResult.getDate("fecha"));
                conceptos.setIngreso(miResult.getDouble("ingreso"));
                conceptos.setEgreso(miResult.getDouble("egreso"));
                conceptos.setConcepto(miResult.getString("concepto"));
                conceptos.setCodigoUsuario(miResult.getInt("id_usuario"));

                listaConceptos.add(conceptos);
            } 
            
            miResult.close();
            miConexion.close();
            
            return listaConceptos;      
        } catch (SQLException ex) 
        {
            Logger.getLogger(Ingreso_egreso_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaConceptos;         
    }    
    
    
    public void generaReporteCierre(String vendedor, double ingresoConceptos, double ingresoVentas, double totalIngresos, double totalSalidas)
    {
        //obtenerDetalleVenta(103);
        try {
            //JasperReport reporte = null;
            //String path = "src\\Reportes\\ReporteCierre.jasper";
            
            Map parametros = new HashMap();
            parametros.put("nombre_vendedor", vendedor);
            parametros.put("ingresoConceptos", ingresoConceptos);
            parametros.put("ingresoVentas", ingresoVentas);
            parametros.put("totalIngresos", totalIngresos);
            parametros.put("totalEgresos", totalSalidas);

            
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteCierre.jasper"));
            
            JasperPrint jPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaConceptos));//JREmptyDataSource(
                    
            JasperViewer vistaReporte = new JasperViewer(jPrint, false);
            vistaReporte.setVisible(true);
            listaConceptos.clear();
            listaConceptos.add(conceptos);
            
            } catch (JRException ex) {
            Logger.getLogger(Ventas_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
