package com.tuzhi.bj.mapper;

import java.util.List;

import com.tuzhi.bj.domain.Meeting;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:MeetingMapper
 * @Description:会议表数据层接口
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
public interface IMeetingMapper extends Mapper<Meeting> {
	
	/**
	 * @title:findMeetingList
	 * @description: 查询会议表列表
	 * @author 郑德超
	 * @param meeting
	 * @CreateDate  2018-04-09 17:20:57
	 */
	List<Meeting> findMeetingList(Meeting meeting);
	
		/**
	 * @title:updateSelectiveById
	 * @description: 更新会议表（更新不为null的值）
	 * @author 郑德超
	 * @param meeting
	 * @CreateDate  2018-04-09 17:20:57
	 */
    int updateMeetingSelectiveById(Meeting meeting);
}
