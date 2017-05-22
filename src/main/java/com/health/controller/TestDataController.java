package com.health.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.po.Standard;
import com.health.model.po.Student;
import com.health.model.po.TestData;
import com.health.model.ro.ResultRO;
import com.health.model.vo.TestDataVO;
import com.health.service.StandardService;
import com.health.service.StudentService;
import com.health.service.TestDataService;


@Controller
@RequestMapping("/test_data")
public class TestDataController {

    @Autowired
    private TestDataService testDataService;

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private StandardService standardService;


    @RequestMapping("to_input")
    public String toInput() {

        return "test_data/input";
    }

    @RequestMapping("to_search")
    public String toSearch(HttpServletRequest req, TestData testData, Map<String, Object> map) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        testData.setStudentId(userId);
        map.put("datas", testDataService.pageAll(testData));
        return "test_data/search";
    }

    @RequestMapping("to_result")
    public String toResult(HttpServletRequest req, Map<String, Object> map) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        Student student = studentService.selectByPrimaryKey(userId);
        TestData td = testDataService.query(userId);
        List<Standard> lst = standardService.getYiban(student.getAge(), student.getSex());
        List<String> strs = new ArrayList<String>();
        for(Standard sd : lst){
        	if("pulmonary".equals(sd.getName())){
        		if(td.getPulmonary()<sd.getThree())
        			strs.add("肺活量");
        	}
        	if("tjsy".equals(sd.getName())){
        		if(td.getPulmonary()<sd.getThree())
        			strs.add("台阶试验");
        	}
        	if("wl".equals(sd.getName())){
        		if(td.getPulmonary()<sd.getThree())
        			strs.add("握力");
        	}
        	if("ywqz".equals(sd.getName())){
        		if(td.getPulmonary()<sd.getThree())
        			strs.add("仰卧起坐");
        	}
        	if("fwc".equals(sd.getName())){
        		if(td.getPulmonary()<sd.getThree())
        			strs.add("俯卧撑");
        	}
        	if("zwtqq".equals(sd.getName())){
        		if(td.getPulmonary()<sd.getThree())
        			strs.add("坐位体前屈");
        	}

        }
        map.put("data", td);
        map.put("strs", strs);
        return "test_data/result";
    }
    
    @RequestMapping("page_time")
    @ResponseBody
    public ResultRO pageByTime(HttpServletRequest req,TestDataVO testData){
    	HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        testData.setStudentId(userId);
        return new ResultRO(testDataService.pageByTime(testData));
    }

    @RequestMapping("create")
    @ResponseBody
    public ResultRO create(TestData testData,String studentNo) {


        Student student = studentService.findByNo(studentNo);
        if(student == null)
        	return new ResultRO("该编号会员不存在");
        if (testDataService.insert(testData, student) > 0) {

            return new ResultRO(true);
        }
        return new ResultRO("数据输入失败");
    }

    @RequestMapping("list")
    @ResponseBody
    public ResultRO create(HttpServletRequest req, TestData testData, Integer page, Integer pageSize) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        testData.setStudentId(userId);
        return new ResultRO(testDataService.page(testData, page, pageSize));
    }

    @RequestMapping("page")
    @ResponseBody
    public ResultRO pageAll(HttpServletRequest req, TestData testData) {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        testData.setStudentId(userId);
        return new ResultRO(testDataService.pageAll(testData));
    }
    
    
    @RequestMapping("get_last")
    @ResponseBody
    public ResultRO getLast(HttpServletRequest req){
    	
    	HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
    	return new ResultRO(testDataService.queryByStudentLast(userId));
    }
}
