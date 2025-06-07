package com.group3.controller;

import com.group3.contactmanagerg3.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.util.List;

import dao.ContactService;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import model.ContactModel;

public class HomeController {
    @FXML
    private VBox contactsContainer;
    
    @FXML
    private void initialize() {
        addContactLabels();
    }

    @FXML
    private void switchToAddContact() throws IOException {
        ContactService.setContact(null);
        App.setRoot("addContactView");
    }
    
    @FXML
    private void search() {
        System.out.println("Search Done");
    }
    
    @FXML   
    private void switchToContact(ContactModel contact) throws IOException {
        ContactService.setContact(contact);
        App.setRoot("contactView");
    }
    
    private void addContactLabels() {
        contactsContainer.getChildren().clear();
        
        List<ContactModel> contactsList = ContactService.getAll();
        for (ContactModel contactModel : contactsList) {
            final String contactName = contactModel.getName();
            Label label = new Label(contactName);
            label.getStyleClass().add("contact-item");
            
            label.setMaxWidth(Double.MAX_VALUE);
            label.setAlignment(Pos.CENTER_LEFT);
            
            VBox.setVgrow(label, Priority.NEVER);
            
            label.setOnMouseClicked(e -> {
                try {
                    switchToContact(contactModel);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            contactsContainer.getChildren().add(label);
        }
    }
}
