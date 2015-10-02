package com.zhgw.search.model.user;

import java.util.Date;

import com.zhgw.search.common.Id;
import com.zhgw.search.common.Table;
import com.zhgw.search.common.Transient;

@Table(name="t_user")
public class UserEntity {

	public String getInsti_name() {
		return insti_name;
	}

	public void setInsti_name(String insti_name) {
		this.insti_name = insti_name;
	}

	@Id()
	private long id ;
	
	private String userName ; 
	
	
	private String password;
	
	
	private String realName ;
	
	private int sex ;
	
	private int age;
	
	private String email ;
	
	private String phone;
	
	private long instiId; //机构ID
	
	@Transient
	private String insti_name ;//机构名称
	
	private int isValid ;
	
	private Date createDate ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}

	public long getInstiId() {
		return instiId;
	}

	public void setInstiId(long instiId) {
		this.instiId = instiId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIsValid() {
		return isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
