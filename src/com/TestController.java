package com;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@Autowired
	private UserDao dao;
	
	@RequestMapping("/index.do")
	public String Test(){
		
		dao.getUser();
		return "index";
	}
}
