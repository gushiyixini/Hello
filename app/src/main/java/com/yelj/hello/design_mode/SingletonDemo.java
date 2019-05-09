package com.yelj.hello.design_mode;

/**
 * Author: Alex.ylj
 * 2019-05-08 18:43 Wednesday
 * Description: 单例
 */
public class SingletonDemo {

    //懒汉式
    //缺点：多线程同时访问时会有问题，缺乏同步
    private static SingletonDemo singletonDemo1;

    public static SingletonDemo getInstance1() {
        if (null == singletonDemo1) {
            singletonDemo1 = new SingletonDemo();
        }
        return singletonDemo1;
    }

    //线程安全的懒汉式
    //缺点：虽然加了同步锁，但是由于大部分情况下，是不需要考虑同步这个情况的，而这里每次请求都加了个同步锁就造成了资源的浪费
    private static SingletonDemo singletonDemo2;

    public static synchronized SingletonDemo getInstance2() {
        if (null == singletonDemo2) {
            singletonDemo2 = new SingletonDemo();
        }
        return singletonDemo2;
    }

    //饿汉式
    //缺点：类加载的时候就初始化了，没有起到懒加载的作用
    private static SingletonDemo singletonDemo3 = new SingletonDemo();

    public static SingletonDemo getInstance3() {
        return singletonDemo3;
    }

    //静态内部类的形式
    //推荐：实现了懒加载，同样也是线程安全的
    private static class SingletonDemoInstance {
        private static SingletonDemo INSTANCE = new SingletonDemo();
    }

    public static SingletonDemo getInstance4() {
        return SingletonDemoInstance.INSTANCE;
    }

    //枚举
    //推荐：自由实例化、单实例、线程安全
    enum SingleDemo {
        INSTANCE;

        public void doSomething() {
            // TODO: 2019-05-08 do something
        }
    }

    //双重验证
    //情景分析：
    //线程A进入方法，发现实例没有初始化，进入代码块，同时被锁定
    //线程B进入方法，发现实例没有初始化，进入代码块，发现已经被线程A锁定，此时阻塞
    //线程A执行同步方法，发现实例没有初始化，则初始化实例，跳出代码块，return
    //线程B执行同步方法，发现实例已经被初始化，跳出代码块，return，此时返回的是线程A中初始化的实例
    //逻辑上实现了线程安全，且实现了懒加载
    private static SingletonDemo singletonDemo5;

    public static SingletonDemo getInstance5() {
        if (null == singletonDemo5) {
            synchronized (SingletonDemo.class) {
                if (null == singletonDemo5) {
                    singletonDemo5 = new SingletonDemo();
                }
            }
        }
        return singletonDemo5;
    }

    //volatile关键字，会强制将修改的值写入内存，线程A修改了变量值，线程B/C/D都会立即读取到修改后的值
    private volatile SingletonDemo getSingletonDemo6;
}
