/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.comparator;
import java.util.Comparator;
import model.ContactModel;

/**
 *
 * @author maycmont
 */
public abstract class BaseComparator implements Comparator<ContactModel> {
    @Override
    public int compare(ContactModel o1, ContactModel o2) {
        return 0;
    }
    
}
