package com.lilo.depth.learn;

import com.alibaba.fastjson.JSON;
import com.lilo.depth.learn.pattern.prototype.bean.MasterPuTi;
import com.lilo.depth.learn.pattern.prototype.bean.SunWuKongDO;
import com.lilo.depth.learn.pattern.prototype.simple.Client;
import com.lilo.depth.learn.pattern.prototype.simple.ConcretePrototypeA;
import com.lilo.depth.learn.pattern.prototype.simple.Prototype;
import com.lilo.depth.learn.pattern.singleton.hunger.HungerSingleton;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shangrong
 * @Date: 04/03/20 17:36
 * @Description:
 */
public class PrototypeTest {


    @Test
    public void prototypeTest() {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(28);
        concretePrototypeA.setName("zhangsan");
        List list = new ArrayList<>();
        concretePrototypeA.setHobbies(list);

        Client client = new Client();
        ConcretePrototypeA copy = (ConcretePrototypeA) client.startClone(concretePrototypeA);
        System.out.println(concretePrototypeA);
        System.out.println(concretePrototypeA.getHobbies());
        concretePrototypeA = null;
        System.out.println(copy);
        System.out.println(copy.getHobbies());
    }


    @Test
    public void beanUtilsPrototypeDeepTest() {
        try {
            SunWuKongDO sunWuKongDO = new SunWuKongDO();
            sunWuKongDO.setName("孙悟空");
            sunWuKongDO.setAge(500);
            sunWuKongDO.setHeight(1.3);

            List<String> list = new ArrayList<>();
            list.add("七十二变");
            list.add("上天入地");
            list.add("毫毛变猴子");
            sunWuKongDO.setAbility(list);

            MasterPuTi masterPuTi = new MasterPuTi();
            masterPuTi.setName("菩提师祖");
            masterPuTi.setStatus("天界5巨头");

            sunWuKongDO.setTeacher(masterPuTi);

            SunWuKongDO hair = new SunWuKongDO();

            BeanUtils.copyProperties(hair, sunWuKongDO);

            SunWuKongDO o = (SunWuKongDO)BeanUtils.cloneBean(sunWuKongDO);

            System.out.println(o);
            System.out.println(sunWuKongDO.getAbility() == hair.getAbility());
            System.out.println(sunWuKongDO.getAbility());
            System.out.println(hair.getAbility());
            sunWuKongDO.getAbility().add("腾云驾雾");
            System.out.println(sunWuKongDO.getAbility());
            System.out.println(hair.getAbility());
            System.out.println("--------------------------");
            System.out.println(sunWuKongDO.getTeacher() == hair.getTeacher());

            System.out.println(sunWuKongDO.getTeacher());
            System.out.println(hair.getTeacher());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsonPrototypeDeepTest(){
        SunWuKongDO sunWuKongDO = new SunWuKongDO();
        sunWuKongDO.setName("孙悟空");
        sunWuKongDO.setAge(500);
        sunWuKongDO.setHeight(1.3);

        List<String> list = new ArrayList<>();
        list.add("七十二变");
        list.add("上天入地");
        list.add("毫毛变猴子");
        sunWuKongDO.setAbility(list);

        MasterPuTi masterPuTi = new MasterPuTi();
        masterPuTi.setName("菩提师祖");
        masterPuTi.setStatus("天界5巨头");

        sunWuKongDO.setTeacher(masterPuTi);

        SunWuKongDO hair = JSON.parseObject(JSON.toJSONString(sunWuKongDO), SunWuKongDO.class);

        System.out.println(sunWuKongDO.getAbility() == hair.getAbility());
        System.out.println(sunWuKongDO.getAbility());
        System.out.println(hair.getAbility());
        sunWuKongDO.getAbility().add("腾云驾雾");
        System.out.println(sunWuKongDO.getAbility());
        System.out.println(hair.getAbility());
        System.out.println("--------------------------");
        System.out.println(sunWuKongDO.getTeacher() == hair.getTeacher());

        System.out.println(sunWuKongDO.getTeacher());
        System.out.println(hair.getTeacher());
    }

    @Test
    public void destructionSingletonTest(){
        HungerSingleton instance = HungerSingleton.getInstance();
        System.out.println(instance);
        try {
            HungerSingleton o = (HungerSingleton) instance.clone();
            System.out.println(o);
            System.out.println(o == instance);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
