package com.company.factoryTest.abstractfactory;

public class Test {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        AbstractFactory abstractFactory = FatherFactory.getFactory("ProductAFactory");
        Product product = abstractFactory.getCar("ProductA001");
        product.create();
    }
}
