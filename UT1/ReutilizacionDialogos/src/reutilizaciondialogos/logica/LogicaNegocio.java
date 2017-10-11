/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reutilizaciondialogos.logica;

import reutilizaciondialogos.beans.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class LogicaNegocio 
{
    private List<Persona> listaPersonas;
    
    public LogicaNegocio()
    {
        listaPersonas = new ArrayList<>();
    }
    
    public void altaPersona(Persona persona)
    {
        listaPersonas.add(persona);
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }
    
    
}
