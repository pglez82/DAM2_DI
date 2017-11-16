/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenteproppersonalizada;

import java.awt.Component;
import java.beans.PropertyEditorSupport;



/**
 *
 * @author pablo
 */
public class ColoresPropertyEditorSupport extends PropertyEditorSupport
{
    private ColoresPanel coloresPanel = new ColoresPanel();
    
    @Override
    public boolean supportsCustomEditor()
    {
        return true;
    }

    @Override
    public Component getCustomEditor()
    {
        return coloresPanel;
    }

    @Override
    public String getJavaInitializationString()
    {
        ClaseDosColores propiedad = coloresPanel.getPropiedadSeleccionada();
        return "new componenteproppersonalizada.ClaseDosColores(new java.awt.Color("+
                propiedad.getColorFondo().getRGB()+
                "),new java.awt.Color("+
                propiedad.getColorTexto().getRGB()+"))";
    }

    @Override
    public Object getValue()
    {
        return coloresPanel.getPropiedadSeleccionada();
    }
    
}
