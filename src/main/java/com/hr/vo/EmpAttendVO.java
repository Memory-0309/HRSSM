package com.hr.vo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
//用来显示签到信息的VO
@Data
@ToString
@Accessors(chain = true)
public class EmpAttendVO {
    private Integer employeeNumber;
    private String name;
    private Date day;
    private String timeType;
    private Date startTime;
    private String startType;
    private Date endTime;
    private String endType;
}
