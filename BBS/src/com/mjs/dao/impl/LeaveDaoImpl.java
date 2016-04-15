package com.mjs.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mjs.dao.LeaveDao;
import com.mjs.dao.exception.DaoException;
import com.mjs.domain.Leave;

public class LeaveDaoImpl extends HibernateDaoSupport implements LeaveDao {

	@Override
	public void addLeave(Leave leave) {
		try {
			this.getHibernateTemplate().save(leave);
		} catch (Exception e) {
			throw new DaoException("LeaveDaoImpl Exception : addLeave()");
		}
	}

	@Override
	public void deleteLeaveById(String leaveId) {
		try {
			Query query = this.getSession().createQuery("delete from Leave where l_id=:id");
			query.setString("id", leaveId);
			query.executeUpdate();
		} catch (Exception e) {
			throw new DaoException("LeaveDaoImpl Exception : deleteLeaveById()");
		}
	}

}
