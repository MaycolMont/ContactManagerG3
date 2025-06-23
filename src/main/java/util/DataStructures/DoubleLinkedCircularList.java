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
public class DoubleLinkedCircularList<T> implements Iterable<T>{
    protected DoubleLinkedNode<T> head;
    protected DoubleLinkedNode<T> tail;
    private int size;

    public DoubleLinkedCircularList() {
        head = null;
        size = 0;
    }

    public boolean add(T element) {
        if (element == null) {return false;}
        DoubleLinkedNode<T> node = new DoubleLinkedNode<>(element);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            node.prev = tail;
            tail.next = node;
            head.prev = node;
            tail = node; 
        }
        size++;
        return true;
    }
    
    public boolean delete(T value) {
        if (value == null){return false;}
        if (head == tail && head.data == value) {
            head = null;
            tail = null;
            return true;
        }
        DoubleLinkedNode current = head;
        boolean started = false;
        while (!started || current != head) {
            if (current.data.equals(value)) {
                if (current == head) {
                    tail.next = head.next;
                    head.next.prev = tail;
                    head = tail.next;
                } else if (current == tail) {
                    head.prev = tail.prev;
                    tail.prev.next = head;
                    tail = head.prev;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
            started = true;
        }
        return false;
    }
    
    public static DoubleLinkedCircularList fromMyArrayList(MyArrayList arrayList) {
        DoubleLinkedCircularList circularList = new DoubleLinkedCircularList();
        for (Object element : arrayList) {
            circularList.add(element);
        }
        return circularList;
    }
    
    public MyArrayList<T> toList() {
        MyArrayList<T> arrayList = new MyArrayList<>();
        Iterator<T> it = iterator();
        while (it.hasNext()){
            arrayList.add(it.next());
        }
        return arrayList;
    }
    
    public void set(T element, T newElement) {
        DoubleLinkedNode current = head;
        boolean started = false;
        while (!started || current != head) {
            if (current.data.equals(element)) {
                current.data = newElement;
            }
            started = true;
        }
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    @Override 
    public Iterator<T> iterator() {
        return new CircularListIterator(this);
    }
    
    public CircularIterator circularIterator(T newHead) {
        if (this.isEmpty()){return null;}
        DoubleLinkedNode current = head;
        boolean started = false;
        while (!started || current != head) {
            if (newHead.equals(current.data)) {
                return new CircularIterator(current);
            }
            current = current.next;
        }
        return null;
    }
}