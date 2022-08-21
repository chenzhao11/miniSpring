package com.demoApp.aspect;

import com.minispring.aop.annotation.Order;
import com.minispring.aop.aspect.DefaultAspect;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
@Order(10)
public class ControllerInfoAspect implements DefaultAspect {
    @Override
    public void before(Class<?> targetClass, Method method, Object[] args) throws Throwable {
        log.info("controller第二个切面执行了，执行的类是【{}】,方法是【{}】,参数是【{}】",
                targetClass.getName(),method.getName(),args);
    }

    @Override
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) throws Throwable {
        log.info("controller第二个切面顺利完成，执行的类是【{}】,方法是【{}】,参数是【{}】，返回值是【{}】",
                targetClass.getName(),method.getName(),args,returnValue);
       return returnValue;
    }

    @Override
    public void afterThrowing(Class<?> targetClass, Method method, Object[] args, Throwable e) throws Throwable {
        log.info("controller方法执行出错，执行的类是【{}】,方法是【{}】,参数是【{}】，异常是【{}】",
                targetClass.getName(),method.getName(),args,e.getMessage());

    }
}