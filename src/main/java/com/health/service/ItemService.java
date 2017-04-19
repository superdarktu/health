package com.health.service;

import com.health.model.po.Item;

public interface ItemService {
    int deleteByPrimaryKey(Integer programId);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer programId);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}