package edu.citytech.cst.s23253396.final_exam.services;

import edu.citytech.cst.s23253396.final_exam.models.Summary;
import javafx.scene.control.Label;

import java.util.List;

public interface SummaryService {

    List<Summary> getSummary(String year, Label status);
    Double calculateTotal(String year);
    Double calculateAverage(String year);
    Double calculateMax(String year);
    Double calculateMin(String year);
}
