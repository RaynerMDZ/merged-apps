package edu.citytech.cst.s23253396.merged_apps.customer_chart.services.implementations;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.cst.s23253396.merged_apps.customer_chart.models.CustomerPurchase;
import edu.citytech.cst.s23253396.merged_apps.customer_chart.services.CustomerPurchaseService;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
public class CustomerPurchaseServiceImpl implements CustomerPurchaseService {

    private final String url = "http://localhost:9215/api/reports/year/month/days/price/location";

    public String getUrl() {
        return url;
    }

    @Override
    public List<CustomerPurchase> getAllCustomerPurchasesDynamic(String years, String months, String days,
                                                                 String price, String location, Label status) {
        status.setText("");

        if (!this.getConnection()) {
            status.setText("No connection available. Check URL or Server.");
            return new ArrayList<>();
        }

        String url = this.modifyUrl(years, months, days, price, location);
        Map map = JSONGet.submitGet(url, Map.class);

        if ((List) map.get("row.data") == null || ((List) map.get("row.data")).size() == 0) {
            status.setText("No data was found for: " + url);
            return new ArrayList<>();
        }

        status.setText(url);

        return (List<CustomerPurchase>) map.get("row.data");
    }

    private String modifyUrl(String year, String month, String days, String price, String location) {

        if (year == null || year.isEmpty()) year = ":year";
        if (month == null || month.isEmpty()) month = ":month";
        if (days == null || days.isEmpty()) days = ":days";
        if (price == null || price.isEmpty()) price = ":price";
        if (location == null || location.isEmpty()) location = ":location";

         return this.getUrl()
                 .replace("year", year)
                 .replace("month", month)
                 .replace("days", days)
                 .replace("price", price)
                 .replace("location", location);
    }

    private boolean getConnection() {
        try {
            Socket socket = new Socket("localhost", 9215);
            return true;
        } catch (ConnectException e) {
            return false;
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

//    private String monthToNumber(String months) {
//        List<String> monthsList = new ArrayList<>();
//
//        for (String singleMonth : months.split(",")) {
//            switch (singleMonth) {
//                case "Jan" -> monthsList.add("1");
//                case "Feb" -> monthsList.add("2");
//                case "Mar" -> monthsList.add("3");
//                case "Apr" -> monthsList.add("4");
//                case "May" -> monthsList.add("5");
//                case "Jun" -> monthsList.add("6");
//                case "Jul" -> monthsList.add("7");
//                case "Aug" -> monthsList.add("8");
//                case "Sep" -> monthsList.add("9");
//                case "Oct" -> monthsList.add("10");
//                case "Nov" -> monthsList.add("11");
//                case "Dec" -> monthsList.add("12");
//                default -> monthsList.add("1");
//            }
//        }
//        return String.join(",", monthsList);
//    }
//
//    private String dayToCompleteName(String days) {
//
//        List<String> daysList = new ArrayList<>();
//
//        for (String singleDay : days.split(",")) {
//            switch (singleDay) {
//                case "Mon" -> daysList.add("MONDAY");
//                case "Tue" -> daysList.add("TUESDAY");
//                case "Wed" -> daysList.add("WEDNESDAY");
//                case "Thu" -> daysList.add("THURSDAY");
//                case "Fri" -> daysList.add("FRIDAY");
//                case "Sat" -> daysList.add("SATURDAY");
//                case "Sun" -> daysList.add("SUNDAY");
//                default -> daysList.add("MONDAY");
//            }
//        }
//        return String.join(",", daysList);
//    }
}
