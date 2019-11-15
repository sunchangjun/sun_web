package com.sun.web.dao;

import com.sun.web.domain.IptvStatsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IptvStatsUserDao {

	public void insert(IptvStatsUser stats_user);
	
	public List<IptvStatsUser> findStatsUser(@Param("from") String from, @Param("to") String to);
	
	
}
