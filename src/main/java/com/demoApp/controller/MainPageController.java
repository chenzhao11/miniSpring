package com.demoApp.controller;

import com.minispring.core.anotation.Controller;
import com.minispring.inject.annotation.Autowired;
import com.minispring.mvc.annotation.RequestMapping;
import com.minispring.mvc.type.RequestMethod;
import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Getter
@Controller
@RequestMapping(value = "main")
public class MainPageController {
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public void throwException(){
        throw new RuntimeException("抛出异常测试");
    }
}
