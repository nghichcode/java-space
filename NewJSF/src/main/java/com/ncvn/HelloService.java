package com.ncvn;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="helloService")
@SessionScoped
public class HelloService {
	public String convert(String inp) {
		return "Hello: "+inp.toLowerCase();
	}
}
