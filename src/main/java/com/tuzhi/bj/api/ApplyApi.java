package com.tuzhi.bj.api;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuzhi.bj.api.domain.AppApply;
import com.tuzhi.bj.api.domain.AppParams;
import com.tuzhi.bj.api.domain.MeetingSelect;
import com.tuzhi.bj.domain.Apply;
import com.tuzhi.bj.domain.ApplyRecord;
import com.tuzhi.bj.domain.Meeting;
import com.tuzhi.bj.domain.User;
import com.tuzhi.bj.domain.vo.ApplyExt;
import com.tuzhi.bj.service.IApplyRecordService;
import com.tuzhi.bj.service.IApplyService;
import com.tuzhi.bj.service.IMeetingService;
import com.tuzhi.bj.service.IUserService;
import com.tuzhi.bj.util.App;
import com.tuzhi.bj.util.DateStyle;
import com.tuzhi.bj.util.DateUtil;
import com.tuzhi.bj.util.PropertiesUtil;
import com.tuzhi.bj.util.UploadUtils;	

/**
 * @author codeZ
 * @date 2018年4月10日 下午3:44:45
 * 
 */
@RestController
@RequestMapping("api/apply")
public class ApplyApi {

	@Autowired
	private IApplyService service;
	@Autowired
	private IMeetingService meetingService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IApplyRecordService applyRecordService;
	
	private HttpServletRequest request;

	@ModelAttribute
	private void urlMsg(HttpServletRequest request) {
		System.err.println("请 求 地 址: \n" + request.getRequestURL() + "?" + request.getQueryString());
		this.request = request;
	}

	// 申请提交
	@RequestMapping("submit") // 去全局网络异常处理类处理下时间参数格式不正确400错误,
	public App submitApply(AppParams params, HttpServletRequest request) {
		try {
			Apply apply = new Apply();
			apply.setProjectName(params.getProjectName());
			apply.setApplyTime(params.getApplyTime());
			apply.setApplyPerson(params.getContacts());
			apply.setPhone(params.getContactNumber());
			apply.setApplyDepartment(params.getDepartment());
			apply.setImages(UploadUtils.upload(request));
			service.saveApply(apply);
			return App.success().data("添加成功!");
		} catch (Exception e) {
			return App.fail("网络异常:"+e.getMessage());
		}
	}

	// 申请人获取申请列表
	@RequestMapping("alreadyAccept") 
	public App alreadyAccept(Integer status) {
		//申请人获取的时候不用传值status
		//安排会议和办结人就需要传他们的level后台xml去判断得到对应的sql
		try {
			// 从数据路中获取之后需要处理一下图片路径和transactState备注问题
			List<AppApply> list = service.alreadyAccept(status);
			String[] split = null;
			List<String> images = null ;
			for (AppApply appApply : list) {
				if(appApply.getImages()!=null){
					split = appApply.getImages().split(",");
					images = new LinkedList<>();
					for (String string : split) {
						string = "http://" + request.getServerName() + ":" + request.getServerPort()
								+ request.getContextPath() + PropertiesUtil.getValue("UPLOAD_PATH") + string;
						images.add(string);
					}
					appApply.setImgUrl(images);
				}
				///抽代码
				if(appApply.getImages2()!=null){
					split = appApply.getImages2().split(",");
					images = new LinkedList<>();
					for (String string : split) {
						string = "http://" + request.getServerName() + ":" + request.getServerPort()
						+ request.getContextPath() + PropertiesUtil.getValue("UPLOAD_PATH") + string;
						images.add(string);
					}
					appApply.setImgUrl2(images);
				}
			}
			return App.success().data(list);
		} catch (Exception e) {
			System.out.println(e);
			return App.fail("网络异常:"+e.getMessage());
		}
	}


	// 获取表格式文件列表
	@RequestMapping("list")
	public App list() {
		try {
			List<Apply> list = service.applyList();
			AppApply applyList = new AppApply();
			List<List<String>> trs = new LinkedList<>();
			List<String> tr = null;
			int i = 1;
			for (Apply appl : list) {
				tr = new LinkedList<>();
				tr.add(i + "");
				i++;
				tr.add(appl.getProjectName());
				tr.add(appl.getApplyDepartment());
				tr.add(appl.getApplyPerson());
				tr.add(appl.getPhone());
				tr.add(new SimpleDateFormat("yyyy年MM月dd日").format(appl.getCreatedTime()));
				tr.add(appl.getResult());
				tr.add(((ApplyExt)appl).getMeetingUsername());
				trs.add(tr);
			}
			applyList.setTitle(new String[] { "序号", "项目名称", "职能部门", "联系人", "联系电话", "申请时间", "进度", "跟进人" });
			applyList.setArrayList(trs);
			return App.success().data(applyList);
		} catch (Exception e) {
			return App.fail("网络异常:"+e.getMessage());
		}
	}
	// 专家或办结 获取需要处理的文件
	@RequestMapping("getReadyApply")
	public App getReadyApply(Integer level) {
		return alreadyAccept(level);
	}

	// 获取所有的会议信息
	@RequestMapping("getMeetingsAndPersons")
	public App getMeetings() {
		try {
			// 使用默认的方法,仅仅是为了方便,pageSize==15已经够用了
			List<Meeting> meetings = meetingService.findMeetingList(new Meeting()).getList();
			Map<String, Object> map = null;
			List<Map<String, Object>> mlist = new LinkedList<>();
			List<Map<String, Object>> ulist = new LinkedList<>();
			for (Meeting meeting : meetings) {
				map = new HashMap<>();
				map.put("meetingType", meeting.getName());
				map.put("meetingId", meeting.getId());
				mlist.add(map);
			}
			//办结
			map = new HashMap<>();
			map.put("meetingType", "办结");
			map.put("meetingId", -1);
			mlist.add(map);
			
			//获取开会人
			User user = new User();
			user.setLevel(4);// level=4标识为开会人员
			List<User> users = userService.findUserList(user).getList();
			for (User u : users) {
				map = new HashMap<>();
				map.put("personnel", u.getUsername());
				map.put("personnelId", u.getId());
				ulist.add(map);
			}
			return App.success().data(new MeetingSelect(mlist, ulist));
		} catch (Exception e) {
			return App.fail("网络异常:"+e.getMessage());
		}
	}

