package com.nc.HelloSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nc.bean.GreetingService;
import com.nc.bean.MyComponent;
import com.nc.config.AppConfig;
import com.nc.lang.Language;

public class MainProgram {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("-----------------------");
		Language language=(Language)context.getBean("languagez");
		System.out.println("Bean Language: "+language);
		System.out.println("Say bye: "+language.getBye());
		
		System.out.println("-----------------------");
		GreetingService service=(GreetingService)context.getBean("greetingService");
		service.sayGreeting();
		
		System.out.println("-----------------------");
		MyComponent component=(MyComponent)context.getBean("myComponent");
		component.showAppInfo();
	}
}
