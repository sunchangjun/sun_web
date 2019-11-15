package com.sun.web.design_patterns;

/**
 * @author ：suncj
 * @date ：2019/7/23 13:59
 * 策略模式
 *
 */
public class StrategyPattern {
     //上下文环境
        private IStrategy mStrategy;
        public StrategyPattern(IStrategy strategy) {
            this.mStrategy = strategy;
        }
        public void algorithm() {
            this.mStrategy.algorithm();
        }

    //抽象策略类 Strategy
    public interface IStrategy {
        void algorithm();
    }

    //具体策略类 ConcreteStrategy
    public static class ConcreteStrategyA implements IStrategy {
        @Override
        public void algorithm() {
            System.out.println("Strategy A");
        }
    }

    //具体策略类 ConcreteStrategy
    public  static class ConcreteStrategyB implements IStrategy {
        @Override
        public void algorithm() {
            System.out.println("Strategy B");
        }
    }
}
