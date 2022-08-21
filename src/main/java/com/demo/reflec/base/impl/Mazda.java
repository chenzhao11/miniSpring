package com.demo.reflec.base.impl;

import com.demo.reflec.base.Car;

public class Mazda implements Car {
    @Override public void run() {
        System.out.println("Mazda is running!!");
    }

    @Override public void alert() {
        System.out.println("Mazda is alertting!!");
    }
    private String name;
    protected String size;
    String length;
    protected void test(){
        System.out.println("我是protected方法！！");
    }
    void defaultMethod(){
        System.out.println("我是Default方法！！");
    }
    private void privateMethod(){
        System.out.println("我是Private方法！！");
    }

}
