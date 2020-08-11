package com.hr.service;

import com.hr.comm.Result;
import com.hr.vo.EmpDeptPosVO;

import java.util.List;

public interface EmployeeService {
    //登录
    Result checkLogin(Integer employeeNumber, String password);

    //返回在职员工列表
    List<EmpDeptPosVO> empList();


}
