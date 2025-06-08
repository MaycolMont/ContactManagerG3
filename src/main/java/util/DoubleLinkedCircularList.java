/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 *
 * @author maycmont
 */
public class DoubleLinkedCircularList<T> implements Iterable<T>{
    private Node<T> head;
    private int size;
    
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            next = this;
            prev = this;
        }
    }

    public DoubleLinkedCircularList() {
        head = null;
        size = 0;
    }

    public DoubleLinkedCircularList(T[] array) {
        for(T element : array) {
            add(element);
        }
    }

    public boolean add(T element) {
        Node<T> node = new Node<>(element);
        if (size == 0) {
            head = node;
        } else {
            Node<T> tail = head.prev;
            node.next = head;
            node.prev = tail;
            tail.next = node;
            head.prev = node;
            head = node; 
        }
        size++;
        return true;
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    @Override 
    public Iterator<T> iterator() {
        return new DLLListIterator();
    }

    private class DLLListIterator implements Iterator<T> {
        private Node<T> current = head;
        private boolean started = false;

        @Override
        public boolean hasNext() {
            return current != null && (!started || current != head);
        }

        @Override
        public T next() {
            if (hasNext()) {
                T data = current.data;
                current = current.next;
                started = true;
                return data;
            }
            throw new NoSuchElementException();
        }
        
        public T getNext() {
            T data = current.next.data;
            current = current.next;
            return data;
        }
        
        public T getPrev() {
            T data = current.prev.data;
            current = current.prev;
            return data;
        }

        @Override
        public void remove() {throw new UnsupportedOperationException("Unimplemented method 'remove'");}
    }
}