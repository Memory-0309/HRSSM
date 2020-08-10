package com.hr.service;

import com.hr.dao.AttendanceDao;
import com.hr.pojo.Attendance;
import com.hr.vo.EmpAttendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Autowired
    AttendanceDao attendanceDao;
    @Override
    public void insertStart(Integer empNumber) {
        Date date = new Date();
        Attendance attendance = new Attendance();
        attendance.setId(null).setEmployeeNumber(empNumber).setDay(date)
                .setTimeType(date.getHours()<12?"上午":"下午")
                .setStartTime(date)
                .setStartType(date.getHours()<9?"正常":"迟到")
                .setWorkType(null).setNotes(null);
        attendanceDao.insertStart(attendance);
    }
    @Override
    public void insertEnd(Integer empNumber) {
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strdate = sdf.format(date);
            Date date1 = sdf.parse(strdate);
            Attendance attendance = new Attendance();
            attendance.setEmployeeNumber(empNumber)
                    .setDay(date1)
                    .setEndTime(date)
                    .setEndType(date.getHours()>18?"正常":"早退");
            attendanceDao.insertEnd(attendance);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<EmpAttendVO> selectLeveByEmpnumber(Integer employeeNumber) {
       String leve = attendanceDao.selectLeveByEmpnumber(employeeNumber);
       List<EmpAttendVO> list = null;
       if (leve.equals("部门员工")){
            list=attendanceDao.selectAttendanceByEmpnumber(employeeNumber);
       }else if (leve.equals("部门主任")){
            list = attendanceDao.selectDeptnoAttendance(employeeNumber);
       }else if (leve.equals("人事部员工") || leve.equals("人事部主任")){
            list = attendanceDao.selectAllAttendance();
       }
        return list;
    }
}
