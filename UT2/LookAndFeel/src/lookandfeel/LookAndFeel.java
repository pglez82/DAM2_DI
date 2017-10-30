/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lookandfeel;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author pablo
 */
public class LookAndFeel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (LookAndFeelInfo lookAndFeel : UIManager.getInstalledLookAndFeels())
        {
            System.out.println(lookAndFeel.getName());
        }
            
    }
    
}
