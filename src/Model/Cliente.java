
package Model;

/**
 *
 * @author kevin
 */
public class Cliente
{
    private int codigo;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private boolean credito;

    
    public Cliente(){}
    
    public Cliente(int codigo, String nombre, String telefono, String direccion, boolean credito)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.credito = credito;
    }
    
    public Cliente( int codigo, String nombre, String telefono, String direccion, String email)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }
    
    public Cliente( int codigo, String nombre, String telefono, String direccion)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    
    public Cliente(String nombre, String telefono, String direccion)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public Cliente( String nombre, String telefono, String direccion, String email)
    {
        //this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }


    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }
        
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }
     
    public void setCredito(boolean credito)
    {
        this.credito = credito;
    }
     
    
    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getCodigo(){ return codigo; }   
    public String getNombre(){ return nombre; }
    public String getTelefono(){ return telefono; }
    public String getDireccion(){ return direccion; }
    public boolean getCredito(){ return credito; }
    public String getEmail(){ return email; }

}
