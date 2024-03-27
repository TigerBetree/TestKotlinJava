package com.test.java.datastruct;

/**
 * 最大子数组和
 */
public class TestMaxSubArraySum {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("1. 最大子数组和为: " + maxSubArray(nums));
        System.out.println("2. 最大子数组和为: " + maxSubArraySum(nums));
        System.out.println("3. 最大子数组和为: " + maxSubArraySum2(nums));
    }

    /**
     * 最大子数组和
     */
    public static int maxSubArray(int[] data) {
        int ans = data[0], pre = 0;
        for (int x : data) {
            pre = Math.max(pre + x, x);
            ans = Math.max(ans, pre);
        }
        return ans;
    }

    public static int maxSubArraySum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int preMaxSum = array[0];
        int maxSum = 0;
        for (int i = 1; i < array.length; i++) {
            preMaxSum = Math.max(array[i], preMaxSum + array[i]);
            maxSum = Math.max(maxSum, preMaxSum);
        }
        return maxSum;
    }

    public static int maxSubArraySum2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum = sum + array[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
