package com.lilo.depth.learn.pattern.factory.abstractfactory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:36
 * @Description: 空调
 */
public class HaiErAirCondition implements IAirCondition {

    @Override
    public void install() {
        System.out.println("海尔..空调安装.....");
    }
}
