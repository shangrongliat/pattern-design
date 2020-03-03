package com.lilo.depth.learn.pattern.factory.factorymethod;

import com.lilo.depth.learn.pattern.factory.IProduction;
import com.lilo.depth.learn.pattern.factory.XiaoSwanProduction;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:18
 * @Description:
 */
public class XiaoSwanProductionFactory implements IProduceFactory {

    @Override
    public IProduction create() {
        return new XiaoSwanProduction();
    }
}
