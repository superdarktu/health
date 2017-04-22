package com.health.service;

import com.health.model.po.Class;

import java.util.List;

public interface ClassService {
    List<Class> pageByKeyWord(Class record, Integer page, Integer pageSize);

    int deleteByPrimaryKey(Integer id);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}