package com.health.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.health.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.health.service.StudentService;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;
	
	
	@RequestMapping("/index")
	public String index(Map<String,Object> map,HttpServletRequest req){
		
		HttpSession session = req.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		map.put("student", studentService.selectByPrimaryKey(1));
		return "index";
	}



	@RequestMapping("/manage_index")
	public String manageIndex(Map<String,Object> map,HttpServletRequest req){

		return "manage/index";
	}

	@RequestMapping("/teacher_index")
	public String teacherIndex(Map<String,Object> map,HttpServletRequest req){

		HttpSession session = req.getSession();
		Integer teacherId = (Integer)session.getAttribute("teacherId");
		map.put("teacher", teacherService.selectByPrimaryKey(1));
		return "teacher/index";
	}

	@RequestMapping("/teacher_about")
	public String teacherAbout(Map<String,Object> map,HttpServletRequest req){

		HttpSession session = req.getSession();
		Integer teacherId = (Integer)session.getAttribute("teacherId");
		map.put("teacher", teacherService.selectByPrimaryKey(1));
		return "teacher/index";
	}
	
	@RequestMapping("/default")
	public String defaultt(Map<String,Object> map,HttpServletRequest req){
		
		HttpSession session = req.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		map.put("student", studentService.selectByPrimaryKey(1));
		return "student/default";
	}
}
