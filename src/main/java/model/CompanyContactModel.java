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

public class CompanyContactModel {
    private String name;
    private String number;
    private String email;
    private String imagePath;
    private String address;

    private CompanyContactModel(Builder builder) {
        this.name = builder.name;
        this.number = builder.number;
        this.email = builder.email;
        this.imagePath = builder.imagePath;
        this.address = builder.address;
    }
     
    public static class Builder {
        private String name;
        private String number;
        private String email;
        private String imagePath;
        private String address;
        
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

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public CompanyContactModel build() {
            return new CompanyContactModel(this);
        }
    }
    
    public String getName() {return this.name;}

    public String getNumber() {return this.number;}

    public String getEmail() {return this.email;}

    public String getAddress(){return this.address;}

    public String getImagePath() {return this.imagePath;}

    public Map<String, String> getAttributes() {
        Map<String, String> attributes = new LinkedHashMap<>();
        attributes.put("Phone", this.number);
        attributes.put("Email", this.email);
        attributes.put("Address", this.address);
        return attributes;
    }
}
