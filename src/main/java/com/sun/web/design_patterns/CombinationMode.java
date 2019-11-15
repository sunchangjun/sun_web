package com.sun.web.design_patterns;

import java.util.ArrayList;

/**
 * @author ：suncj
 * @date ：2019/7/23 9:41
 * 组合模式
 */
public abstract class CombinationMode {
    protected String name;
    protected String duties;
    public String getName(){
        return this.name;
    }
    public String getDuties(){
        return this.duties;
    }
    public CombinationMode(String name,String duties) {
        this.name = name;
        this.duties=duties;
    }
    //获取分支下的所有叶子构件和树枝构件
    public abstract void display(int depth);

    //子类继承
    public static class Composite extends CombinationMode {
        private ArrayList<CombinationMode> componentArrayList = new ArrayList<CombinationMode>();
        public ArrayList<CombinationMode> getComponentArrayList(){

            return this.componentArrayList;
        }
        public Composite(String name,String duties) {
            super(name,duties);
        }
        //构建容器
        //增加一个叶子构件或树枝构件
        public Composite add(CombinationMode component) {
            this.componentArrayList.add(component);
            return this;
        }
        //删除一个叶子构件或树枝构件
        public Composite remove(CombinationMode component) {
            this.componentArrayList.remove(component);
            return this;
        }

        @Override
        public void display(int depth) {
            //输出树形结构
            for(int i=0; i<depth; i++) {
                System.out.print('-');
            }
            System.out.println(name);
            //下级遍历
            for (CombinationMode component : componentArrayList) {
                component.display(depth + 1);
            }
        }

    }

    public static class Leaf extends CombinationMode {
        public Leaf(String name,String duties) {
            super(name,duties);
        }
        @Override
        public void display(int depth) {
            //输出树形结构的叶子节点
            for(int i=0; i<depth; i++) {
                System.out.print('-');
            }
            System.out.println(name);
        }


    }

}
