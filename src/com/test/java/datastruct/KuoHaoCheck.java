package com.test.java.datastruct;

import java.util.Stack;

public class KuoHaoCheck {
    public static void main(String[] args) {

        String s1 = "()[]{}";
        String s2 = "([)]";
        String s3 = "()";
        String s4 = "(]";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid("))"));
    }

//    public static boolean isValid(String s) {
//        if (s == null
//                || s.equals("")
//                || s.length() % 2 != 0) {
//            return false;
//        }
//
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(' || c == '[' || c == '{') {
//                stack.push(c);
//            } else if (!stack.isEmpty()) {
//                char temp = stack.pop();
//                if (c == ')') {
//                    if (temp != '(') {
//                        return false;
//                    }
//                } else if (c == ']') {
//                    if (temp != '[') {
//                        return false;
//                    }
//                } else {
//                    if (temp != '{') {
//                        return false;
//                    }
//                }
//            } else {
//                stack.push(c);
//            }
//        }
//
//        return stack.isEmpty();
//    }

    // 括号匹配
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.isEmpty()) {
                stack.push(aChar);
            } else if (isSym(stack.peek(), aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }

    private static boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}
