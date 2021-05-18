package edu.citytech.cst.s23253396.merged_apps.purchases.services.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.citytech.cst.s23253396.merged_apps.purchases.models.Purchases;
import edu.citytech.cst.s23253396.merged_apps.purchases.services.PurchaseService;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.*;

public class PurchaseServiceImplementation implements PurchaseService {

    private final String url = "http://localhost:3613/customer/api/customers";

    @Override
    public Purchases getPurchaseById(int id, Label status) {

        status.setText("");

        if (!this.getConnection()) {
            status.setText("No connection available. Check URL or Server.");
            return null;
        }

        String newUrl = this.url + "/" + id;

        ObjectMapper mapper = new ObjectMapper();
        Purchases purchase = null;
        try {
            URL url = new URL(newUrl);
            URLConnection connection = url.openConnection();
            
            purchase = mapper.readValue(connection.getInputStream(), Purchases.class);
        } catch (MalformedURLException e) {
            status.setText("No data was found for: " + newUrl);
        } catch (IOException e) {
            status.setText("No data was found for: " + newUrl);
        }

        if (purchase == null) {
            status.setText("No data was found for: " + newUrl);
            return null;
        }

        status.setText(newUrl);

        return purchase;
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
