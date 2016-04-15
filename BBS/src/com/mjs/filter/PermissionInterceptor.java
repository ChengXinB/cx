package com.mjs.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.mjs.domain.Person;
import com.mjs.service.PersonService;
import com.opensymphony.xwork2.ActionInvocation;

public class PermissionInterceptor implements
		com.opensymphony.xwork2.interceptor.Interceptor {
	private PersonService personService = null;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String uri = "";
		uri = request.getRequestURI();
		if (uri.contains("invitation_addInvitation")
				|| uri.contains("invitation_clientDelInvitation")
				|| uri.contains("invitation_addLeave")) {

			if (uri.contains("invitation_addInvitation")) {
				//
				HttpSession session = ServletActionContext.getRequest()
						.getSession();
				Person person = (Person) session.getAttribute("clientPerson");
				if (person == null) {
					request.getRequestDispatcher("/client/login.jsp").forward(
							ServletActionContext.getRequest(),
							ServletActionContext.getResponse());
				}

				boolean addInvitation = personService.permission("发帖", person);
				if (!addInvitation) {
					request.setAttribute("message",
							"<script type='text/javascript'>您没有发帖权限！</script>");
					// request.getRequestDispatcher(
					// "/client/index.jsp").forward(
					// ServletActionContext.getRequest(),
					// ServletActionContext.getResponse());
					return "permission";
				}

			}
			if (uri.contains("invitation_addLeave")) {
				HttpSession session = ServletActionContext.getRequest()
						.getSession();
				Person person = (Person) session.getAttribute("clientPerson");
				if (person == null) {
					request.getRequestDispatcher("/client/login.jsp").forward(
							ServletActionContext.getRequest(),
							ServletActionContext.getResponse());
				}

				boolean addLeave = personService.permission("留言", person);
				if (!addLeave) {
					request.setAttribute("message",
							"<script type='text/javascript'>您没有留言权限！</script>");
					// request.getRequestDispatcher(
					// "/client/index.jsp").forward(
					// ServletActionContext.getRequest(),
					// ServletActionContext.getResponse());
					return "permission";
				}
			}
			if (uri.contains("invitation_clientDelInvitation")) {
				System.out.println("进入权限管理");
				HttpSession session = ServletActionContext.getRequest()
						.getSession();
				Person person = (Person) session.getAttribute("clientPerson");
				if (person == null) {
					request.getRequestDispatcher("/client/login.jsp").forward(
							ServletActionContext.getRequest(),
							ServletActionContext.getResponse());
				}

				boolean clientDelInvitation = personService.permission("删帖",
						person);
				System.out
						.println("clientDelInvitation=" + clientDelInvitation);
				if (!clientDelInvitation) {
					System.out.println("b不能删除。。。");
					request.setAttribute("message",
							"<script type='text/javascript'>您没有删帖权限！</script>");
					// request.getRequestDispatcher(
					// "/client/index.jsp").forward(
					// ServletActionContext.getRequest(),
					// ServletActionContext.getResponse());
					return "permission";
				}
			}

		}
		return invocation.invoke();
	}
}
