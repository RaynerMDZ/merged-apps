package edu.citytech.cst.s23253396.merged_apps.customer_purchases.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Purchases implements Serializable {

    private Long _id;
    private String customerId;
    private Long totalItems;
    private Long totalPrice;
    private ShortDate shortDate;
    private String purchaseDate;
    private String description;
    private List<Item> items;
    private Location location;
    private Reward reward;
    private Float taxPaid;
}
