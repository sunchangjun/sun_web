package com.sun.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class IptvUserOrderStatis {
    private Date time;

    private Integer new_user;

    private Integer refill_user;

    private Integer return_user;
    public IptvUserOrderStatis(){}
    public IptvUserOrderStatis(Date time, Integer newUser, Integer refillUser, Integer returnUser){
        this.time=time;
        this.new_user=newUser;
        this.refill_user=refillUser;
        this.return_user=returnUser;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    public Date getTime() {
        return time;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getNew_user() {
        return new_user;
    }

    public void setNew_user(Integer new_user) {
        this.new_user = new_user;
    }

    public Integer getRefill_user() {
        return refill_user;
    }

    public void setRefill_user(Integer refill_user) {
        this.refill_user = refill_user;
    }

    public Integer getReturn_user() {
        return return_user;
    }

    public void setReturn_user(Integer return_user) {
        this.return_user = return_user;
    }
}