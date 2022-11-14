package com.company.LockTest;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 可重入锁
 */
public class Reentrant {
    private static final Logger log = LoggerFactory.getLogger(Reentrant.class);
    Lock lock = new ReentrantLock();

    public synchronized void method01() {
        System.out.println(Thread.currentThread().getName() + "执行了method01");
        method02();
    }

    public synchronized void method02() {
        System.out.println(Thread.currentThread().getName() + "执行了method02");
    }

    public void method03() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "执行了method03");
            method04();
        } finally {
            lock.unlock();
        }
    }

    public void method04() {
        try {
            lock.tryLock();
            System.out.println(Thread.currentThread().getName() + "执行了method04");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Reentrant reentrant = new Reentrant();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrant.method01();
            }
        }, "t1").start();
        Thread t3 = new Thread(new Thread(){
            @Override
            public void run() {
                reentrant.method01();
            }
        });
        t3.setName("t3");
        t3.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrant.method03();
            }
        }, "t2").start();
    }
}
