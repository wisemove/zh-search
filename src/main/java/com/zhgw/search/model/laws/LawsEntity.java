package com.zhgw.search.model.laws;

import com.zhgw.search.common.Id;
import com.zhgw.search.common.Table;


@Table(name="t_laws")
public class LawsEntity {

	
	@Id
	private long id;
	
	//法规名称
	private String title;
	
	//法规内容
	private String content;
	
	//0 无效 1 有效
	private String isValid;
	
	//父ID
	private long parentId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	
	
}
