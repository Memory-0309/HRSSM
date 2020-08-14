package com.hr.service;

import com.hr.comm.Result;
import com.hr.dao.EmployeeDao;
import com.hr.pojo.Employee;
import com.hr.pojo.History;
import com.hr.vo.EmpDeptEchartsVO;
import com.hr.vo.EmpDeptPosVO;
import com.hr.vo.EmployeePositionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<EmpDeptEchartsVO> showEcharts() {
        List<EmpDeptEchartsVO> list = employeeDao.findEcharts();
        return list;
    }
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

    @Override
    public List<EmpDeptPosVO> empList() {
        List<EmpDeptPosVO> list = employeeDao.findAll();
        return list;
    }

    @Override
    public void addEmp(Employee employee) {
        System.out.println(employee);
        employee.setInTime(new Date());
        employeeDao.addEmp(employee);
    }

    @Override
    public Integer finMaxEmpNumber() {
        Integer maxnumber = employeeDao.findMaxEmpNumber();
        return maxnumber+1;
    }

    @Override
    public void deleteEmpById(Integer id) {
        //首先根据ID去查询此员工的所有信息
        History history = employeeDao.selectById(id);
        //将查询出来的此员工的所有信息封装到History中
        history.setOutTime(new Date());
        history.setStatus("离职");
        history.setId(null);
        //删除emp表中数据
        employeeDao.deleteEmpById(id);
        //往history中添加一条数据
        employeeDao.addHistory(history);
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = employeeDao.findById(id);
        return employee;
    }

    @Override
    public void updateEmp(History history) {
        if (history.getStatus().equals("在职")){
            employeeDao.updateEmp(history);
        }else {
            //首先根据ID去查询此员工的所有信息
            employeeDao.selectById(history.getId());
            //将查询出来的此员工的所有信息封装到History中
            history.setOutTime(new Date());
            history.setStatus(history.getStatus());
            //删除emp表中数据
            Integer id= history.getId();
            employeeDao.deleteEmpById(id);
            history.setId(null);
            //往history中添加一条数据
            //可以补充先删除原有的数据 在往里插入  可以解决数据重复问题
            employeeDao.addHistory(history);
        }
    }
}
