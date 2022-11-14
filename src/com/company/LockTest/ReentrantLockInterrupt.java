package com.company.LockTest;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockInterrupt {
    static Lock lockA = new ReentrantLock();
    static Lock lockB = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        // 线程 1：先获取 lockA 再获取 lockB
        Thread t1 = new Thread(() -> {
            try {
                // 先获取 LockA
                lockA.lockInterruptibly();
                // 休眠 10 毫秒
                TimeUnit.MILLISECONDS.sleep(100);
                // 获取 LockB
                lockB.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("响应中断指令");
            } finally {
                // 释放锁
                lockA.unlock();
                lockB.unlock();
                System.out.println("线程 1 执行完成。");
            }
        });
        // 线程 2：先获取 lockB 再获取 lockA
        Thread t2 = new Thread(() -> {
            try {
                // 先获取 LockB
                lockB.lockInterruptibly();
                // 休眠 10 毫秒
                TimeUnit.MILLISECONDS.sleep(100);
                // 获取 LockA
                lockA.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("响应中断指令");
            } finally {
                // 释放锁
                lockB.unlock();
                lockA.unlock();
                System.out.println("线程 2 执行完成。");
            }
        });
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        // 线程1：执行中断
        t1.interrupt();
    }
}
