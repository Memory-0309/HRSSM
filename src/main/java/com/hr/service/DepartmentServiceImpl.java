package com.hr.service;

import com.hr.dao.DepartmentDao;
import com.hr.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentDao departmentDao;
    @Override
    public List<Department> findIdName() {
        List<Department> list =departmentDao.findIdName();
        return list;
    }
}
