package edu.citytech.cst.s23253396.final_exam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Launcher extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Rayner Mendez - Final Exam");

        String name = "/views/mainView.fxml";
        URL url = getClass().getResource(name);

        if (url != null) {
            Parent root = FXMLLoader.load(url);
            stage.setScene(new Scene(root));
            stage.show();

        } else {
            System.out.println("File with the name of: mainView.fxml, located in: /resources/views/ was not found!");
            System.out.println("Please check the file path.");
        }


    }
}
