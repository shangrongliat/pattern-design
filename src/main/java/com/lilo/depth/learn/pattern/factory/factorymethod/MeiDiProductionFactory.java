package com.lilo.depth.learn.pattern.factory.factorymethod;

import com.lilo.depth.learn.pattern.factory.IProduction;
import com.lilo.depth.learn.pattern.factory.MeiDiProduction;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:17
 * @Description:
 */
public class MeiDiProductionFactory implements IProduceFactory {

    @Override
    public IProduction create() {
        return new MeiDiProduction();
    }
}
