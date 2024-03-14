package com.test.java;

import com.test.java.datastruct.link.ListNode;

import java.util.HashMap;
import java.util.Stack;

public class Test2 {

    /**
     * 最大子数组和
     *
     * @param data
     * @return
     */
    public static int maxSubArray(int[] data) {
        int len = data.length;
        int maxSum = 0;
        for (int i = 0; i < len; i++) {
            int curSum = 0;
            for (int j = i; j < len; j++) {
                curSum += data[j];
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            }
        }
        return maxSum;
    }

    public static boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

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
        return (c1 == '(' && c2 == ')')
                || (c1 == '{' && c2 == '}')
                || (c1 == '[' && c2 == ']');
    }

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
