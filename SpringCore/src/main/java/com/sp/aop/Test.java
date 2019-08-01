package com.sp.aop;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
	public static void main(String[] args) {
		Resource r= (Resource) new ClassPathResource("appContext.xml");
		@SuppressWarnings("unused")
		BeanFactory factory= (BeanFactory) new XmlBeanFactory(r);
		
		A a =  factory.getBean("proxy",A.class);
		a.m();
	}
}
