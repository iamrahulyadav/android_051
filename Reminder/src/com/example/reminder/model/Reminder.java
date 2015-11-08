package com.example.reminder.model;

import java.io.Serializable;

public class Reminder implements Serializable{

	int remId;
	String remTitle,remType,remDate;
	public Reminder() {
		
	}
	
	public Reminder(int remId, String remTitle, String remType, String remDate) {
		super();
		this.remId = remId;
		this.remTitle = remTitle;
		this.remType = remType;
		this.remDate = remDate;
	}
	public int getRemId() {
		return remId;
	}
	public void setRemId(int remId) {
		this.remId = remId;
	}
	public String getRemTitle() {
		return remTitle;
	}
	public void setRemTitle(String remTitle) {
		this.remTitle = remTitle;
	}
	public String getRemType() {
		return remType;
	}
	public void setRemType(String remType) {
		this.remType = remType;
	}
	public String getRemDate() {
		return remDate;
	}
	public void setRemDate(String remDate) {
		this.remDate = remDate;
	}

	@Override
	public String toString() {
		return "Reminder [remId=" + remId + ", remTitle=" + remTitle
				+ ", remType=" + remType + ", remDate=" + remDate + "]";
	}
	
	
	
	
}
