package com.sun.web.dao;

import com.sun.web.domain.IptvResVer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 用户最近播放
 * @author zhangsl
 * @date 2019年4月9日
 */
@Mapper
public interface IptvUserPlayHistoryDao {

	/**
	 * 根据用户id获取最近播放的内容
	 * @param user_id
	 * @return
	 */
	public List<IptvResVer> findHistoryByUserid(@Param("user_id") String userid, @Param("test") boolean test);
	
	public List<Long> findPlayHistoryIds(@Param("user_id") String userid, @Param("type") String type, @Param("test") boolean test);
	/**
	 * 添加播放历史
	 * @param user_id
	 * @param test
	 * @return
	 */
	public void addPlayHistory(@Param("user_id") String userid, @Param("rid") Long rid, @Param("create_time") Date create_time, @Param("test") boolean test);
	/**
	 * 删除播放历史
	 * @param userid
	 * @param rid
	 * @param test
	 */
	public void delPlayHistory(@Param("user_id") String userid, @Param("rid") Long rid, @Param("test") boolean test);
	/**
	 * 删除指定用户所有的播放历史
	 * @param userId
	 * @param test
	 */
    public void removeAllPlayHistory(@Param("user_id") String userId, @Param("test") boolean test);
}