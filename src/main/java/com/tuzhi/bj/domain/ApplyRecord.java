package com.tuzhi.bj.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tuzhi.bj.base.BaseDomain;


/**
 * @ClassName:ApplyRecord
 * @Description:申请记录,,主要记录会议过程的实体类
 * @author 郑德超
 * @CreateDate 2018-04-11 16:55:18
 */
@Table(name = "t_apply_record")
public class ApplyRecord extends BaseDomain {
	
    /****/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    /**申请id**/
    private Integer applyId;
    /**安排会议的人id**/
    private Integer userId;
    /**会议id**/
    private Integer meetingId;
    /**计划开会人**/
    private Integer personnelId;
    /**计划开会日期**/
    @JsonFormat(pattern = "yyyy年MM月dd日",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy年MM月dd日")//存日期时使用  
    private java.util.Date plannedDate;

    /**计划开会时间**/
    private String plannedTime;

    /**实际开会日期**/
    @JsonFormat(pattern = "yyyy年MM月dd日",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy年MM月dd日")//存日期时使用  
    private java.util.Date actualDate;

    /**实际开会时间**/
    private String actualTime;

    /**是否处理状态0未 1处理**/
    private Integer status;

    /**会议结果**/
    private String result;

    /**创建时间**/
    private java.util.Date createdTime;

    /****/
    public Integer getId(){
        return id;
    }
    /****/
    public void setId(Integer id){
        this.id= id;
    }
    /**申请id**/
    public Integer getApplyId(){
        return applyId;
    }
    /**申请id**/
    public void setApplyId(Integer applyId){
        this.applyId= applyId;
    }
    /**安排会议的人id**/
    public Integer getUserId(){
        return userId;
    }
    /**安排会议的人id**/
    public void setUserId(Integer userId){
        this.userId= userId;
    }
    /**会议id**/
    public Integer getMeetingId(){
        return meetingId;
    }
    /**会议id**/
    public void setMeetingId(Integer meetingId){
        this.meetingId= meetingId;
    }
    /**计划开会人**/
    public Integer getPersonnelId(){
        return personnelId;
    }
    /**计划开会人**/
    public void setPersonnelId(Integer personnelId){
        this.personnelId= personnelId;
    }
    /**计划开会日期**/
    public java.util.Date getPlannedDate(){
        return plannedDate;
    }
    /**计划开会日期**/
    public void setPlannedDate(java.util.Date plannedDate){
        this.plannedDate= plannedDate;
    }
    /**计划开会时间**/
    public String getPlannedTime(){
        return plannedTime;
    }
    /**计划开会时间**/
    public void setPlannedTime(String plannedTime){
        this.plannedTime= plannedTime;
    }
    /**实际开会日期**/
    public java.util.Date getActualDate(){
        return actualDate;
    }
    /**实际开会日期**/
    public void setActualDate(java.util.Date actualDate){
        this.actualDate= actualDate;
    }
    /**实际开会时间**/
    public String getActualTime(){
        return actualTime;
    }
    /**实际开会时间**/
    public void setActualTime(String actualTime){
        this.actualTime= actualTime;
    }
    /**是否处理状态0未 1处理**/
    public Integer getStatus(){
        return status;
    }
    /**是否处理状态0未 1处理**/
    public void setStatus(Integer status){
        this.status= status;
    }
    /**会议结果**/
    public String getResult(){
        return result;
    }
    /**会议结果**/
    public void setResult(String result){
        this.result= result;
    }
    /**创建时间**/
    public java.util.Date getCreatedTime(){
        return createdTime;
    }
    /**创建时间**/
    public void setCreatedTime(java.util.Date createdTime){
        this.createdTime= createdTime;
    }

	
}
