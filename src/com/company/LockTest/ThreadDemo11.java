package com.company.LockTest;

import java.util.Scanner;

public class ThreadDemo11 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (locker1.getClass()) {
                    System.out.println("请输入一个整数：");
                    Scanner sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    System.out.println("n = " + n);
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("t2 获取到锁了");
                }
            }
        };
        t2.start();
    }
}

