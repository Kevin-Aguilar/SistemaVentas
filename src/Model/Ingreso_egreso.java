
package Model;

import java.util.Date;

/**
 *
 * @author Kevin
 */
public class Ingreso_egreso 
{
    private int id_cierre;
    private String concepto;
    private double ingreso;
    private double egreso;
    private int codigoUsuario;
    private Date fecha;
    
    
    public Ingreso_egreso(){}
    
    public Ingreso_egreso(String concepto, double ingreso, double egreso, int codigoUsuario)
    {    
        this.concepto = concepto;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.codigoUsuario = codigoUsuario;
    }


    public void setConcepto(String concepto)
    {
        this.concepto = concepto;
    }

    public void setIngreso(double ingreso) 
    {
        this.ingreso = ingreso;
    }

    public void setEgreso(double egreso) 
    {
        this.egreso = egreso;
    }

    public void setCodigoUsuario(int codigoUsuario)
    {
        this.codigoUsuario = codigoUsuario;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }
 
    
    public void setCodigoCierre(int id_cierre)
    {
        this.id_cierre = id_cierre;
    }
    
    public String getConcepto() { return concepto; }
    public double getIngreso() { return ingreso; }
    public double getEgreso(){ return egreso; }
    public int getCodigoUsuario(){ return codigoUsuario; }
    public Date getFecha(){ return fecha; }
    public int getCodigoCierre(){ return id_cierre; }
}
