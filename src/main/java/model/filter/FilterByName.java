/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.filter;
import model.ContactModel;

/**
 *
 * @author maycmont
 */
public class FilterByName implements Filter {
    String string;
    
    public FilterByName(String string) {
        this.string = string;
    }
    
    @Override
    public boolean filter(ContactModel contact) {
        if (contact == null) {return false;}
        return contact.getName().toLowerCase().contains(string.toLowerCase());
    }
}
