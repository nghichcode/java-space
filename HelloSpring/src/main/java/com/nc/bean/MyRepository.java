package com.nc.bean;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
	public String getAppName() {
		return "Hello Spring App";
	}
	public Date getDateTime() {
		return new Date();
	}
}
