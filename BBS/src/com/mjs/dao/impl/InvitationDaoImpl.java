package com.mjs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mjs.dao.InvitationDao;
import com.mjs.dao.exception.DaoException;
import com.mjs.domain.Invitation;
import com.mjs.domain.InvitationQuery;
import com.mjs.domain.LeaveQuery;
import com.mjs.domain.Person;

public class InvitationDaoImpl extends HibernateDaoSupport implements
		InvitationDao {

	@Override
	public void addInvitation(Invitation invitation) {
		try {
			this.getHibernateTemplate().save(invitation);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(
					"InvitationDaoImpl Exception : addInvitation()");
		}
	}

	@Override
	public void deleteInvitationById(String invitationId) {
		try {
			this.getSession().delete(
					this.getSession()//
					.get(Invitation.class, invitationId)
				);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(
					"InvitationDaoImpl Exception : deleteInvitationById()");
		}
	}

	@Override
	public void deleteInvitationByName(String invitationName) {
		try {
			Query query = this.getSession().createQuery(
					"from Invitation i where i.i_name=:name");
			query.setString("name", invitationName);
			this.getSession().delete(
					query.uniqueResult()
				);
			
		} catch (Exception e) {
			throw new DaoException(
					"InvitationDaoImpl Exception : deleteInvitationByName()");
		}
	}

	@Override
	public Invitation findInvitationById(String invitationId) {
		try {
			Query query = this.getSession().createQuery(
					"from Invitation where i_id=:id");
			query.setString("id", invitationId);
			return (Invitation) query.uniqueResult();
		} catch (Exception e) {
			throw new DaoException(
					"InvitationDaoImpl Exception : findInvitationById()");
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Invitation> findAllInvitation() {
		try {
			return this.getSession().createQuery("from Invitation").list();
		} catch (Exception e) {
			throw new DaoException("InvitationDaoImpl Exception : findAllInvitation()");
		}
	}

	@Override
	public List<Invitation> findInvitationByName(String invitationName) {
		try {
			Query query = this.getSession().createQuery(
					"from Invitation i where i.i_name=:name");
			query.setString("name", invitationName);
			return query.list();
		} catch (Exception e) {
			throw new DaoException("InvitationDaoImpl Exception : findInvitationByName()");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public LeaveQuery findLimitleave(int firstResult, int maxResults,
			Invitation invitation) {
		try {
			Query query = this.getSession().createQuery(
					"from Leave where l_invitation=:invitationId");
			LeaveQuery iQuery = new LeaveQuery();
			iQuery.setList(//
			query.setString("invitationId", invitation.getI_id())
					.setFirstResult(firstResult)//
					.setMaxResults(maxResults)//
					.list()//
			);
			Query q = this
					.getSession()
					.createQuery(
							"select count(*) from Leave where l_invitation=:invitationId");
			q.setString("invitationId", invitation.getI_id());

			iQuery.setCount(((Long)q.uniqueResult()).intValue());
			return iQuery;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("InvitationDaoImpl Exception : findLimitleave()");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public InvitationQuery findLimitInvitation(int firstResult, int maxResults) {
		
		try {
			Query query = this.getSession().createQuery(
					"from Invitation i");
			InvitationQuery iQuery = new InvitationQuery();
			iQuery.setList(//
			query.setFirstResult(firstResult)//
					.setMaxResults(maxResults)//
					.list()//
			);
			Query q = this
					.getSession()
					.createQuery(//
							"select count(*) from Invitation i");
			iQuery.setCount(((Long) q.uniqueResult()).intValue());
			return iQuery;
		} catch (Exception e) {
			throw new DaoException(
					"InvitationDaoImpl Exception : findLimitInvitation()");
		}
		
	}

	@Override
	public boolean updateInvitation(Invitation invitation) {
		try {
			this.getHibernateTemplate().update(invitation);
			return true;
		} catch (Exception e) {
			throw new DaoException("InvitationDaoImpl Exception : findInvitationByName()");
		}
	}
}
