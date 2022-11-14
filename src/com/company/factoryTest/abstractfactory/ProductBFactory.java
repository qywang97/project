package com.company.factoryTest.abstractfactory;

public class ProductBFactory extends AbstractFactory{
    @Override
    public Product getCar(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class cl = Class.forName("com.company.factoryTest.abstractfactory."+type);
        return (ProductB)cl.newInstance();
    }
}
