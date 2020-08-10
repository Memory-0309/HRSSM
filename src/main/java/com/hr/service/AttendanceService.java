package com.hr.service;

import com.hr.vo.EmpAttendVO;

import java.util.List;

public interface AttendanceService {
    void insertStart(Integer empNumber);
    void insertEnd(Integer empNumber);


    //根据员工职位不同 返回不同的集合
    List<EmpAttendVO> selectLeveByEmpnumber(Integer employeeNumber);


}
