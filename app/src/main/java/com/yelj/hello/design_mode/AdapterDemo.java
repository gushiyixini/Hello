package com.yelj.hello.design_mode;

/**
 * Author: Alex.ylj
 * 2019-05-09 14:09 Thursday
 * Description: 适配器模式
 */
public class AdapterDemo {

    //已存在的，具有特殊功能，但不符合我们既有标准接口的类
    static class Adaptee {

        void specificRequest() {
            System.out.println("被适配器类，具有特殊功能");
        }
    }

    //目标接口
    interface Target {

        void request();
    }

    //具体的目标类，只提供普通功能
    static class ConcreteTarget implements Target {

        @Override
        public void request() {
            System.out.println("普通类，具有普通功能");
        }
    }

    /**
     * 继承了被适配器类，同时实现了接口
     */
    static class Adapter extends Adaptee implements Target {

        @Override
        public void request() {
            super.specificRequest();
        }
    }

    /**
     * 通过委托的方式
     */
    static class Adapter1 implements Target {

        Adaptee adaptee;

        Adapter1(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void request() {
            this.adaptee.specificRequest();
        }
    }

    /**
     * 优点：
     * 通过适配器，客户端可以调用同一接口，逻辑上更透明
     * 解决了现有类和复用场景要求不一致的问题
     * 将目标类和现有类解耦，引入一个适配器类，复用现有类的代码
     *
     * 适用场景：
     * 旧的代码已经实现了某些功能，但是此时我们想以另外一个接口的形式表示，且不改动原有的代码
     */
    public static void main(String[] args) {
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        Target adapter = new Adapter();
        adapter.request();

        Target adapter1 = new Adapter1(new Adaptee());
        adapter1.request();
    }
}
