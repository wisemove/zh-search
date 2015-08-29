package com.zhgw.search.common.lang;


public class Longable implements Datable {

	private Long longable;

	public void setLongable(Long longable) {
		this.longable = longable;
	}

	@Override
	public Long getValue() {
		// TODO Auto-generated method stub
		return this.longable;
	}

}
