package com.demo.reflec;

import com.demo.reflec.base.Car;
import com.minispring.core.anotation.Component;
import com.minispring.core.anotation.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflecEntrance {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
                   InstantiationException, IllegalAccessException {

        System.out.println(">>>>>>>>>测试获取不同的访问修饰>>>>>>>>>>>>>");
        Class mazda = Class.forName("com.demo.reflec.base.impl.Mazda");
        Method[] methods = mazda.getMethods();
        Method[] declaredMethods = mazda.getDeclaredMethods();
        Field[] fields = mazda.getFields();
        Field[] declaredFields = mazda.getDeclaredFields();
        Constructor constructor = mazda.getConstructor();
        System.out.println("getMethods>>>>>>>>>>>>>>");
        for(Method method : methods){
            System.out.println(method.getName());
        }
        System.out.println("getDeclaredMethods>>>>>>>>>");
        for(Method method : declaredMethods){
            System.out.println(method.getName());
        }
        System.out.println("getFields>>>>>>>>>>>>>>>>>");
        for(Field field : fields){
            System.out.println(field.getName());
        }
        System.out.println("getDeclaredFields>>>>>>>>>>>>");
        for(Field field : declaredFields){
            System.out.println(field.getName());
        }
        Car newCar = (Car)constructor.newInstance();
        System.out.println("使用反射创建的新对象！！" );
        newCar.run();

    }
}
