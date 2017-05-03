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
import com.health.service.StudentService;
import com.health.service.TestDataService;


@Controller
@RequestMapping("/test_data")
public class TestDataController {

	@Autowired
	private TestDataService testDataService;
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("to_input")
	public String toInput(){
		
		return "test_data/input";
	}
	
	@RequestMapping("to_result")
	public String toResult(HttpServletRequest req,Map<String,Object> map){
		
		HttpSession session = req.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		map.put("data", testDataService.query(1));
		return "test_data/result";
	}
	
	@RequestMapping("create")
	@ResponseBody
	public ResultRO create(HttpServletRequest req,TestData testData){
		
		HttpSession session = req.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		Student student = studentService.selectByPrimaryKey(1);
		if(testDataService.insert(testData,student)>0){
			
			return new ResultRO(true,"to_result");
		}
		return new ResultRO("数据输入失败");
	}
}
