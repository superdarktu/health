package com.health.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.po.Login;
import com.health.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
    public String login(String username,String password,HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		Login login = loginService.login(username, password);
		return "";
    }
	
	@RequestMapping("/")
    @ResponseBody
    public int aaa() {
		System.out.println("11111111");
        return 111;
    }
}
