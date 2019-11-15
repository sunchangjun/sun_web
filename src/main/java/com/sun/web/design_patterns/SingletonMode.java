package com.sun.web.design_patterns;

/**
 * @author ：suncj  单例模式
 * @date ：2019/7/23 15:28
 * 三要素：
 *
 * 私有的构造方法；
 *
 * 指向自己实例的私有静态引用；
 *
 * 以自己实例为返回值的静态的公有方法。
 */
public class SingletonMode {

    /**
     * 懒汉模式:线程不安全,所以synchronized 改造成安全的单例模式,但是仍然不够完美所以使用双重检查
     */
    static class LazyMode{
        //使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例
        private static volatile LazyMode lazyMode;
        private LazyMode() {
        }
        public static LazyMode getInstance() {
            // Double-Check idiom
            if (lazyMode == null) {
                synchronized (LazyMode.class) {       // 1
                    // 只需在第一次创建实例时才同步
                    if (lazyMode == null) {       // 2
                        lazyMode = new LazyMode();      // 3
                    }
                }
            }
            return lazyMode;
        }
    }


    /**
     * 饿汉模式:天生线程安全
     */
   static class HungryMode{
        private HungryMode() {}
        private static final HungryMode single = new HungryMode();
        //静态工厂方法
        public static HungryMode getInstance() {
            return single;
        }
    }


}
