package edu.citytech.cst.s23253396.merged_apps.final_grade;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Rayner Mendez - Grade Calculator");

        String name = "/views/final_grade/gradeCalculatorView.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(name));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
