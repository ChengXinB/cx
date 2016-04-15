package com.mjs.service.impl;

import java.util.List;

import com.mjs.dao.AuthorityDao;
import com.mjs.dao.RoleDao;
import com.mjs.domain.Role;
import com.mjs.service.RoleService;

public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao = null;
	private AuthorityDao authorityDao = null;
	
	
	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public Role findRoleByName(String roleName) {
		
		return roleDao.findRoleByName(roleName);
	}

	@Override
	public List<Role> findAllRole() {
		
		List<Role> roles = roleDao.findAllRole();
		return roles;
	}

	@Override
	public void updateAuthority(String[] auth, Role rol) {
		rol.getR_authority().clear();
		for(String a : auth){
			rol.getR_authority().add(authorityDao.findAuthorityByName(a));
		}
		roleDao.updateRoleById(rol);
	}
	
}
