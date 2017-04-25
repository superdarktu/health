package com.health.service;

import java.util.List;

import com.health.model.po.Program;

public interface ProgramService {
	
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	boolean deleteByPrimaryKey(Integer id);

    /**
     * 添加
     * @param program
     * @return
     */
    int insert(Program program);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Program selectByPrimaryKey(Integer id);

    /**
     * 修改
     * @param program
     * @return
     */
    boolean updateByPrimaryKeySelective(Program program);
    
    /**
     * 分页查询
     * @param program
     * @param page
     * @param pageSize
     * @return
     */
    List<Program> page(Program program,Integer page,Integer pageSize);

}