package com.lilo.depth.learn.pattern.singleton.threadlocal;


import com.lilo.depth.learn.pattern.singleton.lazy.LazySingleton;

public class ExectorThread implements Runnable{

    public void run() {
//        LazySingleton singleton = LazySingleton.getSingleton();
//        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
