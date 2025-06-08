/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.ContactModel;
import util.DoubleLinkedCircularList;

/**
 *
 * @author maycmont
 */

// Define filter methods
public class ContactService {
    private static ContactModel currentContact;
    private static DoubleLinkedCircularList<ContactModel> contactsList = new DoubleLinkedCircularList<>();

    public static DoubleLinkedCircularList<ContactModel> getAll() {
        return contactsList;
    }

    //Implement
    public static DoubleLinkedCircularList<ContactModel> getByName() {
        DoubleLinkedCircularList<ContactModel> contactsList = new DoubleLinkedCircularList<>();
        return contactsList;
    }

    // Implement
    public static boolean update(ContactModel contact) {
        // update to dabase, then to the circular list
        
        return false;
    }

    // Implement
    public static boolean delete(ContactModel contact) {
        // first try to delete from database, then from circular list
        
        return false;
    }

    //Implement
    public static boolean add(ContactModel contact) {
        // first add to database, then to the circular list
        if (contact != null) {
            contactsList.add(contact);
            return true;
        }
        return false;
    }

    public static void setContact(ContactModel contact) {
        currentContact = contact;
    }

    public static ContactModel getContact() {
        return currentContact;
    }
}
