package com.niti.androidstorageapp;

import java.util.Date;

public class Blog {
	private long _id;
	private String message;
	private Date date;
	
	public Blog() {
		this.date = new Date();
	}
	
	public Date getDate() {
		return date;
	}
	public long getId() {
		return _id;
	}
	public void setId( long id) {
		this._id = id;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public String toString() {
	    return message;
	  }

}