	//暂时不用暂时不用暂时不用暂时不用暂时不用暂时不用暂时不用暂时不用暂时不用暂时不用暂时不用暂时不用暂时不用
	// 获取所有的开会人员
	@RequestMapping("getMeetingPersons")
	public App getMeetingPersons() {
		try {
			// 使用默认的方法,仅仅是为了方便,pageSize==15已经够用了
			User user = new User();
			user.setLevel(4);// level=4标识为开会人员
			List<User> users = userService.findUserList(user).getList();
			return App.success().data(users);
		} catch (Exception e) {
			return App.fail("网络异常:"+e.getMessage());
		}
	}
	
	
	//说明:安排会议的人在获取了会议和开会人之后,,他会选择相应的人去负责相应的会,,下面是将这些信息统计到数据库中t_apply_record
	@RequestMapping("readyToMeeting")
	public App readyToMeeting(ApplyRecord record) {
		try {
			if(-1 == record.getMeetingId()&&record.getApplyId()!=null)//办结
				return finishMeetings(record.getApplyId());
			if(record.getUserId()==null||record.getPersonnelId()==null||
					record.getMeetingId()==null||record.getPlannedTime()==null||
					record.getPlannedDate()==null)return App.fail("请传入参数");
			applyRecordService.saveApplyRecord(record);
			return App.success("安排成功");
		} catch (Exception e) {
			return App.fail("网络异常:"+e.getMessage());
		}
	}
	//说明:修改
	@RequestMapping("updateReadyMeeting")
	public App updateReadyMeeting(ApplyRecord record) {
		try {
			if(-1 == record.getMeetingId()&&record.getApplyId()!=null)//办结
				return finishMeetings(record.getApplyId());
			if(record.getUserId()==null||record.getPersonnelId()==null||
					record.getMeetingId()==null||record.getPlannedTime()==null||
					record.getPlannedDate()==null)return App.fail("请传入参数");
			applyRecordService.updateReadyMeetingByApplyId(record);
			return App.success("更新成功");
		} catch (Exception e) {
			return App.fail("网络异常:"+e.getMessage());
		}
	}
	
	//获取安排好但是还没有进行的会议
	//获取字段projectName , applyId ,plannedTime ,plannedDate ,actualDate,actualTime,personnel,meetingType,meetingId
	@RequestMapping("getReadyMeetings")
	public App getReadyMeetings(){
		try {
			List<Map<String,Object>> readyMeetings = applyRecordService.getReadyMeetings();
			for (Map<String, Object> map : readyMeetings) {
				if(map.get("plannedDate")!=null)map.put("plannedDate", DateUtil.StringToString(map.get("plannedDate").toString(), DateStyle.YYYY_MM_DD_CN));
				if(map.get("actualDate")!=null)map.put("actualDate", DateUtil.StringToString(map.get("actualDate").toString(), DateStyle.YYYY_MM_DD_CN));
			}
			return App.success(readyMeetings);
		} catch (Exception e) {
			return App.fail("网络异常:"+e.getMessage());
		}
	}
	
	//获取我要开的会
	@RequestMapping("getMyMeetings")
	public App getMyMeetings(Integer userId){
		try {
			List<Map<String,Object>> getMyMeetings = applyRecordService.getMyMeetings(userId);
			for (Map<String, Object> map : getMyMeetings) {
				if(map.get("plannedDate")!=null)map.put("plannedDate", DateUtil.StringToString(map.get("plannedDate").toString(), DateStyle.YYYY_MM_DD_CN));
				if(map.get("actualDate")!=null)map.put("actualDate", DateUtil.StringToString(map.get("actualDate").toString(), DateStyle.YYYY_MM_DD_CN));
			}
			return App.success(getMyMeetings);
		} catch (Exception e) {
			return App.fail("网络异常:"+e.getMessage());
		}
	}
	
	//开会完成了之后需要填写开会结果并
	@RequestMapping("finishMyMeeting")
	public App finishMyMeeting(ApplyRecord record){
		try {
			if(record.getUserId()==null||record.getApplyId()==null||record.getMeetingId()==null)
				return App.fail("请传入参数");
			applyRecordService.finishMyMeeting(record);
			return App.success("操作成功");
		} catch (Exception e) {
			return App.fail("网络异常:"+e.getMessage());
		}
	}
	//安排会议的人员点办结交给办结人员
	@RequestMapping("finishMeetings")
	public App finishMeetings(Integer applyId){
		try {
			if(applyId==null)return App.fail("请传入参数");
			service.finishMeetings(applyId);
			return App.success("操作成功");
		} catch (Exception e) {
			return App.fail("网络异常:"+e.getMessage());
		}
	}
	
	//申请完成
	@RequestMapping("finishApply")
	public App finishApply(Integer applyId,String result){
		try {
			if(applyId==null)return App.fail("请传入参数");
			String images = UploadUtils.upload(request);
			service.finishApply(applyId,result,images);
			return App.success("操作成功");
		} catch (Exception e) {
			return App.fail("网络异常:"+e.getMessage());
		}
	}
}

