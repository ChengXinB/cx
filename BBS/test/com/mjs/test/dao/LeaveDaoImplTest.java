package com.mjs.test.dao;

import java.util.Date;

import org.junit.Test;

import com.mjs.dao.LeaveDao;
import com.mjs.domain.Leave;
import com.mjs.utils.SpringInit;

public class LeaveDaoImplTest extends SpringInit{
	LeaveDao lDao = (LeaveDao) aContext.getBean("leaveDao");
	@Test
	public void testAddLeave() {
		aContext.getBean("sessionFactory");
		Leave l = new Leave();
		l.setL_content("留1言");
		l.setL_date(new Date());
//		l.setL_invitation(null);
//		l.setL_person(null);
		lDao.addLeave(l);
	}

	@Test
	public void testDeleteLeaveById() {
		lDao.deleteLeaveById("402881ef4c1b6087014c1b6097c90001");
	}

}
