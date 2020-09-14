package com.cc.model;

import com.cc.designPattern.MetricProxy;
import com.cc.model.IUserController;

/**
 * @author ：cc
 * @date ：created in 2020/9/14 21:13
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class UserController implements IUserController {
    public MetricInfo login(String username, String password) {
        System.out.println("login success");
        return new MetricInfo(99, 1);
    }

    public void register(String username, String phone) {
        System.out.println("register success");
    }
}


