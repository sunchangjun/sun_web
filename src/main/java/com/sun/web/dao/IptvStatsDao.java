package com.sun.web.dao;

import com.sun.web.domain.IptvStats;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IptvStatsDao {

	public String findMaxDate();
	
	public void insert(IptvStats stats);
	
}
