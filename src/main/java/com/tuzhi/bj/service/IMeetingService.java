package com.tuzhi.bj.service;

import java.util.List;

import com.tuzhi.bj.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.domain.Meeting;

/**
 * @ClassName:IMeetingService
 * @Description:会议表业务层接口
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
public interface IMeetingService extends IBaseService<Meeting>{

	/**
	 * @title:findMeetingList
	 * @description: 查询会议表列表
	 * @author 郑德超
	 * @param meeting
	 * @CreateDate  2018-04-09 17:20:57
	 */
	PageInfo<Meeting> findMeetingList(Meeting meeting);
	
	/**
	 * @title:getMeetingById
	 * @description: 根据ID查询会议表信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-04-09 17:20:57
	 */
	Meeting getMeetingById(Integer id);
	
	/**
	 * @title:saveMeeting
	 * @description: 新增
	 * @author 郑德超
	 * @param meeting
	 * @CreateDate  2018-04-09 17:20:57
	 */
	boolean saveMeeting(Meeting meeting);
	
	 /**
	 * @title:editMeeting
	 * @description: 修改
	 * @author 郑德超
	 * @param meeting
	 * @CreateDate  2018-04-09 17:20:57
	 */
	boolean editMeeting(Meeting meeting);
	
	/**
	 * @title:delMeeting
	 * @description: 删除
	 * @author 郑德超
	 * @param meetingArr	主键编号集合
	 * @CreateDate  2018-04-09 17:20:57
	 */
	boolean delMeeting(List<Integer> meetingArr);
}
