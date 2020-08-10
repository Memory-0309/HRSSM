package com.hr.controller;

import com.hr.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;
    @RequestMapping("addStart")
    public String addStart(Integer employeeNumber){
        System.out.println("上班考勤插入");
        attendanceService.insertStart(employeeNumber);
        return "welcome";
    }

    @RequestMapping("addEnd")
    public String addEnd(Integer employeeNumber){
        System.out.println("下班考勤插入");
        attendanceService.insertEnd(employeeNumber);
        return "welcome";
    }

}
