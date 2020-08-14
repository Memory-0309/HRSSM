package com.hr.service;

import com.hr.dao.EmployeeDao;
import com.hr.dao.LeaveDao;
import com.hr.pojo.Employee;
import com.hr.pojo.Lea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService{

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    LeaveDao leaveDao;

    @Override
    public void insertLea(Lea lea) {
        Employee employee =
                employeeDao.findByNumber(lea.getEmployeeNumber());
        lea.setDepartmentNumber(employee.getDepartmentNumber());
        leaveDao.insertLea(lea);
    }

    @Override
    public List<Lea> findAllNotList() {
        List<Lea> lea = leaveDao.findAllNotList();
        return lea;
    }

    @Override
    public void updateStatus(Integer id) {
        leaveDao.updateStatus(id);
    }


}
