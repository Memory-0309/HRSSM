package com.hr.dao;

import com.hr.pojo.Position;

import java.util.List;

public interface PositionDao {
    //查询职称编号和职称名称
    List<Position> findIdName();
}
