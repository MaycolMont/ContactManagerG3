/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.DataStructures;

import java.util.Iterator;

/**
 *
 * @author maycmont
 */
public class CircularListIterator<T> implements Iterator<T> {
    protected final DoubleLinkedNode<T> head;
    protected DoubleLinkedNode<T> current;
    private boolean started = false;

    public CircularListIterator(DoubleLinkedCircularList circularList) {
        this.head = circularList.head;
        this.current = this.head;
    }
    
    @Override
    public boolean hasNext() {
        return current != null && (!started || current != head);
    }

    @Override
    public T next() {
        T data = current.data;
        current = current.next;
        started = true;
        return data;
    }

    @Override
    public void remove() {throw new UnsupportedOperationException("Unimplemented method 'remove'");}
}
