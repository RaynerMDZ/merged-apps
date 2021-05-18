package edu.citytech.cst.s23253396.merged_apps.customer_chart.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerPurchase {
    private Float _id;
    private String customerId;
    private Float totalItems;
    private Float totalPrice;
    private Location location;
    private ShortDate shortDate;

    public String getMonth() {
        int monthNumber = (int) Math.floor(this.shortDate.getMonth());
        String month = "";
        switch (monthNumber) {
            case 1 -> month = "JANUARY";
            case 2 -> month = "FEBRUARY";
            case 3 -> month = "MARCH";
            case 4 -> month = "APRIL";
            case 5 -> month = "MAY";
            case 6 -> month = "JUNE";
            case 7 -> month = "JULY";
            case 8 -> month = "AUGUST";
            case 9 -> month = "SEPTEMBER";
            case 10 -> month = "OCTOBER";
            case 11 -> month = "NOVEMBER";
            case 12 -> month = "DECEMBER";
            default -> month = "Month not found";
        }
        return month;
    }

    public String getLocationCode() {
        return this.location.getCode();
    }

    public String getDate() {
        String day = String.format("%.0f", this.shortDate.getDay());
        String month = String.format("%.0f", this.shortDate.getMonth());
        String year = String.format("%.0f", this.shortDate.getYear());
        return month + "." + day + "." + year;
    }

    public String getShortDateDayName() {
        return this.shortDate.getDayName();
    }
}
