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
import com.tuzhi.bj.domain.User2;
import com.tuzhi.bj.service.IUser2Service;
import com.tuzhi.bj.util.TzResult;

/**
 * @ClassName:User2Controller
 * @Description:员工表的控制器
 * @author codeZ
 * @CreateDate 2018-05-11 12:06:58
 */
@Controller
@RequestMapping("/user2")
public class User2Controller extends BaseController {

	@Autowired
	private IUser2Service user2Service;
	
	 /**
	 * @title:findUser2List
	 * @description: 分页
	 * @author codeZ
	 * @param user2
	 * @CreateDate  2018-05-11 12:06:58
	 */
	@RequestMapping("/list")
	@ResponseBody
	public TzResult findUser2List(User2 user2){
		PageInfo<User2> page = user2Service.findUser2List(user2);
		return TzResult.success().data(page);
	}
	
	/**
	 * @title:getUser2ById
	 * @description: 查询一条信息
	 * @author codeZ
	 * @param id
	 * @CreateDate  2018-05-11 12:06:58
	 */
	@RequestMapping("/get")
	@ResponseBody
	public User2 getUser2ById(Integer id){
		User2 user2 = user2Service.getUser2ById(id);
		return user2;
	}
	
	
	 /**
	 * @title:editUser2
	 * @description: 新增
	 * @author codeZ
	 * @param user2
	 * @CreateDate  2018-05-11 12:06:58
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveUser2(User2 user2){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = user2Service.saveUser2(user2);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editUser2
	 * @description: 修改
	 * @author codeZ
	 * @param user2
	 * @CreateDate  2018-05-11 12:06:58
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editUser2(User2 user2){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = user2Service.editUser2(user2);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delUser2
	 * @description: 删除
	 * @author codeZ
	 * @param ids	主键ID集合
	 * @CreateDate  2018-05-11 12:06:58
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delUser2(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = user2Service.delUser2(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
