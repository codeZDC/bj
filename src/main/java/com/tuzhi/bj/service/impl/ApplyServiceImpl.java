package com.tuzhi.bj.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.api.domain.AppApply;
import com.tuzhi.bj.base.BaseServiceImpl;
import com.tuzhi.bj.domain.Apply;
import com.tuzhi.bj.domain.ApplyRecord;
import com.tuzhi.bj.mapper.IApplyMapper;
import com.tuzhi.bj.mapper.IApplyRecordMapper;
import com.tuzhi.bj.service.IApplyService;
import com.tuzhi.bj.util.JsonUtils;
import com.tuzhi.bj.util.PropertiesUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:ApplyServiceImpl
 * @Description:申请文件业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-04-10 12:51:47
 */
@Service
public class ApplyServiceImpl extends BaseServiceImpl<Apply> implements IApplyService {
	
	@Autowired
	private IApplyMapper applyMapper;
	@Autowired
	private IApplyRecordMapper applyRecordMapper;
 
	public PageInfo<Apply> findApplyList(Apply apply) {
		// TODO 分页查询
		PageHelper.startPage(apply.getPageNum(), apply.getPageSize());
		PageInfo<Apply> pageInfo = new PageInfo<Apply>(applyMapper.findApplyList(apply));
		
		return pageInfo;
	}
	
	public Apply getApplyById(Integer id){
		// TODO 根据ID查询
		return applyMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveApply(Apply apply){
		apply.setCreatedTime(new Date());
		apply.setStatus(2);//状态 1草稿  2专家处理3正在办结中  4完成
		apply.setResult(PropertiesUtil.getValue("INIT_APPLY_RESULT"));
		boolean flag = applyMapper.insertSelective(apply) > 0 ;
		
		if(flag);//百度云baiduyun给专家处理;
		return flag;
	}
	
	public boolean editApply(Apply apply){
		// TODO 修改
		return applyMapper.updateApplySelectiveById(apply) > 0;
	}
	
	public boolean delApply(List<Integer> applyArr){
		// TODO	删除
		Example example = new Example(Apply.class);
		Criteria c = example.createCriteria();
		c.andIn("id", applyArr);
		return applyMapper.deleteByExample(example) > 0;
	}

	@Override
	public List<AppApply> alreadyAccept(Integer status) {
		// TODO APP
		return applyMapper.alreadyAccept(status);
	}

	@Override
	public List<Apply> applyList() {
		return applyMapper.applyList();
	}

	//不需要开会了,办结处理
	
	@Override
	public void finishMeetings(Integer applyId) {
		//更新项目办结状态
		Apply apply = new Apply();
		apply.setId(applyId);
		apply.setStatus(3);//3是办结中
		apply.setResult("办结中");
		applyMapper.updateByPrimaryKeySelective(apply);
		//把没有开完的会给删除了
		ApplyRecord record = new ApplyRecord();
		record.setApplyId(applyId);
		record.setStatus(0);
		applyRecordMapper.delete(record);
	}
	
	//完成申请
	@Override
	public void finishApply(Integer applyId,String result, String images) {
		//json结果保存到库中
		Map<String, String> map = new HashMap<>();
		//map.put("result", result);
		//map.put("images", images);
		Apply apply = new Apply();
		apply.setId(applyId);
		apply.setStatus(4);//4表示项目完成
		apply.setApplyMsg(images);
		apply.setResult("已办结");
		applyMapper.updateByPrimaryKeySelective(apply);
	}

	
}
