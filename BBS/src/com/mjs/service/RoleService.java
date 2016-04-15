package com.mjs.service;

import java.util.List;

import com.mjs.domain.Role;

public interface RoleService {
	public Role findRoleByName(String roleName);

	public List<Role> findAllRole();

	public void updateAuthority(String[] auth, Role rol);
}
