package com.accenture.academico.controller.handler;

import java.io.Serializable;

public class StandardError implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private int status;
	private String msg;
	private Long timeStamp;
	
	public StandardError(int status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
