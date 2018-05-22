package com.tuzhi.bj.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tuzhi.bj.base.BaseDomain;


/**
 * @ClassName:Apply
 * @Description:申请文件的实体类
 * @author 郑德超
 * @CreateDate 2018-04-10 13:02:29
 */
@Table(name = "t_apply")
public class Apply extends BaseDomain {
	
    /****/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**项目名称**/
    private String projectName;

    /**申请人**/
    private String applyPerson;

    /**申请部门**/
    private String applyDepartment;

    /**申请时间**/
    private java.util.Date applyTime;

    /**申请信息**/
    private String applyMsg;

    /**联系人电话**/
    private String phone;

    /**材料图片信息**/
    private String images;

    /**状态0草稿1专家处理中2正在办结中3完成**/
    private Integer status;

    /**处理结果**/
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
    /**项目名称**/
    public String getProjectName(){
        return projectName;
    }
    /**项目名称**/
    public void setProjectName(String projectName){
        this.projectName= projectName;
    }
    /**申请人**/
    public String getApplyPerson(){
        return applyPerson;
    }
    /**申请人**/
    public void setApplyPerson(String applyPerson){
        this.applyPerson= applyPerson;
    }
    /**申请部门**/
    public String getApplyDepartment(){
        return applyDepartment;
    }
    /**申请部门**/
    public void setApplyDepartment(String applyDepartment){
        this.applyDepartment= applyDepartment;
    }
    /**申请时间**/
    public java.util.Date getApplyTime(){
        return applyTime;
    }
    /**申请时间**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用  
    public void setApplyTime(java.util.Date applyTime){
        this.applyTime= applyTime;
    }
    /**申请信息**/
    public String getApplyMsg(){
        return applyMsg;
    }
    /**申请信息**/
    public void setApplyMsg(String applyMsg){
        this.applyMsg= applyMsg;
    }
    /**联系人电话**/
    public String getPhone(){
        return phone;
    }
    /**联系人电话**/
    public void setPhone(String phone){
        this.phone= phone;
    }
    /**材料图片信息**/
    public String getImages(){
        return images;
    }
    /**材料图片信息**/
    public void setImages(String images){
        this.images= images;
    }
    /**状态0草稿1专家处理中2正在办结中3完成**/
    public Integer getStatus(){
        return status;
    }
    /**状态0草稿1专家处理中2正在办结中3完成**/
    public void setStatus(Integer status){
        this.status= status;
    }
    /**处理结果**/
    public String getResult(){
        return result;
    }
    /**处理结果**/
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
