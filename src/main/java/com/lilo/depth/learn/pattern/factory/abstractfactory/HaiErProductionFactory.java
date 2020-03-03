package com.lilo.depth.learn.pattern.factory.abstractfactory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:35
 * @Description: 海尔生产工厂
 */
public class HaiErProductionFactory extends AbstractProduction{


    @Override
    public IAirCondition createAirCondition() {
        return new HaiErAirCondition();
    }

    @Override
    public IRefrigerator createRefrigerator() {
        return new HaiErRefrigerator();
    }

    @Override
    public IHeater createHeater() {
        return new HaiErHeater();
    }
}
