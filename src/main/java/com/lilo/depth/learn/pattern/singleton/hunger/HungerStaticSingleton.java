package com.lilo.depth.learn.pattern.singleton.hunger;

/**
 * @Author: shangrong
 * @Date: 03/03/20 15:40
 * @Description: 饿汉 静态块初始化型式
 */
public class HungerStaticSingleton {

    private static final HungerStaticSingleton singleton ;

    static {
        singleton = new HungerStaticSingleton();
    }

    private HungerStaticSingleton(){}

    public static HungerStaticSingleton getInstance(){
        return singleton;
    }
}
