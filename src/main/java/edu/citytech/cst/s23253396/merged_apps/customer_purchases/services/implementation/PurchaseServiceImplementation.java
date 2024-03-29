package edu.citytech.cst.s23253396.merged_apps.customer_purchases.services.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.citytech.cst.s23253396.merged_apps.customer_purchases.models.Purchases;
import edu.citytech.cst.s23253396.merged_apps.customer_purchases.services.PurchaseService;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.*;

public class PurchaseServiceImplementation implements PurchaseService {

    private final String url = "http://localhost:3613/customer/api/";

    @Override
    public Purchases getPurchaseById(int id, Label status) {

        status.setText("");

        if (!this.getConnection()) {
            status.setText("No connection available. Check URL or Server.");
            return null;
        }

        String newUrl = this.url + "query/" + id;

        ObjectMapper mapper = new ObjectMapper();
        Purchases purchase = null;
        try {
            URL url = new URL(newUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            purchase = mapper.readValue(connection.getInputStream(), Purchases.class);

        } catch (MalformedURLException e) {
            status.setText("No data was found for: " + newUrl);
            return null;
        } catch (IOException e) {
            status.setText("No data was found for: " + newUrl);
            return null;
        }

        if (purchase == null) {
            status.setText("No data was found for: " + newUrl);
            return null;
        }

        status.setText(newUrl);

        return purchase;
    }

    @Override
    public Float updateRewards(Long id) {

        if (!this.getConnection()) {
            return null;
        }

        String newUrl = this.url + "update/reward/" + id;

        ObjectMapper mapper = new ObjectMapper();
        Float rewards = null;
        try {
            URL url = new URL(newUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            rewards = mapper.readValue(connection.getInputStream(), Float.class);

        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }

        return rewards;
    }

    @Override
    public Float previewTax(Long id) {

        String newUrl = this.url + "tax/preview/" + id;

        if (!this.getConnection()) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        Float tax = null;
        try {
            URL url = new URL(newUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            tax = mapper.readValue(connection.getInputStream(), Float.class);

        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }

        return tax;
    }

    @Override
    public Float updateTax(Long id) {

        String newUrl = this.url + "tax/" + id;

        if (!this.getConnection()) {
            return null;
        }


        ObjectMapper mapper = new ObjectMapper();
        Float tax = null;

        try {
            URL url = new URL(newUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            tax = mapper.readValue(connection.getInputStream(), Float.class);

        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }

        return tax;
    }

    private boolean getConnection() {
        try {
            Socket socket = new Socket("localhost", 3613);
            return true;
        } catch (ConnectException | UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}
