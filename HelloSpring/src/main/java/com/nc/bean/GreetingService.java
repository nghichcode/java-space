package com.nc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nc.lang.Language;

@Service
public class GreetingService {
	@Autowired
	private Language languagez;
	
	public GreetingService() {
	}
	
	public void sayGreeting() {
		System.out.println("Greeting: "+languagez.getGreeting());
	}
}
