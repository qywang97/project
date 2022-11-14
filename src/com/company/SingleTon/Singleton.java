package com.company.SingleTon;

import java.lang.reflect.Constructor;

/**
 * @CLASS_NAME:Singleton
 * @Description:静态内部类，可以实现懒加载，但是可能存在反射攻击或者反序列攻击
 * @Author: wangqy
 * @Version:
 * @Date: 2021/8/4 15:07
 */
public class Singleton {
    /*静态内部类*/
    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
    public static void main(String[] args) throws Exception {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        /*反射*/
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
//        constructor.setAccessible(true);
        Singleton newSingleton = constructor.newInstance();
        System.out.println(singleton == newSingleton);
        System.out.println(singleton == singleton1);
    }
}
