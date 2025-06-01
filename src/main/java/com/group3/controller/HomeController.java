package com.group3.controller;

import com.group3.contactmanagerg3.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.util.List;

import dao.ContactService;
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
        App.setRoot("addContactView");
    }
    
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
            label.setOnMouseClicked(e -> {
                try {
                    switchToContact(contactModel);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            label.setStyle("-fx-padding: 8 0 8 0; -fx-font-size: 14px; -fx-cursor: hand;");

            contactsContainer.getChildren().add(label);
        }
    }
}
