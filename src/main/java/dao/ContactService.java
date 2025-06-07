/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import java.util.ArrayList;
import model.ContactModel;

/**
 *
 * @author maycmont
 */

// Define filter methods
public class ContactService {
    private static ContactModel currentContact;
    
    public static List<ContactModel> getAll() {
        String[] names = {"Maycol", "William", "Victor"};
        return mockContacts(names);
    }
    
    //Implement
    public static List<ContactModel> getByName() {
        // change this by CircularList
        List<ContactModel> contactsList = new ArrayList<>();
        return contactsList;
    }
    
    // Implement
    public static boolean update(ContactModel contact) {
        return false;
    }
    
    // Implement
    public static boolean delete(ContactModel contact) {
        return false;
    }
    
    //Implement
    public static boolean add(ContactModel contact) {
        return false;
    }
    
    // temporal method
    static ArrayList<ContactModel> mockContacts(String[] names){
        ArrayList<ContactModel> contacts = new ArrayList<>();
        for (String name : names) {
            ContactModel contact = new ContactModel.Builder()
                    .setName(name)
                    .setNumber("349034")
                    .setEmail("ksljdf@gmail.com")
                    .build();
            contacts.add(contact);
        }
        return contacts;
    }
    
    public static void setContact(ContactModel contact) {
        currentContact = contact;
    }
    
    public static ContactModel getContact() {
        return currentContact;
    }
}
