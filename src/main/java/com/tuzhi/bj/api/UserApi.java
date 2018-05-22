package com.tuzhi.bj.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuzhi.bj.domain.User;
import com.tuzhi.bj.service.IUserService;
import com.tuzhi.bj.util.App;
import com.tuzhi.bj.util.StringUtils;

/**
 * @author codeZ
 * @date 2018年4月10日 下午4:26:53
 * 
 */

@RestController
@RequestMapping("api/user")
public class UserApi {

	@Autowired
	private IUserService Service;
	
	@ModelAttribute
	private void urlMsg(HttpServletRequest request){
		System.err.println("请 求 地 址: \n"+request.getRequestURL()+"?"+request.getQueryString());
		
	}
	
	//登录
	@RequestMapping("login")
	public App login(String account,String pwd){
		try {
			if(StringUtils.hasEmpty(account,pwd)){
				return App.fail("账号或密码不能为空");
			}
			User user = Service.login(account,pwd);
			Map<String,Object> map = new HashMap<>();
			map.put("userId", user.getId());
			map.put("username", user.getUsername());
			map.put("level", user.getLevel());
			map.put("account", user.getAccount());
			return App.success().data(map);
		} catch (Exception e) {
			return App.fail(e.getMessage());
		}
	}
	//修改密码
	@RequestMapping("updatePassword")
	public App login(String account,String pwd , String newPassword){
		try {
			if(StringUtils.hasEmpty(account,pwd,newPassword)){
				return App.fail("账号或密码或新密码不能为空");
			}
			Service.uploadPassword(account,pwd,newPassword);
			return App.success().data("密码修改成功");
		} catch (Exception e) {
			return App.fail(e.getMessage());
		}
	}
	
}
