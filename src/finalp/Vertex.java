/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalp;

/**
 *
 * @author Monireh.S
 */
public class Vertex {
    
    String data;
    boolean isVisited,finalState,firstState;
    LinkedList edges;
    
    public Vertex(String data) {
        this.data = data;
        this.isVisited = false;
        this.finalState = false;
        this.firstState = false;
        edges = new LinkedList();
    }
    
    
}
