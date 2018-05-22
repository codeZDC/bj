package com.tuzhi.bj.service;

import java.util.List;
import java.util.Map;

import com.tuzhi.bj.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.domain.ApplyRecord;
import com.tuzhi.bj.exception.UserException;

/**
 * @ClassName:IApplyRecordService
 * @Description:申请记录,,主要记录会议过程业务层接口
 * @author 郑德超
 * @CreateDate 2018-04-10 12:51:47
 */
public interface IApplyRecordService extends IBaseService<ApplyRecord>{

	/**
	 * @title:findApplyRecordList
	 * @description: 查询申请记录,,主要记录会议过程列表
	 * @author 郑德超
	 * @param applyRecord
	 * @CreateDate  2018-04-10 12:51:47
	 */
	PageInfo<ApplyRecord> findApplyRecordList(ApplyRecord applyRecord);
	
	/**
	 * @title:getApplyRecordById
	 * @description: 根据ID查询申请记录,,主要记录会议过程信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-04-10 12:51:47
	 */
	ApplyRecord getApplyRecordById(Integer id);
	
	/**
	 * @title:saveApplyRecord
	 * @description: 新增
	 * @author 郑德超
	 * @param applyRecord
	 * @throws UserException 
	 * @CreateDate  2018-04-10 12:51:47
	 */
	boolean saveApplyRecord(ApplyRecord applyRecord) throws UserException;
	
	 /**
	 * @title:editApplyRecord
	 * @description: 修改
	 * @author 郑德超
	 * @param applyRecord
	 * @CreateDate  2018-04-10 12:51:47
	 */
	boolean editApplyRecord(ApplyRecord applyRecord);
	
	/**
	 * @title:delApplyRecord
	 * @description: 删除
	 * @author 郑德超
	 * @param applyRecordArr	主键编号集合
	 * @CreateDate  2018-04-10 12:51:47
	 */
	boolean delApplyRecord(List<Integer> applyRecordArr);

	List<Map<String, Object>> getReadyMeetings();

	void updateReadyMeetingByApplyId(ApplyRecord record);

	List<Map<String, Object>> getMyMeetings(Integer userId);

	int finishMyMeeting(ApplyRecord record);
}
