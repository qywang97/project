package com.company.LockTest;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        final Object A = new Object();
        final Object B = new Object();
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            System.out.println("lock上锁");
            lock.lock();// 上锁
            try{
                //代码
            }finally{
                lock.unlock();
                System.out.println("lock解锁");
            }
        }).start();
        new Thread(()->{
            synchronized (A) {// 死锁
                try {
                    System.out.println(Thread.currentThread().getName()+"持有锁A");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"想获取锁B");
                synchronized (B) {
                    System.out.println("获得锁B");
                }
            }
        },"线程A").start();
        new Thread(()->{
            synchronized (B) {
                try {
                    System.out.println(Thread.currentThread().getName()+"持有锁B");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"想获取锁A");
                synchronized (A) {
                    System.out.println("获得锁A");
                }
            }
        },"线程B").start();

        Object obj = new Object();
        Object obj1 = new Object();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                synchronized (obj1) {
                    System.out.println("大明:我要吃馒头");
                    try {
                        obj1.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }// 进入阻塞状态,直到其他线程发通知
                    System.out.println("大明:开始吃馒头");
                }

            }
        });
        t2.start();
        // 母亲做馒头线程
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                // 做馒头
                System.out.println("母亲开始做馒头");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // 做完馒头发通知
                synchronized (obj1)
                {
                    System.out.println("母亲: 馒头做好了,吃吧");
                    obj1.notify();
//                    obj.notify();// 通知一个等在obj上的一个线程继续运行
//                    obj.notifyAll();// 通知所有等在Obj上的线程继续运行
                }

            }
        });
        t.start();



        synchronized (obj) {
            System.out.println("小明:我要吃馒头");
            obj.wait();// 进入阻塞状态,直到其他线程发通知
            System.out.println("小明:开始吃馒头");
        }

    }

}
