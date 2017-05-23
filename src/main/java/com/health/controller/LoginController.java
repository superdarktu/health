package com.health.controller;

import com.health.model.po.Login;
import com.health.model.po.Student;
import com.health.model.po.Teacher;
import com.health.model.ro.ResultRO;
import com.health.service.LoginService;
import com.health.service.StudentService;
import com.health.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/admin_login")
    public String aaa() {
        return "admin_login";
    }
    
    @RequestMapping("/teacher_login")
    public String bbb() {
        return "teacher_login";
    }

    /**
     * 学员登录
     *
     * @param username
     * @param password
     * @param req
     * @return
     */
    @RequestMapping("/login_in")
    @ResponseBody
    public ResultRO loginIn(String username, String password, HttpServletRequest req) {

        Student student = studentService.login(username, password);
        if (student != null) {

            HttpSession session = req.getSession();
            session.setAttribute("userId", student.getId());
            return new ResultRO(true, "index");
        }

        return new ResultRO("用户名不存在或者用户名密码错误");
    }

    /**
     * 管理员或者教练登录
     *
     * @param username
     * @param password
     * @param req
     * @return
     */
    @RequestMapping("/admin_login_in")
    @ResponseBody
    public ResultRO adminLoginIn(String username, String password, HttpServletRequest req) {

        Login login = loginService.login(username, password);
        if (login != null) {

                HttpSession session = req.getSession();
                session.setAttribute("isManage", 1);
                return new ResultRO(true, "manage_index");

        }

        return new ResultRO("用户名不存在或者用户名密码错误");
    }
    
    @RequestMapping("/teacher_login_in")
    @ResponseBody
    public ResultRO teacherLoginin(String username, String password, HttpServletRequest req) {

        Teacher teacher = teacherService.login(username, password);
        if (teacher != null) {
            HttpSession session = req.getSession();
            session.setAttribute("teacherId", teacher.getId());
            session.setAttribute("teacherNo", teacher.getNo());
            return new ResultRO(true, "teacher_index");
        }

        return new ResultRO("用户名不存在或者用户名密码错误");
    }
	/*
	 * HttpSession session = req.getSession();
		Login login = loginService.login(username, password);
	 */
}
