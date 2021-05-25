package edu.citytech.cst.s23253396.final_exam.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Summary {

    private Integer dayNumber;
    private String day;
    private Double total;
}
