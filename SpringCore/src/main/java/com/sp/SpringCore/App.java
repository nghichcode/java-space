package com.sp.SpringCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sp.txt.TextEditor;

public class App {
    public static void main( String[] args ) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    	HiWorld hifirst = (HiWorld) context.getBean("hiWorld");
    	hifirst.setMessage("Hihihihihihi");
    	hifirst.getMessage();

    	HiWorld hi = (HiWorld) context.getBean("hiWorld");
    	hi.getMessage();
    	
    	JavaCollect jc = (JavaCollect) context.getBean("javaCollection");
    	jc.getAddressList();
    	jc.getAddressSet();
    	jc.getAddressMap();
    	jc.getAddressProp();

    	//Number 2
    	AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
    	Hello hello = (Hello) context.getBean("helloW");
    	hello.getMessage();
    	ctx.registerShutdownHook();

    	TextEditor te = (TextEditor) context.getBean("textEditor");
    	te.spellCheck();
    }
}
