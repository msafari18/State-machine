/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalp;

import GraphViz.GraphDrawer;
import GraphViz.GraphViz;
import java.io.File;

/**
 *
 * @author Monireh.S
 */
public class DrawGraph {

    static String str = "";

    public DrawGraph() {

    }

    public void draw(String name,Graph g) {
        for (int i = 0; i < g.allVertex.size(); i++) {
            for (int j = 0; j < g.allVertex.get(i).edges.printList().size(); j++) {
                for (int k = 0; k < g.allVertex.get(i).edges.printList().get(j).list.size(); k++) {
                    if (str.equals("")) {
                        str = (g.allVertex.get(i).data) + "->" + g.allVertex.get(i).edges.printList().get(j).data + "[ label = \"" + g.allVertex.get(i).edges.printList().get(j).list.get(k) + "\"];";
                    } else {
                        str = str + (g.allVertex.get(i).data) + "->" + g.allVertex.get(i).edges.printList().get(j).data + "[ label = \"" + g.allVertex.get(i).edges.printList().get(j).list.get(k) + "\"];";
                    }
                }
            }
        }
          GraphDrawer gd = new GraphDrawer();
        gd.draw(name+".", str);

    }

}
