
package Model;

import java.io.Serializable;

/**
 *
 * @author Kevin
 */
public class Email implements Serializable
{
    String direccion;
    String contrasenia;
    
    public Email(){ }
    
    public Email(String direccion, String contrasenia)
    { 
        this.direccion = direccion;
        this.contrasenia = contrasenia;   
   }


    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public void setContrasenia(String contrasenia)
    {
        this.contrasenia = contrasenia;
    }
  
    public String getDireccion() {return direccion;}
    public String getContrasenia() {return contrasenia;}    
}
