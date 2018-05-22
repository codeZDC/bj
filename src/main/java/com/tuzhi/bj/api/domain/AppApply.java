package com.tuzhi.bj.api.domain;

import java.util.Date;
import java.util.List;

/**
 * @author codeZ
 * @date 2018年4月11日 上午11:07:32
 */
public class AppApply {

	private Integer applyId;
	private Date applyTime;
	private String contactNumber ;
	private String contacts;
	private String department;
	private String images;
	private String images2;
	private String projectName;
	private Date receptionTime;
	private String transactState;
	private List<String> imgUrl;
	private List<String> imgUrl2;
	
	
	//获取applyList的时候添加
	private String[] title;
	private List<?> arrayList;
	

	
	public String getImages2() {
		return images2;
	}
	public void setImages2(String images2) {
		this.images2 = images2;
	}
	public List<String> getImgUrl2() {
		return imgUrl2;
	}
	public void setImgUrl2(List<String> imgUrl2) {
		this.imgUrl2 = imgUrl2;
	}
	public String[] getTitle() {
		return title;
	}
	public void setTitle(String[] title) {
		this.title = title;
	}
	public List<?> getArrayList() {
		return arrayList;
	}
	public void setArrayList(List<?> arrayList) {
		this.arrayList = arrayList;
	}
	public Integer getApplyId() {
		return applyId;
	}
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public List<String> getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(List<String> imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getReceptionTime() {
		return receptionTime;
	}
	public void setReceptionTime(Date receptionTime) {
		this.receptionTime = receptionTime;
	}
	public String getTransactState() {
		return transactState;
	}
	public void setTransactState(String transactState) {
		this.transactState = transactState;
	}
}
