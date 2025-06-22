/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package util;

import util.DataStructures.DoubleLinkedCircularList;
import util.DataStructures.CircularIterator;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elmay
 */
public class DoubleLinkedCircularListTest {
    
    public DoubleLinkedCircularListTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    /**
     * Test of add method, of class DoubleLinkedCircularList.
     */
    @org.junit.Test
    public void testAdd() {
        System.out.println("add");
        Object element = null;
        DoubleLinkedCircularList instance = new DoubleLinkedCircularList();
        boolean expResult = false;
        boolean result = instance.add(element);
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class DoubleLinkedCircularList.
     */
    @org.junit.Test
    public void testSize() {
        System.out.println("size");
        DoubleLinkedCircularList instance = new DoubleLinkedCircularList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isEmpty method, of class DoubleLinkedCircularList.
     */
    @org.junit.Test
    public void testIsEmpty() {
        System.out.println("is mpty");
        DoubleLinkedCircularList instance = new DoubleLinkedCircularList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of iterator method, of class DoubleLinkedCircularList.
     */
    @org.junit.Test
    public void testIterator() {
        System.out.println("iterator");
        DoubleLinkedCircularList<Integer> list = new DoubleLinkedCircularList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int cont = 0;
        for (Integer element : list) {
            System.out.println("Element: " + element);
            cont++;
        }
        assertEquals(3, cont); // Should iterate through 3 elements
    }

    /**
     * Test of circularIterator method, of class DoubleLinkedCircularList.
     */
    @org.junit.Test
    public void testCircularIterator() {
        System.out.println("circular iterator");
        DoubleLinkedCircularList<Integer> list = new DoubleLinkedCircularList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        CircularIterator<Integer> it = list.circularIterator();
        int count = 0;
        Integer value = null;
        while (count < 6) { // Limit to 6
            value = it.next();
            count++;
        }
        assertEquals((Integer) 3, value); // Last value should be 3
    }
    
}
