package com.group3.controller;

import com.group3.contactmanagerg3.App;
import dao.ContactService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import model.ContactModel;
import util.DataStructures.MyArrayList;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;

public class HomeController {

    @FXML
    private VBox contactsContainer;

    @FXML
    private MenuItem nameMenuItem;

    @FXML
    private MenuItem birthdayMenuItem;

    @FXML
    private MenuItem dateMenuItem;

    @FXML
    private TextField searchField;

    private MyArrayList<ContactModel> allContacts;

    @FXML
    private void initialize() {
        ContactService.setUp();
        allContacts = ContactService.getAll().toList();
        addContactLabels(allContacts);

        // Búsqueda en tiempo real
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filterContactsByName(newValue);
        });
    }

    @FXML
    private void switchToAddContact() throws IOException {
        ContactService.setContact(null);
        App.setRoot("addContactView");
    }

    @FXML
    private void sortByName() {
        MyArrayList<ContactModel> copy = copyContactList();
        copy.sortWithComparator(Comparator.comparing(ContactModel::getName, Comparator.nullsLast(String::compareToIgnoreCase)));
        addContactLabels(copy);
    }

    @FXML
    private void sortByBirthday() {
        MyArrayList<ContactModel> copy = copyContactList();
        copy.sortWithComparator(Comparator.comparing(
            c -> c.getBirthdayDate() != null ? c.getBirthdayDate().getMonthValue() : 13
        ));
        addContactLabels(copy);
    }

    @FXML
    private void sortByCreationDate() {
        MyArrayList<ContactModel> copy = copyContactList();
        copy.sortWithComparator(Comparator.comparing(ContactModel::getCreationDate, Comparator.nullsLast(LocalDate::compareTo)));
        addContactLabels(copy);
    }

    private MyArrayList<ContactModel> copyContactList() {
        MyArrayList<ContactModel> copy = new MyArrayList<>();
        for (ContactModel contact : allContacts) {
            copy.add(contact);
        }
        return copy;
    }

    private void addContactLabels(MyArrayList<ContactModel> list) {
        contactsContainer.getChildren().clear();
        for (ContactModel contactModel : list) {
            createContactLabel(contactModel);
        }
    }

    private void filterContactsByName(String query) {
        MyArrayList<ContactModel> filtered = new MyArrayList<>();
        for (ContactModel contact : allContacts) {
            if (contact.getName() != null && contact.getName().toLowerCase().contains(query.toLowerCase())) {
                filtered.add(contact);
            }
        }
        addContactLabels(filtered);
    }

    private void createContactLabel(ContactModel contactModel) {
        Label label = new Label(contactModel.getName());
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

    @FXML
    private void switchToContact(ContactModel contact) throws IOException {
        ContactService.setContact(contact);
        App.setRoot("contactView");
    }
}
