package com.lilo.depth.learn.pattern.factory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 10:49
 * @Description:
 */
public class HaiErProduction implements IProduction {

    @Override
    public void make() {
        System.out.println("生产海尔空调");
    }
}
