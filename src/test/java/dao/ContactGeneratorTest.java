/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import util.DataStructures.MyArrayList;
import model.filter.FilterByName;
import model.filter.Filter;
import model.ContactModel;
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
public class ContactGeneratorTest {
    
    public ContactGeneratorTest() {
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
     * Test of generarContactos method, of class ContactGenerator.
     */
    @Test
    public void testGenerateContacts() {
        System.out.println("generateContacts");
        int cantidad = 6;
        int expResult = cantidad;
        MyArrayList<ContactModel> result = ContactGenerator.generarateContacts(cantidad);
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testFilterNamesWithA() {
        System.out.println("filterNames");
        String[] names = {"Juan", "Ana", "Carlos", "Sofía", "Luis", "Valeria", "Mateo", "Camila"};
        int expected = 7;
        int result = 0;
        MyArrayList<ContactModel> list = ContactGenerator.generarateByName(names);
        assertNotNull(result);
        assertFalse(list.isEmpty());
        assertEquals(names.length, list.size());
        Filter filter = new FilterByName("a");
        for (ContactModel contact : list) {
            if (filter.filter(contact)) {
                result++;
            }
        }
        assertEquals(expected, result);
    }
    
    @Test
    public void testFilterNamesWithO() {
        System.out.println("filterNames");
        String[] names = {"Juan", "Ana", "Carlos", "Sofía", "Luis", "Valeria", "Mateo", "Camila"};
        int expected = 3;
        int result = 0;
        MyArrayList<ContactModel> list = ContactGenerator.generarateByName(names);
        assertNotNull(result);
        assertFalse(list.isEmpty());
        assertEquals(names.length, list.size());
        Filter filter = new FilterByName("O");
        for (ContactModel contact : list) {
            if (filter.filter(contact)) {
                result++;
            }
        }
        assertEquals(expected, result);
    }
    
}
