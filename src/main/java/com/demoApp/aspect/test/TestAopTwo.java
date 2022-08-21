package com.demoApp.aspect.test;

import com.minispring.aop.annotation.Aspect;
import com.minispring.aop.annotation.Order;
import com.minispring.aop.aspect.DefaultAspect;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Aspect(pointCut = "execution(* com.demoApp.controller..*.*(..))")
@Order(1)
@Slf4j
public class TestAopTwo implements DefaultAspect {
    @Override
    public void before(Class<?> targetClass, Method method, Object[] args) throws Throwable {
       log.info("我是切面逻辑before order1，我增强的目标类是{}，我增强的目标方法是，方法参数{}"
        ,targetClass.getSimpleName(),method.getName(),args);
    }

    @Override
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) throws Throwable {
        Integer res = (Integer) returnValue;
        log.info("我是切面逻辑after order1，我增强的目标类是{}，我增强的目标方法是，方法参数{}"
                ,targetClass.getSimpleName(),method.getName(),args);
        res++;
        return res;
    }

    @Override
    public void afterThrowing(Class<?> targetClass, Method method, Object[] args, Throwable e) throws Throwable {
        log.info("我是切面逻辑after order1的 异常处理，我增强的目标类是{}，我增强的目标方法是，方法参数{}"
                ,targetClass.getSimpleName(),method.getName(),args);
        log.info("异常是{}",e.getMessage());
    }
}