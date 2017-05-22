package com.health.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.po.Student;
import com.health.model.po.TestData;
import com.health.model.ro.ResultRO;
import com.health.service.ProgramService;
import com.health.service.StudentService;
import com.health.service.TestDataService;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private ProgramService programService;
    
    @Autowired
    private TestDataService testDataService;

    @RequestMapping("to_edit")
    public String toEdit(Map<String, Object> map, HttpServletRequest req) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        map.put("student", studentService.selectByPrimaryKey(userId));
        return "student/edit";
    }
    
    @RequestMapping("to_plan")
    public String toPlan(Map<String,Object> map,HttpServletRequest req){
    	
    	HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        Student student = studentService.selectByPrimaryKey(userId);
        if(student.getJsfaid() != null){
        	map.put("pv",programService.getProgram(student.getJsfaid()));
        }
    	return "student/plan";
    }
    
    @RequestMapping("to_effect")
    public String toEffect(Map<String,Object> map, HttpServletRequest req){
    	
    	HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        Student student = studentService.selectByPrimaryKey(userId);
        TestData td = testDataService.queryByStudentLast(userId);
        if(td == null) return "student/effect";
    	map.put("testData",td);
    	map.put("no",student.getJsfaid());
    	map.put("student", student);
    	return "student/effect";
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultRO update(HttpServletRequest req, Student student) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        student.setId(userId);
        if (studentService.update(student)) {

            return new ResultRO(true, "../default");
        }
        return new ResultRO("保存失败");
    }

    @RequestMapping("admin_update")
    @ResponseBody
    public ResultRO adminUpdate(HttpServletRequest req, Student student) {

        if (studentService.update(student)) {

            return new ResultRO(true,"user");
        }
        return new ResultRO("保存失败");
    }

    @RequestMapping("add")
    @ResponseBody
    public ResultRO add(HttpServletRequest req, Student student) {

        if (studentService.insert(student) > 0) {

            return new ResultRO(true,"user");
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

            return new ResultRO(true,"user");
        }
        return new ResultRO("删除失败");
    }
}
