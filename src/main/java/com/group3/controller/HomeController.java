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
    
    private void addContactLabels() {
        contactsContainer.getChildren().clear();
        
        List<ContactModel> contactsList = ContactService.getAll();
        for (ContactModel contacModel : contactsList) {
            String contactName = contacModel.getName();
            Label label = new Label(contactName);
            contactsContainer.getChildren().add(label);
        }
    }
}
