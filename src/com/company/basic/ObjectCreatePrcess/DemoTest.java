package com.company.basic.ObjectCreatePrcess;


/*
对象的创建过程：
首次创建对象时，类中的静态方法/静态字段首次被访问时，Java 解释器必须先查找类路径，以定位 .class 文件；
然后载入 .class（这将创建一个 Class 对象），有关静态初始化的所有动作都会执行。因此，静态初始化只在 Class 对象首次加载的时候进行一次；
当用 new 方法创建对象时，首先再堆上为对象分配足够的存储空间；
这块存储空间会被清零，这就自动地将对象中的所有基本类型数据都设置成了缺省值（对数字来说就是 0，对 boolean 和 str 也相同），而引用则被设置成了 null；
执行所有出现于字段定义处的初始化动作（非静态对象的初始化）；
执行构造器。
*/
public class DemoTest {

    {
        num2 = 100;
        System.out.println("num2");
    }
    private int num2 = 60;
    static {
        num1 = 20;
        System.out.println("num2");
        num3 = 20;
    }
    private static int num1 = 50;
    private static int num3 = 50;

    public static void main(String[] args) {
        DemoTest d = new DemoTest();
        System.out.println(DemoTest.num1);
        System.out.println(d.num2);
    }
}
