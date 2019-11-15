package com.sun.web.dao;

import com.sun.web.entity.IptvUserOrderStatis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface IptvUserOrderStatisDao {
    int deleteByPrimaryKey(Date time);

    int insert(IptvUserOrderStatis record);


    IptvUserOrderStatis selectByPrimaryKey(Date time);

    int updateByPrimaryKeySelective(IptvUserOrderStatis record);

    int updateByPrimaryKey(IptvUserOrderStatis record);


    @Select(value="select* from iptv_user_order_statis where time BETWEEN #{begin_time} and #{end_time}")
    List<IptvUserOrderStatis> findListByTimeBetween(@Param("begin_time") String begin_time, @Param("end_time") String end_time);

    @Select(value="select* from iptv_user_order_statis ")
    List<IptvUserOrderStatis> findAll();
}