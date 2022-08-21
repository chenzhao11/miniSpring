package com.demoApp.controller;

import com.minispring.core.anotation.Controller;


@Controller
public class TestAopController {
    public int say(){
        System.out.println("我是controller的本地方法");
        return 1/0;
    }


}