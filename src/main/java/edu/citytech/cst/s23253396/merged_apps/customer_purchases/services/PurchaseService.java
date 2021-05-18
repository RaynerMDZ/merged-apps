package edu.citytech.cst.s23253396.merged_apps.customer_purchases.services;

import edu.citytech.cst.s23253396.merged_apps.customer_purchases.models.Purchases;
import javafx.scene.control.Label;

public interface PurchaseService {
    Purchases getPurchaseById(int id, Label status);
}
