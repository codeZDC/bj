package com.tuzhi.bj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.base.BaseServiceImpl;
import com.tuzhi.bj.mapper.IDepartmentMapper;
import com.tuzhi.bj.domain.Department;
import com.tuzhi.bj.service.IDepartmentService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:DepartmentServiceImpl
 * @Description:部门表业务层接口实现类
 * @author codeZ
 * @CreateDate 2018-05-11 12:49:20
 */
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements IDepartmentService {
	
	@Autowired
	private IDepartmentMapper departmentMapper;
 
	public PageInfo<Department> findDepartmentList(Department department) {
		// TODO 分页查询
		PageHelper.startPage(department.getPageNum(), department.getPageSize());
		PageInfo<Department> pageInfo = new PageInfo<Department>(departmentMapper.findDepartmentList(department));
		
		return pageInfo;
	}
	
	public Department getDepartmentById(Integer id){
		// TODO 根据ID查询
		return departmentMapper.getDepartmentById(id);
	}
	
	public boolean saveDepartment(Department department){
		// TODO 新增
		return departmentMapper.insertDepartmentSelective(department) > 0;
	}
	
	public boolean editDepartment(Department department){
		// TODO 修改
		return departmentMapper.updateDepartmentSelectiveById(department) > 0;
	}
	
	public boolean delDepartment(List<Integer> departmentArr){
		// TODO	删除
		Example example = new Example(Department.class);
		Criteria c = example.createCriteria();
		c.andIn("id", departmentArr);
		return departmentMapper.deleteByExample(example) > 0;
	}

}
