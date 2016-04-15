package com.mjs.dao;

import com.mjs.domain.Leave;

public interface LeaveDao {
	public void addLeave(Leave leave);
	public void deleteLeaveById(String leaveId);

}
