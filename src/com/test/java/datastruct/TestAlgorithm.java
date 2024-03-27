package com.test.java.datastruct;

import com.test.java.datastruct.link.ListNode;

import java.util.HashMap;
import java.util.Stack;

public class TestAlgorithm {

    public static void main(String[] args) {
        testGenKuoHao("", 0, 0, 3);
    }

    /**
     * 括号生成（全排列）
     *
     * @param s
     * @param left
     * @param right
     * @param n
     */
    private static void testGenKuoHao(String s, int left, int right, int n) {
        if (left == n && right == n) {
            System.out.println(s);
            return;
        }

        if (left < n) {
            testGenKuoHao(s + "(", left + 1, right, n);
        }

        if (right < left) {
            testGenKuoHao(s + ")", left, right + 1, n);
        }
    }

    /**
     * 两数之和等于给定值
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * 括号匹配
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                if (isMatch(stack.peek(), c)) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isMatch(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
    }

    /**
     * 链表反转
     */
    public ListNode reverseLink(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode reverseHead = null;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;

            cur.next = reverseHead;
            reverseHead = cur;

            cur = temp;
        }
        return reverseHead;
    }
}
