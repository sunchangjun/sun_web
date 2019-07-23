package com.sun.web.Test;

/**
 * @author ：suncj  优化:枚举策略模式,用枚举代替具体的策略类,并且免去new的步骤,解耦
 * @date ：2019/7/23 14:38
 */
public class OtherTest {
        public static void main(String[] args) {
            int result = Calculator.ADD.calc(1, 2);
            System.out.println(result);
             System.out.println(Calculator.ADD.getSymbol());
        }

        static enum Calculator {

            // 加法运算
            ADD("+") {
                @Override
                public int calc(int a, int b) {
                    return a + b;
                }
            },
            SUB("-") {
                @Override
                public int calc(int a, int b) {
                    return a - b;
                }
            };
            private String symbol;
            public abstract int calc(int a, int b);
            private Calculator(String symbol) {
                this.symbol = symbol;
            }
            public String getSymbol() {
                return this.symbol;
            }


        }
}
