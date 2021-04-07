package com.accenture.academico.dto;

import java.util.Date;

public class DeleteDTO {

	
	private int status;
	private String msg;
	private Date date;
	public DeleteDTO(int status, String msg, Date date) {
		super();
		this.status = status;
		this.msg = msg;
		this.date = date;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
