package com.health.controller;

import com.health.model.po.Student;
import com.health.model.po.TestData;
import com.health.model.ro.ResultRO;
import com.health.service.StudentService;
import com.health.service.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@RequestMapping("/test_data")
public class TestDataController {

    @Autowired
    private TestDataService testDataService;

    @Autowired
    private StudentService studentService;


    @RequestMapping("to_input")
    public String toInput() {

        return "test_data/input";
    }

    @RequestMapping("to_search")
    public String toSearch(HttpServletRequest req, TestData testData, Map<String, Object> map) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        testData.setStudentId(1);
        map.put("datas", testDataService.pageAll(testData));
        return "test_data/search";
    }

    @RequestMapping("to_result")
    public String toResult(HttpServletRequest req, Map<String, Object> map) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        map.put("data", testDataService.query(1));
        return "test_data/result";
    }

    @RequestMapping("create")
    @ResponseBody
    public ResultRO create(HttpServletRequest req, TestData testData) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        Student student = studentService.selectByPrimaryKey(1);
        if (testDataService.insert(testData, student) > 0) {

            return new ResultRO(true, "to_result");
        }
        return new ResultRO("数据输入失败");
    }

    @RequestMapping("list")
    @ResponseBody
    public ResultRO create(HttpServletRequest req, TestData testData, Integer page, Integer pageSize) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        testData.setStudentId(1);
        return new ResultRO(testDataService.page(testData, page, pageSize));
    }

    @RequestMapping("page")
    @ResponseBody
    public ResultRO pageAll(HttpServletRequest req, TestData testData) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        testData.setStudentId(1);
        return new ResultRO(testDataService.pageAll(testData));
    }
}
