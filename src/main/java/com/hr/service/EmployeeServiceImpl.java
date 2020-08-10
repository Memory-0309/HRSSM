package com.hr.service;

import com.hr.comm.Result;
import com.hr.dao.EmployeeDao;
import com.hr.pojo.Employee;
import com.hr.vo.EmployeePositionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;
    @Override
    public Result checkLogin(Integer employeeNumber, String password) {
        Employee employee= employeeDao.findByNumber(employeeNumber);
        Result result = null;
        if (employee == null){
            return null;
        }
        if (password.equals(employee.getPassword())){
            EmployeePositionVO vo = employeeDao.findByNumberVO(employeeNumber);
            result = new Result(vo.getLevel(),1,employee);
            return result;
        }else {
            return  result;
        }
    }
}