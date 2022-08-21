package com.demo.pattern.Singleton;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();
    public static  HungrySingleton getInstance(){
        return  singleton;
    }
}
