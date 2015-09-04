package com.zhgw.search.model.user;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.zhgw.search.common.Conditions;
import com.zhgw.search.dao.CommonDao;

@Service
public class UserService extends CommonDao<UserEntity>{

	
	public UserEntity chkUser(String userName, String password) {

		Conditions con = new Conditions();
		con.eq("username", userName).eq("password", password);
		UserEntity un = this.queryUnique(con);
		
		return un ;
	}
	
	
	public void save(){
		UserEntity ue = new UserEntity();
		ue.setAge(11);
		ue.setCreateDate(new Date());
		ue.setIsValid(1);
		ue.setPassword("password");
		ue.setUserName("userName");
		ue.setPhone("13888888888");
		ue.setEmail("120182000@qq.com");
		ue.setRealName("yujunminf");
		ue.setId(1234);
		this.save(ue);
	}
	
}
