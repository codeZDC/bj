package com.tuzhi.bj.mapper;

import java.util.List;

import com.tuzhi.bj.domain.Role;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:RoleMapper
 * @Description:角色数据层接口
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
public interface IRoleMapper extends Mapper<Role> {
	
	/**
	 * @title:findRoleList
	 * @description: 查询角色列表
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-04-09 17:20:57
	 */
	List<Role> findRoleList(Role role);
	
		/**
	 * @title:updateSelectiveById
	 * @description: 更新角色（更新不为null的值）
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-04-09 17:20:57
	 */
    int updateRoleSelectiveById(Role role);
}
