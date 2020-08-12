package com.hr.controller;

import com.hr.comm.Result;
import com.hr.pojo.Department;
import com.hr.pojo.Employee;
import com.hr.pojo.Position;
import com.hr.service.DepartmentService;
import com.hr.service.EmployeeService;
import com.hr.service.PositionService;
import com.hr.vo.EmpDeptPosVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    PositionService positionService;

    @RequestMapping("{page}")
    public String showPage(@PathVariable String page){
        return page;
    }


    @RequestMapping("{id}/delete")
    public String delete(@PathVariable Integer id){
        System.out.println("删除的id为："+id);
        employeeService.deleteEmpById(id);
        return "redirect:/employee/empList";
    }

    @RequestMapping("add")
    public String add(Employee employee){
        System.out.println("controller:"+employee);
        employeeService.addEmp(employee);
        return "redirect:/employee/empList";
    }

    @RequestMapping("toAdd")
    public String toAdd(HttpServletRequest request){
        List<Department> dList = departmentService.findIdName();
        List<Position> pList = positionService.findIdName();
        Integer maxNumber =employeeService.finMaxEmpNumber();
        request.setAttribute("maxNumber",maxNumber);
        request.setAttribute("dList",dList);
        request.setAttribute("pList",pList);
        return "admin/employee_add";
    }
    @RequestMapping("empList")
    public String empList(HttpServletRequest request){
        List<EmpDeptPosVO> list = employeeService.empList();
        request.setAttribute("list",list);
        return "admin/employee_list";
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
