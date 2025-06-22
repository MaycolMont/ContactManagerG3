package com.group3.controller;

import com.group3.contactmanagerg3.*;
import dao.ContactService;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.ContactModel;
import java.time.LocalDate;
import util.validator.FormatValidator;
import util.DataStructures.MyArrayList;

public class AddContactController {
    boolean test = true;
    MyArrayList<FormatValidator> validators = new MyArrayList<>( );
    
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField directionField;
    @FXML
    private TextField birthdayField;
    @FXML
    private ChoiceBox<String> TypeChoiceBox;
    

    @FXML
    private void handleSave() throws IOException {
        try {
            validateInputs();
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            System.out.println(message);
            return;
        }
        
        LocalDate birthday;
        if (birthdayField.getText().isBlank()) {
            birthday = null;
        } else {
            birthday = LocalDate.parse(birthdayField.getText());
        }
        
        ContactModel contact = new ContactModel.Builder()
                .setName(nameField.getText())
                .setEmail(emailField.getText())
                .setNumber(phoneField.getText())
                .setDirection(directionField.getText())
                .setBirthdayDate(birthday)
                .setFavorite(false)
                .build();

        ContactService.add(contact);
        App.setRoot("homeView");
    }

    @FXML
    private void initialize() {
        if (test) {
            mockInputs();
        }
        
        setInputValidators();
        TypeChoiceBox.getItems().addAll("Persona Natural", "Empresa");
        TypeChoiceBox.setValue("Persona Natural");

        ContactModel contact = ContactService.getContact();
        if (contact != null) {
            setValues(contact);
        }
    }
    
    private void mockInputs() {
        emailField.insertText(0, "maycol.montalvan@gmail.com");
        phoneField.insertText(0, "0987654321");
        birthdayField.insertText(0, "2003-04-14");
    }
    
    private void setInputValidators() {
        FormatValidator[] arrayValidators = {
            new FormatValidator(phoneField, "^(09\\d{8}|0[2-7]\\d{7}|\\+5939\\d{8}|\\+593[2-7]\\d{7})$", "Formato de número no valido", true),
            new FormatValidator(emailField, "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", "Email no valido", false),
            new FormatValidator(birthdayField, "", "Formato de fecha invalida", false),
            new FormatValidator(nameField, "", "", true)
        };
        validators = validators.ofArray(arrayValidators);
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
    
    private void validateInputs() throws IllegalArgumentException {
        for (FormatValidator validator : validators) {
            validator.validate();
        }
    }
}