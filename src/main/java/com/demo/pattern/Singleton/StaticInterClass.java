package com.demo.pattern.Singleton;

public class StaticInterClass {
    private static class SingletonInstance{
        private static StaticInterClass singleton = new StaticInterClass();
    }
    public StaticInterClass getInstance(){
        return SingletonInstance.singleton;
    }
}
