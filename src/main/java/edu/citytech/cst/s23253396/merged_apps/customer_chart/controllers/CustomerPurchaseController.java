package edu.citytech.cst.s23253396.merged_apps.customer_chart.controllers;

import com.google.gson.Gson;
import edu.citytech.cst.s23253396.merged_apps.customer_chart.models.CustomerPurchase;
import edu.citytech.cst.s23253396.merged_apps.customer_chart.services.CustomerPurchaseService;
import edu.citytech.cst.s23253396.merged_apps.customer_chart.services.implementations.CustomerPurchaseServiceImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerPurchaseController implements Initializable {

    private final CustomerPurchaseService customerPurchaseService = new CustomerPurchaseServiceImpl();

    @FXML
    private TableView<CustomerPurchase> tvCustomerPurchases;

    @FXML
    private AnchorPane apYear;

    @FXML
    private AnchorPane apMonth;

    @FXML
    private AnchorPane apDay;

    @FXML
    private AnchorPane apLocation;

    @FXML
    private AnchorPane apSlider;

    @FXML
    private Button btSearch;

    @FXML
    private Label status;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.status.setText("IDLE");
    }

    @FXML
    void search(ActionEvent event) {

        ObservableList<CustomerPurchase> customerPurchases = this.tvCustomerPurchases.getItems();

        final Gson gson = new Gson();

        for (Object row : this.customerPurchaseService.getAllCustomerPurchasesDynamic(
                this.getAnchorPaneElements("years"),
                this.getAnchorPaneElements("months"),
                this.getAnchorPaneElements("days"),
                "100,500",
                this.getAnchorPaneElements("locations"),
                this.status)) {
            customerPurchases.add(gson.fromJson(row.toString(), CustomerPurchase.class));
        }
    }

    private String getAnchorPaneElements(String choice) {

        this.tvCustomerPurchases.getItems().clear();

        AnchorPane anchorPane = new AnchorPane();

        if (choice.equalsIgnoreCase("years")) {
            anchorPane = this.apYear;
        }

        if (choice.equalsIgnoreCase("months")) {
            anchorPane = this.apMonth;
        }

        if (choice.equalsIgnoreCase("days")) {
            anchorPane = this.apDay;
        }

        if (choice.equalsIgnoreCase("locations")) {
            anchorPane = this.apLocation;
        }


        List<String> elements = new ArrayList<>();

        anchorPane.getChildren().forEach(anchorPaneChild -> {
            if (anchorPaneChild instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) anchorPaneChild;
                if (checkBox.isSelected()) {
                    if (choice.equalsIgnoreCase("months") || choice.equalsIgnoreCase("days")) {
                        elements.add(checkBox.getUserData().toString());
                    } else {
                        elements.add(checkBox.getText());
                    }
                }
            }
        });

        return String.join(",", elements);
    }
}
