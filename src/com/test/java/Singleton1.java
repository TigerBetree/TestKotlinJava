package com.test.java;

public class Singleton1 {

    private Singleton1(){}

    private static class SingletonHolder {
        private static final Singleton1 instance = new Singleton1();
    }

    public static Singleton1 getInstance(){
        return SingletonHolder.instance;
    }
}
