package com.company.JVMDemo;

public class SanQu {
    public static void main(String[] args) {
        // 返回jvm试图使用的最大内存
        long max = Runtime.getRuntime().maxMemory();
        // 返回jvm的初始化内存
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max="+max+"字节\t"+(max/(1024*1024))+"MB");
        System.out.println("total="+total+"字节\t"+(total/(1024*1024))+"MB");

        //默认情况下，试图分配的最大内存是电脑内存的1/4，而初始化的内存是1/64
        // -Xms1024m -Xmx1024m -XX:+PrintGCDetails
    }
}
