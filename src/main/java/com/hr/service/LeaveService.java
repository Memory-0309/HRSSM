package com.hr.service;

import com.hr.pojo.Lea;

import java.util.List;

public interface LeaveService {
    void insertLea(Lea lea);

    List<Lea> findAllNotList();

    void updateStatus(Integer id);

}
