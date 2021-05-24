package edu.citytech.cst.s23253396.merged_apps.customer_purchases.services;

import edu.citytech.cst.s23253396.merged_apps.customer_purchases.models.Item;
import edu.citytech.cst.s23253396.merged_apps.customer_purchases.models.Purchases;
import javafx.scene.control.Label;

import java.util.List;

public interface PurchaseService {
    Purchases getPurchaseById(int id, Label status);
    Float updateRewards(Long id);
    Float previewTax(Long id);
    Float updateTax(Long id);
}
