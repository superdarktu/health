package com.health.service;

import com.health.model.po.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> pageByKeyWord(Equipment record, Integer page, Integer pageSize);

    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

    int save(Equipment record);
}