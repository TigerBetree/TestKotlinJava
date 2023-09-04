package com.test.java.datastruct;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * <p>
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class EvalRPN {

    public static void main(String[] args) {
        String[] s1 = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(s1));

        String[] s2 = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(s2));

        String[] s3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(s3));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left + right);
            } else if (s.equals("-")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left - right);
            } else if (s.equals("*")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left * right);
            } else if (s.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

}
