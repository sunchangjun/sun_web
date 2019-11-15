package com.sun.web.design_patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：suncj  观察者模式
 * @date ：2019/7/23 17:44
 */
public class ObserverMode {
    public static abstract class Subject {
        /**
         * 观察者对象的集合
         */
        private List<Observer> observerList = new ArrayList<>();

        /**
         * 登记观察者
         *
         * @param observer
         */
        public void attach(Observer observer) {
            observerList.add(observer);
            System.out.println("增加了观察者：" + observer.getName());
        }

        /**
         * 删除观察者
         *
         * @param observer
         */
        public void dettach(Observer observer) {
            observerList.remove(observer);
            System.out.println("删除了观察者：" + observer.getName());
        }

        /**
         * 通知所有观察者
         */
        public void notifyObserver() {
            for (Observer observer : observerList) {
                observer.update("灰太狼要搞事情了");
            }
        }

    }
    public static class Wolf extends Subject {

        public void invade(){

            System.out.println("灰太狼：我要搞事情了");
            // 通知所有观察者
            notifyObserver();
        }

    }
    public interface Observer {

        String getName();

        /**
         * 通知更新方法
         *
         * @param msg
         */
        public void update(String msg);

    }
    public static class PleasantSheep implements Observer{

        @Override
        public String getName() {
            return "喜羊羊";
        }

        /**
         * 具体业务逻辑
         */
        @Override
        public void update(String msg) {
            System.out.println("喜羊羊收到通知：" + msg);
        }

    }






}
