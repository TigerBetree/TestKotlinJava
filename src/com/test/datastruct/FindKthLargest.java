package com.test.datastruct;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums1, 2));
        System.out.println(findKthSmallest(nums1, 2));
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));


        int[] nums2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums2, 4));
        System.out.println(findKthSmallest(nums2, 4));
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * 数组中第 k 大的数【使用小顶堆】
     *
     * <p>
     * 1. 先存入 k 个数
     * 2. 从第 k + 1 个数开始，依次跟小顶堆元素比较，如果比堆顶元素大，则加入小顶堆
     * <p>
     * 关键点：堆顶始终保存的是已经遍历的数据中最小的数，当堆中数据大于等于 k 时，则堆顶是第 k 小数
     */
    public static int findKthLargest(int[] nums, int k) {
        // 默认就是小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                priorityQueue.offer(nums[i]);
            } else {
                // 如果发现数据比对顶元素大，则加入到小顶堆中
                int temp = priorityQueue.peek();
                if (temp < nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(nums[i]);
                }
            }
        }

        return priorityQueue.poll();
    }

    /**
     * 数组中第 k 小的数 【使用大顶堆】
     */
    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                priorityQueue.offer(nums[i]);
            } else {
                // 如果发现数据比对顶元素小，则加入到大顶堆中
                int temp = priorityQueue.peek();
                if (temp > nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(nums[i]);
                }
            }
        }

        return priorityQueue.poll();
    }
}
