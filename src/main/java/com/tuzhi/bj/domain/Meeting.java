package com.tuzhi.bj.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tuzhi.bj.base.BaseDomain;


/**
 * @ClassName:Meeting
 * @Description:会议表的实体类
 * @author 郑德超
 * @CreateDate 2018-04-09 15:39:57
 */
@Table(name = "t_meeting")
public class Meeting extends BaseDomain {
	
    /**主键**/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**会议名称**/
    private String name;

    /**会议内容说明**/
    private String remarks;

    /**排序**/
    private Integer orderBy;

    /**创建时间**/
    private java.util.Date createdTime;

    /**主键**/
    public Integer getId(){
        return id;
    }
    /**主键**/
    public void setId(Integer id){
        this.id= id;
    }
    /**会议名称**/
    public String getName(){
        return name;
    }
    /**会议名称**/
    public void setName(String name){
        this.name= name;
    }
    /**会议内容说明**/
    public String getRemarks(){
        return remarks;
    }
    /**会议内容说明**/
    public void setRemarks(String remarks){
        this.remarks= remarks;
    }
    /**排序**/
    public Integer getOrderBy(){
        return orderBy;
    }
    /**排序**/
    public void setOrderBy(Integer orderBy){
        this.orderBy= orderBy;
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
