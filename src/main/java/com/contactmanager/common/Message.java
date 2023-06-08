package com.contactmanager.common;

public class Message {

	private String msg;
	private Object data;

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

	@Override
	public String toString() {
		return "Message{" + "msg=" + msg + ", data=" + data + '}';
	}

}
