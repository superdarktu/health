package com.health.controller;

import com.health.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.service.LoginService;

@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @RequestMapping("/test")
    @ResponseBody
    public int home() {
        return classService.deleteByPrimaryKey(1);
    }

    /**
     * 首页跳转
     */
    @RequestMapping("/toIndex")
    public int toIndex() {
        return 111;
    }

    /**
     * 查询list
     */

    /**
     * 增加
     */

    /**
     * 删除
     */


    /**
     * 修改
     */
}
