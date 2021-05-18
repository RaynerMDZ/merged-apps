package edu.citytech.cst.s23253396.merged_apps.main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class MainViewController {

    @FXML
    private BorderPane borderPane;

    @FXML
    void showAbcCounter(ActionEvent event) throws IOException {
        System.out.println("ABC Counter Selected!");

        String name = "/views/abc_counter/acbCounterView.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
        AnchorPane mainScreen = loader.load();

        this.borderPane.setCenter(mainScreen);
    }

    @FXML
    void showCustomerChart(ActionEvent event) throws IOException {
        System.out.println("Customer Chart Selected!");

        String name = "/views/customer_chart/mainView.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
        AnchorPane mainScreen = loader.load();

        this.borderPane.setCenter(mainScreen);
    }

    @FXML
    void showFinalGrade(ActionEvent event) throws IOException {
        System.out.println("Final Grade Selected!");

        String name = "/views/final_grade/gradeCalculatorView.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
        GridPane mainScreen = loader.load();

        this.borderPane.setCenter(mainScreen);
    }
}
