package com.sun.web.jdbc;

import com.sun.web.domain.IptvConsoleUser;
import com.sun.web.domain.IptvUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ：suncj
 * @date ：2019/10/31 14:17
 */
@Log4j2
@Service
public class IptvJdbcTemplateDao {

    @Autowired
    @Qualifier("iptvJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    public IptvConsoleUser findUserByUserId(String username){
        String  sql="select *  from iptv_console_admin where username=?";
        try{
            return this.jdbcTemplate.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<>(IptvConsoleUser.class));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }



}
