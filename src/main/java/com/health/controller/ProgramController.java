package com.health.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.health.model.po.Program;
import com.health.model.po.Standard;
import com.health.model.ro.ResultRO;
import com.health.model.vo.ProgramVO;
import com.health.service.ProgramService;

/**
 * Created by Administrator on 2017/5/9.
 */
@Controller
@RequestMapping("/program")
public class ProgramController {

	@Autowired
	private ProgramService service;

    // JavaType javaType = getCollectionType(ArrayList.class, YourBean.class);
    //List<YourBean> lst =  (List<YourBean>)mapper.readValue(jsonString, javaType);
	
	@RequestMapping("add")
    @ResponseBody
    public ResultRO add(HttpServletRequest req ,String json) throws  Exception{

        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Standard.class);
        ProgramVO pv =  (ProgramVO)mapper.readValue(json, ProgramVO.class);
        HttpSession session = req.getSession();
        String teacherNo = (String) session.getAttribute("teacherNo");
        
        pv.setTeacherNo(teacherNo);
        if(service.insert(pv)){
            return new ResultRO(true,"to_plan");
        }
        return new ResultRO("添加失败");
    }
	
	
	@RequestMapping("list")
    @ResponseBody
    public ResultRO list(Program program,Integer page, Integer pageSize){
		
		return new ResultRO(service.page(program,page, pageSize));
	}
	
	@RequestMapping("delete")
    @ResponseBody
    public ResultRO delete(String no){
		
		if(service.deleteByPrimaryKey(no)){
			return new ResultRO(true);
		}
		return new ResultRO("删除失败");
	}
	
	@RequestMapping("update")
    @ResponseBody
    public ResultRO update(String json){
		
		try{
			
			ObjectMapper mapper = new ObjectMapper();
	        ProgramVO pv =  (ProgramVO)mapper.readValue(json, ProgramVO.class);
	        service.update(pv);
		}catch(Exception e){
			e.printStackTrace();
			return new ResultRO("修改失败");
		}
		return new ResultRO("修改失败");
	}
	
}
