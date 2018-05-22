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
import com.tuzhi.bj.domain.Department;
import com.tuzhi.bj.service.IDepartmentService;
import com.tuzhi.bj.util.TzResult;

/**
 * @ClassName:DepartmentController
 * @Description:部门表的控制器
 * @author codeZ
 * @CreateDate 2018-05-11 12:49:20
 */
@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController {

	@Autowired
	private IDepartmentService departmentService;
	
	 /**
	 * @title:findDepartmentList
	 * @description: 分页
	 * @author codeZ
	 * @param department
	 * @CreateDate  2018-05-11 12:49:20
	 */
	@RequestMapping("/list")
	@ResponseBody
	public TzResult findDepartmentList(Department department){
		PageInfo<Department> page = departmentService.findDepartmentList(department);
		return TzResult.success().data(page);
	}
	
	/**
	 * @title:getDepartmentById
	 * @description: 查询一条信息
	 * @author codeZ
	 * @param id
	 * @CreateDate  2018-05-11 12:49:20
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Department getDepartmentById(Integer id){
		Department department = departmentService.getDepartmentById(id);
		return department;
	}
	
	
	 /**
	 * @title:editDepartment
	 * @description: 新增
	 * @author codeZ
	 * @param department
	 * @CreateDate  2018-05-11 12:49:20
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveDepartment(Department department){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = departmentService.saveDepartment(department);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editDepartment
	 * @description: 修改
	 * @author codeZ
	 * @param department
	 * @CreateDate  2018-05-11 12:49:20
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editDepartment(Department department){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = departmentService.editDepartment(department);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delDepartment
	 * @description: 删除
	 * @author codeZ
	 * @param ids	主键ID集合
	 * @CreateDate  2018-05-11 12:49:20
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delDepartment(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = departmentService.delDepartment(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
