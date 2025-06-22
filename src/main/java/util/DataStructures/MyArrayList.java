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
public class MyArrayList<E> implements Iterable<E>{
    private Object[] list;
    private int length;
    
    public MyArrayList() {
        list = new Object[5];
        length = 0;
    }
    
    private void duplicateSize() {
        int newLength = list.length * 2;
        Object[] newList = new Object[newLength];
        for (int i=0; i<length; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }
    
    public boolean add(E element){
        if (element == null) {return false;}
        if (length == list.length - 1) {
            duplicateSize();
        }
        list[length] = element;
        length++;
        return true;
    }
    
    public MyArrayList<E> ofArray(E[] arrayElements) {
        MyArrayList<E> newList = new MyArrayList<>();
        for (E element : arrayElements) {
            newList.add(element);
        }
        return newList;
    }
    
    public void pop(int index) {
        if (index < 0 || index > length-1) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = null;
        while (list[index+1] != null) {
            list[index] = list[index+1];
            index++;
        }
        list[index] = null;
        length--;
    }
    
    public int getLength() {return length;}
    
    public boolean isEmpty() {return length == 0;}
    
    public E get(int i) {
        if (i < 0 || i > length-1) {
            throw new IndexOutOfBoundsException();
        }
        return (E) list[i];
    }
    
    public boolean contains(Object value) {
        for (Object element: list) {
            element = (E) element;
            if (element == value)
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int currentIndex;
            Object[] itList = list;
            
            @Override
            public boolean hasNext() {return currentIndex != length;}

            @Override
            public E next() {
                E value = (E) list[currentIndex];
                currentIndex++;
                return value;
                
            }
        };
    }
}