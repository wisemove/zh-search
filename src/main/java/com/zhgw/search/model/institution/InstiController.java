package com.zhgw.search.model.institution;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhgw.search.common.context.WebContextConst;


@Controller
@RequestMapping("insti")
public class InstiController {

	@RequestMapping("index")
	public String index(){
		
		return WebContextConst.INSTITUTION_PATH.concat("index");
	}
}
