package com.sun.web.dao;

import com.sun.web.domain.IptvResVer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 收藏相关服务
 * @author zhangsl
 * @date 2019年4月9日
 */
@Mapper
public interface IptvUserCollectDao {

	/**
	 * 根据用户id获取收藏的内容
	 * @param user_id
	 * @return
	 */
	public List<IptvResVer> findCollectByUserid(@Param("user_id") String user_id, @Param("test") boolean test);
	/**
	 * 添加收藏
	 * @param user_id
	 * @param test
	 * @return
	 */
	public void addCollect(@Param("user_id") String user_id, @Param("rid") Long rid, @Param("create_time") Date create_time, @Param("test") boolean test);
	public void delCollect(@Param("user_id") String user_id, @Param("rid") Long rid, @Param("test") boolean test);
	
	public int findCollectCount(@Param("user_id") String user_id, @Param("type") String type, @Param("test") boolean test);

}