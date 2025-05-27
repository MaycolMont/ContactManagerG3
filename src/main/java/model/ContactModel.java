/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maycmont
 */
public class ContactModel {
    private String name;
    private String number;
    private String email;
    
    private ContactModel(Builder builder) {
        this.name = builder.name;
        this.number = builder.number;
        this.email = builder.email;
    }
     
    public static class Builder {
        private String name;
        private String number;
        private String email; 
        
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
        
        public ContactModel build() {
            return new ContactModel(this);
        }
    }
    
    public static void main(String[] args) {
        ContactModel newContact = new ContactModel.Builder()
                .setName("Maycol")
                .setNumber("09304932")
                .build();
    }
}
