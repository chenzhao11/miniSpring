package com.minispring.mvc.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPathInfo {
    // http请求方法
    private String httpMethod;
    //请求路径
    private String httpPath;
}