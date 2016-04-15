package com.mjs.test.dao;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.mjs.dao.InvitationDao;
import com.mjs.domain.Invitation;
import com.mjs.domain.Leave;
import com.mjs.utils.SpringInit;

public class InvitationDaoImplTest extends SpringInit {
	InvitationDao iDao = (InvitationDao) aContext.getBean("invitationDao");
	@Test
	public void testAddInvitation() {
		Invitation i = new Invitation();
		i.setI_date(new Date());
		i.setI_last("123");
		i.setI_name("留言3");
		i.setI_rtime("123");
		i.setI_stime("123");
		
		Leave l = new Leave();
		l.setL_content("留4言");
		l.setL_date(new Date());
		
		i.getI_leave().add(l);
		iDao.addInvitation(i);
	}

	@Test
	public void testDeleteInvitationById() {
		iDao.deleteInvitationById("402881ef4c1bc325014c1bc336350001");
	}

	@Test
	public void testDeleteInvitationByName() {
		iDao.deleteInvitationByName("留言2");
	}

	@Test
	public void testFindInvitationById() {
		Assert.assertNotNull(iDao.findInvitationById("402881ef4c1bdea3014c1bdeb3df0001"));
	}

	@Test
	public void testFindAllInvitation() {
		System.out.println(iDao.findAllInvitation().size());
	}

	@Test
	public void testFindInvitationByName() {
		Assert.assertNotNull(iDao.findInvitationByName("留言1"));
	}

	@Test
	public void testFindLimitleave() {
		System.out.println(iDao.findLimitleave(0, 2, iDao.findInvitationById("402881ef4c1bdea3014c1bdeb3df0001")).toString());;
	}

}
