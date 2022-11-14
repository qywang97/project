package com.company.LockTest;

public class LockTest {
    public synchronized void test3(){// 锁方法和锁当前实例  性质差不多
        for (int i = 0; i < 10; i++) {
            System.out.println("实例方法锁3");
        }
    }
    public static void main(String[] args) {
        LockTest1 lock = new LockTest1();
        LockTest1 lock2 = new LockTest1();

        System.out.println(lock.equals(lock2));
        new Thread(()->{
            LockTest1.test1();
        }).start();
        new Thread(()->{
            lock.test2();
        }).start();
        new Thread(()->{
            lock2.test3();
        }).start();
    }
}
class LockTest1 extends Thread{
    @Override
    public void run(){

    }
    public  synchronized static  void test1(){
        while (true){
            System.out.println("静态方法锁");
        }
    }
    public synchronized void test3(){// 锁方法和锁当前实例  性质差不多
        for (int i = 0; i < 10; i++) {
            System.out.println("实例方法锁3");
        }
    }
    public  void test2() {// 锁当前实例
        synchronized(this) {
            while (true) {
                System.out.println("-------------------------------------实例方法锁2");
            }
        }
    }

}
