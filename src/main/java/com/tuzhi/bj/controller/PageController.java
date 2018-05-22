package com.tuzhi.bj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制菜单点击之后页面跳转--统一跳转功能
 * @author codeZ
 * @date 2018年4月8日 上午10:12:14
 * 
 */

@Controller
public class PageController {
	//菜单链接跳转
	@RequestMapping("page/{module}")
	public String page(@PathVariable(value="module") String module){
		return module + "/" + module ;
	}
	
	//流程链接跳转
	@RequestMapping("flow/{module}")
	public String flow(@PathVariable(value="module") String module){
		return "flow/" + module ;
	}
	
}
