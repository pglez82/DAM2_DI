/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracttablemodelexample.beans;

/**
 *
 * @author pablo
 */
public class Alumno 
{
    private String nombre;
    private String curso;

    public Alumno(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }
    
    
}
