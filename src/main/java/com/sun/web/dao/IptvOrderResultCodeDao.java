package com.sun.web.dao;

import com.sun.web.entity.IptvOrderResultCode;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IptvOrderResultCodeDao {
    int deleteByPrimaryKey(Date data);

    int insert(IptvOrderResultCode record);


    IptvOrderResultCode selectByPrimaryKey(Date data);


    int updateByPrimaryKey(IptvOrderResultCode record);


    List<IptvOrderResultCode> findByTimeBetten(@Param("start_time") String start_time, @Param("end_time") String end_time);
}