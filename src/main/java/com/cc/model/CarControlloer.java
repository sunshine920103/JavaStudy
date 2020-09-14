package com.cc.model;

/**
 * @author ：cc
 * @date ：created in 2020/9/14 22:10
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class CarControlloer implements ICarController {
    @Override
    public void drive(String car) {
        System.out.println("driver");
    }

    @Override
    public void oil(String money) {
        System.out.println("oil");
    }
}
