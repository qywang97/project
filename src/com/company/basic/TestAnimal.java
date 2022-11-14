package com.company.basic;

public class TestAnimal {
    public static void main(String[] args) {
        Animal cat = new Cat();//向上转型
        cat.move();
        System.out.println(cat.test);
        goDown(cat);
        System.out.println(singleTonClass.SINGLETON.getName());
    }
    static void goDown(Animal animal) {// 向下转型，用于接收然后判断
        if (animal instanceof Cat) {
            System.out.println("Cat");
        }
    }
}
/*
* 枚举，单例，枚举体中定义的SMALL、MEDIUM、LARGE变成了公有静态常量，且类中的构造函数是私有的，这就解释了为什么可以用枚举来做单例模式了。
* */
enum singleTonClass{
    SINGLETON;
    private String name = "谢广坤";
    private Integer age = 25;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
