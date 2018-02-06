package com.limovue.domain;

/**
 * APP请求回馈
 * 
 * @author DXM
 *
 */
public class Result {

	// 结果（0成功1失败）
	private int result;

	// 结果解释
	private String msg;

	// 返回数据（json格式）
	private Object data;

	public Result(int result, String msg, Object data) {
		this.result = result;
		this.msg = msg;
		this.data = data;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
