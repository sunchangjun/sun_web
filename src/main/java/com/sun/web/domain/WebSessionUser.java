package com.sun.web.domain;


/**
 * 〈web端的用户信息〉
 * @author comelk
 * @create 2019/5/27
 */
public class WebSessionUser implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private String userId;

    private String platform;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
