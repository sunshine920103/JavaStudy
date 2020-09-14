package com.cc.designPattern;

/**
 * @author ：cc
 * @date ：created in 2020/9/13 20:27
 * @description：建造者模式
 * @modified By：
 * @version: $version$
 */
public class BuilderResourcePoolConfig {
    private String name;
    private int maxTotal = 8;
    private int maxIdle = 8;
    private int minIdle = 0;

    private BuilderResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxIdle = builder.maxIdle;
        this.maxTotal = builder.maxTotal;
        this.minIdle = builder.minIdle;

    }


    static class Builder {
        private String name;
        private int maxTotal = 8;
        private int maxIdle = 8;
        private int minIdle = 0;

        public BuilderResourcePoolConfig builder() {
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxIdle should less than maxTotal");
            }

            return new BuilderResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }
    }


    public static void main(String[] args) {
        BuilderResourcePoolConfig builderResourcePoolConfig = new BuilderResourcePoolConfig.Builder()
                .setName("cc")
                .setMaxIdle(10)
                .setMaxTotal(20)
                .setMinIdle(0)
                .builder();

        System.out.println(builderResourcePoolConfig.maxIdle);
    }
}
