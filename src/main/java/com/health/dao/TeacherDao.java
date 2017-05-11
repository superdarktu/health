package com.health.dao;

import com.health.model.po.Teacher;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDao {

    @Autowired
    private SQLManager sqlManager;

    public int insert(Teacher teacher) {

        return sqlManager.insert("teacher.insert", teacher);
    }

    public Teacher query(Integer id) {

        return (Teacher) sqlManager.query("teacher.selectByPrimaryKey", id);
    }

    @SuppressWarnings("unchecked")
    public List<Teacher> list(Teacher teacher, Integer page, Integer pageSize) {

        return (List<Teacher>) sqlManager.list("teacher.selectByStr", teacher, page, pageSize);
    }

    public boolean delete(Integer id) {

        return sqlManager.delete("teacher.deleteByPrimaryKey", id) > 0 ? true : false;
    }

    public boolean update(Teacher teacher) {

        return sqlManager.update("teacher.updateByPrimaryKeySelective", teacher) > 0 ? true : false;
    }

    public Integer count() {

        return sqlManager.count("teacher.count", null);
    }

}
