package com.tuzhi.bj.mapper;

import java.util.List;

import com.tuzhi.bj.domain.User2;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:User2Mapper
 * @Description:员工表数据层接口
 * @author codeZ
 * @CreateDate 2018-05-11 11:56:40
 */
public interface IUser2Mapper extends Mapper<User2> {
	
	/**
	 * @title:findUser2List
	 * @description: 查询员工表列表
	 * @author codeZ
	 * @param user2
	 * @CreateDate  2018-05-11 11:56:40
	 */
	List<User2> findUser2List(User2 user2);
	
	
	/**
	 * @title:getUser2ById
	 * @description: 查询员工表信息
	 * @author codeZ
	 * @param id
	 * @CreateDate  2018-05-11 11:56:40
	 */
	User2 getUser2ById(Integer id);
	
	
	/**
	 * @title:deleteByPriKey
	 * @description: 根据id删除信息
	 * @author codeZ
	 * @param id
	 * @CreateDate  2018-05-11 11:56:40
	 */
	int deleteByPriKey(Integer id);


	/**
	 * @title:insert
	 * @description: 插入员工表
	 * @author codeZ
	 * @param user2
	 * @CreateDate  2018-05-11 11:56:40
	 */
    int insertUser2(User2 user2);


	/**
	 * @title:insertSelective
	 * @description: 插入员工表
	 * @author codeZ
	 * @param user2
	 * @CreateDate  2018-05-11 11:56:40
	 */
    int insertUser2Selective(User2 user2);

	/**
	 * @title:updateSelectiveById
	 * @description: 更新员工表（更新不为null的值）
	 * @author codeZ
	 * @param user2
	 * @CreateDate  2018-05-11 11:56:40
	 */
    int updateUser2SelectiveById(User2 user2);

	/**
	 * @title:updateById
	 * @description: 更新员工表（更新不为null的值）
	 * @author codeZ
	 * @param user2
	 * @CreateDate  2018-05-11 11:56:40
	 */
    int updateUser2ById(User2 user2);
}
