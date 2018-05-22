package com.tuzhi.bj.service;

import java.util.List;

import com.tuzhi.bj.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.domain.Role;

/**
 * @ClassName:IRoleService
 * @Description:角色业务层接口
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
public interface IRoleService extends IBaseService<Role>{

	/**
	 * @title:findRoleList
	 * @description: 查询角色列表
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-04-09 17:20:57
	 */
	PageInfo<Role> findRoleList(Role role);
	
	/**
	 * @title:getRoleById
	 * @description: 根据ID查询角色信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-04-09 17:20:57
	 */
	Role getRoleById(Integer id);
	
	/**
	 * @title:saveRole
	 * @description: 新增
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-04-09 17:20:57
	 */
	boolean saveRole(Role role);
	
	 /**
	 * @title:editRole
	 * @description: 修改
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-04-09 17:20:57
	 */
	boolean editRole(Role role);
	
	/**
	 * @title:delRole
	 * @description: 删除
	 * @author 郑德超
	 * @param roleArr	主键编号集合
	 * @CreateDate  2018-04-09 17:20:57
	 */
	boolean delRole(List<Integer> roleArr);
}
