package com.minispring.aop.annotation;

import java.lang.annotation.*;


//作用在类上
@Target(ElementType.TYPE)
//运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    //表示要切的范围
    Class<? extends Annotation> value() default DefaultAspect.class;
    String pointCut() default "";
}
