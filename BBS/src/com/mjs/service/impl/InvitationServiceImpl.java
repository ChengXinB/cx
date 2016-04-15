package com.mjs.service.impl;

import java.util.Date;
import java.util.List;

import com.mjs.dao.InvitationDao;
import com.mjs.dao.LeaveDao;
import com.mjs.dao.PersonDao;
import com.mjs.domain.Invitation;
import com.mjs.domain.InvitationQuery;
import com.mjs.domain.Leave;
import com.mjs.domain.Person;
import com.mjs.service.InvitationService;
import com.mjs.utils.InvitationPage;

public class InvitationServiceImpl implements InvitationService {
	private InvitationDao invitationDao = null;
	private LeaveDao leaveDao = null;
	private PersonDao personDao = null;
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public LeaveDao getLeaveDao() {
		return leaveDao;
	}

	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

	public InvitationDao getInvitationDao() {
		return invitationDao;
	}

	public void setInvitationDao(InvitationDao invitationDao) {
		this.invitationDao = invitationDao;
	}

	@Override
	public List<Invitation> findAllInvitation() {
		return invitationDao.findAllInvitation();
	}

	@Override
	public List<Invitation> findInvitationByName(String i_name) {
		return invitationDao.findInvitationByName(i_name);
	}

	@Override
	public void deleteInvitationById(String invitationId) {
		
		invitationDao.deleteInvitationById(invitationId);
		
	}

	@Override
	public Invitation findInvitationById(String invitationId) {
		return invitationDao.findInvitationById(invitationId);
	}

	@Override
	public String addInvitation(Invitation invitation, Person person) {
		try {
			invitation.setI_date(new Date());
			invitation.setI_rtime("0");
			invitation.setI_stime("0");
			person.setP_time(person.getP_time()+1);
			invitation.setI_person(person);
			personDao.updatePerson(person);
			invitationDao.addInvitation(invitation);
			
		} catch (Exception e) {
			return null;
		}
		return invitation.getI_id();
	}

	@Override
	public Invitation addLeave(String l_title, String invit, Person person) {
		Leave leave = new Leave();
		leave.setL_content(l_title);
		leave.setL_date(new Date());
		Invitation ii = this.findInvitationById(invit);
		leave.setL_invitation(ii);
		leave.setL_person(person);
		leaveDao.addLeave(leave);
		return ii;
	}

	@Override
	public InvitationPage listLimitInvitation(String pagenum) {
		int num = 1;
		if(pagenum!=null && !pagenum.trim().equals("")){
				num = Integer.parseInt(pagenum);
		}
		InvitationQuery pQuery = invitationDao.findLimitInvitation((num-1)*10, 10);
		InvitationPage page = new InvitationPage(num, pQuery.getCount());
		page.setRecords(pQuery.getList());
		return page;
	}

	@Override
	public void updateInvitation(Invitation invitation) {
		invitationDao.updateInvitation(invitation);
		
	}

}
