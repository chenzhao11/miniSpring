package com.minispring.mvc.render;



import com.minispring.mvc.process.RequestProcessorChain;

/**
 * 渲染请求结果
 */
public interface ResultRender {
    void render(RequestProcessorChain requestProcessorChain) throws Exception;
}