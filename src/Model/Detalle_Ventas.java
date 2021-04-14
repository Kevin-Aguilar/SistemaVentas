/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Kevin
 */
public class Detalle_Ventas  implements Comparable<Detalle_Ventas>
{
    private int codigoDetalle_Venta;
    private int codigo_Venta;
    private int cantidad;
    private int codigoProducto;
    /*estos atributos son en test aun*/
    private String producto;
    private double precio;
    /*este atributo fecha se usa en un tipo de reporte únicamente, no para almacenar el detalle*/
    private Date fecha;
    private double ingreso;
    
    public Detalle_Ventas(){}

    public Detalle_Ventas(int codigoVenta, int cantidad, int codigoProducto)
    {
        this.codigo_Venta = codigoVenta;
        this.cantidad = cantidad;
        this.codigoProducto = codigoProducto;
    }

    public void setCodigo_Venta(int codigo_Venta) 
    {
        this.codigo_Venta = codigo_Venta;
    }

    public void setCantidad(int cantidad) 
    {
        this.cantidad = cantidad;
    }

    public void setCodigoProducto(int codigoProducto)
    {
        this.codigoProducto = codigoProducto;
    }
    
    public void setProducto(String producto)
    {
        this.producto = producto;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }
    
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
    
    public void setIngreso(double ingreso)
    {
        this.ingreso = ingreso;
    }    
    
    public int getCodigoDetalle_Ventas(){ return codigoDetalle_Venta; }
    public int getCodigo_Venta() { return codigo_Venta;}
    public int getCantidad() { return cantidad; }
    public int getCodigoProducto() { return codigoProducto; }
    public String getProducto() { return producto; }
    public double getPrecio(){ return precio;   }
    public Date getFecha() { return fecha; }
    public double getIngreso(){ return ingreso;   }

    @Override
    public int compareTo(Detalle_Ventas t) 
    {
        if(t.getCantidad() < cantidad)
            return -1;
        else if(t.getCantidad() < cantidad)
            return 0;
        else
            return 1;
    }
}
