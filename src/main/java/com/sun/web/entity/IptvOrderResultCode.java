package com.sun.web.entity;

public class IptvOrderResultCode {
    private String time;
    private String week;

    private Integer codeNull=0;

    private Integer codeSuccess=0;

    private Integer code9101=0;

    private Integer code9102=0;

    private Integer code9304=0;

    private Integer code9305=0;

    private Integer code9602=0;

    private Integer code9681=0;

    private Integer code9999=0;
    private Integer   other=0;
    private Integer    total;

    private Integer distinct_user;

    public Integer getCodeNull() {
        return codeNull;
    }

    public void addCodeNull() {
        this.codeNull++;
    }

    public Integer getCodeSuccess() {
        return codeSuccess;
    }

    public void addCodeSuccess() {
        this.codeSuccess ++;
    }

    public Integer getCode9101() {
        return code9101;
    }

    public void addCode9101() {
        this.code9101 ++;
    }

    public Integer getCode9102() {
        return code9102;
    }

    public void addCode9102() {
        this.code9102 ++;
    }
    public Integer getCode9304() {
        return code9304;
    }

    public void addCode9304() {
        this.code9304 ++;
    }

    public Integer getCode9305() {
        return code9305;
    }

    public void addCode9305() {
        this.code9305 ++;
    }

    public Integer getCode9602() {
        return code9602;
    }

    public void addCode9602() {
        this.code9602 ++;
    }

    public Integer getCode9681() {
        return code9681;
    }

    public void addCode9681() {
        this.code9681 ++;
    }

    public Integer getCode9999() {
        return code9999;
    }

    public void addCode9999() {
        this.code9999 ++;
    }


    public Integer getOther() {
        return other;
    }

    public void addOther() {
        this.other++;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getDistinct_user() {
        return distinct_user;
    }

    public void setDistinct_user(Integer distinct_user) {
        this.distinct_user = distinct_user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}