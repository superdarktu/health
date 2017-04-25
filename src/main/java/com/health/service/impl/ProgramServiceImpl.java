package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.po.Program;
import com.health.service.ProgramService;
import com.health.util.SQLManager;

@Service
public class ProgramServiceImpl implements ProgramService{
	
	@Autowired
   	private SQLManager sqlManager;

	/**
	 * 根据ID删除
	 */
	public boolean deleteByPrimaryKey(Integer id) {
		
		return sqlManager.delete("program.deleteByPrimaryKey", id) > 0 ? true : false;
	}

	/**
	 * 添加
	 */
	public int insert(Program program) {
		
		return sqlManager.insert("program.insert", program);
	}

	/**
	 * 根据ID查询
	 */
	public Program selectByPrimaryKey(Integer id) {
		
		return (Program) sqlManager.query("program.selectByPrimaryKey", id);
	}

	/**
	 * 修改
	 */
	public boolean updateByPrimaryKeySelective(Program program) {
		
		return sqlManager.update("program.updateByPrimaryKeySelective", program) > 0 ? true : false;
	}

	/**
	 * 分页查询
	 */
	public List<Program> page(Program program, Integer page, Integer pageSize) {
		
		return (List<Program>) sqlManager.list("program.page", program, page, pageSize);
	}

}
