package com.tuzhi.bj.service;

import java.util.List;

import com.tuzhi.bj.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.domain.Department;

/**
 * @ClassName:IDepartmentService
 * @Description:部门表业务层接口
 * @author codeZ
 * @CreateDate 2018-05-11 12:49:20
 */
public interface IDepartmentService extends IBaseService<Department>{

	/**
	 * @title:findDepartmentList
	 * @description: 查询部门表列表
	 * @author codeZ
	 * @param department
	 * @CreateDate  2018-05-11 12:49:20
	 */
	PageInfo<Department> findDepartmentList(Department department);
	
	/**
	 * @title:getDepartmentById
	 * @description: 根据ID查询部门表信息
	 * @author codeZ
	 * @param id	主键
	 * @CreateDate  2018-05-11 12:49:20
	 */
	Department getDepartmentById(Integer id);
	
	/**
	 * @title:saveDepartment
	 * @description: 新增
	 * @author codeZ
	 * @param department
	 * @CreateDate  2018-05-11 12:49:20
	 */
	boolean saveDepartment(Department department);
	
	 /**
	 * @title:editDepartment
	 * @description: 修改
	 * @author codeZ
	 * @param department
	 * @CreateDate  2018-05-11 12:49:20
	 */
	boolean editDepartment(Department department);
	
	/**
	 * @title:delDepartment
	 * @description: 删除
	 * @author codeZ
	 * @param departmentArr	主键编号集合
	 * @CreateDate  2018-05-11 12:49:20
	 */
	boolean delDepartment(List<Integer> departmentArr);
}
