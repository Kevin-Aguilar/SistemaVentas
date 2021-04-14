
package Model;

/**
 *
 * @author kevin
 */
public class Usuario
{
    private int codigo;
    private String nombre;
    private String telefono;
    private String usuario;
    private String contrasenia;
    private String tipoUsuario;

    public Usuario(){}

    
    public Usuario(int codigo, String nombre, String telefono, String usuario, String contrasenia, String tipoUsuario)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }
    
    
    
    
    public Usuario(String nombre, String telefono, String usuario, String contrasenia, String tipoUsuario)
    {
        this.nombre = nombre;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setTelefono(String Telefono)
    {
        this.telefono = Telefono;
    }
    
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }
    
    public void setContrasenia(String contrasenia)
    {
        this.contrasenia = contrasenia;
    }

    public void setTipoUsuario(String tipoUsuario) 
    {
        this.tipoUsuario = tipoUsuario;
    }

    
    public int getCodigo(){ return codigo; }
    public String getNombre(){ return nombre; }
    public String getTelefono(){ return telefono;}
    public String getUsuario(){ return usuario; }
    public String getContrasenia(){ return contrasenia; }
    public String getTipoUsuario(){ return tipoUsuario; }
        
}
