package com.test.java.datastruct.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出数组中的k数。
 * <p>
 * k数的定义：比位置位于这个数前面的数字都大，且比位置位于这个数后面的数字都小的数字（数组首尾的数字不用管）（面头条遇到的）
 * [4,1,3,2,7,9,8,10,12] 此数组中的k数为7和10
 */
public class FindKNumber {

    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 2, 7, 9, 8, 10, 12};
        List<Integer> resultList = findSpecialNumbers(nums);
        if (!resultList.isEmpty()) {
            System.out.println("数组中满足条件的数是：" + resultList);
        } else {
            System.out.println("数组中不存在满足条件的数");
        }
    }

    // 找出数组中的k数(这个数比自己前面的数都大，比自己后面的数都小)
    public static List<Integer> findSpecialNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int[] maxLeft = new int[n]; // 维护数组中每个位置左边的最大值
        int[] minRight = new int[n]; // 维护数组中每个位置右边的最小值

        // 计算每个位置左边的最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxLeft[i] = max;
            max = Math.max(max, nums[i]);
        }

        // 计算每个位置右边的最小值
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            minRight[i] = min;
            min = Math.min(min, nums[i]);
        }

        // 找出满足条件的数
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > maxLeft[i] && nums[i] < minRight[i]) {
                result.add(nums[i]);
            }
        }

        return result;
    }
}
