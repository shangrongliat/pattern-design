package com.lilo.depth.learn.pattern.factory.abstractfactory;

/**
 * @Author: shangrong
 * @Date: 03/03/20 11:24
 * @Description:
 */
public abstract class AbstractProduction {

    public AbstractProduction() {
        System.out.println("开门生产..........");
    }

    public abstract IAirCondition createAirCondition();

    public abstract IRefrigerator createRefrigerator();

    public abstract IHeater createHeater();

    public void outWarehouse(){
        System.out.println("货物出库..............");
    }

}
