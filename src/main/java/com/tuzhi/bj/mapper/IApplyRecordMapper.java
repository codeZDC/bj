package com.tuzhi.bj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tuzhi.bj.domain.ApplyRecord;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:ApplyRecordMapper
 * @Description:申请记录,,主要记录会议过程数据层接口
 * @author 郑德超
 * @CreateDate 2018-04-10 12:51:47
 */
public interface IApplyRecordMapper extends Mapper<ApplyRecord> {
	
	/**
	 * @title:findApplyRecordList
	 * @description: 查询申请记录,,主要记录会议过程列表
	 * @author 郑德超
	 * @param applyRecord
	 * @CreateDate  2018-04-10 12:51:47
	 */
	List<ApplyRecord> findApplyRecordList(ApplyRecord applyRecord);
	
		/**
	 * @title:updateSelectiveById
	 * @description: 更新申请记录,,主要记录会议过程（更新不为null的值）
	 * @author 郑德超
	 * @param applyRecord
	 * @CreateDate  2018-04-10 12:51:47
	 */
    int updateApplyRecordSelectiveById(ApplyRecord applyRecord);
    
    //根据id获取会议名称
    @Select("select name from t_meeting where id = #{yangzhibo}")
	String getMeetingNameById(Integer meetingId);
    
    List<Map<String, Object>> getReadyMeetings();

	void updateReadyMeetingByApplyId(ApplyRecord record);

	List<Map<String, Object>> getMyMeetings(Integer userId);
	
	@Update("update t_apply_record set result = #{result},status=1 where apply_id=#{applyId} "
			+ "and meeting_id = #{meetingId} and personnel_id=#{userId}")
	int finishMyMeeting(ApplyRecord record);
}
