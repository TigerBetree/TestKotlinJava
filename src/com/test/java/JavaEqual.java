package com.test.java;

import java.util.ArrayList;

public class JavaEqual {

    public static void main(String[] s) {
        String string = "string";
        String newString = new String("string");
        System.out.println(string == newString);
        System.out.println(string.equals(newString));

        ArrayList<Integer> al = new ArrayList<>(10);

        System.out.println(String.valueOf(0));
    }
}
