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
import com.tuzhi.bj.domain.User;
import com.tuzhi.bj.service.IUserService;
import com.tuzhi.bj.util.TzResult;

/**
 * @ClassName:UserController
 * @Description:用户表的控制器
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	
	 /**
	 * @title:findUserList
	 * @description: 分页
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("/list")
	@ResponseBody
	public TzResult findUserList(User user){
		PageInfo<User> page = userService.findUserList(user);
		return TzResult.success().data(page);//PageInfo<User>
	}
	
	/**
	 * @title:getUserById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("/get")
	@ResponseBody
	public User getUserById(Integer id){
		User user = userService.getUserById(id);
		return user;
	}
	
	
	 /**
	 * @title:editUser
	 * @description: 新增
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveUser(User user){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = userService.saveUser(user);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editUser
	 * @description: 修改
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editUser(User user){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = userService.editUser(user);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delUser
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delUser(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = userService.delUser(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
