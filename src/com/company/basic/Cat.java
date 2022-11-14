package com.company.basic;
/*子类*/
public class Cat extends Animal{
    public String test = "cat";
    @Override
    public void move() {
//        super.move();
        System.out.println("猫可以跳、可以吃小鱼");
    }

    }
