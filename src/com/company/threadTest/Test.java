package com.company.threadTest;

//public class Test extends  Parent{
//    public Test(String Name){ //2
//        super("kitty"); //4
//        name="hello"; //3
//
//    }
//}
//class Parent{
//        public String name;
//        public Parent(String pName){
//        this.name = pName;
//        }
//        }







import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;


public class Test {
    private static final Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        System.out.println(22&0);
        int c = (-1<<(Integer.SIZE-3))|0;
        System.out.println((-1<<(Integer.SIZE-3))|0);
        System.out.println(((1 << (Integer.SIZE-3)) - 1));
        System.out.println(((1 << (Integer.SIZE-3)) - 1));
        System.out.println(c & ((1 << (Integer.SIZE-3)) - 1));
    }
}

class RunnableImpl implements Runnable {

    public Integer id = -1;

    public RunnableImpl(int id, List<String> list) {
        this.id = id;
        System.out.println("初始化完成 : " + id);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000); // 假设线程每次处理需要3秒钟
            System.out.println("-----------------------------------线程执行结束 : " + id);
        } catch (Exception e) {
        }
    }
}

