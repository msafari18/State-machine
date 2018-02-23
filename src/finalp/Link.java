/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalp;

import java.util.ArrayList;

/**
 *
 * @author Monireh.S
 */
public class Link {
    
    String data;
    Link nextLink;
    ArrayList <String> list;
    public Link(String data) {
        this.list = new ArrayList<>();
        this.data = data;
        this.nextLink = null;
    }
    
    
    
}
