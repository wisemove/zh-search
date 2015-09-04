package com.zhgw.search.model.user;

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
	
}
