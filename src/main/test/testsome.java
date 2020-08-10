import com.hr.dao.AttendanceDao;
import com.hr.vo.EmpAttendVO;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testsome {

    @Test
    public void testInsertStart(){
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("spring/spring-config.xml");
        AttendanceDao ad =ac.getBean("attendanceDao", AttendanceDao.class);
        String leve = ad.selectLeveByEmpnumber(1001);
        System.out.println(leve);
        List<EmpAttendVO> list1 = ad.selectAttendanceByEmpnumber(1001);
        System.out.println("list1"+list1);
        List<EmpAttendVO> list2 =ad.selectDeptnoAttendance(1008);
        System.out.println("list2"+list2);
        List<EmpAttendVO> list3 = ad.selectAllAttendance();
        System.out.println("list3"+list3);
    }
}
