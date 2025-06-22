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
public class FilterByFavorite implements Filter {
    private boolean favorite;
    
    public FilterByFavorite(boolean favorite) {
        this.favorite = favorite;
    }
    
    @Override
    public boolean filter(ContactModel contact) {
        return contact.isFavorite() == favorite;
    }
}
