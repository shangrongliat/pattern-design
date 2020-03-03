package com.lilo.depth.learn;

import com.lilo.depth.learn.pattern.singleton.hunger.HungerSingleton;
import com.lilo.depth.learn.pattern.singleton.hunger.HungerStaticSingleton;
import com.lilo.depth.learn.pattern.singleton.lazy.LazyInnerClassSingleton;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @Author: shangrong
 * @Date: 03/03/20 15:46
 * @Description:
 */
public class SingletonTest {


    /**
     * 饿汉式
     * 1. 在类加载的时候初始化,并且创建单例对象
     * 2. 线程安全，在线程还没出现以前就已经实例化了，不存在访问安全问题
     * 3.没有加任何锁、执行效率高、在用户体验上来说比懒汉式更好
     * <p>
     * 缺点：
     * 类加载时就初始化，不管能否用到都占着空间爱呢，浪费内存。
     * <p>
     * 举例：
     * Spring中的IOC容器就是典型的饿汉式单例。
     */
    @Test
    public void hungerSingletonTest() {
        HungerStaticSingleton instance = HungerStaticSingleton.getInstance();
        System.out.println(instance);
        HungerStaticSingleton instance2 = HungerStaticSingleton.getInstance();
        System.out.println(instance2);
    }

    /**
     * 懒汉式
     * 1. 在被外部调用的时候才创建实例
     * <p>
     * 缺点
     * 1. 存在一定线程安全问题
     * 2. 存在其他破坏单例的方式的存在
     * <p>
     * 总结： 虽然懒汉式有线程安全和单例被破坏的情况，但是可以通过代码优化来避免上述问题
     */
    @Test
    public void lazySingletonTest() {
//        LazySingleton singleton = LazySingleton.getSingleton();
        Thread t1 = new Thread(new SingletonExecutorThread());
        Thread t2 = new Thread(new SingletonExecutorThread());
        t1.start();
        t2.start();

        System.out.println("END.....");

        LazyInnerClassSingleton instance = LazyInnerClassSingleton.getInstance();
        System.out.println(instance);

    }

    @Test
    public void reflexDestructionSingletonTest() {
        try {
            Class<LazyInnerClassSingleton> clazz = LazyInnerClassSingleton.class;
            //通过反射拿到私有构造方法
            //getDeclaredConstructor 内部
            Constructor<LazyInnerClassSingleton> c = clazz.getDeclaredConstructor(null);
            //设置强制访问
            c.setAccessible(true);
            //暴力初始化
            LazyInnerClassSingleton s1 = c.newInstance();
            System.out.println(s1);
            LazyInnerClassSingleton s2 = c.newInstance();
            System.out.println(s2);
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void serializableSingletonTest(){
        HungerSingleton h1 = null;
        HungerSingleton h2 = HungerSingleton.getInstance();

        try {
            FileOutputStream fos = new FileOutputStream("SerializableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(h2);
            oos.flush();
            oos.close();
//
//            FileInputStream fis = new FileInputStream("SerializableSingleton.obj");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            h1 = (HungerSingleton) ois.readObject();
//            ois.close();
//
//            System.out.println(h1);
//            System.out.println(h2);
//
//            System.out.println(h1 == h2);
        }catch (Exception e){
           e.printStackTrace();
        }

    }

}
