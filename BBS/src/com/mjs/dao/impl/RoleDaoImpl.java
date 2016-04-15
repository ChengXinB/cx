package com.mjs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mjs.dao.RoleDao;
import com.mjs.dao.exception.DaoException;
import com.mjs.domain.Role;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

	@Override
	public void addRole(Role role) {
		try {
			this.getHibernateTemplate().save(role);
		} catch (Exception e) {
			throw new DaoException("RoleDaoImpl Exception : addRole()");
		}
	}

	@Override
	public void updateRoleById(Role role) {
		try {
			this.getHibernateTemplate().update(role);
		} catch (Exception e) {
			throw new DaoException("RoleDaoImpl Exception : updateRoleById()");
		}
	}

	@Override
	public void deleteRoleById(String roleId) {
		try {
//			Query query = this.getSession().createQuery("delete from Role r where r.r_id=:id");
//			query.setString("id", roleId);
//			query.executeUpdate();
			Role r = (Role) this.getHibernateTemplate().get(Role.class, roleId);
			 this.getHibernateTemplate().delete(r);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("RoleDaoImpl Exception : deleteRoleById()");
		}
	}

	@Override
	public Role findRoleByName(String roleName) {
		try {
			Query query = this.getSession().createQuery("from Role r where r.r_name=:name");
			query.setString("name", roleName);
//			Role r = ;
//			r.getR_authority().size();
			return (Role) query.uniqueResult();
		} catch (Exception e) {
			throw new DaoException("RoleDaoImpl Exception : findRoleByName()");
		}
		
	}

	@Override
	public List<Role> findAllRole() {
		try {
			@SuppressWarnings("unchecked")
			List<Role> roles = this.getSession().createQuery("from Role r").list();
			return roles;
		} catch (Exception e) {
			throw new DaoException("RoleDaoImpl Exception : findAllRole()");
		}
		
	}

}
