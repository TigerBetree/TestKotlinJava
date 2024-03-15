package com.test.java.datastruct.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 * <p>
 * 1. 定义两个队列 q1 和 q2；
 * 2. push 方法：将元素入队到 q1 中；
 * 3. pop 方法：将 q1 中的所有元素逐个出队并存入 q2 中，直到只留下最后一个元素；将该元素出队，
 * 并将 q2 中的所有元素再逐个入队到 q1 中。这样就保证了栈顶元素永远在队列的末尾，也就实现了后进先出。
 */
public class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
        top = x;
    }

    public int pop() {
        while (q1.size() > 1) {
            top = q1.poll();
            q2.offer(top);
        }
        int res = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

