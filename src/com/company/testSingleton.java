package com.company;

class ThreadTest implements Runnable{
    private String name ;       // 表示线程的名称
    public ThreadTest(String name){
        this.name = name ;      // 通过构造方法配置name属性
    }
    @Override
    public void run(){  // 覆写run()方法，作为线程 的操作主体
        for(int i=0;i<10;i++){
            Singleton singleton = Singleton.getInstance();
        }
    }
}
 public class testSingleton{
     public static void main(String args[]){
         ThreadTest mt1 = new ThreadTest("线程A ") ;    // 实例化对象
         ThreadTest mt2 = new ThreadTest("线程B ") ;    // 实例化对象
         Thread t1 = new Thread(mt1) ;       // 实例化Thread类对象
         Thread t2 = new Thread(mt2) ;       // 实例化Thread类对象
               t1.start() ;    // 启动多线程
               t2.start() ;    // 启动多线程
            }
 };
