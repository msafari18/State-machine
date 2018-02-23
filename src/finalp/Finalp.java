/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalp;

import GraphViz.GraphDrawer;
import GraphViz.GraphViz;
import javax.swing.UIManager;

/**
 *
 * @author Monireh.S
 */
public class Finalp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        FirstFrame moni = new FirstFrame();
        moni.setVisible(true);
        moni.setDefaultCloseOperation(moni.EXIT_ON_CLOSE);
         try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
          moni.setResizable(false);
        // TODO code application logic here
    }
    
    
    
}
