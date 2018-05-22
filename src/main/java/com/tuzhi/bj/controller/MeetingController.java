package com.tuzhi.bj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tuzhi.bj.base.BaseController;
import com.tuzhi.bj.domain.Meeting;
import com.tuzhi.bj.service.IMeetingService;
import com.tuzhi.bj.util.TzResult;

/**
 * @ClassName:MeetingController
 * @Description:会议表的控制器
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
@Controller
@RequestMapping("/meeting")
public class MeetingController extends BaseController {

	@Autowired
	private IMeetingService meetingService;
	
	 /**
	 * @title:findMeetingList
	 * @description: 分页
	 * @author 郑德超
	 * @param meeting
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("/list")
	@ResponseBody
	public TzResult findMeetingList(Meeting meeting){
		PageInfo<Meeting> page = meetingService.findMeetingList(meeting);
		return TzResult.success().data(page);//PageInfo<Meeting>
	}
	
	/**
	 * @title:getMeetingById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Meeting getMeetingById(Integer id){
		Meeting meeting = meetingService.getMeetingById(id);
		return meeting;
	}
	
	
	 /**
	 * @title:editMeeting
	 * @description: 新增
	 * @author 郑德超
	 * @param meeting
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveMeeting(Meeting meeting){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = meetingService.saveMeeting(meeting);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editMeeting
	 * @description: 修改
	 * @author 郑德超
	 * @param meeting
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editMeeting(Meeting meeting){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = meetingService.editMeeting(meeting);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delMeeting
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-04-09 17:20:57
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delMeeting(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = meetingService.delMeeting(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
