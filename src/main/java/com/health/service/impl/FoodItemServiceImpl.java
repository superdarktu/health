package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.po.FoodItem;
import com.health.service.FoodItemService;
import com.health.util.SQLManager;

@Service
public class FoodItemServiceImpl implements FoodItemService{
	
	@Autowired
	private SQLManager sqlManage;

	public int insert(FoodItem record) {
		
		return sqlManage.insert("foodItem.insert", record);
	}

	@Override
	public List<FoodItem> selectByProgramId(Integer programId) {
		
		return (List<FoodItem>) sqlManage.list("foodItem.selectByPrimaryKey", programId);
	}

	public int deleteByPid(Integer pid) {

		return  sqlManage.delete("foodItem.deleteByPid", pid);
	}

}
