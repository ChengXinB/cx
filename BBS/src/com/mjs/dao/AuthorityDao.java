package com.mjs.dao;

import java.util.List;

import com.mjs.domain.Authority;

public interface AuthorityDao {
	/**
	 * 添加权限
	 * @param authority
	 */
	public void addAuthority(Authority authority);
	/**
	 * 根据权限ID查找权限
	 * @param authorityId
	 * @return
	 */
	public Authority findAuthorityById(String authorityId);
	/**
	 * 根据ID更新权限
	 * @param authorityId
	 */
	public void updateAuthorityById(Authority authority);
	/**
	 * 根据ID删除权限
	 * @param authorityName
	 */
	public void deleteAuthorityByName(String authorityName);
	public List<Authority> findAllAuthority();
	public Authority findAuthorityByName(String a);

}
