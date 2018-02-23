/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Monireh.S
 */
public class FirstFrame extends JFrame{
    JTextField m;
    JButton ok;
    JLabel h;
    public FirstFrame(){
        
        this.setLayout(null);
        this.setSize(250,200);
        this.setLocation(500, 300);
        h = new JLabel("enter number of vertex here");
        h.setSize(150,20);
        h.setLocation(30,30);
        this.add(h);
        m = new JTextField();
        m.setSize(80,25);
        m.setLocation(30,70);
        this.add(m);
        ok = new JButton("OK");
        ok.setSize(60,20);
        ok.setLocation(30,120);
        this.add(ok);
       
        ok.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int mo = 0;
                if(m.getText() != null )
                     mo = Integer.parseInt(m.getText());
                secondFrame mon = new secondFrame(mo);
                mon.setVisible(true);
                setvisi();
                
            }
        }
        );
    }
    
    private void setvisi (){
        this.setVisible(false);
    }
    
}
