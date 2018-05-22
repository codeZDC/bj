package com.tuzhi.bj.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.base.BaseServiceImpl;
import com.tuzhi.bj.mapper.IMeetingMapper;
import com.tuzhi.bj.domain.Meeting;
import com.tuzhi.bj.service.IMeetingService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:MeetingServiceImpl
 * @Description:会议表业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
@Service
public class MeetingServiceImpl extends BaseServiceImpl<Meeting> implements IMeetingService {
	
	@Autowired
	private IMeetingMapper meetingMapper;
 
	public PageInfo<Meeting> findMeetingList(Meeting meeting) {
		// TODO 分页查询
		PageHelper.startPage(meeting.getPageNum(), meeting.getPageSize());
		PageInfo<Meeting> pageInfo = new PageInfo<Meeting>(meetingMapper.findMeetingList(meeting));
		
		return pageInfo;
	}
	
	public Meeting getMeetingById(Integer id){
		// TODO 根据ID查询
		return meetingMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveMeeting(Meeting meeting){
		// TODO 新增
		meeting.setCreatedTime(new Date());
		return meetingMapper.insertSelective(meeting) > 0;
	}
	
	public boolean editMeeting(Meeting meeting){
		// TODO 修改
		return meetingMapper.updateMeetingSelectiveById(meeting) > 0;
	}
	
	public boolean delMeeting(List<Integer> meetingArr){
		// TODO	删除
		Example example = new Example(Meeting.class);
		Criteria c = example.createCriteria();
		c.andIn("id", meetingArr);
		return meetingMapper.deleteByExample(example) > 0;
	}

}
