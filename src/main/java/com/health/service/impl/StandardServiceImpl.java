package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.po.Standard;
import com.health.service.StandardService;
import com.health.util.SQLManager;

@Service
public class StandardServiceImpl implements StandardService{
	
	@Autowired
	private SQLManager sqlManager;

	/**
	 * 删除
	 */
	public boolean deleteByPrimaryKey(Integer id) {
		
		return sqlManager.delete("standard.delete", id) > 0 ? true : false;
	}

	/**
	 * 添加
	 */
	public int insert(Standard standard) {
		
		return sqlManager.insert("standard.insert", standard);
	}

	/**
	 * 根据ID查询
	 */
	public Standard selectByPrimaryKey(Integer id) {
		
		return (Standard) sqlManager.query("standard.query", id);
	}

	/**
	 * 修改
	 */
	public boolean updateByPrimaryKeySelective(Standard standard) {
		
		return sqlManager.update("standard.update", standard) > 0 ? true : false;
	}

	/**
	 * 分页查询
	 */
	public List<Standard> page(Standard standard, Integer page, Integer pageSize) {
			
		return (List<Standard>) sqlManager.list("standard.page", standard, page, pageSize);
	}
	
	public List<Standard> list(Standard standard) {
		
		return (List<Standard>) sqlManager.list("standard.page", standard);
	}
	
	public List<Standard> getAllByAge(Integer  age) {
		
		return (List<Standard>) sqlManager.list("standard.list", age);
	}

}
