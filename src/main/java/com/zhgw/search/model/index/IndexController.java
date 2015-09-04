package com.zhgw.search.model.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

	
	
	@Autowired
	private IndexService indexService;
	
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(value="index")
	public String index(Model model ){
		
		return "index";
	}
	
	
	@RequestMapping("login")
	public String login_index(){
		
		return "login";
	}
	@RequestMapping("loginx")
	public String loginex_index(String userName ,String password,Model model ){
		UserEntity ue = userService.chkUser(userName, password);
		System.out.println(userName +"   "+ password);
		
		if(ue ==null ){
			model .addAttribute("msg", "用户名或密码错误.");
			return "login";
		}
		
		return "index";
	}
	
	
}
