package com.company.factoryTest.abstractfactory;

/**
 * @CLASS_NAME:AbstractFactory
 * @Description:所有的工厂的父类，也是只声明，不做定义
 * @Author: wangqy
 * @Version:
 * @Date: 2021/7/27 15:04
 */
public abstract class AbstractFactory {
    public abstract Product getCar(String type) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException;

}
