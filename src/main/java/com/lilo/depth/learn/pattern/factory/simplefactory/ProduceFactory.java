package com.lilo.depth.learn.pattern.factory.simplefactory;

import com.lilo.depth.learn.pattern.factory.HaiErProduction;
import com.lilo.depth.learn.pattern.factory.IProduction;
import com.lilo.depth.learn.pattern.factory.MeiDiProduction;
import com.lilo.depth.learn.pattern.factory.XiaoSwanProduction;

/**
 * @Author: shangrong
 * @Date: 03/03/20 10:46
 * @Description:
 */
public class ProduceFactory {

//    IProduction create(String productName) {
//        if ("meidi".equals(productName)) {
//            return new MeiDiProduction();
//        } else if ("haier".equals(productName)) {
//            return new HaiErProduction();
//        } else if ("xiaoswan".equals(productName)) {
//            return new XiaoSwanProduction();
//        } else {
//            return null;
//        }
//    }

    public IProduction create(String clazzName){
        try {
            if (!(null == clazzName || "".equals(clazzName))) {
                return (IProduction) Class.forName(clazzName).newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public IProduction create(Class<? extends IProduction> clazz){
        try {
            if (clazz != null) {
                return clazz.newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
