package com.zhgw.search.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zhgw.search.common.Conditions;

/**
 * Controller Utils
 * 
 * @author yunjume
 */
public class ControllerModel {


	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

	static Map<String, Object> map = new HashMap<String, Object>();
	static Map<String, Serializable> map1 = new HashMap<String, Serializable>();;

	Logger logger = LoggerFactory.getLogger(ControllerModel.class);

	/**
	 * get a empty data map
	 * 
	 * @return
	 */
	public static  Map<String, Object> getEmptyMap() {
		return map;
	}

	public static Map<String,Serializable> getSeriaMap(){
		map1.clear();
		return map1;
	}
	
	/**
	 * inject this map datas to request scope
	 */
	public void injectRequest() {

		if (!map.isEmpty()) {
			for (Entry<String, Object> en : map.entrySet()) {
				request.setAttribute(en.getKey(), en.getValue());
			}
		}
	}

	/**
	 * inject this map datas to session scope
	 */
	public void injectSession() {
		if (!map.isEmpty()) {
			for (Entry<String, Object> en : map.entrySet()) {
				request.getSession().setAttribute(en.getKey(), en.getValue());
			}
		}
	}
	
	
	public static void  fieldsLikes(Map<String,Serializable> map ,Conditions con ){
		
		for(Entry<String,Serializable> en : map.entrySet()){
			if(en.getValue()!=null &&! en.getValue().equals(""))
			con.like(en.getKey(), en.getValue()).OR();  
		}
	}
	
	public static void main(String[] args) {
		Map<String,Serializable> ma = new HashMap<String,Serializable>();
		ma.put("userName","d");
		ma.put("password",123);
		Conditions con = new Conditions();
		fieldsLikes(ma,con);
		System.out.println(con.toSQL("aaa")+"   "+ ToStringBuilder.reflectionToString(con.getParamterList().toArray()));
	}
}
