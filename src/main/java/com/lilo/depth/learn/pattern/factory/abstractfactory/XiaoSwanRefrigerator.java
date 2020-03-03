package com.lilo.depth.learn.pattern.factory.abstractfactory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:39
 * @Description:
 */
public class XiaoSwanRefrigerator implements IRefrigerator {

    @Override
    public void assemble() {
        System.out.println("美的..冰箱组装...");
    }
}
