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
import com.tuzhi.bj.domain.Apply;
import com.tuzhi.bj.service.IApplyService;
import com.tuzhi.bj.util.TzResult;
import com.tuzhi.bj.util.UploadUtils;

/**
 * @ClassName:ApplyController
 * @Description:申请文件的控制器
 * @author 郑德超
 * @CreateDate 2018-04-10 13:02:29
 */
@Controller
@RequestMapping("/apply")
public class ApplyController extends BaseController {
 
	@Autowired
	private IApplyService applyService;
	
	 /**
	 * @title:findApplyList
	 * @description: 分页
	 * @author 郑德超
	 * @param apply
	 * @CreateDate  2018-04-10 13:02:29
	 */
	@RequestMapping("/list")
	@ResponseBody
	public TzResult findApplyList(Apply apply){
		PageInfo<Apply> page = applyService.findApplyList(apply);
		return TzResult.success().data(page);//PageInfo<Apply>
	}
	
	/**
	 * @title:getApplyById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-04-10 13:02:29
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Apply getApplyById(Integer id){
		Apply apply = applyService.getApplyById(id);
		return apply;
	}
	
	
	 /**
	 * @title:editApply
	 * @description: 新增
	 * @author 郑德超
	 * @param apply
	 * @CreateDate  2018-04-10 13:02:29
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveApply(Apply apply){
		//上传文件
		apply.setImages(UploadUtils.upload(request));
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = applyService.saveApply(apply);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editApply
	 * @description: 修改
	 * @author 郑德超
	 * @param apply
	 * @CreateDate  2018-04-10 13:02:29
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editApply(Apply apply){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = applyService.editApply(apply);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delApply
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-04-10 13:02:29
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delApply(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = applyService.delApply(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
