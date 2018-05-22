package com.tuzhi.bj.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.base.BaseServiceImpl;
import com.tuzhi.bj.domain.User;
import com.tuzhi.bj.exception.UserException;
import com.tuzhi.bj.mapper.IUserMapper;
import com.tuzhi.bj.service.IUserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:UserServiceImpl
 * @Description:用户表业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
	
	@Autowired
	private IUserMapper userMapper;
 
	public PageInfo<User> findUserList(User user) {
		// TODO 分页查询
		PageHelper.startPage(user.getPageNum(), user.getPageSize());
		PageInfo<User> pageInfo = new PageInfo<User>(userMapper.findUserList(user));
		
		return pageInfo;
	}
	
	public User getUserById(Integer id){
		// TODO 根据ID查询
		return userMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveUser(User user){
		// TODO 新增
		user.setCreatedTime(new Date());
		return userMapper.insertSelective(user) > 0;
	}
	
	public boolean editUser(User user){
		// TODO 修改
		return userMapper.updateUserSelectiveById(user) > 0;
	}
	
	public boolean delUser(List<Integer> userArr){
		// TODO	删除
		Example example = new Example(User.class);
		Criteria c = example.createCriteria();
		c.andIn("id", userArr);
		return userMapper.deleteByExample(example) > 0;
	}

	@Override
	public User login(String account, String password) throws UserException {
		// TODO API 用户登录并返回该用户信息
		User record = new User();
		record.setAccount(account);
		record.setPassword(password);
		record = userMapper.selectOne(record); 
		if(record == null)
			throw new UserException("用户名或密码错误!");
		return  record;
	}
	@Override
	public void uploadPassword(String account, String password, String newPassword) throws UserException {
		// TODO APP 修改密码
		Example example = new Example(User.class);
		User user = new User();
		example.createCriteria().andEqualTo("account", account).andEqualTo("password", password);
		user.setPassword(newPassword);
		if(!(userMapper.updateByExampleSelective(user, example) > 0))
			throw new UserException("用户名或密码错误!");
	}

	
}
