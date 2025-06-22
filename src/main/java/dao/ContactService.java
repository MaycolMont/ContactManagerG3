/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.ContactModel;
import util.DataStructures.DoubleLinkedCircularList;
import util.DataStructures.MyArrayList;

/**
 *
 * @author maycmont
 */

public class ContactService {
    private static ContactModel currentContact;
    private static DoubleLinkedCircularList<ContactModel> contactList = new DoubleLinkedCircularList<>();
    private static MyArrayList<String> numberList = new MyArrayList<>();
    private static MyArrayList<String> emailList = new MyArrayList<>();

    public static DoubleLinkedCircularList<ContactModel> getAll() {return contactList;}

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

    public static void add(ContactModel contact) {
        // first add to database, then to the circular list
        if (contact != null) {
            contactList.add(contact);
            numberList.add(contact.getNumber());
            emailList.add(contact.getEmail());
        }
    }

    public static void setContact(ContactModel contact) {currentContact = contact;}

    public static ContactModel getContact() {return currentContact;}
    
    public static boolean numberExists(String number) {return numberList.contains(number);}
    
    public static boolean emailExists(String email) {return emailList.contains(email);}
}
