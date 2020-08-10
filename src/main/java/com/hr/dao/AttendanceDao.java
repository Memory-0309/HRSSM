package com.hr.dao;

import com.hr.pojo.Attendance;
import com.hr.vo.EmpAttendVO;

import java.util.List;

public interface AttendanceDao {
    //上班插入员工考勤
    void insertStart(Attendance attendance);

    //下班修改员工考勤-实际执行update语句 根据员工编号和当前日期
    void insertEnd(Attendance attendance);

    //根据员工编号，查出该员工的职位
    String selectLeveByEmpnumber(Integer employeeNumber);
    //部门员工查询自己的考勤信息
    List<EmpAttendVO> selectAttendanceByEmpnumber(Integer employeeNumber);
    //部门主任查询本部门的考勤信息
    List<EmpAttendVO> selectDeptnoAttendance(Integer employeeNumber);
    //人事部查询所有人的考勤信息
    List<EmpAttendVO> selectAllAttendance();

}
