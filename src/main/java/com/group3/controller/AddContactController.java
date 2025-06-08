package com.group3.controller;

import com.group3.contactmanagerg3.*;
import dao.ContactService;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.ContactModel;

public class AddContactController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;

    @FXML
    private void handleSave() throws IOException {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        ContactModel contact = new ContactModel.Builder()
                .setName(name)
                .setEmail(email)
                .setNumber(phone)
                .build();

        ContactService.add(contact);
        App.setRoot("homeView");
    }

    @FXML
    private void initialize() {
        ContactModel contact = ContactService.getContact();
        if (contact != null) {
            setValues(contact);
        }
    }
    
    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("homeView");
        // valida si quiere regresar a home sin guardar cambios
    }
    
    // En modo editar, llena los campos con los valores
    // del objeto ContactModel pasado como parametro
    private void setValues(ContactModel contact) {
        
    }
}