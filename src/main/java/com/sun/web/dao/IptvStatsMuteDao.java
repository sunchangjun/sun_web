package com.sun.web.dao;

import com.sun.web.domain.IptvStatsMute;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IptvStatsMuteDao {

	public void insert(IptvStatsMute mute);
	
	
}
