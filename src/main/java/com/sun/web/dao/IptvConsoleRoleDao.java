package com.sun.web.dao;

import com.sun.web.domain.IptvConsoleRole;

import java.util.List;

public interface IptvConsoleRoleDao {

	public List<IptvConsoleRole> findAllRoles();

	public void saveRole(IptvConsoleRole role);

}
