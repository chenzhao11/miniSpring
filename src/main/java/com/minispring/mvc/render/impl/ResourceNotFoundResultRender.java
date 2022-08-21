package com.minispring.mvc.render.impl;


import com.minispring.mvc.process.RequestProcessorChain;
import com.minispring.mvc.render.ResultRender;

import javax.servlet.http.HttpServletResponse;


public class ResourceNotFoundResultRender implements ResultRender {
    private String httpMethod;
    private String httpPath;
    public ResourceNotFoundResultRender(String requestMethod, String requestPath) {
        this.httpMethod = requestMethod;
        this.httpPath = requestPath;
    }

    @Override
    public void render(RequestProcessorChain requestProcessorChain) throws Exception {
        requestProcessorChain.getResponse().sendError(HttpServletResponse.SC_NOT_FOUND
                ,"获取不到对应的资源:请求路径 ["+httpPath +"] 请求方法 ["+httpMethod+"]"
                );
    }
}