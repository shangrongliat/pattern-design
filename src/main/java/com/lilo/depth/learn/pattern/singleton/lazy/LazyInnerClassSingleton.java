package com.lilo.depth.learn.pattern.singleton.lazy;

/**
 * @Author: shangrong
 * @Date: 03/03/20 17:18
 * @Description: 懒汉 内部静态类式
 * 这种型式兼顾饿汉式的内存浪费，也兼顾synchronized性能问题
 * 玩美的屏蔽上面的这两个缺点
 */
public class LazyInnerClassSingleton {

    //默认使用LazyInnerClassSingleton的时候,会先初始化内部类
    //如果没有是用的话,内部类不会加载
    private LazyInnerClassSingleton(){
        if(LazyHolder.LAZY != null){
            throw new RuntimeException("不允许通过反射创建实例");
        }
    }

    //static 是为了使单例的空间共享
    //final 是保证这个方法不会被重写,重载
    public static final LazyInnerClassSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

}
