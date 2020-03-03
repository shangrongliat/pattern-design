package com.lilo.depth.learn;

import com.lilo.depth.learn.pattern.factory.IProduction;
import com.lilo.depth.learn.pattern.factory.XiaoSwanProduction;
import com.lilo.depth.learn.pattern.factory.abstractfactory.AbstractProduction;
import com.lilo.depth.learn.pattern.factory.abstractfactory.HaiErProductionFactory;
import com.lilo.depth.learn.pattern.factory.abstractfactory.MeiDiProductionFactory;
import com.lilo.depth.learn.pattern.factory.abstractfactory.XiaoSwanProductionFactory;
import com.lilo.depth.learn.pattern.factory.factorymethod.IProduceFactory;
import com.lilo.depth.learn.pattern.factory.simplefactory.ProduceFactory;
import org.junit.Test;

public class FactoryTest {

    @Test
   public void abstractFactoryTest() {
        AbstractProduction productionFactory = new HaiErProductionFactory();
        productionFactory.createAirCondition().install();
        productionFactory.createHeater().power();
        productionFactory.createRefrigerator().assemble();
        productionFactory.outWarehouse();
        System.out.println("---------------------华丽的分割线------------------------");
        productionFactory = new MeiDiProductionFactory();
        productionFactory.createAirCondition().install();
        productionFactory.createHeater().power();
        productionFactory.createRefrigerator().assemble();
        productionFactory.outWarehouse();
        System.out.println("---------------------华丽的分割线------------------------");
        productionFactory = new XiaoSwanProductionFactory();
        productionFactory.createAirCondition().install();
        productionFactory.createHeater().power();
        productionFactory.createRefrigerator().assemble();
        productionFactory.outWarehouse();

    }

    @Test
    public void factoryMethodTest(){
        IProduceFactory produceFactory = new com.lilo.depth.learn.pattern.factory.factorymethod.HaiErProductionFactory();
        IProduction production = produceFactory.create();
        production.make();
        System.out.println(production);
        production = produceFactory.create();
        production.make();
        System.out.println(production);

        produceFactory = new com.lilo.depth.learn.pattern.factory.factorymethod.MeiDiProductionFactory();
        production = produceFactory.create();
        production.make();

        produceFactory = new com.lilo.depth.learn.pattern.factory.factorymethod.XiaoSwanProductionFactory();
        produceFactory.create().make();
    }

    @Test
    public void simpleFactory(){
        ProduceFactory production = new ProduceFactory();

//        IProduction meidi = production.create("meidi");
//        meidi.make();

        IProduction haier = production.create("com.lilo.depth.learn.pattern.factory.HaiErProduction");
        haier.make();
        System.out.println(haier);

        IProduction xiaoSwan = production.create(XiaoSwanProduction.class);
        xiaoSwan.make();
        System.out.println(xiaoSwan);
    }
}
