package com.minispring.mvc.type;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 存储请求处理完完毕的处理结果
 */

public class ModelAndView {
    //试图所在位置
    @Getter
    private String view;
    //存贮数据名字 和 对应的值
    @Getter
     private Map<String,Object> model = new HashMap<>();
     public ModelAndView setView(String view){
         this.view = view;
         return this;
     }
     public ModelAndView addViewData(String attributeName,Object attributeValue ){
         model.put(attributeName,attributeValue);
         return this;
     }
}