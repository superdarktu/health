package com.health.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.health.service.StudentService;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("/index")
	public String index(Map<String,Object> map,HttpServletRequest req){
		
		HttpSession session = req.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		map.put("student", studentService.selectByPrimaryKey(1));
		return "index";
	}
	
	
	
	@RequestMapping("/manage_index")
	public String manageIndex(Map<String,Object> map,HttpServletRequest req){
		
		return "index";
	}
	
	@RequestMapping("/default")
	public String defaultt(Map<String,Object> map,HttpServletRequest req){
		
		HttpSession session = req.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		map.put("student", studentService.selectByPrimaryKey(1));
		return "student/default";
	}
}
