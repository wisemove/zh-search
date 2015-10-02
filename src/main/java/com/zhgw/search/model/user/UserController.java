package com.zhgw.search.model.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zhgw.search.common.Conditions;
import com.zhgw.search.common.context.UserContext;
import com.zhgw.search.common.context.WebContextConst;
import com.zhgw.search.model.institution.InstiEntity;
import com.zhgw.search.model.institution.InstiService;


@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private InstiService instiService;
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
	
	
	@RequestMapping("query-users-json")
	@ResponseBody
	public String query_users_json() throws IOException{
		String json =  userService.getUserJson();
		
		return json;
	}
	
	@RequestMapping("query-user-byid")
	@ResponseBody
	public String query_by_id (String _id ){
		
		if(_id ==null ){
			return WebContextConst.ERROR;
		}
		UserEntity ue = userService.get(_id);
		if(ue.getId()==0 ){
			ue.setInsti_name("请选择机构名称");
		}else{
			InstiEntity ie = this.instiService.get(ue.getInstiId());
			if(ie!=null && ie.getIns_name()!=null){
				ue.setInsti_name(ie.getIns_name());
			}else{
				ue.setInsti_name("请选择机构名称");
			}
		}
		return JSONObject.toJSONString(ue);
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
	
	
	@RequestMapping("save-user")
	@ResponseBody
	public String save_users(UserEntity entity ){
		
//		System.out.println(ToStringBuilder.reflectionToString(entity));
		this.userService.save(entity);
		return WebContextConst.SUCCESS;
	}
}
