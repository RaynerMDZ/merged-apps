package edu.citytech.cst.s23253396.merged_apps.customer_purchases.controllers;

import edu.citytech.cst.s23253396.merged_apps.customer_purchases.models.Item;
import edu.citytech.cst.s23253396.merged_apps.customer_purchases.models.Purchases;
import edu.citytech.cst.s23253396.merged_apps.customer_purchases.services.PurchaseService;
import edu.citytech.cst.s23253396.merged_apps.customer_purchases.services.implementation.PurchaseServiceImplementation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private Label rewards;

    @FXML
    private Label taxPreviewLabel;

    @FXML
    private Label taxUpdateLabel;

    @FXML
    private Label rewardsLabel;

    @FXML
    void search(ActionEvent event) {

        this.taxPreviewLabel.setText("0.00");
        this.rewardsLabel.setText("0.00");
        this.taxUpdateLabel.setText("");

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

            if (purchase.getReward() != null) {
                this.rewards.setText("$"+ Double.parseDouble(purchase.getReward().getAmount().toString()));
            }

            purchases.addAll(purchase.getItems());
        }
    }

    @FXML
    void previewTax(ActionEvent event) {
        if (this.searchId.getText().equalsIgnoreCase("") || this.searchId.getText() == null) {
            connectionStatus.setText("Please select an id first.");
            return;
        }

        Float taxPreview = this.purchaseService.previewTax(Long.parseLong(this.searchId.getText()));

        this.taxPreviewLabel.setText(taxPreview.toString());
    }

    @FXML
    void updateRewards(ActionEvent event) {

        this.rewardsLabel.setText("0.00");

        if (this.searchId.getText().equalsIgnoreCase("") || this.searchId.getText() == null) {
            connectionStatus.setText("Please select an id first.");
            return;
        }

        Float reward = this.purchaseService.updateRewards(Long.parseLong(this.searchId.getText()));

        this.rewardsLabel.setText(reward.toString());
    }

    @FXML
    void updateTax(ActionEvent event) {
        if (this.searchId.getText().equalsIgnoreCase("") || this.searchId.getText() == null) {
            connectionStatus.setText("Please select an id first.");
            return;
        }

        Float updateTax = this.purchaseService.updateTax(Long.parseLong(this.searchId.getText()));

        this.taxUpdateLabel.setText(updateTax.toString());
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
