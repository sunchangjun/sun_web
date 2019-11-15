package com.sun.web.design_patterns;

/**
 * 建造者模式demo
 * @author ：suncj
 * @date ：2019/7/22 16:46
 */
public class BuilderMode {
    private String userId;
    private String userName;
    private String moble;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMoble() {
        return moble;
    }

    public void setMoble(String moble) {
        this.moble = moble;
    }

    class Director{

    }

   public  static abstract class Builder{
       public  abstract Builder buildId(String  userId);
       public  abstract Builder buildName(String  username);
       public  abstract Builder buildMoble(String moble);
       public  abstract BuilderMode build();
    }

    public static class ConcreteBuilder extends Builder{
        private BuilderMode builderMode = new BuilderMode();

        @Override
       public Builder buildId(String userId) {
            builderMode.setUserId(userId);
            return this;
        }

        @Override
        public  Builder buildName(String username) {
            builderMode.setUserName(username);
            return this;
        }

        @Override
        public  Builder buildMoble(String moble) {
            builderMode.setMoble(moble);
            return this;
        }

        @Override
       public  BuilderMode build() {
            return builderMode;
        }
    }

}
