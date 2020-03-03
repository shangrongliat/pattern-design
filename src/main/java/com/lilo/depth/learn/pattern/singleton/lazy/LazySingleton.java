package com.lilo.depth.learn.pattern.singleton.lazy;

/**
 * @Author: shangrong
 * @Date: 03/03/20 15:20
 * @Description:
 */
public class LazySingleton {

    private static LazySingleton singleton = null;

    private LazySingleton(){}

    /**
     * 在增加synchronized关键字之前，线程不安全，在并发情况下会出现创建多个实例的情况
     *
     * 在增加synchronized关键字之后，玩美的展现了监视锁的运行状态，线程安全问题解决了，
     * 但是使用synchronized加锁，在线程数量比较多的情况下，如果CPU分配压力上升，会导致大批量线程出现阻塞，从而导致程序运行性能大幅下降。
     */
    public synchronized static LazySingleton getSingleton(){
        if(null == singleton){
            singleton = new LazySingleton();
        }
        return singleton;
    }

}
