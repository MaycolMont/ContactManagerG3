/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package util;

import util.DataStructures.MyArrayList;
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
public class MyArrayListTest {
    
    public MyArrayListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class MyArrayList.
     */
    @Test
    public void testEmptyList() {
        System.out.println("emptyList");
        String element = "Hola";
        MyArrayList<String> list = new MyArrayList<>();
        list.add(element);
        boolean expected = false;
        boolean result = list.isEmpty();
        assertEquals(expected, result);
    }

    @Test
    public void testAdd() {
        System.out.println("add");
        String element = "Hola";
        MyArrayList<String> list = new MyArrayList<>();
        list.add(element);
        boolean expected = true;
        boolean result = list.getLength() == 1 && "Hola".equals(list.get(0));
        assertEquals(expected, result);
    }
    
    @Test
    public void testAddFromArray() {
        System.out.println("add from array");
        MyArrayList<String> list = new MyArrayList<>();
        String[] array = {"HOla", "Mundo", "TEst"};
        list.ofArray(array);
        int expected = 3;
        int result = list.getLength();
        assertEquals(expected, result);
    }

    @Test
    public void testAddMoreThanFirstLength() {
        System.out.println("addAddMoreThanFirstLength");
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Hola");
        list.add("Mundo");
        list.add("!");
        list.add("Esto");
        list.add("es");
        list.add("una");
        list.add("prueba");
        boolean expected = true;
        boolean result = list.getLength() == 7 && "es".equals(list.get(4));
        assertEquals(expected, result);
    }

    /**
     * Test of pop method, of class MyArrayList.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        int i = 0;
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.pop(i);
        boolean expected = true;
        boolean result = list.getLength() == 2 && list.get(0) == 2 && list.get(1) == 3;
        assertEquals(expected, result);
    }

    @Test
    public void testPopLast() {
        System.out.println("popLast");
        int i = 2;
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.pop(i);
        boolean expected = true;
        boolean result = list.getLength() == 2 && list.get(0) == 1 && list.get(1) == 2;
        assertEquals(expected, result);
    }


    /**
     * Test of get method, of class MyArrayList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int i = 0;
        MyArrayList<Integer> instance = new MyArrayList<>();
        instance.add(1);
        instance.add(2);
        Object expResult = 1;
        Object result = instance.get(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class MyArrayList.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Integer value = 2;
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        boolean expResult = true;
        boolean result = list.contains(value);
        assertEquals(expResult, result);
    }

    @Test
    public void testNotContains() {
        System.out.println("not contains");
        Integer value = 5;
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        boolean expResult = false;
        boolean result = list.contains(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of iterator method, of class MyArrayList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it = list.iterator();
        int result = 0;
        while (it.hasNext()) {
            Integer value = it.next();
            result++;
        }
        int expected = 3;
        assertEquals(expected, result);
    }
    
}
