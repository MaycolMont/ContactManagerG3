package com.group3.controller;

import com.group3.contactmanagerg3.*;
import java.io.IOException;
import javafx.fxml.FXML;

public class AddContactController {

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("homeView");
    }
}