/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.DataStructures;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author maycmont
 */
public class MyArrayList<E> implements Iterable<E>, List<E>{
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
    
    public static MyArrayList fromArray(Object[] arrayElements) {
        MyArrayList newList = new MyArrayList<>();
        for (Object element : arrayElements) {
            newList.add(element);
        }
        return newList;
    }
    
    private boolean validIndex(int index) {
        if (index < 0 || index > length-1) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }
    
    @Override
    public boolean isEmpty() {return length == 0;}
    
    @Override
    public E get(int i) {
        if (i < 0 || i > length-1) {
            throw new IndexOutOfBoundsException();
        }
        return (E) list[i];
    }
    
    @Override
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

    @Override
    public int size() {return length;}

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        list = new Object[5];
        length = 0;
    }

    @Override
    public E set(int index, E element) {
        if (validIndex(index)){
            list[index] = element;
        }
        return element;
    }
    
    @Override
    public boolean add(E element) {
        if (element == null) {return false;}
        if (length == list.length - 1) {
            duplicateSize();
        }
        list[length] = element;
        length++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (length == list.length - 1) {
            duplicateSize();
        }
        for (int i=0; i<length; i++) {
            E current = (E) list[i];
            if (current == element) {
                
            }
        }
    }

    @Override
    public E remove(int index) {
        validIndex(index);
        E element = (E) list[index];
        list[index] = null;
        while (list[index+1] != null) {
            list[index] = list[index+1];
            index++;
        }
        list[index] = null;
        length--;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        Iterator it = iterator();
        int index = 0;
        while(it.hasNext()) {
            E current = (E) it.next();
            E value = (E) o;
            if (current.equals(value)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}