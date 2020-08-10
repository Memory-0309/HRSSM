package com.hr.dao;

import com.hr.pojo.Employee;
import com.hr.vo.EmployeePositionVO;
import org.apache.ibatis.annotations.Param;

public interface EmployeeDao {
    //根据员工编号查询员工信息
    Employee findByNumber(@Param("number") Integer number);

    EmployeePositionVO findByNumberVO(@Param("number") Integer number);

}
