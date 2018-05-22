package com.tuzhi.bj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tuzhi.bj.api.domain.AppApply;
import com.tuzhi.bj.domain.Apply;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:ApplyMapper
 * @Description:申请文件数据层接口
 * @author 郑德超
 * @CreateDate 2018-04-10 12:51:47
 */
public interface IApplyMapper extends Mapper<Apply> {
	
	/**
	 * @title:findApplyList
	 * @description: 查询申请文件列表
	 * @author 郑德超
	 * @param apply
	 * @CreateDate  2018-04-10 12:51:47
	 */
	List<Apply> findApplyList(Apply apply);
	
		/**
	 * @title:updateSelectiveById
	 * @description: 更新申请文件（更新不为null的值）
	 * @author 郑德超
	 * @param apply
	 * @CreateDate  2018-04-10 12:51:47
	 */
    int updateApplySelectiveById(Apply apply);
	
	List<AppApply> alreadyAccept(@Param("status")Integer status);

	@Update("update t_apply set result = #{param2} where id = #{param1}")
	int updateApplyResultById(Integer applyId, String result);

	//app获取会议列表,,跟进人
	List<Apply> applyList();
}
