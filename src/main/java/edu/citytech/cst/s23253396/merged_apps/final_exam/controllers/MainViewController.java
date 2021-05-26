package edu.citytech.cst.s23253396.merged_apps.final_exam.controllers;

import edu.citytech.cst.s23253396.merged_apps.final_exam.models.Summary;
import edu.citytech.cst.s23253396.merged_apps.final_exam.services.SummaryService;
import edu.citytech.cst.s23253396.merged_apps.final_exam.services.implementations.SummaryServiceImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;

public class MainViewController implements Initializable {

    private final SummaryService summaryService = new SummaryServiceImplementation();

    private Integer itemPosition = 0;

    @FXML
    private ChoiceBox<Integer> yearChoiceBox;

    @FXML
    private BarChart<String, Double> days;

    @FXML
    private CategoryAxis xAxisFruits;

    @FXML
    private NumberAxis yAxisNumberOfPeople;

    @FXML
    private Label total;

    @FXML
    private Label average;

    @FXML
    private Label max;

    @FXML
    private Label min;

    @FXML
    private Label connectionStatus;

    @FXML
    private TableView<Summary> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.days.setLegendVisible(false);

        // JavaFx has a bug that overlaps all names on the X axis. This prevents the overlapping.
        this.days.setAnimated(false);

        this.yearChoiceBox.getItems().addAll(2013, 2014, 2015, 2016, 2017);
    }

    @FXML
    void search(ActionEvent event) {

        this.itemPosition = 0;
        String year = this.yearChoiceBox.getValue().toString();

        XYChart.Series<String, Double> dayNames = new XYChart.Series<>();
        HashMap<String, String> styles = new HashMap<>();

        this.days.getData().clear();
        this.tableView.getItems().clear();

        List<Summary> summaries = this.summaryService.getSummary(year, this.connectionStatus);

        if (!summaries.isEmpty()) {
            this.tableView.getItems().addAll(summaries);

            summaries.forEach(summary -> {
                this.addBarChartData(summary.getDay(), summary.getTotal(), this.generateRandomColor(), dayNames, styles);
            });

            DecimalFormat decimalFormat = new DecimalFormat("#.##");


            this.total.setText(decimalFormat.format(this.summaryService.calculateTotal(year)));
            this.average.setText(decimalFormat.format(this.summaryService.calculateAverage(year)));
            this.max.setText(decimalFormat.format(this.summaryService.calculateMax(year)));
            this.min.setText(decimalFormat.format(this.summaryService.calculateMin(year)));

            this.populateBarChart(dayNames, styles);
        }
    }

    private void addBarChartData(String fruitName, Double numberOfPeople, String barColor, XYChart.Series<String, Double> fruits, HashMap<String, String> styles) {

        XYChart.Data<String, Double> day = new XYChart.Data<>();

        day.setXValue(fruitName);
        day.setYValue(numberOfPeople);
        fruits.getData().add(day);

        styles.put(".data" + this.itemPosition + ".chart-bar", "-fx-bar-fill: " + barColor);

        itemPosition += 1;
    }

    private void addBarStyle(HashMap<String, String> styles) {
        for (Map.Entry<String, String> style : styles.entrySet()) {
            String lookupData = style.getKey();
            String styleToApply = style.getValue();

            Node node = this.days.lookup(lookupData);
            node.setStyle(styleToApply);
        }
    }

    private void populateBarChart(XYChart.Series<String, Double> days, HashMap<String, String> styles) {
        this.days.getData().add(days);
        this.addBarStyle(styles);
    }

    private void fakeData() {
        //        this.addBarChartData("Apple", 35, "red");
//        this.addBarChartData("Orange", 30, "orange");
//        this.addBarChartData("Banana", 10, "yellow");
//        this.addBarChartData("Kiwi", 25, "green");
//        this.addBarChartData("Blueberry", 40, "blue");
//        this.addBarChartData("Grape", 5, "purple");
//
//        this.populateBarChart();
    }

    private String generateRandomColor() {
        String[] colors = {"red", "orange", "yellow", "green", "skyblue", "pink", "cyan", "violet", "purple", "grey"};
        int color = new Random().nextInt(colors.length);
        return colors[color];
    }

}
