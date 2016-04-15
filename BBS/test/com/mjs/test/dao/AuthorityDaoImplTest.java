package com.mjs.test.dao;

import org.junit.Test;
import com.mjs.dao.AuthorityDao;
import com.mjs.domain.Authority;
import com.mjs.utils.SpringInit;

public class AuthorityDaoImplTest extends SpringInit{
	private AuthorityDao aDao = (AuthorityDao) aContext.getBean("authorityDao");
	@Test
	public void testAddAuthority() {
		Authority a = new Authority();
		a.setA_name("你好6");
		a.setA_url("/manager");
		aDao.addAuthority(a);
	}

	@Test
	public void testFindAuthorityById() {
		System.out.println(aDao.findAuthorityById("402881ef4c1826a8014c1826b8380001"));;
	}

	@Test
	public void testUpdateAuthorityById() {
		Authority a = new Authority();
		a.setA_id("402881ef4c1826a8014c1826b8380001");
		a.setA_name("你1好");
		a.setA_url("/manager");
		aDao.updateAuthorityById(a);
	}

	@Test
	public void testDeleteAuthorityByName() {
		aDao.deleteAuthorityByName("你1好");
	}

}
