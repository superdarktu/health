package com.health.service;

import com.health.model.po.Food;

import java.util.List;

public interface FoodService {
    List<Food> pageByKeyWord(Food record, Integer page, Integer pageSize);

    List<Food> pageByName(Food record);

    Integer deleteByPrimaryKey(Integer id);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);

    int save(Food record);
}