package edu.citytech.cst.s23253396.merged_apps.purchases.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ShortDate implements Serializable {

    private Long day;
    private Long month;
    private Long year;
}
