package edu.citytech.cst.s23253396.merged_apps.final_grade.controllers;

import edu.citytech.cst.s23253396.merged_apps.final_grade.services.GradeCalculatorServiceImpl;
import edu.citytech.cst.s23253396.merged_apps.final_grade.services.impl.GradeCalculatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class GradeCalculatorViewController {

    private final GradeCalculatorService calculatorService = new GradeCalculatorServiceImpl();

    @FXML
    private Label title;

    @FXML
    private Label status;

    @FXML
    private Label letterGrade;

    @FXML
    private TextField txtScore;

    @FXML
    private TextField txtGpa;

    @FXML
    private TextField txtLetterGrade;

    @FXML
    private Button btnCalculate;

    @FXML
    private Button btnClear;

    @FXML
    void calculateGrade(ActionEvent event) {

//        boolean isNumeric = txtScore.getText().chars().allMatch(Character::isDigit);
//        String score = txtScore.getText();
//
//        if (isNumeric) {
//            if (Float.parseFloat(score) > 100.0f || Float.parseFloat(score) < 0.0f) {
//                this.status.setText("Please enter a number between 0-100!");
//                return;
//            }
//        }

        try {
            Float gpa = this.calculatorService.calculateGpa(Float.parseFloat(txtScore.getText()));
            String letterGrade = this.calculatorService.calculateLetterGrade(gpa);

            this.txtGpa.setText(gpa.toString());
            this.txtLetterGrade.setText(letterGrade);

            this.status.setText("Done!");
        } catch (RuntimeException e) {
            this.status.setText("Please enter only numbers!");
        }

    }

    @FXML
    void clearTextFields(ActionEvent event) {
        this.txtGpa.clear();
        this.txtLetterGrade.clear();
        this.txtScore.clear();
        this.status.setText("");
    }

}
