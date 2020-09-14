package com.cc.model;

/**
 * @author ：cc
 * @date ：created in 2020/9/14 21:47
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface IUserController {
    public MetricInfo login(String username, String password);

    public void register(String username, String phone);
}
