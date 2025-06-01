package com.group3.controller;

import com.group3.contactmanagerg3.*;
import java.io.IOException;
import javafx.fxml.FXML;

public class HomeController {

    @FXML
    private void switchToAddContact() throws IOException {
        App.setRoot("addContactView");
    }
}
