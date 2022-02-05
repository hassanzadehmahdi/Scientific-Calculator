/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;
 
import java.util.Arrays;
 
public class CustomStack<E> 
{
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 100;
    private Object elements[];
 
    public CustomStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }
 
    public void push(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }
 
    @SuppressWarnings("unchecked")
    public E pop() {
        E e = (E) elements[--size];
        elements[size] = null;
        return e;
    }
    
    public java.lang.String peek() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E result = (E) elements[size - 1];
        return (String) result;
    }
    
    public int size() {
        return size;
    }
 
    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
     
    @Override
    public String toString()
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < size ;i++) {
             sb.append(elements[i].toString());
             if(i < size-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();
    }
}