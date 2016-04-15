package com.mjs.domain;

import java.io.Serializable;
import java.util.List;

import com.mjs.service.AuthorityService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Authority extends ActionSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9070917097459518559L;
	private String a_id;
	private String a_name;
	private String a_url;

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_url() {
		return a_url;
	}

	public void setA_url(String a_url) {
		this.a_url = a_url;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a_id == null) ? 0 : a_id.hashCode());
		result = prime * result + ((a_name == null) ? 0 : a_name.hashCode());
		result = prime * result + ((a_url == null) ? 0 : a_url.hashCode());
		result = prime
				* result
				+ ((authorityService == null) ? 0 : authorityService.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authority other = (Authority) obj;
		if (a_id == null) {
			if (other.a_id != null)
				return false;
		} else if (!a_id.equals(other.a_id))
			return false;
		if (a_name == null) {
			if (other.a_name != null)
				return false;
		} else if (!a_name.equals(other.a_name))
			return false;
		if (a_url == null) {
			if (other.a_url != null)
				return false;
		} else if (!a_url.equals(other.a_url))
			return false;
		if (authorityService == null) {
			if (other.authorityService != null)
				return false;
		} else if (!authorityService.equals(other.authorityService))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Authority [a_id=" + a_id + ", a_name=" + a_name + ", a_url="
				+ a_url + "]";
	}

	/*************************************************************************/
	private AuthorityService authorityService = null;

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	public String findAllAuthority(){
		
		List<Authority> authoritys = authorityService.findAllAuthority();
		ValueStack v = ActionContext.getContext().getValueStack();
		v.set("authoritys", authoritys);
		v.push(authoritys);
		
		return "findAllAuthority";
	}
}
