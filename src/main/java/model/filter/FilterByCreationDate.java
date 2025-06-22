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
public class FilterByCreationDate extends FilterByBirthdayDate {
    public FilterByCreationDate(LocalDate date) {
        super(date);
    }
    
    @Override
    public boolean filter(ContactModel contact) {
        return after * date.compareTo(contact.getCreationDate()) >= 0;
    }
}
