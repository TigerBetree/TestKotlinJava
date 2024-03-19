package com.test.java.test;

public class Singleton2 {

    private static class MySingletonHolder {
        private static final Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return MySingletonHolder.instance;
    }

    private Singleton2() {

    }
}

