
package Model;

/**
 *
 * @author Kevin
 */
public class Tiquete_venta 
{
    private int codigo;
    private String descripcion;
    private String vendedor;
    private String cliente;
    private String telCliente;
    private String dirCliente;
    private double precio;
    private int cantidad;
    private double total;
    private double totalPagar;
    private double transporte;
    private double subtotal;

    
    public Tiquete_venta(){}

    public Tiquete_venta(int codigo, String descripcion, String vendedor, String cliente, String telCliente, String dirCliente, double precio, int cantidad, double total, double subtotal, double transporte ,double totalPagar ) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.telCliente = telCliente;
        this.dirCliente = dirCliente;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.totalPagar = totalPagar;
        this.transporte = transporte;
        this.subtotal = subtotal;
    }
    
    
    
    
    public Tiquete_venta( int codigo, String descripcion, double precio, int cantidad, double total, double subtotal, double transporte, double totalPagar)
    {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.subtotal = subtotal;
        this.transporte = transporte;
        this.totalPagar = totalPagar;
    }


    public void setTotalPagar(double totalPagar) 
    {
        this.totalPagar = totalPagar;
    }

    public void setTransporte(double transporte) 
    {
        this.transporte = transporte;
    }


    public void setSubtotal(double subtotal) 
    {
        this.subtotal = subtotal;
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

    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }
    
    public void setTotal(double total)
    {
        this.total = total;
    }

    public String getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(String telCliente) {
        this.telCliente = telCliente;
    }

    public String getDirCliente() {
        return dirCliente;
    }

    public void setDirCliente(String dirCliente) {
        this.dirCliente = dirCliente;
    }
    
    
    
    public int getCodigo(){ return codigo; }
    public String getDescripcion(){ return descripcion; }
    public double getPrecio(){ return precio; }    
    public int getCantidad(){ return cantidad;}
    public double getTotal(){ return total;}    
    public double getSubtotal(){ return subtotal;}
    public double getTotalPagar(){ return totalPagar;}        
    public double getTransporte(){ return transporte;}
    public String getVendedor(){ return vendedor;}
    public String getCliente(){ return cliente;}
}
