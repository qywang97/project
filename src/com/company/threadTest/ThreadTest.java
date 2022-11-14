package com.company.threadTest;

import java.util.concurrent.Callable;

public class ThreadTest {

    public static void main(String[] args) {

        //创建多线程对象
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();

        //创建多线程对象
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mt1,"hello");
        Thread t2 = new Thread(mt1,"java");
        t1.start();
        t2.start();

        //设置每个对象的名字
//        mt1.setName("hello");
        mt2.setName("world");
        mt3.setName("java");

        //调用start()方法，其内部调用了run()方法，实现了多线程
        //在这里直接调用run()方法，不能实现多线程
//        mt1.start();
//        mt2.start();
//        mt3.start();
    }
}
// 方式1：继承Thread类，重写run方法
class MyThread extends Thread {
    int t = 100;
    @Override
    public void run() {
        while (t > 0) {
            synchronized(this){
                if (t > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 这里调用的是当前线程的名字
                    System.out.println(Thread.currentThread().getName() + ":" + t--);
                }
            }}
    }
}
// 方式2：实现Runnable接口，重写run方法,获取线程名只能通过Thread.currentThread().getName()获取
class MyRunnable implements Runnable {
    private int t = 100;

    @Override
    public void run() {
        // 为了演示多线程的同步问题，在多线程同步中，
        // 可能出现1号窗口还正在卖，而还没卖出去的时候，二号窗口刚好开始卖，导致一张票卖了两次
        // 所以在这里我加上在卖票时候的一个延迟

        while (t > 0) {
            synchronized(this){
                if (t > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 这里调用的是当前线程的名字
                    System.out.println(Thread.currentThread().getName() + ":" + t--);
                }
        }}
    }
}
// 方式1：实现Callable接口，重写run方法,获取线程名只能通过Thread.currentThread().getName()获取
class myCallable implements Callable {
    private int t = 100;

    public void run() {
        // 为了演示多线程的同步问题，在多线程同步中，
        // 可能出现1号窗口还正在卖，而还没卖出去的时候，二号窗口刚好开始卖，导致一张票卖了两次
        // 所以在这里我加上在卖票时候的一个延迟

        while (t > 0) {
            synchronized(this){
                if (t > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 这里调用的是当前线程的名字
                    System.out.println(Thread.currentThread().getName() + ":" + t--);
                }
            }}
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
