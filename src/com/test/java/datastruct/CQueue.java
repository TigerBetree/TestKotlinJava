package com.test.java.datastruct;

import java.util.Stack;

/**
 * 两个栈实现队列
 * 一个栈入，一个栈出
 */
class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else if (stack1.isEmpty()) {
            return -1;
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
