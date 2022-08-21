package com.demo.reflec.base.impl;

import com.demo.reflec.base.Car;
import com.minispring.core.anotation.Component;

@Component
public class Benzz implements Car {

    @Override public void run() {
        System.out.println("Benzz is running!!");
    }

    @Override public void alert() {
        System.out.println("Benzz is alertting!!");
    }
}
