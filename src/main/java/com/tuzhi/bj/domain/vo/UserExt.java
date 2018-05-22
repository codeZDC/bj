package com.tuzhi.bj.domain.vo;

import com.tuzhi.bj.domain.User;

/**
 * @author codeZ
 * @date 2018年4月10日 上午10:06:01
 * 
 */
public class UserExt extends User {

	//获取用户列表的时候页面需要的角色名称
	private String roleName ;

	
	
	
	
	
	
	
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	} 
}
