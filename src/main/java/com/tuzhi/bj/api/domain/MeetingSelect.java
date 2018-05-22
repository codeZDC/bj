package com.tuzhi.bj.api.domain;

import java.util.List;
import java.util.Map;

/**
 * @author codeZ
 * @date 2018年4月11日 下午4:34:49
 * 
 */
public class MeetingSelect {

	private List<Map<String, Object>> listConference;
	private List<Map<String, Object>> listPersonnel;
	public List<Map<String, Object>> getListConference() {
		return listConference;
	}
	public void setListConference(List<Map<String, Object>> listConference) {
		this.listConference = listConference;
	}
	public List<Map<String, Object>> getListPersonnel() {
		return listPersonnel;
	}
	public void setListPersonnel(List<Map<String, Object>> listPersonnel) {
		this.listPersonnel = listPersonnel;
	}
	public MeetingSelect(List<Map<String, Object>> listConference, List<Map<String, Object>> listPersonnel) {
		super();
		this.listConference = listConference;
		this.listPersonnel = listPersonnel;
	}
	public MeetingSelect() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
