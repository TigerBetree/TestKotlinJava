package com.test.java.datastruct.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9};
        int target = 11;
        List<List<Integer>> pairs = findPairs(nums1, nums2, target);
        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }

        findSum(nums1, nums2, target);

        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {6, 7, 8, 9, 10};
        int M = 10;

        findPairsWithSum(nums3, nums4, M);

        testPairs2();
    }

    public static void findSum(int[] arr1, int[] arr2, int m) {
        int i = 0, j = arr2.length - 1;
        while (i < arr1.length && j >= 0) {
            int sum = arr1[i] + arr2[j];
            if (sum == m) {
                System.out.println("找到了两个数：" + arr1[i] + "和" + arr2[j]);
                i++;
                j--;
            } else if (sum < m) {
                i++;
            } else {
                j--;
            }
        }
    }

    public static List<List<Integer>> findPairs(int[] nums1, int[] nums2, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> numMap = new HashMap<>();

        // 构建一个哈希表来存储nums1中元素及其索引
        for (int i = 0; i < nums1.length; i++) {
            numMap.put(nums1[i], i);
        }

        // 遍历nums2
        for (int j = nums2.length - 1; j >= 0; j--) {
            // 计算当前和
            int complement = target - nums2[j];
            // 如果当前和存在于nums1中
            if (numMap.containsKey(complement)) {
                // 添加到结果中
                List<Integer> pair = new ArrayList<>();
                pair.add(complement);
                pair.add(nums2[j]);
                result.add(pair);
            }
        }
        return result;
    }


    public static void findPairsWithSum(int[] nums1, int[] nums2, int M) {
        int i = 0, j = nums2.length - 1; // 初始化指针，i指向nums1的第一个元素，j指向nums2的最后一个元素

        while (i < nums1.length && j >= 0) {
            int currentSum = nums1[i] + nums2[j];

            // 如果当前和小于M，说明我们需要增大和，所以增加nums1的指针
            if (currentSum < M) {
                i++;
            } else if (currentSum > M) { // 如果当前和大于M，说明我们需要减小和，所以减小nums2的指针
                j--;
            } else { // 如果当前和等于M，我们找到了一个有效的组合
                System.out.println("Pair found: (" + nums1[i] + ", " + nums2[j] + ")");
                i++; // 移动nums1的指针
                j--; // 移动nums2的指针，避免重复使用同一个元素
            }
        }
    }

    public static void testPairs2() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {3, 4, 5, 6, 7};
        int M = 8;
        List<int[]> result = findPairs2(nums1, nums2, M);
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }

    public static List<int[]> findPairs2(int[] nums1, int[] nums2, int M) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = nums2.length - 1;
        while (i < nums1.length && j >= 0) {
            int sum = nums1[i] + nums2[j];
            if (sum == M) {
                result.add(new int[]{nums1[i], nums2[j]});
                i++;
                j--;
            } else if (sum < M) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public List<int[]> findPairs3(int[] nums1, int[] nums2, int target) {
        List<int[]> result = new ArrayList<>();
        int pointer1 = 0;
        int pointer2 = nums2.length - 1;

        while (pointer1 < nums1.length && pointer2 >= 0) {
            int sum = nums1[pointer1] + nums2[pointer2];
            if (sum == target) {
                result.add(new int[]{nums1[pointer1], nums2[pointer2]});
                pointer1++;
                pointer2--;
            } else if (sum < target) {
                pointer1++;
            } else {
                pointer2--;
            }
        }

        return result;
    }
}


