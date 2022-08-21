package com.minispring.mvc.render.impl;

import com.minispring.mvc.process.RequestProcessorChain;
import com.minispring.mvc.render.ResultRender;
import com.google.gson.Gson;

import java.io.PrintWriter;


/**
 * Json请求渲染器
 */
public class JsonResultRender implements ResultRender {
    private Object JsonData;;
    public JsonResultRender(Object res) {
        this.JsonData = res;
    }
    @Override
    public void render(RequestProcessorChain requestProcessorChain) throws Exception {
        //设置响应头
        requestProcessorChain.getResponse().setContentType("application/json");
        requestProcessorChain.getResponse().setCharacterEncoding("UTF-8");
        //响应流写入经过Gson处理后的结果

        try(PrintWriter writer = requestProcessorChain.getResponse().getWriter()) {
            Gson gson = new Gson();
            String json = gson.toJson(JsonData);
            writer.write(json);
            writer.flush();
        }
    }
}