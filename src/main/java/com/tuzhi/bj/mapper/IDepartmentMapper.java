package com.tuzhi.bj.mapper;

import java.util.List;

import com.tuzhi.bj.domain.Department;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:DepartmentMapper
 * @Description:部门表数据层接口
 * @author codeZ
 * @CreateDate 2018-05-11 12:49:20
 */
public interface IDepartmentMapper extends Mapper<Department> {
	
	/**
	 * @title:findDepartmentList
	 * @description: 查询部门表列表
	 * @author codeZ
	 * @param department
	 * @CreateDate  2018-05-11 12:49:20
	 */
	List<Department> findDepartmentList(Department department);
	
	
	/**
	 * @title:getDepartmentById
	 * @description: 查询部门表信息
	 * @author codeZ
	 * @param id
	 * @CreateDate  2018-05-11 12:49:20
	 */
	Department getDepartmentById(Integer id);
	
	
	/**
	 * @title:deleteByPriKey
	 * @description: 根据id删除信息
	 * @author codeZ
	 * @param id
	 * @CreateDate  2018-05-11 12:49:20
	 */
	int deleteByPriKey(Integer id);


	/**
	 * @title:insert
	 * @description: 插入部门表
	 * @author codeZ
	 * @param department
	 * @CreateDate  2018-05-11 12:49:20
	 */
    int insertDepartment(Department department);


	/**
	 * @title:insertSelective
	 * @description: 插入部门表
	 * @author codeZ
	 * @param department
	 * @CreateDate  2018-05-11 12:49:20
	 */
    int insertDepartmentSelective(Department department);

	/**
	 * @title:updateSelectiveById
	 * @description: 更新部门表（更新不为null的值）
	 * @author codeZ
	 * @param department
	 * @CreateDate  2018-05-11 12:49:20
	 */
    int updateDepartmentSelectiveById(Department department);

	/**
	 * @title:updateById
	 * @description: 更新部门表（更新不为null的值）
	 * @author codeZ
	 * @param department
	 * @CreateDate  2018-05-11 12:49:20
	 */
    int updateDepartmentById(Department department);
}
