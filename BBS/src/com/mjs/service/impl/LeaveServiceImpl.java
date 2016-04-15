package com.mjs.service.impl;

import com.mjs.dao.LeaveDao;
import com.mjs.service.LeaveService;


public class LeaveServiceImpl implements LeaveService {

	private LeaveDao leaveDao = null;

	public LeaveDao getLeaveDao() {
		return leaveDao;
	}

	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}
	
}
