package com.sun.web.dao;

import com.sun.web.domain.IptvConsoleUser;
import org.apache.ibatis.annotations.Param;

public interface IptvConsoleUserDao {
    /**
     * 根据用户名查找用户信息
     * @param userName
     * @return
     */
	public IptvConsoleUser findUserByUserName(String userName);
    /**
     * 新增用户
     * @param user
     */
	public void saveUser(IptvConsoleUser user);
	/**
	 * 根据id查询用户
	 * @param userId
	 * @return
	 */
	public IptvConsoleUser findUserById(Integer userId);
	/**
	 * 删除用户
	 * @param userId
	 */
	public void deleteUser(Integer userId);

	/**
	 * 修改密码
	 * @param newPassword
	 * @param userid
	 */
    public void updatePwdById(@Param("newPassword") String newPassword, @Param("userid") Integer userid);
}
