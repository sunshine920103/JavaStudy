package com.cc.dataStruct.java;

/**
 * @author ：cc
 * @date ：created in 2020/4/2 16:12
 * @description： 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 * @modified By：
 * @version: $version$
 */
public class Array {
    //定义整形数据data保存数据
    public int[] data;
    //记录数组大小
    public int n;
    //记录实际个数
    public int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    //根据索引，找到数据中的元素并返回
    public int find(int index) {
        if (index < 0 || index >= n) {
            return -1;
        }
        return data[index];
    }

    //插入元素
    public String insert(int index, int value) {
        if (count == n) {
            return ("数组已满");
        }
        if (index < 0 || index >= n) {
            return ("数组越界");
        }
        for (int i = count - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        count++;
        return ("插入成功");
    }

    //根据索引，删除数组中元素
    public String delete(int index) {
        if (index < 0 || index >= n) {
            return ("数组越界");
        }
        for (int i = index; i < count; i++) {
            data[i] = data[i + 1];
        }
        count--;
        return ("删除成功");
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        System.out.println(array.insert(0, 3));
        System.out.println(array.insert(0, 4));
        System.out.println(array.insert(1, 5));
        System.out.println(array.insert(3, 9));
        System.out.println(array.delete(3));
        System.out.println(array.insert(3, 11));
        System.out.println(array.insert(5, 12));
        //array.insert(3, 11);
        array.printAll();
    }


}
