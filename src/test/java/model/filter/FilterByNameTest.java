/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model.filter;

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
public class FilterByNameTest {
    
    public FilterByNameTest() {
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
    
    public ContactModel getContactWithName(String name) {
        ContactModel contact = new ContactModel.Builder().
                setName(name).
                build();
        return contact;
    }

    /**
     * Test of filter method, of class FilterByName.
     */
    @Test
    public void testFilter() {
        FilterByName instance = new FilterByName("May");
        boolean expResult = false;
        boolean result = instance.filter(null);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsContains() {
        ContactModel contact = getContactWithName("Maycol");
        FilterByName instance = new FilterByName("May");
        boolean expResult = true;
        boolean result = instance.filter(contact);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testNotStarts() {
        ContactModel contact = getContactWithName("montalvan maycol");
        FilterByName instance = new FilterByName("May");
        boolean expResult = true;
        boolean result = instance.filter(contact);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStartWithUppercase() {
        ContactModel contact = getContactWithName("MAYCOL MONTALVAN");
        FilterByName instance = new FilterByName("May");
        boolean expResult = true;
        boolean result = instance.filter(contact);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNotContains() {
        ContactModel contact = getContactWithName("asdf");
        FilterByName instance = new FilterByName("May");
        boolean expResult = false;
        boolean result = instance.filter(contact);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNotEqual() {
        ContactModel contact = getContactWithName("maasydf");
        FilterByName instance = new FilterByName("May");
        boolean expResult = false;
        boolean result = instance.filter(contact);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInMiddle() {
        ContactModel contact = getContactWithName("asMaYasd");
        FilterByName instance = new FilterByName("May");
        boolean expResult = true;
        boolean result = instance.filter(contact);
        assertEquals(expResult, result);
    }
}
