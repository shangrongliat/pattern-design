package com.lilo.depth.learn.pattern.factory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 10:52
 * @Description:
 */
public class XiaoSwanProduction implements IProduction{

    @Override
    public void make() {
        System.out.println("生产小天鹅空调");
    }
}
