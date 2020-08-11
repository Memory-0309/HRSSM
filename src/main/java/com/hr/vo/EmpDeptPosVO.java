package com.hr.vo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 此VO用来做员工管理
 */
@Data
@ToString
@Accessors(chain = true)
public class EmpDeptPosVO {
    private Integer empId;
    private Integer employeeNumber;
    private String empName;
    private String gender;
    private String telephone;
    private String deptName;
    private String positionName;
    private Date inTime;
}
