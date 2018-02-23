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
public class LinkedList {
    
    Link firstNode;
    Link current,head;
    ArrayList<Link> print = new ArrayList<>();
    int size = 0;

    public LinkedList() {
        head = new Link("");
        head.nextLink = firstNode;
    }

    /**
     *
     * @param data an String that should add to linked list
     * @param line line of the word
     * @param word  which word of list 
     */
    public void insert(Link datalink) {
        
        if (current == null) {
            current = this.firstNode;
        }
        if (this.firstNode == null) {
            this.firstNode = datalink;
            this.current = this.firstNode;
            size++;
        } else {
            if (checkadd(datalink.data) == null) {
                int i = 0;
                try {
                    if (this.current.nextLink == null) {
                        this.current.nextLink = datalink;
                        size++;
                    } else {
                        this.current = this.current.nextLink;
                        this.insert(datalink);
                    }
                } catch (NullPointerException x) {
                    System.out.println("error");
                }
            }
        }
    }

    /**
     *
     * @param data this data must be deleted from linked list
     */
    public void del(String data){
        current = firstNode;
        del1(data);
    }
    private void del1(String data) {
        if (this.firstNode.data.equals(data)) {
            this.firstNode = this.firstNode.nextLink;
            size--;
            return ;
        } else if (current.nextLink == null) {
            return ; 
        } else {
           if(current.nextLink.data.equals(data)){
               current.nextLink = current.nextLink.nextLink;
               size--;
               return;
           }
           current = current.nextLink; 
           del1(data);
        }
    }

    /**
     *
     * @return true if linkedList is empty , false if it isn't
     */
    public boolean isEmpty() {
        return this.firstNode == null;
    }

    /**
     * add every node to an array list to print it 
     */
    public ArrayList<Link> printList() {
        print.clear();
        for (this.current = this.firstNode; this.current != null; this.current = this.current.nextLink) {
           
            print.add(current);
            }
        return print;

    }

    /**
     *
     * @param file name of the string that user want to find
     */
    public void checkList(String file) {

        for (this.current = this.firstNode; this.current != null; this.current = this.current.nextLink) {
            if (current.data.equals(file)) {
                del(current.data);
                return;
            }
        }

    }

    
    /**
     * check the list and find a string
     * @param fileName the string that user want
     * @return a node that involve this string , null if this node doesn't exit
     */
    public Link checkadd(String fileName) {
        Link fCur = firstNode;
        for(int i = 0;i < size ; i++){
                if(fileName.equals(fCur.data)){
                    return fCur;
                }
            fCur = fCur.nextLink;
        }
        return null;
     }  

    
    
}
