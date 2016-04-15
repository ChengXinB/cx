package com.mjs.test.dao;

import java.util.Date;

import org.junit.Test;

import com.mjs.dao.PersonDao;
import com.mjs.dao.RoleDao;
import com.mjs.domain.Invitation;
import com.mjs.domain.Leave;
import com.mjs.domain.Person;
import com.mjs.utils.SpringInit;

public class PersonDaoImplTest extends SpringInit {
	PersonDao pDao = (PersonDao) aContext.getBean("personDao");
	RoleDao rDao = (RoleDao) aContext.getBean("roleDao");
	@Test
	public void testFindPersonById() {
		pDao.findPersonById("402881ef4c1c0542014c1c0555360001");
	}

	@Test
	public void testFindAllPerson() {
		System.out.println(pDao.findAllPerson().size());;
	}

	@Test
	public void testFindLimitPerson() {
		System.out.println(pDao.findLimitPerson(0, 2).toString());
	}

	@Test
	public void testFindLimitInvitation() {
		System.out.println(pDao.findLimitInvitation(0, 1, pDao.findPersonById("402881ef4c1c0542014c1c0555360001")));
	}

	@Test
	public void testFindPerson() {
		System.out.println(pDao.findPerson("xiao", "234"));
	}

	@Test
	public void testAddPerson() {
		
		int ii = 1;
		while(ii++<34){
		Person person = new Person();
		person.setP_password("123");
		person.setP_username("xiaomi1ng"+ii);
		
		Invitation i = new Invitation();
		i.setI_date(new Date());
		i.setI_last("123");
		i.setI_name("留言2222222222222");
		i.setI_rtime("123");
		i.setI_stime("123");
		
		Leave l = new Leave();
		l.setL_content("留言222222222222");
		l.setL_date(new Date());
		l.setL_person(person);
		
		i.getI_leave().add(l);
		person.getP_invitation().add(i);
		
		person.getP_role().add(rDao.findRoleByName("管理员"));
//		pDao.addPerson(person);
		}
//		rDao.findRoleByName("管理员");
		
	}

	@Test
	public void testUpdatePerson() {
		Person p = pDao.findPersonById("402881ef4c1c0542014c1c0555360001");
		p.setP_birthday(new Date());
		pDao.updatePerson(p);
	}

}
