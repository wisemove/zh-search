package com.zhgw.search.model.institution;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zhgw.search.common.Conditions;
import com.zhgw.search.common.context.UserContext;
import com.zhgw.search.common.context.WebContextConst;
import com.zhgw.search.model.user.UserEntity;
import com.zhgw.search.model.user.UserService;
import com.zhgw.search.util.DataTableUtils;
import com.zhgw.search.util.DateUtil;
import com.zhgw.search.util.PageResourceUtil;

@Controller
@RequestMapping("insti")
public class InstiController {

	@Autowired
	private InstiService instiService;

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("index")
	public String index() {

		
		return WebContextConst.INSTITUTION_PATH.concat("index");
	}

	private PageResourceUtil pru = new PageResourceUtil("insti.handle.page");
	
	/**
	 * 机构数据
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("query-instis-json")
	@ResponseBody
	public String query_instis_json() throws IOException {
		StringBuffer sb = new StringBuffer();
		List<InstiEntity> ies = this.instiService.queryAll(new Conditions());
		String s = pru.getResource();

		int size = ies.size();
		int i = 1;
		for (InstiEntity ie : ies) {
			sb.append(DataTableUtils.getDataJsonFragment(ie.getIns_name(), 
					ie.getIns_desc(), 
					ie.getIsValid() == 0 ? "<font color=red>禁用</font>" : "<font color=green>启用</font>",
					DateUtil.formatShortDate(ie.getCreateDate()	),
					MessageFormat.format(s, ie.getId(),ie.getIns_name())
					));
			if (i++ != size) {
				sb.append(",");
			}
		}

		String result = DataTableUtils.setDataJsonHeader(sb.toString());
		return result;

	}

	/**
	 * 添加用户的时候用到此JSON数据 json数据详细：
	 * 
	 * <pre>
	 * [{
	 *  "id":1,
	 * "text":"Java",
	 * 	"desc":"Write once, run anywhere"
	 * },{
	 * 	"id":2,
	 * 	"text":"C#",
	 * 	"desc":"One of the programming languages designed for the Common Language Infrastructure"
	 * }]
	 * 
	 </pre>
	 * 
	 * @return
	 */
	@RequestMapping(value = "query-select-option-insti", method = RequestMethod.POST)
	@ResponseBody
	public String getSelectOptionInsti() {

		List<InstiEntity> en = this.instiService.queryAll(new Conditions().eq("isValid", WebContextConst.VALID));

		StringBuffer sb = new StringBuffer();
		for (InstiEntity in : en) {

			sb.append("{");
			sb.append("\"id\":").append(in.getId()).append(",");

			sb.append("\"text\":").append("\"").append(in.getIns_name()).append("\"").append(",");

			sb.append("\"desc\":").append("\"").append(in.getIns_desc()).append("\"");

			sb.append("}");

			sb.append(",");

		}
		if (!sb.toString().isEmpty()) {
			sb = sb.deleteCharAt(sb.length() - 1);
		}
		return "[" + sb.toString() + "]";
	}
	
	
	@RequestMapping("save-instis")
	@ResponseBody
	public String save_instis(InstiEntity entity)
	{
	//	System.out.println(ToStringBuilder.reflectionToString(entity));
		instiService.save(entity);
		return WebContextConst.SUCCESS;
	}
	@RequestMapping("delete-insti")
	@ResponseBody
	public String delete_instis(long _id)
	{
	//	System.out.println(ToStringBuilder.reflectionToString(entity));
		instiService.delete(_id);
		return WebContextConst.SUCCESS;
	}
	@RequestMapping("query-insti-byid")
	@ResponseBody
	public String query_this_byId(long _id)
	{
		InstiEntity ie = instiService.get(_id);
		
		return JSONObject.toJSONString(ie);
	}
	@RequestMapping("update-insti")
	@ResponseBody
	public String update_insti(InstiEntity en )
	{
		//System.out.println(ToStringBuilder.reflectionToString(en));
		instiService.updateNotNull(en);
		return WebContextConst.SUCCESS;
	}
	
	@RequestMapping("query-nan-users-byInsId")
	public String getNanUsersByInstiId(long _instiId,Model model){

		List<UserEntity> list = userService.getNanUsersByInsId(_instiId);
		model.addAttribute("result", list);
	/*	for(UserEntity ue : list ){
			System.out.println(ToStringBuilder.reflectionToString(ue));
		}*/
		return WebContextConst.INSTITUTION_PATH.concat("nan-user-options");
	}
	
	@RequestMapping("query-users-byInsId")
	public String getUsersByInstiId(long _instiId,Model model){

		List<UserEntity> list = userService.getUsersByInsId(_instiId);
		model.addAttribute("result", list);
		return WebContextConst.INSTITUTION_PATH.concat("user-options");
	}
	
	//修改用户所在的机构 
	@RequestMapping("update-users-insti")
	@ResponseBody
	public String update_user_insti(long insti_id , String _userIds){
		if(_userIds !=null ){
			String  [] userIds = _userIds.split(",");
			for(String uid : userIds){
				 if(uid !=null && !uid.trim().equals(""))
				 {
					 UserEntity ue = userService.get(Long.parseLong(uid));
					 ue.setInstiId(insti_id);
					 userService.update(ue);
				 }
			}
		}
		return WebContextConst.SUCCESS;
	}
	
	//设置为部门审核人 每个机构有唯一一位审核人
	@ResponseBody
	@RequestMapping("update-user-audit")
	public String update_user_audit(long _insti_id,long _userId){
		
		List<UserEntity> ens = this.userService.queryAll(new Conditions().eq("instiId", _insti_id));
		if(ens !=null && ens.size() !=0){
			for(UserEntity en : ens ){
				if(en.getAuthType() .equals(UserContext.AUDIT_USER)){
					//如果是审核人设置为普通用户
					en.setAuthType(UserContext.GENERAL_USER);
					userService.update(en);
				}
			}
			
		}
		UserEntity ue = userService.get(_userId);
		ue.setAuthType(UserContext.AUDIT_USER);
		userService.update(ue);
		return WebContextConst.SUCCESS;
	}

}
