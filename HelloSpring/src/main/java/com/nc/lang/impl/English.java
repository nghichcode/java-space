package com.nc.lang.impl;

import com.nc.lang.Language;

public class English implements Language {

	@Override
	public String getGreeting() {
		return "Hello";
	}

	@Override
	public String getBye() {
		return "Goodbye";
	}

}
