package com.health.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.po.Student;
import com.health.model.ro.ResultRO;
import com.health.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("to_edit")
	public String toEdit(Map<String,Object> map,HttpServletRequest req){
		
		HttpSession session = req.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		map.put("student", studentService.selectByPrimaryKey(1));
		return "student/edit";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResultRO update(HttpServletRequest req,Student student){
		
		HttpSession session = req.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		student.setId(1);
		if(studentService.update(student)){
			
			return new ResultRO(true,"../default");
		}
		return new ResultRO("保存失败");
	}
}
