package com.health.service;

import com.health.model.po.Program;

public interface ProgramService {
    int deleteByPrimaryKey(Integer id);

    int insert(Program record);

    int insertSelective(Program record);

    Program selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Program record);

    int updateByPrimaryKey(Program record);
}