package com.lilo.depth.learn.pattern.factory.abstractfactory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:48
 * @Description:
 */
public class XiaoSwanAirCondition implements IAirCondition {
    @Override
    public void install() {
        System.out.println("小天鹅..空调安装.....");
    }
}
