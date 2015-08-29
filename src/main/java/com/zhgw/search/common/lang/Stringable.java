package com.zhgw.search.common.lang;


public class Stringable implements Datable {

	private String stringable;

	public void setStringable(String stringable) {
		this.stringable = stringable;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return stringable;
	}
}
