package com.hr.dao;

import com.hr.pojo.Department;

import java.util.List;

public interface DepartmentDao {
    //查询部门编号和部门名称
    List<Department> findIdName();
}
