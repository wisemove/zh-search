package com.zhgw.search.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Controller Utils
 * 
 * @author yunjume
 */
public class ControllerModel {


	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

	Map<String, Object> map = new HashMap<String, Object>();;

	Logger logger = LoggerFactory.getLogger(ControllerModel.class);

	/**
	 * get a empty data map
	 * 
	 * @return
	 */
	public Map<String, Object> getEmptyMap() {
		return map;
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
	
}
