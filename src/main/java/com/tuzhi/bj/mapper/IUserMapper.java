package com.tuzhi.bj.mapper;

import java.util.List;

import com.tuzhi.bj.domain.User;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:UserMapper
 * @Description:用户表数据层接口
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
public interface IUserMapper extends Mapper<User> {
	
	/**
	 * @title:findUserList
	 * @description: 查询用户表列表
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-04-09 17:20:57
	 */
	List<User> findUserList(User user);
	
		/**
	 * @title:updateSelectiveById
	 * @description: 更新用户表（更新不为null的值）
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-04-09 17:20:57
	 */
    int updateUserSelectiveById(User user);
}
