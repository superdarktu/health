package com.health.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.po.Classs;
import com.health.model.po.Classs;
import com.health.model.ro.ResultRO;
import com.health.service.ClasssService;

@Controller
@RequestMapping("/classs")
public class ClasssController {

    @Autowired
    private ClasssService ClasssService;

    @RequestMapping("/test")
    @ResponseBody
    public int home() {
        return ClasssService.deleteByPrimaryKey(1);
    }

    /**
     * 首页跳转
     */
    @RequestMapping("toIndex")
    public int toIndex() {
        return 111;
    }

    /**
     * 查询list
     */
    @ResponseBody
    @RequestMapping("list")
    public ResultRO listClasss(int page, int pageSize,String name) {
        Classs record = new Classs();
        record.setName(name);
        return new ResultRO(ClasssService.pageByKeyWord(record, page, pageSize));
    }
    
    @ResponseBody
    @RequestMapping("search")
    public ResultRO search(String name){
    	
    	return new ResultRO("查询失败");
    }

    /**
     * 增加或修改
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultRO insertOrUpdate(Classs record) {
    	
    	if(record.getId() == null){
    		if(ClasssService.insert(record) > 0){
    			return new ResultRO(true);
    		}
    	}else{
    		if(ClasssService.updateByPrimaryKeySelective(record) > 0){
    			return new ResultRO(true);
    		}
    	}
    	
        return new ResultRO("保存失败");
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("delete")
    public ResultRO remove(Integer id) {
    	
    	if(ClasssService.deleteByPrimaryKey(id) > 0){
    		return new ResultRO(true);
    	}
        return new ResultRO("删除失败");
    }
}
