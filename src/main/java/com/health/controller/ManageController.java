package com.health.controller;


import com.health.service.StudentService;
import com.health.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/equipment")
    public String aaa() {
        return "manage/equipment";
    }

    @RequestMapping("/food")
    public String food() {
        return "manage/food";
    }


    @RequestMapping("/class")
    public String classs() {
        return "manage/class";
    }

    @RequestMapping("/user")
    public String user() {
        return "manage/user";
    }

    @RequestMapping("/usered")
    public String usered(Map<String,Object> map,Integer id) {

        map.put("student",studentService.selectByPrimaryKey(id));
        return "manage/usered";
    }

    @RequestMapping("/leader")
    public String leader() {
        return "manage/leader";
    }

    @RequestMapping("/leaded")
    public String leaded(Map<String,Object> map,Integer id) {

        map.put("teacher",teacherService.selectByPrimaryKey(id));
        return "manage/leaded";
    }
}
