/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group3.controller;

/**
 *
 * @author maycmont
 */

import com.group3.contactmanagerg3.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import model.ContactModel;
import util.DataStructures.CircularIterator;

import java.io.IOException;

public class CarouselController {
    @FXML private StackPane centerPane;
    
    protected CircularIterator<ContactModel> contactList;
    
    public void setIterator(CircularIterator<ContactModel> contacts) {
       this.contactList = contacts;
       showContact(contactList.next());
    }
    
    @FXML
    public void handleNext() {
        showContact(contactList.next());
    }

    @FXML
    public void handlePrevious() {
        showContact(contactList.prev());
    }

    private void showContact(ContactModel contact) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("contactView.fxml"));
            Node node = loader.load();
            
            ContactController controller = loader.getController();
            controller.setContact(contact);
            
            centerPane.getChildren().setAll(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

