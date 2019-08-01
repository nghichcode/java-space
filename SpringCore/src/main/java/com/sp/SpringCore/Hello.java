package com.sp.SpringCore;

public class Hello {
	private String message;

	public void getMessage() {
		System.out.println("Your message: "+message);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void initBean() {
		System.out.println("Init Hello");
	}

	public void destroyBean() {
		System.out.println("Destroy Hello");
	}

}
