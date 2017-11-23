/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relojdigital;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author pablo
 */
public class RelojDigital extends JLabel implements Serializable
{
    /**
     * Nuestras dos propiedades
     */
    private boolean segundos;
    private Alarma alarma;
    
    /**
     * Esto son atributos (sin getters ni setters, solo para uso interno.
     */
    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private final SimpleDateFormat sdfSegundos = new SimpleDateFormat("HH:mm:ss");
    
    /**
     * Listener de nuestro componente
     */
    private AlarmaListener alarmaListener;
    
    public RelojDigital()
    {
        //Aquí  metemos el método clave. Un timer que se ejecuta cada segundo para
        //actualizar la hora.
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Date horaActual = new Date();

                //Decidimos con que formato mostramos la hora
                if (segundos)
                    setText(sdfSegundos.format(horaActual));
                else
                    setText(sdf.format(horaActual));
                
                if (alarma!=null)
                {
                    //Si la condición de la alarma se activa, llamamos al listener
                    if (alarma.isActiva() && horasCoinciden(horaActual,alarma.getHoraAlarma()))
                    {
                        if (alarmaListener!=null)
                        {
                            alarmaListener.suenaAlarma();
                        }
                    }
                }
            }
        }, 0, 1000);
    }

    public boolean isSegundos() {
        return segundos;
    }

    public void setSegundos(boolean segundos) {
        this.segundos = segundos;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }
    
    public void addAlarmaListener(AlarmaListener alarmaListener)
    {
        this.alarmaListener = alarmaListener;
    }
    
    /**
     * Método para comprobar si dos horas coinciden
     * @param horaActual 
     * @param horaAlarma
     * @return Si la diferencia entre las dos horas es menos de un segundo, devolvemos
     * true
     */
    private boolean horasCoinciden(Date horaActual, Date horaAlarma)
    {
        return horaActual.getTime()-horaAlarma.getTime()<1000;
    }
}
