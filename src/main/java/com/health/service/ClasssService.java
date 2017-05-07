package com.health.service;

import com.health.model.po.Classs;

import java.util.List;

public interface ClasssService {
    List<Classs> pageByKeyWord(Classs record, Integer page, Integer pageSize);
    
    List<Classs> pageByName(String name);

    int deleteByPrimaryKey(Integer id);

    int insert(Classs record);

    int insertSelective(Classs record);

    Classs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classs record);

    int updateByPrimaryKey(Classs record);

    int save(Classs record);
}