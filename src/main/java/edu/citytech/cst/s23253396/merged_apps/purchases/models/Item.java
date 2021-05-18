package edu.citytech.cst.s23253396.merged_apps.purchases.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Item implements Serializable {

    private String name;
    private Long quantity;
    private Long totalCost;
    private Long unitPrice;
}
