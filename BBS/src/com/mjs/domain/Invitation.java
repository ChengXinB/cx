package com.mjs.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.mjs.service.InvitationService;
import com.mjs.utils.InvitationPage;
import com.mjs.utils.PersonPage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Invitation extends ActionSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 810069890752674559L;
	private String i_id;
	private String i_name;
	private String i_title;
	private Date i_date;
	private String i_stime;
	private String i_rtime;
	private String i_last;
	private Person i_person;
	private Set<Leave> i_leave = new HashSet<Leave>();

	public String getI_title() {
		return i_title;
	}

	public void setI_title(String i_title) {
		this.i_title = i_title;
	}

	public String getI_id() {
		return i_id;
	}

	public void setI_id(String i_id) {
		this.i_id = i_id;
	}

	public String getI_name() {
		return i_name;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
	}

	public Date getI_date() {
		return i_date;
	}

	public void setI_date(Date i_date) {
		this.i_date = i_date;
	}

	public String getI_last() {
		return i_last;
	}

	public void setI_last(String i_last) {
		this.i_last = i_last;
	}

	public Person getI_person() {
		return i_person;
	}

	public void setI_person(Person i_person) {
		this.i_person = i_person;
	}

	public String getI_stime() {
		return i_stime;
	}

	public Set<Leave> getI_leave() {
		return i_leave;
	}

	public void setI_leave(Set<Leave> i_leave) {
		this.i_leave = i_leave;
	}

	public void setI_stime(String i_stime) {
		this.i_stime = i_stime;
	}

	public String getI_rtime() {
		return i_rtime;
	}

	public void setI_rtime(String i_rtime) {
		this.i_rtime = i_rtime;
	}

	@Override
	public String toString() {
		return "Invitation [i_id=" + i_id + ", i_name=" + i_name + ", i_date="
				+ i_date + ", i_stime=" + i_stime + ", i_rtime=" + i_rtime
				+ ", i_last=" + i_last + ", i_leave=" + i_leave + "]";
	}

	/**********************************************************************/
	private InvitationService invitationService = null;

	public InvitationService getInvitationService() {
		return invitationService;
	}

	public void setInvitationService(InvitationService invitationService) {
		this.invitationService = invitationService;
	}

	public String findAllInvitation() {

		List<Invitation> invitations = invitationService.findAllInvitation();
		ValueStack v = ActionContext.getContext().getValueStack();
		v.set("invitations", invitations);
		v.push(invitations);
		return "findAllInvitation";
	}

	public String findInvitationByName() {

		if (i_name == null || i_name.trim().equals("")) {
			List<Invitation> invitation = (List<Invitation>) ServletActionContext
					.getRequest().getSession().getAttribute("invitation");

			if (invitation != null) {
				ActionContext.getContext().getValueStack()
						.set("invitation", invitation);
				ActionContext.getContext().getValueStack().push(invitation);
			}

			return "findInvitationByName";
		} else {
			List<Invitation> invitation = invitationService
					.findInvitationByName(this.i_name);
			ActionContext.getContext().getSession()
					.put("invitation", invitation);
			ActionContext.getContext().getValueStack()
					.set("invitation", invitation);
			ActionContext.getContext().getValueStack().push(invitation);
			return "findInvitationByName";
		}
	}

	public String delInvitationById() {
		String invitationId = ServletActionContext.getRequest().getParameter(
				"invitationId");
		ServletActionContext.getRequest().getSession()
				.setAttribute("invitation", null);
		invitationService.deleteInvitationById(invitationId);
		return "delInvitationById";
	}

	public String deleteInvitation() {
		String invitationId = ServletActionContext.getRequest().getParameter(
				"invitationId");
		InvitationPage ipage = (InvitationPage) ServletActionContext
				.getRequest().getSession().getAttribute("InvitationPage");
		ServletActionContext.getRequest().getSession().removeAttribute("InvitationPage");
		List<Invitation> is = ipage.getRecords();
		System.out.println(is.size());
		is.clear();
		System.out.println(is.size());
		ipage.setRecords(is);
		ActionContext.getContext().getSession().put("InvitationPage", ipage);
		ServletActionContext.getRequest().getSession().setAttribute("InvitationPage", ipage);
		invitationService.deleteInvitationById(invitationId);

		return "deleteInvitation";
	}
	public String addInvitation(){
		Person person = (Person) ActionContext.getContext().getSession().get("clientPerson");
		String inId = invitationService.addInvitation(this, person);
		if(inId!=null){
			Invitation invitation = invitationService.findInvitationById(inId);
			ActionContext.getContext().getValueStack().set("invitation", invitation);
			ActionContext.getContext().getValueStack().push(invitation);
			return "addInvitation";
		}
		return "addInvitationError";
		
	}
	public String addLeave(){
		String l_title = ServletActionContext.getRequest().getParameter("editorValue");
		String substring = l_title.substring(3,l_title.length()-4);
		String invit = ServletActionContext.getRequest().getParameter("invit");
		Person person = (Person) ActionContext.getContext().getSession().get("clientPerson");
		Invitation invitation = invitationService.addLeave(substring, invit, person);
		invitation.setI_rtime(String.valueOf(Integer.valueOf(invitation.getI_rtime())+1));
		invitationService.updateInvitation(invitation);
		ActionContext.getContext().getValueStack().set("invitation", invitation);
		ActionContext.getContext().getValueStack().push(invitation);
		return "addLeave";
	}
	public String listAllInvitation(){
		
		String pagenum = ServletActionContext.getRequest().getParameter(
				"pagenum");
		InvitationPage page = invitationService.listLimitInvitation(pagenum);
		ActionContext.getContext().getValueStack().set("page", page);
		ActionContext.getContext().getValueStack().push(page);
		
		return "listAllInvitation";
	}
	public String findInvitation(){
			String  inId = ServletActionContext.getRequest().getParameter("inId");
			Invitation invitation = invitationService.findInvitationById(inId);
			invitation.setI_stime(String.valueOf(Integer.valueOf(invitation.getI_stime())+1));
			invitationService.updateInvitation(invitation);
			ActionContext.getContext().getValueStack().set("invitation", invitation);
			ActionContext.getContext().getValueStack().push(invitation);
			
		return "addInvitation";
		
	}
	public String clientDelInvitation(){
		
		String id = ServletActionContext.getRequest().getParameter("invitationId");
		invitationService.deleteInvitationById(id);
		return "clientDelInvitation";
	}
}
