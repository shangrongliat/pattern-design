package com.lilo.depth.learn.pattern.factory.factorymethod;

import com.lilo.depth.learn.pattern.factory.HaiErProduction;
import com.lilo.depth.learn.pattern.factory.IProduction;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:17
 * @Description:
 */
public class HaiErProductionFactory implements IProduceFactory {

    @Override
    public IProduction create() {
        return new HaiErProduction();
    }
}
