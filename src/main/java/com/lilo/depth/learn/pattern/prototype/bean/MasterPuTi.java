package com.lilo.depth.learn.pattern.prototype.bean;

import java.io.Serializable;

/**
 * @Author: shangrong
 * @Date: 05/03/20 10:51
 * @Description: 菩提师祖  孙悟空的师父
 */
public class MasterPuTi implements Serializable {

    private static final long serialVersionUID = 1000408774238688823L;
    //名称
    private String name;

    //地位
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
