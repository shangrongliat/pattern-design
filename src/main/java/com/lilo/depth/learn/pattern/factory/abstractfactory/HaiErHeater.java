package com.lilo.depth.learn.pattern.factory.abstractfactory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:37
 * @Description:
 */
public class HaiErHeater implements IHeater{

    @Override
    public void power() {
        System.out.println("海尔..热水器开电...");
    }
}
