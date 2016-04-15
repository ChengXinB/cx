package com.mjs.test.service;

import org.junit.Test;

import com.mjs.service.PersonService;
import com.mjs.utils.SpringInit;

public class test extends SpringInit{
	@Test
	public void test01(){
		PersonService  ps = (PersonService) aContext.getBean("personService");
		ps.findPersonByNick("ff");
	}
}
