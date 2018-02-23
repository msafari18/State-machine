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
public class Stack {

    public ArrayList<Vertex> stack;
    int top = 0;

    public Stack() {
        stack = new ArrayList<>();
    }

    /**
     *
     * @param cmd the string that must be pushed into stack
     */
    public void push(Vertex node) {
        if (!node.equals("")) {
            stack.add(node);
            top++;
        }
    }

    /**
     *
     * @return last string in stack
     */
    public Vertex pop() {
        if (!isEmpty()) {
            top--;
            return stack.remove(top);
        } else {
            return null;
        }
    }

    /**
     *
     * @return true if linkedList is empty , false if it isn't
     */
    public boolean isEmpty() {
        if (top == 0) {
            return true;
        }
        return false;

    }

    public boolean contain(String node) {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).data.equals(node)) {
                return true;
            }
        }
        return false;
    }
}
