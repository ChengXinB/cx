package com.mjs.dao;

import java.util.List;

import com.mjs.domain.Invitation;
import com.mjs.domain.InvitationQuery;
import com.mjs.domain.LeaveQuery;

public interface InvitationDao {
	public void addInvitation(Invitation invitation);
	public void deleteInvitationById(String invitationId);
	public void deleteInvitationByName(String invitationName);
	public Invitation findInvitationById(String invitationId);
	public List<Invitation> findAllInvitation();
	public List<Invitation> findInvitationByName(String invitationName);
	public LeaveQuery findLimitleave(int firstResult, int maxResults, Invitation invitation);
	public InvitationQuery findLimitInvitation(int firstResult, int maxResults);
	public boolean updateInvitation(Invitation invitation);
}	
