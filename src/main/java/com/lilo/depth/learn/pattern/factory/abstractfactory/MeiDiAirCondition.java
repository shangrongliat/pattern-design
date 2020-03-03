package com.lilo.depth.learn.pattern.factory.abstractfactory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:48
 * @Description:
 */
public class MeiDiAirCondition implements IAirCondition {
    @Override
    public void install() {
        System.out.println("美的..空调安装.....");
    }
}
