package com.mjs.service;

import java.util.List;

import com.mjs.domain.Person;
import com.mjs.utils.InvitationPage;
import com.mjs.utils.PersonPage;

public interface PersonService {
	public Person managerLogin(String username, String password);

	public PersonPage findLimitPerson(String pagenum);

	public boolean addPerson(Person person);

	public List<Person> findPersonByNick(String p_nick);

	public InvitationPage findLimitInvitation(String num, Person person);

	public void updateRole(String[] role, String p_username);

	public Person findPersonByUsername(String p_username);

	public Person clientLogin(String p_username, String p_password);

	public void updatePerson(Person p);

	public boolean permission(String string, Person person);
}
