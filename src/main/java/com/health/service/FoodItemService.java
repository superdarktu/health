package com.health.service;

import java.util.List;

import com.health.model.po.FoodItem;

public interface FoodItemService {

    int insert(FoodItem record);

    List<FoodItem> selectByProgramId(Integer programId);

}