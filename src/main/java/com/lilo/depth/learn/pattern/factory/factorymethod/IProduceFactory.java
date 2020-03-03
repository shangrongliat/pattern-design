package com.lilo.depth.learn.pattern.factory.factorymethod;

import com.lilo.depth.learn.pattern.factory.IProduction;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:12
 * @Description:
 */
public interface IProduceFactory {

    IProduction create();
}
