package com.health.controller;

import com.health.model.ro.ResultRO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/info")
public class InfoController {


    @RequestMapping("/to_search")
    public String to_search() {

        return "info/search";
    }

    @RequestMapping("/search")
    @ResponseBody
    public ResultRO search(String name) {

        return new ResultRO("查询失败");
    }
}
