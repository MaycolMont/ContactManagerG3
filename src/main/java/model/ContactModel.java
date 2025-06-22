/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Map;
import java.util.LinkedHashMap;
import java.time.LocalDate;

/**
 *
 * @author maycmont
 */

public class ContactModel {
    public static int lastId;
    private int id;
    private String name;
    private String number;
    private String email;
    private String imagePath;
    private String direction;
    private boolean favorite;
    private LocalDate birthdayDate;
    private LocalDate creationDate = LocalDate.now(); // Default to current date
    
    public ContactModel() {}
    
    private ContactModel(ContactModel.Builder builder) {
        this.name = builder.name;
        this.number = builder.number;
        this.email = builder.email;
        this.imagePath = builder.imagePath;
        this.direction = builder.direction;
        this.favorite = builder.favorite;
        this.birthdayDate = builder.birthdayDate;
    }
     
    public static class Builder {
        private int id;
        private String name;
        private String number;
        private String email;
        private String imagePath;
        private String direction;
        private boolean favorite;
        private LocalDate birthdayDate;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }
        
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setFavorite(boolean favorite) {
            this.favorite = favorite;
            return this;
        }

        public Builder setBirthdayDate(LocalDate birthdayDate) {
            this.birthdayDate = birthdayDate;
            return this;
        }
        
        public ContactModel build() {
            ContactModel contact = new ContactModel(this);
            contact.setId();
            return contact;
        }
    }
    
    private void setId() {this.id = ++lastId;}
    
    public static void setLastId(int lastId) {
        ContactModel.lastId = lastId;
    }
    
    public int getId() {return id;}
    
    public String getName() {return this.name;}

    public String getNumber() {return this.number;}

    public String getEmail() {return this.email;}

    public String getDirection(){return this.direction;}

    public LocalDate getBirthdayDate(){return this.birthdayDate;}

    public String getImagePath() {return this.imagePath;}
    
    public boolean getFavorite() {return favorite;}

    public LocalDate getCreationDate() {return creationDate;}
    
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
    
    
    public Map<String, String> mapAttributes() {
        Map<String, String> attributes = new LinkedHashMap<>();
        attributes.put("Phone", this.number);
        attributes.put("Email", this.email);
        attributes.put("Direction", this.direction);
        if (birthdayDate != null) {
            attributes.put("Cumpleaños", birthdayDate.toString());
        }
        return attributes;
    }
}
