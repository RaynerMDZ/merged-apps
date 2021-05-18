package edu.citytech.cst.s23253396.merged_apps.customer_chart.services;

import edu.citytech.cst.s23253396.merged_apps.customer_chart.models.CustomerPurchase;
import javafx.scene.control.Label;

import java.util.List;

public interface CustomerPurchaseService {
    List<CustomerPurchase> getAllCustomerPurchasesDynamic(String years, String months, String days, String price, String location, Label status);
}
