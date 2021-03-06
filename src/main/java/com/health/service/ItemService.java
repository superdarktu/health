package com.health.service;

import com.health.model.po.Item;

import java.util.List;

public interface ItemService {
    List<Item> pageByKeyWord(Integer programId);

    int deleteByPrimaryKey(String no);

    int deleteByPid(Integer id);

    int insert(Item record);

}