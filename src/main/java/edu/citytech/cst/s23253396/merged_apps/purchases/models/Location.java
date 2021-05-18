package edu.citytech.cst.s23253396.merged_apps.purchases.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Location implements Serializable {

    private String code;
    private List<Double> point;
}
