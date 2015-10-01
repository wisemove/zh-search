package com.zhgw.search.model.institution;

import java.util.Date;

import com.zhgw.search.common.Id;
import com.zhgw.search.common.Table;

/**
 * 机构 实体
 * @author yunjume
 *
 */
@Table(name="t_institution")
public class InstiEntity {

	@Id
	private long id ;
	
	//机构名称
	private String ins_name;
	
	//机构描述
	private String ins_desc;
	
	//是否有效
	private int isValid=1;
	
	private Date createDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIns_name() {
		return ins_name;
	}

	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}

	public String getIns_desc() {
		return ins_desc;
	}

	public void setIns_desc(String ins_desc) {
		this.ins_desc = ins_desc;
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
