
package Model;

/**
 *
 * @author kevin
 */
public class Producto
{
    private int codigo;
    private String descripcion;
    private double precio;
    private double precio_UberEats;

    
    public Producto(){}
    
    public Producto(int codigo, String descripcion, double precio)
    {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public Producto(int codigo, String descripcion, double precio, double precioUberEats)
    {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precio_UberEats = precioUberEats;
    }
    
    
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public void setPrecioUberEats(double precioUberEats)
    {
        this.precio_UberEats = precioUberEats;
    }
    public int getCodigo(){ return codigo; }
    public String getDescripcion(){ return descripcion; }
    public double getPrecio(){ return precio; }
    public double getPrecioUberEats(){ return precio_UberEats; }      
}
