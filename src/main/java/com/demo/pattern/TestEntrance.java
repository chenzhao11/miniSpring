package com.demo.pattern;

import com.demo.pattern.Singleton.EnumSingleton;
import com.demo.pattern.Singleton.Test;

import java.lang.reflect.InvocationTargetException;

public class TestEntrance {
    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.getInstance();
        System.out.println(Test.A);
    }
}
