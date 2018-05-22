package com.tuzhi.bj.service;

import java.util.List;

import com.tuzhi.bj.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.domain.User;
import com.tuzhi.bj.exception.UserException;

/**
 * @ClassName:IUserService
 * @Description:用户表业务层接口
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
public interface IUserService extends IBaseService<User>{

	/**
	 * @title:findUserList
	 * @description: 查询用户表列表
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-04-09 17:20:57
	 */
	PageInfo<User> findUserList(User user);
	
	/**
	 * @title:getUserById
	 * @description: 根据ID查询用户表信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-04-09 17:20:57
	 */
	User getUserById(Integer id);
	
	/**
	 * @title:saveUser
	 * @description: 新增
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-04-09 17:20:57
	 */
	boolean saveUser(User user);
	
	 /**
	 * @title:editUser
	 * @description: 修改
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-04-09 17:20:57
	 */
	boolean editUser(User user);
	
	/**
	 * @title:delUser
	 * @description: 删除
	 * @author 郑德超
	 * @param userArr	主键编号集合
	 * @CreateDate  2018-04-09 17:20:57
	 */
	boolean delUser(List<Integer> userArr);

	User login(String account, String password) throws UserException;

	void uploadPassword(String account, String password, String newPassword) throws UserException;
}
