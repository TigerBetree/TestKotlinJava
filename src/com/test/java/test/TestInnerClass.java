package com.test.java.test;

public class TestInnerClass {

    public static void main(String[] args) {

        Outer outer = new Outer();

        outer.printName();
    }
}


class Outer {

    private String outerName = "outer";

    public class Inner {
        private String innerName = "inner";

        public void printName() {
            System.out.println(this.innerName);
            System.out.println("outer.name : " + outerName);
        }
    }

    public void printName() {
        System.out.println(this.outerName);

        Inner inner = new Inner();
        inner.printName();
    }
}