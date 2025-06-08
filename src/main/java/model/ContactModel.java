/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Map;
import java.util.LinkedHashMap;

/**
 *
 * @author maycmont
 */

public class ContactModel {
    private String name;
    private String number;
    private String email;
    private String imagePath;
    private String direction;
    private boolean isFavorite;
    private String birthdayDate;
    
    private ContactModel(Builder builder) {
        this.name = builder.name;
        this.number = builder.number;
        this.email = builder.email;
        this.imagePath = builder.imagePath;
        this.direction = builder.direction;
        this.isFavorite = builder.favorite;
        this.birthdayDate = builder.birthdayDate;
    }
     
    public static class Builder {
        private String name;
        private String number;
        private String email;
        private String imagePath;
        private String direction;
        private boolean favorite;
        private String birthdayDate;
        
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

        public Builder setBirthdayDate(String birthdayDate) {
            this.birthdayDate = birthdayDate;
            return this;
        }
        
        public ContactModel build() {
            return new ContactModel(this);
        }
    }
    
    // these attributes are required to be set
    public String getName() {return this.name;}

    public String getNumber() {return this.number;}

    public String getEmail() {return this.email;}

    public String getDirection(){return this.direction;}

    public String getBirthayDate(){return this.birthdayDate;}
    
    public String getImagePath() {return this.imagePath;}
    
    public boolean isFavorite() {return isFavorite;}

    public Map<String, String> getAttributes() {
        Map<String, String> attributes = new LinkedHashMap<>();
        attributes.put("Phone", this.number);
        attributes.put("Email", this.email);
        attributes.put("Direction", this.direction);
        attributes.put("Birthday Date", this.birthdayDate);
        return attributes;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }
}
