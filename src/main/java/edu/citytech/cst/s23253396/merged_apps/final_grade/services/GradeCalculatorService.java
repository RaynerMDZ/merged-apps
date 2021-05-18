package edu.citytech.cst.s23253396.merged_apps.final_grade.services;

public interface GradeCalculatorService {
    Float calculateGpa(Float score);
    String calculateLetterGrade(Float gpa);
}
