/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group3.controller;

import dao.ContactService;
import com.group3.contactmanagerg3.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.ContactModel;
import dao.ContactService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Move this class to util
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
    private ContactModel contact;
    
    @FXML
    private ImageView profileImage;
    
    @FXML
    private Label nameLabel;

    @FXML
    private VBox attributesBox;
    
    @FXML
    private void initialize() {
        contact = ContactService.getContact();
        System.out.println(contact);
        setContactLayout();
    }
    
    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("homeView");
    }
    
    @FXML
    private void favorite() {
        
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
    
        if (confirmed){
            ContactService.delete();
            switchToHome();
        }
    }
    
    public void setContactLayout() {
        nameLabel.setText(contact.getName());
        setImageContact();

        // Add attributes to the VBox
        attributesBox.getChildren().clear();

        contact.mapAttributes().forEach((key, value) -> {
            if (value == null || value.isEmpty()) {
                return; // Skip empty attributes
            }
            
            Label label = new Label(key + ": " + value);

            label.getStyleClass().add("attribute-label");

            attributesBox.getChildren().add(label);
        });
    }
    
    public void setImageContact() {
        String imagePath = contact.getImagePath();
        if (imagePath == null) {
            URL defaultUrl = getClass().getResource("/images/default-profile.png");
            if (defaultUrl != null) {
                profileImage.setImage(new Image(defaultUrl.toString()));
            }
        } else {
            try {
                Image img = new Image(new FileInputStream("images/" + imagePath));
                profileImage.setImage(img);
            } catch(FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
