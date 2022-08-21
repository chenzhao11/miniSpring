package com.minispring.mvc.render.impl;

import com.minispring.mvc.process.RequestProcessorChain;
import com.minispring.mvc.render.ResultRender;

import javax.servlet.http.HttpServletResponse;


public class interErrorResultRender implements ResultRender {
    private String errorMsg;
    public interErrorResultRender(String errorMsg){
        this.errorMsg = errorMsg;
    }
    @Override
    public void render(RequestProcessorChain requestProcessorChain) throws Exception {
        requestProcessorChain.getResponse().sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, errorMsg);
    }
}