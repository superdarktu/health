package com.health.service;

import com.health.model.po.Item;

import java.util.List;

public interface ItemService {
    List<Item> pageByKeyWord(Item record, Integer page, Integer pageSize);

    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}