package com.test.kotlin.singleton;

public class Singleton1 {
    private static class Holder {
        private static Singleton1 singleton1 = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return Holder.singleton1;
    }

    private void doSomething() {
        System.out.println("java.doSomething.");
    }

    public static void main(String[] args) {
        Singleton1.getInstance().doSomething();
        Singleton.Companion.get().doSomthing();
    }
}


