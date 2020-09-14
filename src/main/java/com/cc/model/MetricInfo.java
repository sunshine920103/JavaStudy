package com.cc.model;

/**
 * @author ：cc
 * @date ：created in 2020/9/14 22:27
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class MetricInfo {
    public int successCount;
    public int errorCount;

    public MetricInfo(int successCount, int errorCount) {
        this.successCount = successCount;
        this.errorCount = errorCount;
    }
}
