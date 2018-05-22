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
import com.tuzhi.bj.domain.ApplyRecord;
import com.tuzhi.bj.exception.UserException;
import com.tuzhi.bj.service.IApplyRecordService;
import com.tuzhi.bj.util.TzResult;

/**
 * @ClassName:ApplyRecordController
 * @Description:申请记录,,主要记录会议过程的控制器
 * @author 郑德超
 * @CreateDate 2018-04-10 13:02:29
 */
@Controller
@RequestMapping("/applyRecord")
public class ApplyRecordController extends BaseController {

	@Autowired
	private IApplyRecordService applyRecordService;
	
	 /**
	 * @title:findApplyRecordList
	 * @description: 分页
	 * @author 郑德超
	 * @param applyRecord
	 * @CreateDate  2018-04-10 13:02:29
	 */
	@RequestMapping("/list")
	@ResponseBody
	public TzResult findApplyRecordList(ApplyRecord applyRecord){
		PageInfo<ApplyRecord> page = applyRecordService.findApplyRecordList(applyRecord);
		return TzResult.success().data(page);//PageInfo<ApplyRecord>
	}
	
	/**
	 * @title:getApplyRecordById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-04-10 13:02:29
	 */
	@RequestMapping("/get")
	@ResponseBody
	public ApplyRecord getApplyRecordById(Integer id){
		ApplyRecord applyRecord = applyRecordService.getApplyRecordById(id);
		return applyRecord;
	}
	
	
	 /**
	 * @title:editApplyRecord
	 * @description: 新增
	 * @author 郑德超
	 * @param applyRecord
	 * @throws UserException 
	 * @CreateDate  2018-04-10 13:02:29
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveApplyRecord(ApplyRecord applyRecord) throws UserException{
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = applyRecordService.saveApplyRecord(applyRecord);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editApplyRecord
	 * @description: 修改
	 * @author 郑德超
	 * @param applyRecord
	 * @CreateDate  2018-04-10 13:02:29
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editApplyRecord(ApplyRecord applyRecord){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = applyRecordService.editApplyRecord(applyRecord);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delApplyRecord
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-04-10 13:02:29
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delApplyRecord(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = applyRecordService.delApplyRecord(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
