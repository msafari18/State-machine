/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalp;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Monireh.S
 */
public class ThirdFrame extends JFrame {

    private JLabel h;
    private JButton m1,m2,m3,m4;
    private JTextField[][] texts;
    private JTextField firststate, finalstate;
    int im;

    public ThirdFrame(JTextField[][] graph, int numve, String firststate, String finalstate) {
        final Graph g = new Graph(graph, numve, firststate, finalstate);
       // DrawGraph.draw(g);
        JPanel table = new JPanel();
        JPanel okff = new JPanel();

        h = new JLabel("the adjacent table :)");
        texts = new JTextField[(numve + 1)][2];
        this.setSize(400, 400);
        this.setLocation(500, 100);
        h.setFont(new Font("Afra", Font.PLAIN, 15));
        this.add(h, BorderLayout.NORTH);
        table.setLayout(new GridLayout(numve + 1, 2));
        
        for (int j = 0; j < numve + 1; j++) {
            for (int k = 0; k < 2; k++) {
                if (k == 0 && j == 0) {
                    texts[j][k] = new JTextField("state");
                    texts[j][k].setEditable(false);
                    table.add(texts[j][k]);
                } else if (k == 1 && j == 0) {
                    texts[j][k] = new JTextField("adjacent");
                    texts[j][k].setEditable(false);
                    table.add(texts[j][k]);
                } else if (k == 0) {
                    if(g.allVertex.get(j - 1).firstState)
                        texts[j][k] = new JTextField(g.allVertex.get(j - 1).data + "start");
                    else    
                        texts[j][k] = new JTextField(g.allVertex.get(j - 1).data);
                    
                    table.add(texts[j][k]);
                } else if (k != 0 && j != 0) {
                    String m = "";
                    for (int p = 0; p < g.allVertex.get(j - 1).edges.printList().size(); p++) {
                        for (int o = 0; o < g.allVertex.get(j - 1).edges.printList().get(p).list.size(); o++) {
                            m = m + "(" + g.allVertex.get(j - 1).edges.printList().get(p).data + "," + g.allVertex.get(j - 1).edges.printList().get(p).list.get(o) + "),";
                        }
                    }
                    texts[j][k] = new JTextField(m);
                    table.add(texts[j][k]);

                }
            }
            
        }
        this.add(table, BorderLayout.CENTER);
            m1 = new JButton("find loop");
            okff.add(m1);
            m2 = new JButton("delet loop");
            okff.add(m2);
            m3 = new JButton("draw graph");
            okff.add(m3);
            m4 = new JButton("check string");
            okff.add(m4);
            okff.setLayout(new GridLayout(1,4));
            this.add(okff, BorderLayout.SOUTH);
            m1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int findLoop = g.findLoop(0);
                    ForthFrame m = new ForthFrame(1,findLoop);
                    m.setVisible(true);
                }
            }
            );

            m2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int findLoop = g.findLoop(1);
                    ForthFrame m = new ForthFrame(2);
                    m.setVisible(true);
                
                }
                
            }
            );
            
            m3.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                  
                    ForthFrame m = new ForthFrame(3,g);
                    m.setVisible(true);
                
                }
            }
            );
            
            m4.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                ForthFrame m = new ForthFrame(4,g);
                    m.setVisible(true);
                    
                }
            }
            );
            
    }
}
