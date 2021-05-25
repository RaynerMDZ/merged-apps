package edu.citytech.cst.s23253396.final_exam.services.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.citytech.cst.s23253396.final_exam.models.Summary;
import edu.citytech.cst.s23253396.final_exam.services.SummaryService;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryServiceImplementation implements SummaryService {

    private final String URL = "http://localhost:9215/api/summary/year/:year";

    @Override
    public List<Summary> getSummary(String year, Label status) {

        status.setText("");

        if (!this.getConnection()) {
            status.setText("No connection available. Check URL or Server.");
            return new ArrayList<>();
        }

        String newUrl = this.modifyUrl(year);

        ObjectMapper mapper = new ObjectMapper();
        List<Summary> summaries = null;

        try {
            URL url = new URL(newUrl);
            URLConnection connection = url.openConnection();

            summaries = Arrays.asList(mapper.readValue(connection.getInputStream(), Summary[].class));
        } catch (MalformedURLException e) {
            status.setText("No data was found for: " + newUrl);
            return new ArrayList<>();
        } catch (IOException e) {
            status.setText("No data was found for: " + newUrl);
            return new ArrayList<>();
        }

        status.setText(newUrl);

        return summaries;
    }

    @Override
    public Double calculateTotal(String year) {
        Double total = 0.0D;
        String newUrl = this.modifyUrl(year);

        ObjectMapper mapper = new ObjectMapper();
        List<Summary> summaries = null;
        try {
            URL url = new URL(newUrl);
            URLConnection connection = url.openConnection();
            summaries = Arrays.asList(mapper.readValue(connection.getInputStream(), Summary[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        for (Summary summary : summaries) {
            total += summary.getTotal();
        }

        return total;
    }

    @Override
    public Double calculateAverage(String year) {

        Double total = 0.0D;
        String newUrl = this.modifyUrl(year);

        ObjectMapper mapper = new ObjectMapper();
        List<Summary> summaries = null;
        try {
            URL url = new URL(newUrl);
            URLConnection connection = url.openConnection();

            summaries = Arrays.asList(mapper.readValue(connection.getInputStream(), Summary[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        int arraySize = summaries.size();

        for (Summary summary : summaries) {
            total += summary.getTotal();
        }

        return total / arraySize;
    }

    @Override
    public Double calculateMax(String year) {
        String newUrl = this.modifyUrl(year);

        ObjectMapper mapper = new ObjectMapper();
        List<Summary> summaries = null;
        try {
            URL url = new URL(newUrl);
            URLConnection connection = url.openConnection();

            summaries = Arrays.asList(mapper.readValue(connection.getInputStream(), Summary[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Double max = summaries.get(0).getTotal();

        for (Summary summary : summaries) {
            if (summary.getTotal() > max) {
                max = summary.getTotal();
            }
        }

        return max;
    }

    @Override
    public Double calculateMin(String year) {
        String newUrl = this.modifyUrl(year);

        ObjectMapper mapper = new ObjectMapper();
        List<Summary> summaries = null;
        try {
            URL url = new URL(newUrl);
            URLConnection connection = url.openConnection();

            summaries = Arrays.asList(mapper.readValue(connection.getInputStream(), Summary[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Double min = summaries.get(0).getTotal();

        for (Summary summary : summaries) {
            if (summary.getTotal() < min) {
                min = summary.getTotal();
            }
        }

        return min;
    }
//
//    private <T extends Object> T getData(String url, Class<T> object) {
//
//        ObjectMapper mapper = new ObjectMapper();
//        List<T> objects = null;
//        try {
//            URL url = new URL(url);
//            URLConnection connection = url.openConnection();
//
//            object = Arrays.asList(mapper.readValue(connection.getInputStream(), T.class));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return object;
//    }

    private String modifyUrl(String year) {

        if (year == null || year.isEmpty()) year = ":year";

        return this.URL.replace(":year", year);
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
}
