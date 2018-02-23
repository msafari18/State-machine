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
public class secondFrame extends JFrame {

    private JLabel h;
    private JButton m;
    private JTextField[][] texts;
    private JTextField firststate, finalstate;
    int im;

    public secondFrame(int i) {
        JPanel table = new JPanel();
        JPanel okff = new JPanel();
        this.im = i;
        firststate = new JTextField("firststate");
        finalstate = new JTextField("laststate");

        h = new JLabel("enter your table :)");
        texts = new JTextField[(i + 1)][(i + 1)];
        this.setSize(400, 400);
        this.setLocation(500, 100);
        h.setFont(new Font("Afra", Font.PLAIN, 20));
        this.add(h, BorderLayout.NORTH);
        table.setLayout(new GridLayout(i + 1, i + 1));
        for (int j = 0; j < i + 1; j++) {
            for (int k = 0; k < i + 1; k++) {
                if (k == 0 && j == 0) {
                    texts[j][k] = new JTextField("state");
                    texts[j][k].setEditable(false);
                    table.add(texts[j][k]);
                } else {

                    texts[j][k] = new JTextField();
                    if (j == 0) {
                        texts[j][k].setText("" + k);
                    } else if (k == 0) {
                        texts[j][k].setText("" + j);
                    }
                    table.add(texts[j][k]);
                }
            }
        }
        this.add(table, BorderLayout.CENTER);
        m = new JButton("OK");
        okff.add(firststate, BorderLayout.NORTH);
        okff.add(finalstate, BorderLayout.CENTER);
        okff.add(m, BorderLayout.SOUTH);
        this.add(okff, BorderLayout.SOUTH);
        m.setFont(new Font("Afra", Font.PLAIN, 20));
        m.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ThirdFrame finalframe = new ThirdFrame(texts, im, firststate.getText(), finalstate.getText());
                finalframe.setVisible(true);
                setvisi();

            }
        }
        );
    }

    private void setvisi() {
        this.setVisible(false);

    }
}
