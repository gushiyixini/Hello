package com.yelj.hello.design_mode;

/**
 * Author: Alex.ylj
 * 2019-05-08 19:00 Wednesday
 * Description:
 */
public class MainClass {

    public static void main(String[] args){
        testSingleton();
    }

    /**
     * 测试单例
     */
    private static void testSingleton(){
        SingletonDemo.getInstance1();
        SingletonDemo.getInstance2();
        SingletonDemo.getInstance3();
        SingletonDemo.getInstance4();

        SingletonDemo.SingleDemo instance = SingletonDemo.SingleDemo.INSTANCE;
    }
}
