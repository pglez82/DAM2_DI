/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package festexample2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pablo
 */
public class Vehiculo 
{
    private String nombrePropietario;
    private String apellidosPropietario;
    private String dniPropietario;
    private String telefonoPropietario;
    
    private String modelo;
    private String matricula;
    private Date fechaEntrada;
    private String tipoVehiculo;
    
    
    //Solo para camiones. La solución adecuada sería haciendo una clase diferente
    //llamada "Camion" que extendiese de ésta, solo con los dos datos nuevos (longitud
    //y mercancías peligrosas. En este caso, para no complicar el programa, lo añado
    //aquí en la misma clase Vehículo
    private Integer longitud;
    private Boolean mercanciasPeligrosas;

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getApellidosPropietario() {
        return apellidosPropietario;
    }

    public void setApellidosPropietario(String apellidosPropietario) {
        this.apellidosPropietario = apellidosPropietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public String getTelefonoPropietario() {
        return telefonoPropietario;
    }

    public void setTelefonoPropietario(String telefonoPropietario) {
        this.telefonoPropietario = telefonoPropietario;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public Boolean getMercanciasPeligrosas() {
        return mercanciasPeligrosas;
    }

    public void setMercanciasPeligrosas(Boolean mercanciasPeligrosas) {
        this.mercanciasPeligrosas = mercanciasPeligrosas;
    }
    
    /**
     * Devuelve la representación para la tabla de la pantalla inicial.
     * El array devuelto se utiliza para representarlo en una tabla como una fila.
     * Vamos a devolver un array de tres posiciones por lo tanto la tabla tendrá
     * tres columnas.
     * @return Array de strings con tres posiciones, conteniendo la mátricula,
     * el modelo y la fecha de entrada.
     */
    public String[] getTableRepresentation()
    {
        //Para formatear la fecha al formato deseado
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String[] rep = new String[3];
        rep[0]=matricula;
        rep[1]=modelo;
        rep[2]=sdf.format(fechaEntrada);
        return rep;
    }
}
