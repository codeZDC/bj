package com.tuzhi.bj.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tuzhi.bj.base.BaseDomain;


/**
 * @ClassName:User
 * @Description:用户表的实体类
 * @author 郑德超
 * @CreateDate 2018-04-09 17:20:57
 */
@Table(name = "t_user")
public class User extends BaseDomain {
	
    /****/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**用户名**/
    private String username;

    /**账号**/
    private String account;

    /**密码**/
    private String password;

    /**手机号码**/
    private String phone;

    /**用户等级**/
    private Integer level;

    /**可用状态1可用 0不可用**/
    private Integer status;

    /**角色id**/
    private Integer roleId;

    /**排序编号**/
    private Integer orderBy;

    /**备注**/
    private String remarks;

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
    /**用户名**/
    public String getUsername(){
        return username;
    }
    /**用户名**/
    public void setUsername(String username){
        this.username= username;
    }
    /**账号**/
    public String getAccount(){
        return account;
    }
    /**账号**/
    public void setAccount(String account){
        this.account= account;
    }
    /**密码**/
    public String getPassword(){
        return password;
    }
    /**密码**/
    public void setPassword(String password){
        this.password= password;
    }
    /**手机号码**/
    public String getPhone(){
        return phone;
    }
    /**手机号码**/
    public void setPhone(String phone){
        this.phone= phone;
    }
    /**用户等级**/
    public Integer getLevel(){
        return level;
    }
    /**用户等级**/
    public void setLevel(Integer level){
        this.level= level;
    }
    /**可用状态1可用 0不可用**/
    public Integer getStatus(){
        return status;
    }
    /**可用状态1可用 0不可用**/
    public void setStatus(Integer status){
        this.status= status;
    }
    /**角色id**/
    public Integer getRoleId(){
        return roleId;
    }
    /**角色id**/
    public void setRoleId(Integer roleId){
        this.roleId= roleId;
    }
    /**排序编号**/
    public Integer getOrderBy(){
        return orderBy;
    }
    /**排序编号**/
    public void setOrderBy(Integer orderBy){
        this.orderBy= orderBy;
    }
    /**备注**/
    public String getRemarks(){
        return remarks;
    }
    /**备注**/
    public void setRemarks(String remarks){
        this.remarks= remarks;
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
