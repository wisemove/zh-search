package com.zhgw.search.model.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhgw.search.common.Conditions;
import com.zhgw.search.common.context.UserContext;


@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@RequestMapping("index")
	public String index(Model model){
		
		
		return "user/index";
	}

	@RequestMapping("query-users")
	public String getPage(Model model ){
		
		List<UserEntity> list = this.userService.queryAll(new Conditions());
		
		model.addAttribute("user_datas", list);
		return "user/user-data-temp";
	}
	
	@RequestMapping("resetpass")
	public String resetPassword(){
		
		return "user/resetpass";
	}
	
	@ResponseBody
	@RequestMapping("resetpassx")
	public String resetpassx(String password0,String password1){
		
		String session_pass = ((UserEntity)request.getSession().getAttribute(UserContext.USER_SESSION)).getPassword();
		if(!password0.equals(session_pass)){
			return "旧密码错误,请重新输入";
		}
		System.out.println(password0 +"   "+password1);
		return "密码修改成功";
	}
}
