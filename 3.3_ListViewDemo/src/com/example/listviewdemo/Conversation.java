package com.example.listviewdemo;

import java.io.Serializable;

public class Conversation implements Serializable{
	String content;
	int resid;
	
	public Conversation() {

	}
	

	public Conversation(String content) {
		super();
		this.content = content;
	}


	public Conversation(String name, int quantity) {
		super();
		this.content = name;
		this.resid =quantity;
			}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getResid() {
		return resid;
	}

	public void setResid(int resid) {
		this.resid = resid;
	}

	@Override
	public String toString() {
		return "Item [content=" + content + ", resid=" + resid + "]";
	}

	
}
