/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenteproppersonalizada;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author pablo
 */
public class ClaseDosColores implements Serializable
{
    private Color colorFondo;
    private Color colorTexto;

    public ClaseDosColores(Color colorFondo, Color colorTexto)
    {
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
    }
    
    public Color getColorFondo()
    {
        return colorFondo;
    }

    public Color getColorTexto()
    {
        return colorTexto;
    }
}
