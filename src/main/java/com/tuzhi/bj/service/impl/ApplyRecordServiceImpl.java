package com.tuzhi.bj.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.base.BaseServiceImpl;
import com.tuzhi.bj.domain.ApplyRecord;
import com.tuzhi.bj.exception.UserException;
import com.tuzhi.bj.mapper.IApplyMapper;
import com.tuzhi.bj.mapper.IApplyRecordMapper;
import com.tuzhi.bj.service.IApplyRecordService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:ApplyRecordServiceImpl
 * @Description:申请记录,,主要记录会议过程业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-04-10 12:51:47
 */
@Service
public class ApplyRecordServiceImpl extends BaseServiceImpl<ApplyRecord> implements IApplyRecordService {
	
	@Autowired
	private IApplyRecordMapper applyRecordMapper;
	@Autowired
	private IApplyMapper applyMapper;
	
	private Integer i = 1;
	
	public PageInfo<ApplyRecord> findApplyRecordList(ApplyRecord applyRecord) {
		// TODO 分页查询
		PageHelper.startPage(applyRecord.getPageNum(), applyRecord.getPageSize());
		PageInfo<ApplyRecord> pageInfo = new PageInfo<ApplyRecord>(applyRecordMapper.findApplyRecordList(applyRecord));
		
		return pageInfo;
	}
	
	public ApplyRecord getApplyRecordById(Integer id){
		// TODO 根据ID查询
		return applyRecordMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveApplyRecord(ApplyRecord applyRecord) throws UserException{
		// TODO 新增
		applyRecord.setCreatedTime(new Date());
		applyRecord.setStatus(0);//0表示未处理
		boolean res = applyRecordMapper.insertSelective(applyRecord) > 0;
		if(!res)throw new UserException("新增开会失败");
		//然后处理apply中的result信息,修改为会议名称
		//获取会议名称,,并修改apply中的result
		String mname = applyRecordMapper.getMeetingNameById(applyRecord.getMeetingId());
		applyMapper.updateApplyResultById(applyRecord.getApplyId(),mname);
		return res;
	}
	
	public boolean editApplyRecord(ApplyRecord applyRecord){
		// TODO 修改
		return applyRecordMapper.updateApplyRecordSelectiveById(applyRecord) > 0;
	}
	
	public boolean delApplyRecord(List<Integer> applyRecordArr){
		// TODO	删除
		Example example = new Example(ApplyRecord.class);
		Criteria c = example.createCriteria();
		c.andIn("id", applyRecordArr);
		return applyRecordMapper.deleteByExample(example) > 0;
	}

	//获取安排好但是没有开的会议(即状态为0的会议)
	@Override
	public List<Map<String, Object>> getReadyMeetings() {
		return applyRecordMapper.getReadyMeetings();
	}

	@Override
	public void updateReadyMeetingByApplyId(ApplyRecord record) {
		applyRecordMapper.updateReadyMeetingByApplyId(record);
		//然后处理apply中的result信息,修改为会议名称
		//获取会议名称,,并修改apply中的result
		String mname = applyRecordMapper.getMeetingNameById(record.getMeetingId());
		applyMapper.updateApplyResultById(record.getApplyId(),mname);
	}

	//获取我需要开的会议
	@Override
	public List<Map<String, Object>> getMyMeetings(Integer userId) {
		// TODO Auto-generated method stub
		return applyRecordMapper.getMyMeetings(userId);
	}

	@Override
	public int finishMyMeeting(ApplyRecord record) {
		applyRecordMapper.finishMyMeeting(record);
		applyMapper.updateApplyResultById(record.getApplyId(),"会议筹备中");
		return 1;
	}
	
}
