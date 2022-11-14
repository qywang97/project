package com.company.factoryTest.abstractfactory;

/**
 * @CLASS_NAME:FatherFactory
 * @Description:超级工厂，用于选工厂
 * @Author: wangqy
 * @Version:
 * @Date: 2021/7/27 15:03
 */
public abstract class FatherFactory {
    public static AbstractFactory getFactory(String type)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        /**
         * @Description:Class.forName()只接受全限定名，不能直接传入类名
         * @Param:type
         */
        Class cl = Class.forName("com.company.factoryTest.abstractfactory."+type);
        return (AbstractFactory) cl.newInstance();
    }

}
