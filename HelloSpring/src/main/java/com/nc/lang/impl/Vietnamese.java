package com.nc.lang.impl;

import com.nc.lang.Language;

public class Vietnamese implements Language {

	@Override
	public String getGreeting() {
		return "Xin chao";
	}

	@Override
	public String getBye() {
		return "Tam biet";
	}

}
