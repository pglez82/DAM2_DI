/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetas.dto;

/**
 *
 * @author pablo
 */
public class Planeta 
{
    private String nombre;
    private double eje;
    private double excentricidad;
    private double periodo;

    public Planeta(String nombre, double eje,  double periodo,double excentricidad) {
        this.nombre = nombre;
        this.eje = eje;
        this.excentricidad = excentricidad;
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Planeta{" + "nombre=" + nombre + ", eje=" + eje + ", excentricidad=" + excentricidad + ", periodo=" + periodo + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public double getEje() {
        return eje;
    }

    public double getExcentricidad() {
        return excentricidad;
    }

    public double getPeriodo() {
        return periodo;
    }
    
    
    public String[] toStringArray()
    {
        String[] s = new String[4];
        s[0] = nombre;
        s[1] = eje == -1 ? "" : Double.toString(eje);
        s[2] = periodo == -1 ? "" : Double.toString(periodo);
        s[3] = excentricidad == -1 ? "" : Double.toString(excentricidad);
        return s;
    }
    
    
}
