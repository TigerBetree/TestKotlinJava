package com.test.java.test;

public class Singleton {
//    private static volatile Singleton instance;
//
//    private Singleton() {
//
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    private static class SingletonHolder {
        private static final Singleton singleton = new Singleton();
    }

    private Singleton(){

    }

    public static Singleton getInstance(){
        return SingletonHolder.singleton;
    }
}
