/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group3.controller;

import com.group3.contactmanagerg3.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

class ConfirmDialog {

    public static boolean show(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null); // or set a header
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }
}


/**
 *
 * @author maycmont
 */
public class ContactController {
    
    @FXML
    private void swithToHome() throws IOException {
        App.setRoot("homeView");
    }
    
    @FXML
    private void edit() throws IOException {
        App.setRoot("addContactView");
    }
    
    @FXML
    private void delete() throws IOException {
        // if user confirm, then delete from the user from data and return to Home
        boolean confirmed = ConfirmDialog.show("Ventana de confirmación", 
                "¿Estás seguro que quieres eliminar este contacto?");
        
        if (confirmed)swithToHome();
    }
}
