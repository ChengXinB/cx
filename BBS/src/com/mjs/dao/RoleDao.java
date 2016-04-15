package com.mjs.dao;

import java.util.List;

import com.mjs.domain.Role;

public interface RoleDao {
	public void addRole(Role role);
	public void updateRoleById(Role role);
	public void deleteRoleById(String roleId);
	public Role findRoleByName(String roleName);
	public List<Role> findAllRole();

}
