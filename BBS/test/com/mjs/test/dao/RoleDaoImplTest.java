package com.mjs.test.dao;

import org.junit.Test;

import com.mjs.dao.AuthorityDao;
import com.mjs.dao.RoleDao;
import com.mjs.dao.impl.RoleDaoImpl;
import com.mjs.domain.Role;
import com.mjs.utils.SpringInit;

public class RoleDaoImplTest extends SpringInit{
	private RoleDao rDao = (RoleDao) aContext.getBean("roleDao");
	private AuthorityDao aDao = (AuthorityDao) aContext.getBean("authorityDao");
	@Test
	public void testAddRole() {
		Role r = new Role();
		r.setR_name("管理员1");
		r.getR_authority().add(aDao.findAuthorityById("ff8080814c18a5c0014c18a5d4b50001"));
		rDao.addRole(r);
	}

	@Test
	public void testUpdateRoleById() {
		Role r = new Role();
		r = rDao.findRoleByName("删帖会员");
//		r.getR_authority().add(aDao.findAuthorityById("402880014c2009ee014c2009f1e90001"));
//		rDao.updateRoleById(r);
	}

	@Test
	public void testDeleteRoleById() {
		rDao.deleteRoleById("ff8080814c18b034014c18b044b40001");
	}

	@Test
	public void testFindRoleByName() {
//		System.out.println(rDao.findRoleByName("管理员1"));
		Role r = rDao.findRoleByName("管理员");
		
//		System.out.println(r);
	}

	@Test
	public void testFindAllRole() {
		System.out.println(rDao.findAllRole().size());
	}

}
