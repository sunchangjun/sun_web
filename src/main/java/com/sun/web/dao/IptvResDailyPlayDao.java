package com.sun.web.dao;

import com.sun.web.enums.IptvObjectEnum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

@Mapper
public interface IptvResDailyPlayDao {

	//查找7天内的数据,按播放量来进行降序,现在返回的是vid,以便接下来取详情
	public List<Long> findWeekResVid(@Param("type") IptvObjectEnum type, @Param("from") Date from, @Param("to") Date to,
                                     @Param("size") int size, @Param("test") boolean test);

	public void addDailyPlayNum(@Param("date") Date date, @Param("rid") Long rid);
}