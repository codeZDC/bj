package com.tuzhi.bj.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author codeZ
 * @date 2018年4月8日 下午5:26:58
 * 
 */
@JsonInclude(Include.NON_EMPTY)
public class App {

	private String errorMsg;
	private boolean status;
	private Object data;

	public Object getData() {
		return data;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public App setData(Object data) {
		this.data = data;
		return this;
	}

	public App(Object data,boolean status) {
		this.data = data;
		this.status = status;
	}

	public App(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public static App success() {
		return success(null);
	}
	public static App success(Object data) {
		return new App(data,true);
	}

	public App data(Object data) {
		return this.setData(data);
	}

	public static App fail() {
		return fail("失败");
	}

	public static App fail(String errorMsg) {
		return new App(errorMsg);
	}

}
