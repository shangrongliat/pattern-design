package com.lilo.depth.learn.pattern.factory.abstractfactory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:39
 * @Description:
 */
public class HaiErRefrigerator implements IRefrigerator {

    @Override
    public void assemble() {
        System.out.println("海尔..冰箱组装...");
    }
}
