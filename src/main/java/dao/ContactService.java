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
public class ContactService {
    
    public static List<ContactModel> getAll() {
        String[] names = {"Maycol", "William", "Victor"};
        return mockContacts(names);
    }
    
    // temporary method
    static ArrayList<ContactModel> mockContacts(String[] names){
        ArrayList<ContactModel> contacts = new ArrayList<>();
        for (String name : names) {
            ContactModel contact = new ContactModel.Builder()
                    .setName(name)
                    .build();
            contacts.add(contact);
        }
        return contacts;
    }
}
