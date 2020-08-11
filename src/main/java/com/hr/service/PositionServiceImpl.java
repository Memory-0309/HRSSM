package com.hr.service;

import com.hr.dao.PositionDao;
import com.hr.pojo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    PositionDao positionDao;

    @Override
    public List<Position> findIdName() {
        List<Position> list = positionDao.findIdName();
        return list;
    }
}
