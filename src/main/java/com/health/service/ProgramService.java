package com.health.service;

import java.util.List;

import com.health.model.po.Program;
import com.health.model.vo.ProgramVO;

public interface ProgramService {
	
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	boolean deleteByPrimaryKey(String no);


    /**
     * 根据no查询
     * @param no
     * @return
     */
    List<ProgramVO> selectByNo(String no);


    /**
     * 分页查询
     * @param program
     * @param page
     * @param pageSize
     * @return
     */
    List<Program> page(Program program,Integer page,Integer pageSize);



    boolean addProgram(List<ProgramVO> list,String no);

}