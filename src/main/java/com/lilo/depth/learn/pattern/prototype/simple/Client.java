package com.lilo.depth.learn.pattern.prototype.simple;

/**
 * @Author: shangrong
 * @Date: 04/03/20 17:37
 * @Description:
 */
public class Client {

    public Prototype startClone(Prototype concretePrototype){
        return concretePrototype.clone();
    }

}
