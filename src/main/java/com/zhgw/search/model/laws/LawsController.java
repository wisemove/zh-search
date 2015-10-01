package com.zhgw.search.model.laws;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
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
	public String insert_laws(LawsEntity entity){
		if(entity!=null )
			entity.setIsValid("1");
		this.lawsService.save(entity);
		return WebContextConst.SUCCESS;
	}
	
	
	@ResponseBody
	@RequestMapping("delete-laws")
	public String delete_laws(long _id ){
		
		LawsEntity law = new LawsEntity();
		law.setId(_id);
		lawsService.deleteLaws(law);
		return WebContextConst.SUCCESS;
	}
	
	
	@ResponseBody
	@RequestMapping("update-laws")
	public String update_laws(LawsEntity laws ){
		
		System.out.println(ToStringBuilder.reflectionToString(laws));
		this.lawsService.updateNotNull(laws);
		
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
		this.lawsService.getAllLaws(_id);
		
		return json;
	}
	
	@RequestMapping("show-all-laws")
	public String show_all_laws(String _id ,Model model  ){
		List<LawsEntity> list = this.lawsService.getAllLaws(_id);
		model.addAttribute("all_laws", list);
		return WebContextConst.LAWS_PATH.concat("all-laws-temp");
	}
}
