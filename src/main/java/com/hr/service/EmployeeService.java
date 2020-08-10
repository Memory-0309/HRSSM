package com.hr.service;

import com.hr.comm.Result;

public interface EmployeeService {

    Result checkLogin(Integer employeeNumber, String password);


}
