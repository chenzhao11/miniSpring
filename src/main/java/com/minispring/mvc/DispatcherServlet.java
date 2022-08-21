package com.minispring.mvc;

import com.minispring.aop.AspectWeaver;
import com.minispring.core.BeanContainer;
import com.minispring.inject.DependencyInjector;
import com.minispring.mvc.process.RequestProcessor;
import com.minispring.mvc.process.RequestProcessorChain;
import com.minispring.mvc.process.impl.ControllerRequestProcessor;
import com.minispring.mvc.process.impl.JspRequestProcessor;
import com.minispring.mvc.process.impl.PreRequestProcessor;
import com.minispring.mvc.process.impl.StaticResourceRequestProcessor;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * 拦截所有的路由请求， @WebServlet("/")
 * 解析请求
 * 将请求派发给Controller的方法 去处理
 * /* 拦截所有请求
 */

/**
 * 分发器
 */
@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {
    List<RequestProcessor> PROCESSOR = new ArrayList<>();
    @SneakyThrows @Override
    public void init() throws ServletException {
       //初始化常驻内存的应用
        //1.初始化容器和AOP容器
        initIOC(false);;
        //2.初始化请求处理器责任链
        initProcessor();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建责任链对象实例
        RequestProcessorChain requestProcessorChain = new RequestProcessorChain(PROCESSOR.iterator(),req,resp);
        //2.通过责任链模式依次调用请求处理器进行处理
        requestProcessorChain.doRequestProcessorChain();
        //3.对处理结果进行渲染
        requestProcessorChain.doRender();
    }

    private void initProcessor() {
        PROCESSOR.add(new PreRequestProcessor());
        PROCESSOR.add(new StaticResourceRequestProcessor(getServletContext()));
        PROCESSOR.add(new JspRequestProcessor(getServletContext()));;
        PROCESSOR.add(new ControllerRequestProcessor());
    }

    private void initIOC(boolean AOP) throws UnsupportedEncodingException {
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.miniSpring");
        if (AOP){
            new AspectWeaver().doAopByAspectJ();
        }
        new DependencyInjector().doIoc();
    }
}
