/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.comparator;

import model.ContactModel;

/**
 *
 * @author maycmont
 */

public class ComparatorByName extends BaseComparator {
    @Override
    public int compare(ContactModel contact1, ContactModel contact2) {
        int res = super.compare(contact1, contact2);
        if (res == 0) {
            res = contact1.getName().compareTo(contact2.getName());
        }
        return res;
    }
}
