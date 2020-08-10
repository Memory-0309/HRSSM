package com.hr.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@ToString
@Accessors(chain = true)
public class Attendance {
    private Integer id;
    private Integer employeeNumber;
    private Date day;
    private String timeType;
    private Date startTime;
    private String startType;
    private Date endTime;
    private String endType;
    private String workType;
    private String notes;
}
