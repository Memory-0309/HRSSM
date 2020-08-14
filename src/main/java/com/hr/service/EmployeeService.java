package com.hr.service;

import com.hr.comm.Result;
import com.hr.pojo.Employee;
import com.hr.pojo.History;
import com.hr.vo.EmpDeptEchartsVO;
import com.hr.vo.EmpDeptPosVO;

import java.util.List;

public interface EmployeeService {
    //
    List<EmpDeptEchartsVO> showEcharts();

    //登录
    Result checkLogin(Integer employeeNumber, String password);

    //返回在职员工列表
    List<EmpDeptPosVO> empList();

    //新增员工
    void addEmp(Employee employee);

    //查询员工最大编号
    Integer finMaxEmpNumber();

    //删除员工
    void deleteEmpById(Integer id);

    //根据ID查询员工信息
    Employee findById(Integer id);

    //修改员工信息
    void updateEmp(History history);
}
