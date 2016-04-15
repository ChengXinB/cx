package com.mjs.domain;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;

import org.apache.struts2.ServletActionContext;

import com.mjs.service.PersonService;
import com.mjs.service.RoleService;
import com.mjs.utils.InvitationPage;
import com.mjs.utils.MD5Util;
import com.mjs.utils.PersonPage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Person extends ActionSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9193620227999489894L;
	private String p_id;
	private String p_username = "";
	private String p_password = "";
	private String p_rpassword = "";
	private Date p_birthday;
	private String p_rbirthday;
	private Date p_date;
	private String p_nick;
	private String p_sex;
	private int p_time;
	private File p_photo;
	private String p_photoFileName;
	private String p_photoContentType;
	private String p_path;
	private Set<Role> p_role = new HashSet<Role>();
	private Set<Invitation> p_invitation = new HashSet<Invitation>();

	public String getP_rbirthday() {
		return p_rbirthday;
	}

	public void setP_rbirthday(String p_rbirthday) {
		this.p_rbirthday = p_rbirthday;
	}

	public String getP_photoFileName() {
		return p_photoFileName;
	}

	public void setP_photoFileName(String p_photoFileName) {
		this.p_photoFileName = p_photoFileName;
	}

	public String getP_photoContentType() {
		return p_photoContentType;
	}

	public void setP_photoContentType(String p_photoContentType) {
		this.p_photoContentType = p_photoContentType;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_username() {
		return p_username;
	}

	public void setP_username(String p_username) {
		this.p_username = p_username;
	}

	public String getP_password() {
		return p_password;
	}

	public void setP_password(String p_password) {
		this.p_password = p_password;
	}

	public String getP_rpassword() {
		return p_rpassword;
	}

	public void setP_rpassword(String p_rpassword) {
		this.p_rpassword = p_rpassword;
	}

	public Date getP_birthday() {
		return p_birthday;
	}

	public void setP_birthday(Date p_birthday) {
		this.p_birthday = p_birthday;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	public String getP_nick() {
		return p_nick;
	}

	public void setP_nick(String p_nick) {
		this.p_nick = p_nick;
	}

	public String getP_sex() {
		return p_sex;
	}

	public void setP_sex(String p_sex) {
		this.p_sex = p_sex;
	}

	public int getP_time() {
		return p_time;
	}

	public void setP_time(int p_time) {
		this.p_time = p_time;
	}

	public File getP_photo() {
		return p_photo;
	}

	public void setP_photo(File p_photo) {
		this.p_photo = p_photo;
	}

	public String getP_path() {
		return p_path;
	}

	public void setP_path(String p_path) {
		this.p_path = p_path;
	}

	public Set<Role> getP_role() {
		return p_role;
	}

	public void setP_role(Set<Role> p_role) {
		this.p_role = p_role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Invitation> getP_invitation() {
		return p_invitation;
	}

	public void setP_invitation(Set<Invitation> p_invitation) {
		this.p_invitation = p_invitation;
	}

	public Map<String, String> errors = new HashMap<String, String>();

	@Override
	public String toString() {
		return "Person [p_id=" + p_id + ", p_username=" + p_username
				+ ", p_password=" + p_password + ", p_rpassword=" + p_rpassword
				+ ", p_rbirthday=" + p_rbirthday + ", p_date=" + p_date
				+ ", p_nick=" + p_nick + ", p_sex=" + p_sex + ", p_time="
				+ p_time + ", p_photoFileName=" + p_photoFileName
				+ ", p_photoContentType=" + p_photoContentType + ", p_path="
				+ p_path + "]";
	}

	/*********************************************************************************/
	// Action
	private PersonService personService = null;
	private RoleService roleService = null;

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public String login() {
		Person pp = null;
		pp = (Person) ServletActionContext.getContext().getSession()
				.get("managerPerson");
		if (pp != null) {
			return LOGIN;
		}
		Person p = personService.managerLogin(p_username, p_password);
		if (p != null) {
			ActionContext.getContext().getSession().put("managerPerson", p);
			return LOGIN;
		}
		ServletActionContext
				.getRequest()
				.setAttribute(
						//
						"message",
						"<script type='text/javascript'>alert('密码错误，或您没有权限访问！')</script>");
		// ServletActionContext.getPageContext().getSession().setAttribute(//
		// "message", ");
		return "loginError";
	}

	public String clientLogin() {

		Person pp = null;
		pp = (Person) ServletActionContext.getContext().getSession()
				.get("clientPerson");
		if (pp != null) {
			return "clientLogin";
		}
		Person p = personService.clientLogin(p_username, p_password);
		if (p != null) {
			ActionContext.getContext().getSession().put("clientPerson", p);
			return "clientLogin";
		}
		ServletActionContext.getRequest().setAttribute(
				//
				"message",
				"<script type='text/javascript'>alert('密码错误')</script>");
		// ServletActionContext.getPageContext().getSession().setAttribute(//
		// "message", ");
		return "clientLoginError";
	}

	public String listLimitPerson() {
		String pagenum = ServletActionContext.getRequest().getParameter(
				"pagenum");
		PersonPage page = personService.findLimitPerson(pagenum);
		ActionContext.getContext().getValueStack().set("page", page);
		ActionContext.getContext().getValueStack().push(page);

		return "listLimitPerson";
	}

	public String unlogin() {
		ServletActionContext.getRequest().getSession()
				.setAttribute("person", null);
		return "unlogin";
	}

	public String addPerson() {
		return "addPerson";
	}

	public void validateToAddPerson() {
		if (!p_username.matches("\\w{5,10}")) {
			addFieldError("p_username",
					"<span class='input-notification error png_bg'>请输入10~15位字母或数字</span>");
		}
		if (!p_password.matches("\\w{5,10}")) {
			addFieldError("p_password",
					"<span class='input-notification error png_bg'>请输入10~15位字母或数字</span>");
		} else {
			if (!p_password.equals(p_rpassword)) {
				addFieldError("p_password",
						"<span class='input-notification error png_bg'>两次密码需保持一致</span>");
			}
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			p_birthday = format.parse(p_rbirthday);
		} catch (Exception e) {
			addFieldError("p_birthday",
					"<span class='input-notification error png_bg'>请输入正确的日期格式</span>");
		}
		if (p_photoContentType != null) {
			if (!p_photoContentType.startsWith("image")) {
				addFieldError("p_photo",
						"<span class='input-notification error png_bg'>请添加图片格式的文件</span>");
			}
		}
	}

	public String toAddPerson() {
		boolean bool = personService.addPerson(this);
		if (!bool) {
			ServletActionContext
					.getRequest()
					.setAttribute(
							"message",
							"<div class='notification error png_bg'> <a href='#' class='close'><img src='../resources/images/icons/cross_grey_small.png' title='Close this notification' alt='close' /></a><div>用户名已存在</div></div>");
		} else {
			ServletActionContext
					.getRequest()
					.setAttribute(
							"message",
							"<div class='notification success png_bg'> <a href='#' class='close'><img src='../resources/images/icons/cross_grey_small.png' title='Close this notification' alt='close' /></a><div>保存成功</div></div>");
		}
		return "toAddPerson";
	}

	public String clientAddPerson() {

		errors.clear();
		if (!p_username.matches("\\w{5,10}")) {
			errors.put("p_username", "请输入5~10位字母或数字");
		}
		if (!p_password.matches("\\w{5,10}")) {
			errors.put("p_password", "请输入5~10位字母或数字");
		} else {
			if (!p_password.equals(p_rpassword)) {
				errors.put("p_rpassword", "两次密码需保持一致");
			}
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			p_birthday = format.parse(p_rbirthday);
		} catch (Exception e) {
			errors.put("p_birthday", "请输入正确的日期格式");
		}
		if (p_photoContentType != null) {
			if (!p_photoContentType.startsWith("image")) {
				errors.put("p_photo", "请添加图片格式的文件");
			}
		}
		if (!errors.isEmpty()) {
			try {
				ServletActionContext.getRequest()
						.setAttribute("errors", errors);
				ServletActionContext.getRequest().setAttribute("message",
						"<scrip type='text/javascript'>注册失败！</script>");
				ServletActionContext.getRequest().setAttribute("person", this);
				ServletActionContext
						.getRequest()
						.getRequestDispatcher("/client/regist.jsp")
						.forward(ServletActionContext.getRequest(),
								ServletActionContext.getResponse());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "clientError";
		}

		boolean bool = personService.addPerson(this);
		if (!bool) {
			ServletActionContext.getRequest().setAttribute("message",
					"<script type='text/javascript'>用户名已注册</script>");
		} else {
			ServletActionContext.getRequest().setAttribute("message",
					"<script type='text/javascript'>注册成功</script>");
		}
		return "clientAddPerson";
	}

	public String findPersonByNick() {

		List<Person> persons = personService.findPersonByNick(p_nick);
		ActionContext.getContext().getValueStack().set("persons", persons);
		ActionContext.getContext().getValueStack().push(persons);

		return "findPersonByNick";
	}

	public String findLimitInvitation() {

		String p_invita = ServletActionContext.getRequest().getParameter(
				"p_invita");

		String num = ServletActionContext.getRequest().getParameter("num");
		if (num == null || num.trim().equals("")) {
			num = "1";
		}
		if (p_invita == null || p_invita.trim().equals("")) {
			InvitationPage page1 = (InvitationPage) ServletActionContext
					.getRequest().getSession().getAttribute("InvitationPage");

			InvitationPage page2 = new InvitationPage(1, 1);
			ActionContext.getContext().getValueStack().set("page", page2);
			ActionContext.getContext().getValueStack().push(page2);

			if (page1 != null) {
				ActionContext.getContext().getValueStack().set("page", page1);
				ActionContext.getContext().getValueStack().push(page1);
			}

			return "findLimitInvitation";
		} else {
			try {
				this.setP_username(p_invita);
				InvitationPage page = personService.findLimitInvitation(num,
						this);
				ActionContext.getContext().getSession()
						.put("InvitationPage", page);
				ActionContext.getContext().getValueStack().set("page", page);
				ActionContext.getContext().getValueStack().push(page);
				return "findLimitInvitation";
			} catch (Exception e) {
				return "findLimitInvitation";
			}
		}
	}

	public String updateRole() {
		try {
			String[] role = ServletActionContext.getRequest()
					.getParameterValues("role");
			if (role != null && role.length > 0) {
				personService.updateRole(role, p_username);
			}
			if (p_username != null && !p_username.equals("")) {
				List<Role> roles = roleService.findAllRole();
				Person p = personService.findPersonByUsername(p_username);
				ServletActionContext.getRequest().setAttribute("person", p);
				ServletActionContext.getRequest().setAttribute("roles", roles);
			}
		} catch (Exception e) {
			return "updateRole";
		}
		return "updateRole";
	}

	public String clientUnLogin() {
		System.out.println("-------------------");
		ActionContext.getContext().getSession().put("clientPerson", null);
		System.out.println("-----------------");
		return "clientUnLogin";
	}

	public String showImage() {
		try {
			String fileName = ServletActionContext.getRequest().getParameter(
					"personUsername");
			Person p = personService.findPersonByUsername(fileName);
			String storePath = ServletActionContext.getServletContext()
					.getRealPath(
							"/WEB-INF/files" + "\\" + p.getP_path() + "\\"
									+ p.p_photoFileName);
			File file = new File(storePath);
			try {
				OutputStream os = ServletActionContext.getResponse()
						.getOutputStream();
				ImageIO.write(ImageIO.read(file), "jpg", os);

			} catch (IOException e) {
				return null;
			}
		} catch (Exception e1) {
			return null;
		}
		return null;
	}

	public String showPersonDetail() {

		String personUsername = ServletActionContext.getRequest().getParameter(
				"personUsername");
		Person person = personService.findPersonByUsername(personUsername);
		if (person != null) {
			if (ServletActionContext.getRequest().getSession()
					.getAttribute("clientPerson") != null) {
				if (!person.getP_username().equals(
						((Person) ServletActionContext.getRequest()
								.getSession().getAttribute("clientPerson"))
								.getP_username())) {
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					person.setP_rbirthday(format.format(person.getP_birthday()));
					ActionContext.getContext().getValueStack()
							.set("person", person);
					ActionContext.getContext().getValueStack().push(person);
					return "showClientDetail";
				}
			}
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			person.setP_rbirthday(format.format(person.getP_birthday()));
			ActionContext.getContext().getValueStack().set("person", person);
			ActionContext.getContext().getValueStack().push(person);
			return "showClientDetail";
		}
		return "clientAddPerson";
	}

	public String clientUpdate() {
		Person p = personService.findPersonByUsername(p_username);
		if (p_nick != null && !p_nick.trim().equals("")) {
			p.setP_nick(p_nick);
		}
		if (p_sex != null && !p_sex.trim().equals("")) {
			p.setP_sex(p_sex);
		}
		if (p_password != null && !p_password.trim().equals("")) {
			if (!p_password.matches("\\w{5,15}")) {
				errors.put("p_password", "请输入5~15位字母或数字");
			} else {
				if (!p_password.equals(p_rpassword)) {
					errors.put("p_rpassword", "两次密码需保持一致");
				} else {
					p.setP_password(MD5Util.encode(p_password));
				}
			}
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (!p_rbirthday.equals(format.format(p.getP_birthday()))) {
			try {
				p_birthday = format.parse(p_rbirthday);
				p.setP_birthday(p_birthday);
			} catch (Exception e) {
				errors.put("p_birthday", "请输入正确的日期格式");
			}
		}
		if (!errors.isEmpty()) {
			try {
				ServletActionContext.getRequest()
						.setAttribute("errors", errors);
				ServletActionContext.getRequest().setAttribute("message",
						"<scrip type='text/javascript'>修改失败！</script>");
				ServletActionContext.getRequest().setAttribute("person", p);
				ServletActionContext
						.getRequest()
						.getRequestDispatcher("/client/showPersonDetail.jsp")
						.forward(ServletActionContext.getRequest(),
								ServletActionContext.getResponse());
			} catch (Exception e) {
				return "clientUpdate";
			}
		}
		personService.updatePerson(p);
		return "clientUpdate";
	}

	public String showMeInvitation() {

		Person person = (Person) ServletActionContext.getRequest().getSession()
				.getAttribute("clientPerson");

		String pagenum = ServletActionContext.getRequest().getParameter(
				"pagenum");
		InvitationPage page = personService
				.findLimitInvitation(pagenum, person);
		ActionContext.getContext().getValueStack().set("page", page);
		ActionContext.getContext().getValueStack().push(page);

		return "showMeInvitation";
	}
}
