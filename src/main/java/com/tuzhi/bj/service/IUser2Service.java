package com.tuzhi.bj.service;

import java.util.List;

import com.tuzhi.bj.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.domain.User2;

/**
 * @ClassName:IUser2Service
 * @Description:员工表业务层接口
 * @author codeZ
 * @CreateDate 2018-05-11 11:56:40
 */
public interface IUser2Service extends IBaseService<User2>{

	/**
	 * @title:findUser2List
	 * @description: 查询员工表列表
	 * @author codeZ
	 * @param user2
	 * @CreateDate  2018-05-11 11:56:40
	 */
	PageInfo<User2> findUser2List(User2 user2);
	
	/**
	 * @title:getUser2ById
	 * @description: 根据ID查询员工表信息
	 * @author codeZ
	 * @param id	主键
	 * @CreateDate  2018-05-11 11:56:40
	 */
	User2 getUser2ById(Integer id);
	
	/**
	 * @title:saveUser2
	 * @description: 新增
	 * @author codeZ
	 * @param user2
	 * @CreateDate  2018-05-11 11:56:40
	 */
	boolean saveUser2(User2 user2);
	
	 /**
	 * @title:editUser2
	 * @description: 修改
	 * @author codeZ
	 * @param user2
	 * @CreateDate  2018-05-11 11:56:40
	 */
	boolean editUser2(User2 user2);
	
	/**
	 * @title:delUser2
	 * @description: 删除
	 * @author codeZ
	 * @param user2Arr	主键编号集合
	 * @CreateDate  2018-05-11 11:56:40
	 */
	boolean delUser2(List<Integer> user2Arr);
}
