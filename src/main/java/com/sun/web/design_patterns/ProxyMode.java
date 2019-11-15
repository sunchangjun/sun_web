package com.sun.web.design_patterns;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：suncj
 * @date ：2019/7/24 11:00
 * 代理模式
 */
public class ProxyMode {

    /***********************静态代理************************************/
    interface  ProxyInterface{
        void confer();//面谈
        void signContract();//签合同
        void bookTicket();//订票
        void sing();//唱歌
        void collectMoney();//收尾款
    }
    /**
     * 代理角色（明星经纪人）：
     */
    public static class ProxyStar implements ProxyInterface{
        private ProxyInterface star;//真实对象的引用（明星）
        @Override
        public void confer() {
            System.out.println("ProxyStar.confer()");
        }
        @Override
        public void signContract() {
            System.out.println("ProxyStar.signContract()");
        }
        @Override
        public void bookTicket() {
            System.out.println("ProxyStar.bookTicket()");
        }
        @Override
        public void sing() {
            star.sing();//真实对象的操作（明星唱歌）
        }
        @Override
        public void collectMoney() {
            System.out.println("ProxyStar.collectMoney()");
        }
        public ProxyStar(ProxyInterface star) {//通过构造器给真实角色赋值
            this.star = star;
        }
    }
    /**
     * 真实角色（明星艺人）：
     */
    public static class RealStar implements ProxyInterface{
        @Override
        public void confer() {
            System.out.println("RealStar.confer()");
        }
        @Override
        public void signContract() {
            System.out.println("RealStar.signContract()");
        }
        @Override
        public void bookTicket() {
            System.out.println("RealStar.bookTicket()");
        }
        @Override
        public void sing() {
            System.out.println("张学友.sing()");//真实角色的操作：真正的业务逻辑
        }
        @Override
        public void collectMoney() {
            System.out.println("RealStar.collectMoney()");
        }
    }
    public static void main(String[] args) {
        String method="cglib";
        if("static".equals(method)) {//静态代理
        //静态代理
        ProxyInterface real = new RealStar();
        ProxyInterface proxy = new ProxyStar(real);
        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();//真实对象的操作（明星唱歌）
        proxy.collectMoney();
        } else if("dynamic".equals(method)){//动态代理
            // 真实角色
        ProxyInterface realStar = new RealStar();
        //处理器
        StarHandler handler = new StarHandler(realStar);
        //代理类
        ProxyInterface dynamicproxy = (ProxyInterface) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{ProxyInterface.class}, handler);
        dynamicproxy.sing();//调用代理类的唱歌方法：其实调用的是真实角色的唱歌方法
        }else if ("cglib".equals(method)){
            UserDao target = new UserDao();
            //代理对象
            UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();
            //执行代理对象的方法
            proxy.save();
        }





    }

    /****************************动态代理（也叫JDK代理）**********************************/
    /**
     * 处理器
     */
    public static class StarHandler implements InvocationHandler {
        private ProxyInterface realStar;//真实角色
        /**
         * 所有的流程控制都在invoke方法中
         * proxy：代理类
         * method：正在调用的方法
         * args：方法的参数
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object object = null;
            System.out.println("真实角色调用之前的处理.....");
            if (method.getName().equals("sing")) {
                object = method.invoke(realStar, args);//激活调用的方法
            }
            System.out.println("真实角色调用之后的处理.....");
            return object;
        }
        //通过构造器来初始化真实角色
        public StarHandler(ProxyInterface realStar) {
            super();
            this.realStar = realStar;
        }
    }

    /******************************************动态代理之cglib****************************************/
    public static class UserDao {

        public void save() {
            System.out.println("----已经保存数据!----");
        }
    }

    /**
     * Cglib子类代理工厂
     * 对UserDao在内存中动态构建一个子类对象
     */
    public static class ProxyFactory implements MethodInterceptor {
        //维护目标对象
        private Object target;

        public ProxyFactory(Object target) {
            this.target = target;
        }

        //给目标对象创建一个代理对象
        public Object getProxyInstance(){
            //1.工具类
            Enhancer en = new Enhancer();
            //2.设置父类
            en.setSuperclass(target.getClass());
            //3.设置回调函数
            en.setCallback(this);
            //4.创建子类(代理对象)
            return en.create();

        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("开始事务...");

            //执行目标对象的方法
            Object returnValue = method.invoke(target, args);

            System.out.println("提交事务...");

            return returnValue;
        }
    }
}
