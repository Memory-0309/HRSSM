package com.hr.vo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class EmpDeptEchartsVO {
    private String deptName;
    private Integer deptSum;
}
