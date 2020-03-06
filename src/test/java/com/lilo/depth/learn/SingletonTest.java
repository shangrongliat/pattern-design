package com.lilo.depth.learn;

import com.lilo.depth.learn.pattern.singleton.hunger.HungerSingleton;
import com.lilo.depth.learn.pattern.singleton.hunger.HungerStaticSingleton;
import com.lilo.depth.learn.pattern.singleton.lazy.LazyInnerClassSingleton;
import com.lilo.depth.learn.pattern.singleton.register.ContainerSingleton;
import com.lilo.depth.learn.pattern.singleton.register.EnumSingleton;
import com.lilo.depth.learn.pattern.singleton.threadlocal.ExectorThread;
import com.lilo.depth.learn.pattern.singleton.threadlocal.ThreadLocalSingleton;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @Author: shangrong
 * @Date: 03/03/20 15:46
 * @Description:  单例看似简单，实现起来也非常简单，但是在线程的安全及是否可以被破坏的方面序要多下功夫去进行研究。
 *
 * 优点：
 *  1. 单例模式可以保证内存里只有一个实例
 *  2. 减少内存开销;避免对资源的多重占用
 *  3. 设置全局访问点，严格控制访问
 * 缺点：
 *  1. 没有接口，扩展困难
 *  2. 如果要扩展单例对象，只有修改代码，没有其他途径
 *
 * 要点：
 *  1. 私有构造器
 *  2. 保证线程安全
 *  3. 延迟加载
 *  4. 防止序列化和反序列化破坏单例
 *  5. 防止反射攻击破坏单例
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
    public void serializableSingletonTest() {
        HungerSingleton h1 = null;
        HungerSingleton h2 = HungerSingleton.getInstance();

        try {
            FileOutputStream fos = new FileOutputStream("SerializableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(h2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SerializableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            h1 = (HungerSingleton) ois.readObject();
            ois.close();

            System.out.println(h1);
            System.out.println(h2);

            System.out.println(h1 == h2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 枚举式单例
     * 由于JDK的机制，该类型的单例保证枚举式单例不可以被反射和序列化反序列再次加载实例
     */
    @Test
    public void enumSingletonTest() {
        try {
            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
                @Override
                public void handler() {
                    EnumSingleton instance = EnumSingleton.getInstance();
                    System.out.println(System.currentTimeMillis()+": "+ instance.getData());
                }
            }, 10, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册式单例
     */
    @Test
    public void containerSingletonTest() {
        try {
            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
                @Override
                public void handler() {
                    Object bean = ContainerSingleton.getBean("com.lilo.depth.learn.pattern.singleton.register.Pojo");
                    System.out.println(System.currentTimeMillis()+": "+ bean);
                }
            }, 100, 50);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end....");
    }

    /**
     * 线程单例
     * 不能保证其对象是全局唯一，但是可以保证在单个线程内是唯一的，天生的线程安全
     * 该单例是将所有对象放到ThreadLocalMap中，为没个线程都提供一个对象，实际上是用线程来进行隔离的。
     */
    @Test
    public void threadLocalSingletonTest(){
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();

        System.out.println("end......");

    }

}
