package com.company.factoryTest.abstractfactory;

/**
 * @CLASS_NAME:ProductAFactory
 * @Description:具体某个大类的工厂，包含所有子类的创建方法
 * @Author: wangqy
 * @Version:
 * @Date: 2021/7/27 15:09
 */
public class ProductAFactory extends AbstractFactory{
    @Override
    public Product getCar(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class cl = Class.forName("com.company.factoryTest.abstractfactory."+type);
        return (ProductA)cl.newInstance();
    }
}
