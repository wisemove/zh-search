package com.zhgw.search.model.person;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhgw.search.common.context.UserContext;
import com.zhgw.search.common.context.WebContextConst;
import com.zhgw.search.model.institution.InstiEntity;
import com.zhgw.search.model.institution.InstiService;
import com.zhgw.search.model.user.UserEntity;
import com.zhgw.search.model.user.UserService;

/**
 * 个人档案。
 * @author yunjume
 *
 */
@Controller
@RequestMapping("person")
public class PersonController {

	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InstiService instiService;
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("whoami")
	public String index(Model model){
		UserEntity ue = (UserEntity) session.getAttribute(UserContext.USER_SESSION);
		if(ue.getInstiId()!=0){
		  InstiEntity ie = instiService.get(ue.getInstiId());
		  ue.setInsti_name(ie.getIns_name());
		}else{
			ue.setInsti_name("为加入任何机构");
		}
		
		model.addAttribute("user", ue);
		return WebContextConst.PERSON_PATH.concat("whoami");
	}
}
