/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relojdigital;

import java.awt.Component;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pablo
 */
public class AlarmaPropertyEditorSupport extends PropertyEditorSupport
{
    /**
     * Hay que declarar aquí esta instancia porque la usamos para varios métodos.
     */
    private AlarmaPanel alarmaPanel = new AlarmaPanel();
    
    /**
     * Este método tiene que devolver true siempre si queremos que haya un editor
     * de propiedades personalizado
     * @return true
     */
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    /**
     * Este método devuelve una instancia del panel a mostrar.
     * @return panel a mostrar
     */
    @Override
    public Component getCustomEditor() {
        return alarmaPanel;
    }

    /**
     * En este método nos tenemos que arreglar para devolver un string que inicialize
     * la propiedad y que irá insertado en el setter dentro del initcomponents.
     * @return un string con la propiedad inicializada
     */
    @Override
    public String getJavaInitializationString() {
        Date horaAlarma = alarmaPanel.getSelectedValue().getHoraAlarma();
        boolean activa = alarmaPanel.getSelectedValue().isActiva();
        return "new relojdigital.Alarma(new java.util.Date("+horaAlarma.getTime()+"l),"+activa+")";
    }

    /**
     * Recuperamos el valor del panel y lo devolvemos.
     * @return 
     */
    @Override
    public Object getValue() {
        return alarmaPanel.getSelectedValue();
    }

    
    /**
     * Este método lo añado aunque no es necesario. Se encarga de mostrar un texto en la paleta de netbeans con el valor
     * de la propiedad en forma de texto. Devuelvo la fecha y hora formateada y si está activa o no para que el programador
     * que use el componente pueda verlo bien.
     * @return valor de la propiedad en string
     */
    @Override
    public String getAsText() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy - hh:mm");
        //Os he añadido aquí un if comprimido con ? y : . Es bastante interesante para casos como este.
        return sdf.format(alarmaPanel.getSelectedValue().getHoraAlarma()) + " [" + 
                 (alarmaPanel.getSelectedValue().isActiva() ? "Activa" : "Inactiva") + "]"; //To change body of generated methods, choose Tools | Templates.
    }
}
