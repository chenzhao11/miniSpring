package com.demoApp.aspect;

import com.minispring.aop.annotation.Order;
import com.minispring.aop.aspect.DefaultAspect;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;


/**
 * 切面类
 */
@Slf4j
//@Aspect(Service.class)
//@Aspect(pointCut = "within(com.fuyouj.controller.superadmin.*)")
@Order(10)
public class ServiceTimeCalculatorAspect implements DefaultAspect {
     private long timeStampCache;
    @Override
    public void before(Class<?> targetClass, Method method, Object[] args) throws Throwable {
        log.info("service开始计时，执行的类是[{}],执行的方法是[{}],参数是[{}]",
                targetClass.getName(),method.getName(),args);
        timeStampCache = System.currentTimeMillis();
    }

    @Override
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) throws Throwable {
        timeStampCache = System.currentTimeMillis() - timeStampCache;
        log.info("service结束计时，执行的类是[{}],执行的方法是[{}],参数是[{}],执行的时间是[{}] ms",
                targetClass.getName(),method.getName(),args,timeStampCache);
        return returnValue;
    }

    @Override
    public void afterThrowing(Class<?> targetClass, Method method, Object[] args, Throwable e) throws Throwable {

    }
}