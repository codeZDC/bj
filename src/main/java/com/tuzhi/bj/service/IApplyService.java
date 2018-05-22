package com.tuzhi.bj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.api.domain.AppApply;
import com.tuzhi.bj.base.IBaseService;
import com.tuzhi.bj.domain.Apply;
import com.tuzhi.bj.domain.ApplyRecord;

/**
 * @ClassName:IApplyService
 * @Description:申请文件业务层接口
 * @author 郑德超
 * @CreateDate 2018-04-10 12:51:47
 */
public interface IApplyService extends IBaseService<Apply>{

	/**
	 * @title:findApplyList
	 * @description: 查询申请文件列表
	 * @author 郑德超
	 * @param apply
	 * @CreateDate  2018-04-10 12:51:47
	 */
	PageInfo<Apply> findApplyList(Apply apply);
	
	/**
	 * @title:getApplyById
	 * @description: 根据ID查询申请文件信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-04-10 12:51:47
	 */
	Apply getApplyById(Integer id);
	
	/**
	 * @title:saveApply
	 * @description: 新增
	 * @author 郑德超
	 * @param apply
	 * @CreateDate  2018-04-10 12:51:47
	 */
	boolean saveApply(Apply apply);
	
	 /**
	 * @title:editApply
	 * @description: 修改
	 * @author 郑德超
	 * @param apply
	 * @CreateDate  2018-04-10 12:51:47
	 */
	boolean editApply(Apply apply);
	
	/**
	 * @title:delApply
	 * @description: 删除
	 * @author 郑德超
	 * @param applyArr	主键编号集合
	 * @CreateDate  2018-04-10 12:51:47
	 */
	boolean delApply(List<Integer> applyArr);

	List<AppApply> alreadyAccept(Integer status);

	//api获取会议列表,,跟进人
	List<Apply> applyList();

	void finishApply(Integer applyId,String result, String images);

	void finishMeetings(Integer applyId);

}
