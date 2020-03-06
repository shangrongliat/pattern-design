package com.lilo.depth.learn.pattern.singleton.register;

/**
 * @Author: shangrong
 * @Date: 04/03/20 10:25
 * @Description:
 */
public enum  EnumSingleton {

    INSTANCE(new Object());

    private EnumSingleton(Object obj){
        data = obj;
    }
    private Object data;

    public Object getData() {
        return data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
