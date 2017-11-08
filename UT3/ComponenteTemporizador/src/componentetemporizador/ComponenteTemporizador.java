/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentetemporizador;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author pablo
 */
public class ComponenteTemporizador extends JLabel implements Serializable
{
    private int numSegundos;
    private int contador;
    
    public ComponenteTemporizador()
    {
        
    }

    public int getNumSegundos()
    {
        return numSegundos;
    }

    public void setNumSegundos(int numSegundos)
    {
        this.numSegundos = numSegundos;
        setText(Integer.toString(numSegundos));
        cuentaAtras();
    }
    
    private void cuentaAtras()
    {
        contador = numSegundos;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run()
            {
                if (contador>=0)
                {
                    setText(Integer.toString(contador--));
                }
                else
                {
                    this.cancel();
                }
            }
        }, 0, 1000);
    }
    
}
