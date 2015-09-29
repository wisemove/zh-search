package com.zhgw.search.model.laws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zhgw.search.common.Conditions;
import com.zhgw.search.common.context.WebContextConst;
import com.zhgw.search.util.TreeUtil;

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
	
	@RequestMapping(value="load-laws-tree")
	@ResponseBody
	public String load_laws_tree (String pid,Model model){
		List<LawsEntity> entity  = this.lawsService.queryAll(new Conditions().eq("parentId", Integer.parseInt(pid)));
		
		return TreeUtil.toJson(entity);
		
	}
	
	
	@RequestMapping("show-laws")
	@ResponseBody
	public String show_laws(String _id ){
		
		LawsEntity entity = this.lawsService.get(_id);
		
		String json =  JSONObject.toJSONString(entity);
		
		System.out.println(json);
		
		return json;
	}
	
}
