package com.hr.controller;

import com.hr.service.AttendanceService;
import com.hr.vo.EmpAttendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping("oneself")
    public String oneself(Integer employeeNumber, HttpServletRequest request){
      List<EmpAttendVO> list = attendanceService.selectLeveByEmpnumber(employeeNumber);
      request.setAttribute("aList",list);
      return "admin/attendance_list";
    }
}
