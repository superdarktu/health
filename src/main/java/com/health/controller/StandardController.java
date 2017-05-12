package com.health.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.health.model.po.Standard;
import com.health.model.ro.ResultRO;
import com.health.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/standard")
public class StandardController {


    @Autowired
    private StandardService standardService;


    @RequestMapping("add")
    @ResponseBody
    public ResultRO add(String json) throws  Exception{

        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Standard.class);
        List<Standard> lst =  (List<Standard>)mapper.readValue(json, javaType);

        if(standardService.insert(lst) >0){
            return new ResultRO(true);
        }
        return new ResultRO("添加失败");
    }

    @RequestMapping("list")
    @ResponseBody
    public ResultRO list(String name){

        return new ResultRO(standardService.selectByPrimaryKey(name));
    }

}
