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
public class ForthFrame extends JFrame {

    JTextField m;
    JButton ok, okk;
    JLabel h;

    public ForthFrame(int k) {
        setComponent(0);

        h.setText("DEL LOOP");
        if (k == 2) {
            m.setText("FINISH");
        } else {
            m.setText("");
        }
    }

    public ForthFrame(final int k, final Graph g) {
        setComponent(0);
        String str;
        okk = new JButton("ok");
        this.add(okk);
        okk.setSize(60, 20);
        okk.setLocation(30, 130);
        if(k == 4)
            h.setText("write the string here");
                    
        else if(k == 3)
                h.setText("write a name for picture file");
                    
        okk.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (k == 4) {
                    if (m.getText() != null) {
                        m.setText(g.findString(m.getText())+"");
                    }
                }
                if (k == 3) {
                    if (m.getText() != null) {
                        DrawGraph m1 = new DrawGraph();
                        m1.draw(m.getText(), g);
                    }
                }
            }
        }
        );

    }

    public ForthFrame(int k, int l) {
        setComponent(1);
        if (l != 0) {
            h.setText("it has loop");
        }
        //m.setText(""+l);
    }

    private void setvisi() {
        this.setVisible(false);
    }

    private void setComponent(int kk) {
        this.setLayout(null);
        this.setSize(250, 200);
        this.setLocation(500, 300);
        h = new JLabel("");
        h.setSize(150, 20);
        h.setLocation(30, 30);
        this.add(h);
        m = new JTextField();
        m.setSize(80, 25);
        m.setLocation(30, 70);
        if(kk == 1)
            this.add(m);
        ok = new JButton("back");
        ok.setSize(60, 20);
        ok.setLocation(30, 100);
        this.add(ok);

        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setvisi();
            }
        }
        );
    }
}
