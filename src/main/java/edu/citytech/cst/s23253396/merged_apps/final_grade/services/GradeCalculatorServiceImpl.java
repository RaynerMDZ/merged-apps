package edu.citytech.cst.s23253396.merged_apps.final_grade.services;

import edu.citytech.cst.s23253396.merged_apps.final_grade.services.impl.GradeCalculatorService;

public class GradeCalculatorServiceImpl implements GradeCalculatorService {

    @Override
    public Float calculateGpa(Float score) {
        if (score < 65) return 0f;
        if (score >= 97 && score <= 100) return 4.0f;
        if (score >= 93 && score <= 96) return 4.0f;
        if (score >= 90 && score <= 92) return 3.7f;
        if (score >= 87 && score <= 89) return 3.3f;
        if (score >= 83 && score <= 86) return 3.0f;
        if (score >= 80 && score <= 82) return 2.7f;
        if (score >= 77 && score <= 79) return 2.3f;
        if (score >= 73 && score <= 76) return 2.0f;
        if (score >= 70 && score <= 72) return 1.7f;
        if (score >= 67 && score <= 69) return 1.3f;
        if (score >= 65 && score <= 66) return 1.0f;
        return 0f;
    }

    @Override
    public String calculateLetterGrade(Float gpa) {
        if (gpa == 0f) return "F";
        if (gpa == 4.0f) return "A";
        if (gpa == 3.7f) return "A-";
        if (gpa == 3.3f) return "B+";
        if (gpa == 3.0f) return "B";
        if (gpa == 2.7f) return "B-";
        if (gpa == 2.3f) return "C+";
        if (gpa == 2.0f) return "C";
        if (gpa == 1.7f) return "C-";
        if (gpa == 1.3f) return "D+";
        if (gpa == 1.0f) return "D";
        return "F";
    }
}
