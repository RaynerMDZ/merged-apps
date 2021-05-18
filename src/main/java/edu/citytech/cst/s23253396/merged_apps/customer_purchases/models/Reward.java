package edu.citytech.cst.s23253396.merged_apps.customer_purchases.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Reward {

    private Float amount;
    private ShortDate date;
}
