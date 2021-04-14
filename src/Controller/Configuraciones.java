
package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class Configuraciones 
{
    public static final String ARCHIVO = "C:\\Users\\Kevin\\Documents\\NetBeansProjects\\SistemaVentas\\src\\Configuracion\\config.properties";


    public static void escrituraArchivoPropiedades() 
    {
        try//(OutputStream salida = new FileOutputStream(ARCHIVO))
        {
            Properties propiedades = new Properties();
            
            propiedades.setProperty("correoNegocio", "comidachina.eldragon@gmail.com");
            propiedades.setProperty("contraseñaCorreo", "comidachina");
            
            propiedades.store(new FileWriter(ARCHIVO), null);
            
            System.out.println(propiedades);
        } catch (FileNotFoundException ex) {
            System.out.println("no se encontró el archivo "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ocurrió un error al abrir el archivo "+ex.getMessage());
        }
    }
    
    
    public static void leer()
    {
        try//(InputStream lectura = new FileInputStream(ARCHIVO))
        {
            //OutputStream salida = new FileOutputStream(ARCHIVO);
            Properties propiedades = new Properties();
            
            propiedades.load(new FileReader(ARCHIVO));
            
            System.out.println("correo del comercio: "+propiedades.getProperty("correoNegocio"));
            System.out.println("contraseña: "+propiedades.getProperty("contraseñaCorreo")); 
            
            
            System.out.println("Editando archivo");
//            
            //propiedades.setProperty("correoNegocio", "kevin.ab14@hotmail.com");
            propiedades.replace("correoNegocio", "kevin.ab14@hotmail.com");
//            
//            System.out.println(propiedades);
            propiedades.store(new FileWriter(ARCHIVO), "se ha cambiado el correo");
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
