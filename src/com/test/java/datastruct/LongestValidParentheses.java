package com.test.java.datastruct;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 最长有效括号
 * <a href="https://github.com/hanggegreat/CS-Tree/blob/master/%E7%AE%97%E6%B3%95/leetcode-TOP100.md#32%E6%9C%80%E9%95%BF%E6%9C%89%E6%95%88%E6%8B%AC%E5%8F%B7">...</a>
 *
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("("));
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses(")()"));
        System.out.println(longestValidParentheses(")()())"));


        System.out.println(longestValidParentheses2("()"));
        System.out.println(longestValidParentheses2(")()"));
        System.out.println(longestValidParentheses2(")()())"));

    }

    public int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    res = Math.max(res, stack.isEmpty() ? i - start + 1 : i - stack.peek());
                }
            }
        }
        return res;
    }

    // 最长有效括号：)()())
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
