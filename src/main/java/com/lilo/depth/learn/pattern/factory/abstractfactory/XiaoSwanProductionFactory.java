package com.lilo.depth.learn.pattern.factory.abstractfactory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:47
 * @Description:
 */
public class XiaoSwanProductionFactory extends AbstractProduction {

    @Override
    public IAirCondition createAirCondition() {
        return new XiaoSwanAirCondition();
    }

    @Override
    public IRefrigerator createRefrigerator() {
        return new XiaoSwanRefrigerator();
    }

    @Override
    public IHeater createHeater() {
        return new XiaoSwanHeater();
    }
}
