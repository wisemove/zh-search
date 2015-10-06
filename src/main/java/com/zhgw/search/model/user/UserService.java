package com.zhgw.search.model.user;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
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
				sb.append("\"").append("<font color=yellow>未加入</font>").append("\"").append(",");
			}else{
			     InstiEntity ie = instiService.get(ue.getInstiId());
			     if(ie==null){
			    	 sb.append("\"").append("<font color=red>已删除</font>").append("\"").append(",");
			     }else{
			       sb.append("\"").append(ie.getIns_name()).append("\"").append(",");
			     }
			}
			
			sb.append("\"").append(ue.getIsValid()==0?"<font color=red>禁用</font>" : "<font color=green>启用</font>").append("\"").append(",");
			
			String opc = MessageFormat.format(opPages, ue.getId(),ue.getAuthType());
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
	
	
	//根据部门ID 查询在此部门的人员
	public List<UserEntity> getUsersByInsId(long insId){
	  Conditions con = new Conditions();
	  con.eq("instiId", insId);
	  return queryAll(con);
	}
	
	//根据机构ID 查询不在此机构的人员。
	public List<UserEntity> getNanUsersByInsId(long insId){
		
		
		final String sql ="SELECT u.id as id," +
				"  u.userName as userName, " +
				"  i.ins_name as insti_name," +
				" i.id as instiId," +
				" u.authType " +
				" FROM  t_user  u LEFT  JOIN t_institution  i ON (u.instiId=i.id ) where u.instiId!=?" +
				" OR u.instiId IS NULL ";
		this.printSQL(sql);
		List<UserEntity> list = this.queryAll(sql, insId);
		return list;
	}
}
