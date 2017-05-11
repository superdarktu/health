package com.health.controller;

import com.health.model.po.Student;
import com.health.model.ro.ResultRO;
import com.health.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("to_edit")
    public String toEdit(Map<String, Object> map, HttpServletRequest req) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        map.put("student", studentService.selectByPrimaryKey(1));
        return "student/edit";
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultRO update(HttpServletRequest req, Student student) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        student.setId(1);
        if (studentService.update(student)) {

            return new ResultRO(true, "../default");
        }
        return new ResultRO("保存失败");
    }

    @RequestMapping("admin_update")
    @ResponseBody
    public ResultRO adminUpdate(HttpServletRequest req, Student student) {

        if (studentService.update(student)) {

            return new ResultRO(true);
        }
        return new ResultRO("保存失败");
    }

    @RequestMapping("add")
    @ResponseBody
    public ResultRO add(HttpServletRequest req, Student student) {

        if (studentService.insert(student) > 0) {

            return new ResultRO(true);
        }
        return new ResultRO("添加失败");
    }

    @RequestMapping("list")
    @ResponseBody
    public ResultRO list(String keyword, Integer page, Integer pageSize) {

        Student student = new Student();
        student.setName(keyword);
        student.setNo(keyword);
        return new ResultRO(studentService.page(student, page, pageSize));
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultRO delete(Integer id) {

        if (studentService.deleteByPrimaryKey(id)) {

            return new ResultRO(true);
        }
        return new ResultRO("删除失败");
    }
}
