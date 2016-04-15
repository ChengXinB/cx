package com.mjs.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mjs.dao.PersonDao;
import com.mjs.dao.exception.DaoException;
import com.mjs.dao.exception.ExristException;
import com.mjs.domain.Authority;
import com.mjs.domain.InvitationQuery;
import com.mjs.domain.Person;
import com.mjs.domain.PersonQuery;
import com.mjs.domain.Role;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

	@Override
	public Person findPersonById(String personId) {
		try {
			return (Person) this.getHibernateTemplate().get(Person.class,
					personId);
		} catch (Exception e) {
			throw new DaoException("PersonDaoImpl Exception : findPersonById");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAllPerson() {
		try {
			return this.getSession().createQuery("from Person").list();
		} catch (Exception e) {
			throw new DaoException("PersonDaoImpl Exception : findAllPerson()");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public PersonQuery findLimitPerson(int firstResult, int maxResults) {
		try {
			PersonQuery qQuery = new PersonQuery();
			qQuery.setList(this.getSession().createQuery("from Person")
					//
					.setFirstResult(firstResult).setMaxResults(maxResults)
					.list());
			qQuery.setCount(((Long) this.getSession()
					.createQuery("select count(*) from Person").uniqueResult())
					.intValue());
			return qQuery;
		} catch (Exception e) {
			throw new DaoException(
					"PersonDaoImpl Exception : findLimitPerson()");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public InvitationQuery findLimitInvitation(int firstResult, int maxResults,
			Person person) {
		try {
			Query qq = this.getSession().createQuery("from Person p where p.p_username=:username");
			qq.setString("username", person.getP_username());
			Query query = this.getSession().createQuery(
					"from Invitation i where i.i_person=:personId");
			if(qq.uniqueResult()==null){
				return new InvitationQuery();
			}
			query.setString("personId", ((Person)qq.uniqueResult()).getP_id());
			InvitationQuery iQuery = new InvitationQuery();
			iQuery.setList(//
			query.setFirstResult(firstResult)//
					.setMaxResults(maxResults)//
					.list()//
			);
			Query q = this
					.getSession()
					.createQuery(//
							"select count(*) from Invitation i where i.i_person=:personId");
			q.setString("personId", person.getP_id());
			iQuery.setCount(((Long) q.uniqueResult()).intValue());
			return iQuery;
		} catch (Exception e) {
			throw new DaoException(
					"PersonDaoImpl Exception : findLimitInvitation()");
		}
	}

	@Override
	public Person findPerson(String username, String password) {
		try {
			Query query = this.getSession().createQuery(//
							"from Person p where p.p_username=:username and p.p_password=:password");
			query.setString("username", username).setString("password",
					password);
			return (Person) query.uniqueResult();
		} catch (Exception e) {
			throw new DaoException("PersonDaoImpl Exception : findPerson()");
		}

	}

	@Override
	public void addPerson(Person person) throws ExristException {
				this.getHibernateTemplate().save(person);
	}

	@Override
	public void updatePerson(Person person) {
		try {
			this.getSession().update(person);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("PersonDaoImpl Exception : updatePerson()");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findPersonByNick(String personNick) {
		try {
			Query query = this
					.getSession()
					.createQuery(//
							"from Person p where p.p_nick=:nick");
			query.setString("nick", personNick);
			return query.list();
		} catch (Exception e) {
			throw new DaoException("PersonDaoImpl Exception : findPersonByNick()");
		}
	}

	@Override
	public Person findPersonByUsrename(String p_username) {
		try {
			Query query = this
					.getSession()
					.createQuery(//
							"from Person p where p.p_username=:username");
			query.setString("username", p_username);
			return (Person) query.uniqueResult();
		} catch (Exception e) {
			throw new DaoException("PersonDaoImpl Exception : findPersonByNick()");
		}
	}

	@Override
	public boolean permission(String string, Person person) {
		Person p = this.findPersonByUsrename(person.getP_username());
		Set<Role> roles = p.getP_role();
		Set<Authority> authority = new HashSet<Authority>();
		
		for(Role r : roles){
			Set<Authority> authoritys = r.getR_authority();
			for(Authority a : authoritys){
				authority.add(a);
			}
		}
		
		for(Authority aa : authority){
			if(aa.getA_name().equals(string)){
				this.getSession().clear();
				return true;
			}
		}
		this.getSession().clear();
		return false;
	}

}
