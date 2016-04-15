package com.mjs.service.impl;

import java.util.List;

import com.mjs.dao.AuthorityDao;
import com.mjs.domain.Authority;
import com.mjs.service.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService {
	private AuthorityDao authorityDao = null;

	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	@Override
	public List<Authority> findAllAuthority() {
		return authorityDao.findAllAuthority();
	}
	
}
