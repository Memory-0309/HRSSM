package com.hr.dao;

import com.hr.pojo.Lea;

import java.util.List;

public interface LeaveDao {
    void insertLea(Lea lea);

    List<Lea> findAllNotList();

    void updateStatus(Integer id);
}
