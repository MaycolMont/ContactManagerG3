/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model.filter;

import model.ContactModel;
import java.time.LocalDate;

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
public class FilterByBirthdayDateTest {
    LocalDate referenceDate;
    
    public FilterByBirthdayDateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        referenceDate = LocalDate.of(2025, 3, 1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of filter method, of class FilterByBirthdayDate.
     */
    @Test
    public void testNullContact() {
        System.out.println("filter");
        ContactModel contact = null;
        FilterByBirthdayDate filter = new FilterByBirthdayDate(referenceDate);
        boolean expResult = false;
        boolean result = filter.filter(contact);
        assertEquals(expResult, result);
    }
    
    public ContactModel getContactWithBirthday(LocalDate date) {
        ContactModel contact = new ContactModel.Builder().
                setBirthdayDate(date)
                .build();
        
        return contact;
    }
    
    @Test
    public void testValidAfterBirthdayContact() {
        ContactModel contact = getContactWithBirthday(LocalDate.of(2025, 3, 2));
        FilterByBirthdayDate filter = new FilterByBirthdayDate(referenceDate);
        boolean expected = true;
        boolean result = filter.filter(contact);
        assertEquals(expected, result);
    }
    
    @Test
    public void testNotValidAfterBirthdayContact() {
        ContactModel contact = getContactWithBirthday(LocalDate.of(2024, 1, 2));
        FilterByBirthdayDate filter = new FilterByBirthdayDate(referenceDate);
        boolean expected = false;
        boolean result = filter.filter(contact);
        assertEquals(expected, result);
    }
    
    @Test
    public void testEqualAfterBirthdayContact() {
        ContactModel contact = getContactWithBirthday(referenceDate);
        FilterByBirthdayDate filter = new FilterByBirthdayDate(referenceDate);
        boolean expected = true;
        boolean result = filter.filter(contact);
        assertEquals(expected, result);
    }
    
    @Test
    public void testEqualBeforeBirthdayContact() {
        ContactModel contact = getContactWithBirthday(referenceDate);
        FilterByBirthdayDate filter = new FilterByBirthdayDate(referenceDate);
        filter.setBefore();
        boolean expected = true;
        boolean result = filter.filter(contact);
        assertEquals(expected, result);
    }
    
    @Test
    public void testValidBeforeBirthdayContact() {
        ContactModel contact = getContactWithBirthday(LocalDate.of(2025, 1, 1));
        FilterByBirthdayDate filter = new FilterByBirthdayDate(referenceDate);
        filter.setBefore();
        boolean expected = true;
        boolean result = filter.filter(contact);
        assertEquals(expected, result);
    }
    
    @Test
    public void testNotValidBeforeBirthdayContact() {
        ContactModel contact = getContactWithBirthday(LocalDate.of(2025, 4, 2));
        FilterByBirthdayDate filter = new FilterByBirthdayDate(referenceDate);
        filter.setBefore();
        boolean expected = false;
        boolean result = filter.filter(contact);
        assertEquals(expected, result);
    }
}
