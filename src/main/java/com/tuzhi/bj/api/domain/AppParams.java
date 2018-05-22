package com.tuzhi.bj.api.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author codeZ
 * @date 2018年4月11日 上午10:16:24
 * 
 */
/**
 * @author TZ
 *
 */
public class AppParams {
	
	//submit提交时候需要的草书
	private String projectName;

	@DateTimeFormat(pattern = "yyyy年MM月dd日")//存日期时使用  
	private Date applyTime;
	private String department;
	private String contacts;
	private String contactNumber;
	
	
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}
