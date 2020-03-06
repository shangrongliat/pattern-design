package com.lilo.depth.learn.pattern.prototype.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: shangrong
 * @Date: 05/03/20 10:48
 * @Description:
 */
public class SunWuKongDO implements Serializable {

    private static final long serialVersionUID = -1523143581369923632L;
    //名称
    private String name;
    //年龄
    private Integer age;
    //身高
    private Double height;
    //本领
    private List<String> ability;

    private MasterPuTi teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public List<String> getAbility() {
        return ability;
    }

    public void setAbility(List<String> ability) {
        this.ability = ability;
    }

    public MasterPuTi getTeacher() {
        return teacher;
    }

    public void setTeacher(MasterPuTi teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "SunWuKongDO{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", height=" + height +
            ", ability=" + ability +
            ", teacher=" + teacher +
            '}';
    }
}
