package com.health.controller;

import com.health.model.ro.ResultRO;
import com.health.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/index")
    public String index(Map<String, Object> map) {

        map.put("messages", messageService.list());
        return "teacher/message";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultRO delete(Integer id) {

        if (messageService.deleteByPrimaryKey(id) > 0) {
            return new ResultRO(true, "index");
        }

        return new ResultRO("删除失败");
    }
}
