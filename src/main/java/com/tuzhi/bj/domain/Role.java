package com.tuzhi.bj.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tuzhi.bj.base.BaseDomain;


/**
 * @ClassName:Role
 * @Description:的实体类
 * @author 郑德超
 * @CreateDate 2018-04-09 15:39:57
 */
@Table(name = "t_role")
public class Role extends BaseDomain {
	
    /****/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**角色名**/
    private String roleName;

    /**角色标识**/
    private String roleKey;

    /**角色等级**/
    private Integer level;

    /**备注**/
    private String remarks;

    /**排序**/
    private Integer orderBy;

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
    /**角色名**/
    public String getRoleName(){
        return roleName;
    }
    /**角色名**/
    public void setRoleName(String roleName){
        this.roleName= roleName;
    }
    /**角色标识**/
    public String getRoleKey(){
        return roleKey;
    }
    /**角色标识**/
    public void setRoleKey(String roleKey){
        this.roleKey= roleKey;
    }
    /**角色等级**/
    public Integer getLevel(){
        return level;
    }
    /**角色等级**/
    public void setLevel(Integer level){
        this.level= level;
    }
    /**备注**/
    public String getRemarks(){
        return remarks;
    }
    /**备注**/
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
