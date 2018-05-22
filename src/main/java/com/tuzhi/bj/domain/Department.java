package com.tuzhi.bj.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tuzhi.bj.base.BaseDomain;


/**
 * @ClassName:Department
 * @Description:部门表的实体类
 * @author codeZ
 * @CreateDate 2018-05-11 12:49:20
 */
@Table(name = "tt_department")
public class Department extends BaseDomain {
	
    /**ID**/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**部门名称**/
    private String deptName;

    /**部门信息**/
    private String deptInfo;

    /**部门编号**/
    private String deptCode;

    /**备注**/
    private String remarks;

    /**创建时间**/
    private String createTime;

    /**ID**/
    public Integer getId(){
        return id;
    }
    /**ID**/
    public void setId(Integer id){
        this.id= id;
    }
    /**部门名称**/
    public String getDeptName(){
        return deptName;
    }
    /**部门名称**/
    public void setDeptName(String deptName){
        this.deptName= deptName;
    }
    /**部门信息**/
    public String getDeptInfo(){
        return deptInfo;
    }
    /**部门信息**/
    public void setDeptInfo(String deptInfo){
        this.deptInfo= deptInfo;
    }
    /**部门编号**/
    public String getDeptCode(){
        return deptCode;
    }
    /**部门编号**/
    public void setDeptCode(String deptCode){
        this.deptCode= deptCode;
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
    public String getCreateTime(){
        return createTime;
    }
    /**创建时间**/
    public void setCreateTime(String createTime){
        this.createTime= createTime;
    }

	
}
