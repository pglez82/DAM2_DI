/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenteproppersonalizada;

import java.io.Serializable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author pablo
 */
public class ComponentePropPersonalizada extends JTextField implements Serializable
{
    private ClaseDosColores colores;
    private int numCaracteres;
    
    public ComponentePropPersonalizada()
    {
        getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                analizaCambios();
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                analizaCambios();
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                analizaCambios();
            }
        });
    }
    
    public void analizaCambios()
    {
        if (getText().length()>numCaracteres)
        {
            setBackground(colores.getColorFondo());
            setForeground(colores.getColorTexto());
        }
    }

    public ClaseDosColores getColores()
    {
        return colores;
    }

    public void setColores(ClaseDosColores colores)
    {
        this.colores = colores;
    }

    public int getNumCaracteres()
    {
        return numCaracteres;
    }

    public void setNumCaracteres(int numCaracteres)
    {
        this.numCaracteres = numCaracteres;
    }
    
    
        
}
