package com.health.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.po.Student;
import com.health.model.po.Teacher;
import com.health.model.ro.ResultRO;
import com.health.service.TeacherService;


@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("admin_update")
	@ResponseBody
	public ResultRO adminUpdate(HttpServletRequest req,Teacher teacher){
		
		if(teacherService.updateByPrimaryKeySelective(teacher)){
			
			return new ResultRO(true);
		}
		return new ResultRO("保存失败");
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ResultRO add(HttpServletRequest req,Teacher teacher){
		
		if(teacherService.insert(teacher) > 0){
			
			return new ResultRO(true);
		}
		return new ResultRO("添加失败");
	}
	
	@RequestMapping("list")
	@ResponseBody
	public ResultRO list(String keyword,Integer page ,Integer pageSize){
		
		Teacher teacher  = new Teacher();
		teacher.setName(keyword);
		teacher.setNo(keyword);
		return new ResultRO(teacherService.page(teacher, page, pageSize));
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public ResultRO delete(Integer id){
		
		if(teacherService.deleteByPrimaryKey(id)){
			
			return new ResultRO(true);
		}
		return new ResultRO("删除失败");
	}
}