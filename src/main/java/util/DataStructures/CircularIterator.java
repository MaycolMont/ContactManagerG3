/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.DataStructures;

/**
 *
 * @author maycmont
 */
public class CircularIterator<T> {
    private DoubleLinkedNode current;
    
    public CircularIterator(DoubleLinkedNode head) {
        current = head;
    }
    
    public T next() {
        T data = (T) current.data;
        current = current.next;
        return data;
    }
    
    public T prev() {
        T data = (T) current.data;
        current = current.prev;
        return data;
    }
}
