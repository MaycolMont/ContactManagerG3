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

    public static void setUp() {
        contactList = DoubleLinkedCircularList.fromMyArrayList(Persistance.readContacts());
        int lastId = 0;
        for (ContactModel contact : contactList) {
            if (contact.getId() > lastId) {
                lastId = contact.getId();
            }
            numberList.add(contact.getNumber());
            emailList.add(contact.getEmail());
        }
        ContactModel.setLastId(lastId);
    }
    
    public static void update() {
        int id = currentContact.getId();
        for (ContactModel contact : contactList) {
            if (contact.getId() == id) {
                contactList.set(contact, currentContact);
                updateData();
                break;
            }
        }
    }

    public static void delete() {
        contactList.delete(currentContact);
        updateData();
    }

    public static void add(ContactModel contact) {
        if (contact != null) {
            contactList.add(contact);
            numberList.add(contact.getNumber());
            emailList.add(contact.getEmail());
            updateData();
        }
    }

    public static void setContact(ContactModel contact) {currentContact = contact;}

    public static ContactModel getContact() {return currentContact;}
    
    public static boolean numberExists(String number) {return numberList.contains(number);}
    
    public static boolean emailExists(String email) {return emailList.contains(email);}
    
    public static void updateData() {
        currentContact = null;
        Persistance.saveList(contactList.toList());
    }
}
