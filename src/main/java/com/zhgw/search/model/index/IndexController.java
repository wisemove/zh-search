package com.zhgw.search.model.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

	
	
	@Autowired
	private IndexService indexService;
	
	@RequestMapping(value="index")
	public String index(Model model ){
		
		indexService.test();
		System.out.println("aaa");
		return "index";
	}
	
	
	@RequestMapping("login")
	public String login_index(){
		
		
		return "login";
	}
}
