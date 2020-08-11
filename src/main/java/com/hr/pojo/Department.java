package com.hr.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class Department {
    private Integer id;
    private Integer departmentNumber;
    private String name;
    private String manager;
    private String telephone;
    private String address;
    private String notes;
}