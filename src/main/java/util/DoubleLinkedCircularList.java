/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.lang.Iterable;
import java.util.NoSuchElementException;
import java.util.ListIterator;

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
    public ListIterator<T> iterator() {
        return new DLLListIterator();
    }

    private class DLLListIterator implements ListIterator<T> {
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

        @Override
        public boolean hasPrevious() {
            if (current == head) {return false;}
            return true;
        }

        @Override
        public T previous() {
            if (hasPrevious()) {
                T data = current.data;
                current = current.prev;
                return data;
            }
            throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() {throw new UnsupportedOperationException("Unimplemented method 'nextIndex'");}

        @Override
        public int previousIndex() {throw new UnsupportedOperationException("Unimplemented method 'previousIndex'");}

        @Override
        public void remove() {throw new UnsupportedOperationException("Unimplemented method 'remove'");}

        @Override
        public void set(T e) {
            current.data = e;
        }

        @Override
        public void add(T e) {throw new UnsupportedOperationException("Unimplemented method 'add'");}
    }
}