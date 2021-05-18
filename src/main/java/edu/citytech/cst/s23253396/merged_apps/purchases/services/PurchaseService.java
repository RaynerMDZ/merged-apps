package edu.citytech.cst.s23253396.merged_apps.purchases.services;

import edu.citytech.cst.s23253396.merged_apps.purchases.models.Purchases;
import javafx.scene.control.Label;

public interface PurchaseService {
    Purchases getPurchaseById(int id, Label status);
}
