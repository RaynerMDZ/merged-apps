package edu.citytech.cst.s23253396.merged_apps.purchases.controllers;

import edu.citytech.cst.s23253396.merged_apps.purchases.models.Item;
import edu.citytech.cst.s23253396.merged_apps.purchases.models.Purchases;
import edu.citytech.cst.s23253396.merged_apps.purchases.services.PurchaseService;
import edu.citytech.cst.s23253396.merged_apps.purchases.services.implementation.PurchaseServiceImplementation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainViewController {

    private final PurchaseService purchaseService = new PurchaseServiceImplementation();

    @FXML
    private TextField searchId;

    @FXML
    private Label id;

    @FXML
    private Label totalPrice;

    @FXML
    private Label connectionStatus;

    @FXML
    private TableView<Item> purchasesTable;

    @FXML
    private Button search;

    @FXML
    void search(ActionEvent event) {

        this.purchasesTable.getItems().clear();
        this.id.setText("Id");
        this.totalPrice.setText("$0.00");

        // Validates input. Only accepts integers.
        if (this.searchId.getText().equalsIgnoreCase("") || !this.isNumeric(this.searchId.getText()) || !this.isInteger(this.searchId.getText()) || this.searchId == null) {
            this.connectionStatus.setText("Invalid search id:  " + this.searchId.getText());
            return;
        }

        ObservableList<Item> purchases = this.purchasesTable.getItems();

        int id = Integer.parseInt(this.searchId.getText());

        Purchases purchase = this.purchaseService.getPurchaseById(id, connectionStatus);

        if (purchase != null) {
            this.id.setText(purchase.getCustomerId());
            this.totalPrice.setText("$"+ Double.parseDouble(purchase.getTotalPrice().toString()));

            purchases.addAll(purchase.getItems());
        }
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
