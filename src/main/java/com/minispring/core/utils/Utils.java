package com.minispring.core.utils;

/**
 * @Author: ZhaoChen
 * @Date: 2022/06/01/14:27
 * @Description:
 */
public class Utils {
    public static boolean isEmpty(String s){
        if( s == null || s.length() == 0 || s.trim().length() == 0) return true;
        return false;
    }
}
