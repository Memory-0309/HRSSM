package com.hr.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
@Accessors(chain = true)
public class Lea {
    private Integer id;
    private Integer employeeNumber;
    private Integer departmentNumber;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;
    private String days;
    private String reason;
    private String type;
    private String manager;
    private String status;
    private String notes;
}
