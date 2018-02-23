/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.JTextField;

/**
 *
 * @author Monireh.S
 */
public class Graph {

    ArrayList<Vertex> allVertex;
    JTextField[][] vertexedge;
    int numve = 0;
    String[] finalstate;
    String[] firststate;
    ArrayList<String> finalstate1 = new ArrayList<>();
    ArrayList<String> firststate1 = new ArrayList<>();

    public Graph(JTextField[][] vertex, int i, String firststate, String finalstate) {
        numve = i;
        this.allVertex = new ArrayList<>();
        this.vertexedge = vertex;
        this.finalstate = finalstate.split(",");
        this.firststate = firststate.split(",");
        firststate1.add(this.firststate[0]);
        for (int k = 0; k < this.finalstate.length; k++) {
            finalstate1.add(this.finalstate[k]);
        }
        add();
        for (int l = 0; l < allVertex.size(); l++) {
            if (allVertex.get(l).firstState) {
                Collections.swap(allVertex, 0, l);
            }
        }

    }

    public void add() {
        int k = 0;
        for (int i = 1; i <= numve; i++) {

            Vertex curvertex = new Vertex(vertexedge[i][0].getText());
            if (finalstate1.contains(vertexedge[i][0].getText())) {
                curvertex.finalState = true;
            }
            if (firststate1.contains(vertexedge[i][0].getText())) {
                curvertex.firstState = true;
            }

            for (k = 1; k <= numve; k++) {
                if (!vertexedge[i][k].equals("_")) {
                    String[] line = vertexedge[i][k].getText().split(",");
                    if (line[0].equals("_")) {
                    } else {
                        Link ver = new Link(vertexedge[0][k].getText());

                        for (int p = 0; p < line.length; p++) {
                            ver.list.add(line[p]);
                        }
                        curvertex.edges.insert(ver);
                    }
                }
            }
            allVertex.add(curvertex);
        }
    }

    public int findLoop(int n) {
        int x = 0;
        x = DFS(n, allVertex.get(0));
    return x ;
}

public boolean findString(String m1) {
        xs.clear();
        return findString1(m1, 0, 0);
    }

    private int DFS(int n, Vertex m1) {
        int x = 0;
        Stack s = new Stack();

        s.push(m1);

        while (!s.isEmpty()) {
            Vertex v = s.pop();
            if (!v.isVisited) {
                v.isVisited = true;
                for (int j = 0; j < v.edges.printList().size(); j++) {
                    for (int m = 0; m < allVertex.size(); m++) {
                        if (v.edges.printList().get(j).data.equals(allVertex.get(m).data)) {
                            if (!allVertex.get(m).isVisited) {
                                s.push(allVertex.get(m));
                            } else {
                                x++;
                                if (n == 1) {
                                    v.edges.printList().get(j).list.clear();
                                }
                            }
                        }

                    }

                }
            }
        }
        return x;

    }

    ArrayList<Integer> xs = new ArrayList<>();

    public boolean findString1(String s, int count, int h1) {
        int x = h1;
        xs.clear();
        if (count >= s.length()) {
            return true;
        }

        char cs;
        cs = s.charAt(count);
        for (int i = 0; i < allVertex.get(x).edges.printList().size(); i++) {
            for (int j = 0; j < allVertex.get(x).edges.printList().get(i).list.size(); j++) {
                if (allVertex.get(x).edges.printList().get(i).list.get(j).charAt(0) == (cs)) {
                    for (int k = 0; k < allVertex.size(); k++) {
                        if (!allVertex.get(x).edges.printList().isEmpty()) {
                            if (allVertex.get(k).data.equals(allVertex.get(x).edges.printList().get(i).data)) {
                                xs.add(k);
                            }
                        }
                    }
                }

            }
        }
        count++;
        for (int h = 0; h < xs.size(); h++) {
            int flag = 0;
            if (count == s.length()) {
                if (allVertex.get(xs.get(h)).finalState) {
                    return findString1(s, count, xs.get(h));
                }
            } else {
                return findString1(s, count, xs.get(h));
            }
        }
        return false;
    }

}
