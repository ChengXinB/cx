package com.mjs.dao;

import java.util.List;

import com.mjs.dao.exception.ExristException;
import com.mjs.domain.InvitationQuery;
import com.mjs.domain.Person;
import com.mjs.domain.PersonQuery;

public interface PersonDao {
	public Person findPersonById(String personId);
	public List<Person> findAllPerson();
	public PersonQuery findLimitPerson(int firstResult, int maxResults);
	public InvitationQuery findLimitInvitation(int firstResult, int maxResults, Person person);
	public Person findPerson(String username, String password);
	public void addPerson (Person person) throws ExristException;
	public void updatePerson(Person person);
	public List<Person> findPersonByNick(String personNick);
	public Person findPersonByUsrename(String p_username);
	public boolean permission(String string, Person person);
}
