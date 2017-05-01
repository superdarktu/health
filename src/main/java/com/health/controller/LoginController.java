package com.health.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.po.Login;
import com.health.model.po.Student;
import com.health.model.po.Teacher;
import com.health.model.ro.ResultRO;
import com.health.service.LoginService;
import com.health.service.StudentService;
import com.health.service.TeacherService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/login")
    public String login() {
		return "login";
    }
	
	@RequestMapping("/admin_login")
    public String aaa() {
		return "admin_login";
    }
	
	/**
	 * 学员登录
	 * @param username
	 * @param password
	 * @param req
	 * @return
	 */
	@RequestMapping("/login_in")
	@ResponseBody
	public  ResultRO loginIn(String username,String password,HttpServletRequest req){
		
		Login login = loginService.login(username, password);
		if(login != null && "3".equals(login.getUsertype())){
			
			Student student = studentService.selectByLoginId(login.getId());
			HttpSession session = req.getSession();
			session.setAttribute("userId", student.getId());
			return new ResultRO(true,"index");
		}
		
		return new ResultRO("用户名不存在或者用户名密码错误");
	}
	
	/**
	 * 管理员或者教练登录
	 * @param username
	 * @param password
	 * @param req
	 * @return
	 */
	@RequestMapping("/admin_login_in")
	@ResponseBody
	public ResultRO adminLoginIn(String username,String password,HttpServletRequest req){
		
		Login login = loginService.login(username, password);
		if(login != null ){
			
			if("1".equals(login.getUsertype())){
				
				HttpSession session = req.getSession();
				session.setAttribute("isManage", 1);
				return new ResultRO(true,"manage_index");
			}
			if("2".equals(login.getUsertype())){
				Teacher teacher = teacherService.selectByLoginId(login.getId());
				HttpSession session = req.getSession();
				session.setAttribute("teacherId", teacher.getId());
				return new ResultRO(true,"teacher_index");
			}
			
		}
		
		return new ResultRO("用户名不存在或者用户名密码错误");
	}
	
	/*
	 * HttpSession session = req.getSession();
		Login login = loginService.login(username, password);
	 */
}
