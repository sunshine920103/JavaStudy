package com.cc.javastudy;
/**
 * Created by zhufeng on 2016/10/15.
 */
public class Test {

    @org.junit.Test
    public void test1()
    {
        System.out.println("test");
    }

    @org.junit.Test
    public void test2()
    {
        //浮点数除以0得到无穷大或NaN结果
        System.out.println(1.0/0); //Infinity
        System.out.println(1/0); //Infinity

    }
}
