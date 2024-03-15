package com.test.java.datastruct.stackqueue;

import java.util.Stack;

/**
 * 两个栈实现队列
 * <p>
 * 1. 定义两个栈 s1 和 s2；
 * 2. push 方法：将元素压入栈 s1 中；
 * 3. pop 方法：先判断 s2 是否为空，如果不为空，则弹出栈顶元素；如果为空，则将 s1 中的元素全部倒入 s2 中，
 * 再弹出栈顶元素。这样就保证了 s2 的栈顶元素是最先放入队列的元素，也就实现了先进先出。
 */
public class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (!s2.isEmpty()) {
            return s2.pop();
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

