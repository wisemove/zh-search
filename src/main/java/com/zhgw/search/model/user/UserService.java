package com.zhgw.search.model.user;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhgw.search.common.Conditions;
import com.zhgw.search.dao.CommonDao;
import com.zhgw.search.model.institution.InstiEntity;
import com.zhgw.search.model.institution.InstiService;
import com.zhgw.search.util.PageResourceUtil;

@Service
public class UserService extends CommonDao<UserEntity>{

	@ Autowired
	private InstiService instiService;
	
	public UserEntity chkUser(String userName, String password) {

		Conditions con = new Conditions();
		con.eq("username", userName).eq("password", password);
		UserEntity un = this.queryUnique(con);
		
		return un ;
	}
	
	
	public String getUserJson() throws IOException{
		
		StringBuffer sb  = new StringBuffer();
		PageResourceUtil pru = new PageResourceUtil("user.handle.page");
		
		String opPages = pru.getResource();
		
		sb.append("{ \n");
		sb.append("\"data\":[\n");
		
		List<UserEntity> list = this.queryAll(new Conditions());
		
		long i=1;
		long length = list.size();
		for(UserEntity ue : list){
		  	sb.append("[");
			
		  	sb.append("\"").append(ue.getUserName()).append("\"").append(",");
		  	sb.append("\"").append(ue.getRealName()).append("\"").append(",");
		  	sb.append("\"").append(ue.getSex()==0?"女":"男").append("\"").append(",");
//		  	sb.append("\"").append(ue.getAge()).append("\"").append(",");
		  	sb.append("\"").append(ue.getEmail()).append("\"").append(",");
			sb.append("\"").append(ue.getPhone()).append("\"").append(",");
			
			long instiId = ue.getInstiId();
			if(instiId==0){
				sb.append("\"").append("否").append("\"").append(",");
			}else{
			     InstiEntity ie = instiService.get(ue.getInstiId());
			     sb.append("\"").append(ie.getIns_name()).append("\"").append(",");
			}
			
			sb.append("\"").append(ue.getIsValid()==0?"禁用":"启用").append("\"").append(",");
			
			String opc = MessageFormat.format(opPages, ue.getId());
			sb.append("\"").append(opc).append("\"");
			sb.append("]");
			if((i++) != length){
				sb.append(",");
			}
		}
		
		sb.append("] \n");
		sb.append("}\n");
		
		return sb.toString();
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
