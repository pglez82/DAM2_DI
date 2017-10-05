/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import utils.Utils;

/**
 *
 * @author alumno
 */
public class Partido implements Serializable, Comparable<Partido>{
    private String eqLocal,eqVisitante, resultado;
    private Divisiones division;
    private Date fecha;
    public enum Divisiones {
        PRIMERA,SEGUNDA,TERCERA
    }

    public Partido(String eqLocal, String eqVisitante, String resultado, Divisiones division, Date fecha) {
        this.eqLocal = eqLocal;
        this.eqVisitante = eqVisitante;
        this.resultado = resultado;
        this.division = division;
        this.fecha = fecha;
    }

    public String getEqLocal() {
        return eqLocal;
    }

    public void setEqLocal(String eqLocal) {
        this.eqLocal = eqLocal;
    }

    public String getEqVisitante() {
        return eqVisitante;
    }

    public void setEqVisitante(String eqVisitante) {
        this.eqVisitante = eqVisitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Divisiones getDivision() {
        return division;
    }

    public void setDivision(Divisiones division) {
        this.division = division;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Partido{" + "eqLocal=" + eqLocal + ", eqVisitante=" + eqVisitante + ", resultado=" + resultado + ", division=" + division + ", fecha=" + Utils.sdf.format(fecha) + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partido other = (Partido) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Partido o) {
        return this.fecha.compareTo(o.fecha);
    }
    
    
}
