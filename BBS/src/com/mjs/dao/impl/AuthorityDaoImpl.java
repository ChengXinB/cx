package com.mjs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mjs.dao.AuthorityDao;
import com.mjs.dao.exception.DaoException;
import com.mjs.domain.Authority;

public class AuthorityDaoImpl extends HibernateDaoSupport implements
		AuthorityDao {

	@Override
	public void addAuthority(Authority authority) {
		try {
			this.getHibernateTemplate().save(authority);
		} catch (DataAccessException e) {
			throw new DaoException("AutorityDaoImpl Exception: addAuthority()");
		}
	}

	@Override
	public Authority findAuthorityById(String authorityId) {
		try {
			return (Authority) this.getHibernateTemplate().get(Authority.class,
					authorityId);
		} catch (DataAccessException e) {
			throw new DaoException(
					"AutorityDaoImpl Exception: findAuthorityById()");
		}

	}

	@Override
	public void updateAuthorityById(Authority authority) {
		try {
			this.getHibernateTemplate().update(authority);
		} catch (DataAccessException e) {
			throw new DaoException(
					"AutorityDaoImpl Exception: updateAuthorityById()");
		}

	}

	@Override
	public void deleteAuthorityByName(String authorityName) {
		try {
			Query query = this.getSession().createQuery(
					"delete from Authority a where a.a_name=:name");
			query.setString("name", authorityName);
			query.executeUpdate();

		} catch (DataAccessException e) {
			throw new DaoException(
					"AutorityDaoImpl Exception: deleteAuthorityByName()");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Authority> findAllAuthority() {
		try {
			return this.getSession().createQuery("from Authority").list();
		} catch (DataAccessException e) {
			throw new DaoException(
					"AutorityDaoImpl Exception: findAuthorityById()");
		}
	}

	@Override
	public Authority findAuthorityByName(String a) {
		try {
			return (Authority) (this.getSession().createQuery(
					"from Authority where a_name=:name").setString("name", a))
					.uniqueResult();
		} catch (DataAccessException e) {
			throw new DaoException(
					"AutorityDaoImpl Exception: findAuthorityById()");
		}
	}

}
