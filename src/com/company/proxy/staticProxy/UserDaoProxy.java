package com.company.proxy.staticProxy;

/**
 * @CLASS_NAME:UserDaoProxy
 * @Description:委托类和被委托类都实现同一接口，面向接口编程，才能更好的低耦合
 * @Author: wangqy
 * @Version:
 * @Date: 2021/7/27 16:13
 */
public class UserDaoProxy implements IUserDao{
    //接收保存目标对象
    private IUserDao target;
    public UserDaoProxy(IUserDao target){
        this.target=target;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}
