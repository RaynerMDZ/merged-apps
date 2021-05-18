package edu.citytech.cst.s23253396.merged_apps.customer_chart;

import com.jbbwebsolutions.http.utility.JSONGet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;

public class Launcher extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Rayner Mendez - Customer Chart");

        String name = "/views/customer_chart/mainView.fxml";

        Parent root = FXMLLoader.load(getClass().getResource(name));
        stage.setScene(new Scene(root));
        stage.show();

    }
}
