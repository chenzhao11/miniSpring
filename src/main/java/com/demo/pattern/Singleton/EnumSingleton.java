package com.demo.pattern.Singleton;


public class EnumSingleton {
    public EnumSingleton(){ }
    public  static EnumSingleton getInstance(){
        return Container.INSTANCE.singleton;
    }
    private enum Container{
        INSTANCE;
        private EnumSingleton singleton;
        Container(){
            singleton = new EnumSingleton();
        }
    }
}
