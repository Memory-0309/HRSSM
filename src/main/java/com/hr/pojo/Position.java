package com.hr.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class Position {
    private Integer id;
    private Integer positionNumber;
    private String name;
    private String level;
    private String notes;
}