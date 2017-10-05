/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


import beans.Partido;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class LogicaAplicacion {
    private final String NOMBRE_FICHERO = "partidos.dat";
    private List<Partido> partidos = new LinkedList<>();

    public LogicaAplicacion() {
        cargarFichero();
    }

    
    public boolean altaNuevoPartido(Partido p){
        return partidos.add(p);
    }
    
    
    
    public Partido borradoPartido(int index) throws Exception{
        Partido partido = null;
        if (index<partidos.size() && index>=0)
            partido = partidos.remove(index);
        else
            System.out.println("Posicion no encontrada");
        
        return partido;
    }
    
    public List<Partido> listaPartidosOrdenados(String metodo){
        LinkedList<Partido> copia = new LinkedList<>(partidos);
        if(metodo.equals("ascendente")){
            Collections.sort(copia);
        }
        else{
            Collections.sort(copia,new Comparator<Partido>() {
                @Override
                public int compare(Partido o1, Partido o2) {
                    return o2.getFecha().compareTo(o1.getFecha());
                }
            });
        }
        return copia;
    }
    
    public List<Partido> listaPartidosDivision(Partido.Divisiones d){
        List<Partido> partidosDivision = new ArrayList<>();
        for (Partido partido : partidos) {
            if(partido.getDivision().equals(d)){
                partidosDivision.add(partido);
            }
        }
        return partidosDivision;
    }
    
    private void cargarFichero(){
        File f = new File(NOMBRE_FICHERO);
        if(f.exists())
        {
            FileInputStream fis = null;
            ObjectInputStream oos = null;
            LinkedList<Partido> ps = null;

            try{

                fis = new FileInputStream(NOMBRE_FICHERO);
                oos = new ObjectInputStream(fis);
                ps = (LinkedList<Partido>) oos.readObject();
                partidos = ps;

            } catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            finally{
                try {
                    oos.close();
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(ObjectInput.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void guardarEnFichero(){
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO,true) );
            oos.writeObject(partidos);
        }catch(EOFException e){
            System.out.println(e.getMessage());
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            try {
                oos.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
          
        }
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
}