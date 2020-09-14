package com.cc.designPattern;

import com.cc.model.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：cc
 * @date ：created in 2020/9/14 21:15
 * @description：动态代理
 * @modified By：
 * @version: $version$
 */
public class MetricProxy {
    private MetricController metricController;

    public MetricProxy() {
        metricController = new MetricController();
    }

    public Object createProxy(Object proxiedObject) {
        Class[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }


    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
            metricController.recordRequest(requestInfo);

            if (result instanceof MetricInfo) {
                metricController.sendCount((MetricInfo) result);
            }
            return result;
        }
    }

    public static <I, T> I createBean(T t) {
        I e = (I) new MetricProxy().createProxy(t);
        return e;
    }


    public static void main(String[] args) {
//        IUserController userController = (IUserController) new MetricProxy().createProxy(new UserController());
        IUserController userController = MetricProxy.createBean(new UserController());
        userController.login("a", "b");
        userController.register("b", "123");


        ICarController carController = MetricProxy.createBean(new CarControlloer());
        carController.drive("a");
        carController.oil("123");
    }
}

class MetricController {
    public void recordRequest(RequestInfo requestInfo) {
        System.out.println("record request");
    }

    public void sendCount(MetricInfo metricInfo) {
        System.out.println("send Count:" + metricInfo.successCount + "," + metricInfo.errorCount);
    }
}

class RequestInfo {
    public RequestInfo(String apiName, Long reponseTime, Long startTimestamp) {

    }
}
