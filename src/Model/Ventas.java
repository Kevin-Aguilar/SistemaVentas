
package Model;

import java.util.Date;


/**
 *
 * @author Kevin
 */
public class Ventas implements Comparable<Ventas>
{
    private Detalle_Ventas detalle;
    private int codigoVenta;
    private double total;
    private double transporte;
    private int codigoCliente;
    private int codigoUsuario;
    /***********************************/
    private String nombreUsuario;
    private String nombreCliente;
    private String telCliente;
    private String dirCliente;
    
    
    private Date fecha;
    
    public Ventas()
    {     }

    public Ventas( double total, int codigoCliente, String telCliente, String dirCliente , int codigoUsuario, Date fecha) 
    {
        this.total = total;
        this.codigoCliente = codigoCliente;
        this.telCliente = telCliente;
        this.dirCliente = dirCliente;
        this.codigoUsuario = codigoUsuario;
        this.fecha = fecha;
    }

    
    
    public Ventas(int codigoVenta, Detalle_Ventas detalle, double total, int codigoCliente, int codigoUsuario) 
    {
        this.codigoVenta = codigoVenta;
        this.detalle = detalle;
        this.total = total;
        this.codigoCliente = codigoCliente;
        this.codigoUsuario = codigoUsuario;
    }

    
    public void setCodigoVenta(int codigoVenta)
    {
        this.codigoVenta = codigoVenta;
    }

    public void setDetalle(Detalle_Ventas detalle)
    {
        this.detalle = detalle;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public void setCodigoCliente(int codigoCliente) 
    {
        this.codigoCliente = codigoCliente;
    }

    public void setCodigoUsuario(int codigoUsuario) 
    {
        this.codigoUsuario = codigoUsuario;
    }
    
    public void setFecha(Date fecha) 
    {
        this.fecha = fecha;
    }   
    
    public void setTransporte(double transporte)
    {
        this.transporte = transporte;
    }
    
    public void setNombreUsuario(String nombre)
    {
        this.nombreUsuario = nombre;
    }
    
    public void setNombreCliente(String nombreC)
    {
        this.nombreCliente = nombreC;
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
    
    
    public int getCodigoVenta(){ return codigoVenta; }
    public Detalle_Ventas getDetalle() { return detalle; }
    public double getTotal() { return total; }
    public int getCodigoCliente() { return codigoCliente; } 
    public int getCodigoUsuario() { return codigoUsuario; }    
    public Date getFecha() { return fecha; } 
    public double getTransporte() { return transporte; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getNombreCliente() { return nombreCliente; }

    public int compareTo(Ventas t) 
    {
        if(t.getCodigoVenta() < codigoVenta)
            return -1;
        else if(t.getCodigoVenta() < codigoVenta)
            return 0;
        else
            return 1;
    }
}
