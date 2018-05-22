package com.tuzhi.bj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.base.BaseController;
import com.tuzhi.bj.domain.Role;
import com.tuzhi.bj.service.IRoleService;
import com.tuzhi.bj.util.TzResult;

/**
 * @ClassName:RoleController
 * @Description:角色的控制器
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;
	
	 /**
	 * @title:findRoleList
	 * @description: 分页
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("/list")
	@ResponseBody
	public TzResult findRoleList(Role role){
		PageInfo<Role> page = roleService.findRoleList(role);
		return TzResult.success().data(page);//PageInfo<Role>
	}
	
	/**
	 * @title:getRoleById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Role getRoleById(Integer id){
		Role role = roleService.getRoleById(id);
		return role;
	}
	
	
	 /**
	 * @title:editRole
	 * @description: 新增
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveRole(Role role){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = roleService.saveRole(role);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editRole
	 * @description: 修改
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editRole(Role role){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = roleService.editRole(role);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delRole
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delRole(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = roleService.delRole(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
