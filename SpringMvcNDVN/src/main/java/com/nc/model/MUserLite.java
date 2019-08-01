package com.nc.model;

import java.util.Date;

public class MUserLite extends Object {
// "select muser.userId,muser.createdBy,muser.createdDate,muser.updatedBy,muser.updatedDate,muser.fullName,muser.userName from MUser as muser";

	private long userId;
	private long createdBy;
	private Date createdDate;
	private long updatedBy;
	private Date updatedDate;
	private String fullName;
	private String userName;

	public MUserLite() {}

	public MUserLite(long userId, long createdBy, Date createdDate, long updatedBy, Date updatedDate, String fullName, String userName) {
		super();
		this.userId = userId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.fullName = fullName;
		this.userName = userName;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
