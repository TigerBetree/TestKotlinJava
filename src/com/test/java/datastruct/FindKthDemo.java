package com.test.java.datastruct;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 0};
        System.out.println(findKthLargest(nums, 2));
        System.out.println(findKthSmallest(nums, 2));
    }

    /**
     * 利用大顶堆，返回数组中第K小的数
     * @param nums
     * @param k
     * @return
     */
    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (q.size() < k) {
                q.add(nums[i]);
            } else {
                if (q.peek() > nums[i]) {
                    q.poll();
                    q.add(nums[i]);
                }
            }
        }
        return q.peek();
    }


    /**
     * 利用小顶堆，返回数组中第K大的数
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int i = 0; i < nums.length; i++) {
            if (q.size() < k) {
                q.offer(nums[i]);
            } else {
                int top = q.peek();
                if (top < nums[i]) {
                    q.poll();
                    q.offer(nums[i]);
                }
            }
        }

        return q.peek();
    }
}
