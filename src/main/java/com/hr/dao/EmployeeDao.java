package com.hr.dao;

import com.hr.pojo.Employee;
import com.hr.pojo.History;
import com.hr.vo.EmpDeptPosVO;
import com.hr.vo.EmployeePositionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    //删除员工 -- 从emp表中删除
    void deleteEmpById(Integer id);
    //删除员工 -- 往history表中添加
    void addHistory(History history);
    //根据id查询此员工所有信息
    History selectById(Integer id);


    //新增员工
    void addEmp(Employee employee);
    //获取最大员工编号
    Integer findMaxEmpNumber();

    //查询在职员工信息
    List<EmpDeptPosVO> findAll();
    //根据员工编号查询员工信息
    Employee findByNumber(@Param("number") Integer number);
    EmployeePositionVO findByNumberVO(@Param("number") Integer number);
}
