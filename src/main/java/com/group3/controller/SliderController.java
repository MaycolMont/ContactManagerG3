/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group3.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import util.DataStructures.DoubleLinkedCircularList;
import util.DataStructures.CircularIterator;
import model.*;

/**
 *
 * @author maycmont
 */
public class SliderController {
    private CircularIterator<Node> iterator;

    @FXML private StackPane sliderContainer;

    public void setNodes(CircularIterator<Node> nodesIterator) {
        this.iterator = nodesIterator;
        if (!sliderContainer.getChildren().isEmpty()) {
            sliderContainer.getChildren().clear();
        }
        addComponent(iterator.next());
    }

    public void addComponent(Node component) {
        component.setTranslateX(sliderContainer.getWidth()); // Start off-screen
        sliderContainer.getChildren().add(component);

        TranslateTransition slideIn = new TranslateTransition(Duration.millis(300), component);
        slideIn.setFromX(sliderContainer.getWidth());
        slideIn.setToX(0);
        slideIn.play();
    }

    public void removeComponent(Node component) {
        TranslateTransition slideOut = new TranslateTransition(Duration.millis(300), component);
        slideOut.setFromX(0);
        slideOut.setToX(sliderContainer.getWidth());
        slideOut.setOnFinished(e -> sliderContainer.getChildren().remove(component));
        slideOut.play();
    }

    @FXML
    private void next() {
        if (iterator != null) {
            Node nextNode = iterator.next();
            removeComponent(sliderContainer.getChildren().get(0));
            addComponent(nextNode);
        }
    }
    
    @FXML
    private void prev() {
         if (iterator != null) {
            Node prevNode = iterator.prev();
            removeComponent(sliderContainer.getChildren().get(0));
            addComponent(prevNode);
        }
    }
}

