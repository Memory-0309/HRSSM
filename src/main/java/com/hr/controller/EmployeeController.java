package com.hr.controller;

import com.hr.comm.Result;
import com.hr.pojo.Employee;
import com.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("{page}")
    public String showPage(@PathVariable String page){
        return page;
    }


   /* @RequestMapping("/login")
    public String showLogin(){
        System.out.println("员工登录");
        return "login";
    }

    @RequestMapping("/welcome")
    public String showWelcome(){
        return "welcome";
    }
*/




    @RequestMapping("checkLogin")
    public String checkLogin(Integer employeeNumber, String password, HttpSession session){
       Result result = employeeService.checkLogin(employeeNumber,password);
       if (result != null){
           System.out.println(result);
           Employee employee = (Employee) result.getObject();
           session.setAttribute("loged",employee);
           if ("人事部主任".equals(result.getMessage())){
               return "admin/index1";
           }else if ("人事部员工".equals(result.getMessage())){
               return "admin/index2";
           }else if ("部门主任".equals(result.getMessage())){
               return "admin/index3";
           }else{
               return "admin/index4";
           }
       }else {
           return "redirect:/employee/login";
       }


    }
}
