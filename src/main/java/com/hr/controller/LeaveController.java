package com.hr.controller;


import com.hr.pojo.Lea;
import com.hr.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("leave")
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    @RequestMapping("toAdd")
    public String toAdd(){
        return "admin/leave_add";
    }
    @RequestMapping("add")
    public String add(Lea lea){
        System.out.println(lea);
        leaveService.insertLea(lea);
        return "admin/leave_add";
    }

    @RequestMapping("notlist")
    public String notlist(HttpServletRequest request){
        List<Lea> lea = leaveService.findAllNotList();
        request.setAttribute("lea",lea);
        return "admin/leave_notlist";
    }

    @RequestMapping("{id}/update")
    public String updateStatus(@PathVariable Integer id) {
        leaveService.updateStatus(id);
        return "redirect:/leave/notlist";
    }

}
