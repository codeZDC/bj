package com.tuzhi.bj.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author codeZ
 * @date 2018年4月8日 下午5:26:58
 * 
 */
@JsonInclude(Include.NON_EMPTY)
public class TzResult {

	private String msg ;
	private boolean success ;
	private Object data;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public TzResult setData(Object data) {
		this.data = data;
		return this;
	}
	public TzResult(String msg, boolean success) {
		super();
		this.msg = msg;
		this.success = success;
	}
	public TzResult(String msg) {
		super();
		this.msg = msg;
	}
	
	public static TzResult success(){
		return success("");
	}
	public static TzResult success(String msg){
		return new TzResult(msg, true);
	}
	public TzResult data(Object data){
		return this.setData(data);
	}
	public static TzResult fail(){
		return fail("");
	}
	public static TzResult fail(String error){
		return new TzResult(error);
	}
	
}
