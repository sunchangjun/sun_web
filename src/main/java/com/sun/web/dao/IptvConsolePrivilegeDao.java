package com.sun.web.dao;


import com.sun.web.domain.IptvConsolePrivilege;
import java.util.List;

public interface IptvConsolePrivilegeDao {
    /**
     * 查询所有的一级菜单
     * @return
     */
	public List<IptvConsolePrivilege> findTopPrivileges();
    /**
     * 查询角色权限
     * @param roleId
     * @return
     */
	public List<IptvConsolePrivilege> findPrivilegesByRoleId(Integer roleId);

}
