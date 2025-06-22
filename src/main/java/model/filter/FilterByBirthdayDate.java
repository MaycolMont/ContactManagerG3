/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.filter;
import java.time.LocalDate;
import model.ContactModel;

/**
 *
 * @author maycmont
 */
public class FilterByBirthdayDate implements Filter{
    protected LocalDate date;
    protected int after = 1;
    
    public FilterByBirthdayDate(LocalDate date) {this.date = date;}
    
    public void setBefore() {
        after = -1;
    }
    
    @Override
    public boolean filter(ContactModel contact) {
        if (contact == null) {return false;}
        return after * contact.getBirthdayDate().compareTo(date) >= 0;
    }
}
