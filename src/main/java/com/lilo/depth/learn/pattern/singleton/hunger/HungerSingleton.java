package com.lilo.depth.learn.pattern.singleton.hunger;

import java.io.*;
import java.util.Date;

/**
 * @Author: shangrong
 * @Date: 03/03/20 15:14
 * @Description: 饿汉式单例 普通模式
 */
public class HungerSingleton implements Cloneable,Serializable {

    //先静态、后动态
    //先属性、后方法
    //先上后下

    private static final HungerSingleton singleton = new HungerSingleton();

    private static final long serialVersionUID = -8055575402317800856L;

    private HungerSingleton(){}

    public static HungerSingleton getInstance(){
        return singleton;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }


    private Object deepClone(){
        try{

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            HungerSingleton copy = (HungerSingleton)ois.readObject();
            return copy;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    private Object readResolve(){
        return singleton;
    }

}
