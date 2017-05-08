package com.health.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.po.Food;
import com.health.model.ro.ResultRO;
import com.health.service.FoodService;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping("/test")
    @ResponseBody
    public int home() {
        return foodService.deleteByPrimaryKey(1);
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
    public ResultRO listFood(int page, int pageSize, String name) {
        Food record = new Food();
        record.setName(name);
        record.setSort(name);
        return new ResultRO(foodService.pageByKeyWord(record, page, pageSize));
    }

    /**
     * 增加或修改
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultRO insertOrUpdate(Food record) {
    	
    	if(record.getId() == null){
    		if(foodService.insert(record) > 0){
    			return new ResultRO(true);
    		}
    	}else{
    		if(foodService.updateByPrimaryKeySelective(record) > 0){
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
    	
    	if(foodService.deleteByPrimaryKey(id) > 0){
    		return new ResultRO(true);
    	}
        return new ResultRO("删除失败");
    }
}
