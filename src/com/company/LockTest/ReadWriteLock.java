package com.company.LockTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadWriteLock {
    public static void main(String[] args) {
        MyMap myCache = new MyMap();
        Downgrade downgrade = new Downgrade();
        downgrade.Demotion();
        //十个写线程
        for (int i = 0; i < 10; i++) {
            final int temp=i;
            new Thread(() -> {
                myCache.put(temp+"",temp+"");
            }, String.valueOf(i)).start();
        }
        //十个读线程
        for (int i = 0; i < 10; i++) {
            final int temp=i;
            new Thread(() -> {
                myCache.get(temp+"");
            }, String.valueOf(i)).start();
        }
    }
}

/**
 * 自定义缓存
 */
class MyMap {
    private volatile Map<String, Object> map = new HashMap<>();

    //读写锁 :更加细粒度的控制
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    //存入值 写的时候希望只有一个线程写
    public void put(String key, Object value) {
        //加写锁
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        }catch (Exception e){

        }finally {
            // 解锁
            lock.writeLock().unlock();
        }
    }

    //取值  读所有人都可以读
    public void get(String key) {
        //加读锁
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成");
        }catch (Exception e){

        }finally {
            lock.readLock().unlock();
        }
    }
}
// 锁降级
 class Downgrade {
    public  void Demotion() {
        //可重入读写锁对象
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        //读锁
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        //写锁
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        //锁降级

        //获取读锁
        readLock.lock();
        System.out.println("read读取");

        //获取写锁
        writeLock.lock();
        System.out.println("飞飞");


        //解锁
        writeLock.unlock();
        readLock.unlock();
    }
}
