package com.tuzhi.bj.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.base.BaseServiceImpl;
import com.tuzhi.bj.mapper.IRoleMapper;
import com.tuzhi.bj.domain.Role;
import com.tuzhi.bj.service.IRoleService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:RoleServiceImpl
 * @Description:角色业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {
	
	@Autowired
	private IRoleMapper roleMapper;
 
	public PageInfo<Role> findRoleList(Role role) {
		// TODO 分页查询
		PageHelper.startPage(role.getPageNum(), role.getPageSize());
		PageInfo<Role> pageInfo = new PageInfo<Role>(roleMapper.findRoleList(role));
		
		return pageInfo;
	}
	
	public Role getRoleById(Integer id){
		// TODO 根据ID查询
		return roleMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveRole(Role role){
		// TODO 新增
		role.setCreatedTime(new Date());
		return roleMapper.insertSelective(role) > 0;
	}
	
	public boolean editRole(Role role){
		// TODO 修改
		return roleMapper.updateRoleSelectiveById(role) > 0;
	}
	
	public boolean delRole(List<Integer> roleArr){
		// TODO	删除
		Example example = new Example(Role.class);
		Criteria c = example.createCriteria();
		c.andIn("id", roleArr);
		return roleMapper.deleteByExample(example) > 0;
	}

}
