package com.sun.web.domain;

import java.math.BigDecimal;

/**
 * 〈iptv活动奖品实体〉
 *
 * @author comelk
 * @create 2019/8/27
 */
public class IptvActivityAward {

    private Integer id;

    private String name;

    private Integer num;

    private BigDecimal price;
    //万份中奖概率
    private Integer probability;

    private Integer day_max_num;
    //非本表字段，已经中奖次数
    private Integer used;

    private Integer start_num;

    private Integer end_num;

    private String poster;

    private Integer actvity_id;

    public Integer getActvity_id() {
        return actvity_id;
    }

    public void setActvity_id(Integer actvity_id) {
        this.actvity_id = actvity_id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    public Integer getStart_num() {
        return start_num;
    }

    public void setStart_num(Integer start_num) {
        this.start_num = start_num;
    }

    public Integer getEnd_num() {
        return end_num;
    }

    public void setEnd_num(Integer end_num) {
        this.end_num = end_num;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public Integer getDay_max_num() {
        return day_max_num;
    }

    public void setDay_max_num(Integer day_max_num) {
        this.day_max_num = day_max_num;
    }
}
