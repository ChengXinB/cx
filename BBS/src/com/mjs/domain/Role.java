package com.mjs.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.mjs.service.AuthorityService;
import com.mjs.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Role extends ActionSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1212705667833979130L;
	private String r_id;
	private String r_name;
	private Set<Authority> r_authority = new HashSet<Authority>();

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public Set<Authority> getR_authority() {
		return r_authority;
	}

	public void setR_authority(Set<Authority> r_authority) {
		this.r_authority = r_authority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Role [r_id=" + r_id + ", r_name=" + r_name + ", r_authority="
				+ r_authority + "]";
	}

	/******************************************************************/
	private RoleService roleService = null;
	private AuthorityService authorityService = null;
	

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public String findAllRole(){
		
		List<Role> roles = roleService.findAllRole();
		ValueStack v = ActionContext.getContext().getValueStack();
		v.set("roles", roles);
		v.push(roles);
		
		return "findAllRole";
	}
	public String addRole(){
		
		return "addRole";
	}
	public String updateRole(){
		
		List<Role> roles = roleService.findAllRole();
		List<Authority> authoritys = authorityService.findAllAuthority();
		ServletActionContext.getRequest().setAttribute("authoritys", authoritys);
		ServletActionContext.getRequest().setAttribute("roles", roles);
		
		return "updateRole";
	}
	public String upAuthority(){
		String[] auth = ServletActionContext.getRequest().getParameterValues("auth");
		String rol = ServletActionContext.getRequest().getParameter("rol");
		if (auth!=null) {
			if (auth.length > 0) {
				roleService.updateAuthority(auth,
						roleService.findRoleByName(rol));
			}
		}
		return "upAuthority";
	}
}
