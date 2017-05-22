package com.health.service;

import com.health.model.po.Teacher;

import java.util.List;

public interface TeacherService {

    /**
     * 删除教练
     *
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(Integer id);

    /**
     * 添加教练
     *
     * @param teacher
     * @return
     */
    int insert(Teacher teacher);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    Teacher selectByPrimaryKey(Integer id);

    /**
     * 根据登录ID查询
     *
     * @param id
     * @return
     */
    Teacher selectByLoginId(Integer loginId);

    /**
     * 修改信息
     *
     * @param teacher
     * @return
     */
    boolean updateByPrimaryKeySelective(Teacher teacher);

    /**
     * 分页查询
     *
     * @param teacher
     * @param page
     * @param pageSize
     * @return
     */
    List<Teacher> page(Teacher teacher, Integer page, Integer pageSize);
    
    Teacher login(String username,String password);
}