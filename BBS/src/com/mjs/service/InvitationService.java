package com.mjs.service;

import java.util.List;

import com.mjs.domain.Invitation;
import com.mjs.domain.Person;
import com.mjs.utils.InvitationPage;

public interface InvitationService {

	List<Invitation> findAllInvitation();

	List<Invitation> findInvitationByName(String i_name);

	void deleteInvitationById(String invitationId);

	Invitation findInvitationById(String invitationId);

	String addInvitation(Invitation invitation ,Person person);

	Invitation addLeave(String l_title, String invit, Person person);

	InvitationPage listLimitInvitation(String pagenum);

	void updateInvitation(Invitation invitation);

}
