package com.health.dao;

import com.health.model.po.Student;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private SQLManager sqlManager;

    public int insert(Student student) {

        return sqlManager.insert("student.insert", student);
    }

    public Student query(Integer id) {

        return (Student) sqlManager.query("student.selectByPrimaryKey", id);
    }

    @SuppressWarnings("unchecked")
    public List<Student> list(Student student, Integer page, Integer pageSize) {

        return (List<Student>) sqlManager.list("student.selectByStr", student, page, pageSize);
    }

    public boolean delete(Integer id) {

        return sqlManager.delete("student.deleteByPrimaryKey", id) > 0 ? true : false;
    }

    public boolean update(Student student) {

        return sqlManager.update("student.updateByPrimaryKeySelective", student) > 0 ? true : false;
    }

    public Integer count() {

        return sqlManager.count("student.count", null);
    }
}
