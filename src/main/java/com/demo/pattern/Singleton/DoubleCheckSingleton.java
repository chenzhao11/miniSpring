package com.demo.pattern.Singleton;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DoubleCheckSingleton {
    private static  volatile DoubleCheckSingleton singleton;
    public static DoubleCheckSingleton getInstance(){
        if(singleton == null){
            synchronized (DoubleCheckSingleton.class){
                if(singleton == null){
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
