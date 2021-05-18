package edu.citytech.cst.s23253396.merged_apps.customer_chart.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShortDate {
    private Float year;
    private Float month;
    private Float day;
    private String dayName;
}
