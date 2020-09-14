package com.cc.designPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：cc
 * @date ：created in 2020/7/29 21:51
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

}

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null)
                    instance = new LazySingleton();
            }
        }
        return instance;
    }
}

class ClassSingleton {

    private int i = 0;

    private ClassSingleton() {
    }

    private static class ClassSingletonHolder {
        private static final ClassSingleton instance = new ClassSingleton();
    }

    public static ClassSingleton getInstance() {
        return ClassSingletonHolder.instance;
    }

    public void setI() throws InterruptedException {
        synchronized (ClassSingleton.class) {
            i = ++i;
            Thread.sleep(1000);
            System.out.println(i);
        }

    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) throws InterruptedException {
        List<MyThread> arrayList = new ArrayList();

        for (int i = 0; i < 20; i++) {
            MyThread a = new MyThread();
            arrayList.add(a);
        }

        arrayList.forEach(Thread::start);


        Thread.sleep(1000);
        System.out.println(ClassSingleton.getInstance().getI());
    }


}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            ClassSingleton.getInstance().setI();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


//线程唯一的单例
class ThreadSingleton {
    private static final ConcurrentHashMap<Long, ThreadSingleton> instanceMap = new ConcurrentHashMap<Long, ThreadSingleton>();

    private ThreadSingleton() {
    }

    public static ThreadSingleton getInstance() {
        Long threadId = Thread.currentThread().getId();
        instanceMap.putIfAbsent(threadId, new ThreadSingleton());
        return instanceMap.get(threadId);
    }

}

