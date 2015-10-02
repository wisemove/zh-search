package com.zhgw.search.model.institution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhgw.search.common.Conditions;
import com.zhgw.search.common.context.WebContextConst;

@Controller
@RequestMapping("insti")
public class InstiController {

	@Autowired
	private InstiService instiService;

	@RequestMapping("index")
	public String index() {

		return WebContextConst.INSTITUTION_PATH.concat("index");
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
}
