package com.lilo.depth.learn.pattern.factory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 10:48
 * @Description:
 */
public class MeiDiProduction implements IProduction{

    @Override
    public void make() {
        System.out.println("生产美的空调");
    }
}
