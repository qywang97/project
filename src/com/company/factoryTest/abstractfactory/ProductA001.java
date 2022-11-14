package com.company.factoryTest.abstractfactory;

/**
 * @CLASS_NAME:ProductA001
 * @Description:具体某个子类，工厂模式最后实际生产的地方
 * @Author: wangqy
 * @Version:
 * @Date: 2021/7/27 15:07
 */
public class ProductA001 extends ProductA{
    @Override
    public void create() {
        System.out.println("ProductA001");
    }
}
