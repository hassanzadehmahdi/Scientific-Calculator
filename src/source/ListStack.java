/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *
 * @author mahdi
 */
import java.util.ArrayList;

public class ListStack<X> {

    private final ArrayList<X> list;

    public ListStack() {
        list = new ArrayList<X>();
    }

    public void push(X item) {
        list.add(item);
    }

    public X pop() {
        if (list.size() == 0) {
//            throw new IllegalStateException("Stack is empty");
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public boolean contains(X item) {
        return list.contains(item);
    }

    public X access(X item) {
        try {
            while (true) {
                if (item == pop()) {
                    return item;
                }
            }

        } catch (Exception e) {
            System.out.println("Item not found on the stack");
            return null;
        }

    }

    public X peek() {
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }
}
