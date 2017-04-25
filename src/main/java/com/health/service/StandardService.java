package com.health.service;

import java.util.List;

import com.health.model.po.Standard;

public interface StandardService {
	
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
    boolean deleteByPrimaryKey(Integer id);

    /**
     * 添加
     * @param standard
     * @return
     */
    int insert(Standard standard);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Standard selectByPrimaryKey(Integer id);

    /**
     * 修改
     * @param standard
     * @return
     */
    boolean updateByPrimaryKeySelective(Standard standard);
    
    /**
     * 分页查询
     * @param standard
     * @param page
     * @param pageSize
     * @return
     */
    List<Standard> page(Standard standard,Integer page ,Integer pageSize);

}