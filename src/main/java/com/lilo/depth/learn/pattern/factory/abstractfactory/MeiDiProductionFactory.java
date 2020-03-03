package com.lilo.depth.learn.pattern.factory.abstractfactory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:47
 * @Description:
 */
public class MeiDiProductionFactory extends AbstractProduction {

    @Override
    public IAirCondition createAirCondition() {
        return new MeiDiAirCondition();
    }

    @Override
    public IRefrigerator createRefrigerator() {
        return new MeiDiRefrigerator();
    }

    @Override
    public IHeater createHeater() {
        return new MeiDiHeater();
    }
}
