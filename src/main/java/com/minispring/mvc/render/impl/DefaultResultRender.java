package com.minispring.mvc.render.impl;

import com.minispring.mvc.process.RequestProcessorChain;
import com.minispring.mvc.render.ResultRender;



public class DefaultResultRender implements ResultRender {
    @Override
    public void render(RequestProcessorChain requestProcessorChain) throws Exception {
        int code = requestProcessorChain.getResponseCode();
        requestProcessorChain.getResponse().setStatus(code);
    }
}