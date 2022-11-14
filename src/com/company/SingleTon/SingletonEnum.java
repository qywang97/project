package com.company.SingleTon;

/*枚举，目前最安全的方式，因为枚举类实例不能让外界创建*/
public enum SingletonEnum {

    INSTANC;

    public void doSomething() {
        System.out.println("doSomething");
    }

}

//调用方法
 class Main {

    public static void main(String[] args) {
        SingletonEnum singletonEnum = SingletonEnum.INSTANC;
    }

}
