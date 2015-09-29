package com.zhgw.search.model.laws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhgw.search.common.context.WebContextConst;

@Controller
@RequestMapping("laws")
public class LawsController {

	
	@Autowired
	private LawsService lawsService;
	
	
	@RequestMapping("index")
	public String index(){
		
		return WebContextConst.LAWS_PATH.concat("index");
	}
	
	
	@ResponseBody
	@RequestMapping("save-laws")
	public String insert_laws(){
		
		return WebContextConst.SUCCESS;
	}
	
	@ResponseBody
	@RequestMapping("update-laws")
	public String update_laws(){
		
		return WebContextConst.SUCCESS;
	}
	
	@RequestMapping("query-laws")
	public String query_laws(LawsEntity entity ,Model model ){
		
		return WebContextConst.LAWS_PATH.concat("laws-content");
	}
}
