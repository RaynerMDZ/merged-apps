package edu.citytech.cst.s23253396.merged_apps.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Rayner Mendez - 23253396");

        String name = "/views/main/mainView.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(name));
        stage.setScene(new Scene(root));
        stage.setResizable(true);
        stage.show();
    }
}
