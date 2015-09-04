package com.zhgw.search.model.index;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhgw.search.common.context.UserContext;
import com.zhgw.search.model.user.UserEntity;
import com.zhgw.search.model.user.UserService;


@Controller
public class IndexController {

	
	
	@Autowired
	private IndexService indexService;
	
	
	@Autowired 
	private UserService userService;
	
	
	@Autowired
	private HttpServletRequest request;
	
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
		request.getSession().setAttribute(UserContext.USER_SESSION, ue);
		return "redirect:index.htm";
	}
	
	@RequestMapping("logout")
	public String logout (){
		request.getSession().removeAttribute(UserContext.USER_SESSION);
		return "redirect:login.htm";
	}
	
	
}
