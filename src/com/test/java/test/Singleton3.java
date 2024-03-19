package com.test.java.test;

public class Singleton3 {
//    private static volatile Singleton3 instance;
//
//    private Singleton3() {
//
//    }
//
//    public static Singleton3 getInstance() {
//        if (instance == null) {
//            synchronized (Singleton3.class) {
//                if (instance == null) {
//                    instance = new Singleton3();
//                }
//            }
//        }
//        return instance;
//    }

    private static class SingletonHolder {
        private static final Singleton3 singleton3 = new Singleton3();
    }

    private Singleton3(){

    }

    public static Singleton3 getInstance(){
        return SingletonHolder.singleton3;
    }
}
