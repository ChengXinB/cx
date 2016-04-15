package com.mjs.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInit {
	public static ApplicationContext aContext = null;
	static{
		aContext = new ClassPathXmlApplicationContext("spring/ApplicationContext.xml");
	}
}
