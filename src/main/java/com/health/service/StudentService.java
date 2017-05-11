package com.health.service;

import com.health.model.po.Student;
import com.health.model.vo.ProgramVO;

import java.util.List;

public interface StudentService {

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(Integer id);

    /**
     * 添加
     *
     * @param student
     * @return
     */
    int insert(Student student);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    Student selectByPrimaryKey(Integer id);

    /**
     * 根据登录ID查询
     *
     * @param loginId
     * @return
     */
    Student selectByLoginId(Integer loginId);

    /**
     * 修改
     *
     * @param student
     * @return
     */
    boolean update(Student student);

    /**
     * 分页查询
     *
     * @param student
     * @param page
     * @param pageSize
     * @return
     */
    List<Student> page(Student student, Integer page, Integer pageSize);

    List<ProgramVO> getProgram(Integer studentId);
}