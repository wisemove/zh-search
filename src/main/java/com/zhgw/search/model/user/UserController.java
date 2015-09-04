package com.zhgw.search.model.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhgw.search.common.context.UserContext;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("user/resetpass")
	public String resetPassword(){
		
		return "user/resetpass";
	}
	
	
	@ResponseBody
	@RequestMapping("user/resetpassx")
	public String resetpassx(String password0,String password1){
		
		String session_pass = ((UserEntity)request.getSession().getAttribute(UserContext.USER_SESSION)).getPassword();
		if(!password0.equals(session_pass)){
			return "旧密码错误,请重新输入";
		}
		System.out.println(password0 +"   "+password1);
		return "密码修改成功";
	}
}
