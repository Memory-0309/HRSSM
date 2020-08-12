package com.hr.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@ToString
@Accessors(chain = true)
public class History {
    private Integer id;
    private Integer employeeNumber;
    private String name;
    private String gender;
    private Date birthday;
    private String telephone;
    private String email;
    private String address;
    private String photo;
    private String education;
    private Date inTime;
    private Date outTime;
    private Integer departmentNumber;
    private Integer positionNumber;
    private String status;
    private String home;
    private String notes;
}