package com.mjs.domain;

import java.io.Serializable;
import java.util.Date;

import com.mjs.service.LeaveService;
import com.opensymphony.xwork2.ActionSupport;

public class Leave extends ActionSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7248799726178555082L;
	private String l_id;
	private String l_content;
	private Date l_date;
	private Invitation l_invitation;
	private Person l_person;

	public String getL_id() {
		return l_id;
	}

	public void setL_id(String l_id) {
		this.l_id = l_id;
	}

	public String getL_content() {
		return l_content;
	}

	public void setL_content(String l_content) {
		this.l_content = l_content;
	}

	public Date getL_date() {
		return l_date;
	}

	public void setL_date(Date l_date) {
		this.l_date = l_date;
	}

	public Invitation getL_invitation() {
		return l_invitation;
	}

	public void setL_invitation(Invitation l_invitation) {
		this.l_invitation = l_invitation;
	}

	public Person getL_person() {
		return l_person;
	}

	public void setL_person(Person l_person) {
		this.l_person = l_person;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Leave [l_id=" + l_id + ", l_content=" + l_content + ", l_date="
				+ l_date + "]";
	}

	/***********************************************************************************/
	private LeaveService leaveService = null;

	public LeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}

}
