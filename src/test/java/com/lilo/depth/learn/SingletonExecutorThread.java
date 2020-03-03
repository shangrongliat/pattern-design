package com.lilo.depth.learn;

import com.lilo.depth.learn.pattern.singleton.lazy.LazySingleton;

/**
 * @Author: shangrong
 * @Date: 03/03/20 15:59
 * @Description:
 */
public class SingletonExecutorThread implements Runnable {

    @Override
    public void run() {
        LazySingleton singleton = LazySingleton.getSingleton();
        System.out.println(Thread.currentThread().getName()+":" + singleton);
    }
}
