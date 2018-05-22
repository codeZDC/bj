package com.tuzhi.bj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.base.BaseServiceImpl;
import com.tuzhi.bj.mapper.IUser2Mapper;
import com.tuzhi.bj.domain.User2;
import com.tuzhi.bj.service.IUser2Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:User2ServiceImpl
 * @Description:员工表业务层接口实现类
 * @author codeZ
 * @CreateDate 2018-05-11 11:56:40
 */
@Service
public class User2ServiceImpl extends BaseServiceImpl<User2> implements IUser2Service {
	
	@Autowired
	private IUser2Mapper user2Mapper;
 
	public PageInfo<User2> findUser2List(User2 user2) {
		// TODO 分页查询
		PageHelper.startPage(user2.getPageNum(), user2.getPageSize());
		PageInfo<User2> pageInfo = new PageInfo<User2>(user2Mapper.findUser2List(user2));
		
		return pageInfo;
	}
	
	public User2 getUser2ById(Integer id){
		// TODO 根据ID查询
		return user2Mapper.getUser2ById(id);
	}
	
	public boolean saveUser2(User2 user2){
		// TODO 新增
		return user2Mapper.insertUser2Selective(user2) > 0;
	}
	
	public boolean editUser2(User2 user2){
		// TODO 修改
		return user2Mapper.updateUser2SelectiveById(user2) > 0;
	}
	
	public boolean delUser2(List<Integer> user2Arr){
		// TODO	删除
		Example example = new Example(User2.class);
		Criteria c = example.createCriteria();
		c.andIn("id", user2Arr);
		return user2Mapper.deleteByExample(example) > 0;
	}

}
