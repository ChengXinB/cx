package com.mjs.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.mjs.dao.PersonDao;
import com.mjs.dao.RoleDao;
import com.mjs.dao.impl.PersonDaoImpl;
import com.mjs.domain.Authority;
import com.mjs.domain.InvitationQuery;
import com.mjs.domain.Person;
import com.mjs.domain.PersonQuery;
import com.mjs.domain.Role;
import com.mjs.service.PersonService;
import com.mjs.utils.InvitationPage;
import com.mjs.utils.MD5Util;
import com.mjs.utils.PersonPage;
import com.mjs.utils.WebUtil;

public class PersonServiceImpl implements PersonService {
	private PersonDao personDao = null;
	private RoleDao roleDao = null;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public Person managerLogin(String username, String password) {
		try {
			password = MD5Util.encode(password);
			Person p = personDao.findPerson(username, password);
			if (p!=null) {
				for (Role r : p.getP_role()) {
					if (r.getR_name().equals("管理员")) {
						return p;
					}
				}
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public PersonPage findLimitPerson(String pagenum) {
		
		int num = 1;
		if(pagenum!=null && !pagenum.trim().equals("")){
				num = Integer.parseInt(pagenum);
		}
		PersonQuery pQuery = personDao.findLimitPerson((num-1)*10, 10);
		PersonPage page = new PersonPage(num, pQuery.getCount());
		page.setRecords(pQuery.getList());
		return page;
	}

	@Override
	public boolean addPerson(Person person) {
		try {
			person.getP_role().add(roleDao.findRoleByName("删帖员"));
			person.getP_role().add(roleDao.findRoleByName("发帖员"));
			person.getP_role().add(roleDao.findRoleByName("留言员"));
			person.setP_date(new Date());
			person.setP_password(MD5Util.encode(person.getP_password()));
			String storePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files");
			String fileName = UUID.randomUUID().toString()+"_"+person.getP_photoFileName();
			person.setP_photoFileName(fileName);
			String realStorePath = WebUtil.makeDirs(storePath, fileName);
			person.setP_path(realStorePath);
			InputStream in = new FileInputStream(person.getP_photo());
			OutputStream out = new FileOutputStream(storePath+"\\"+realStorePath+"\\"+fileName);
			int len = 0;
			byte[] by = new byte[1024];
			while((len=in.read(by))>0){
				out.write(by, 0, len);
			}
			personDao.addPerson(person);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Person> findPersonByNick(String p_nick) {
		return personDao.findPersonByNick(p_nick);
	}

	@Override
	public InvitationPage findLimitInvitation(String num, Person person) {
		int n = 1;
		if(num!=null && !num.trim().equals("")){
				n = Integer.parseInt(num);
		}
		InvitationQuery iQuery = personDao.findLimitInvitation((n-1)*10, 10, person);
		InvitationPage page = new InvitationPage(n, iQuery.getCount());
		page.setRecords(iQuery.getList());
		return page;
	}

	@Override
	public void updateRole(String[] role, String p_username) {
		Person p = personDao.findPersonByUsrename(p_username);
		System.out.println(p_username);
		System.out.println(p);
		System.out.println(Arrays.toString(role));
		p.getP_role().clear();
		for(String s : role){
			p.getP_role().add(roleDao.findRoleByName(s));
		}
		personDao.updatePerson(p);
	}

	@Override
	public Person findPersonByUsername(String p_username) {
		return personDao.findPersonByUsrename(p_username);
	}

	@Override
	public Person clientLogin(String p_username, String p_password) {
		try {
			p_password = MD5Util.encode(p_password);
			Person p = personDao.findPerson(p_username, p_password);
			return p;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void updatePerson(Person p) {
		personDao.updatePerson(p);
	}

	@Override
	public boolean permission(String string, Person person) {
		return personDao.permission(string, person);
	}
}
